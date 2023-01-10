/**
 * 0. Project	: 스마트HACCP MES
 * 1. 작성자  	: 스마트HACCP_NEW
 * 2. 작성일	: 2020.01.01
 * 3. Comment 	: 발주등록
 * 4. 변경이력 : 
 *  			이름		|일자          		|변경내용
 *              ------------------------------------------------------
 *				
 */
var fnObj = {};
var MODAL_NAME = "QC100M";

var ACTIONS = ppmboot.actionExtend(fnObj, {
    PAGE_SEARCH: function (caller, act, data) {
    	ppmboot.ajax({
            type: "GET",
            url:  ["qcManage", "group"],
            data: $.extend({}, getSerializeArrayToJson("#searchView0")),
            callback: function (res) {   
                caller.gridView01.setData(res);
                caller.gridView02.setData([]);
            }
        });
        return false;
    },    
    //엑셀 다운로드
    EXCEL_DOWNLOAD: function (caller, act, data) {
    	caller.gridView01.target.exportExcel("QC100_"+getNowDt()+".xls");
    },
    //신규 작성
    ADD_FORM: function (caller, act, data) {
    	axDialog.confirm({
            msg: "[신규등록] 하시겠습니까?"
        }, function () {
            if (this.key == "ok") {
            	ppmboot.modal.open({  
                    modalType: MODAL_NAME,
                    param: "",
                    sendData: function(){
                        return {
                        	"mode" : "add"
                        };
                    },
                    callback: function (data) {
                        ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
                    }
                });
            	
            }
        });
    },
    //수정
    MOD_FORM: function (caller, act, data) {
        var list = caller.gridView01.getData("selected");
        if(list.length!=1){
        	axDialog.alert({
                theme: "primary",
                msg: "대상을 선택하세요."
            });
        	return false;
        }else{
    		
        	axDialog.confirm({
                msg: "[수정] 하시겠습니까?"
            }, function () {
                if (this.key == "ok") {

                	ppmboot.modal.open({  
                        modalType: MODAL_NAME,
                        param: "",
                        sendData: function(){
                            return {
                            	"mode" : "mod",
                            	"company" : list[0].company,
                            	"qcGroupCd" : list[0].qcGroupCd
                            };
                        },
                        callback: function (data) {
                            ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
                        }
                    });  
                	
                }
        	});
        }
    },
    //복사
    COPY_FORM: function (caller, act, data) {
    	var list = caller.gridView01.getData("selected");
        if(list.length!=1){
        	axDialog.alert({
                theme: "primary",
                msg: "대상을 선택하세요."
            });
        	return false;
        }else{
    		
        	axDialog.confirm({
                msg: "[복사등록] 하시겠습니까?"
            }, function () {
                if (this.key == "ok") {

                	ppmboot.modal.open({  
                        modalType: MODAL_NAME,
                        param: "",
                        sendData: function(){
                            return {
                            	"mode" : "copy",
                            	"company" : list[0].company,
                            	"qcGroupCd" : list[0].qcGroupCd
                            };
                        },
                        callback: function (data) {
                            ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
                        }
                    });  
                	
                }
        	});
        }
    },    
    //조회
    VIEW_FORM: function (caller, act, data) {
	    var list = caller.gridView01.getData("selected");
    	ppmboot.modal.open({  
            modalType: MODAL_NAME,
            param: "",
            sendData: function(){
                return {
                	"mode" : "view",
                	"company" : list[0].company,
                	"qcGroupCd" : list[0].qcGroupCd
                };
            },
            callback: function (data) {
                ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
            }
        });    	
    },
    //조회 테이블 선택
    ITEM_CLICK: function (caller, act, data) {
    	ppmboot
	   	 .call({
	   	     	type: "GET",
	            url:  ["qcManage", "groupItem"],
	            data: {company:data.company,qcGroupCd:data.qcGroupCd},
	   	         callback: function (res) {
	   	        	
	   	            caller.gridView02.setData(res);
	   	         }
	   	 	})        
	       .done(function () {
	       });  
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
    _this.searchView.initView();
    _this.gridView01.initView();
    _this.gridView02.initView();
    ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
};

fnObj.pageResize = function () {

};

fnObj.pageButtonView = ppmboot.viewExtend({
    initView: function () {
        ppmboot.buttonClick(this, "data-page-btn", {
        	"search": function () {
                ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
            },
            "fn1": function () {
                ACTIONS.dispatch(ACTIONS.ADD_FORM);
            },
            "fn2": function () {
                ACTIONS.dispatch(ACTIONS.MOD_FORM);
            },
            "fn3": function () {
                ACTIONS.dispatch(ACTIONS.COPY_FORM);
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

        this.target.find('[data-ax5picker="date"]').ax5picker({
            direction: "auto",
            content: {
                type: 'date'
            }
        });
    }
});

/**
 * gridView01
 */
fnObj.gridView01 = ppmboot.viewExtend(ppmboot.gridView, {

    initView: function () {
        var _this = this;
        this.target = ppmboot.gridBuilder({
            showLineNumber: true,
            sortable: true, 
            multiSort: false,
            showRowSelector: true,
            multipleSelect: false,
            lineNumberColumnWidth: 40,
            rowSelectorColumnWidth: 26,
            frozenColumnIndex: 0,
            target: $('[data-ax5grid="grid-view-01"]'),
            columns: [     				
                {key: "qcGroupCd",label: "검사그룹코드",width:100,align:"center"},
                {key: "qcGroupNm",label: "검사그룹명",width:200,align:"left"},
				{key: "qcType"},   
                {key: "remark"},  
                {key: "useYn"},        
            ],
            body: {
                onClick: function () {
                    this.self.select(this.dindex);
                    ACTIONS.dispatch(ACTIONS.ITEM_CLICK, this.item);
                }
            }
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
                return this.qcGroupCd;
            });
        } else {
            list = _list;
        }
        return list;
    },
    align: function () {
        this.target.align();
    },
});


/**
 * gridView02	검사관리항목
 */
fnObj.gridView02 = ppmboot.viewExtend(ppmboot.gridView, {	
    initView: function () {
        var _this = this;
        this.target = ppmboot.gridBuilder({
            showLineNumber: true,  
            multipleSelect: false,
            sortable: true, 
            multiSort: false,
            showRowSelector:false, 
            lineNumberColumnWidth: 40,
            rowSelectorColumnWidth: 26,
            frozenColumnIndex: 0,
            target: $('[data-ax5grid="grid-view-02"]'),
            columns: [  
                {key: "qcCd"},
                {key: "qcNm",width:150},    
				{key: "qcUnit"},				
                {key: "remark", label: "비고", width: 200, align: "left"},
                {key: "qcEquipYn", label: "검사장비", width: 80, align: "center"},      
                {key: "useYn"},        
            ],
            body: { 
                onClick: function () {
                    this.self.select(this.dindex);
                }
            }
        });
    },
    getData: function (_type) {
        var list = [];
        var _list = this.target.getList(_type);

        if (_type == "modified" || _type == "deleted") {
            list = ax5.util.filter(_list, function () {
                return this.qcCd;
            });
        } else {
            list = _list;
        }
        return list;
    },
});
