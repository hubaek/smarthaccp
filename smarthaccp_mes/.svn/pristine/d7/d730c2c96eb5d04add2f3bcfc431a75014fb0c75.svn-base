/**
 * 0. Project	: 스마트HACCP MES
 * 1. 작성자  	: 스마트HACCP_NEW
 * 2. 작성일	: 2020.01.01
 * 3. Comment 	: 출하검사현황
 * 4. 변경이력 : 
 *  			이름		|일자          		|변경내용
 *              ------------------------------------------------------
 *				
 */
var fnObj = {};
var qcType = "20"//출하검사

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
    	var sData = getSerializeArrayToJson("#searchView0");
    	sData.saCustCode = nvl(sData.custCd,'');
    	sData.saCustName = nvl(sData.custNm,'');
    	ppmboot
	   	 .call({
	   	     	type: "GET",
	            url: ["qcManage","getQcMasterList"],
	            data: $.extend({qcType:qcType}, sData),
	   	         callback: function (res) {			        	 
	   	            caller.gridView01.setData(res);
	   	         }
	   	 })       
	     .done(function () {     	       	
	     });   
    },      
    OPEN_BAD_MODAL: function (caller, act, data) {   
    	var idx = data.dindex;
    	customModal.open({
            width: 900,
            height: 700,
            iframe: {
                method: "get",
                url: "/jsp/mes/QC/modal/QC-BAD-MV.jsp",
                param: "slipCd="+data.item.slipCd +"&qcType="+qcType
            }
        });    	
    },
    OPEN_QC_DETAIL_MODAL: function (caller, act, data) {  
    	var idx = data.dindex;
    	customModal.open({
            width: 1360,
            height: 750,
            iframe: {
                method: "get",
                url: "/jsp/mes/QC/modal/QC-DETAIL-MV.jsp",
                param: "slipCd="+data.item.slipCd +"&qcType="+qcType+"&itemCd="+data.item.itemCd
            }
        });    	
    },
    OPEN_QC_DOC_MODAL: function (caller, act, data) {  
    	var idx = data.dindex;
    	customModal.open({
            width: 900,
            height: 300,
            iframe: {
                method: "get",
                url: "/jsp/mes/QC/modal/QC-DOC-MV.jsp",
                param: "slipCd="+data.item.slipCd +"&qcType="+qcType+"&itemCd="+data.item.itemCd +"&itemNm="+data.item.itemNm
            }
        });    	
    },
    //엑셀 다운로드 2020-12-09 추가
    EXCEL_DOWNLOAD: function (caller, act, data) {
    	caller.gridView01.target.exportExcel("출하검사현황.xls");
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

fnObj.pageButtonView = ppmboot.viewExtend({
    initView: function () {
        ppmboot.buttonClick(this, "data-page-btn", {
        	"search": function () {
                ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
            },
            "excel": function () {
                ACTIONS.dispatch(ACTIONS.EXCEL_DOWNLOAD);
            }
        });
    }
});

fnObj.pageStart = function () {	
	var _this = this;
    ppmboot
	    .call({
	        type: "GET",
	        url: ["basic", "detail"],
	        data: {mainCd:"QC_FLAG", useYn: "Y"},
	        callback: function (res) {        
	            this.QC_FLAG = res.list;
	        }
	    })
        .done(function () {
            CODE = this;
	        CONVERT_CODE = convertCommonCode(CODE);         
	        
            _this.pageButtonView.initView();
            _this.searchView.initView();
            _this.gridView01.initView();
            ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
        });
};

fnObj.pageResize = function () {

};

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
 * gridView
 */
fnObj.gridView01 = ppmboot.viewExtend(ppmboot.gridView, {
    initView: function () {
        var _this = this;
        this.target = ppmboot.gridBuilder({
            showRowSelector: true,
            frozenColumnIndex: 0,
            target: $('[data-ax5grid="grid-view-01"]'),
            columns: [
                {key: "inDt" , label:"입고일"},  
                {key: "itemCd"},
                {key: "itemNm"},     
                {key: "spec"},
                {key: "custNm"},     
                {key: "whCd"},
                {key: "lotNo"},
                {key: "barcode"},
                {key: "unit"},  
                {key: "qcWay"},
                {key: "qcDt", label: "검사일자", width: 100, align: "center"},
				{key:"qcFlag", label: "검사결과",width:100, align: "center", 
                	formatter: function formatter() {
    					return CONVERT_CODE["QC_FLAG"].map[this.value];
					}
				},				  
                {key: "inQty", label: "입고수량", width: 80, formatter:"number", align: "right"},
	            {key: "badQty",label:"불량수량",width: 80 ,styleClass: "grid-cell-purple"},
                {key: "itemQty", label: "합격수량", width: 80, formatter:"number", align: "right"},
	            {key: "qcDetailYn",label:"검사내역",width: 80, align: "center" ,styleClass: "grid-cell-purple"},
	            {key: "qcDocYn",label:"성적서",width: 80, align: "center",styleClass: "grid-cell-purple"},
                {key: "updatedBy",label:"검사자"},
            ],
            body: {
                onClick: function () {
                    this.self.select(this.dindex);
                    if(this.column.key == "badQty") {
                    	ACTIONS.dispatch(ACTIONS.OPEN_BAD_MODAL,this);
                    }
		        	if(this.column.key == "qcDetailYn") {
                    	ACTIONS.dispatch(ACTIONS.OPEN_QC_DETAIL_MODAL,this);
                    }
		        	if(this.column.key == "qcDocYn") {
                    	ACTIONS.dispatch(ACTIONS.OPEN_QC_DOC_MODAL,this);
                    }
                }
            }
        });
    },
    getData: function (_type) {
        var list = [];
        var _list = this.target.getList(_type);

        if (_type == "modified" || _type == "deleted") {
            list = ax5.util.filter(_list, function () {
                return this.whCd;
            });
        } else {
            list = _list;
        }
        return list;
    }
});