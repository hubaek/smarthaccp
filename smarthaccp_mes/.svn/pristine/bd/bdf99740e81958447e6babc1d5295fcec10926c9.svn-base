/**
 * 0. Project	: 스마트HACCP MES
 * 1. 작성자  	: 김회재
 * 2. 작성일		: 2020.12.18
 * 3. Comment 	: 여과공정CCP2-P
 * 4. 변경이력 : 
 *  			이름		|일자          		|변경내용
 *              ------------------------------------------------------
 *								
 */
var fnObj = {};
var param;
var tempFileCd;
var inFlag;
var mode;
var staFlag;
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
            url: ["filter", "master"],
            data: {company:param.company, inspectionDate:param.inspectionDate.replace(/-/gi,"")},
            callback: function (res) {
            	caller.formView01.setData(res[0]);
            }
        })
        .call({
            type: "GET",
            url: ["filter","detail"],
            data: {company:param.company, inspectionDate:param.inspectionDate.replace(/-/gi,"")},
            callback: function (res) {
            	caller.gridView02.setData(res);
            }
        })
    	.done(function () {
        	setAuthBtn();
        });

        return false;
    },    
    PAGE_SAVE: function (caller, act, data) {
   	 if (caller.formView01.validate()) {
   		 if(mode == "add"){
   			if(!inFlag){
   				axDialog.alert({
   	                theme: "primary",
   	                msg: "중복체크를 해주세요."
   	            });
   	    		return false;
   					}
   	   	 		}
   		 var cnt = 0;
   		 var nCnt = 0;
   		 var rCnt = 0;
   		 var listCnt = [];
   		 var lCnt = 0;
         var mData = caller.formView01.getData(); 
         var dData = [].concat(caller.gridView02.getData("modified"));
         dData = dData.concat(caller.gridView02.getData("deleted"));
         dData = dData.concat(caller.gridView02.getData());
         
         
         dData.forEach(function (n) {
             n.company   = "1000";
             n.inspectionDate = mData.inspectionDate.replace(/-/gi,"");
             if(n.result1 ===undefined || n.result2 === undefined||n.result3 === undefined ){
             	cnt++;
             }

             if(n.result1 ==="N" || n.result2 === "N"||n.result3 === "N"){
	              	if(n.remark === undefined || n.remark == null){
		               	 rCnt++;
		               	 listCnt.push(rCnt);
	                }
	              	nCnt++;	
              }
             
         });
         	mData.writer = SCRIPT_SESSION.userNm; //작성자에 userNm 넣기 
            mData.inspectionDate = mData.inspectionDate.replace(/-/gi,"");
			mData.tempFileCd = tempFileCd;
			mData.status = "10";
			if(nCnt > 0){
				if(rCnt > 0){
					axDialog.alert({
	   	                theme: "primary",
	   	                msg: listCnt.shift()+"행의 비고란을 작성해주세요."
	   	            });
				return false;
				}
			}
			
			if(cnt > 0){
				axDialog.confirm({
	        		theme: "primary",
	        		msg: "점검사항에 빈칸이 존재합니다. \n 저장하시겠습니까?"
	        	}, function(){
	        		if(this.key == "ok"){
	        			ppmboot
	                    .call({
	                        type: "PUT", url: ["filter", "master"], data: JSON.stringify([mData]),
	                        callback: function (res) {                    	
	                        }
	                    })
	                    .call({
	                        type: "PUT", url: ["filter", "detail"], data: JSON.stringify(dData),
	                        callback: function (res) {
	                        	param.mode = "mod";
	                        	axToast.push("저장 되었습니다.");
	                        	$("input:checkbox[id='chk']").prop("checked", false); 
	                        	parent.ppmboot.modal.callback("");
	                        }
	                    })
		                .done(function () {
		                	
		                });
	        		}
	        	});
			}else{
				axDialog.confirm({
	        		theme: "primary",
	        		  msg: "저장하시겠습니까?"
	        	}, function(){
	        		if(this.key == "ok"){
	        			ppmboot
	                    .call({
	                        type: "PUT", url: ["filter", "master"], data: JSON.stringify([mData]),
	                        callback: function (res) {                    	
	                        }
	                    })
	                    
	                    .call({
	                        type: "PUT", url: ["filter", "detail"], data: JSON.stringify(dData),
	                        callback: function (res) {
	                        	param.mode = "mod";	
	                        	axToast.push("저장 되었습니다.");
	                        	$("input:checkbox[id='chk']").prop("checked", false); 
	                        	parent.ppmboot.modal.callback("");
	                        }
	                    })
		                .done(function () {
	                        
		                });
	        		}
	        	});
			}
			
			
   	 	}	
    },
    PAGE_DELETE: function (caller, act, data) {    	
		axDialog.confirm({
            theme: "danger",
            msg: "삭제하시겠습니까?"
        }, function () {
            if (this.key == "ok") {
        		var mData = caller.formView01.getData();
        		mData.inspectionDate = mData.inspectionDate.replace(/-/gi,"");
        		ppmboot
            	.call({
            		type: "DELETE"
            	  , url:["filter"]
            	  , data : JSON.stringify([mData])
            	  , callback: function(res){
            		  
                	}
            	})	
                .done(function (){
                	axToast.push("삭제되었습니다.");
                	parent.ppmboot.modal.callback("");	      
                    ACTIONS.dispatch(ACTIONS.PAGE_CLOSE); 
                
                });
            }
        }); 	 
   	},
   	ITEM_SUB_ADD: function (caller, act, data) {
    	var inspectionDate = $("#inspectionDate").val().replace(/-/gi,"");
    	if(inspectionDate == "" || inspectionDate === undefined || inspectionDate == null){
    		axDialog.alert({
                theme: "warning",
                msg: "점검일자를 입력하세요."
            });
    		return false;
    	}
   		caller.gridView02.addRow();
    },
    ITEM_SUB_DEL: function (caller, act, data) {
    	var list = [];
    	list = caller.gridView02.getData("selected");
    	if(list.length == 0){
    		axDialog.alert({
                theme: "primary",
                msg: "대상을 선택하세요."
            });
    		return false;	
    	}
        caller.gridView02.delRow("selected");
    },
   	CHECKED : function(caller , act , data){
    	var inspectionDate = $("#inspectionDate").val().replace(/-/gi,"");;
   		if(nvl(inspectionDate,'') == ''){
   			axDialog.alert({
                theme: "warning",
                msg: "점검일자를 입력하세요."
            },function(){
            });
   			
   		}else{
	    	ppmboot
		   	 .call({
		   	     	type: "GET",
		   	         url: ["filter","master"],
		   	         data: {inspectionDate: inspectionDate.replace(/-/gi,"")},
		   	         callback: function (res) {
			   	            if(res.length > 0 ){
				   	            	axDialog.alert({
				   	                 theme: "primary",
				   	                 msg: "이미 등록된 점검일자 입니다."
				   	             });
				   	            	$("input:checkbox[id='chk']").prop("checked",false); 
				   	            	inFlag = false;	
			   	            }else{
			   	            	axDialog.alert({
				   	                 theme: "primary",
				   	                 msg: "등록 가능한 점검일자 입니다."
				   	             });
			   	            	inFlag = true;
			   	            	$("input:checkbox[id='chk']").prop("checked", true); 
			   	            }
			   	            
		   	         }
		   	 })
		     .done(function () {	   
		    	//필요시 기능 추가	
		     });
   		}
    },
    SEARCH_CCP_ITEM: function(caller , act , data){
    	var templateId = param.templateId;
    	
    	ppmboot.ajax({
	        type: "GET",
	        url: ["haccp","selectccpmngitemlist"],
	        data: {"ccp" : templateId},
	        callback: function (res) {
	        	res.forEach(function(item) {
	        	    var rowhtml = "";
	        	    if(item.doctype == "0"){//form
	        	    	rowhtml += '<tr>';
						rowhtml += '	<th>' + item.ccpItem + '</th>';
						rowhtml += '	<td>' + item.docdesc + '</td>';
						rowhtml += '</tr>';
	        	    }
	        	    $("#ccpTable").append(rowhtml);
	        	});
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
    _this.formView01.initView();
    
    param = parent.ppmboot.modal.getData();
    ACTIONS.dispatch(ACTIONS.SEARCH_CCP_ITEM);
    
    if(param.mode == "add"){      
        setAuthBtn();
    }else{
    	ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
    }
    
    
    tempFileCd = randomStringCd(20);
    _this.gridView02.initView();
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
                ACTIONS.dispatch(ACTIONS.PAGE_DELETE);
            },
            "close": function () {
                ACTIONS.dispatch(ACTIONS.PAGE_CLOSE);
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
        this.initEvent();

        this.target.find('[data-ax5picker="basic"]').ax5picker({
        	direction: "auto",
            content: {
                type: 'date',
               
            },
            onStateChanged: function(){
        		if(this.value != undefined){
	        		inFlag = false;
	        		$("#inspectionDate").val(this.value.replace(/-/gi,""));
	        		$("input:checkbox[id='chk']").prop("checked", false); 
        		}
            }  
        });    
          
        ppmboot.buttonClick(this, "data-form-view-01-btn", {
            "form-clear": function () {
                ACTIONS.dispatch(ACTIONS.ITEM_ADD);
            },
            "checkId" : function(){
            	ACTIONS.dispatch(ACTIONS.CHECKED);
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
    	data.inspectionDate = convertStringToDateFormat(data.inspectionDate);
    	this.model.setModel(data);
    	this.modelFormatter.formatting(); // 입력된 값을 포메팅 된 값으로 변경
    	if(data.inspectionDate != null ){
    		$("#inspectionDate").attr("disabled","disabled");
    	}else{
    		$("#inspectionDate").removeAttr("disabled");
    	}
    	searchFile(nvl(data.inspectionDate,tempFileCd));
    	
    },
    validate: function (data) {
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
    }
});

function setAuthBtn(){
	var mData = fnObj.formView01.getData();
		 mode = param.mode;
		 $("#status").attr("disabled","disabled");	 
	if(mode !='view'){
        $("#save").show();
		if(nvl(mData.inspectionDate,'') == ''){
	        $("#delete").hide();
		}else{
	        $("#delete").show();
		}
	    if(mode == "mod"){
	    	//$("#modal-content").find("select,button,checkbox").prop('disabled', true);
	    }	
	}else{
        $("#save").hide();
        $("#delete").hide();
    	$("#modal-content").find("input,select,button,textarea, file, radio").prop('disabled', true);
	}
}


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
            multipleSelect: false,
            showRowSelector: true,
            lineNumberColumnWidth: 40,
            rowSelectorColumnWidth: 26,
            frozenColumnIndex: 0,
            target: $('[data-ax5grid="grid-view-02"]'),
            columns: [
            	 {key: "inspectionDate"  	, label:"점검일자" , width: 100  , align: "center", hidden:true},
            	 {key: "itemNm"				, label:"제품명"   , width: 210 , editor: "text" , align: "left", styleClass: "grid-cell-blue" },
            	 {key: "inspectionType"		, label:"구분"   , width: 80   , align: "center", styleClass: "grid-cell-blue" },
            	 {key: "inspectionTime"		, label:"확인시간"   , width: 120 , align: "center", styleClass: "grid-cell-blue" },            	 
            	 {label: "여과망/필터 확인(CP-100)", width:200, columns: [ 
                        {key: "result1", label: "적합",width: 80, sortable: false, align: "center", editor: {type: "checkbox", config: {height: 17, trueValue: "Y", falseValue: "N"}}},
                        {key: "result1", label: "부적합",width: 80, sortable: false, align: "center", editor: {type: "checkbox", config: {height: 17, trueValue: "N", falseValue: "Y"}}}
                     ]
                 },
                 {label: "여과기청결여부", columns: [ 
                        {key: "result2", label: "적합",width: 60, sortable: false, align: "center", editor: {type: "checkbox", config: {height: 17, trueValue: "Y", falseValue: "N"}}},
                        {key: "result2", label: "부적합",width: 60, sortable: false, align: "center", editor: {type: "checkbox", config: {height: 17, trueValue: "N", falseValue: "Y"}}}
                     ]
                 },
                 {key: "remark"	    	, label:"비고"     , width: 170 , editor: {type: "textarea"}   , align: "left", styleClass: "grid-cell-blue" },
            	 {key: "inspectionSeq"  , hidden:true},
            ],
            body: {
            	mergeCells: ["itemNm"],
            	onClick: function (index) {
                	if(index.colIndex == 3){
                		this.self.setValue(index.dindex,this.self.columns[4].columns[1].key,"Y");
                		let today = new Date();
                        let month = today.getMonth()+1;
                        let date2 = today.getDate();
                        let hours = today.getHours();
                        let minutes = today.getMinutes();
                        let seconds = today.getSeconds();
                        
                        if(String(month).length == 1){month = "0"+month;}
                        if(String(date2).length == 1){date2 = "0"+date2;}
                        if(String(hours).length == 1){hours = "0"+hours;}
                        if(String(minutes).length == 1){minutes = "0"+minutes;}
                        if(String(seconds).length == 1){seconds = "0"+seconds;}
                        
                        let time = month + "-" + date2 + " " + hours + ":" + minutes + ":" + seconds;
                        
                        this.self.setValue(index.dindex,this.self.columns[3].key,time);
                	}else if(index.colIndex == 4){
                		this.self.setValue(index.dindex,this.self.columns[4].columns[0].key,"N");
                		let today = new Date();
                        let month = today.getMonth()+1;
                        let date2 = today.getDate();
                        let hours = today.getHours();
                        let minutes = today.getMinutes();
                        let seconds = today.getSeconds();
                        
                        if(String(month).length == 1){month = "0"+month;}
                        if(String(date2).length == 1){date2 = "0"+date2;}
                        if(String(hours).length == 1){hours = "0"+hours;}
                        if(String(minutes).length == 1){minutes = "0"+minutes;}
                        if(String(seconds).length == 1){seconds = "0"+seconds;}
                        
                        let time = month + "-" + date2 + " " + hours + ":" + minutes + ":" + seconds;
                        
                        this.self.setValue(index.dindex,this.self.columns[3].key,time);
                	}else if(index.colIndex == 5){
                		this.self.setValue(index.dindex,this.self.columns[5].columns[1].key,"Y");
                		let today = new Date();
                        let month = today.getMonth()+1;
                        let date2 = today.getDate();
                        let hours = today.getHours();
                        let minutes = today.getMinutes();
                        let seconds = today.getSeconds();
                        
                        if(String(month).length == 1){month = "0"+month;}
                        if(String(date2).length == 1){date2 = "0"+date2;}
                        if(String(hours).length == 1){hours = "0"+hours;}
                        if(String(minutes).length == 1){minutes = "0"+minutes;}
                        if(String(seconds).length == 1){seconds = "0"+seconds;}
                        
                        let time = month + "-" + date2 + " " + hours + ":" + minutes + ":" + seconds;
                        
                        this.self.setValue(index.dindex,this.self.columns[3].key,time);
                	}else if(index.colIndex == 6){
                		this.self.setValue(index.dindex,this.self.columns[5].columns[0].key,"N");
                		let today = new Date();
                        let month = today.getMonth()+1;
                        let date2 = today.getDate();
                        let hours = today.getHours();
                        let minutes = today.getMinutes();
                        let seconds = today.getSeconds();
                        
                        if(String(month).length == 1){month = "0"+month;}
                        if(String(date2).length == 1){date2 = "0"+date2;}
                        if(String(hours).length == 1){hours = "0"+hours;}
                        if(String(minutes).length == 1){minutes = "0"+minutes;}
                        if(String(seconds).length == 1){seconds = "0"+seconds;}
                        
                        let time = month + "-" + date2 + " " + hours + ":" + minutes + ":" + seconds;
                        
                        this.self.setValue(index.dindex,this.self.columns[3].key,time);
                	}
                	/*else if(index.colIndex == 7){
                		this.self.setValue(index.dindex,this.self.columns[6].columns[1].key,"Y");
                	}else if(index.colIndex == 8){
                		this.self.setValue(index.dindex,this.self.columns[6].columns[0].key,"N");
                	}*/
                	                	
                }
            }
        });         
    },
    getData: function (_type) {
        var list = [];
        var _list = this.target.getList(_type);

        if (_type == "modified" || _type == "deleted") {
            list = ax5.util.filter(_list, function () {
            	list.push(this.company);
            	list.push(this.inspectionDate);
            	list.push(this.inspectionSeq);
            	return list;
            });
        } else {
            list = _list;
        }
        return list;
    },    
});


