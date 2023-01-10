/**
 * 0. Project	: SV MES
 * 1. 작성자  	: 국
 * 2. 작성일		: 2020.02.24
 * 3. Comment 	: 매출종합현황
 * 4. 변경이력 : 
 *  			이름		|일자          		|변경내용
 *              ------------------------------------------------------
 *				
 */
var fnObj = {};

var pre2Year;
var pre1Year;
var pre0Year;

var ACTIONS = ppmboot.actionExtend(fnObj, {
    PAGE_SEARCH: function (caller, act, data) {
    	
       	var graphList1 = new Array;    
       	var itemData1 = new Array;   
     	var x1Data = new Array;     	
     	x1Data.push("x");


       	var graphList2 = new Array;    
       	var itemData2 = new Array;   
     	var x2Data = new Array;     	
     	x2Data.push("x");


       	var graphList3 = new Array;    
       	var itemData3 = new Array;   
     	var x3Data = new Array;     	
     	x3Data.push("x");
     	
    	ppmboot
		   	 .call({
		   	     	type: "GET",
		            url: ["sales", "itemDetailGroupByYearMon"],
		            data: $.extend({}, getSerializeArrayToJson("#searchView0")),
		   	        callback: function (res) {	
			   	     	
		   	        	var totalSum = 0;
		   	        	itemData1.push("월별 판매실적");
	    	            res.list.forEach(function (n) {	
	    	             	x1Data.push(n.saMm);
			   	        	itemData1.push(nvl(n.saAmt,0));
	    	            	totalSum = totalSum + n.saAmt;
    	                });

	    	            res.list.forEach(function (n) {
	    	            	if(nvl(n.saAmt,0) > 0){
		    	            	n.saPer =  n.saAmt / totalSum * 100,2;
	    	            	}else{
	    	            		n.saPer = 0 ;
	    	            	}
    	                });

	    	        	graphList1.push(x1Data);   
	    	         	graphList1.push(itemData1);
		   	            caller.gridView01.setData(res);
		   	        }
		   	 })       
		   	 .call({
		   	     	type: "GET",
		            url: ["sales", "itemDetailGroupByYearQuater"],
		            data: $.extend({}, getSerializeArrayToJson("#searchView0")),
		   	        callback: function (res) {	
		   	        	var totalSum = 0;
		   	        	itemData2.push("분기별 판매실적");
		   	        	
	    	            res.list.forEach(function (n) {	
	    	             	x2Data.push(n.saQt);
			   	        	itemData2.push(nvl(n.saAmt,0));
	    	            	totalSum = totalSum + n.saAmt;
    	                });

	    	            res.list.forEach(function (n) {
	    	            	if(nvl(n.saAmt,0) > 0){
		    	            	n.saPer =  n.saAmt / totalSum * 100,2;
	    	            	}else{
	    	            		n.saPer = 0 ;
	    	            	}
    	                });

	    	        	graphList2.push(x2Data);   
	    	         	graphList2.push(itemData2);
		   	            caller.gridView02.setData(res);
		   	        }
		   	 })      
		   	 .call({
		   	     	type: "GET",
		            url: ["sales", "itemDetailGroupByYearCust"],
		            data: $.extend({}, getSerializeArrayToJson("#searchView0")),
		   	        callback: function (res) {	
		   	        	var totalSum1 = 0;
		   	        	itemData3.push("거래처별 판매실적");
	    	            res.list.forEach(function (n) {	
	    	             	x3Data.push(n.custNm);
			   	        	itemData3.push(nvl(n.saPrice1,0));
			   	        	totalSum1 = totalSum1 + n.saPrice1;
    	                });

	    	            res.list.forEach(function (n) {
	    	            	if(nvl(n.saPrice1,0) > 0){
		    	            	n.saPer1 =  n.saPrice1 / totalSum1 * 100,2;
	    	            	}else{
	    	            		n.saPer1 = 0 ;
	    	            	}
    	                });

	    	        	graphList3.push(x3Data);   
	    	         	graphList3.push(itemData3);
		   	            caller.gridView03.setData(res);
		   	        }
		   	 })       
		   	 .call({
		   	     	type: "GET",
		            url: ["sales", "itemDetailGroupByMonthCust"],
		            data: $.extend({}, getSerializeArrayToJson("#searchView0")),
		   	        callback: function (res) {	
	    	            res.list.forEach(function (n) {
	    	            	n.totalAmt =  nvl(n.saPrice1,0) +  nvl(n.saPrice2,0) +  nvl(n.saPrice3,0) +  nvl(n.saPrice4,0) +  nvl(n.saPrice5,0)
	    	            	+ nvl(n.saPrice6,0) +  nvl(n.saPrice7,0) +  nvl(n.saPrice8,0) +  nvl(n.saPrice9,0) +  nvl(n.saPrice10,0) +  nvl(n.saPrice11,0) +  nvl(n.saPrice12,0)
	    	            });
		   	            caller.gridView04.setData(res);
		   	        }
		   	 })       
		   	 .call({
		   	     	type: "GET",
		            url: ["sales", "itemDetailGroupByYearCust20"],
		            data: $.extend({}, getSerializeArrayToJson("#searchView0")),
		   	        callback: function (res) {	

		   	        	var totalSum = 0;
		   	        	var seq = 1;
		   	        	
	    	            res.list.forEach(function (n) {	
	    	            	totalSum = totalSum + n.saAmt;
	    	            	n.seq = seq;
	    	            	seq++;
    	                });

	    	            res.list.forEach(function (n) {
	    	            	if(nvl(n.saAmt,0) > 0){
		    	            	n.saPer =  n.saAmt / totalSum * 100,2;
	    	            	}else{
	    	            		n.saPer = 0 ;
	    	            	}
    	                });
	    	            
		   	            caller.gridView05.setData(res);
		   	        }
		   	 })       
		   	 .call({
		   	     	type: "GET",
		            url: ["sales", "itemDetailGroupByYearCust"],
		            data: $.extend({}, getSerializeArrayToJson("#searchView0")),
		   	        callback: function (res) {	

		   	        	var totalSum1 = 0;
		   	        	var totalSum2 = 0;
		   	        	var totalSum3 = 0;
	    	            res.list.forEach(function (n) {	
			   	        	totalSum1 = totalSum1 + n.saPrice1;
			   	        	totalSum2 = totalSum2 + n.saPrice2;
			   	        	totalSum3 = totalSum3 + n.saPrice3;
	    	            });

	    	            res.list.forEach(function (n) {
	    	            	if(nvl(n.saPrice1,0) > 0){
		    	            	n.saPer1 =  n.saPrice1 / totalSum1 * 100,2;
	    	            	}else{
	    	            		n.saPer1 = 0 ;
	    	            	}

	    	            	if(nvl(n.saPrice2,0) > 0){
		    	            	n.saPer2 =  n.saPrice2 / totalSum2 * 100,2;
	    	            	}else{
	    	            		n.saPer2 = 0 ;
	    	            	}

	    	            	if(nvl(n.saPrice3,0) > 0){
		    	            	n.saPer3 =  n.saPrice3 / totalSum3 * 100,2;
	    	            	}else{
	    	            		n.saPer3 = 0 ;
	    	            	}
	    	            });
		   	            caller.gridView06.setData(res);
		   	        }
		   	 })       
		     .done(function () {     

		    	 var chart1 = bb.generate({
		 			data : {
		 				x : "x",
		 				columns : graphList1,
		 			    type: "bar",
		 			    labels: true,
		 			    colors: {
		 			       "월별 판매실적": "#00ff00",
		 			     },
		 			},
		 		   axis: {
		 			    x: {
			 			      show: true,
		 			      type: "category",
		 			    }
		 			  },
		 		    grid: {
		 			    y: {
		 			      show: true
		 			    }
		 			  },
		 			bindto : "#graph1"
		 		 });
		    	 

		    	 var chart2 = bb.generate({
		 			data : {
		 				x : "x",
		 				columns : graphList2,
		 			    type: "bar",
		 			    labels: true
		 			},
		 		   axis: {
		 			    x: {
			 			      show: true,
			 			      type: "category",
		 			    }
		 			  },
		 		    grid: {
		 			    y: {
		 			      show: true
		 			    }
		 			  },
		 			bindto : "#graph2"
		 		 });
		    	 

		    	 var chart3 = bb.generate({
		 			data : {
		 				x : "x",
		 				columns : graphList3,
		 			    type: "bar",
		 			    labels: true,
		 			    colors: {
			 			       "거래처별 판매실적": "fuchsia",
			 			     },
		 			},
		 		   axis: {
		 			    x: {
		 			      type: "category",
		 			    }
		 			  },
		 		    grid: {
		 			    y: {
		 			      show: true
		 			    }
		 			  },
		 			bindto : "#graph3"
		 		 });
		    	 
   	 
		    });   
        return false;
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
    _this.gridView01.initView();
    _this.gridView02.initView();
    _this.gridView03.initView();
    _this.gridView04.initView();
    _this.gridView05.initView();
    

	pre0Year = $("#inoutYear").val();
	pre1Year = pre0Year - 1;
	pre2Year = pre1Year - 1;
    
    _this.gridView06.initView();

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

//== view 시작
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
 * gridView01
 */
fnObj.gridView01 = ppmboot.viewExtend(ppmboot.gridView, {
    initView: function () {
        var _this = this;
        this.target = ppmboot.gridBuilder({
            showLineNumber: false,
            sortable: false, 
            multiSort: false,
            showRowSelector: false,
            multipleSelect: false,
            frozenColumnIndex: 0,
            target: $('[data-ax5grid="grid-view-01"]'),
            columns: [
                {key: "saMm",label:"월", align: "center", width:40},
                {key: "saAmt",label:"금액", align: "right", formatter:"number", width:90},
                {key: "saPer",label:"점유율(%)", align: "right", formatter:"number", width:70},
            ],
            footSum: [
                [  
                    {label: "합계", colspan: 1, align: "center"},
                    {key: "saAmt", collector: "sum", formatter:"number", align: "right"},
                    {key: "saPer", collector: "sum", formatter:"number", align: "right"},
                ]],
            body: {
                onClick: function () {
                	this.self.select(this.dindex);
                }
            },
            page: {
                display: false
            }
        });
    }
});

/**
 * gridView02
 */
fnObj.gridView02 = ppmboot.viewExtend(ppmboot.gridView, {
    initView: function () {
        var _this = this;
        this.target = ppmboot.gridBuilder({
            showLineNumber: false,
            sortable: false, 
            multiSort: false,
            showRowSelector: false,
            multipleSelect: false,
            frozenColumnIndex: 0,
            target: $('[data-ax5grid="grid-view-02"]'),
            columns: [
                {key: "saQt",label:"분기", align: "center", width:40},
                {key: "saAmt",label:"금액", align: "right", formatter:"number", width:90},
                {key: "saPer",label:"점유율(%)", align: "right", formatter:"number", width:70},
            ],
            footSum: [
                [  
                    {label: "합계", colspan: 1, align: "center"},
                    {key: "saAmt", collector: "sum", formatter:"number", align: "right"},
                    {key: "saPer", collector: "sum", formatter:"number", align: "right"},
                ]],
            body: {
                onClick: function () {
                	this.self.select(this.dindex);
                }
            },
            page: {
                display: false
            }
        });
    }
});


/**
 * gridView03
 */
fnObj.gridView03 = ppmboot.viewExtend(ppmboot.gridView, {
    initView: function () {
        var _this = this;
        this.target = ppmboot.gridBuilder({
            showLineNumber: false,
            sortable: true, 
            multiSort: false,
            showRowSelector: false,
            multipleSelect: false,
            frozenColumnIndex: 0,
            target: $('[data-ax5grid="grid-view-03"]'),
            columns: [
                {key: "custNm",label:"거래처", align: "center", width:120},
                {key: "saPrice1",label:"금액", align: "right", formatter:"number"},
                {key: "saPer1",label:"점유율(%)", align: "right", formatter:"number"},
            ],
            footSum: [
                [  
                    {label: "합계", colspan: 1, align: "center"},
                    {key: "saPrice1", collector: "sum", formatter:"number", align: "right"},
                    {key: "saPer1", collector: "sum", formatter:"number", align: "right"},
                ]],
            body: {
                onClick: function () {
                	this.self.select(this.dindex);
                }
            },
            page: {
                display: false
            }
        });
    }
});


/**
 * gridView04
 */
fnObj.gridView04 = ppmboot.viewExtend(ppmboot.gridView, {
    initView: function () {
        var _this = this;
        this.target = ppmboot.gridBuilder({
            showLineNumber: false,
            sortable: true, 
            multiSort: false,
            showRowSelector: false,
            multipleSelect: false,
            frozenColumnIndex: 0,
            target: $('[data-ax5grid="grid-view-04"]'),
            columns: [
                {key: "custNm",label:"거래처", align: "center", width:120},
                {key: "saPrice1",label:"1월", align: "right", formatter:"number"},
                {key: "saPrice2",label:"2월", align: "right", formatter:"number"},
                {key: "saPrice3",label:"3월", align: "right", formatter:"number"},
                {key: "saPrice4",label:"4월", align: "right", formatter:"number"},
                {key: "saPrice5",label:"5월", align: "right", formatter:"number"},
                {key: "saPrice6",label:"6월", align: "right", formatter:"number"},
                {key: "saPrice7",label:"7월", align: "right", formatter:"number"},
                {key: "saPrice8",label:"8월", align: "right", formatter:"number"},
                {key: "saPrice9",label:"9월", align: "right", formatter:"number"},
                {key: "saPrice10",label:"10월", align: "right", formatter:"number"},
                {key: "saPrice11",label:"11월", align: "right", formatter:"number"},
                {key: "saPrice12",label:"12월", align: "right", formatter:"number"},
                {key: "totalAmt",label:"합계", align: "right", formatter:"number"},
                
            ],
            footSum: [
                [  
                    {label: "합계", colspan: 1, align: "center"},
                    {key: "saPrice1", collector: "sum", formatter:"number", align: "right"},
                    {key: "saPrice2", collector: "sum", formatter:"number", align: "right"},
                    {key: "saPrice3", collector: "sum", formatter:"number", align: "right"},
                    {key: "saPrice4", collector: "sum", formatter:"number", align: "right"},
                    {key: "saPrice5", collector: "sum", formatter:"number", align: "right"},
                    {key: "saPrice6", collector: "sum", formatter:"number", align: "right"},
                    {key: "saPrice7", collector: "sum", formatter:"number", align: "right"},
                    {key: "saPrice8", collector: "sum", formatter:"number", align: "right"},
                    {key: "saPrice9", collector: "sum", formatter:"number", align: "right"},
                    {key: "saPrice10", collector: "sum", formatter:"number", align: "right"},
                    {key: "saPrice11", collector: "sum", formatter:"number", align: "right"},
                    {key: "saPrice12", collector: "sum", formatter:"number", align: "right"},
                    {key: "totalAmt", collector: "sum", formatter:"number", align: "right"},
                ]],
            body: {
                onClick: function () {
                	this.self.select(this.dindex);
                }
            },
            page: {
                display: false
            }
        });
    }
});



/**
 * gridView05
 */
fnObj.gridView05 = ppmboot.viewExtend(ppmboot.gridView, {
    initView: function () {
        var _this = this;
        this.target = ppmboot.gridBuilder({
            showLineNumber: false,
            sortable: true, 
            multiSort: false,
            showRowSelector: false,
            multipleSelect: false,
            frozenColumnIndex: 0,
            target: $('[data-ax5grid="grid-view-05"]'),
            columns: [
                {key: "seq",label:"순위", align: "center", width:80},
                {key: "custNm",label:"업체명", align: "center", width:120},
                {key: "saAmt",label:"금액", align: "right", formatter:"number"},
                {key: "saPer",label:"점유율(%)", align: "right", formatter:"number"},
            ],
            footSum: [
                [  
                    {label: "합계", colspan: 2, align: "center"},
                    {key: "saAmt", collector: "sum", formatter:"number", align: "right"},
                    {key: "saPer", collector: "sum", formatter:"number", align: "right"},
                ]],
            body: {
                onClick: function () {
                	this.self.select(this.dindex);
                }
            },
            page: {
                display: false
            }
        });
    }
});



/**
 * gridView06
 */
fnObj.gridView06 = ppmboot.viewExtend(ppmboot.gridView, {
    initView: function () {
        var _this = this;
        this.target = ppmboot.gridBuilder({
            showLineNumber: false,
            sortable: true, 
            multiSort: false,
            showRowSelector: false,
            multipleSelect: false,
            frozenColumnIndex: 0,
            target: $('[data-ax5grid="grid-view-06"]'),
            columns: [
                {key: "custNm",label:"거래처", align: "center", width:120},
            	{
                    label: pre2Year, columns: [
                        {key: "saPrice3",label:"금액", align: "right", formatter:"number"},
                        {key: "saPer3",label:"점유율(%)", align: "right", formatter:"number"},
                    ]
                },
            	{
                    label: pre1Year, columns: [
                        {key: "saPrice2",label:"금액", align: "right", formatter:"number"},
                        {key: "saPer2",label:"점유율(%)", align: "right", formatter:"number"},
                    ]
                },
            	{
                    label: pre0Year, columns: [
                        {key: "saPrice1",label:"금액", align: "right", formatter:"number"},
                        {key: "saPer1",label:"점유율(%)", align: "right", formatter:"number"},
                    ]
                },
            ],
            footSum: [
                [  
                    {label: "합계", colspan: 1, align: "center"},
                    {key: "saPrice3", collector: "sum", formatter:"number", align: "right"},
                    {key: "saPer3", collector: "sum", formatter:"number", align: "right"},
                    {key: "saPrice2", collector: "sum", formatter:"number", align: "right"},
                    {key: "saPer2", collector: "sum", formatter:"number", align: "right"},
                    {key: "saPrice1", collector: "sum", formatter:"number", align: "right"},
                    {key: "saPer1", collector: "sum", formatter:"number", align: "right"},
                ]],
            body: {
                onClick: function () {
                	this.self.select(this.dindex);
                }
            },
            page: {
                display: false
            }
        });
    }
});


