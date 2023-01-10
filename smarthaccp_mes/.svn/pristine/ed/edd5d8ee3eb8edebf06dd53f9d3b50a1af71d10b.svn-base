/**
 * 0. Project	: 스마트HACCP MES
 * 1. 작성자  	: 스마트HACCP_NEW
 * 2. 작성일		: 2022.07.13
 * 3. Comment 	: 자료실(제품)
 * 4. 변경이력 : 
 *  			이름		|일자          		|변경내용
 *              ------------------------------------------------------
 *				
 */
var fnObj = {};

var ACTIONS = ppmboot.actionExtend(fnObj, {	
	PAGE_SEARCH: function (caller, act, data) {	
		var itemCd = $("input[name=itemCd]").val();
		var dataNm = $("#dataNm").val();
		var madeBy = $("#madeBy").val();
		
		ppmboot.call({
	        	type: "GET",
	            url: ["board","selectBoardTypeItem"],
	        	data: {"company": SCRIPT_SESSION["company"], "itemCd" : itemCd, "dataNm" : dataNm, "madeBy" : madeBy},
	            callback: function (res) {
	            	caller.gridView01.setData(res);
	            }
	    })
	    .done(function () {
	    
	    });
        return false;
    },    
    //신규 작성
    ADD_FORM: function (caller, act, data) {
    	var paramObj = {
            "mode" : "add"
        };
        ppmboot.popup.open("/jsp/mes/BOD/modal/BOD040MV.jsp", "자료등록", "1300", "700", paramObj);
    },
    //조회
    VIEW_FORM: function (caller, act, data) {
    	var paramObj = {
            "mode" : "mod",
            "seq" : data.seq
        };
        ppmboot.popup.open("/jsp/mes/BOD/modal/BOD040MV.jsp", "자료조회 및 수정", "1300", "700", paramObj);
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
 * gridView01 품목정보
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
                 {key: "regDt", label : "등록일", width: 200, align:"center"},
                 {key: "itemNm", label : "제품", width: 600, formatter:function(){
                 	return "<font style='cursor:pointer'><u>"+nvl(this.value,'')+"</u></font>";
                 }}, 
                 {key: "dataNm", label : "자료명", width: 250, align:"left"},
                 {key: "madeBy", label : "제조사", width: 250, align:"center"},
                 {key: "company", hidden: true},
                 {key: "seq", hidden: true},
                 {key: "itemCd", hidden: true},
                 {key: "boardDesc", hidden: true}
                 
            ],
            body: { 
                onClick: function () {
                    this.self.select(this.dindex);
                    if(this.column.key == "itemNm") {
                        ACTIONS.dispatch(ACTIONS.VIEW_FORM, this.item);
                	}
                },
            }
        });        
    },
    getData: function (_type) {
        var list = [];
        var _list = this.target.getList(_type);

        if (_type == "modified" || _type == "deleted") {
            list = ax5.util.filter(_list, function () {
                return this.itemCd;
            });
        } else {
            list = _list;
        }
        return list;
    }
});
