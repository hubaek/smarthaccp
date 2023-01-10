
/**
 * 0. Project	: 
 * 1. 작성자  	: 
 * 2. 작성일		: 
 * 3. Comment 	: 한계기준정보
 * 4. 변경이력 : 
 *  			이름		|일자          		|변경내용
 *              ------------------------------------------------------
 *				
 */
 
var fnObj = {};
var param;
var tempFileCd;
var inFlag;
var mode; 
var ACTIONS = ppmboot.actionExtend(fnObj, {	
	PAGE_CLOSE: function (caller, act, data) { 
        if (parent) {
        	if (typeof param.callBack === "undefined"){
        		parent.ppmboot.modal.close();
        	}else{
        		parent.customModal.close();
        	}
        }
    },
    PAGE_SEARCH: function (caller, act, data) {		
    	ppmboot
    	.call({
            type: "GET",
            url: ["limit"],
            data: {company:param.company, prcsslmtId:param.prcsslmtId},
            callback: function (res) {
            	caller.formView01.setData(res.list[0]);
            }
        })
    	.done(function () {
        	setAuthBtn();
        });
        return false;
    },    
    PAGE_SAVE: function (caller, act, data) {
   	 if (caller.formView01.validate()) {
	   		if(mode == "add"){
	   			if(!inFlag){
	   				axDialog.alert({
	   	                theme: "primary",
	   	                msg: "중복체크를 해주세요."
	   	            });
	   	    		return false;
				}
	 		}
	   		
			var mData = caller.formView01.getData();    		 
			mData.tempFileCd = tempFileCd;
			
			if($('#emailYn').is(':checked')){
				mData.emailYn = "Y";
			}
			
			console.log(mData);
            ppmboot.ajax({
                type: "PUT",
                url: ["limit"],
	        	data: JSON.stringify(mData),
                callback: function (res) {
                	param.mode = "mod";	  
                	param.company = res.company;
	            	param.prcsslmtId = res.prcsslmtId;
	                axToast.push("저장 되었습니다.");
	                parent.ppmboot.modal.callback("");	      
                    ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
                }
            });
        }
    },
    PAGE_DELETE: function (caller, act, data) {    	
		axDialog.confirm({
            theme: "danger",
            msg: "삭제하시겠습니까?"
        }, function () {
            if (this.key == "ok") {
        		var mData = caller.formView01.getData();	
       	        ppmboot.ajax({
       	        	type: "DELETE", 
       	            url:  ["limit"],
       	        	data: JSON.stringify(mData),
       	            callback: function (res) {     	
       	            	parent.ppmboot.modal.callback("");	      
	                    ACTIONS.dispatch(ACTIONS.PAGE_CLOSE); 
       	            }
       	        });	  
            }
        }); 	 
   	},
   	
   	CHECK_ID : function(caller, act, data){
   		var prcsslmtId = $("#prcsslmtId").val();
   		/*var plcIp = $("#plcIp").val();
   		if(nvl(plcIp,'') == ''){
   			axDialog.alert({
                theme: "warning",
                msg: "PLC_IP를 입력하세요."
            });
   		}*/
   		if(nvl(prcsslmtId, '') ==''){
   			axDialog.alert({
                theme: "warning",
                msg: "한계기준ID를 입력하세요."
            });
   		}else{
   			ppmboot
   			.call({
   				type	:	"GET",
   				url		:	["limit"],
   				data	:	{prcsslmtId : prcsslmtId},
   				callback:	function(res){
   					if(res.list.length > 0){
   						axDialog.alert({
	   							theme	: 	"danger",
	   							msg		:	"이미 등록된 한계기준ID 입니다."
	   						});   						
   						inFlag = false;
   						$("input:checkbox[id='chk']").prop("checked", false);
   					}else{
   						axDialog.alert({
		   	                 theme	: "primary",
		   	                 msg	: "등록가능한 한계기준ID 입니다."
		   	             });
	   	            	inFlag = true;
	   	            	$("input:checkbox[id='chk']").prop("checked", true); 
   					}
   				}
   			})
   			.done(function(){
   				//필요시 기능 추가
   			});
   		}
   	},
    dispatch: function (caller, act, data) {
        var result = ACTIONS.exec(caller, act, data);
        if (result != "error") {
            return result;
        } else {
            return false;
        }
    }
});

