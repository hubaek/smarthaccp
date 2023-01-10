/**
 * 0. Project	: 스마트HACCP MES
 * 1. 작성자  	: 스마트HACCP_NEW
 * 2. 작성일	: 2020.01.01
 * 3. Comment 	: 자료실
 * 4. 변경이력 : 
 *  			이름		|일자          		|변경내용
 *              ------------------------------------------------------
 *				
 */
var fnObj = {};
var PAGE_NAME = "자료실";
var BOARD_TYPE = "DATA";

var ACTIONS = ppmboot.actionExtend(fnObj, {
    PAGE_SEARCH: function (caller, act, data) {    	     
    	ppmboot.ajax({
            type: "GET",
            url: ["board"],
            data: $.extend({boardType:BOARD_TYPE}, getSerializeArrayToJson("#searchView0")),
            callback: function (res) {   
                caller.gridView01.setData(res);
            }
        });   	 
        return false;
    },    
    ITEM_CLICK: function (caller, act, data) {
    	ppmboot.modal.open({  
            modalType: "BOD030MV",
            param: "",
            sendData: function(){
                return {
                	"mode" : "mod",
                	"boardCd" : data.boardCd
                };
            },
            callback: function (data) {
                ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
            }
        });    
    },
    //신규 작성
    ADD_FORM: function (caller, act, data) {
    	axDialog.confirm({
            msg: "신규 "+PAGE_NAME+"를 작성 하시겠습니까?"
        }, function () {
            if (this.key == "ok") {
            	ppmboot.modal.open({  
                    modalType: "BOD030M",
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
 * gridView01	목록
 */
fnObj.gridView01 = ppmboot.viewExtend(ppmboot.gridView, {
    initView: function () {
        var _this = this;
        this.target = ppmboot.gridBuilder({
            showLineNumber: true,
            sortable: true, 
            multiSort: true,
            showRowSelector: false, 
            multiSort:false,
            lineNumberColumnWidth: 40,
            rowSelectorColumnWidth: 25,
            frozenColumnIndex: 0,
            target: $('[data-ax5grid="grid-view-01"]'),
            columns: [
                {key: "regDt",width:250,label:"등록일",align:"center"},
                {key: "boardTitle" ,label:"제목", width:620, align:"left"},
                {key: "userNm", label:"등록자", width:250, align:"center"},
                {key: "viewCnt", label: "조회수", width: 250, formatter:"number", align: "right"},
                {key: "updatedAt", width: 250},
            ],
            body: { 
                onClick: function () {
                    this.self.select(this.dindex);
                    ACTIONS.dispatch(ACTIONS.ITEM_CLICK, this.item);
                }
            }
        });        
    },
    getData: function (_type) {
        var list = [];
        var _list = this.target.getList(_type);

        if (_type == "modified" || _type == "deleted") {
            list = ax5.util.filter(_list, function () {
                return this.boardCd;
            });
        } else {
            list = _list;
        }
        return list;
    }
});