/**
 * 0. Project	: 스마트HACCP MES
 * 1. 작성자  	: 스마트HACCP_NEW
 * 2. 작성일	: 2020.01.01
 * 3. Comment 	: 사용자관리
 * 4. 변경이력 : 
 *  			이름		|일자          		|변경내용
 *              ------------------------------------------------------
 *				
 */
var fnObj = {};
var CODE = {};
var mask;
var CONVERT_CODE;
var checkFlag;

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
            url: ["users","userList"],
            data: $.extend({}, getSerializeArrayToJson("#searchView0")),
            callback: function (res) {
                caller.gridView01.setData(res);
                caller.formView01.clear();
                caller.formView01.maskOnOff("on");
            }
        });

        return false;
    },
    PAGE_SAVE: function (caller, act, data) {
        if (caller.formView01.validate()) {
        	if(!checkFlag){
	   	    	 axDialog.alert({
	   	             theme: "warning",
	   	             msg: "아이디 중복검사를 해주세요."
	   	         },function(){
	   	         	$("#itemCd").focus();
	   	         });
	   	     }else{
	        	var mData = caller.formView01.getData();
	        	if(document.formView01.mailAgree.checked){
	        		mData.mailAgree = "Y";
	        	}else{
	        		mData.mailAgree = "N";
	        	}
	        	mData.company = "1000";
	            
	        	if(mData.password_change == 'Y'){
	        		if (!caller.formView01.validatePW(mData)) return;
	        	}
	        	
	            ppmboot.ajax({
	                type: "PUT",
	                url: ["users"],
	                data: JSON.stringify(mData),
	                callback: function (res) {
	                    ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
	                }
	            });
	   	     }
        }
    },
    SEND_EMAIL: function (caller, act, data){
    	ppmboot.ajax({
    		type: "POST",
    		url: ["users", "sendmail"],
    		data: $.extend({}, getSerializeArrayToJson("#searchView0")),
    		callback: function (res){
    		}
    	});
    },
    FORM_CLEAR: function (caller, act, data) {
        axDialog.confirm({
            msg: LANG("ax.script.form.clearconfirm")
        }, function () {
            if (this.key == "ok") {
            	$("input:checkbox[name='mailAgree']").prop("checked", false);
                caller.formView01.clear();
            }
        });
    },
    ITEM_CLICK: function (caller, act, data) {
    	ppmboot
        .call({
            type: "GET",
            url: ["users"],
            data: {userCd: data.userCd},
            callback: function (res) {
            	if(res.mailAgree == "N"){
            		$("input:checkbox[name='mailAgree']").prop("checked", false);
            	}else if(res.mailAgree == "Y"){
            		$("input:checkbox[name='mailAgree']").prop("checked", true);
            	}
            	$("input:text[name='userCd']").prop("disabled", true);
            	checkFlag = true;
                caller.formView01.setData(res);
            }
        })
        .done(function () {
        });
    	
        return false;
    },
    CHECK_ID: function (caller, act, data) {    
    	var mData = caller.formView01.getData();
    	
   		if(nvl(mData.userCd,'') == ''){
   			axDialog.alert({
                theme: "warning",
                msg: "아이디를 입력하세요."
            },function(){
            	$("#userCd").focus();
            });
   		}else{
   			ppmboot
	   	    .call({
	   	        type: "GET",
	   	        url:  ["users","user"],
	   	        data: {userCd: mData.userCd},
	   	        callback: function (res) {    
	   	        	console.log(res.list.length);
	   	           if(res.list.length > 0){
		   	        	axDialog.alert({
		                    theme: "warning",
		                    msg: "이미 등록된 아이디입니다."
		                },function(){
		                	$("#userCd").focus();
		                });
	   	        	   checkFlag = false;
	   	           }else{
	   	        	   	axDialog.alert({
		                    theme: "warning",
		                    msg: "등록할수 있는 아이디입니다."
		                },function(){
		                    
		                });
	   	        	   checkFlag = true;
	   	           }
	   	        }
	   	    })
	   	    .done(function () {
	   	    	
	   	    });
   		}
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

    ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
    
    $("#userCd").change(function() {
    	checkFlag = false;
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
  initView: function () {
      this.target = $(document["searchView0"]);
      this.target.attr("onsubmit", "return ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);");
      
  }
});

/**
 * gridView
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
                {key: "userCd"},
                {key: "userNm"},
                {key: "deptCd", align:"left"},
                {key: "userPosition", align:"left"},
                {key: "userDuty", align:"left"},
                {key: "email"},
                {key: "useYn", width:143, label:"사용여부"}
            ],
            body: {
                onClick: function () {
                    this.self.select(this.dindex);
                    ACTIONS.dispatch(ACTIONS.ITEM_CLICK, this.list[this.dindex]);
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
    }
});

/**
 * formView01
 */
fnObj.formView01 = ppmboot.viewExtend(ppmboot.formView, {
    getDefaultData: function () {
        return $.extend({}, ppmboot.formView.defaultData, {
            roleList: []
        });
    },
    maskOnOff:function(status){
    	
    	if(status=="off"){
    		if(mask.status=="on"){
    			mask.close();
    		}
    	}else{
    		if(mask.status=="off"){
    			mask.open();
    		}
    	}
    	
    },
    initView: function () {
        this.target = $("#formView01");
        this.model = new ax5.ui.binder();
        this.model.setModel(this.getDefaultData(), this.target);
        this.modelFormatter = new ppmboot.modelFormatter(this.model); // 모델 포메터 시작
        

        mask = new ax5.ui.mask({
            theme: "form-mask",
            target: $('#split-panel-form'),
            content: "왼쪽 사용자 선택 또는 신규 버튼을 눌러주세요."
        });
        
        this.maskOnOff("on");    
        
        this.initEvent();

        ppmboot.buttonClick(this, "data-form-view-01-btn", {
        	"checkId": function () {
            	ACTIONS.dispatch(ACTIONS.CHECK_ID)
            },
            "form-clear": function () {
                ACTIONS.dispatch(ACTIONS.FORM_CLEAR);
            },
            "send-email": function () {
            	ACTIONS.dispatch(ACTIONS.SEND_EMAIL);
            }, 
        });
    },
    initEvent: function () {
        var _this = this;
        this.model.onChange("password_change", function () {
            if (this.value == "Y") {
                _this.target.find('[data-ax-path="userPs"]').removeAttr("readonly");
                _this.target.find('[data-ax-path="userPs_chk"]').removeAttr("readonly");
            } else {
                _this.target.find('[data-ax-path="userPs"]').attr("readonly", "readonly");
                _this.target.find('[data-ax-path="userPs_chk"]').attr("readonly", "readonly");
            }
        });
        
    },
    getData: function () {
        var data = this.modelFormatter.getClearData(this.model.get()); // 모델의 값을 포멧팅 전 값으로 치환.        

        data.authList = [];
        data.userCompany = [];
        
        if (data.grpAuthCd) {
            data.grpAuthCd.forEach(function (n) {
                data.authList.push({
                	grpAuthCd: n,
                	userCd : data.userCd
                });
            });
        }

        if (data.companyAuthCd) {
            data.companyAuthCd.forEach(function (n) {
                data.userCompany.push({
                	company: n,
                	userCd : data.userCd
                });
            });
        }
        
    	data.grpAuthCd = "";
    	data.companyAuthCd = "";
    	
        return $.extend({}, data);
    },
    setData: function (data) {
        this.maskOnOff("off");

        if (typeof data === "undefined") data = this.getDefaultData();
        data = $.extend({}, data);

        
        if (data.authList) {
            data.grpAuthCd = [];
            data.authList.forEach(function (n) {
                data.grpAuthCd.push(n.grpAuthCd);
            });
        }

        if (data.userCompany) {
            data.companyAuthCd = [];
            data.userCompany.forEach(function (n) {
                data.companyAuthCd.push(n.company);
            });
        }
        
        data.userPs = "";
        data.password_change = "";
        this.target.find('[data-ax-path="userPs"]').attr("readonly", "readonly");
        this.target.find('[data-ax-path="userPs_chk"]').attr("readonly", "readonly");
        
        if(nvl(data.userCd,'') != '' && nvl(data.ifYn,'N') == 'Y'){
            this.target.find('[data-ax-path="userCd"]').attr("readonly", "readonly");
            this.target.find('[data-ax-path="deptCd"]').attr("disabled", "disabled");
            this.target.find('[data-ax-path="userNm"]').attr("readonly", "readonly");
            this.target.find('[data-ax-path="email"]').attr("readonly", "readonly");
            this.target.find('[data-ax-path="hpNo"]').attr("readonly", "readonly");
        }else{
        	this.target.find('[data-ax-path="userCd"]').removeAttr("readonly");
        	this.target.find('[data-ax-path="deptCd"]').removeAttr("disabled");
            this.target.find('[data-ax-path="userNm"]').removeAttr("readonly");
            this.target.find('[data-ax-path="email"]').removeAttr("readonly");
            this.target.find('[data-ax-path="hpNo"]').removeAttr("readonly");
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
            },function(){
                rs.error[0].jquery.focus();
            });
            return false;
        }
        return true;
    },
    clear: function () {
        this.maskOnOff("off");

    	this.target.find('[data-ax-path="userCd"]').removeAttr("readonly");
    	this.target.find('[data-ax-path="deptCd"]').removeAttr("disabled");
        this.target.find('[data-ax-path="userNm"]').removeAttr("readonly");
        this.target.find('[data-ax-path="email"]').removeAttr("readonly");
        this.target.find('[data-ax-path="hpNo"]').removeAttr("readonly");
        
        this.model.setModel(this.getDefaultData());
    },
    validatePW: function (mData) {
    	if(mData.password_change == 'Y'){
    		if(g_isEmpty(mData.userPs)){
    			axDialog.alert({
    				theme: "warning",
    				msg: "비밀번호를 입력해 주세요"
    			},function(){
    				
    			});
    			return false;
    		}
    		if (mData.userPs != mData.userPs_chk) {
    			axDialog.alert({
    				theme: "warning",
    				msg: "비밀번호가 일치하지 않습니다."
    			},function(){
    				
    			});
    			return false;
    }
    		
    		/*
    		 * 영문(대소문자) 포함
			     숫자 포함
			    특수 문자 포함
			    공백 X
			    비밀번호 자리 8~20자
    		 */
    		var pw = mData.userPs;
    		var num = pw.search(/[0-9]/g);
    		var eng = pw.search(/[a-z]/ig);
    		var spe = pw.search(/[`~!@@#$%^&*|₩₩₩'₩";:₩/?]/gi);

    		if(pw.length < 8 || pw.length > 20){
	    			axDialog.alert({
	     				theme: "warning",
	     				msg: "8자리 ~ 20자리 이내로 입력해주세요."
	     			},function(){ });
	    			return false;
    		 }else if(pw.search(/\s/) != -1){
	    			axDialog.alert({
	      				theme: "warning",
	      				msg: "비밀번호는 공백 없이 입력해주세요."
	      			},function(){ });
	     			return false;
    			
    		 }else if(num < 0 || eng < 0 || spe < 0 ){
	    			axDialog.alert({
	      				theme: "warning",
	      				msg: "영문,숫자, 특수문자를 혼합하여 입력해주세요."
	      			},function(){ });
	     			return false;
    		 }
    	}
        
        return true;
    },
});