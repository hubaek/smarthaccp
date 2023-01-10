/**
 * 0. Project	: 스마트HACCP MES
 * 1. 작성자  	: 스마트HACCP_NEW
 * 2. 작성일	: 2020.01.01
 * 3. Comment 	: 출하검사항목등록
 * 4. 변경이력 : 
 *  			이름		|일자          		|변경내용
 *              ------------------------------------------------------
 *				
 */
var fnObj = {};
var mask;
var qcType = "20"			//출하검사
var QC_ROUT_CODE = "DCHE"	//출하검사 공정

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
    	ppmboot.ajax({
            type: "GET",
            url:  ["qcManage", "getQcItemTargetList"],
            data: $.extend({itemTypeGroup:"P",qcType:qcType}, getSerializeArrayToJson("#searchView0")),
            callback: function (res) {   
                caller.gridView01.setData(res);
            }
        });
        return false;
    },        
    PAGE_SAVE: function (caller, act, data) {
        var sData = [].concat(caller.gridView01.getData("selected"));       	
        if(sData.length > 0){
        	var bData = [].concat(caller.gridView02.getData("created"));   
            bData = [].concat(caller.gridView02.getData("modified"));   
            bData = bData.concat(caller.gridView02.getData("deleted"));   
            bData.forEach(function (n) {
                n.company = sData[0].company;
                n.itemCd = sData[0].itemCd;
                n.routCd = QC_ROUT_CODE;
            });
        	ppmboot
            .call({
                type: "PUT",
                url:  ["qcManage", "item"],
                data: JSON.stringify(bData),
                callback: function (res) {
                	
                }
            })
            .done(function () {
                axToast.push("저장 되었습니다.");
                ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
            });
        }
    },  
    ITEM_CLICK: function (caller, act, data) {
    	caller.formView01.setData(data);
        ppmboot.ajax({
            type: "GET",
            url:  ["qcManage", "item"],
            data: {qcType:qcType,itemCd:data.itemCd},
            callback: function (res) {
                caller.gridView02.setData(res);
            }
        });
    },
    QC_GROUP_M: function (caller, act, data) {   
        var list = caller.gridView01.getData("selected");
        if(list.length > 0){
        	customModal.open({
                width: 1300,
                height: 750,
                iframe: {
                    method: "get",
                    url: "/jsp/mes/QC/modal/QC-GROUP-M.jsp", 
                    param: "callBack=qcGroupModalCallback"
                }
            });  
        }else{
        	 axDialog.alert({
                 theme: "warning",
                 msg: "품목을 선택하세요."
             });
        	 return false;
        }  	
    },
    QC_MASTER_M: function (caller, act, data) {   
    	var list = caller.gridView01.getData("selected");
        if(list.length > 0){
        	customModal.open({
                width: 1300,
                height: 750,
                iframe: {
                    method: "get",
                    url: "/jsp/mes/QC/modal/QC-MASTER-M.jsp", 
                    param: "callBack=qcMasterModalCallback"
                }
            });  
        }else{
        	 axDialog.alert({
                 theme: "warning",
                 msg: "품목을 선택하세요."
             });
        	 return false;
        }  	  	
    },
    ITEM_SUB_DEL: function (caller, act, data) {
        caller.gridView02.delRow("selected");
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
    _this.formView01.initView();
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
 * formView01
 */
fnObj.formView01 = ppmboot.viewExtend(ppmboot.formView, {
    getDefaultData: function () {
        return $.extend({}, ppmboot.formView.defaultData, {});
    },
    initView: function () {
        this.target = $("#formView01");
        this.model = new ax5.ui.binder();
        this.model.setModel(this.getDefaultData(), this.target);
        this.modelFormatter = new ppmboot.modelFormatter(this.model); // 모델 포메터 시작            
        this.initEvent();
    },
    initEvent: function () {
        var _this = this;             
    },
    getData: function () {
        var data = this.modelFormatter.getClearData(this.model.get()); // 모델의 값을 포멧팅 전 값으로 치환.
        return $.extend({}, data);
    },
    setData: function (data) {
        if (typeof data === "undefined") data = this.getDefaultData();   
        data = $.extend({}, data);
        
        if(nvl(data.itemCd,'') != ''){
            searchFile(data.itemCd);
        }
        
        this.model.setModel(data);
        this.modelFormatter.formatting(); // 입력된 값을 포메팅 된 값으로 변경
    },
    validate: function () {
        var rs = this.model.validate();  
        if (rs.error) {
        	 axDialog.alert({
                 theme: "warning",
                 msg: LANG("ax.script.form.validate", rs.error[0].jquery.attr("title"))
             });
            rs.error[0].jquery.focus();
            return false;
        }  
        return true;
    },
    clear: function () {
        this.model.setModel(this.getDefaultData());
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
				{key: "itemMainNm"},
				{key: "itemSubNm"},
                {key: "spec"},   
                {key: "unit"},
                {key: "qcCount"},
                
            ],
            body: { 
                onClick: function () {
                    this.self.select(this.dindex);
                    ACTIONS.dispatch(ACTIONS.ITEM_CLICK, this.item);
                },
                trStyleClass: function(){
                	if(this.item.qcCount == 0){
                		return "grid-cell-important1";
                	}
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
            multipleSelect: true,
            sortable: true, 
            multiSort: false,
            showRowSelector:true, 
            multiSort:false,
            lineNumberColumnWidth: 40,
            rowSelectorColumnWidth: 26,
            frozenColumnIndex: 0,
            target: $('[data-ax5grid="grid-view-02"]'),
            columns: [  
				{key: "qcCd"},
				{key: "qcNm"},
				{key: "qcUnit"},
                {key: "magmVal", label: "관리기준", width: 70, formatter:"number", align: "right", editor: {type: "number"},styleClass: "grid-cell-blue"},
                {key: "rmagMax", label: "R상한", width: 70, formatter:"number", align: "right", editor: {type: "number"},styleClass: "grid-cell-blue"},
                {key: "magmMax", label: "관리상한", width:70, formatter:"number", align: "right", editor: {type: "number"},styleClass: "grid-cell-blue"},
                {key: "magmMin", label: "관리하한", width: 70, formatter:"number", align: "right", editor: {type: "number"},styleClass: "grid-cell-blue"},
                {key: "specMax", label: "규격상한", width: 70, formatter:"number", align: "right", editor: {type: "number"},styleClass: "grid-cell-blue"},
                {key: "specMin", label: "규격하한", width: 70, formatter:"number", align: "right", editor: {type: "number"},styleClass: "grid-cell-blue"},
                {key: "smplCnt", label: "시료군수", width: 70, formatter:"number", align: "right", editor: {type: "number"},styleClass: "grid-cell-blue"},
                {key: "qcCnt", label: "측정횟수", width: 70, formatter:"number", align: "right", editor: {type: "number"},styleClass: "grid-cell-blue"},
                {key: "sort", label: "정렬", width: 70, formatter:"number", align: "right",editor: "number",styleClass: "grid-cell-blue"},
                {key: "useYn", label: "사용여부", editor:"checkYn",styleClass: "grid-cell-blue"},
            ],
            body: { 
                onClick: function () {
                    this.self.select(this.dindex);
                }
            }
        });
        
        ppmboot.buttonClick(this, "data-grid-view-02-btn", {
            "qc-group": function () {
                ACTIONS.dispatch(ACTIONS.QC_GROUP_M);
            },
            "qc-master": function () {
                ACTIONS.dispatch(ACTIONS.QC_MASTER_M);
            },
            "item-remove": function () {
                ACTIONS.dispatch(ACTIONS.ITEM_SUB_DEL);
            }
       });
       //엑셀 붙여넣기
       document.getElementById("gridView02").addEventListener('paste', function(e){
    	   handlePasteGridView(e, fnObj.gridView02.target, "N");  	//event ,target, addYn 
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
    addRow: function (data) {    	
        this.target.addRow({__created__: true, useYn: "Y",company:data.company,
        	qcType:qcType,
        	qcCd:data.qcCd,
        	qcNm:data.qcNm,
        	qcUnit:data.qcUnit,
        	qcSpec:data.qcSpec,
        	sort:data.sort,
        	}, "last");
    }
});

function qcGroupModalCallback(data){	
	var l = fnObj.gridView02.getData().length;
	
	data.forEach(function (n) {
		l++;
		n.sort = l;
		fnObj.gridView02.addRow(n);
     });  
	customModal.close();
}

function qcMasterModalCallback(data){	
	
	var l = fnObj.gridView02.getData().length;
	data.sort = l + 1;
	
	fnObj.gridView02.addRow(data);
}