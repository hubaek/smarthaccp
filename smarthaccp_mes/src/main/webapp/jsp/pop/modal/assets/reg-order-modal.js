/**
 * 0. Project	: 스마트HACCP MES
 * 1. 작성자  	: 스마트HACCP 
 * 2. 작성일		: 2021.06.29
 * 3. Comment 	: 작업등록
 */
var fnObj = {};
var param;

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
    	fn_itemType("AM0001");
    }, 
    
    //작업등록
    REG_ORDER: function (caller, act, data) {      	
    	var mData = caller.gridView01.getData("selected");
    	var tempOrderNo = randomStringCd(20);
    	mData[0].orderDt = getNowDt();    
    	mData[0].tempOrderNo = tempOrderNo;
    	mData[0].routingCd = "RT001";
    	mData[0].routCd = "PRC001";
    	mData[0].routSeq = 1;
    	mData[0].equipCd = "EQ001";
    	mData[0].lastFlag = "Y";
    	mData[0].whCd = "S001"; //출하창고
    	//mData[0].orderQty = 100;
    	//mData[0].orderType = "10"; //POP현장에서 작업등록시 작업시작
    	if(g_isEmpty(mData[0].orderQty) || mData[0].orderQty < 1){
    		axDialog.alert({
                theme: "danger",
                width:400,
                msg: "지시수량을 입력해주세요!"
            });        
        	return false;
    	}
    	
        axDialog.confirm({
            theme: "danger",
            width:500,
            msg: "<font color=red>작업등록 하시겠습니까?</font>"
        }, function () {
        	if(this.key == "ok")
        	{
        		ppmboot
                .call({
                    type: "PUT", 
                    url: ["worderMaster","master"], 
                    data: JSON.stringify(mData),
                    callback: function (res) {
                    }
                })
                .done(function () {
                    axToast.push("저장 되었습니다.");
                    parent.ppmboot.modal.callback();
                    //ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
                });
            }
        });    
    	
    },
    
    ITEM_DIV_REFRI: function (caller, act, data) { 
    	$("#div-refri").css("display", "");
    	$("#div-freeze").css("display", "none");
    	$("#reg-order").css("background-color", "#249b24");
    	fn_itemType("AM0001");
    },
    
    ITEM_DIV_FREEZE: function (caller, act, data) { 
    	$("#div-refri").css("display", "none");
    	$("#div-freeze").css("display", "");
    	$("#reg-order").css("background-color", "#0079BF");
    	fn_itemType("AM0002");
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
    _this.gridView01.initView();

    param = parent.ppmboot.modal.getData();
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
            "reg-order": function () {
                ACTIONS.dispatch(ACTIONS.REG_ORDER);
            },
            "close": function () {
                ACTIONS.dispatch(ACTIONS.PAGE_CLOSE);
            },
            "btn-refri": function () {
                ACTIONS.dispatch(ACTIONS.ITEM_DIV_REFRI);
            },
            "btn-freeze": function () {
                ACTIONS.dispatch(ACTIONS.ITEM_DIV_FREEZE);
            },
            "btn-refri-1": function () {
                fn_itemList("btn-refri-1");
            },
            "btn-refri-2": function () {
                fn_itemList("btn-refri-2");
            },
            "btn-refri-3": function () {
                fn_itemList("btn-refri-3");
            },
            "btn-refri-4": function () {
                fn_itemList("btn-refri-4");
            },
            "btn-refri-5": function () {
                fn_itemList("btn-refri-5");
            },
            "btn-refri-6": function () {
                fn_itemList("btn-refri-6");
            },
            "btn-refri-7": function () {
                fn_itemList("btn-refri-7");
            },
            "btn-freeze-1": function () {
                fn_itemList("btn-freeze-1");
            },
            "btn-freeze-2": function () {
                fn_itemList("btn-freeze-2");
            },
            "btn-freeze-3": function () {
                fn_itemList("btn-freeze-3");
            },
            "btn-freeze-4": function () {
                fn_itemList("btn-freeze-4");
            },
            "btn-freeze-5": function () {
                fn_itemList("btn-freeze-5");
            },
            "btn-freeze-6": function () {
                fn_itemList("btn-freeze-6");
            },
            "btn-freeze-7": function () {
                fn_itemList("btn-freeze-7");
            },
            "btn-freeze-8": function () {
                fn_itemList("btn-freeze-8");
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
            showLineNumber: true,
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
            scroller: {size: 35},
            columns: [
            	{key: "itemCd", width:140},
                {key: "itemNm", width:300},
                //{key: "itemType"},   
				{key: "itemMainNm"},
				{key: "itemSubNm", label:"품목분류", width:100},
                {key: "spec", width: 100},   
                //{key: "unit"},
                {key: "orderQty", label: "지시수량",width: 120, formatter:"number", align: "right", editor: {type: "number"} ,styleClass: "grid-cell-blue"}
            ],
            body: {
                columnHeight: 55,
                onClick: function () {
                    this.self.select(this.dindex);
                    if(this.column.key == "cancelBad") {  
                        ACTIONS.dispatch(ACTIONS.RETURN_ITEM, this.item);
                    }
                    $("#calc_result").val(0);
                }
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
    	//console.log(data);
    	var sData = this.getData("selected");
    	var idx = sData[0].__index;
    	this.target.setValue(idx,"orderQty", data.itemQty);
    	//var mData = caller.gridView01.getData("selected");
    	//fnObj.gridView01.target.setValue(0,"itemQty", data.itemQty);
    	//fnObj.gridView01.target.select(0);
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


function $id(id)
{
    return document.getElementById(id);
}

function fn_itemType(itemMainCd){
	ppmboot.ajax({
        type: "GET",
        url: ["item", "itemSub"],
        data:{company:"1000",itemMainCd:itemMainCd},
        callback: function (res) {
            var list = res.list;
            var idx = 1;
        	for(var i=0; i<list.length; i++){
        			//console.log(list[i].itemSubCd);
        		if(itemMainCd=="AM0001"){
        			$("#btn-refri-"+idx).val(list[i].itemSubCd);
        			$("#btn-refri-"+idx).text(list[i].itemSubNm);
        		}else{
        			$("#btn-freeze-"+idx).val(list[i].itemSubCd);
        			$("#btn-freeze-"+idx).text(list[i].itemSubNm);
        		}
        		idx++;
        	}
        }
    });
}

function fn_itemList(param){
	//console.log("param : "+param );
	//console.log($("#"+param).val());
	
	var param2 = {};
    param2.itemSubCd = $("#"+param).val()
    
    ppmboot.ajax({
        type: "GET",
        url: ["item"],
        data: $.extend({}, param2),
        callback: function (res) {   
        	fnObj.gridView01.setData(res);
        }
    }); 
}

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
}


