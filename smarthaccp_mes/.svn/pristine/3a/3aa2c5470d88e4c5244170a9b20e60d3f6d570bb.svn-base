/**
 * 0. Project	: 스마트HACCP MES
 * 1. 작성자  	: 스마트HACCP_NEW
 * 2. 작성일	: 2020.01.01
 * 3. Comment 	: 개별시스템 권한관리
 * 4. 변경이력 : 
 *  			이름		|일자          		|변경내용
 *              ------------------------------------------------------
 *				
 */
var fnObj = {};

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
            url: ["users","getPopAuthUserList"],
            data: $.extend({}, getSerializeArrayToJson("#searchView0")),
            callback: function (res) {
                caller.gridView01.setData(res);
            }
        });
        return false;
    },    
    PAGE_SAVE: function (caller, act, data) {    	
        var bData = [].concat(caller.gridView01.getData("created"));   
        bData = [].concat(caller.gridView01.getData("modified"));   
        bData = bData.concat(caller.gridView01.getData("deleted")); 
        var cData = [].concat(caller.gridView02.getData("created"));   
        cData = [].concat(caller.gridView02.getData("modified"));   
        cData = cData.concat(caller.gridView02.getData("deleted")); 
        ppmboot
        .call({
        	type: "PUT",
            url: ["system","pop"],
        	data: JSON.stringify(bData),
            callback: function (res) {         
            }
        })
        .call({
        	type: "PUT",
            url: ["system","popEquip"],
        	data: JSON.stringify(cData),
            callback: function (res) {         
            }
        })
        .done(function () {
            axToast.push("저장 되었습니다.");
            ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
        });
        
    },    
    ITEM_CLICK: function (caller, act, data) {
        ppmboot
	        .call({
	            type: "GET",
	            url: ["system","popEquip"],
	            data: {userCd:data.userCd},
	            callback: function (res) {
	                caller.gridView02.setData(res);  
	            }    
	        })
	        .done(function () {
	        });
    },
    //설비 선택정보적용
    EQUIP_SELECT_MODAL_OPEN: function (caller, act, data) {
        var mData = caller.gridView01.getData("selected");      
        if(mData.length == 0){
        	axDialog.alert("대상을 선택하세요.");
        	return false;
        }else{
            if(nvl(mData[0].userCd,'') != ''){
            	customModal.open({
                    width: 900,
                    height: 700,
                    iframe: {
                        method: "get",
                        url: "/jsp/mes/modal/EQ-SEL-M.jsp", 
                        param: "callBack=customEquipSelelctModalCallback&obj"
                    }
                });    	   
            }       
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
    ppmboot
    .call({
        type: "GET",
        url:  ["basic", "detail"],
        data: {mainCd: "ROUT_TYPE",useYn:"Y"},
        callback: function (res) {        		
        	res.list.push({subCd:"",subNm:"전체"});
            this.ROUT_TYPE = res.list;
        }
    })
    .call({
        type: "GET",
        url: ["rout"],
        data: {},
        callback: function (res) {        		
        	res.list.forEach(function (n) {   
    			n.subCd = n.routCd;   
    			n.subNm = n.routNm;
    		});            	
        	res.list.push({subCd:"",subNm:"전체"});
            this.ROUT_CD = res.list;
        }
    })
    .call({
        type: "GET",
        url: ["equip"],
        data: {},
        callback: function (res) {        		
        	res.list.forEach(function (n) {   
    			n.subCd = n.equipCd;   
    			n.subNm = n.equipNm;
    		});            	
        	res.list.push({subCd:"",subNm:"전체"});
            this.EQUIP_CD = res.list;
        }
    })
   /* .call({
        type: "GET",
        url: ["system","print"],
        data: {},
        callback: function (res) {        		
        	res.list.forEach(function (n) {   
    			n.subCd = n.printCd;   
    			n.subNm = n.printNm;
    		});            	
            this.PRINT_CD = res.list;
        }
    })*/
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
            multipleSelect: false,
            sortable: true, 
            multiSort: false,
            showRowSelector:true, 
            multiSort:false,
            lineNumberColumnWidth: 40,
            rowSelectorColumnWidth: 26,
            target: $('[data-ax5grid="grid-view-01"]'),
            columns: [
                {key: "company",label:"회사",width: 100},
                {key: "userCd",label: "아이디",width: 120},
                {key: "userNm",label: "사용자명",width: 120},      
				{key:"routType", label: "공정분류",width:100, align: "center",
        			editor: {type: "select", 
    					config: {columnKeys: {
           	    					optionValue: "subCd", optionText: "subNm"
   	    						}, options: CODE.ROUT_TYPE
    					}
					}, formatter: function formatter() {
		    					return CONVERT_CODE["ROUT_TYPE"].map[this.value];
					},styleClass:"grid-cell-select"
				},	  
				{key:"routCd", label: "공정",width:100, align: "center",
        			editor: {type: "select", 
    					config: {columnKeys: {
           	    					optionValue: "subCd", optionText: "subNm"
   	    						}, options: CODE.ROUT_CD
    					}
					}, formatter: function formatter() {
		    					return CONVERT_CODE["ROUT_CD"].map[this.value];
					},styleClass:"grid-cell-select"
				},	
				/*{key:"printCd", label: "바코드프린터",width:100, align: "center",
        			editor: {type: "select", 
    					config: {columnKeys: {
           	    					optionValue: "subCd", optionText: "subNm"
   	    						}, options: CODE.PRINT_CD
    					}
					}, formatter: function formatter() {
		    					return CONVERT_CODE["PRINT_CD"].map[this.value];
					},styleClass:"grid-cell-select"
				},	*/
                {key: "remark",label: "비고",width: 150,editor: {type: "text"},styleClass: "grid-cell-blue"},            
                {key: "equipAuthYn",align:"center",width: 100, label: "사용설비권한", editor: "checkYn",styleClass: "grid-cell-blue"},         
                {key: "authYn",align:"center", label: "권한적용", editor: "checkYn",styleClass: "grid-cell-blue"},        
            ],
            body: {
                onClick: function () {
                    this.self.select(this.dindex);
                    if(this.column.key == 'company' || this.column.key == 'userCd' || this.column.key == 'userNm'){
                        ACTIONS.dispatch(ACTIONS.ITEM_CLICK, this.item);
                    }
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
                return this.userCd;
            });
        } else {
            list = _list;
        }
        return list;
    },
    align: function () {
        this.target.align();
    },
});

