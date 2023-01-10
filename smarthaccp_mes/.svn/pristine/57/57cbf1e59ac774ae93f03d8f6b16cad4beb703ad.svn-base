/**
 * 0. Project	: 스마트HACCP MES
 * 1. 작성자  		: 스마트HACCP 
 * 2. 작성일		: 2018.01.01
 * 3. Comment 	: 폐기등록
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
	            url: ["/api/v1/pop2/getDiscardTypeList"],
	            data: {useYn:"Y"},
	            callback: function (res) {
	                caller.gridView01.setData(res);
	            }
	        })
	        .call({
	            type: "GET",
	            url:  ["/api/v1/pop2/getOutgoingList"],
	            data: {wlotNo: param.order.wlotNo,discardYn:"Y"},
	            callback: function (res) {
	                caller.gridView02.setData(res);
	            }    
	        })
	       .done(function () {
	           caller.gridView03.setData([]);
	       });  
    	
        return false;
    }, 
    DISCARD_CLICK: function (caller, act, data) {  
    	
        var item = new Object();
        item.discardType = data.discardType;
        item.discardTypeNm = data.discardTypeNm;
        item.bomUnit = param.item.bomUnit;
        
        caller.gridView03.setData([]);
        caller.gridView03.setDefault(item);
        $("#calc_result").val("");
        
    },
    DISCARD_ITEM: function (caller, act, data) {      	
    	var list = caller.gridView03.getData();    	
    	if(list.length > 0){

            var discardYn = "Y";
            var discardType = list[0].discardType;
            var num = list[0].itemQty;
            var unit = list[0].bomUnit;
            
    		var item = param.item;
    		item.discardYn = discardYn;
    		item.discardType = discardType;
    		item.bomItemQty = num;
    		item.bomUnit = unit;
    		item.wlotNo = param.order.wlotNo;
    		
            if(nvl(num,0) == 0){
            	axDialog.alert({
                    theme: "primary",
                    width:500,
                    msg: "폐기수량을 입력하세요."
                });
            	return false;
            }else{

                axDialog.confirm({
                    theme: "danger",
                    width:500,
                    msg: "<font color=red>선택된 자재를 ("+item.bomItemQty +" "+item.bomUnit+") 폐기 하시겠습니까?</font>"
                }, function () {
                	if(this.key == "ok")
                	{

                		var obj = {
        	            	workMaster: param.order,
        	            	workOutgoingItem: item,
        	            };
                		
        	        	ppmboot.ajax({
            	        	type: "PUT", 
            	        	url: ["/api/v1/pop2/saveOutgoing"], 
            		     	data: JSON.stringify(obj),
            		         callback: function (res) {       
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
                msg: "선택된 폐기유형이 없습니다."
            });
        	return false;
    	}
    },  
    //전체환입
    CANCEL_DISCARD: function (caller, act, data) {  
        axDialog.confirm({
            theme: "danger",
            width:500,
            msg: "<font color=red>선택된 자재를 '전체' 폐기취소 처리 하시겠습니까?</font>"
        }, function () {
        	if(this.key == "ok")
        	{
        		var item = data;
        		item.__deleted__ = true;
        		
        		var obj = {
	            	workMaster: param.order,
	            	workOutgoingItem: item,
	            };
        		
	        	ppmboot.ajax({
    	        	type: "PUT", 
    	        	url: ["/api/v1/pop2/cancelOutgoing"], 
    		     	data: JSON.stringify(obj),
    		         callback: function (res) {       
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
    
    ppmboot
	    .call({
	        type: "GET",
	        url:  ["basic", "detail"],
	        data: {mainCd: "DISCARD_TYPE"},
	        callback: function (res) {        		
	            this.DISCARD_TYPE = res.list;
	        }
	    })
	    .done(function () {
	        CODE = this;
	        CONVERT_CODE = convertCommonCode(CODE);
	        param = parent.ppmboot.modal2.getData();
	
	        _this.pageButtonView.initView();
	        _this.gridView01.initView();
	        _this.gridView02.initView();
	        _this.gridView03.initView();
	        
	        ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
	        
	        
	    });
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
                ACTIONS.dispatch(ACTIONS.DISCARD_ITEM);
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
            lineNumberColumnWidth: 40,
            rowSelectorColumnWidth: 26,
            frozenColumnIndex: 0, 
            target: $('[data-ax5grid="grid-view-01"]'),
            header: {
                columnHeight: 50
            },
            scroller: {size: 35},
            columns: [
                {key: "discardTypeNm", label:"폐기명", width:500, align:"left"},
            ],
            body: {
                columnHeight: 55,
                onClick: function () {
                    this.self.select(this.dindex);
                    ACTIONS.dispatch(ACTIONS.DISCARD_CLICK, this.item);
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
				{key:"discardType", label: "폐기유형",width:150, align: "center",formatter: function formatter() {
						return CONVERT_CODE["DISCARD_TYPE"].map[this.value];
					}
				},	
            	{
					label: "폐기(소요단위)", columns: [
	                    {key: "lotNo", width: 150},
	                    {key: "barcode", width: 150},
	                    {key: "bomItemQty", label: "투입수량", width: 150, formatter:"number", align: "right"},
	                    {key: "bomUnit",label:"소요단위",width:150, align: "center"},
	                ]
	            },	
                {key: "cancelStock", label:"폐기취소", align:"center", formatter:function(){
                	return "<button type='button' style='background-color:red' class='btn btn-success W70'>폐기취소</button>";
                }},  
            ],
            body: {
                columnHeight: 55,
                onClick: function () {
                    this.self.select(this.dindex);

                    if(this.column.key == "cancelStock") {  
                        ACTIONS.dispatch(ACTIONS.CANCEL_DISCARD, this.item);
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
                {key: "discardTypeNm",label: "폐기유형", width: 250, align: "center"},
                {key: "itemQty", label: "폐기수량", width: 180, formatter:"number", align: "right",formatter:function(){
                	return "<font size = 6>"+nvl(this.value,0)+"</font>";
                }},
                {key: "bomUnit"},
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
    	fnObj.gridView03.target.setValue(0,"discardType", data.discardType);
    	fnObj.gridView03.target.setValue(0,"discardTypeNm", data.discardTypeNm);
    	fnObj.gridView03.target.setValue(0,"bomUnit", data.bomUnit);
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
    else if(n=='=')
    {
        if(calc_array[id][0]!='=' && calc_array[id][1]!=1)
        {
                eval('calcul='+calc_array[id][2]+calc_array[id][0]+calc_array[id][3]+';');
                calc_array[id][0] = '=';
                $id(id+'_result').value=calcul;
                calc_array[id][2]=calcul;
                calc_array[id][3]=0;
        }
    }
    else if(n=='+-')
    {
        $id(id+'_result').value=$id(id+'_result').value*(-1);
        if(calc_array[id][0]=='=')
        {
                calc_array[id][2] = $id(id+'_result').value;
                calc_array[id][3] = 0;
        }
        else
        {
                calc_array[id][3] = $id(id+'_result').value;
        }
        pas_ch = 1;
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
    else
    {
        if(calc_array[id][0]!='=' && calc_array[id][1]!=1)
        {
	          eval('calcul='+calc_array[id][2]+calc_array[id][0]+calc_array[id][3]+';');
	          $id(id+'_result').value=calcul;
	          calc_array[id][2]=calcul;
	          calc_array[id][3]=0;
        }
        calc_array[id][0] = n;
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
    else if(evt.keyCode==107)
    {
            f_calc(id,'+');
    }
    else if(evt.keyCode==109)
    {
            f_calc(id,'-');
    }
    else if(evt.keyCode==106)
    {
            f_calc(id,'*');
    }
    else if(evt.keyCode==111)
    {
            f_calc(id,'/');
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
    else if(evt.keyCode==13)
    {
            f_calc(id,'=');
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
