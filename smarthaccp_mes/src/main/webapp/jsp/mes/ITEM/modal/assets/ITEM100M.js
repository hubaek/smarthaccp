/**
 * 0. Project	: 팔피엠 MES
 * 1. 작성자  	: 팔피엠_NEW
 * 2. 작성일	: 2020.01.01
 * 3. Comment 	: 품목정보등록
 * 4. 변경이력 : 
 *  			이름		|일자          		|변경내용
 *              ------------------------------------------------------
 *				
 */
var fnObj = {};
var param;
var tempFileCd;
var checkFlag = false;

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
            url: ["item"],
            data: {company:param.comapny, itemCd:param.itemCd},
            callback: function (res) {
            	caller.formView01.setData(res.list[0]);            	
            	ACTIONS.dispatch(ACTIONS.CHANGE_ITEM_GROUP,res.list[0].itemSubCd);
            }
        })
    	.done(function () {
        	setAuthBtn();
        	checkFlag = true;
        });
        return false;
    },    
    PAGE_SAVE: function (caller, act, data) { 
    	 if (caller.formView01.validate()) {
    		 if(!checkFlag){
    	    	 axDialog.alert({
    	             theme: "warning",
    	             msg: "품목코드 중복검사를 해주세요."
    	         },function(){
    	         	$("#itemCd").focus();
    	         });
    	     }else{
    	    	var mData = caller.formView01.getData();	   

    	    	mData.itemMainCd = $("#itemMainCd").val();
    	    	mData.itemSubCd = $("#itemSubCd").val();
    	    	
				mData.tempFileCd = tempFileCd;	        	
				
				mData.yieldTrans = nvl(mData.yieldTrans,1);
				mData.pdTrans = nvl(mData.pdTrans,1);
				mData.bomTrans = nvl(mData.bomTrans,1);
		        
				ppmboot.ajax({	        	
					type: "PUT", 
					url: ["item"], 
					data: JSON.stringify(mData),
				    callback: function (res) {
				    	param.mode = "mod";	   
				    	param.company = res.comapny;
    	            	param.itemCd = res.itemCd;
    	                axToast.push("저장 되었습니다.");
    	                parent.ppmboot.modal.callback("");	      
    	                
                        ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
				    }
				});
    	     }
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
       	            url:  ["item"],
       	        	data: JSON.stringify(mData),
       	            callback: function (res) {     	
		                parent.ppmboot.modal.callback("");	      
	                    ACTIONS.dispatch(ACTIONS.PAGE_CLOSE); 
       	            }
       	        });	  
            }
        }); 	 
   	},
    CHANGE_ITEM_GROUP: function (caller, act, data) {   
    	var mData = caller.formView01.getData();    
		mData.itemSubCd = data;
		tempItemSubCd = data; //조회 후 저장시 서브품목코드가 NULL로 들어가 임시로 세팅
		
       	$("#itemSubCd option").remove();
    	if(nvl(mData.itemMainCd,'')== ''){
           	$("#itemSubCd").append("<option value=''>선택</option>")
   		}else{
   			ppmboot.ajax({
   		    	type: "GET",
   	           	url:  ["item", "itemSub"],
   	           	data: {company:mData.company,itemMainCd:mData.itemMainCd},
   		        callback: function (res) {
   		        	if(res.list.length > 1){
   		            	$("#itemSubCd").append("<option value=''>선택</option>")
   		        	}		        	
   		        	res.list.forEach(function (n) {
   	                	$("#itemSubCd").append("<option value='"+n.itemSubCd+"'>"+n.itemSubNm+"</option>")
   		        	});	
   		        	
   		        	if(nvl(mData.itemSubCd,'') != ''){
   			        	$("#itemSubCd").val(mData.itemSubCd).attr("selected", "selected");
   		        	}else{
   		    			$("#itemSubCd option:eq(0)").attr("selected","selected");	
   		        	}
   		        }
   		    });
   		}
    	
    },    
   	CHECK_ID: function (caller, act, data) {    	
   		var mData = caller.formView01.getData();	
   		if(nvl(mData.itemCd,'') == ''){
   			axDialog.alert({
                theme: "warning",
                msg: "품목코드를 입력하세요."
            },function(){
            	$("#itemCd").focus();
            });
   		}else{
   			ppmboot
	   	    .call({
	   	        type: "GET",
	   	        url:  ["item"],
	   	        data: {itemCdCheck: mData.itemCd},
	   	        callback: function (res) {        		
	   	           if(res.list.length > 0){
		   	        	axDialog.alert({
		                    theme: "warning",
		                    msg: "이미 등록된 품목코드 입니다."
		                },function(){
		                	$("#itemCd").focus();
		                });
	   	        	   checkFlag = false;
	   	           }else{
	   	        	   	axDialog.alert({
		                    theme: "warning",
		                    msg: "등록할수 있는 품목코드 입니다."
		                },function(){
		                    
		                });
	   	        	   checkFlag = true;
	   	           }
	   	        }
	   	    })
	   	    .done(function () {
	   	    	
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
        ACTIONS.dispatch(ACTIONS.CHANGE_ITEM_GROUP,"");      
        setAuthBtn();
    }else{
    	ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
    }
    
    tempFileCd = randomStringCd(20);
    

    $("#itemCd").change(function() {
    	checkFlag = false;
    });
        
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
        return $.extend({}, ppmboot.formView.defaultData, {bomTrans:1,pdTrans:1,yieldTrans:1});
    },
    initView: function () {
        this.target = $("#formView01");
        this.model = new ax5.ui.binder();
        this.model.setModel(this.getDefaultData(), this.target);
        this.modelFormatter = new ppmboot.modelFormatter(this.model); // 모델 포메터 시작
        
        this.initEvent();
        
        ppmboot.buttonClick(this, "data-form-view-01-btn", {
            "checkId": function () {
            	ACTIONS.dispatch(ACTIONS.CHECK_ID)
            },
        });
    },
    initEvent: function () {
        var _this = this;        
        
        this.model.onChange("itemMainCd", function () {
            ACTIONS.dispatch(ACTIONS.CHANGE_ITEM_GROUP,"");        	
        }); 
        
        this.model.onChange("unit", function () {
        	calcUnit();
        }); 
        
        this.model.onChange("yieldUnit", function () {
        	calcUnit();
        }); 

        this.model.onChange("bomUnit", function () {
        	calcUnit();
        }); 

        this.model.onChange("pdUnit", function () {
        	calcUnit();
        }); 
        
    },
    getData: function () {
        var data = this.modelFormatter.getClearData(this.model.get()); // 모델의 값을 포멧팅 전 값으로 치환.
        return $.extend({}, data);
    },
    setData: function (data) {
        if (typeof data === "undefined") data = this.getDefaultData();
        data = $.extend({}, data);      
        
        if(nvl(data.itemCd,'') != ''){
        	$("#checkId").attr("disabled","disabled");
        	$("#itemCd").attr("readonly","readonly");
        }else{
        	$("#checkId").removeAttr("disabled");
        	$("#itemCd").removeAttr("readonly");
        	checkFlag = false;
        }
        
        searchFile(nvl(data.itemCd,tempFileCd));
        
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
    setDefaultCust:function(data){
        this.model.set("custCd", data.custCd);
        this.model.set("custNm", data.custNm);
    },
    setTrans:function(data){
        this.model.set("yieldTrans", data.yieldTrans);
        this.model.set("pdTrans", data.pdTrans);
        this.model.set("bomTrans", data.bomTrans);
        this.modelFormatter.formatting(); // 입력된 값을 포메팅 된 값으로 변경
        
    },
});

function setAuthBtn(){
	var mData = fnObj.formView01.getData();
	var mode = param.mode;
	if(mode !='view'){
        $("#save").show();
		if(nvl(mData.itemCd,'') == ''){
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


function calcUnit(){  
	
	var n = fnObj.formView01.getData();
	
	n.pdUnit = nvl(n.pdUnit,n.unit);
	n.bomUnit = nvl(n.bomUnit,n.unit);
	n.yieldUnit = nvl(n.yieldUnit,n.unit);

	if((n.unit == 'KG' && n.pdUnit == 'GR') || n.unit == 'MT' && n.pdUnit == 'CM'){
		n.pdTrans = 1000;
	}else if (n.unit == 'MT' && n.pdUnit == 'CM'){
		n.pdTrans = 100;										
	}else{
		if(n.unit == n.pdUnit){
			n.pdTrans = 1;					
		}else{
			n.pdTrans = '';
		}
	}

	if((n.unit == 'KG' && n.bomUnit == 'GR') || n.unit == 'MT' && n.bomUnit == 'CM'){
		n.bomTrans = 1000;
	}else if (n.unit == 'MT' && n.bomUnit == 'CM'){
		n.bomTrans = 100;					
	}else{
		if(n.unit == n.bomUnit){
			n.bomTrans = 1;					
		}else{
			n.bomTrans = '';
		}
	}
	
	if((n.unit == 'KG' && n.yieldUnit == 'GR')){
		n.yieldTrans = 1000;
	}else if (n.unit == 'MT' && n.yieldUnit == 'CM'){
		n.yieldTrans = 100;
	}else{
		if(n.unit == n.yieldUnit){
			n.yieldTrans = 1;					
		}else{
			n.yieldTrans = '';
		}
	}
	
	fnObj.formView01.setTrans(n);
	
}

function chkCharCode(event) {
	  const regExp = /[^0-9a-zA-Z]/g;
	  const ele = event.target;
	  if (regExp.test(ele.value)) {
	    ele.value = ele.value.replace(regExp, '');
	    alert("영문과 숫자만 입력해주세요.");
	  }
};