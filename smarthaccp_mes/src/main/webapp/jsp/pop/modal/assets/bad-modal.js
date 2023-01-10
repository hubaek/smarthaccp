/**
 * 0. Project	: 스마트HACCP MES
 * 1. 작성자  		: 스마트HACCP 
 * 2. 작성일		: 2018.01.01
 * 3. Comment 	: 불량등록
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
	            url: ["/api/v1/pop2/getBadTypeList"],
	            data: {routCd:param.order.routCd,useYn:"Y"},
	            callback: function (res) {
	                caller.gridView01.setData(res);
	            }
	        })
	        .call({
	            type: "GET",
	            url:  ["/api/v1/pop2/getWorkBadList"],
	            data: {wlotNo: param.order.wlotNo},
	            callback: function (res) {
	                caller.gridView02.setData(res);
	            }    
	        })
	       .done(function () {
	           caller.gridView03.setData([]);
	       });  
    	
        return false;
    }, 
    BAD_CLICK: function (caller, act, data) {  
        var item = new Object();
        item.badCd = data.badCd;
        item.badNm = data.badNm;
        caller.gridView03.setData([]);
        caller.gridView03.setDefault(item);
        $("#calc_result").val("");
        
    },
    //자재출고
    BAD_ITEM: function (caller, act, data) {      	
    	var list = caller.gridView03.getData();    	
    	if(list.length > 0){

            var num = list[0].itemQty;
            
            if(nvl(num,0) == 0){
            	axDialog.alert({
                    theme: "primary",
                    width:500,
                    msg: "불량수량을 입력하세요."
                });
            	return false;
            }else{

                axDialog.confirm({
                    theme: "danger",
                    width:500,
                    msg: "<font color=red>불량등록 하시겠습니까?</font>"
                }, function () {
                	if(this.key == "ok")
                	{
                		var item = list[0];

                		item.company = param.order.company;
                		item.badQty = num;
                		item.wlotNo = param.order.wlotNo;
                		
        	        	ppmboot.ajax({
            	        	type: "PUT", 
            	        	url: ["/api/v1/pop2/saveWorkBad"], 
            		     	data: JSON.stringify(item),
            		         callback: function (res) {       
            	            	 parent.ppmboot.modal.callback();
            		             ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
            		         }
        	        	});
                    }
                });    
            } 
    	}else{
        	axDialog.alert({
                theme: "primary",
                width:500,
                msg: "선택된 불량유형이 없습니다."
            });
        	return false;
    	}
    },  
    //불량취소
    RETURN_ITEM: function (caller, act, data) {  
        axDialog.confirm({
            theme: "danger",
            width:500,
            msg: "<font color=red>불량취소 하시겠습니까?</font>"
        }, function () {
        	if(this.key == "ok")
        	{
        		var item = data;
        		item.badDtm = "";
        		
	        	ppmboot.ajax({
    	        	type: "PUT", 
    	        	url: ["/api/v1/pop2/cancelWorkBad"], 
    		     	data: JSON.stringify(item),
    		         callback: function (res) {       
    		        	 parent.ppmboot.modal.callback();
    		             ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
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
    
    _this.pageButtonView.initView();
    _this.gridView01.initView();
    _this.gridView02.initView();
    _this.gridView03.initView();

    param = parent.ppmboot.modal.getData();
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
            "search": function () {
                ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
            },
            "choice": function () {
                ACTIONS.dispatch(ACTIONS.BAD_ITEM);
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
            showLineNumber: true,
            sortable: false, 
            multiSort: false,
            showRowSelector: false,
            multipleSelect: false,
            lineNumberColumnWidth: 50,
            rowSelectorColumnWidth: 26,
            frozenColumnIndex: 0, 
            target: $('[data-ax5grid="grid-view-01"]'),
            header: {
                columnHeight: 50
            },
            scroller: {size: 35},
            columns: [
                {key: "badNm", label:"불량명", width:625, align:"left"},
            ],
            body: {
                columnHeight: 55,
                onClick: function () {
                    this.self.select(this.dindex);
                    ACTIONS.dispatch(ACTIONS.BAD_CLICK, this.item);
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
 * gridView02
 */
