/**
 * 0. Project	: 스마트HACCP MES
 * 1. 작성자  		: 스마트HACCP 
 * 2. 작성일		: 2018.01.01
 * 3. Comment 	: 검사내역
 * 4. 변경이력 : 
 *  			이름		|일자          		|변경내용
 *              ------------------------------------------------------
 *				
 */
var fnObj = {};
var param;

var ACTIONS = ppmboot.actionExtend(fnObj, {
    PAGE_CLOSE: function (caller, act, data) { 
		parent.customModal.close();
    },
    PAGE_SEARCH: function (caller, act, data) {
    	 ppmboot                 
	        .call({
	        	type: "GET",
	            url:  ["qcManage","getQcDetailList"],
	            data: {slipCd:param.slipCd},
	            callback: function (res) {
	                caller.gridView01.setData(res);
	            }
	     })    
         .done(function () {
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

    param = ax5.util.param(ax5.info.urlUtil().param);
    ppmboot
	    .call({
	        type: "GET",
	        url: ["basic", "detail"],
	        data: {mainCd:"QC_FLAG", useYn: "Y"},
	        callback: function (res) {        
	            this.QC_FLAG = res.list;
	        }
	    })
	    .call({
	        type: "GET",
	        url:  ["qcManage", "master"],
	        data: {qcType:param.qcType},
	        callback: function (res) {       	
	        	res.list.forEach(function (n) {   
	    			n.subCd = n.qcCd;   
	    			n.subNm = n.qcNm;
	    		});            	
	            this.QC_CD = res.list; 
	        }
	    })
	    .done(function () {
	        CODE = this;
	        CONVERT_CODE = convertCommonCode(CODE);

	        _this.pageButtonView.initView();
	        _this.searchView.initView();
	        _this.gridView01.initView();    
	
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
 * gridView01	검사규격
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
				{key: "qcCd",label:"검사항목",width:120,align:"center", formatter: function formatter() { return CONVERT_CODE["QC_CD"].map[this.value];}},
                //{key: "qcSpec", label: "검사기준", width: 150, align: "center"},
            	{key: "qcUnit"},
                {key: "magmVal", label: "관리기준값", width: 90, formatter:"number", align: "right"},
                {key: "specMax", label: "규격상한값", width: 90, formatter:"number", align: "right"},
                {key: "specMin", label: "규격하한값", width: 90, formatter:"number", align: "right"},
                {key: "qcFlag", label: "검사상태", formatter: function formatter() { return parent.COMMON_CODE["QC_FLAG"].map[this.value];}},
            	{
                    label: "측정치", columns: [
                        {key: "measure1", label: "n1", width: 70, formatter:"number", align: "right"},
                        {key: "measure2", label: "n2", width: 70, formatter:"number", align: "right"},
                        {key: "measure3", label: "n3", width: 70, formatter:"number", align: "right"},
                        {key: "measure4", label: "n4", width: 70, formatter:"number", align: "right"},
                        {key: "measure5", label: "n5", width: 70, formatter:"number", align: "right"},
                    ]
                },
                {key: "remark1", label: "비고", width: 200, align: "left"},
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
                return this.itemCd;
            });
        } else {
            list = _list;
        }
        return list;
    },
});