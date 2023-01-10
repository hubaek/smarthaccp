/**
 * 0. Project	: 스마트HACCP MES
 * 1. 작성자  		: 스마트HACCP 
 * 2. 작성일		: 2018.01.01
 * 3. Comment 	: 바코드발행 패드
 * 4. 변경이력 : 
 *  			이름		|일자          		|변경내용
 *              ------------------------------------------------------
 *				
 */
var fnObj = {};
var param;

var ACTIONS = ppmboot.actionExtend(fnObj, {
    PAGE_CLOSE: function (caller, act, data) { 
    	if (parent) {
        	if (typeof param.callBack === "undefined"){
        		parent.ppmboot.modal2.close();
        	}else{
        		parent.customModal.close();
        	}
        }
    },
    PAGE_SEARCH: function (caller, act, data) {    	 
    	ppmboot
   	   	.call({
   	     	type: "GET",
   	        url: ["/api/v1/pop2/getWorkOrderList"],
            data: {wlotNo: param.wlotNo},
   	        callback: function (res) {
   	        	res[0].barcodeQty = param.stockQty;
   	        	debugger;
   	        	if(res.length > 0){
   	        		for(var i = 0 ; i < res.length ; i++) res[i].barcodeQty = Math.floor(res[i].barcodeQty); // 발행가능수량 소수자리수 표기 제한
   	        		caller.gridView01.setData(res);
   	        		caller.gridView01.target.select(0);
   	        	}
   	        }
	   	 })  
        .done(function () {
        });   
    },
    PAGE_CHOICE: function (caller, act, data) {
    	var mData = caller.gridView01.getData("selected");
        var num = mData[0].itemQty;
        var maxNum = mData[0].barcodeQty;
        
        if(false){
        	axDialog.alert({
                theme: "primary",
                width:500,
                msg: "입력 할 수 없는 수량입니다."
            });
        	return false;
        }else if(Number(num)>Number(maxNum)){
        	axDialog.alert({
                theme: "primary",
                width:500,
                msg: "발행가능수량을 확인하세요."
            });
        	return false;
        }else{            
            if (nvl(num,0) != 0) {

                ACTIONS.dispatch(ACTIONS.DIVISION_BARCODE);
            }
        }
    },
    DIVISION_BARCODE: function (caller, act, data) {  
    	
    	var mData = caller.gridView01.getData("selected");

    	var barcodeQty = nvl(mData[0].itemQty,0);
    	var printCnt = nvl(mData[0].printCnt,0);
	    
    	axDialog.confirm({
            theme: "danger",
            width:500,
            msg: "<font color=red>입력하신 수량으로 바코드발행 하시겠습니까?\n수량:"+barcodeQty+"\n장수:"+printCnt+"</font>"
        }, function () {
        	if(this.key == "ok")
        	{        	

    		    if(barcodeQty>0){  
    		    	
            		var barcodeList = new Array();
            		mData[0].stockCd = param.stockCd;
            		debugger;
            		for(var i = 0 ; i < printCnt ; i++){
                		var item = new Object();
                		item.company = mData[0].company;
                		item.wlotNo = mData[0].wlotNo;
                		item.itemCd = mData[0].itemCd;
                		item.refStockCd = mData[0].stockCd;
            			item.stockCd = '';
                		item.itemQty = mData[0].itemQty;
            			item.boxYn = 'N';
            			item.refBarcode = param.barcode;
                		barcodeList.push(item);
				   }
            		
            		ppmboot.ajax({
        	        	type: "PUT", 
        	        	url: ["stock","stockBox"], 
        		     	data: JSON.stringify(barcodeList),
        		         callback: function (res) {       
        	            	 parent.ppmboot.modal2.callback();
        		             ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
        		         }
    	        	});
    		    }
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
    param = parent.ppmboot.modal2.getData();      

    _this.pageButtonView.initView();
    _this.gridView01.initView();
    
    ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
    
    document.body.onkeydown = function(e){
    	key_detect_calc('calc',e);
    };
};

fnObj.pageResize = function () {

}; 

fnObj.pageButtonView = ppmboot.viewExtend({
    initView: function () {
    	ppmboot.buttonClick(this, "data-page-btn", {
            "choice": function () {
                ACTIONS.dispatch(ACTIONS.PAGE_CHOICE);
            },
            "close": function () {
                ACTIONS.dispatch(ACTIONS.PAGE_CLOSE);
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
            lineNumberColumnWidth: 40,
            rowSelectorColumnWidth: 26,
            frozenColumnIndex: 0, 
            target: $('[data-ax5grid="grid-view-01"]'),
            header: {
                columnHeight: 50
            },
            columns: [
                {key: "itemNm",width:250,formatter:function(){
                	return "<font size=4 color=white>"+nvl(this.value,0)+"</font>";
                }},
                {key: "prodQty",width:120, align: "center",formatter:function(){
                	return "<font size=6 color=white>"+nvl(this.value,0)+"</font>";
                }},
                {key: "barcodeQty",label: "발행가능수량", width: 120, align: "center",formatter:function(){
                	return "<font size=6 color=white>"+nvl(this.value,0)+"</font>";
                }},
                {key: "itemQty", label: "발행수량", width: 150, formatter:"number", align: "center",formatter:function(){
                	return "<font size = 6>"+nvl(this.value,0)+"</font>";
                }},
                {key: "printCnt", label: "발행장수", width: 120, formatter:"number", align: "center",formatter:function(){
                	return "<font size=6 color=red>"+nvl(this.value,0)+"</font>";
                }},
            ],
            body: {
                columnHeight: 60,
            },
            page: {
                display: false
            }
        });        
    },
    setData: function (_data) {
        this.target.setData(_data);
    },
    setCalcResult1:function(data){
    	fnObj.gridView01.target.setValue(0,"itemQty", data.itemQty);
    	fnObj.gridView01.target.setValue(0,"printCnt", data.printCnt);
    	fnObj.gridView01.target.select(0);
    },
    setCalcResult2:function(data){
    	fnObj.gridView01.target.setValue(0,"printCnt", data.printCnt);
    	fnObj.gridView01.target.select(0);
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


function add_calc1(v)
{
	var r = nvl($("#calc_result1").val(),"0");
	
	if(v == "C"){
		$("#calc_result1").val(0);
	}else if (v == "nbs"){
		r = r.substr(0, r.length -1);     
		$("#calc_result1").val(r);
	}else{
		//이미 소수점이 들어갔으면.
		if(r!=0 && v == "." && r.indexOf(v) != -1){
			return false;
		}
		
		if(r == '0'){
			if(v == "."){
				$("#calc_result1").val(r+v);
			}else{
				$("#calc_result1").val(v);
			}
			
		}else{
			$("#calc_result1").val(r+v);
		}
	}
	
	setCalcResult1($("#calc_result1").val());
	return true;
}

function add_calc2(v)
{
	var r = nvl($("#calc_result2").val(),"0");
	
	if(v == "C"){
		$("#calc_result2").val(0);
	}else if (v == "nbs"){
		r = r.substr(0, r.length -1);     
		$("#calc_result2").val(r);
	}else{
		//이미 소수점이 들어갔으면.
		if(r!=0 && v == "." && r.indexOf(v) != -1){
			return false;
		}
		
		if(r == '0'){
			if(v == "."){
				$("#calc_result2").val(r+v);
			}else{
				$("#calc_result`").val(v);
			}
			
		}else{
			$("#calc_result2").val(r+v);
		}
	}
	
	setCalcResult2($("#calc_result2").val());
	return true;
}

function key_detect_calc(id,evt)
{
	if((evt.keyCode>95) && (evt.keyCode<106))
	{
	    var nbr = evt.keyCode-96;
	    add_calc1(nbr);
	}
	else if((evt.keyCode>47) && (evt.keyCode<58))
	{
	    var nbr = evt.keyCode-48;
	    add_calc1(nbr);
	}else if(evt.keyCode==110)
	{
		add_calc1('.');
	}
	else if(evt.keyCode==190)
	{
		add_calc1('.');
	}
	else if(evt.keyCode==188)
	{
		add_calc1('.');
	}
	else if(evt.keyCode==46)
	{
		add_calc1('C');
	}
	else if(evt.keyCode==8)
	{
		add_calc1('nbs');
	}
	else if(evt.keyCode==27)
	{
		add_calc1('C');
	}
	return true;
}

function setDefault(barcodeQty){
	fnObj.gridView01.setDefault({barcodeQty:barcodeQty,printCnt:0});
}

function setCalcResult1(v){
	var mData = fnObj.gridView01.getData("selected");
	var barcodeQty = nvl(v,0);
	var stockQty = nvl(mData[0].barcodeQty,0);	
    
    var printCnt = 0 ;
    if(barcodeQty > 0){
        printCnt = Math.floor(stockQty / barcodeQty);
    }
	
	fnObj.gridView01.setCalcResult1({itemQty:v,printCnt:nvl(printCnt,0)});
}

function setCalcResult2(v){
	fnObj.gridView01.setCalcResult2({printCnt:nvl(v,0)});
}