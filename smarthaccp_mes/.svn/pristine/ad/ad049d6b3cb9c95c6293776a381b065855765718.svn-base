/**
 * 0. Project	: 스마트HACCP MES
 * 1. 작성자  	: 스마트HACCP_NEW
 * 2. 작성일		: 2020.01.01
 * 3. Comment 	: 사용자로그관리
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
            url: ["userLogs"],
            data: $.extend({}, getSerializeArrayToJson("#searchView0")),
            callback: function (res) {
                caller.gridView01.setData(res);
            }
        });
        return false;
    },
    ITEM_CLICK: function (caller, act, data) {
        caller.formView01.setData(data);
    },
    ITEM_REMOVE: function (caller, act, data) {
        var delete_queue = caller.gridView01.getData("selected");
        if (delete_queue.length == 0) {
            alert("삭제할 목록을 선택해주세요");
            return;
        }
        if (!confirm("정말 삭제하시겠습니까?")) return;
        var delQueue = function () {
            var pars;
            if (pars = delete_queue.shift()) {
                ppmboot.ajax({
                    type: "DELETE",
                    url: ["userLogs", pars.id],
                    data: "",
                    callback: function (res) {
                        delQueue();
                    },
                    options: {
                        onError: function (err) {
                            alert("삭제작업에 실패하였습니다.");
                            ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
                        }
                    }
                });
            } else {
                axToast.push("삭제 처리 되었습니다.");
                ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
            }
        };
        delQueue();
    },
    ITEM_REMOVEALL: function (caller, act, data) {
        if (!confirm("정말 삭제하시겠습니까?")) return;
        
        ppmboot.ajax({
            type: "DELETE",
            url: ["userLogs", "events/all"],
            data: "",
            callback: function (res) {
                axToast.push("삭제 처리 되었습니다.");
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
    this.pageButtonView.initView();
    this.searchView.initView();
    this.gridView01.initView();
    this.formView01.initView();

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
        this.filter = $("#filter");
    },
    getData: function () {
        return {
            filter: this.filter.val(),
            sort: "id,desc"
        }
    }
});

/**
 * gridView
 */
fnObj.gridView01 = ppmboot.viewExtend(ppmboot.gridView, {
    page: {
        pageNumber: 0,
        pageSize: 20
    },
    initView: function () {
        var _this = this;
        this.target = ppmboot.gridBuilder({
            showRowSelector: true,
            frozenColumnIndex: 0,
            multipleSelect: true,
            target: $('[data-ax5grid="grid-view-01"]'),
            columns: [
                {key: "id", label: "ID", width: 100, align: "center"},
                {key: "phase", label: "Phase", width: 100, align: "center"},
                {key: "system", label: "System", width: 100, align: "center"},
                {key: "serverName", label: "Server Name", width: 100, align: "center"},
                {key: "hostName", label: "Host Name", width: 100, align: "center"},
                {key: "userCd", label:"USER CD", width: 100},
                {key: "programCode", label: "Program Code", width: 280, align: "left"},
                {key: "programNm", label: "Program Name", width: 280, align: "left"},
                {key: "programAction", label: "Program Action", width: 200, align: "left"},
                {
                    key: "errorDatetime", label: "Time", width: 255, align: "center", formatter: function () {
                    return ax5.util.date(new Date(this.value || ""), {"return": 'yyyy/MM/dd hh:mm:ss'});
                }
                },
            ],
            body: {
                onClick: function () {
                    this.self.select(this.dindex, {selectedClear: true});
                    ACTIONS.dispatch(ACTIONS.ITEM_CLICK, this.list[this.dindex]);
                }
            },
            onPageChange: function (pageNumber) {
                _this.setPageData({pageNumber: pageNumber});
                ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
            }
        });

        ppmboot.buttonClick(this, "data-grid-view-01-btn", {
            "remove": function () {
                ACTIONS.dispatch(ACTIONS.ITEM_REMOVE);
            },
            "removeAll": function () {
                ACTIONS.dispatch(ACTIONS.ITEM_REMOVEALL);
            }
        });
    },
    getData: function (_type) {
        var list = [];
        var _list = this.target.getList();
        if (_type == "selected") {
            list = ax5.util.filter(_list, function () {
                return this.__selected__;
            });
        } else {
            list = _list;
        }
        return list;
    },
    addRow: function () {
        this.target.addRow({__created__: true, useYn: "N"}, "last");
    }
});

/**
 * formView01
 */
fnObj.formView01 = ppmboot.viewExtend(ppmboot.formView, {
    getDefaultData: function () {
        return {
            trace: ""
        };
    },
    initView: function () {
        this.target = $("#formView01");
        this.model = new ax5.ui.binder();
        this.model.setModel(this.getDefaultData(), this.target);
        this.modelFormatter = new ppmboot.modelFormatter(this.model); // 모델 포메터 시작
        this.initEvent();
        this.prettify();
    },
    initEvent: function () {

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
        this.prettify();
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
    },
    prettify: function () {
        this.target.find(".for-prettify").each(function () {
            var $this = $(this);
            var path = $this.attr("data-ax-path");

            var po = [];

            if (path == "parameterMap" || path == "headerMap" || path == "userInfo") {
                po.push('<pre class="prettyprint linenums lang-js" style="margin:0;">');
                try {
                    po.push(JSON.stringify(JSON.parse($this.text()), null, '    '));
                } catch (e) {

                }
            } else {
                po.push('<pre class="prettyprint linenums" style="margin:0;">');
                po.push($this.html());
            }
            po.push('</pre>');
            $this.html(po.join(''));
        });
        if (window["prettyPrint"]) window["prettyPrint"]();
    }
});
