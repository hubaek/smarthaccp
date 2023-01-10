/**
 * 0. Project	: 스마트HACCP MES
 * 1. 작성자  	: 스마트HACCP_NEW
 * 2. 작성일	: 2020.01.01
 * 3. Comment 	: 메뉴관리
 * 4. 변경이력 : 
 *  			이름		|일자          		|변경내용
 *              ------------------------------------------------------
 *				
 */
var fnObj = {};
var CODE = {};
var AUTH_GROUP;

var ACTIONS = ppmboot.actionExtend(fnObj, {
    PAGE_SEARCH: function (caller, act, data) {
        var searchData = caller.searchView.getData();
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
            	
            	console.log(res.list);
                caller.treeView01.setData(searchData, res.list, data);
            }
        })
        .done(function () {
            caller.gridView01.setData([]);
        });
        return false;
    },
    PAGE_SAVE: function (caller, act, data) {
        var formData = caller.formView01.getData();
        var menus = caller.treeView01.getData();
        menus = setMenuSeq(menus);
        var obj = {
        	menuList: menus,
            deletedList: caller.treeView01.getDeletedList()
        };
        ppmboot.ajax({
        	 type: "PUT",
             url: ["menu"],
             data: JSON.stringify(obj),
             callback: function (res) {
                 caller.treeView01.clearDeletedList();
                 axToast.push(LANG("ax.script.menu.category.saved"));
                 ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
             }
        });
        if (typeof formData.menuCd != "undefined") {
        	ppmboot.ajax({
        		type: "PUT",
                url: ["menu", formData.menuCd],
                data: JSON.stringify(formData),
                callback: function (res) {
                	ACTIONS.dispatch(ACTIONS.PAGE_SEARCH, {menuCd: formData.menuCd});

                    if (formData.progCd) {
                    	
                    	var dData = caller.gridView01.getData();
                    	
                    	dData.forEach(function (n) {
                    		n.modalCd = formData.modalCd;
                        });
                    	
                        ppmboot.ajax({
                            type: "PUT",
                            url: ["menu", "auth"],
                            data: JSON.stringify(dData),
                            callback: function (res) {
                                axToast.push(LANG("ax.script.menu.authgroup.saved"));
                                ACTIONS.dispatch(ACTIONS.SEARCH_AUTH, {menuCd: formData.menuCd});
                            }
                        });
                    }
                }
           });
        } 
    },
    TREEITEM_CLICK: function (caller, act, data) {
        if (typeof data.menuCd === "undefined") {
            caller.formView01.clear();
            if (confirm(LANG("ax.script.menu.save.confirm"))) {
                ACTIONS.dispatch(ACTIONS.PAGE_SAVE);
            }
            return;
        }
        ppmboot.ajax({
            type: "GET",
            url: ["menu", data.menuCd],
            data: {},
            callback: function (res) {
                caller.formView01.setData(res);
            }
        });
    },
    TREEITEM_DESELECTE: function (caller, act, data) {
        caller.formView01.clear();
    },
    TREE_ROOTNODE_ADD: function (caller, act, data) {
        caller.treeView01.addRootNode();
    },
    SELECT_PROG: function (caller, act, data) {
        caller.treeView01.updateNode(data);

        var _data = caller.formView01.getData();
        var obj = {
            menuList: caller.treeView01.getData(),
            deletedList: caller.treeView01.getDeletedList()
        };
        var searchData = caller.searchView.getData();
        ppmboot
            .call({
                type: "PUT",
                url: ["menu"],
                data: JSON.stringify(obj),
                callback: function (res) {
                    caller.treeView01.clearDeletedList();
                    axToast.push(LANG("ax.script.menu.category.saved"));
                }
            })
            .call({
                type: "GET",
                url: ["menu"],
                data: searchData,
                callback: function (res) {
                    caller.treeView01.setData(searchData, res.list);
                }
            })
            .done(function () {
                ACTIONS.dispatch(ACTIONS.SEARCH_AUTH, {menuCd: _data.menuCd});
            });
    },
    SEARCH_AUTH: function (caller, act, data) {
        ppmboot.ajax({
            type: "GET",
            url: ["menu", "auth"],
            data: data,
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
                            creAh: "N",
                            modAh: "N",
                            fn1Ah: "N",
                            fn2Ah: "N",
                            fn3Ah: "N",
                            fn4Ah: "N",
                            fn5Ah: "N",
                            menuCd: data.menuCd
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
                                    creAh: n.creAh || "N",
                                    modAh: n.modAh || "N",
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
                                program_creAh: res.program.creAh || "N",
                                program_creAh: res.program.creAh || "N",
                                program_modAh: res.program.modAh || "N",
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
            // 직접코딩
            return false;
        }
    }
});

