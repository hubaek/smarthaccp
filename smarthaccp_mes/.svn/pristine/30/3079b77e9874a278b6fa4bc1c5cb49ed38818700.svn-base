/**
 * 0. Project	: 스마트HACCP CMMS
 * 1. 작성자  	: 스마트HACCP
 * 2. 작성일		: 2020.01.01
 * 3. Comment 	: 공정등록
 * 4. 변경이력 : 
 *  			이름		|일자          		|변경내용
 *              ------------------------------------------------------
 *				
 */
var fnObj = {};
var CODE = {};
var param;
var tempFileCd;

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
	PAGE_CLOSE: function (caller, act, data) { 
        if (parent) {
        	if (typeof param.callBack === "undefined"){
        		parent.ppmboot.modal.close();
        	}else{
        		parent.customModal.close();
        	}
        }
    },
    PAGE_SEARCH: function (caller, act, data) {
    	ppmboot
        .call({
        	type: "GET",
            url:  ["rout"],
            data: {company:param.company,routCd:param.routCd},
            callback: function (res) {
                caller.formView01.setData(res.list[0]);
            }
         })
    	 .call({
		    type: "GET",
		    url: ["rout","equip"],
		    data: {routCd:param.routCd},
		    callback: function (res) {
		        caller.gridView01.setData(res);  
		    }    
		 })
		 .call({
			 type: "GET",
			 url:  ["rout", "nwrk"],
			 data: {routCd:param.routCd},
			 callback: function (res) {
			     caller.gridView02.setData(res);  
	         }    
         })
		 .call({
		     type: "GET",
		     url:  ["rout", "bad"],
		     data: {routCd:param.routCd},
		     callback: function (res) {
		        caller.gridView03.setData(res);  
		    }    
		 })
		 .call({
             type: "GET",
             url:  ["rout", "man"],
             data: {routCd:param.routCd},
             callback: function (res) {
                caller.gridView04.setData(res);  
            }    
         })
		 .done(function () {
			 setAuthBtn();
		 });
        return false
    }, 
    PAGE_SAVE: function (caller, act, data) {    	
   	 	if (caller.formView01.validate()) {
            axDialog.confirm({
                theme: "danger",
                msg: "'저장'하시겠습니까?"
            }, function () {
            	if(this.key == "ok"){
            		
            		var mData = caller.formView01.getData();	  	
                    mData.tempFileCd = tempFileCd;

                    var dData1 = [].concat(caller.gridView01.getData("modified"));
                    dData1 = dData1.concat(caller.gridView01.getData("deleted"));
                    
                    var dData2 = [].concat(caller.gridView02.getData("modified"));
                    dData2 = dData2.concat(caller.gridView02.getData("deleted"));
                    
                    var dData3 = [].concat(caller.gridView03.getData("modified"));
                    dData3 = dData3.concat(caller.gridView03.getData("deleted"));
                    
                    var dData4 = [].concat(caller.gridView04.getData("modified"));
                    dData4 = dData4.concat(caller.gridView04.getData("deleted"));
                    
	       	        mData.rout300List = dData1;	
	       	        mData.rout500List = dData2;
	       	        mData.rout600List = dData3;	
	       	        mData.rout200List = dData4;
	       	        
		       	     ppmboot
		             .call({
		                 type: "PUT", 
		                 url: ["rout"], 
		                 data: JSON.stringify(mData),
		                 callback: function (res) {
	                	 	param.mode = "mod";	  
	                	 	param.routCd = res.routCd;
			                parent.ppmboot.modal.callback("");	 
		                    ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
		                 }
		             }) 
		             .done(function () {
		            	 axToast.push("저장 되었습니다.");
		             }); 
                }
            });
	    	
	    }
    },
    //설비 적용
    EQUIP_SELECT_MODAL_OPEN: function (caller, act, data) {
        var mData = caller.formView01.getData();      
    	customModal.open({
            width: 900,
            height: 700,
            iframe: {
                method: "get",
                url: "/jsp/mes/modal/EQ-SEL-M.jsp", 
                param: "callBack=customEquipSelelctModalCallback&obj"
            }
        });    	   
        
    }, 
    //비가동 적용
    NWRK_SELECT_MODAL_OPEN: function (caller, act, data) {
    	var mData = caller.formView01.getData();
    	customModal.open({
            width: 900,
            height: 700,
            iframe: {
                method: "get",
                url: "/jsp/mes/modal/BASIC-NWRK-M.jsp", 
                param: "callBack=customNwrkSelelctModalCallback&gridNm=gridView02&keyNm=nwrkCd"
            }
        });    	   
    }, 
    //불량유형 적용
    BAD_SELECT_MODAL_OPEN: function (caller, act, data) {
    	var mData = caller.formView01.getData();     
		customModal.open({
	        width: 900,
	        height: 700,
	        iframe: {
	            method: "get",
	            url: "/jsp/mes/modal/BASIC-BAD-M.jsp", 
                param: "callBack=customBadSelelctModalCallback&gridNm=gridView03&keyNm=badCd"
	        }
	    });    	   
    },    
    //가용인원 적용
    USER_SELECT_MODAL_OPEN: function (caller, act, data) {
    	var mData = caller.formView01.getData();     
    	customModal.open({
            width: 900,
            height: 700,
            iframe: {
                method: "get",
                url: "/jsp/mes/modal/USER-SEL-M.jsp", 
                param: "callBack=customUserSelelctModalCallback&obj"
            }
        });    	   
    },
    GRID01_DEL: function (caller, act, data) {
        caller.gridView01.delRow("selected");
    },
    GRID02_DEL: function (caller, act, data) {
        caller.gridView02.delRow("selected");
    },
    GRID03_DEL: function (caller, act, data) {
        caller.gridView03.delRow("selected");
    },
    GRID04_DEL: function (caller, act, data) {
        caller.gridView04.delRow("selected");
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
        data: {mainCd: "NWRK_CD"},
        callback: function (res) {        		
            this.NWRK_CD = res.list;
        }
    })
    .done(function () {
    	CODE = this;
        CONVERT_CODE = convertCommonCode(CODE);
        
        _this.pageButtonView.initView();
        _this.formView01.initView();
        _this.gridView01.initView();
        _this.gridView02.initView();
        _this.gridView03.initView();
        _this.gridView04.initView();

        param = parent.ppmboot.modal.getData();
    	if (typeof param === "undefined"){
    	    param = ax5.util.param(ax5.info.urlUtil().param);
    	}
    	
        if(param.mode == "add"){      
            setAuthBtn();
        }else{
        	ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
        }
        
        tempFileCd = randomStringCd(20);
        
    });
};

