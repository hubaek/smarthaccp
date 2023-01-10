/**
 * 0. Project	: 스마트HACCP MES
 * 1. 작성자  	: 스마트HACCP_NEW
 * 2. 작성일		: 2020.01.01
 * 3. Comment 	: 공정등록
 * 4. 변경이력 : 
 *  			이름		|일자          		|변경내용
 *              ------------------------------------------------------
 *				
 */
var fnObj = {};
var CODE = {};
var MODAL_NAME = "RT100M";

var ACTIONS = ppmboot.actionExtend(fnObj, {
    PAGE_SEARCH: function (caller, act, data) {
        ppmboot.ajax({
            type: "GET",
            url: ["rout"],
            data: $.extend({}, getSerializeArrayToJson("#searchView0")),
            callback: function (res) {
                caller.gridView01.setData(res);
                caller.gridView02.setData([]);
                caller.gridView03.setData([]);
                caller.gridView04.setData([]);
                caller.gridView05.setData([]);
            }
        });
        return false;
    },
    //신규 작성
    ADD_FORM: function (caller, act, data) {
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
    },    
    //수정
    MOD_FORM: function (caller, act, data) {
    	var list =  caller.gridView01.getData("selected");
    	if(list.length!=1){
        	axDialog.alert({
                theme: "primary",
                msg: "대상을 선택하세요."
            });
        	return false;
        }else{
        	ppmboot.modal.open({  
                modalType: MODAL_NAME,
                param: "",
                sendData: function(){
                    return {
                    	"mode" : "mod",
                    	"company" : list[0].company,
                    	"routCd" : list[0].routCd,
                    };
                },
                callback: function (data) {
                    ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
                }
            });	 
        }
    },    
    //조회
    VIEW_FORM: function (caller, act, data) {
    	var list =  caller.gridView01.getData("selected");
    	ppmboot.modal.open({  
            modalType: MODAL_NAME,
            param: "",
            sendData: function(){
                return {
                	"mode" : "view",
                	"company" : list[0].company,
                	"routCd" : list[0].routCd,
                };
            },
            callback: function (data) {
                ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
            }
        });	 
    },
    ITEM_CLICK: function (caller, act, data) {
		 ppmboot
		 .call({
		     type: "GET",
		     url: ["rout","equip"],
		     data: {routCd:data.routCd},
		     callback: function (res) {
		         caller.gridView02.setData(res);  
		     }    
		 })
		 .call({
			 type: "GET",
			 url:  ["rout", "nwrk"],
			 data: {routCd:data.routCd},
			 callback: function (res) {
			     caller.gridView03.setData(res);  
	         }    
         })
		.call({
		    type: "GET",
		    url:  ["rout", "bad"],
		    data: {routCd:data.routCd},
		    callback: function (res) {
		        caller.gridView04.setData(res);  
		    }    
		})
		.call({
            type: "GET",
            url:  ["rout", "man"],
            data: {routCd:data.routCd},
            callback: function (res) {
                caller.gridView05.setData(res);  
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

var CODE = {};

fnObj.pageStart = function () {
	var _this = this;
    ppmboot
    .call({
        type: "GET",
        url:  ["basic", "detail"],
        data: {mainCd: "NWRK_CD"},
        callback: function (res) {        		
            this.NWRK_CD = res.list;
        }
    })
    .done(function () {
        CODE = this;
        CONVERT_CODE = convertCommonCode(CODE);
        
        _this.pageButtonView.initView();
        _this.searchView.initView();
        _this.gridView01.initView();
        _this.gridView02.initView();
        _this.gridView03.initView();
        _this.gridView04.initView();
        _this.gridView05.initView();

        ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
        
    });
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
 * gridView
 */
fnObj.gridView01 = ppmboot.viewExtend(ppmboot.gridView, {
   initView: function () {
        var _this = this;

        this.target = ppmboot.gridBuilder({
        	showLineNumber: true,  
            multipleSelect: false,
            sortable: true, 
            multiSort: false,
            showRowSelector:true, 
            multiSort:false,
            lineNumberColumnWidth: 40,
            rowSelectorColumnWidth: 26,
            frozenColumnIndex: 0,
            target: $('[data-ax5grid="grid-view-01"]'),
            columns: [
                {key: "routCd", label: "공정코드", width: 120, align: "center",formatter:function(){
                	return this.value;
                }},
                {key: "routNm", label: "공정명", width: 418, align: "left",formatter:function(){
                	return "<font style='cursor:pointer'><u>"+nvl(this.value,'')+"</u></font>";
                }},
                {key: "routType", width: 120},
                {key: "whCd" , label:"공정창고", width: 120},
                {key: "qcYn", width: 120},
                {key: "equipUseYn", width: 120},
                {key: "outscFlag", width: 120},
                //{key: "custNm",label:"외주거래처", width: 240},
                {key: "routEqCnt",width: 90, label: "설비(수)", formatter:"number", align: "right"},
                {key: "routNwrkCnt",width: 90, label: "비가동(수)", formatter:"number", align: "right"},
                {key: "routBadCnt",width: 90, label: "불량(수)", formatter:"number", align: "right"},
                {key: "routManCnt",width: 90, label: "인원(수)", formatter:"number", align: "right"},
                {key: "useYn",width: 100},
            ],
            body: {
                onClick: function () {
                    this.self.select(this.dindex);
                    if(this.column.key != "routNm") {
                		ACTIONS.dispatch(ACTIONS.ITEM_CLICK, this.item);
                	}
                    if(this.column.key == "routNm") {
                    	ACTIONS.dispatch(ACTIONS.VIEW_FORM,this.item);
                    }
                },
                onDBLClick: function () {
                    this.self.select(this.dindex);
                	/*if(this.column.key == "routCd") {
                		ACTIONS.dispatch(ACTIONS.ITEM_CLICK, this.item);
                	}*/
                },
            }
        });
    },
    getData: function (_type) {
        var list = [];
        var _list = this.target.getList(_type);

        if (_type == "modified" || _type == "deleted") {
            list = ax5.util.filter(_list, function () {
                return this.whCd;
            });
        } else {
            list = _list;
        }
        return list;
    },
    addRow: function () {
        this.target.addRow({__created__: true}, "last");
    }
});

fnObj.gridView02 = ppmboot.viewExtend(ppmboot.gridView, {	
    initView: function () {
        var _this = this;
        this.target = ppmboot.gridBuilder({
            showLineNumber: true,  
            multipleSelect: false,
            sortable: true, 
            multiSort: false,
            showRowSelector:false, 
            multiSort:false,
            lineNumberColumnWidth: 40,
            rowSelectorColumnWidth: 26,
            frozenColumnIndex: 0,
            target: $('[data-ax5grid="grid-view-02"]'),
            columns: [  
                {key: "equipCd", label: "설비코드", width:313, align: "center",formatter:function(){
                 	return this.value;
                 }},
                {key: "equipNm", label:"설비명", width: 700, align: "left"},
                {key: "refYn", label:"연결설비", width: 300, align: "center"},
                {key: "useYn", label:"사용여부", width: 300, align: "center"},
            ],  
            body: { 
                onClick: function () {
                    this.self.select(this.dindex);
                }
            }
        });
    }
});

fnObj.gridView03 = ppmboot.viewExtend(ppmboot.gridView, {	
    initView: function () {
        var _this = this;
        this.target = ppmboot.gridBuilder({
            showLineNumber: true,  
            multipleSelect: false,
            sortable: true, 
            multiSort: false,
            showRowSelector:false, 
            multiSort:false,
            lineNumberColumnWidth: 40,
            rowSelectorColumnWidth: 26,
            frozenColumnIndex: 0,
            target: $('[data-ax5grid="grid-view-03"]'),
            columns: [  
                {key: "nwrkCd", label:"비가동코드", width: 400, align: "center",formatter:function(){
                	return this.value;
                }},
				{key: "nwrkCd",label: "비가동명", width: 740, align: "left", formatter: function formatter() { return CONVERT_CODE["NWRK_CD"].map[this.value];}},
                {key: "useYn", label:"사용여부", width: 473, align: "center"}
            ],  
            body: { 
                onClick: function () {
                    this.self.select(this.dindex);
                }
            }
        });
    }
});

fnObj.gridView04 = ppmboot.viewExtend(ppmboot.gridView, {	
    initView: function () {
        var _this = this;
        this.target = ppmboot.gridBuilder({
            showLineNumber: true,  
            multipleSelect: false,
            sortable: true, 
            multiSort: false,
            showRowSelector:false, 
            multiSort:false,
            lineNumberColumnWidth: 40,
            rowSelectorColumnWidth: 26,
            frozenColumnIndex: 0,
            target: $('[data-ax5grid="grid-view-04"]'),
            columns: [  
                {key: "badCd", label:"불량코드", width: 400, align: "center",formatter:function(){
                	return this.value;
                }},
				{key: "badNm",label: "불량명", width: 740, align: "left"},
                {key: "useYn", label:"사용여부", width: 473, align: "center"}
            ],  
            body: { 
                onClick: function () {
                    this.self.select(this.dindex);
                }
            }
        });
    }
});

fnObj.gridView05 = ppmboot.viewExtend(ppmboot.gridView, {	
    initView: function () {
        var _this = this;
        this.target = ppmboot.gridBuilder({
            showLineNumber: true,  
            multipleSelect: false,
            sortable: true, 
            multiSort: false,
            showRowSelector:false, 
            multiSort:false,
            lineNumberColumnWidth: 40,
            rowSelectorColumnWidth: 26,
            frozenColumnIndex: 0,
            target: $('[data-ax5grid="grid-view-05"]'),
            columns: [  
                {key: "userCd", label:"작업자ID", width: 400, align: "center"},
                {key: "userNm", label:"작업자명", width: 740},
                {key: "useYn", label:"사용여부", width: 473, align: "center"}
            ],  
            body: { 
                onClick: function () {
                    this.self.select(this.dindex);
                }
            }
        });
    }
});