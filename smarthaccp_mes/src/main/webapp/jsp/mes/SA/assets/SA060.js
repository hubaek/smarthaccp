/**
 * 0. Project	: 
 * 1. 작성자  	: 
 * 2. 작성일		: 
 * 3. Comment 	: 수주등록(개인)
 * 4. 변경이력 : 
 *  			이름		|일자          		|변경내용
 *              ------------------------------------------------------
 *				
 */
var fnObj = {};
var MODAL_NAME = "SA030M";

var ACTIONS = ppmboot.actionExtend(fnObj, {
    PAGE_SEARCH: function (caller, act, data) {
    	ppmboot.ajax({
            type: "GET",
            url: ["order","header"],
            data: $.extend({searchType:"S"}, getSerializeArrayToJson("#searchView0")),
            callback: function (res) {   
                caller.gridView01.setData(res);
                caller.gridView02.setData([]);
            }
        });
        return false;
    },
    //엑셀 다운로드
    EXCEL_DOWNLOAD: function (caller, act, data) {
    	ppmboot.ajax({
            type: "GET",
            url: ["excel"],
            data: $.extend({}, this.searchView.getData()),
            callback: function (res) {
                caller.gridView01.setData(res);
            }
        });
        return false;
    },
    //신규 작성
    ADD_FORM: function (caller, act, data) {
    	axDialog.confirm({
            msg: "[신규등록] 하시겠습니까?"
        }, function () {
            if (this.key == "ok") {
            	ppmboot.modal.open({  
                    modalType: MODAL_NAME,
                    param: "",
                    sendData: function(){
                        return {
                        	"mode" : "add"
                        };
                    },
                    callback: function (data) {
                        ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
                    }
                });
            	
            }
        });
    },
    //수정
    MOD_FORM: function (caller, act, data) {
        var list = caller.gridView01.getData("selected");
        if(list.length!=1){
        	axDialog.alert({
                theme: "primary",
                msg: "대상을 선택하세요."
            });
        	return false;
        }else{
    		
        	axDialog.confirm({
                msg: "[수정] 하시겠습니까?"
            }, function () {
                if (this.key == "ok") {

                	ppmboot.modal.open({  
                        modalType: MODAL_NAME,
                        param: "",
                        sendData: function(){
                            return {
                            	"mode" : "mod",
                            	"company" : list[0].company,
                            	"slipCd" : list[0].slipCd
                            };
                        },
                        callback: function (data) {
                            ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
                        }
                    });  
                	
                }
        	});
        }
    },
    //복사
    COPY_FORM: function (caller, act, data) {
    	axDialog.confirm({
            msg: "[복사 등록] 하시겠습니까?"
        }, function () {
            if (this.key == "ok") {

                var list = caller.gridView01.getData("selected");
                
                if(list.length!=1){
                	axDialog.alert({
                        theme: "primary",
                        msg: "대상을 선택하세요."
                    });
                	return false;
                }else{
                	ppmboot.modal.open({  
                        modalType: MODAL_NAME,
                        param: "",
                        sendData: function(){
                            return {
                            	"mode" : "copy",
                            	"company" : list[0].company,
                            	"slipCd" : list[0].slipCd
                            };
                        },
                        callback: function (data) {
                            ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
                        }
                    });                	
                }
            }
        });
    },    
    //조회 팝업
    VIEW_FORM: function (caller, act, data) {
    	ppmboot.modal.open({  
            modalType: MODAL_NAME,
            param: "",
            sendData: function(){
                return {
                	"mode" : "view",
                	"company" : data.company,
                	"slipCd" : data.slipCd
                };
            },
            callback: function (data) {
                ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
            }
        });    	
    },
    VIEW_REF_FORM: function (caller, act, data) {
    	if(nvl(data.refSlipCd,'') == ''){
    		return false;
    	}
    	ppmboot.modal.open({  
            modalType: "SA020M",
            param: "",
            sendData: function(){
                return {
                	"mode" : "view",
                	"company" : data.company,
                	"slipCd" : data.refSlipCd
                };
            },
            callback: function (data) {
                ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
            }
        });    	
    },
    DOWNLOAD_DOC: function (caller, act, data) {
    	//location.href = "/api/v1/files/download?id=" +"30"; /* TB_MES_FILE000의 ID 해당 양식을 올리고 id값 변경해줘야함 */
    	var list = caller.gridView01.getData("selected");
    	if(list.length!=1){
        	axDialog.alert({
                theme: "primary",
                msg: "대상을 한개만 선택하세요."
            });
        	return false;
        }else{
        	let reportUrl = "/api/v1/order/transactionDownLoad?custNm=" + list[0].custNm + "&slipCd=" + list[0].slipCd;
        	window.open(reportUrl);
        	
        }
    },
    //조회 테이블 선택
    ITEM_CLICK: function (caller, act, data) {
    	ppmboot
	   	 .call({
	   	     	type: "GET",
	   	         url: ["order","itemList"],
	   	     	data: {company:data.company, slipCd: data.slipCd},
	   	         callback: function (res) {
	   	        	
	   	            caller.gridView02.setData(res);
	   	         }
	   	 	})        
	       .done(function () {
	       });  
    },      
    dispatch: function (caller, act, data) {
        var result = ACTIONS.exec(caller, act, data);
        if (result != "error") {
            return result;
        } else {
            return false;
        }
    },
    EXCEL_DATA_DOWN: function (caller, act, data) {
    	var list = caller.gridView01.getData("selected");
    	if(list.length!=1){
        	axDialog.alert({
                theme: "primary",
                msg: "대상을 선택하세요."
            });
        	return false;
        }else{
        	ppmboot.call({
   	   	     	type: "GET",
   	   	        url: ["order","excelDataDownLoad"],
   	   	     	data: {company:list[0].company, slipCd: list[0].slipCd},
   	   	         callback: function (res) {
   	   	        	caller.gridView03.setData(res);
   	                caller.gridView03.target.exportExcel("SA030_"+getNowDt()+".xls");
   	   	         }
   	   	 	})        
   	       .done(function () {
   	       });
        }
    },
});