fnObj.pageResize = function () {
	
};

fnObj.pageButtonView = ppmboot.viewExtend({
    initView: function () {
        ppmboot.buttonClick(this, "data-page-btn", {  
            "save": function () {
                ACTIONS.dispatch(ACTIONS.PAGE_SAVE);
            },
            "delete": function () {
                ACTIONS.dispatch(ACTIONS.PAGE_DEL);
            },
            "close": function () {
                ACTIONS.dispatch(ACTIONS.PAGE_CLOSE);
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

        if(nvl(data.routCd,'') != ''){
        	$("#routCd").attr("readonly","readonly");
        }else{
        	$("#routCd").removeAttr("readonly");        	
        }
        
        searchFile(nvl(data.routCd,tempFileCd));
        this.model.setModel(data);
        this.modelFormatter.formatting(); // 입력된 값을 포메팅 된 값으로 변경
    },
    validate: function () {
        var rs = this.model.validate();
        if (rs.error) {
            alert(LANG("ax.script.form.validate", rs.error[0].jquery.attr("title")));
            rs.error[0].jquery.focus();
            return false; 
        }
        return true;
    },
    clear: function () {
        this.model.setModel(this.getDefaultData());
    },
    setDefaultCust:function(data){
        this.model.set("custCd", data.custCd);
        this.model.set("custNm", data.custNm);
    },
});

//공정별설비
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
            frozenColumnIndex: 0,
            target: $('[data-ax5grid="grid-view-01"]'),
            columns: [  
                {key: "equipCd", label: "설비코드", width:258, align: "center",formatter:function(){
                 	return this.value;
                 }},
                {key: "equipNm", label:"설비명", width: 500, align: "left"},
                {key: "refYn", label:"연결설비", width: 210, align: "center", editor: "checkYn"},
                {key: "useYn", label:"사용여부", width: 210, align: "center", editor: "checkYn"},
            ],  
            body: { 
                onClick: function () {
                    this.self.select(this.dindex);
                }
            }
        });
        ppmboot.buttonClick(this, "data-grid-view-01-btn", {
            "grid01-add": function () {
           	 	ACTIONS.dispatch(ACTIONS.EQUIP_SELECT_MODAL_OPEN);
            },
	        "grid01-remove": function () {
	            ACTIONS.dispatch(ACTIONS.GRID01_DEL);
	        },
        });
        
    },
    getData: function (_type) {
        var list = [];
        var _list = this.target.getList(_type);

        if (_type == "modified" || _type == "deleted") {
            list = ax5.util.filter(_list, function () {
                return nvl(this.equipCd,randomStringCd(20));
            });
        } else {
            list = _list;
        }
        return list;
    },
    addRow: function (data) {
        this.target.addRow({__created__: true,equipCd:data.equipCd,equipNm:data.equipNm,routType:data.routType,routCd:data.routCd,company:data.company,useYn:nvl(data.useYn,"Y"),refYn:nvl(data.refYn,"N"),
        	}, "last");
    }
});

