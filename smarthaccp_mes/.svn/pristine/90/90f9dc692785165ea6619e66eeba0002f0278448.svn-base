/**
 * 0. Project	: 스마트HACCP MES
 * 1. 작성자  	: 스마트HACCP
 * 2. 작성일		: 2020.06.30
 * 3. Comment 	: 비가동유형등록
 * 4. 변경이력 : 
 *  			이름		|일자          		|변경내용
 *              ------------------------------------------------------
 *				
 */
var fnObj = {};
var mainCd = "NWRK_CD";
var codeLabel = "비가동코드"
var valueLabel = "비가동명"
	
var ACTIONS = ppmboot.actionExtend(fnObj, {
    PAGE_SEARCH: function (caller, act, data) {
    	ppmboot.ajax({
            type: "GET",
            url:  ["basic", "detail"],
            data: $.extend({mainCd:mainCd}, getSerializeArrayToJson("#searchView0")),
            callback: function (res) {
                caller.gridView01.setData(res);
            }
        });
        return false;  
    },
    PAGE_SAVE: function (caller, act, data) {

        var mData = getSerializeArrayToJson("#searchView0");            
        var dData = [].concat(caller.gridView01.getData("modified"));        
        var itemQtyCnt1 = 0;
        var itemQtyCnt2 = 0;

        dData.forEach(function (n) {
        	if (nvl(n.subCd,'') == ''){
        		itemQtyCnt1++;
        		return false;
        	}  
        	if (nvl(n.subNm,'') == ''){
        		itemQtyCnt2++;
        		return false;
        	}  
        });

        if(itemQtyCnt1 > 0){
         	 axDialog.alert({
                  theme: "warning",
                  msg:  codeLabel + "를 입력하세요."
            });
         	 return false;
       }else if(itemQtyCnt2 > 0){
         	 axDialog.alert({
                  theme: "warning",
                  msg: valueLabel + "를 입력하세요."
            });
         	 return false;
       }else{

           dData = dData.concat(caller.gridView01.getData("deleted"));
           // m에 d 삽입
           dData.forEach(function (n) {
               n.company = mData.company;
               n.mainCd = mainCd;
           });
           
    	   ppmboot
           .call({
               type: "PUT",
               url: ["basic", "detail"], 
               data: JSON.stringify(dData),
               callback: function (res) {
            	   
               }
           })
           .done(function () {
               axToast.push("저장 되었습니다.");
               ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
           });
       }
        
    },
    ITEM_SUB_ADD: function (caller, act, data) {
    	caller.gridView01.addRow();
    },
    ITEM_SUB_DEL: function (caller, act, data) {
        caller.gridView01.delRow("selected");
    },  
    //엑셀 다운로드 2020-12-09 추가
    EXCEL_DOWNLOAD: function (caller, act, data) {
    	caller.gridView01.target.exportExcel("비가동유형정보.xls");
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
            "save": function () {
                ACTIONS.dispatch(ACTIONS.PAGE_SAVE);
            },
            "excel": function () {
                ACTIONS.dispatch(ACTIONS.EXCEL_DOWNLOAD);
            }
        });
    }
});

/**
 * searchView
 */  
fnObj.searchView = ppmboot.viewExtend(ppmboot.searchView, {
    getDefaultData: function () {		
        return $.extend({}, ppmboot.formView.defaultData, {});
    },
    initView: function () {
        this.target = $(document["searchView0"]);
        this.model = new ax5.ui.binder();
        this.model.setModel(this.getDefaultData(), this.target);
        this.modelFormatter = new ppmboot.modelFormatter(this.model); // 모델 포메터 시작
        this.target.attr("onsubmit", "return ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);");
        this.initEvent();
    },
    initEvent: function () {
        var _this = this;
    },
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
            multipleSelect: true,
            lineNumberColumnWidth: 40,
            rowSelectorColumnWidth: 26,
            target: $('[data-ax5grid="grid-view-01"]'),
            columns: [
                {key: "subCd", label: codeLabel, width: 80, align: "center", editor: "text",styleClass: "grid-cell-blue"},
                {key: "subNm", label: valueLabel, width: 200, align: "left", editor: "text",styleClass: "grid-cell-blue"},                     
                {key: "remark", label: "비고", width: 200, align: "left", editor: "text",styleClass: "grid-cell-blue"},
                {key: "sort", label: "정렬", editor: "number",styleClass: "grid-cell-blue"},
                {key: "useYn", label: "사용유무", editor: "checkYn",styleClass: "grid-cell-blue"}, 
            ],
            body: {
            }
        });  

        ppmboot.buttonClick(this, "data-grid-view-01-btn", {
            "item-add": function () {
                ACTIONS.dispatch(ACTIONS.ITEM_SUB_ADD);
            },
            "item-remove": function () {
                ACTIONS.dispatch(ACTIONS.ITEM_SUB_DEL);
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
                return this.subCd;
            });
        } else {
            list = _list;
        }
        return list;
    },
    align: function () {
        this.target.align();
    },
    addRow: function (data) {    	
        this.target.addRow({__created__: true, useYn: "Y"}, "last");
    }
});