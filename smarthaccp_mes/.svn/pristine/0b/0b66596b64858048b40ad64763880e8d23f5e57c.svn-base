/**
 * 0. Project	: SMART HACCP
 * 1. 작성자  	: 김회재
 * 2. 작성일		: 2020.06.01
 * 3. Comment 	: HACCP 공통코드 관리
 * 4. 변경이력 : 
 *  			이름		|일자          		|변경내용
 *              ------------------------------------------------------
 *				
 */
var fnObj = {};
var ACTIONS = ppmboot.actionExtend(fnObj, {
    PAGE_SEARCH: function (caller, act, data) {
        ppmboot.ajax({
            type: "GET",
            url: ["haccp", "master"],
            data: $.extend({}, getSerializeArrayToJson("#searchView0")),
            callback: function (res) {            	
                caller.gridView01.setData(res);
            }
        });
        return false;
    },
    
    PAGE_SAVE: function (caller, act, data) {
        if (caller.formView01.validate()) {
            var mData = caller.formView01.getData();
            var dData = [].concat(caller.gridView02.getData("modified"));
            dData = dData.concat(caller.gridView02.getData("deleted"));
            
            mData.company = '1000';
            dData.forEach(function (n) {
                n.company = mData.company;
                n.templateId = mData.templateId;
                n.startDate = mData.startDate;
            });
            
            ppmboot
                .call({
                    type: "PUT", url: ["haccp", "master"], data: JSON.stringify([mData]),
                    callback: function (res) {                    	
                    }
                })
                .call({
                    type: "PUT", url: ["dailyreport", "saveTemplate"], data: JSON.stringify(dData),
                    callback: function (res) {
                    }
                })
                .done(function () {
                    axToast.push("저장 되었습니다.");
                    ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
                });
        }

    },
    ITEM_ADD: function (caller, act, data) {
        axDialog.confirm({
            msg: LANG("ax.script.form.clearconfirm")
        }, function () {
            if (this.key == "ok") {
                caller.formView01.clear();
                caller.gridView02.clear();
            }
        });
    },
    ITEM_CLICK: function (caller, act, data) {
    	/*caller.formView01.setData(data);
        ppmboot.ajax({
            type: "GET",
            url:  ["haccp", "detail"],
            data: "mainCode=" + data.mainCode+"&company="+data.company,
            callback: function (res) {
                caller.gridView02.setData(res);
            }
        });*/
        ppmboot
    	.call({
            type: "GET",
            url: ["dailyreport", "recentlyTemplate"],
            data: {company: $("#company").val(), templateId:data.templateId},
            callback: function (res) {
            	var startDate = res.map.recentlyTemplate.startDate;
            	data.startDate = startDate;
            	
            	caller.formView01.setData(data);
            	
            	ppmboot
            	.call({
            		type:"GET",
            		url: ["dailyreport", "template"],
            		data: {
            			company: $("#company").val(), 
            			templateId:data.templateId,
            			startDate:startDate,
            			//typeCd:"D"
            		},
	            	callback:function (res){
	            		caller.gridView02.setData(res);
	            	}
            })
            .done(function(){
            });
            }
        })
    	.done(function () {
        });
    },
    ITEM_SUB_ADD: function (caller, act, data) {
    	caller.gridView02.addRow();
    },
    ITEM_SUB_DEL: function (caller, act, data) {
        caller.gridView02.delRow("selected");
    },
  
    //출력창 띄우기
	VIEW_FORM: function (caller, act, data) {
		//alert("프린트준비중"); return;
		var dlist = caller.gridView01.getData("selected");
		if(dlist.length == 0 ){//  선택된 값 없을시 실행 x
			return false;
		}
    	
		
		for(var i in dlist){
			dlist[i]["reportFile"] ="kim_test1.jrxml";
		 }
		 
		 console.log(dlist);
		 
		 if (dlist.length==0){
            alert("출력할 항목을 선택해 주세요");
            return;
        }
        
        
        var _ua = navigator.userAgent;
        
        //IE 11인 경우 예외 처리 (Window.open으로 처리)
        var trident = _ua.match(/Trident\/(\d.\d)/i);
        if( trident != null )
        {
            if( trident[1] == "7.0" )  {
            	window.open("about:blank","reportPop", "width=900, height=700, scrollbars=yes");
                var formsend =new cmm.uiUtil.PostSend("sendform","reportPop");
                // formsend.add("path", "/views/popup/reportView");
                formsend.addPWithMap({"paramList":dlist});
                formsend.send("/report/view_report");
            	
            }else{
            	parent.getReportPopup({"paramList":dlist});
            }
        }else{
        	parent.getReportPopup({"paramList":dlist});
        }
		 
        
        ppmboot.ajax({
            type: "GET",
            url: ["item"],
            data: $.extend({}, getSerializeArrayToJson("#searchView0")),
            callback: function (res) {   
                caller.gridView01.setData(res);
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
    _this.formView01.initView();
    _this.gridView01.initView();
    _this.gridView02.initView();

    ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
    
    console.log(SCRIPT_SESSION);
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
        
        this.target.find('[data-ax5picker="date"]').ax5picker({
            direction: "auto",
            content: {
                type: 'date'
            }
        });   
        
        ppmboot.buttonClick(this, "data-form-view-01-btn", {
            "form-clear": function () {
                ACTIONS.dispatch(ACTIONS.ITEM_ADD);
            },
            "form-print": function () {
        		ACTIONS.dispatch(ACTIONS.VIEW_FORM);
            }
        
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

        this.target.find('[data-ax-path="templateId"]').attr("readonly", "readonly");
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
        this.target.find('[data-ax-path="templateId"]').removeAttr("readonly");
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
            showRowSelector: false,
            multipleSelect: false,
            lineNumberColumnWidth: 40,
            rowSelectorColumnWidth: 26,
            frozenColumnIndex: 0,
            target: $('[data-ax5grid="grid-view-01"]'),
            columns: [
                {key: "templateId", label: "점검일지코드", width: "*", align: "center"},
                {key: "templateNm", label: "점검일지명", width: 200, align: "left"},
                //{key: "useYn"}
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
                return this.templateId;
            });
        } else {
            list = _list;
        }
        return list;
    },
});

/**
 * gridView02
 */
fnObj.gridView02 = ppmboot.viewExtend(ppmboot.gridView, {

    initView: function () {
        var _this = this;
        this.target = ppmboot.gridBuilder({
            showLineNumber: false,
            sortable: true, 
            //multiSort: false,
            showRowSelector: true,
            multipleSelect: false,
            lineNumberColumnWidth: 40,
            rowSelectorColumnWidth: 26,
            frozenColumnIndex: 0,
            target: $('[data-ax5grid="grid-view-02"]'),
            columns: [
                {key: "startDate", hidden: true},
                {key: "dSeq", hidden: true},
                {key: "typeCd", hidden: true},
                {key: "ditem001", label: "item001", width: 150, align: "left", editor: "text",styleClass: "grid-cell-blue"},  
                {key: "ditem002", label: "item002", width: "*", align: "left", editor: {type: "textarea"}, styleClass: "grid-cell-blue"}
                /*{key: "ditem002", label: "item002", width: "*", align: "left", editor: {type: "textarea"}, styleClass: "grid-cell-blue", multiLine:true, formatter:function formatter() {
                    return this.value.replace(/\r\n/gi,"<br/>");
            	}}*/
                //{key: "ditem003", label: "item003", width: 150, align: "left", editor: "text",styleClass: "grid-cell-blue"},  
            ],
            body: {
                onClick: function () {
                }
            }
        });
        ppmboot.buttonClick(this, "data-grid-view-02-btn", {
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
            	list.push(this.company);
            	list.push(this.templateId);
            	list.push(this.startDate);
                return list;
            });
        } else {
            list = _list;
        }
        return list;
    },
    align: function () {
        this.target.align();
    },
    addRow: function () {    	
    	let seq = (this.target.getList(getLastDt).length)+1
        this.target.addRow({__created__: true,d_seq: seq}, "last");
    }
});