fnObj.pageStart = function () {
    var _this = this;

    _this.pageButtonView.initView();
    _this.searchView.initView();
    _this.gridView01.initView();
    _this.gridView02.initView();
    _this.gridView03.initView();
    _this.uploadView.initView();
    
    
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
        this.target.attr("onsubmit", "return ACTIONS.dispatch(ACTIONS.EXCEL_DOWNLOAD);");
        
        this.target.find('[data-ax5picker="date"]').ax5picker({
            direction: "auto",
            content: {
                type: 'date'
            }
        });
        ppmboot.buttonClick(this, "data-page-btn", {      
            "fn1": function () {
                ACTIONS.dispatch(ACTIONS.ADD_FORM);
            },
            "fn2": function () {
                ACTIONS.dispatch(ACTIONS.MOD_FORM);
            },
            "fn3": function () {
                ACTIONS.dispatch(ACTIONS.COPY_FORM);
            },
            "qc-in": function () {
            	 ACTIONS.dispatch(ACTIONS.DOWNLOAD_DOC);
            },
            "down-doc": function () {
           	 ACTIONS.dispatch(ACTIONS.DOWNLOAD_DOC);
           }
        });
    }
});


/**
 * uploadView
 */
fnObj.uploadView = ppmboot.viewExtend(ppmboot.commonView, {
    initView: function () {
        this.target = document["uploadForm"];
        $(this.target).attr("onsubmit", "return fnObj.uploadView.onSubmit();");
    },
    onSubmit: function () {
    	
    	if( this.target.only.value == 'Y' ){
    		if(fnObj.gridView01.getData().length > 0){
    			 alert("한개의 파일만 업로드 가능합니다. 삭제 후 업로드 하세요.");
    	         return false;
    		}
    	}
    	  
        if (this.target.upload.value == "") {
            alert("파일을 선택해주세요.");
            return false;
        }
        this.upload();
        return false;
    },
    upload: function () {
        axMask.open();
        var target_name = "submitwin";
        
        // iframe 생성
        var iframe = $('<iframe src="javascript:false;" name="' + target_name + '" style="display:none;"></iframe>');
        $(document.body).append(iframe);

        // onload 이벤트 핸들러
        // action에서 파일을 받아 처리한 결과값을 텍스트로 출력한다고 가정하고 iframe의 내부 데이터를 결과값으로 callback 호출
        iframe.load(function () {
            var doc = this.contentWindow ? this.contentWindow.document : (this.contentDocument ? this.contentDocument : this.document);
            var root = doc.documentElement ? doc.documentElement : doc.body;
            var result = root.textContent ? root.textContent : root.innerText;
            var res = JSON.parse(result);
            
            console.log(res);
            if (res.error) {
                alert("업로드 실패!!");
            }
            else {
            	alert("업로드 되었습니다.");
                ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
            }
            iframe.remove();
            axMask.close();
        });
        this.target.target = target_name;
        this.target.submit();
        
    }
});

