/**
 * 0. Project	: 한상유통
 * 1. 작성자  	: 김재민
 * 2. 작성일		: 2020.06.24
 * 3. Comment 	: 택배송장조회
 * 4. 변경이력 		: 
 *  			이름		|일자          		|변경내용
 *              ------------------------------------------------------
 *				
 */


var fnObj = {};
var ACTIONS = ppmboot.actionExtend(fnObj, {
	PAGE_SEARCH: function (caller, act, data) {		// 조회할때
    	var sData = getSerializeArrayToJson("#searchView0");
    	var num = sData.dvrNum;
    	var company = sData.dvrCd;
    	
    	if (company == ''){
    		
        	axDialog.alert("운송사를 선택해주세요");
        	return false;
    		
    	};
    	
    	if (num == ''){
    		
        	axDialog.alert("운송장번호를 입력해주세요");
        	return false;
    		
    	};
    	
    	ppmboot
	   	 .call({
	   	     	type: "GET",
	   	     	url:  ["Delivery", "detail"],
	            data: {num : num, company :company},
	   	        callback: function (res) {
	   	        	
	   	     	if (res.length == 0 ){
	   	    		
	   	        	axDialog.alert("운송장 번호를 확인해주세요");
	   	        	caller.gridView01.clear();
	   	        	return false;
	   	    		
	   	    	};
	   	        	
	   	            caller.gridView01.setData(res);
	   	         }
	   	 })
	   	 .call({
		   		type: "GET",
	   	     	url:  ["Delivery", "master"],
	            data: {num : num, company :company},
	   	        callback: function (res) {
	   	        	
		   	     	if (res.length == 0 ){
		   	    		
		   	        	
		   	        	caller.gridView02.clear();
		   	        	return false;
		   	    		
		   	    	};
	   	        	
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
            // 직접코딩
            return false;
        }
    }
});

//fnObj 기본 함수 스타트와 리사이즈
fnObj.pageStart = function () {
	var _this = this; 
	_this.pageButtonView.initView();
    _this.searchView.initView();
    _this.gridView01.initView();
    _this.gridView02.initView();
    
//  ppmboot  
//	  .call({
//	      type: "GET",
//	      url:  ["basic", "detail"],
//	      data: {mainCd: "STATUS"},
//	      callback: function (res) {              
//	          this.STATUS = res.list;
//	      }
//	  })
//	  .done(function () {
//	      CODE = this;
//	      CONVERT_CODE = convertCommonCode(CODE);
//	  });
  
//  ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
  

};

fnObj.pageResize = function () {
};


fnObj.pageButtonView = ppmboot.viewExtend({
 initView: function () {
     ppmboot.buttonClick(this, "data-page-btn", {
         "search": function () {
             ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
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
 * gridView
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
                {key: "STATUS", label: "단계", width: 170, align: "left"},
                {key: "TIME", label: "처리", width: 230, align: "center"},
                {key: "DESC", label: "상품상태", width: 600, align: "left"},
                {key: "LOC", label: "담당점소", width: 170, align: "left"},
            ],
            body: {
                onClick: function () {
                    this.self.select(this.dindex);
                    ACTIONS.dispatch(ACTIONS.ITEM_CLICK, this.item);
                    
                    if(this.column.key == "inspectionMonth"){
                    	ACTIONS.dispatch(ACTIONS.VIEW_FORM,this.item);
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
                return this.subCd;
            });
        } else {
            list = _list;
        }
        return list;
    },
});

fnObj.gridView02 = ppmboot.viewExtend(ppmboot.gridView, {
    initView: function () {
        var _this = this;

        this.target = ppmboot.gridBuilder({
            showLineNumber: false,
            sortable: true, 
            multiSort: false,
            showRowSelector: false,
            multipleSelect: false,
            lineNumberColumnWidth: 40,
            rowSelectorColumnWidth: 26,
            frozenColumnIndex: 0,
            target: $('[data-ax5grid="grid-view-02"]'),
            columns: [      	
                {key: "cust", label: "배달업체", width: 150, align: "center"},
                {key: "SENDER", label: "보내는 사람", width: 150, align: "center"},
                {key: "shipDate", label: "발신일자", width: 200, align: "center"},
                {key: "RECEIVER", label: "받는사람", width: 150, align: "center"}
            ],
            body: {
                onClick: function () {
                    this.self.select(this.dindex);
                    ACTIONS.dispatch(ACTIONS.ITEM_CLICK, this.item);
                    
                    if(this.column.key == "inspectionMonth"){
                    	ACTIONS.dispatch(ACTIONS.VIEW_FORM,this.item);
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
                return this.subCd;
            });
        } else {
            list = _list;
        }
        return list;
    },
});