fnObj.gridView02 = ppmboot.viewExtend(ppmboot.gridView, {
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
            target: $('[data-ax5grid="grid-view-02"]'),
            header: {
                columnHeight: 50
            },
            scroller: {size: 35},
            columns: [
                {key: "badNm", label:"불량명", width:300, align:"left"},
                {key: "badQty", label: "불량수량", width: 180, formatter:"number", align: "right"},
                {key: "unit", width: 180},
                {key: "badDtm", label:"불량시간", width:380 , align:"center"},
                {key: "cancelBad", label:"불량취소", align:"center", formatter:function(){
                	return "<button type='button' style='background-color:red' class='btn btn-success W70'>불량취소</button>";
                }},  
            ],
            body: {
                columnHeight: 55,
                onClick: function () {
                    this.self.select(this.dindex);
                    if(this.column.key == "cancelBad") {  
                        ACTIONS.dispatch(ACTIONS.RETURN_ITEM, this.item);
                    }
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
 * gridView03
 */
fnObj.gridView03 = ppmboot.viewExtend(ppmboot.gridView, {
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
            target: $('[data-ax5grid="grid-view-03"]'),
            header: {
                columnHeight: 50
            },
            columns: [
                {key: "badNm",label: "불량유형", width: 250, align: "center"},
                {key: "itemQty", label: "불량수량", width: 224, formatter:"number", align: "right",formatter:function(){
                	return "<font size = 6>"+nvl(this.value,0)+"</font>";
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
    setDefault:function(data){
    	fnObj.gridView03.addRow();
    	fnObj.gridView03.target.setValue(0,"badCd", data.badCd);
    	fnObj.gridView03.target.setValue(0,"badNm", data.badNm);
    	fnObj.gridView03.target.select(0);
    },
    setCalcResult:function(data){
    	fnObj.gridView03.target.setValue(0,"itemQty", data.itemQty);
    	fnObj.gridView03.target.select(0);
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






///계산로직
calc_array = new Array();
var calcul=0;
var pas_ch=0;


function $id(id)
{
    return document.getElementById(id);
}


function f_calc(id,n)
{
    if(n=='ce')
    {
            init_calc(id);
    }
    else if(n=='nbs')
    {
        if($id(id+'_result').value<10 && $id(id+'_result').value>-10)
        {
            $id(id+'_result').value=0;
        }
        else
        {
            $id(id+'_result').value=$id(id+'_result').value.slice(0,$id(id+'_result').value.length-1);
        }
        if(calc_array[id][0]=='=')
        {
            calc_array[id][2] = $id(id+'_result').value;
            calc_array[id][3] = 0;
        }
        else
        {
            calc_array[id][3] = $id(id+'_result').value;
        }
    }
    
    if(pas_ch==0)
    {
        calc_array[id][1] = 1;
    }
    else
    {
        pas_ch=0;
    }
    document.getElementById(id+'_result').focus();
    setCalcResult($("#calc_result").val());
    
    return true;
}


function add_calc(id,n)
{
	
    if(calc_array[id][1]==1)
    {
            $id(id+'_result').value=n;
    }
    else
    {
            $id(id+'_result').value+=n;
    }
    if(calc_array[id][0]=='=')
    {
            calc_array[id][2] = $id(id+'_result').value;
            calc_array[id][3] = 0;
    }
    else
    {
            calc_array[id][3] = $id(id+'_result').value;
    }
    calc_array[id][1] = 0;
    document.getElementById(id+'_result').focus();
    setCalcResult($("#calc_result").val());
    return true;
}


function init_calc(id)
{
    $id(id+'_result').value=0;
    calc_array[id] = new Array('=',1,'0','0',0);
    document.getElementById(id+'_result').focus();
    return true;
}


function key_detect_calc(id,evt)
{
    if((evt.keyCode>95) && (evt.keyCode<106))
    {
            var nbr = evt.keyCode-96;
            add_calc(id,nbr);
    }
    else if((evt.keyCode>47) && (evt.keyCode<58))
    {
            var nbr = evt.keyCode-48;
            add_calc(id,nbr);
    }
    else if(evt.keyCode==110)
    {
            add_calc(id,'.');
    }
    else if(evt.keyCode==190)
    {
            add_calc(id,'.');
    }
    else if(evt.keyCode==188)
    {
            add_calc(id,'.');
    }
    else if(evt.keyCode==46)
    {
            f_calc(id,'ce');
    }
    else if(evt.keyCode==8)
    {
            f_calc(id,'nbs');
    }
    else if(evt.keyCode==27)
    {
            f_calc(id,'ce');
    }
    return true;
}

function setCalcResult(v){
	fnObj.gridView03.setCalcResult({itemQty:v});
}

document.getElementById('calc').onload=init_calc('calc');
