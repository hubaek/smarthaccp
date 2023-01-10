/**
 * 0. Project	: 스마트HACCP MES
 * 1. 작성자  	: 스마트HACCP_NEW
 * 2. 작성일	: 2020.01.01
 * 3. Comment 	: 메뉴별권한
 * 4. 변경이력 : 
 *  			이름		|일자          		|변경내용
 *              ------------------------------------------------------
 *				
 */
var fnObj = {};
var CODE = {};
var AUTH_GROUP;
var MENU_CD;

var ACTIONS = ppmboot.actionExtend(fnObj, {
    PAGE_SEARCH: function (caller, act, data) {
    	var searchData = getSerializeArrayToJson("#searchView0");
    	ppmboot
        .call({
            type: "GET", 
            url: ["authGroup", "group"],
            data: $.extend({}, getSerializeArrayToJson("#searchView0")),
            callback: function (res) {
                var authGroup = [];
                res.list.forEach(function (n) {
                    authGroup.push({
                    	company: n.company, grpAuthCd: n.grpAuthCd, grpAuthNm: n.grpAuthNm,
                        data: n 
                    });
                });
                AUTH_GROUP = authGroup;
            }
        })
        .call({
            type: "GET", 
            url: ["menu"],
            data: $.extend({}, getSerializeArrayToJson("#searchView0")),
            callback: function (res) {
                caller.treeView01.setData(searchData, res.list, data);
            }
        })
        .done(function () {
            caller.gridView01.setData([]);
        });
        return false;
    },
    PAGE_SAVE: function (caller, act, data) {    	
        ppmboot.ajax({
            type: "PUT",
            url: ["menu", "auth"],
            data: JSON.stringify(caller.gridView01.getData()),
            callback: function (res) {
                axToast.push(LANG("ax.script.menu.authgroup.saved"));
                ACTIONS.dispatch(ACTIONS.SEARCH_AUTH);
            }
        });
    },
    TREEITEM_CLICK: function (caller, act, data) {
    	MENU_CD = data.menuCd;
        ACTIONS.dispatch(ACTIONS.SEARCH_AUTH);
    },
    SEARCH_AUTH: function (caller, act, data) {
        ppmboot.ajax({
            type: "GET",
            url: ["menu", "auth"],
            data: $.extend({menuCd:MENU_CD}, getSerializeArrayToJson("#searchView0")),
            callback: function (res) {
                var list = [];
                if (res.program) {
                	AUTH_GROUP.forEach(function (g) {
                        var item = {
                            company: g.company,
                            grpAuthCd: g.grpAuthCd,
                            grpAuthNm: g.grpAuthNm,
                            useYn: "N",
                            schAh: "N",
                            savAh: "N",
                            exlAh: "N",
                            delAh: "N",
                            fn1Ah: "N",
                            fn2Ah: "N",
                            fn3Ah: "N",
                            fn4Ah: "N",
                            fn5Ah: "N",
                            menuCd: MENU_CD
                        };
                        res.list.forEach(function (n) {
                            if (n.grpAuthCd == item.grpAuthCd) {
                                $.extend(item, {
                                    company: n.company,
                                    useYn: "Y",
                                    schAh: n.schAh || "N",
                                    savAh: n.savAh || "N",
                                    exlAh: n.exlAh || "N",
                                    delAh: n.delAh || "N",
                                    fn1Ah: n.fn1Ah || "N",
                                    fn2Ah: n.fn2Ah || "N",
                                    fn3Ah: n.fn3Ah || "N",
                                    fn4Ah: n.fn4Ah || "N",
                                    fn5Ah: n.fn5Ah || "N"
                                });
                            }
                        });

                        if (res.program) {
                            $.extend(item, {
                                program_schAh: res.program.schAh || "N",
                                program_savAh: res.program.savAh || "N",
                                program_exlAh: res.program.exlAh || "N",
                                program_delAh: res.program.delAh || "N",
                                program_fn1Ah: res.program.fn1Ah || "N",
                                program_fn2Ah: res.program.fn2Ah || "N",
                                program_fn3Ah: res.program.fn3Ah || "N",
                                program_fn4Ah: res.program.fn4Ah || "N",
                                program_fn5Ah: res.program.fn5Ah || "N"
                            });
                        }
                        list.push(item);
                    });
                }
                caller.gridView01.setData(list);
            }
        });
    },
    MENU_AUTH_CLEAR: function (caller, act, data) {
        caller.gridView01.clear();
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
    _this.treeView01.initView();
    _this.gridView01.initView();

    ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
    $("#company").change(function(){ 
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
        this.menuGrpCd = $("#menuGrpCd");
    },
    getData: function () {
        return {
            pageNumber: this.pageNumber,
            pageSize: this.pageSize,
            menuGrpCd: this.menuGrpCd.val()
        }
    }
});

/**
 * treeView
 */
fnObj.treeView01 = ppmboot.viewExtend(ppmboot.treeView, {
    param: {},
    deletedList: [],
    newCount: 0,
    addRootNode: function () {
        var _this = this;
        var nodes = _this.target.zTree.getSelectedNodes();
        var treeNode = nodes[0];
        // root
        treeNode = _this.target.zTree.addNodes(null, {
            id: "_isnew_" + (++_this.newCount),
            pId: 0,
            lv:0,
            name: "New Item",
            menuGrpCd: _this.param.menuGrpCd
        });
        if (treeNode) {
            _this.target.zTree.editName(treeNode[0]);
        }
        fnObj.treeView01.deselectNode();
    },
    initView: function () {
        var _this = this;
        $('[data-tree-view-01-btn]').click(function () {
            var _act = this.getAttribute("data-tree-view-01-btn");
            switch (_act) {
                case "add":
                    break;
                case "delete":
                    break;
            }
        });
        this.target = ppmboot.treeBuilder($('[data-z-tree="tree-view-01"]'), {
            view: {
                dblClickExpand: true,
                addHoverDom: function (treeId, treeNode) {
                    var sObj = $("#" + treeNode.tId + "_span");
                    if (treeNode.editNameFlag || $("#addBtn_" + treeNode.tId).length > 0) return;
                    var addStr = "<span class='button add' id='addBtn_" + treeNode.tId
                        + "' title='add node' onfocus='this.blur();'></span>";
                    var btn = $("#addBtn_" + treeNode.tId);
                    if (btn) {
                        btn.bind("click", function () {
                            _this.target.zTree.addNodes(
                                treeNode,
                                {
                                    id: "_isnew_" + (++_this.newCount),
                                    pId: treeNode.id,
                                    name: "신규 메뉴",
                                    lv:treeNode.level+1,
                                    __created__: true,
                                    menuGrpCd: _this.param.menuGrpCd
                                }
                            );
                            _this.target.zTree.selectNode(treeNode.children[treeNode.children.length - 1]);
                            _this.target.editName();
                            fnObj.treeView01.deselectNode();
                            return false;
                        });
                    }
                },
                removeHoverDom: function (treeId, treeNode) {
                    $("#addBtn_" + treeNode.tId).unbind().remove();
                }
            },
            edit: {
                enable: false,
                editNameSelectAll: true
            },
            callback: {
                beforeDrag: function () {
                    //return false;
                },
                onClick: function (e, treeId, treeNode, isCancel) {
                    ACTIONS.dispatch(ACTIONS.TREEITEM_CLICK, treeNode);
                },
                onRename: function (e, treeId, treeNode, isCancel) {
                    //treeNode.__modified__ = true;
                },
                onRemove: function (e, treeId, treeNode, isCancel) {
                    if (!treeNode.__created__) {
                        treeNode.__deleted__ = true;
                        _this.deletedList.push(treeNode);
                    }
                    fnObj.treeView01.deselectNode();
                }
            }
        }, []);
    },
    setData: function (_searchData, _tree, _data) {
        this.param = $.extend({}, _searchData);
        this.target.setData(_tree);

        if (_data && typeof _data.menuCd !== "undefined") {
            // selectNode
            (function (_tree, _keyName, _key) {
                var nodes = _tree.getNodes();
                var findNode = function (_arr) {
                    var i = _arr.length;
                    while (i--) {
                        if (_arr[i][_keyName] == _key) {
                            _tree.selectNode(_arr[i]);
                        }
                        if (_arr[i].children && _arr[i].children.length > 0) {
                            findNode(_arr[i].children);
                        }
                    }
                };
                findNode(nodes);
            })(this.target.zTree, "menuCd", _data.menuCd);
        }
    },
    getData: function () {
        var _this = this;
        var tree = this.target.getData();

        var convertList = function (_tree) {
            var _newTree = [];
            _tree.forEach(function (n, nidx) {
                var item = {};
                if (n.__created__ || n.__modified__) {
                    item = {
                        __created__: n.__created__,
                        __modified__: n.__modified__,
                        menuCd: n.menuCd,
                        menuGrpCd: _this.param.menuGrpCd,
                        menuNm: n.name,
                        parentCd: n.parentCd,
                        sort: nidx,
                        progCd: n.progCd,
                        lv: n.lv,
                        multiLanguageJson: n.multiLanguageJson,
                    };
                } else {
                    item = {
                        menuCd: n.menuCd,
                        menuGrpCd: n.menuGrpCd,
                        menuNm: n.name,
                        parentCd: n.parentCd,
                        sort: nidx,
                        progCd: n.progCd,
                        lv: n.lv,
                        multiLanguageJson: n.multiLanguageJson,
                    };
                }
                if (n.children && n.children.length) {
                    item.children = convertList(n.children);
                }
                
                _newTree.push(item);
            });
            
            
            return _newTree;
        };
        var newTree = convertList(tree);
        return newTree;
    },
    getDeletedList: function () {
        return this.deletedList;
    },
    clearDeletedList: function () {
        this.deletedList = [];
        return true;
    },
    updateNode: function (data) {
        var treeNodes = this.target.getSelectedNodes();
        if (treeNodes[0]) {
            treeNodes[0].progCd = data.progCd;
        }
    },
    deselectNode: function () {
        ACTIONS.dispatch(ACTIONS.TREEITEM_DESELECTE);
    }
});

/**
 * gridView
 */
fnObj.gridView01 = ppmboot.viewExtend(ppmboot.gridView, {
    initView: function () {
        var _this = this;

        this.target = ppmboot.gridBuilder({
            showLineNumber: false,
            showRowSelector: false,
            frozenColumnIndex: 0,
            target: $('[data-ax5grid="grid-view-01"]'),
            columns: [
                {key: "company"},
                {key: "grpAuthCd", label: COL("ax.admin.menu.auth.group.code"), width: 120, align: "center",formatter:function(){
                	return this.value;
                }},
                {key: "grpAuthNm", label: COL("ax.admin.menu.auth.group.name"), width: 160, align: "left"},
                {key: "useYn", label: "사용", width: 50, editor: "checkYn"},
                {key: "schAh", label: COL("ax.admin.menu.auth.inquery"), width: 50, align: "center", editor: "menu-program-auth-checkYn"},
                {key: "savAh", label: COL("ax.admin.menu.auth.save"), width: 50, align: "center", editor: "menu-program-auth-checkYn"},
                {key: "exlAh", label: COL("ax.admin.menu.auth.excel"), width: 50, align: "center", editor: "menu-program-auth-checkYn"},
                {key: "delAh", label: COL("ax.admin.menu.auth.delete"), width: 50, align: "center", editor: "menu-program-auth-checkYn"},
                {key: "fn1Ah", label: "FN1", width: 50, align: "center", editor: "menu-program-auth-checkYn"},
                {key: "fn2Ah", label: "FN2", width: 50, align: "center", editor: "menu-program-auth-checkYn"},
                {key: "fn3Ah", label: "FN3", width: 50, align: "center", editor: "menu-program-auth-checkYn"},
                {key: "fn4Ah", label: "FN4", width: 50, align: "center", editor: "menu-program-auth-checkYn"},
                {key: "fn5Ah", label: "FN5", width: 50, align: "center", editor: "menu-program-auth-checkYn"}
            ],
            body: {
                onClick: function () {
                    // this.self.select(this.dindex);
                }
            }
        });

        ppmboot.buttonClick(this, "data-grid-view-01-btn", {
            "add": function () {
                ACTIONS.dispatch(ACTIONS.ITEM_ADD);
            },
            "delete": function () {
                ACTIONS.dispatch(ACTIONS.ITEM_DEL);
            }
        });
    },
    getData: function (_type) {
        var list = [];
        var _list = this.target.getList(_type);

        if (_type == "modified" || _type == "deleted") {
            list = ax5.util.filter(_list, function () {
                return this.progNm && this.progPh;
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