//공정별비가동
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
                {key: "nwrkCd", label:"비가동코드", width: 334, align: "center",formatter:function(){
                	return this.value;
                }},
				{key: "nwrkCd",label: "비가동명", width: 550, align: "left", formatter: function formatter() { return CONVERT_CODE["NWRK_CD"].map[this.value];}},
                {key: "useYn", label:"사용여부", width: 300, align: "center", editor: "checkYn"}
            ],  
            body: { 
                onClick: function () {
                    this.self.select(this.dindex);
                }
            }
        });
        ppmboot.buttonClick(this, "data-grid-view-02-btn", {
        	"grid02-add": function () {
           	 	ACTIONS.dispatch(ACTIONS.NWRK_SELECT_MODAL_OPEN);
            },
        	"grid02-remove": function () {
                ACTIONS.dispatch(ACTIONS.GRID02_DEL);
            },
        });
    },
    getData: function (_type) {
        var list = [];
        var _list = this.target.getList(_type);

        if (_type == "modified" || _type == "deleted") {
            list = ax5.util.filter(_list, function () {
                return nvl(this.nwrkCd,randomStringCd(20));
            });
        } else {
            list = _list;
        }
        return list;
    },
    addRow: function (data) {
        this.target.addRow({__created__: true,nwrkCd:data.subCd,nwrkNm:data.subNm,routCd:data.routCd,company:data.company,useYn:nvl(data.useYn,"Y"),
        	}, "last");
    }
});

