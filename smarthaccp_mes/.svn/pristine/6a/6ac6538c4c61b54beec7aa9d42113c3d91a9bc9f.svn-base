/**
 * 0. Project	: 스마트HACCP MES
 * 1. 작성자  		: 스마트HACCP 
 * 2. 작성일		: 2018.01.01
 * 3. Comment 	: 양품등록
 * 4. 변경이력 : 
 *  			이름		|일자          		|변경내용
 *              ------------------------------------------------------
 *				
 */
var fnObj = {};
var param;
var bflag = 0; 	// 1 = box, 2 = ea

//모달 재정의 Start
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
    	
    	$("#calc_result").val("0");
    	
    	ppmboot
   	   	.call({
   	     	type: "GET",
   	        url: ["/api/v1/pop2/getWorkOrderList"],
            data: {wlotNo: param.wlotNo},
   	        callback: function (res) {
   	        	/*
   	        	if(res[0].unit == "BOX"){
   	        		document.getElementById('box_button').style.backgroundColor='red';
   	        	}else{
   	        		document.getElementById('unit_button').style.backgroundColor='red';
   	        	}
   	        	*/
   	        	if(res.length > 0){
   	        		caller.gridView01.setData(res);
   	        		caller.gridView01.target.select(0);
   	        	}
   	        }
	   	 })  
        .done(function () {
        });   
    },
    IN_ITEM1: function (caller, act, data) {
    	var mData = caller.gridView01.getData("selected");    	
        var num = mData[0].itemQty;
        var btn = mData[0].unit;
        
        if(mData[0].wlotNo == undefined){
    		axDialog.alert({
                theme: "primary",
                width:500,
                msg: "작업지시 등록을 해주세요."
            });
        	return false;
    	}
    	
        if(nvl(num,0) == 0){
        	axDialog.alert({
                theme: "primary",
                width:500,
                msg: "실적 수량을 입력하세요."
            });
        	return false;
        }else{
        	
	        	axDialog.confirm({
                    theme: "danger",
                    width:500,
                    msg: "<font color=red>"+num+"개 등록 하시겠습니까?</font>"
                }, function () {
                	if(this.key == "ok")
                	{            		
                		var item = new Object();
                		item.company = "1000";//mData[0].company;
                		item.wlotNo = mData[0].wlotNo;
                		item.stockCd = mData[0].stockCd;
                		item.itemCd = mData[0].itemCd;
                		item.itemQty = num;
                		item.boxQty = 0;
                		item.eaQty = num;
        	        	ppmboot.ajax({
            	        	type: "PUT", 
            	        	url: ["/api/v1/pop2/updateWorkProdQty"], 
            		     	data: JSON.stringify(item),
            		        callback: function (res) {       
           		        	 	parent.ppmboot.modal.callback();
           		        	 	bflag = "0";  
           		        	 axDialog.confirm({
        		        	 		msg:"입고 완료",
        		        	 		btns:{
        		        	 			ok:{
        		        	 				label:"확인", theme:'primary', onClick:function(key){
        		        	 					if(this.value.label == "확인"){
           		        	 						location.reload(true);
           		        	 					}
        		        	 					console.log(this.value, this);
        		        	 				}
        		        	 			}
        		        	 		}
        		        	 	});
           		        	 	//location.reload(true);
            		        }
        	        	});
                    }
                });
	        
            	  
        }
    },
    
    CANCEL_ITEM: function (caller, act, data) { 
    	var mData = caller.gridView01.getData("selected");
    	//var btn = mData[0].unit;
    	var num = mData[0].itemQty;	// 생산수량 - 입력수량
    	let today = new Date();
    	let year = today.getFullYear().toString(); // 년도
    	let month = (today.getMonth() + 1).toString();  // 월
    	let date = today.getDate().toString();  // 날짜
    	if(month.length != 2){
    		month = "0"+month;
    	}
    	if(date.length != 2){
    		date = "0"+date
    	}
    	day = year+"-"+month+"-"+date;
    	console.log(mData[0]);
    	if(mData[0].stockCd == "N" || mData[0].whCd != "J001"){
    		axDialog.alert({
                theme: "primary",
                width:500,
                msg: "재고가 없습니다."
            });
        	return false;
    	}
    		axDialog.confirm({
                theme: "danger",
                width:500,
                msg: "<font color=red>출고 하시겠습니까?</font>"
            }, function () {
            	if(this.key == "ok")
            	{
            		
            			var item = new Object();
            			item.company = "1000";
            			item.itemQty = num;
            			item.boxQty = num;
            			item.eaQty = 0;
            			item.stockCd = mData[0].stockCd;
            			item.outDt = day;
            			item.itemCd = mData[0].itemCd;
            			item.etcYn = "N";
            			item.whType = "30";
            			ppmboot.ajax({
            				type: "PUT", 
            	        	url: ["/api/v1/pop2/cancelWorkProdQty2"], 
            		     	data: JSON.stringify(item),
            		     	callback: function (res) {
           		        	 	parent.ppmboot.modal.callback();
            		        }
            			});            			
            		
                }
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

fnObj.pageStart = function () {
    var _this = this;
    param = parent.ppmboot.modal.getData();      

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
            "choice1": function () {
                ACTIONS.dispatch(ACTIONS.IN_ITEM1);
            },
            "choice2": function () {
            	ACTIONS.dispatch(ACTIONS.CANCEL_ITEM);
            },
            "close": function () {
                ACTIONS.dispatch(ACTIONS.PAGE_CLOSE);
            },
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
                columnHeight: 80
            },
            columns: [
              {key: "itemNm",label: "<span style='font-size:45px'>품목명</span>",width:510, formatter:function(){
            	  return "<font size = 6>"+nvl(this.value,0)+"</font>";
              }},
            //2020-07-27 p/n 숨김 처리 최정욱
              //{key: "partNo",width:120,label:"P/N", align: "center"},
              {key: "spec",width:120,label:"규격", hidden:true, align: "center"},
              {key: "unit",width:120, hidden:true},
              {key: "orderQty", hidden:true, width:100},
              {key: "prodQty", hidden:true, width:100},
              {key: "badQty", hidden:true, width:100},
              {key: "goodQty", hidden:true, width:100},
              {key: "itemQty", label: "추가실적", hidden:true, width: 150, formatter:"number", align: "right",formatter:function(){
              	return "<font size = 6>"+nvl(this.value,0)+"</font>";
              }},
            ],
            body: {
                columnHeight: 110,
            },
            page: {
                display: false
            }
        });        
    },
    setData: function (_data) {
        this.target.setData(_data);
    },
    setCalcResult:function(data){
    	fnObj.gridView01.target.setValue(0,"itemQty", data.itemQty);
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



function add_calc(v)
{
	var r = nvl($("#calc_result").val(),"0");
	
	if(v == "C"){
		$("#calc_result").val(0);
	}else if (v == "nbs"){
		r = r.substr(0, r.length -1);     
		$("#calc_result").val(r);
	}else{
		//이미 소수점이 들어갔으면.
		if(r!=0 && v == "." && r.indexOf(v) != -1){
			return false;
		}
		
		if(r == '0'){
			if(v == "."){
				$("#calc_result").val(r+v);
			}else{
				$("#calc_result").val(v);
			}
			
		}else{
			$("#calc_result").val(r+v);
		}
	}
	
	setCalcResult($("#calc_result").val());
	return true;
}


function key_detect_calc(id,evt)
{
	if((evt.keyCode>95) && (evt.keyCode<106))
	{
	    var nbr = evt.keyCode-96;
	    add_calc(nbr);
	}
	else if((evt.keyCode>47) && (evt.keyCode<58))
	{
	    var nbr = evt.keyCode-48;
	    add_calc(nbr);
	}else if(evt.keyCode==110)
	{
		add_calc('.');
	}
	else if(evt.keyCode==190)
	{
		add_calc('.');
	}
	else if(evt.keyCode==188)
	{
		add_calc('.');
	}
	else if(evt.keyCode==46)
	{
		add_calc('C');
	}
	else if(evt.keyCode==8)
	{
		add_calc('nbs');
	}
	else if(evt.keyCode==27)
	{
		add_calc('C');
	}
	return true;
}


function setCalcResult(v){
	fnObj.gridView01.setCalcResult({itemQty:v});
	$("#itemQty").val(v);
}
// 20.08.11 여기부터 추가
function customStockModalCallback2(data){
	   fnObj.gridView01.setData(data);
	   //fnObj.gridView01.addParentRow2(data);
}

function itemSearchModal(){
	var itemTypeGroup = "";                   
	customModal.open({
        width: 1200,
        height: 700,
        iframe: {
            method: "get",
            url: "/jsp/pop/modal/POP-ITEM-SEL-M.jsp", 
            param: "callBack=customStockModalCallback2&itemTypeGroup=" + itemTypeGroup
        }
	}); 
}

$('#box_button').on('click', function(){
	$('#unit_button').removeClass('selected');
	$(this).addClass('selected');
});
$('#unit_button').on('click', function(){
	$('#box_button').removeClass('selected');
	$(this).addClass('selected');
});