/**
 * gridView01	수주목록
 */
fnObj.gridView01 = ppmboot.viewExtend(ppmboot.gridView, {
    initView: function () {
        var _this = this;
        this.target = ppmboot.gridBuilder({
            showLineNumber: true,
            sortable: true, 
            multiSort: false,
            showRowSelector: true, 
            multiSort:false,
            lineNumberColumnWidth: 40,
            rowSelectorColumnWidth: 26,
            frozenColumnIndex: 0,
            target: $('[data-ax5grid="grid-view-01"]'),
            columns: [
                {key: "slipDt"},
                {key: "slipCd",label:"수주번호", formatter:function(){
                	return "<font><u>"+nvl(this.value,'')+"</u></font>";
                }},
                {key: "saOrderType"},
                {key: "custNm"},
                {key: "userNm"},
                {key: "saOrderDt", label: "수주일자", width: 80, align: "center"},
                {key: "saDeliveryDt", label: "납기일자", width: 80, align: "center"},
                {key: "orderNo",label:"발주번호",width:100, align:"center", hidden:true},
                {key: "surtaxYn"},
                {key: "sumItemQty"},
                {key: "sumSupplyPrice"},
                {key: "sumSurtax"},
                {key: "sumTotalPrice"},
                {key: "updatedAt"},
                {key: "updatedBy"},
                //{key: "addressee", label:"수취인"},
                //{key: "contactAddress1", label:"연락처1"},
                //{key: "contactAddress2", label:"연락처2"},
                //{key: "postcode", label:"우편번호", align:"center"},
                //{key: "address", label:"주소"},
                //{key: "msg", label:"메시지"},
                //{key: "shippingCharge", label:"택배비", align:"right", formatter:"number"}
            ],
            footSum: [
                [  
                    {label: "합계", colspan: 9, align: "center"},
                    {key: "sumItemQty", collector: "sum", formatter:"number", align: "right"},
                    {key: "sumSupplyPrice", collector: "sum", formatter:"number", align: "right"},
                    {key: "sumSurtax", collector: "sum", formatter:"number", align: "right"},
                    {key: "sumTotalPrice", collector: "sum", formatter:"number", align: "right"}
                ]],
            body: { 
                onClick: function () {
                    this.self.select(this.dindex);
                    if(this.column.key != "slipCd") {
                    	ACTIONS.dispatch(ACTIONS.ITEM_CLICK, this.item);
                	}
                },
                onDBLClick: function () {
                    this.self.select(this.dindex);
                	if(this.column.key == "slipCd") {
                        ACTIONS.dispatch(ACTIONS.VIEW_FORM,this.item);
                    	ACTIONS.dispatch(ACTIONS.ITEM_CLICK, this.item);
                	}
                },
            }
        });
        
    },
    getData: function (_type) {
        var list = [];
        var _list = this.target.getList(_type);

        if (_type == "modified" || _type == "deleted") {
            list = ax5.util.filter(_list, function () {
                return this.slipCd;
            });
        } else {
            list = _list;
        }
        return list;
    }
});

