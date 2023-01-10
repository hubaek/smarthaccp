/**
 * 0. Project	: 스마트HACCP CMMS
 * 1. 작성자  		: 스마트HACCP
 * 2. 작성일		: 2020.01.01
 * 3. Comment 	: 검사항목등록
 * 4. 변경이력 : 
 *  			이름		|일자          		|변경내용
 *              ------------------------------------------------------
 *				
 */
var fnObj = {};

//모달 재정의 Start
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
            url:  ["qcManage", "master"],
            data: $.extend({}, getSerializeArrayToJson("#searchView0")),
            callback: function (res) {
                caller.gridView01.setData(res);
                caller.gridView02.setData([]);
                caller.formView01.clear();
            }
        });
        return false;
    },
    PAGE_SAVE: function (caller, act, data) {
    	if (caller.formView01.validate()) {
    		axDialog.confirm({
                msg: "검사항목을 저장 하시겠습니까?"
            }, function () {
                if (this.key == "ok") {
            		var mData = caller.formView01.getData();

            		ppmboot
            		.call({
            			type: "PUT",            
                        url:  ["qcManage", "master"],
        			    data: JSON.stringify([mData]),
        			    callback: function (res) {
        			    }
        			})
        			.done(function () {
        			    axToast.push("저장 되었습니다.");

                        if(nvl(mData.qcCd,'') == ''){
                        	ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
                        }
        			});
                }
            });
	    }    	 
    },
    PAGE_DEL: function (caller, act, data) {
    	if (caller.formView01.validate()) {
    		axDialog.confirm({
                msg: "검사항목을 '삭제' 하시겠습니까?"
            }, function () {
                if (this.key == "ok") {
            		var mData = caller.formView01.getData();

            		ppmboot
            		.call({
            			type: "DELETE",            
                        url:  ["qcManage", "master"],
        			    data: JSON.stringify(mData),
        			    callback: function (res) {
        			    }
        			})
        			.done(function () {
        			    axToast.push("저장 되었습니다.");
        			    ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
        			});
                }
            });
	    }    	 
    },
    ITEM_CLICK: function (caller, act, data) {
        caller.formView01.setData(data);
        ppmboot.ajax({
            type: "GET",
            url:  ["qcManage", "group"],
            data: {company:data.company,qcCd:data.qcCd},
            callback: function (res) {   
                caller.gridView02.setData(res);
            }
        });
    },
    FORM_CLEAR: function (caller, act, data) {
        axDialog.confirm({
            msg: "신규 검사항목을 등록하시겠니까?"
        }, function () {
            if (this.key == "ok") {
                caller.formView01.clear(); 
            	caller.formView01.setDefaultUser(SCRIPT_SESSION);
                caller.gridView02.setData([]);
            }
        });
    },    
    EXCEL_DOWNLOAD: function (caller, act, data) {
    	caller.gridView01.target.exportExcel("INSP000_"+getNowDt()+".xls");
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
    initView: function () {
        this.target = $(document["searchView0"]);
        this.target.attr("onsubmit", "return ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);");
               
        this.target.find('[data-ax5picker="date"]').ax5picker({
            direction: "auto",
            content: {
                type: 'date'
            }
        });
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
        
        this.target.find('[data-ax5picker="date"]').ax5picker({
            direction: "auto",
            content: {
                type: 'date'
            }
        });    

        this.initEvent();

        ppmboot.buttonClick(this, "data-form-view-01-btn", {
            "form-clear": function () {
                ACTIONS.dispatch(ACTIONS.FORM_CLEAR);
            },
        });
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
        this.model.setModel(data);       
        this.modelFormatter.formatting(); // 입력된 값을 포메팅 된 값으로 변경       
    },
    validate: function () {
        var rs = this.model.validate();  
        if (rs.error) {
       	 	axDialog.alert({
                theme: "warning",
                msg: LANG("ax.script.form.validate", rs.error[0].jquery.attr("title"))
            },function(){
                rs.error[0].jquery.focus();
            });
            return false;
        }  
        return true;
    },
    clear: function () {

        if (typeof data === "undefined") data = this.getDefaultData();
        data = $.extend({}, data);        
    	
        this.model.setModel(this.getDefaultData());
    },
    setDefaultUser:function(data){
        this.model.set("inspUserCd", data.userCd);
        this.model.set("inspUserNm", data.userNm);
        this.model.set("inspDeptCd", data.deptCd);
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
            multipleSelect: false,
            lineNumberColumnWidth: 40,
            rowSelectorColumnWidth: 26,
            frozenColumnIndex: 0,
            target: $('[data-ax5grid="grid-view-01"]'),
            columns: [
                {key: "qcCd"},
                {key: "qcNm",label: "검사항목명", width: 180, align: "left"},    
                {key: "qcUnit"},  
                {key: "remark"},
                {key: "qcEquipYn",label: "검사장비", width: 80, align: "center"},      
                {key: "qcRoutYn",label: "공정검사", width: 80, align: "center"},        
                {key: "useYn"},        
                
            ],
            body: {
                onClick: function () {
                    this.self.select(this.dindex);
                    ACTIONS.dispatch(ACTIONS.ITEM_CLICK, this.item);
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
                return this.qcCd;
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

/**
 * gridView02	사용품질그룹
 */
fnObj.gridView02 = ppmboot.viewExtend(ppmboot.gridView, {
    initView: function () {
        var _this = this;
        this.target = ppmboot.gridBuilder({
            showLineNumber: true,
            sortable: true, 
            multiSort:false,
            showRowSelector: false, 
            lineNumberColumnWidth: 40,
            rowSelectorColumnWidth: 28,
            frozenColumnIndex: 0,
            target: $('[data-ax5grid="grid-view-02"]'),
            columns: [  
                {key: "qcGroupCd",label: "검사그룹코드",width:100,align:"center"},
                {key: "qcGroupNm",label: "검사그룹명",width:200,align:"left"},
				{key: "qcType"},   
                {key: "remark"},  
                {key: "useYn"},        
            ],
            body: { 
                onClick: function () {
                }
            }
        });        
    },
});