fnObj.gridView02 = ppmboot.viewExtend(ppmboot.gridView, {	
    initView: function () {
        var _this = this;
        this.target = ppmboot.gridBuilder({
            showLineNumber: true,  
            multipleSelect: true,
            sortable: true, 
            multiSort: false,
            showRowSelector:true, 
            lineNumberColumnWidth: 40,
            rowSelectorColumnWidth: 26,
            frozenColumnIndex: 0,
            target: $('[data-ax5grid="grid-view-02"]'),
            columns: [  
                {key: "equipCd", label: "설비코드", width:100, align: "center",formatter:function(){
                 	return this.value;
                }},
                {key: "equipNm", label:"설비명", width: 200, align: "center",formatter:function(){
					return CONVERT_CODE["EQUIP_CD"].map[this.item.equipCd];
                }},
                {key: "sort", label: "정렬", editor: "number",styleClass: "grid-cell-blue"},
                {key: "useYn", label:"사용여부", width: 80, align: "center", editor: "checkYn"},
            ],  
            body: { 
                onClick: function () {
                    this.self.select(this.dindex);
                }
            }
        });
        ppmboot.buttonClick(this, "data-grid-view-02-btn", {
            "item-remove": function () {
                ACTIONS.dispatch(ACTIONS.ITEM_SUB_DEL);
            },
            "equip-all": function () {
           	 	ACTIONS.dispatch(ACTIONS.EQUIP_SELECT_MODAL_OPEN);
            }
        });
        
    },
    getData: function (_type) {
        var list = [];
        var _list = this.target.getList(_type);

        if (_type == "modified" || _type == "deleted") {
            list = ax5.util.filter(_list, function () {
                return this.equipCd;
            });
        } else {
            list = _list;
        }
        return list;
    },
    addRow: function (data) {
        this.target.addRow({__created__: true,userCd:data.userCd,equipCd:data.equipCd,equipNm:data.equipNm,company:data.company,useYn:nvl(data.useYn,"Y"),
        	}, "last");
    }
});

//설비적용
function customEquipSelelctModalCallback(item){
	var data = fnObj.gridView01.getData("selected");
	item.userCd = data[0].userCd;
	fnObj.gridView02.addRow(item);
}