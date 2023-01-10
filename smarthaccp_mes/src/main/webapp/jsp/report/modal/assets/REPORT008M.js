
/**
 * 0. Project	: 
 * 1. 작성자  	: 
 * 2. 작성일		: 
 * 3. Comment 	: 입/출고 및 재고 점검표
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
	
	ITEM_YES: function (caller, act, data) {
//    	const dData = [].concat(caller.gridView02.getData());
//        var i=0;
//        dData.forEach(function(n){
//        	caller.gridView02.target.setValue(i,"checkResult", "Y");
//        	i++;
//        });
    }, 
    ITEM_NO: function (caller, act, data) {
//    	const dData = [].concat(caller.gridView02.getData());
//        var i=0;
//        dData.forEach(function(n){
//        	caller.gridView02.target.setValue(i,"checkResult", "N");
//        	i++;
//        });
    }, 
	
	PRINT_POPUP: function(caller, act,data){
    	if(caller.formView01.getData() != undefined){
    		let reportDate = caller.formView01.getData().reportDate;
    		window.open("../print/REPORT008_P.jsp?reportDate="+reportDate+"&mSeq=" + mseq);
    	}else{
    		axDialog.alert({
    			theme: "primary",
    			  msg: "목록에서 출력할 대상을 선택하세요."
    		});
    	}
    },
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
            url: ["dailyreport", "master"],
            data: {company:param.company, templateId:param.templateId, startDate:param.startDate, reportDate:param.reportDate, mSeq:param.mseq},
            callback: function (res) {
            	caller.formView01.setData(res);
            }
        })
        .call({
            type: "GET",
            url: ["dailyreport", "detail"],
            data: {company:param.company, templateId:param.templateId, startDate:param.startDate, reportDate:param.reportDate, mSeq:param.mseq},
            callback: function (res) {
            	caller.gridView02.setData(res);
            }
        })
    	.done(function () {
    		$("#chk").remove();
    		$("#date_check").remove();
    		$("input[data-ax-path='reportDate']").attr("readonly","readonly");
    		$("input[data-ax-path='reportDate']").unbind();
    		$("input[data-ax-path='reportDate']").closest("div").find("span").unbind();
    		inFlag = true;
        	setAuthBtn();
        });
        return false;
    },
    PAGE_ADD: function (caller, act, data) {
    	ppmboot
    	.call({
            type: "GET",
            url: ["dailyreport", "recentlyTemplate"],
            data: {company:param.company, templateId:param.templateId},
            callback: function (res) {
//            	caller.formView01.setData(res);
            	fnObj.formView01.model.set("startDate",res.map.recentlyTemplate.startDate);
            }
        })
    	.done(function () {
        	setAuthBtn();
        });
    	fnObj.formView01.model.set("writer",SCRIPT_SESSION.userNm);
        return false;
    },
    PAGE_SAVE: function (caller, act, data) {
    	if (caller.formView01.validate()) {
            var mData = caller.formView01.getData();
            var dData = caller.gridView02.getData();
            mData.templateId = param.templateId;
            $(dData).each(function(index,object){
            	object.company = mData.company;
            	object.templateId = mData.templateId;
            	object.startDate = mData.startDate;
            	object.reportDate = mData.reportDate;
            });
            if(!inFlag){
            	axDialog.alert({
        			theme: "primary",
        			msg: "중복체크를 해주십시오."
        		});
        		return false;
            }
        	axDialog.confirm({
        		theme: "primary",
        		msg: "저장하시겠습니까?"
        	}, function(){
        		if(this.key =="ok"){
        			//let sData = caller.gridView02.getData();
        			let lineCnt = 0;
        			let nLineNumber = [];
        			let MAX;
    	            mData.status = "10";
    	            
    	            mData.writer = SCRIPT_SESSION.userNm; //작성자에 userNm 넣기 
    	            
    	            MAX = nLineNumber.length;
    	            if(nLineNumber.length > 0){
    	            	for(var i = 0 ; i < MAX; i++){
    	            		nLineNumber.reverse();
    	            		let currentLine =nLineNumber.pop(); 
    	            		/*
    	            		if(sData[currentLine-1].remark == undefined || sData[currentLine-1].remark == ''){
    	            			axDialog.alert({
    	    	        			theme: "primary",
    	    	        			msg: currentLine + "행에 비고란을 작성해주세요."
    	    	        		});
    	    	            	return false;
    	            		}
    	            		*/
    	            	}
    	            }
    	            ppmboot
    	                .call({
    	                    type: "PUT", url: ["dailyreport", "saveMaster"], data: JSON.stringify([mData]),
    	                    callback: function (res) {                    	
    	                    }
    	                })
    	                .call({
    	                    type: "PUT", url: ["dailyreport", "saveDetail"], data: JSON.stringify(dData),
    	                    callback: function (res) {
    	                    	
    	                    }
    	                })
    	                .done(function () {
    	                    axToast.push("저장 되었습니다.");
    	                    parent.ppmboot.modal.callback("");
    	                    param.reportDate = mData.reportDate.replace(/-/gi,"");
    	                    ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
    	                });
        		}else{
        			return false;
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
        		var mData = [].concat(caller.formView01.getData());
       	        ppmboot.ajax({
       	        	type: "PUT", 
       	            url:  ["dailyreport","deleteMaster"],
       	        	data: JSON.stringify(mData),
       	            callback: function (res) {     	
	   	            	var dData = [].concat(caller.gridView02.getData());
	   	    	        ppmboot.ajax({
	   	    	        	type: "PUT", 
	   	    	            url:  ["dailyreport","deleteDetail"],
	   	    	        	data: JSON.stringify(dData),
	   	    	            callback: function (res) {     	
	   	    	            	parent.ppmboot.modal.callback("");	      
	   		                    ACTIONS.dispatch(ACTIONS.PAGE_CLOSE); 
	   	    	            }
	   	    	        });
	                    
       	            	
       	            }
       	        });   
            }
        }); 	 
   	},
   	
   	DUB_CHECK : function(caller, act, data){
   		var pReportDate = $('input[data-ax-path="reportDate"]').val();
   		if(nvl(pReportDate, '') ==''){
   			axDialog.alert({
                theme: "warning",
                msg: "점검일자를 입력하세요."
            });
   		}else{
   			ppmboot
   			.call({
   				type	:	"GET",
   				url		:	["dailyreport", "duplicateReportDt"],
   				data	:	{company:param.company, templateId:param.templateId, reportDate:pReportDate},
   				callback:	function(res){
   					if(res.map.isDup){
   						axDialog.alert({
   							theme	: 	"primary",
   							msg		:	"이미 생성된 검사 입니다."
   						});
   						//inFlag = false;
   						//$("input:checkbox[id='date_check']").prop("checked", false);
   					}else{
   						axDialog.alert({
		   	                 theme	: "primary",
		   	                 msg	: "입력 가능한 점검일입니다."
		   	             });
	   	            	inFlag = true;
	   	            	$("input:checkbox[id='date_check']").prop("checked", true); 
   					}
   				}
   			})
   			.done(function(){
   				//필요시 기능 추가
   			});
   		}
   	},
   	ITEM_SUB_ADD: function (caller, act, data) {
    	caller.gridView02.addRow();
    },
    ITEM_SUB_DEL: function (caller, act, data) {
    	var list = [];
    	list = caller.gridView02.getData("selected");
    	if(list.length == 0){
    		axDialog.alert({
                theme: "primary",
                msg: "대상을 선택하세요."
            });
    		return false;	
    	}
        caller.gridView02.delRow("selected");

        if(param.mode == "mod" && list[0].templateId != undefined){
        	ppmboot.ajax({
	        	type: "PUT", 
	            url:  ["dailyreport","deleteDetail"],
	        	data: JSON.stringify(list),
	            callback: function (res) {     	 
	            }
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
    _this.gridView02.initView();
//    _this.gridView02.initView();
    param = parent.ppmboot.modal.getData(); 
    switch(param.mode){
	    case "add" : 
	    	ACTIONS.dispatch(ACTIONS.PAGE_ADD);
	    	break;
	    case "mod" :
	    	inFlag = true;
	    	$(":input[data-ax-path='reportDate']").attr("readonly", "readonly");
	    default : 
	    	ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
    }
    /*if(param.mode == "add"){      
        ACTIONS.dispatch(ACTIONS.PAGE_ADD);
    }else{
    	ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
    }*/
    
    tempFileCd = randomStringCd(20);
    
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
            },
            "form-print": function(){
            	ACTIONS.dispatch(ACTIONS.PRINT_POPUP);
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

function fn_reportDateChg(obj){
	if(obj.value != undefined && param.mode == "add"){
		inFlag = false;
		$("input:checkbox[id='date_check']").prop("checked", false); 
	}else{
		fnObj.formView01.setDefaultDate();
		return false;
	}
}
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
            },
//            onStateChanged: function(){
//        		if(this.value != undefined){
//	        		inFlag = false;
//	        		$("input:checkbox[id='date_check']").prop("checked", false); 
//        		}
//            }
        });
        ppmboot.buttonClick(this, "data-form-view-01-btn", {
            "check-date": function () {
            	ACTIONS.dispatch(ACTIONS.DUB_CHECK)
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
        
        if(nvl(data["map"]["master"].reportDate,'') != ''){
        	$("#reportDate").attr("readonly","readonly");
        }else{
        	$("#reportDate").removeAttr("readonly");        	
        }
        if(data["map"]["master"].status == 10){
        	data["map"]["master"].status = "저장";
        }else if(data["map"]["master"].status == 20){
        	data["map"]["master"].status = "상신";
        }else if(data["map"]["master"].status == 40){
        	data["map"]["master"].status = "승인";
        }else if(data["map"]["master"].status == 50){
        	data["map"]["master"].status = "반려";
        }
        searchFile(nvl(data["map"]["master"].reportDate,tempFileCd));

        this.model.setModel(data["map"]["master"]);
        this.modelFormatter.formatting(); // 입력된 값을 포메팅 된 값으로 변경
    },
    setDefaultDate:function(){
        this.model.set("reportDate", ax5.util.date(param.reportDate, {'return': 'yyyy-MM-dd', 'add': {d: 0}}));
        
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
    
    
});

function setAuthBtn(){
	var mData = fnObj.formView01.getData();
	mode = param.mode;

	if(mode !='view'){
        $("#save").show();
		if(nvl(mData.reportDate,'') == ''){
	        $("#delete").hide();
		}else{
	        $("#delete").show();
		}
	}else{
		$("#printDetail").show();
        $("#save").hide();
        $("#delete").hide();
    	$("#modal-content").find("input,select,button,textarea, file, radio").prop('disabled', true);
	}
}


/**
 * gridView02
 */
fnObj.gridView02 = ppmboot.viewExtend(ppmboot.gridView, {
    initView: function () {
        var _this = this;
        this.target = ppmboot.gridBuilder({
        	showLineNumber: true,
            sortable: false, 
            multiSort: false,
            multipleSelect: false,
            showRowSelector: true,
            lineNumberColumnWidth: 40,
            rowSelectorColumnWidth: 26,
            frozenColumnIndex: 0, 
            target: $('[data-ax5grid="grid-view-02"]'),
            columns: [
            	{
                    label: "원재료", columns: [
                    	{label:"입고일", key: "ditem001" ,  width: 100 , editor: {type: "date",config: {content: {config: {mode: "day", selectMode: "day"}}}} , align: "center"},
                        {label:"입고처", key: "ditem002", editor: "text"},    
                        {label:"품명", key: "ditem003", editor: "text"},
                        {label:"입고량", key: "ditem004", editor: {type: "number"}, align: "right"},
                        {label:"출고량", key: "ditem005", editor: {type: "number"}, align: "right"},
                        {label:"재고량", key: "ditem006", editor: {type: "number"}, align: "right"},
                    ]
                },		  
                {
                    label: "부재료", columns: [
                    	{label:"입고일", key: "ditem007" , width: 100 , editor: {type: "date",config: {content: {config: {mode: "day", selectMode: "day"}}}} , align: "center"},
                        {label:"입고처", key: "ditem008", editor: "text"},    
                        {label:"품명", key: "ditem009", editor: "text"},
                        {label:"입고량", key: "ditem010", editor: {type: "number"}, align: "right"},
                        {label:"출고량", key: "ditem011", editor: {type: "number"}, align: "right"},
                        {label:"재고량", key: "ditem012", editor: {type: "number"}, align: "right"},
                    ]
                },
                {
                    label: "포장재", columns: [
                    	{label:"입고일", key: "ditem013" , width: 100 , editor: {type: "date",config: {content: {config: {mode: "day", selectMode: "day"}}}} , align: "center"},
                        {label:"입고처", key: "ditem014", editor: "text"},    
                        {label:"품명", key: "ditem015", editor: "text"},
                        {label:"입고량", key: "ditem016", editor: {type: "number"}, align: "right"},
                        {label:"출고량", key: "ditem017", editor: {type: "number"}, align: "right"},
                        {label:"재고량", key: "ditem018", editor: {type: "number"}, align: "right"},
                    ]
                },
            ],
            body: {
            	onClick: function () {  
                    this.self.select(this.dindex);
                	if(this.column.key == "itemBtn") {
                    	ACTIONS.dispatch(ACTIONS.ITEM_MODAL_OPEN, this);
                    }
		        },
		        onDataChanged: function () {  	
		        	calcItemDetail(this);
		        }
            }
        });
        
        ppmboot.buttonClick(this, "data-grid-view-02-btn", {
        	 "item-add": function () {
                 ACTIONS.dispatch(ACTIONS.ITEM_SUB_ADD);
             },
             "item-remove": function () {
                 ACTIONS.dispatch(ACTIONS.ITEM_SUB_DEL);
             },
        });
    },
    setData: function (_data) {
        this.target.setData(_data);
    },
    getData: function (_type) {
        var list = [];
        var _list = this.target.getList(_type);

        if (_type == "modified" || _type == "deleted") {
            list = ax5.util.filter(_list, function () {
                return nvl(this.slipSeq,randomStringCd(20));
            });
        } else {
            list = _list;
        }
        return list;
    },
    align: function () {
        this.target.align();
    },
    addParentRow: function (data) {
    	addParentRow(this.target,data);
    },
});
