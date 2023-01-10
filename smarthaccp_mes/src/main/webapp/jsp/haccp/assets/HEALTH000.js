/**
 * 0. Project	: 
 * 1. 작성자  	: 
 * 2. 작성일		: 
 * 3. Comment 	: 보건증관리
 * 4. 변경이력 : 
 *  			이름		|일자          		|변경내용
 *              ------------------------------------------------------
 *				
 */

var fnObj = {};
var MODAL_NAME = "HEALTH000M";
var idx = 0;
var ACTIONS = ppmboot.actionExtend(fnObj, {
    PAGE_SEARCH: function (caller, act, data) {
        ppmboot.ajax({
            type: "GET",
            url: ["users", "userList"],
            data: $.extend({}, getSerializeArrayToJson("#searchView0")),
            callback: function (res) {            	
            	for(var i = 0; i < res.list.length; i++){
            		if(res.list[i].remainDt != undefined || res.list[i].remainDt != ""){
            			res.list[i].remainDt = Number(res.list[i].remainDt);
            		}
            	}
                caller.gridView01.setData(res);
                //caller.gridView02.setData([]);
                ACTIONS.dispatch(ACTIONS.ITEM_CLICK, res.list[idx]);
            }
        });
        return false;
    },
    ITEM_CLICK: function (caller, act, data) {
        
        ppmboot.ajax({
            type: "GET",
            url: ["/api/v1/health"],
            data:{userCd:data.userCd},
            callback: function (res) {
                caller.gridView02.setData(res);
            }
        });
    },
    // 신규 작성
	ADD_FORM : function(caller, act, data) {
		var list = caller.gridView01.getData("selected");
		var list2 = caller.gridView02.getData();
		
		if (list.length != 1) {
			axDialog.alert({
				theme : "primary",
				msg : "대상을 선택하세요."
			});
			return;
		}
		
		var seq = 1;
		seq += list2.length;
		var userKey = list[0].userCd + "-" + seq;
		
		ppmboot.modal.open({
			modalType : MODAL_NAME,
			param : "",
			sendData : function() {
				return {
					"mode" : "add",
					"userCd" : list[0].userCd,
					"userNm" : list[0].userNm,
					"userKey" : userKey
				};
			},
			callback : function(data) {
				ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
			}
		});
	},
	// 수정
	MOD_FORM : function(caller, act, data) {
		var list = caller.gridView02.getData("selected");
		if (list.length != 1) {
			axDialog.alert({
				theme : "primary",
				msg : "대상을 선택하세요."
			});
			return false;
		} else {
			ppmboot.modal.open({
				modalType : MODAL_NAME,
				param : "",
				sendData : function() {
					return {
						"mode" : "mod",
						"userCd" : list[0].userCd,
						"healthCardSeq" : list[0].healthCardSeq,
						"userKey" : list[0].userKey,
					};
				},
				callback : function(data) {
					ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
				}
			});
		}
	},
	// 조회
	VIEW_FORM : function(caller, act, data) {
		var list = caller.gridView02.getData("selected");
		ppmboot.modal.open({
			modalType : MODAL_NAME,
			param : "",
			sendData : function() {
				return {
					"mode" : "view",
					"userCd" : list[0].userCd,
					"healthCardSeq" : list[0].healthCardSeq,
				};
			},
			callback : function(data) {
				ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
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

    _this.pageButtonView.initView();
    _this.searchView.initView();
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
            multipleSelect: false,
            lineNumberColumnWidth: 40,
            rowSelectorColumnWidth: 26,
            frozenColumnIndex: 0,
            target: $('[data-ax5grid="grid-view-01"]'),
            columns: [
            	{key: "userNm", label:"대상자", align:"center"},
            	{key: "userCd", width:120},
                {key: "hpNo"	, label:"전화번호", width:120},
                {key: "remainDt", label:"잔여일", width:"*", align:"right"}
            ],
            body: {
                onClick: function () {
                	idx = this.dindex;
                	this.self.select(this.dindex);
                    ACTIONS.dispatch(ACTIONS.ITEM_CLICK, this.item);
                }
            }
        });
        
        ppmboot.buttonClick(this, "data-grid-view-01-btn", {
        	"btn-reg": function () {
                ACTIONS.dispatch(ACTIONS.ADD_FORM);
            },
        });
    },
    getData: function (_type) {
        var list = [];
        var _list = this.target.getList(_type);

        if (_type == "modified" || _type == "deleted") {
            list = ax5.util.filter(_list, function () {
                return this.itemMainCd;
            });
        } else {
            list = _list;
        }
        return list;
    },
    addRow: function () {
        this.target.addRow({__created__: true}, "last");
    }
});


/**
 * gridView02
 */
fnObj.gridView02 = ppmboot.viewExtend(ppmboot.gridView, {

    initView: function () {
        var _this = this;
        this.target = ppmboot.gridBuilder({
            showLineNumber: true,
            sortable: true, 
            multiSort: false,
            showRowSelector: true,
            multipleSelect: false,
            lineNumberColumnWidth: 40,
            rowSelectorColumnWidth: 26,
            target: $('[data-ax5grid="grid-view-02"]'),
            columns: [
            	{key: "userNm", label:"직원명", align:"center"},
            	{key: "healthCardNo", label: "보건증번호", width: 150, align: "center"
            		, formatter : function() { return "<font style='cursor:pointer'><u>"+ nvl(this.value, '') + "</u></font>"; }
                },
                {key: "healthCardStartDt", label: "유효시작일", width: 150, align: "center"},      
                {key: "healthCardEndDt", label: "유효종료일", width: 150, align: "center"},  
                {key: "remark", label: "비고", width: 200, align: "left"},
            ],
            body: {
                onClick: function () {
                    this.self.select(this.dindex);
                    if (this.column.key == "healthCardNo") {
						ACTIONS.dispatch(ACTIONS.VIEW_FORM, this.item);
					}
                }
            }
        });
        ppmboot.buttonClick(this, "data-grid-view-02-btn", {
            "btn-mod": function () {
                ACTIONS.dispatch(ACTIONS.MOD_FORM);
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
                return nvl(this.itemSubCd,randomStringCd(20));
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