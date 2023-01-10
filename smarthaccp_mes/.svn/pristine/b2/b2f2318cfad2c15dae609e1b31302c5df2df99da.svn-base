var fnObj = {};
var param;
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
        ppmboot.ajax({
            type: "GET",
            url:  ["qcManage", "group"],
            data: $.extend({useYn:"Y"}, getSerializeArrayToJson("#searchView0")),
            callback: function (res) {
                caller.gridView01.setData(res);
            }
        });

        return false;
    },
    PAGE_CHOICE: function (caller, act, data) {
        var list = caller.gridView02.getData();        
        if (list.length > 0) {
        	if (typeof param.callBack === "undefined"){
        		parent.ppmboot.modal.callback(list);
        	}else{            		
        		parent[param.callBack](list);      
        	}
        }
    },
    ITEM_CLICK: function (caller, act, data) {
        ppmboot.ajax({
            type: "GET",
            url:  ["qcManage", "groupItem"],
            data: {company:data.company,qcGroupCd:data.qcGroupCd,useYn:"Y"},
            callback: function (res) {
                caller.gridView02.setData(res);
            }
        });
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
    ppmboot
	    .call({
	        type: "GET",
	        url:  ["basic", "detail"],
	        data: {mainCd: "QC_TYPE"},
	        callback: function (res) {        		
	            this.QC_TYPE = res.list;
	        }
	    })
	    .call({
	        type: "GET",
	        url:  ["basic", "detail"],
	        data: {mainCd: "QC_UNIT"},
	        callback: function (res) {        		
	            this.QC_UNIT = res.list;
	        }
	    })
        .done(function () {
            CODE = this;    
	        CONVERT_CODE = convertCommonCode(CODE); 
            _this.pageButtonView.initView();
            _this.searchView.initView();
            _this.gridView01.initView();
            _this.gridView02.initView();
            param = ax5.util.param(ax5.info.urlUtil().param);

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
            "choice": function () {
                ACTIONS.dispatch(ACTIONS.PAGE_CHOICE);
            },
            "close": function () {
                ACTIONS.dispatch(ACTIONS.PAGE_CLOSE);
            }
        });
    }
});

//== view 시작
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
 * gridView01	품목정보목록
 */
fnObj.gridView01 = ppmboot.viewExtend(ppmboot.gridView, {
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
            target: $('[data-ax5grid="grid-view-01"]'),
            columns: [  
                {key: "qcGroupCd",label: "검사그룹코드",width:100,align:"center"},
                {key: "qcGroupNm",label: "검사그룹명",width:200,align:"left"},      
                {key: "qcType", label: "검사유형", width: 130, align: "center",formatter: function formatter() { return CONVERT_CODE["QC_TYPE"].map[this.value];}},
                {key: "remark", label: "비고", width: 150, align: "left"},  
                
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
                return this.itemCd;
            });
        } else {
            list = _list;
        }
        return list;
    }
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
            multiSort:false,
            lineNumberColumnWidth: 40,
            rowSelectorColumnWidth: 26,
            frozenColumnIndex: 0,
            target: $('[data-ax5grid="grid-view-02"]'),
            columns: [  
                {key: "qcCd"},
                {key: "qcNm",label: "검사항목명", width: 150, align: "center"},    
				{key: "qcUnit"},				
                {key: "qcSpec", label: "검사기준", width: 150, align: "left"},
                {key: "specMax", label: "규격상한값", width: 100, formatter:"number", align: "right"},
                {key: "specMin", label: "규격하한값", width: 100, formatter:"number", align: "right"},
                {key: "remark", label: "비고", width: 200, align: "left"},
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
