/**
 * 0. Project	: 스마트HACCP MES
 * 1. 작성자  	: 스마트HACCP_NEW
 * 2. 작성일	: 2020.01.01
 * 3. Comment 	: COMPANY 관리
 * 4. 변경이력 : 
 *  			이름		|일자          		|변경내용
 *              ------------------------------------------------------
 *				
 */
var fnObj = {}
var ACTIONS = ppmboot.actionExtend(fnObj, {
    PAGE_SEARCH: function (caller, act, data) {
        ppmboot.ajax({
            type: "GET",
            url: ["company","company"],
            data: $.extend({}, getSerializeArrayToJson("#searchView0")),
            callback: function (res) {            	
                caller.gridView01.setData(res);
            }
        }); 

        return false;
    },
    PAGE_CLEAR: function (caller, act, data) {
        return false;
    },
    PAGE_SAVE: function (caller, act, data) {
        if (caller.formView01.validate()) {
            var mData = caller.formView01.getData();
            if(document.formView01.consent.checked){
            	mData.consent = "Y";            	
            }else{
            	mData.consent = "N";
            }
            ppmboot
            .call({
                type: "PUT", 
                url: ["company","company"],
                data: JSON.stringify(mData),
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
    	if(data.consent == "Y"){
    		$("input:checkbox[name='consent']").prop("checked", true);
    	}else{
    		$("input:checkbox[name='consent']").prop("checked", false);
    	}
        caller.formView01.setData(data);
    },
    FORM_CLEAR: function (caller, act, data) {
        axDialog.confirm({
            msg: LANG("ax.script.form.clearconfirm")
        }, function () {
            if (this.key == "ok") {
            	$("input:checkbox[name='consent']").prop("checked", false); 
                caller.formView01.clear();
            }
        });
    },    
    ETC1FIND: function (caller, act, data) {
        ppmboot.modal2.open({
            modalType: "ZIPCODE",
            param: "",
            header:{title: LANG("ax.script.address.finder.title")},
            sendData: function(){
                return {};
            },
            callback: function (data) {
                caller.formView01.setEtc1Value({
                    zipcode: data.zipcode, roadAddress: data.roadAddress, jibunAddress: data.jibunAddress
                });
                this.close();
            }
        });
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
    _this.gridView01.initView();
    _this.formView01.initView();

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
            "clear": function () {
                ACTIONS.dispatch(ACTIONS.PAGE_CLEAR);
            },
            "save": function () {
                ACTIONS.dispatch(ACTIONS.PAGE_SAVE);
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
            "etc1find": function () {
                ACTIONS.dispatch(ACTIONS.ETC1FIND);
            },
            "form-clear": function () {
                ACTIONS.dispatch(ACTIONS.FORM_CLEAR);
            }
        });
        //관리자만 회사등록가능
        if(SCRIPT_SESSION.details.menuGrpCd != 'SYSTEM_MANAGER'){
        	//$("#form-clear").hide();
        }
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
        this.target.find('[data-ax-path="company"]').attr("readonly", "readonly");
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
        this.model.setModel(this.getDefaultData());
        this.target.find('[data-ax-path="company"]').removeAttr("readonly");
    },
    setEtc1Value: function (data) {
        this.model.set("address1", data.zipcode);
        this.model.set("address2", data.roadAddress);
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
            multiSort:false,
            lineNumberColumnWidth: 40,
            rowSelectorColumnWidth: 26,
            frozenColumnIndex: 0,
            target: $('[data-ax5grid="grid-view-01"]'),
            columns: [
                {key: "company", label: "회사코드", width: 100, align: "center",formatter: function formatter() {
                    return this.value;
                }},
                {key: "companyNm", label: "회사명", width: 180, align: "center"},
                {key: "businessNo", label: "사업자번호", width: 150, align: "center"},
                {key: "ceoNm", label: "대표자명", width: 150, align: "center"},
                {key: "useYn", label: "사용여부", width: 100, align: "center"}
            ],
            body: {
                onClick: function () {
                    this.self.select(this.dindex);
                    ACTIONS.dispatch(ACTIONS.ITEM_CLICK, this.item);
                }
            },
        });
    },
    getData: function (_type) {
        var list = [];
        var _list = this.target.getList(_type);

        if (_type == "modified" || _type == "deleted") {
            list = ax5.util.filter(_list, function () {
                return this.mainCd;
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