fnObj.pageStart = function () {
    var _this = this;
    _this.pageButtonView.initView();
    _this.formView01.initView();
    
    param = parent.ppmboot.modal.getData();   
    if(param.mode == "add"){      
        setAuthBtn();
    }else{
    	ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
    }
    
    tempFileCd = randomStringCd(20);
    
    //시스템 관리자 전용
    if(SCRIPT_SESSION.userCd != 'system'){
    	$("#syschk").hide();
    }
};

fnObj.pageResize = function () {
	
};

fnObj.pageButtonView = ppmboot.viewExtend({
    initView: function () {
        ppmboot.buttonClick(this, "data-page-btn", {
        	"save": function () {
                ACTIONS.dispatch(ACTIONS.PAGE_SAVE);
            },
            "delete": function () {
                ACTIONS.dispatch(ACTIONS.PAGE_DELETE);
            },
            "close": function () {
                ACTIONS.dispatch(ACTIONS.PAGE_CLOSE);
            }
        });
    }
});

/**
 * searchView
 */
fnObj.searchView = ppmboot.viewExtend(ppmboot.searchView, {
    initView: function () {
        this.target = $(document["searchView0"]);
        this.target.attr("onsubmit", "return ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);");
    }
});

/**
 * formView01
 */
fnObj.formView01 = ppmboot.viewExtend(ppmboot.formView, {
    getDefaultData: function () {
        return $.extend({}, ppmboot.formView.defaultData, {});
    },
    initView: function () {
        this.target = $("#formView01");
        this.model = new ax5.ui.binder();
        this.model.setModel(this.getDefaultData(), this.target);
        this.modelFormatter = new ppmboot.modelFormatter(this.model); // 모델 포메터 시작
        this.target.find('[data-ax5picker="date"]').ax5picker({
            direction: "auto",
            content: {
                type: 'date'
            }
        });
        ppmboot.buttonClick(this, "data-form-view-01-btn", {
            "checkId": function () {
            	ACTIONS.dispatch(ACTIONS.CHECK_ID)
            }
        });
        this.initEvent();     
    },
    initEvent: function () {
        var _this = this;
    },
    getData: function () {
        var data = this.modelFormatter.getClearData(this.model.get()); // 모델의 값을 포멧팅 전 값으로 치환.
        return $.extend({}, data);
    },
    setData: function (data) {
        if (typeof data === "undefined") data = this.getDefaultData();
        data = $.extend({}, data);      
        
        if(nvl(data.emailYn,'N') == "Y"){
        	$('#emailYn').prop('checked',true);
        }
        
        if(nvl(data.prcsslmtId,'') != ''){
        	$("#prcsslmtId").attr("readonly","readonly");
        }else{
        	$("#prcsslmtId").removeAttr("readonly");        	
        }
        
        searchFile(nvl(data.prcsslmtId,tempFileCd));
        
        this.model.setModel(data);
        this.modelFormatter.formatting(); // 입력된 값을 포메팅 된 값으로 변경
    },
    validate: function () {
        var rs = this.model.validate();
        if (rs.error) {
            alert(LANG("ax.script.form.validate", rs.error[0].jquery.attr("title")));
            rs.error[0].jquery.focus();
            return false; 
        }
        return true;
    },
    clear: function () {
        this.model.setModel(this.getDefaultData());
    },
    
    setDefaultRout:function(data){
        this.model.set("routCd", data.routCd);
        this.model.set("routNm", data.routNm);
        $("#hiddenRoutCd").val(data.routCd);
    },
});

function setAuthBtn(){
	var mData = fnObj.formView01.getData();
	mode = param.mode;

	if(mode !='view'){
        $("#save").show();
		if(nvl(mData.prcsslmtId,'') == ''){
	        $("#delete").hide();
		}else{
	        $("#delete").show();
		}
	}else{
        $("#save").hide();
        $("#delete").hide();
    	$("#modal-content").find("input,select,button,textarea, file, radio").prop('disabled', true);
	}
}

$('#emailYn').click(function(){
	if($('#emailYn').is(':checked')){
		$("#mst").attr("disabled", false);
	}else{
		$("#mst").attr("disabled", true);
	}
});