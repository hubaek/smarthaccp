/**
 * 0. Project	: 스마트HACCP MES
 * 1. 작성자  	: 스마트HACCP_NEW
 * 2. 작성일	: 2020.01.01
 * 3. Comment 	: 공통코드 관리
 * 4. 변경이력 : 
 *  			이름		|일자          		|변경내용
 *              ------------------------------------------------------
 *				
 */
var fnObj = {};
var maxSeq;
var year;
var maxYear;
var janFlag = false;
var febFlag = false;
var marFlag = false;
var aprFlag = false;
var mayFlag = false;
var junFlag = false;
var julFlag = false;
var augFlag = false;
var sepFlag = false;
var octFlag = false;
var novFlag = false;
var decFlag = false;
var ACTIONS = ppmboot.actionExtend(fnObj, {
    PAGE_SEARCH: function (caller, act, data) {
    	var sData = getSerializeArrayToJson("#searchView0");
    	year = sData.year;
        ppmboot
        .call({
            type: "GET",
            url: ["plan", "getPlanList"],
            data: $.extend({qcYyyy:year, qcNm:sData.qcNm}, getSerializeArrayToJson("#searchView0")),
            callback: function (res) {
            	if(sData.qcNm == '' || sData.qcNm == null || sData.qcNm == undefined){
            		maxSeq = res.length;
            	}
            	caller.gridView01.setData(res);
            }
        })
        .call({
    		type: "GET",
	        url: ["plan","maxYear"],
	     	data: {},
	     	callback: function(res) {
	     		if(res[0] != null){
	     			maxYear = parseInt(res[0].maxYear) + 1;	     			
	     		}
	     	}
    	})
    	.done(function () {    		
    	});
        return false;
    },
    PAGE_SAVE: function (caller, act, data) {
    	var dData = [].concat(caller.gridView01.getData("modified"));
            dData = dData.concat(caller.gridView01.getData("deleted"));
            mData = caller.gridView01.getData();
            ppmboot
            .call({
                type: "PUT", url: ["plan", "putPlan"], data: JSON.stringify(dData),
                callback: function (res) {
                }
            })
            .done(function () {
                axToast.push("저장 되었습니다.");
                ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
            });

    },
    JAN_CLICK: function (caller, act, data){
    	mData = caller.gridView01.getData("selected");
    	if(mData[0].janPlan == "Y"){
    		janFlag = true;
    	}else{
    		janFlag = false
    	};    	    	
    	
    },
    FEB_CLICK: function (caller, act, data){
    	mData = caller.gridView01.getData("selected");
    	if(mData[0].febPlan == "Y"){
    		febFlag = true;
    	}else{
    		febFlag = false
    	};    	    	
    	
    },
    MAR_CLICK: function (caller, act, data){
    	mData = caller.gridView01.getData("selected");
    	if(mData[0].marPlan == "Y"){
    		marFlag = true;
    	}else{
    		marFlag = false
    	};    	    	
    	
    },
    APR_CLICK: function (caller, act, data){
    	mData = caller.gridView01.getData("selected");
    	if(mData[0].aprPlan == "Y"){
    		aprFlag = true;
    	}else{
    		aprFlag = false
    	};    	    	
    	
    },
    MAY_CLICK: function (caller, act, data){
    	mData = caller.gridView01.getData("selected");
    	if(mData[0].mayPlan == "Y"){
    		mayFlag = true;
    	}else{
    		mayFlag = false
    	};    	    	
    	
    },
    JUN_CLICK: function (caller, act, data){
    	mData = caller.gridView01.getData("selected");
    	if(mData[0].junPlan == "Y"){
    		junFlag = true;
    	}else{
    		junFlag = false
    	};    	    	
    	
    },
    JUL_CLICK: function (caller, act, data){
    	mData = caller.gridView01.getData("selected");
    	if(mData[0].julPlan == "Y"){
    		julFlag = true;
    	}else{
    		julFlag = false
    	};    	    	
    	
    },
    AUG_CLICK: function (caller, act, data){
    	mData = caller.gridView01.getData("selected");
    	if(mData[0].augPlan == "Y"){
    		augFlag = true;
    	}else{
    		augFlag = false
    	};    	    	
    	
    },
    SEP_CLICK: function (caller, act, data){
    	mData = caller.gridView01.getData("selected");
    	if(mData[0].sepPlan == "Y"){
    		sepFlag = true;
    	}else{
    		sepFlag = false
    	};    	    	
    	
    },
    OCT_CLICK: function (caller, act, data){
    	mData = caller.gridView01.getData("selected");
    	if(mData[0].octPlan == "Y"){
    		octFlag = true;
    	}else{
    		octFlag = false
    	};    	    	
    	
    },
    NOV_CLICK: function (caller, act, data){
    	mData = caller.gridView01.getData("selected");
    	if(mData[0].novPlan == "Y"){
    		novFlag = true;
    	}else{
    		novFlag = false
    	};    	    	
    	
    },
    DEC_CLICK: function (caller, act, data){
    	mData = caller.gridView01.getData("selected");
    	if(mData[0].decPlan == "Y"){
    		decFlag = true;
    	}else{
    		decFlag = false
    	};    	    	
    	
    },
    BTN_FN1: function (caller, act, data) {
    	var mData = caller.gridView01.getData();
    	var sData = getSerializeArrayToJson("#searchView0");    	
    	year = sData.year;
    	ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);	// searchView에서 년도를 선택후 조회를 누르지 않고 복사를 할 경우를 대비하여 복사하기전 조회를 한다. - kjm
    	axDialog.confirm({
    		theme: "primary",
    		msg: year+"년을 "+maxYear + "년으로\n복사하시겠습니까?"
    	}, function(){
    		if(this.key=="ok"){    			
    			var sData =	caller.gridView01.getData();
    			var dData = [].concat(caller.gridView01.getData("modified"));
                dData = dData.concat(caller.gridView01.getData("deleted"));
                console.log(dData);
    	        
    	        sData.forEach(function(n){
    	        	n.qcYyyy = maxYear;
    	        	n.janResult = "N";
    	        	n.janRemark = "";
    	        	n.febResult = "N";
    	        	n.febRemark = "";
    	        	n.marResult = "N";
    	        	n.marRemark = "";
    	        	n.aprResult = "N";
    	        	n.aprRemark = "";
    	        	n.mayResult = "N";
    	        	n.mayRemark = "";
    	        	n.junResult = "N";
    	        	n.junRemark = "";
    	        	n.julResult = "N";
    	        	n.julRemark = "";
    	        	n.augResult = "N";
    	        	n.augRemark = "";
    	        	n.sepResult = "N";
    	        	n.sepRemark = "";
    	        	n.octResult = "N";
    	        	n.octRemark = "";
    	        	n.novResult = "N";
    	        	n.novRemark = "";
    	        	n.decResult = "N";  
    	        	n.decRemark = "";
    	        });
    	        console.log(dData);
    	        ppmboot
                .call({
                    type: "PUT", url: ["plan", "putPlan"], data: JSON.stringify(sData),
                    callback: function (res) {
                    }
                })
                .done(function () {
                    axToast.push("복사 되었습니다.");
                    ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
                });
    		}
    	}
    	)
    },
    ITEM_SUB_ADD: function (caller, act, data) {
        caller.gridView01.addRow();
    },
    ITEM_SUB_DEL: function (caller, act, data) {
        caller.gridView01.delRow("selected");
    }, 
    //엑셀 다운로드 2020-12-09 추가
    EXCEL_DOWNLOAD: function (caller, act, data) {
    	caller.gridView01.target.exportExcel("품질검사 연간계획.xls");
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
    _this.gridView01.initView();

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
            "save": function () {
                ACTIONS.dispatch(ACTIONS.PAGE_SAVE);
            },
            "fn1": function(){
            	ACTIONS.dispatch(ACTIONS.BTN_FN1);
            },
            "excel": function () {
                ACTIONS.dispatch(ACTIONS.EXCEL_DOWNLOAD);
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
 * gridView01
 */
fnObj.gridView01 = ppmboot.viewExtend(ppmboot.gridView, {

    initView: function () {
        var _this = this;
        this.target = ppmboot.gridBuilder({
            showLineNumber: false,
            sortable: true, 
            multiSort: false,
            showRowSelector: true,
            multipleSelect: false,
            lineNumberColumnWidth: 40,
            rowSelectorColumnWidth: 26,
            target: $('[data-ax5grid="grid-view-01"]'),
            columns: [
            	{key: "qcYyyy", label: "검사년도", hidden:true},
            	{key: "qcCd", label: "검사유형코드", hidden:true},
            	{key: "qcNm", label: "검사유형", width: 100, align: "center", editor: "text",styleClass: "grid-cell-blue"},
            	{
            		label:"1월", columns:[
            			{key:"janPlan", label:"계획", width: 50, align: "center",editor: {type: "checkbox", config: {height: 17, trueValue: "Y", falseValue: "N"}}},
            			{key:"janResult", label:"실적", width: 50, align: "center",editor: {type: "checkbox", config: {height: 17, trueValue: "Y", falseValue: "N"}}},
            			{key:"janRemark", label:"비고", width: 100, align: "center",editor:{type:"textarea"}}
            		]
            	},
            	{
            		label:"2월", columns:[
            			{key:"febPlan", label:"계획", width: 50, align: "center",editor: {type: "checkbox", config: {height: 17, trueValue: "Y", falseValue: "N"}}},
            			{key:"febResult", label:"실적", width: 50, align: "center",editor: {type: "checkbox", config: {height: 17, trueValue: "Y", falseValue: "N"}}},
            			{key:"febRemark", label:"비고", width: 100, align: "center",editor:{type:"textarea"}}
            		]
            	},
            	{
            		label:"3월", columns:[
            			{key:"marPlan", label:"계획", width: 50, align: "center",editor: {type: "checkbox", config: {height: 17, trueValue: "Y", falseValue: "N"}}},
            			{key:"marResult", label:"실적", width: 50, align: "center",editor: {type: "checkbox", config: {height: 17, trueValue: "Y", falseValue: "N"}}},
            			{key:"marRemark", label:"비고", width: 100, align: "center",editor:{type:"textarea"}}
            		]
            	},
            	{
            		label:"4월", columns:[
            			{key:"aprPlan", label:"계획", width: 50, align: "center",editor: {type: "checkbox", config: {height: 17, trueValue: "Y", falseValue: "N"}}},
            			{key:"aprResult", label:"실적", width: 50, align: "center",editor: {type: "checkbox", config: {height: 17, trueValue: "Y", falseValue: "N"}}},
            			{key:"aprRemark", label:"비고", width: 100, align: "center",editor:{type:"textarea"}}
            		]
            	},
            	{
            		label:"5월", columns:[
            			{key:"mayPlan", label:"계획", width: 50, align: "center",editor: {type: "checkbox", config: {height: 17, trueValue: "Y", falseValue: "N"}}},
            			{key:"mayResult", label:"실적", width: 50, align: "center",editor: {type: "checkbox", config: {height: 17, trueValue: "Y", falseValue: "N"}}},
            			{key:"mayRemark", label:"비고", width: 100, align: "center",editor:{type:"textarea"}}
            		]
            	},
            	{
            		label:"6월", columns:[
            			{key:"junPlan", label:"계획", width: 50, align: "center",editor: {type: "checkbox", config: {height: 17, trueValue: "Y", falseValue: "N"}}},
            			{key:"junResult", label:"실적", width: 50, align: "center",editor: {type: "checkbox", config: {height: 17, trueValue: "Y", falseValue: "N"}}},
            			{key:"junRemark", label:"비고", width: 100, align: "center",editor:{type:"textarea"}}
            		]
            	},
            	{
            		label:"7월", columns:[
            			{key:"julPlan", label:"계획", width: 50, align: "center",editor: {type: "checkbox", config: {height: 17, trueValue: "Y", falseValue: "N"}}},
            			{key:"julResult", label:"실적", width: 50, align: "center",editor: {type: "checkbox", config: {height: 17, trueValue: "Y", falseValue: "N"}}},
            			{key:"julRemark", label:"비고", width: 100, align: "center",editor:{type:"textarea"}}
            		]
            	},
            	{
            		label:"8월", columns:[
            			{key:"augPlan", label:"계획", width: 50, align: "center",editor: {type: "checkbox", config: {height: 17, trueValue: "Y", falseValue: "N"}}},
            			{key:"augResult", label:"실적", width: 50, align: "center",editor: {type: "checkbox", config: {height: 17, trueValue: "Y", falseValue: "N"}}},
            			{key:"augRemark", label:"비고", width: 100, align: "center",editor:{type:"textarea"}}
            		]
            	},
            	{
            		label:"9월", columns:[
            			{key:"sepPlan", label:"계획", width: 50, align: "center",editor: {type: "checkbox", config: {height: 17, trueValue: "Y", falseValue: "N"}}},
            			{key:"sepResult", label:"실적", width: 50, align: "center",editor: {type: "checkbox", config: {height: 17, trueValue: "Y", falseValue: "N"}}},
            			{key:"sepRemark", label:"비고", width: 100, align: "center",editor:{type:"textarea"}}
            		]
            	},
            	{
            		label:"10월", columns:[
            			{key:"octPlan", label:"계획", width: 50, align: "center",editor: {type: "checkbox", config: {height: 17, trueValue: "Y", falseValue: "N"}}},
            			{key:"octResult", label:"실적", width: 50, align: "center",editor: {type: "checkbox", config: {height: 17, trueValue: "Y", falseValue: "N"}}},
            			{key:"octRemark", label:"비고", width: 100, align: "center",editor:{type:"textarea"}}
            		]
            	},
            	{
            		label:"11월", columns:[
            			{key:"novPlan", label:"계획", width: 50, align: "center",editor: {type: "checkbox", config: {height: 17, trueValue: "Y", falseValue: "N"}}},
            			{key:"novResult", label:"실적", width: 50, align: "center",editor: {type: "checkbox", config: {height: 17, trueValue: "Y", falseValue: "N"}}},
            			{key:"novRemark", label:"비고", width: 100, align: "center",editor:{type:"textarea"}}
            		]
            	},
            	{
            		label:"12월", columns:[
            			{key:"decPlan", label:"계획", id:"decPlan", width: 50, align: "center",editor: {type: "checkbox", config: {height: 17, trueValue: "Y", falseValue: "N"}}},
            			{key:"decResult", label:"실적", width: 50, align: "center",editor: {type: "checkbox", config: {height: 17, trueValue: "Y", falseValue: "N"}}},            			
            			{key:"decRemark", label:"비고", width: 100, align: "center",editor:{type:"textarea"}}
            		]
            	},
            ],
            body: {
                onClick: function (index) {
                	this.self.select(this.dindex);   
                	
                    if(index.colIndex == 1){
                    	ACTIONS.dispatch(ACTIONS.JAN_CLICK, this.item);
                    	if(janFlag == false){
                    		this.self.setValue(index.dindex,this.self.columns[3].columns[1].key,"N");
                    	}
                    }
                    if(index.colIndex == 2){
                    	ACTIONS.dispatch(ACTIONS.JAN_CLICK, this.item);
                    	if(janFlag == false){                    		
                    		axDialog.alert({
            		            theme: "primary",
            		              msg: "계획이 없습니다."
            		   	 	});
                    		this.self.setValue(index.dindex,this.self.columns[3].columns[1].key,"N");
                    	}
                    	janFlag = false;
                    }
                    
                    if(index.colIndex == 4){
                    	ACTIONS.dispatch(ACTIONS.FEB_CLICK, this.item);
                    	if(febFlag == false){
                    		this.self.setValue(index.dindex,this.self.columns[4].columns[1].key,"N");
                    	}
                    }
                    if(index.colIndex == 5){
                    	ACTIONS.dispatch(ACTIONS.FEB_CLICK, this.item);
                    	if(febFlag == false){                    		
                    		axDialog.alert({
            		            theme: "primary",
            		              msg: "계획이 없습니다."
            		   	 	});
                    		this.self.setValue(index.dindex,this.self.columns[4].columns[1].key,"N");
                    	}
                    	febFlag = false;
                    }
                    
                    if(index.colIndex == 7){
                    	ACTIONS.dispatch(ACTIONS.MAR_CLICK, this.item);
                    	if(marFlag  == false){
                    		this.self.setValue(index.dindex,this.self.columns[5].columns[1].key,"N");
                    	}
                    }
                    if(index.colIndex == 8){
                    	ACTIONS.dispatch(ACTIONS.MAR_CLICK, this.item);
                    	if(marFlag == false){                    		
                    		axDialog.alert({
            		            theme: "primary",
            		              msg: "계획이 없습니다."
            		   	 	});
                    		this.self.setValue(index.dindex,this.self.columns[5].columns[1].key,"N");
                    	}
                    	marFlag = false;
                    }
                    
                    if(index.colIndex == 10){
                    	ACTIONS.dispatch(ACTIONS.APR_CLICK, this.item);
                    	if(aprFlag == false){
                    		this.self.setValue(index.dindex,this.self.columns[6].columns[1].key,"N");
                    	}
                    }
                    if(index.colIndex == 11){
                    	ACTIONS.dispatch(ACTIONS.APR_CLICK, this.item);
                    	if(aprFlag == false){                    		
                    		axDialog.alert({
            		            theme: "primary",
            		              msg: "계획이 없습니다."
            		   	 	});
                    		this.self.setValue(index.dindex,this.self.columns[6].columns[1].key,"N");
                    	}
                    	aprFlag = false;
                    }
                    
                    if(index.colIndex == 13){
                    	ACTIONS.dispatch(ACTIONS.MAY_CLICK, this.item);
                    	if(mayFlag == false){
                    		this.self.setValue(index.dindex,this.self.columns[7].columns[1].key,"N");
                    	}
                    }
                    if(index.colIndex == 14){
                    	ACTIONS.dispatch(ACTIONS.MAY_CLICK, this.item);
                    	if(mayFlag == false){                    		
                    		axDialog.alert({
            		            theme: "primary",
            		              msg: "계획이 없습니다."
            		   	 	});
                    		this.self.setValue(index.dindex,this.self.columns[7].columns[1].key,"N");
                    	}
                    	mayFlag  = false;
                    }
                    
                    if(index.colIndex == 16){
                    	ACTIONS.dispatch(ACTIONS.JUN_CLICK, this.item);
                    	if(junFlag == false){
                    		this.self.setValue(index.dindex,this.self.columns[8].columns[1].key,"N");
                    	}
                    }
                    if(index.colIndex == 17){
                    	ACTIONS.dispatch(ACTIONS.JUN_CLICK, this.item);
                    	if(junFlag == false){                    		
                    		axDialog.alert({
            		            theme: "primary",
            		              msg: "계획이 없습니다."
            		   	 	});
                    		this.self.setValue(index.dindex,this.self.columns[8].columns[1].key,"N");
                    	}
                    	junFlag = false;
                    }
                    
                    if(index.colIndex == 19){
                    	ACTIONS.dispatch(ACTIONS.JUL_CLICK, this.item);
                    	if(julFlag == false){
                    		this.self.setValue(index.dindex,this.self.columns[9].columns[1].key,"N");
                    	}
                    }
                    if(index.colIndex == 20){
                    	ACTIONS.dispatch(ACTIONS.JUL_CLICK, this.item);
                    	if(julFlag == false){                    		
                    		axDialog.alert({
            		            theme: "primary",
            		              msg: "계획이 없습니다."
            		   	 	});
                    		this.self.setValue(index.dindex,this.self.columns[9].columns[1].key,"N");
                    	}
                    	julFlag = false;
                    }
                    
                    if(index.colIndex == 22){
                    	ACTIONS.dispatch(ACTIONS.AUG_CLICK, this.item);
                    	if(augFlag == false){
                    		this.self.setValue(index.dindex,this.self.columns[10].columns[1].key,"N");
                    	}
                    }
                    if(index.colIndex == 23){
                    	ACTIONS.dispatch(ACTIONS.AUG_CLICK, this.item);
                    	if(augFlag == false){                    		
                    		axDialog.alert({
            		            theme: "primary",
            		              msg: "계획이 없습니다."
            		   	 	});
                    		this.self.setValue(index.dindex,this.self.columns[10].columns[1].key,"N");
                    	}
                    	augFlag = false;
                    }
                    
                    if(index.colIndex == 25){
                    	ACTIONS.dispatch(ACTIONS.SEP_CLICK, this.item);
                    	if(sepFlag == false){
                    		this.self.setValue(index.dindex,this.self.columns[11].columns[1].key,"N");
                    	}
                    }
                    if(index.colIndex == 26){
                    	ACTIONS.dispatch(ACTIONS.SEP_CLICK, this.item);
                    	if(sepFlag == false){                    		
                    		axDialog.alert({
            		            theme: "primary",
            		              msg: "계획이 없습니다."
            		   	 	});
                    		this.self.setValue(index.dindex,this.self.columns[11].columns[1].key,"N");
                    	}
                    	sepFlag = false;
                    }
                    
                    if(index.colIndex == 28){
                    	ACTIONS.dispatch(ACTIONS.OCT_CLICK, this.item);
                    	if(octFlag == false){
                    		this.self.setValue(index.dindex,this.self.columns[12].columns[1].key,"N");
                    	}
                    }
                    if(index.colIndex == 29){
                    	ACTIONS.dispatch(ACTIONS.OCT_CLICK, this.item);
                    	if(octFlag == false){                    		
                    		axDialog.alert({
            		            theme: "primary",
            		              msg: "계획이 없습니다."
            		   	 	});
                    		this.self.setValue(index.dindex,this.self.columns[12].columns[1].key,"N");
                    	}
                    	octFlag = false;
                    }
                    
                    if(index.colIndex == 31){
                    	ACTIONS.dispatch(ACTIONS.NOV_CLICK, this.item);
                    	if(novFlag == false){
                    		this.self.setValue(index.dindex,this.self.columns[13].columns[1].key,"N");
                    	}
                    }
                    if(index.colIndex == 32){
                    	ACTIONS.dispatch(ACTIONS.NOV_CLICK, this.item);
                    	if(novFlag == false){                    		
                    		axDialog.alert({
            		            theme: "primary",
            		              msg: "계획이 없습니다."
            		   	 	});
                    		this.self.setValue(index.dindex,this.self.columns[13].columns[1].key,"N");
                    	}
                    	novFlag = false;
                    }
                    
                    if(index.colIndex == 34){
                    	ACTIONS.dispatch(ACTIONS.DEC_CLICK, this.item);
                    	if(decFlag == false){
                    		this.self.setValue(index.dindex,this.self.columns[14].columns[1].key,"N");
                    	}
                    }
                    if(index.colIndex == 35){
                    	ACTIONS.dispatch(ACTIONS.DEC_CLICK, this.item);
                    	if(decFlag == false){                    		
                    		axDialog.alert({
            		            theme: "primary",
            		              msg: "계획이 없습니다."
            		   	 	});
                    		this.self.setValue(index.dindex,this.self.columns[14].columns[1].key,"N");
                    	}
                    	decFlag = false;
                    }
                }
            }
        });
        ppmboot.buttonClick(this, "data-grid-view-01-btn", {
            "item-add": function () {
                ACTIONS.dispatch(ACTIONS.ITEM_SUB_ADD);
            },
            "item-remove": function () {
                ACTIONS.dispatch(ACTIONS.ITEM_SUB_DEL);
            }
        });
        //엑셀 붙여넣기
      /* document.getElementById("gridView01").addEventListener('paste', function(e){
    	   handlePasteGridView(e, fnObj.gridView02.target, "Y");  	//event ,target, addYn 
       });*/
    },
    getData: function (_type) {
        var list = [];
        var _list = this.target.getList(_type);

        if (_type == "modified" || _type == "deleted") {
            list = ax5.util.filter(_list, function () {
                return this.qcYyyy;
            });
        } else {
            list = _list;
        }
        return list;
    },
    align: function () {
        this.target.align();
    },
    addRow: function () {
    	maxSeq = maxSeq +1;
    	var ListLeng = maxSeq.toString().length;
		
    	if(ListLeng == "1"){
			var qcCd = "QC_000" + maxSeq
		}else if(ListLeng == "2"){
			var qcCd = "QC_00" + maxSeq
		}else if(ListLeng == "3"){
			var qcCd = "QC_0" + maxSeq
		}else if(ListLeng == "4"){
			var qcCd = "QC_" + maxSeq
		}
    	
        this.target.addRow({__created__: true,  qcYyyy:year,qcCd: qcCd}, "last");
    }
});