/**
 * gridView02 상세목록
 */
fnObj.gridView02 = ppmboot.viewExtend(ppmboot.gridView, {
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
            target: $('[data-ax5grid="grid-view-02"]'),
            columns: [
                {key: "refSlipCd",label:"견적번호", hidden:true, formatter:function(){
                	return "<font><u>"+nvl(this.value,'')+"</u></font>";
                }},
                {key: "remainYn2",label:"수주상태", hidden : false},
            	{
                    label: "품목정보", columns: [
                        {key: "itemCd"},
                        {key: "itemNm"},
                        //{key: "partNo"},
                        {key: "spec"},
                        {key: "unit"},
                    ]
                },
            	{
                    label: "금액정보", columns: [
                        {key: "itemQty"},
                        {key: "unitAmt"},
                        {key: "supplyAmt"},
                        {key: "surtaxAmt"},
                        {key: "totalAmt"},
                    ]
                },
                {key: "itemRemark"},
            ],
            footSum: [
                [  
                    {label: "합계", colspan: 5, align: "center"},
                    {key: "itemQty", collector: "sum", formatter:"number", align: "right"},
                    {key: "unitAmt", collector: "sum", formatter:"number", align: "right"},
                    {key: "supplyAmt", collector: "sum", formatter:"number", align: "right"},
                    {key: "surtaxAmt", collector: "sum", formatter:"number", align: "right"},
                    {key: "totalAmt", collector: "sum", formatter:"number", align: "right"}
                ]],
            body: {
                onDBLClick: function () {
                    this.self.select(this.dindex);
                	if(this.column.key == "refSlipCd") {
                        ACTIONS.dispatch(ACTIONS.VIEW_REF_FORM,this.item);
                	}
                },
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
                return this.itemCd;
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
 * gridView01	수주목록
 */
fnObj.gridView03 = ppmboot.viewExtend(ppmboot.gridView, {
    initView: function () {
        var _this = this;
        this.target = ppmboot.gridBuilder({
            showLineNumber: true,
            sortable: true, 
            multiSort: false,
            showRowSelector: true, 
            multiSort:false,
            lineNumberColumnWidth: 40,
            rowSelectorColumnWidth: 26,
            frozenColumnIndex: 0,
            target: $('[data-ax5grid="grid-view-03"]'),
            columns: [
                {key: "companyNm", label: "보내는사람"},
                {key: "companyTel", label: "전화번호1"},
                {key: "companyAdress", label: "주소"},
                {key: "custNm", label: "받는사람"},
                {key: "tel", label: "전화번호1", width: 80, align: "center"},
                {key: "adress", label: "주소", width: 80, align: "center"},
                {key: "itemNm",label:"품명",width:100, align:"center"},
                {key: "itemQty",label:"수량"},
                {key: "invoiceNumber",label:"송장번호"},
            ],
        });
        
        ppmboot.buttonClick(this, "data-grid-view-03-btn", {
            "dexcel-data-down": function () {
	            ACTIONS.dispatch(ACTIONS.EXCEL_DATA_DOWN);
	        },
        });
    },
    getData: function (_type) {
        var list = [];
        var _list = this.target.getList(_type);

        if (_type == "modified" || _type == "deleted") {
            list = ax5.util.filter(_list, function () {
                return this.slipCd;
            });
        } else {
            list = _list;
        }
        return list;
    }
});