fnObj.pageStart = function () {
    var _this = this;
    ppmboot
        .call({
            type: "GET", url: "/api/v1/programs", data: "",
            callback: function (res) {
                var programList = [];
                res.list.forEach(function (n) {
                    programList.push({
                        value: n.progCd, text: n.progNm + "(" + n.progCd + ")",
                        progCd: n.progCd, progNm: n.progNm,
                        data: n
                    });
                });
                this.programList = programList;
            }
        })
        .done(function () {
            CODE = this; // this는 call을 통해 수집된 데이터들.

            _this.pageButtonView.initView();
            _this.searchView.initView();
            _this.treeView01.initView();
            _this.formView01.initView();
            _this.gridView01.initView();

            ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
            

            $("#company").change(function(){ 
            	ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
            }); 

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
            //__created__: true,
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
                    ACTIONS.dispatch(ACTIONS.TREE_ROOTNODE_ADD);
                    break;
                case "delete":
                    //ACTIONS.dispatch(ACTIONS.ITEM_DEL);
                    break;
            }
        });

        this.target = ppmboot.treeBuilder($('[data-z-tree="tree-view-01"]'), {
            view: {
                dblClickExpand: false,
                addHoverDom: function (treeId, treeNode) {

                    var sObj = $("#" + treeNode.tId + "_span");
                    if (treeNode.editNameFlag || $("#addBtn_" + treeNode.tId).length > 0) return;
                    var addStr = "<span class='button add' id='addBtn_" + treeNode.tId
                        + "' title='add node' onfocus='this.blur();'></span>";
                    sObj.after(addStr);
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
                enable: true,
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
                        iconNm:n.iconNm,
                        paramUrl:n.paramUrl,
                        menuCd:n.menuCd,
                        modalCd:n.modalCd
                    };
                } else {
                    item = {
                        menuCd: n.menuCd,
                        menuGrpCd: n.menuGrpCd,
                        menuNm: n.name,
                        parentCd: n.parentCd,
                        sort: nidx,
                        progCd: n.progCd,
                        lv: n.level,
                        multiLanguageJson: n.multiLanguageJson,
                        iconNm:n.iconNm,
                        paramUrl:n.paramUrl,
                        menuCd:n.menuCd,
                        modalCd:n.modalCd,
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
 * formView01
 */
fnObj.formView01 = ppmboot.viewExtend(ppmboot.formView, {
    getDefaultData: function () {
        return $.extend({}, ppmboot.formView.defaultData, {
            multiLanguageJson: {
                ko: "", en: "", zh: ""
            }
        });
    },
    initView: function () {
        var _this = this;
        this.programList = CODE.programList;

        this.target = $("#formView01");
        this.model = new ax5.ui.binder();
        this.model.setModel(this.getDefaultData(), this.target);
        this.modelFormatter = new ppmboot.modelFormatter(this.model); // 모델 포메터 시작
        
        this.mask = new ax5.ui.mask({
            theme: "form-mask",
            target: $('#split-panel-form'),
            content: COL("ax.admin.menu.form.d1")
        });
        
        this.mask.open();

        this.initEvent();

        ppmboot.buttonClick(this, "data-form-view-01-btn", {
            "form-clear": function () {
                ACTIONS.dispatch(ACTIONS.FORM_CLEAR);
            }
        });

        this.combobox = $('[data-ax5combobox]').ax5combobox({
            options: this.programList,
            onExpand: function (callBack) {
                ppmboot
                    .ajax({
                        type: "GET", url: "/api/v1/programs", data: "",
                        callback: function (res) {
                            var programList = [];
                            res.list.forEach(function (n) {
                                programList.push({
                                    value: n.progCd, text: n.progNm + "(" + n.progCd + ")",
                                    progCd: n.progCd, progNm: n.progNm,
                                    data: n
                                });
                            });

                            _this.programList = programList;
                            callBack({
                                options: programList
                            });
                        }, options: {nomask: true}
                    });
            },
            onChange: function () {
                if (this.value[0]) {
                    _this.model.set("progCd", this.value[0].progCd);
                    _this.model.set("progNm", this.value[0].progNm);

                    ACTIONS.dispatch(ACTIONS.MENU_AUTH_CLEAR);
                    ACTIONS.dispatch(ACTIONS.SELECT_PROG, this.value[0]);
                } else {
                    if (_this.model.get("progCd")) {
                        _this.model.set("progCd", "");
                        _this.model.set("progNm", "");
                        _this.combobox.ax5combobox("close");

                        ACTIONS.dispatch(ACTIONS.SELECT_PROG, "");
                        ACTIONS.dispatch(ACTIONS.MENU_AUTH_CLEAR);
                    }
                }
            }
        });
    },
    initEvent: function () {
        var _this = this;
    },
    getData: function () {
        var data = this.modelFormatter.getClearData(this.model.get()); // 모델의 값을 포멧팅 전 값으로 치환.
        return data;
    },
    setData: function (data) {
        this.mask.close();
        var _data = this.getDefaultData();
        this.combobox.ax5combobox("setValue", []);

        ACTIONS.dispatch(ACTIONS.MENU_AUTH_CLEAR);
        _data.menuCd = data.menuCd;
        if (data.progCd) {
            var progIndex = ax5.util.search(this.programList, function () {
                return this.progCd == data.progCd;
            });
            var prog = this.programList[progIndex];

            _data.progCd = prog.progCd;
            _data.progNm = prog.progNm;

            this.combobox.ax5combobox("setValue", _data.progCd);
            ACTIONS.dispatch(ACTIONS.SEARCH_AUTH, {menuCd: data.menuCd});
        }

        if (!data.multiLanguageJson) {
            _data.multiLanguageJson = {
                ko: data.name,
                en: data.name,
                zh: data.name
            }
        }else{
            _data.multiLanguageJson = data.multiLanguageJson;
        }
        
        _data.paramUrl = data.paramUrl;
        _data.iconNm = data.iconNm;
        _data.menuCd = data.menuCd;
        _data.modalCd = data.modalCd;
        
        this.model.setModel(_data);
        this.modelFormatter.formatting(); // 입력된 값을 포메팅 된 값으로 변경
    },
    clear: function () {
        this.mask.open();
        this.model.setModel(this.getDefaultData());
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
                {key: "company",formatter:function(){
                	return this.value;
                }},
                {key: "grpAuthCd", label: COL("ax.admin.menu.auth.group.code"), width: 160, align: "center"},
                {key: "grpAuthNm", label: COL("ax.admin.menu.auth.group.name"), width: 192, align: "left"},
                {key: "useYn", label: "사용", width: 60, editor: "checkYn"},
                {key: "schAh", label: COL("ax.admin.menu.auth.inquery"), width: 60, align: "center", editor: "menu-program-auth-checkYn"},
                {key: "savAh", label: COL("ax.admin.menu.auth.save"), width: 60, align: "center", editor: "menu-program-auth-checkYn"},
                {key: "exlAh", label: COL("ax.admin.menu.auth.excel"), width: 60, align: "center", editor: "menu-program-auth-checkYn"},
                {key: "delAh", label: COL("ax.admin.menu.auth.delete"), width: 60, align: "center", editor: "menu-program-auth-checkYn"},
                {key: "creAh", label: "신규", width: 60, align: "center", editor: "menu-program-auth-checkYn"},
                {key: "modAh", label: "수정", width: 60, align: "center", editor: "menu-program-auth-checkYn"},
                {key: "fn1Ah", label: "FN1", width: 60, align: "center", editor: "menu-program-auth-checkYn"},
                {key: "fn2Ah", label: "FN2", width: 60, align: "center", editor: "menu-program-auth-checkYn"},
                {key: "fn3Ah", label: "FN3", width: 60, align: "center", editor: "menu-program-auth-checkYn"},
                {key: "fn4Ah", label: "FN4", width: 60, align: "center", editor: "menu-program-auth-checkYn"},
                {key: "fn5Ah", label: "FN5", width: 60, align: "center", editor: "menu-program-auth-checkYn"}
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

//우선 3depth 까지만 seq 정의함..
function setMenuSeq(data){
	var menuSort = 0;
    data.forEach(function (n) {
        if (n.children && n.children.length) {
        	n.children.forEach(function (n2) {
                if (n2.children && n2.children.length) {
                	n2.children.forEach(function (n3) {
                        if (n3.children && n3.children.length) {
                        	
                        }else{
                        	n3.menuSort = menuSort ++;
                        }
                    });
                }else{
                	n2.menuSort = menuSort ++;
                }
            });
        }else{
        	n.menuSort = menuSort ++;
        }
    });
    
    return data;
}