//불량유형
fnObj.gridView03 = ppmboot.viewExtend(ppmboot.gridView, {	
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
            target: $('[data-ax5grid="grid-view-03"]'),
            columns: [  
                {key: "badCd", label:"불량코드", width: 334, align: "center",formatter:function(){
                	return this.value;
                }},
				{key: "badNm",label: "불량명", width: 550, align: "left"},
                {key: "useYn", label:"사용여부", width: 300, align: "center", editor: "checkYn"}
            ],  
            body: { 
                onClick: function () {
                    this.self.select(this.dindex);
                }
            }
        });
        ppmboot.buttonClick(this, "data-grid-view-03-btn", {
        	"grid03-add": function () {
           	 	ACTIONS.dispatch(ACTIONS.BAD_SELECT_MODAL_OPEN);
            },
        	"grid03-remove": function () {
                ACTIONS.dispatch(ACTIONS.GRID03_DEL);
            },
            
        });
        
    },
    getData: function (_type) {
        var list = [];
        var _list = this.target.getList(_type);

        if (_type == "modified" || _type == "deleted") {
            list = ax5.util.filter(_list, function () {
                return nvl(this.badCd,randomStringCd(20));
            });
        } else {
            list = _list;
        }
        return list;
    },
    addRow: function (data) {
        this.target.addRow({__created__: true,badCd:data.subCd,badNm:data.subNm,routCd:data.routCd,company:data.company,useYn:nvl(data.useYn,"Y"),
        	}, "last");
    }
});

//가용인원
fnObj.gridView04 = ppmboot.viewExtend(ppmboot.gridView, {	
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
            target: $('[data-ax5grid="grid-view-04"]'),
            columns: [  
                {key: "userCd", label:"작업자ID", width: 334, align: "center"},
                {key: "userNm", label:"작업자명", width: 550, align: "center"},
                {key: "useYn", label:"사용여부", width: 300, align: "center", editor: "checkYn"}
            ],  
            body: { 
                onClick: function () {
                    this.self.select(this.dindex);
                }
            }
        });
        ppmboot.buttonClick(this, "data-grid-view-04-btn", {
        	"grid04-add": function () {
           	 	ACTIONS.dispatch(ACTIONS.USER_SELECT_MODAL_OPEN);
            },
        	"grid04-remove": function () {
                ACTIONS.dispatch(ACTIONS.GRID04_DEL);
            },
        });
        
    },
    getData: function (_type) {
        var list = [];
        var _list = this.target.getList(_type);

        if (_type == "modified" || _type == "deleted") {
            list = ax5.util.filter(_list, function () {
                return nvl(this.userCd,randomStringCd(20));
            });
        } else {
            list = _list;
        }
        return list;
    },
    addRow: function (data) {
        this.target.addRow({__created__: true,userCd:data.userCd,userNm:data.userNm,routCd:data.routCd,company:data.company,useYn:nvl(data.useYn,"Y"),
        	}, "last");
    }
});

//설비 적용
function customEquipSelelctModalCallback(item){
	var data = fnObj.formView01.getData();
	item.routType = data.routType;
	item.routCd = data.routCd;
	fnObj.gridView01.addRow(item);
}


//비가동적용
function customNwrkSelelctModalCallback(data){
	var mData = fnObj.formView01.getData();
	var list = fnObj.gridView02.getData();     
	var addYn = "Y";
	
	list.forEach(function (n) {
		if(n.nwrkCd == data.subCd){
			addYn = "N";
			return false; 
		}
	});
	
	if(addYn == "Y"){
	    data.routCd = mData.routCd;
		fnObj.gridView02.addRow(data);
	}
}


//불량적용
function customBadSelelctModalCallback(data){
	var mData = fnObj.formView01.getData();
	
	var list = fnObj.gridView03.getData();     
	var addYn = "Y";
	
	list.forEach(function (n) {
		if(n.badCd == data.subCd){
			addYn = "N";
			return false; 
		}
	});
	
	if(addYn == "Y"){

	    data.routCd = mData.routCd;
		fnObj.gridView03.addRow(data);
	}
}

//작업자 적용
function customUserSelelctModalCallback(item){
	var data = fnObj.formView01.getData();
	item.routCd = data.routCd;
	fnObj.gridView04.addRow(item);
}

function setAuthBtn(){	
	var mData = fnObj.formView01.getData();
	var mode = param.mode;
	
	if(mode != 'view'){
        $("#save").show();
	}else{
        $("#save").hide();
    	$("#modal-content").find("input,select,button,textarea, file, radio").prop('disabled', true);
	}
}