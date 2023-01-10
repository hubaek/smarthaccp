/**
 * 0. Project	: HACCP MES
 * 1. 작성자  		: 스마트HACCP
 * 2. 작성일		: 2020.01.01
 * 3. Comment 	: 서버모니터링
 * 4. 변경이력 : 
 *  			이름		|일자          		|변경내용
 *              ------------------------------------------------------
 *				
 */

var fnObj = {};

var ACTIONS = ppmboot.actionExtend(fnObj, {	
	PAGE_SEARCH: function (caller, act, data) {		
    	ppmboot.ajax({
            type: "GET",
            url: ["server", "log"],
            data: $.extend({}, getSerializeArrayToJson("#searchView0")),
            callback: function (res) {   
                caller.gridView01.setData(res); 
            }
        });   	 
        return false;
    },    
    dispatch: function (caller, act, data) {
        var result = ACTIONS.exec(caller, act, data);
        if (result != "error") {
            return result;
        } else {
            // 직접코딩
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
 * gridView01
 */
fnObj.gridView01 = ppmboot.viewExtend(ppmboot.gridView, {
    initView: function () {
        var _this = this;
        this.target = ppmboot.gridBuilder({
            showLineNumber: true,
            sortable: true, 
            multiSort:false,
            showRowSelector: true, 
            multipleSelect: true,
            lineNumberColumnWidth: 40,
            rowSelectorColumnWidth: 26,
            frozenColumnIndex: 0,
            target: $('[data-ax5grid="grid-view-01"]'),
            columns: [  
                {key: "logSeq", label: "로그SEQ", width: 100, align: "center", editor: "text"},
                {key: "serverCd", label: "서버코드", width: 130, align: "center", editor: "text"},
                {key: "programNm", label: "프로그램명", width: 130, align: "center", editor: "text"},
                {key: "createdAt" ,width:150},
                {key: "createdBy"},
                {key: "updatedAt" ,width:150},
                {key: "updatedBy"}
            ],
            body: { 
                onClick: function () {
                    this.self.select(this.dindex);
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
                return this.serverCd && this.logSeq;
            });
        } else {
            list = _list;
        }
        return list;
    }
});