/**
 * 0. Project	: 스마트HACCP MES
 * 1. 작성자  	: 스마트HACCP_NEW
 * 2. 작성일	: 2020.01.01
 * 3. Comment 	: 수입 검사불량유형등록
 * 4. 변경이력 : 
 *  			이름		|일자          		|변경내용
 *              ------------------------------------------------------
 *				
 */
var fnObj = {};
var mainCd = "BAD_CD";
var codeLabel = "불량코드"
var valueLabel = "불량명"
	
var customModal = new ax5.ui.modal({
  absolute: true,
  onStateChanged: function onStateChanged() {
      if (this.state === "open") {
          window.axMask.open();
      } else if (this.state === "close") {
          window.axMask.close();
      }  
  }
});

var ACTIONS = ppmboot.actionExtend(fnObj, {
    PAGE_SEARCH: function (caller, act, data) {    	 
    	var mData = getSerializeArrayToJson("#searchView0");
    	ppmboot.ajax({
            type: "GET",
            url: ["rout","bad"], 
            data: $.extend({routCd:mData.routCd}, getSerializeArrayToJson("#searchView0")),
            callback: function (res) {
                caller.gridView01.setData(res);
            }
        });
        return false;  
    },  
    PAGE_SAVE: function (caller, act, data) {
    	var mData = getSerializeArrayToJson("#searchView0");
        var bData = [].concat(caller.gridView01.getData("modified"));
        bData = bData.concat(caller.gridView01.getData("deleted"));  
        //2020-07-14 company 코드 하드코딩으로 주입 최정욱
        bData.forEach(function (n) {
            n.company = mData.company;
        });
        ppmboot
        .call({
            type: "PUT", 
            url: ["rout","bad"], 
            data: JSON.stringify(bData),
            callback: function (res) {

            }
        }) 
        .done(function () {
            axToast.push("저장 되었습니다.");
        });        
    },
    BAD_SELECT_MODAL_OPEN: function (caller, act, data) {
    	customModal.open({
            width: 900,
            height: 700,
            iframe: {
                method: "get",
                url: "/jsp/mes/modal/BASIC-BAD-M.jsp", 
                param: "callBack=customBadSelelctModalCallback&gridNm=gridView01&keyNm=badCd"
            }
        });   
    },    
    ITEM_SUB_DEL: function (caller, act, data) {
        caller.gridView01.delRow("selected");
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
	ppmboot
	 .call({
	     type: "GET",
	     url:  ["basic", "detail"],
	     data: {mainCd: "BAD_CD"},
	     callback: function (res) {        		
	         this.BAD_CD = res.list;
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
            "save": function () {
                ACTIONS.dispatch(ACTIONS.PAGE_SAVE);
            }
        });
    }
});

/**
 * searchView
 */  
fnObj.searchView = ppmboot.viewExtend(ppmboot.searchView, {
    getDefaultData: function () {		
        return $.extend({}, ppmboot.formView.defaultData, {routCd:"QCHE"});
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
        this.model.onChange("routCd", function () {
            ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
        });
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
                {key: "badCd", label:"불량코드", width: 120, align: "center",formatter:function(){
                	return this.value;
                }},
				{key: "badNm",label: "불량명", width: 180, align: "center"},
                {key: "useYn", label:"사용여부", width: 80, align: "center", editor: "checkYn"}
            ],
            body: {
                onClick: function () {
                }
            }
        });  

        ppmboot.buttonClick(this, "data-grid-view-01-btn", {
            "bad-all": function () {
           	 	ACTIONS.dispatch(ACTIONS.BAD_SELECT_MODAL_OPEN);
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
                return this.badCd;
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
        this.target.addRow({__created__: true,badCd:data.subCd,badNm:data.subNm,routCd:data.routCd,company:data.company,useYn:nvl(data.useYn,"Y"),
        	}, "last");
    }
});


//불량적용
function customBadSelelctModalCallback(data){

    var mData = getSerializeArrayToJson("#searchView0");   
	var list = fnObj.gridView01.getData();     
	var addYn = "Y";
	
	list.forEach(function (n) {
		if(n.badCd == data.subCd){
			addYn = "N";
			return false; 
		}
	});
	
	if(addYn == "Y"){

	    data.routCd = mData.routCd;
		fnObj.gridView01.addRow(data);
	}
}