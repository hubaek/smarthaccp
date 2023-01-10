/**
 * 0. Project	: 팔피엠 MES
 * 1. 작성자  		: 전준룡
 * 2. 작성일		: 2019.05.13
 * 3. Comment 	: 거래처별 구매단가등록
 * 4. 변경이력 : 
 *  			이름		|일자          		|변경내용
 *              ------------------------------------------------------
 *				
 */
var fnObj = {};
var customModal = new ax5.ui.modal({
  absolute: true,
  onStateChanged: function onStateChanged() {
      // mask
      if (this.state === "open") {
          window.axMask.open();
      } else if (this.state === "close") {
          window.axMask.close();
      }  
  }
});

var ACTIONS = ppmboot.actionExtend(fnObj, {
    PAGE_SEARCH: function (caller, act, data) {
    	ppmboot.ajax({
            type: "GET",
            url: ["item"],
            data: $.extend({itemTypeGroup:"I"}, getSerializeArrayToJson("#searchView0")),
            callback: function (res) {
                caller.gridView01.setData(res);
                caller.gridView02.setData([]);
            }
        });   	 
        return false;
    },        
    PAGE_SAVE: function (caller, act, data) {
        var dData = caller.gridView02.getData();
        var itemQtyCnt = 0;	       
        dData.forEach(function (n) {
        	if (nvl(n.unitPrice,0) == 0){
        		itemQtyCnt++;
        		return false;
        	}  
        });
        if(itemQtyCnt > 0){
          	 axDialog.alert({
                   theme: "warning",
                   msg: "구매단가를 입력하세요."
             });
          	 return false;
        }else{

	        var bData = [].concat(caller.gridView02.getData("created"));   
	        bData = [].concat(caller.gridView02.getData("modified"));   
	        bData = bData.concat(caller.gridView02.getData("deleted")); 
	        bData = caller.gridView02.getData();
	        ppmboot
	            .call({
	                type: "PUT", 
	                url:  ["price","pcPrice"],
	                data: JSON.stringify(bData),
	                callback: function (res) {
	
	                }
	            })
	            .done(function () {
	                axToast.push("저장 되었습니다.");
	                ACTIONS.dispatch(ACTIONS.ITEM_CLICK);
	            });
        }
    },
    ITEM_SUB_DEL: function (caller, act, data) {
        caller.gridView02.delRow("selected");
    },
    ITEM_CLICK: function (caller, act, data) {
        var list = caller.gridView01.getData("selected");
        ppmboot.ajax({
            type: "GET",    
            url:  ["price","pcPrice"],
            data: {itemCd:list[0].itemCd},
            callback: function (res) {  
                caller.gridView02.setData(res);
            }
        });
    },
    //거래처 선택정보적용
    CUST_SELECT_MODAL_OPEN: function (caller, act, data) {

        var list = caller.gridView01.getData("selected");        
        if (typeof list[0] === "undefined"){
        	axDialog.alert("품목을 리스트에서 선택하세요.");
        }else{
        	customModal.open({
	            width: 1000,
	            height: 800,
	            iframe: {
	                method: "get",
	                url: "/jsp/mes/modal/CUST-SEL-M.jsp", 
	                param: "callBack=customCustSelelctModalCallback&exceptCustType=20&itemCd="+list[0].itemCd+"&itemNm="+list[0].itemNm
	            }
	        });    			
        }
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
        data: {mainCode: "ITEM_GROUP"},
        callback: function (res) {        		
            this.ITEM_GROUP = res.list;
        }
    })
    .done(function () {
        CODE = this;
        CONVERT_CODE = convertCommonCode(CODE);

        _this.pageButtonView.initView();
        _this.searchView.initView();
        _this.gridView01.initView();
        _this.gridView02.initView();

        ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
    });
};



fnObj.pageResize = function () {};

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
                {key: "itemCd"},
                {key: "itemNm"},
                //{key: "partNo"},   
                {key: "itemType"},   
				//{key: "itemGroup", formatter: function formatter() { return CONVERT_CODE["ITEM_GROUP"].map[this.value];}},
                {key: "spec"},   
                {key: "unit"},
                {key: "custNm"},
                {key: "pcPrice" , label:"구매 기준단가"},
                {key: "unitPrice" ,label:"구매단가"},  
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
                return this.itemCode;
            });
        } else {
            list = _list;
        }
        return list;
    }
});


/**
 * gridView02 구매처별 단가
 */
fnObj.gridView02 = ppmboot.viewExtend(ppmboot.gridView, {	
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
            target: $('[data-ax5grid="grid-view-02"]'),
            columns: [  
            	{key: "itemCd"},
            	{key: "itemNm"},
                {key: "custCd", label: "거래처코드", width: 100, align: "center",styleClass: "grid-cell-blue"},                
                {key: "custNm", label: "거래처명", width: 100, align: "center",styleClass: "grid-cell-blue"},
                {key: "regDt", label: "최종등록일", width: 100, align: "center"},
                {key: "unitPrice", label:"구매단가", editor: {type: "number"},styleClass: "grid-cell-blue"},
                {key: "useYn", label:"사용여부", width: 70, align: "center", editor: "checkYn",styleClass: "grid-cell-blue"},
                {key: "updatedAt"},
                {key: "updatedBy"},
            ],
            body: { 
                onClick: function () {
                    this.self.select(this.dindex);
                }
            }
        });
        ppmboot.buttonClick(this, "data-grid-view-02-btn", {
            "cust-all": function () {
                ACTIONS.dispatch(ACTIONS.CUST_SELECT_MODAL_OPEN);
            },
            "item-remove": function () {
                ACTIONS.dispatch(ACTIONS.ITEM_SUB_DEL);
            }
        });
        
    },
    getData: function (_type) {
        var list = [];
        var _list = this.target.getList(_type);

        if (_type == "modified" || _type == "deleted") {
            list = ax5.util.filter(_list, function () {
                return this.custCode ;
            });
        } else {
            list = _list;
        }
        return list;
    },
    addRow: function (data) {
        this.target.addRow({__created__: true,useYn:"Y",company:data.company,itemCd:data.itemCd,itemNm:data.itemNm,custCd:data.custCd,custNm:data.custNm,regDt:getNowDt()}, "last");
    }
});


//공정선택 적용
function customCustSelelctModalCallback(item,param){
	//한글 깨짐 현상 발생해서 처리함 2020-12-02 cju
	var encodeStr = decodeURI(param.itemNm);
	
	item.itemCd = param.itemCd;
	item.itemNm = encodeStr;
	fnObj.gridView02.addRow(item);
}