/**
 * 0. Project	: 스마트HACCP MES
 * 1. 작성자  		: 스마트HACCP 
 * 2. 작성일		: 2018.01.01
 * 3. Comment 	: 자재환입 패드
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
    PAGE_CHOICE: function (caller, act, data) {    	
    	
    	var g = caller.gridView01.getData();
    	
    	
        var num = g[0].outQty;
        var maxNum = g[0].maxQty;
        //var unit = g[0].bomUnit;
        
        if(false){
        	axDialog.alert({
                theme: "primary",
                width:500,
                msg: "입력 할 수 없는 수량입니다."
            });
        	return false;
        }else if(num>maxNum){
        	axDialog.alert({
                theme: "primary",
                width:500,
                msg: "환입가능수량을 확인하세요."
            });
        	return false;
        }else{
            var obj = {
            	num: num,
            	//unit: unit,
            	item: param.obj
            };
            
            if (nvl(num,0) != 0) {
            	if (typeof param.callBack === "undefined"){
            		parent.ppmboot.modal2.callback(obj);
            	}else{            		
            		parent[param.callBack](obj);      
            	}
            }
        }
    },
    ITEM_CLICK: function (caller, act, data) {
        ACTIONS.dispatch(ACTIONS.PAGE_CHOICE);
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
    param = parent.ppmboot.modal2.getData();            
    if(param.obj.bomUnit == param.obj.unit){
        $("#bom_unit_btn").val(param.obj.bomUnit);
    }else{
        $("#bom_unit_btn").val(param.obj.bomUnit);
        $("#unit_btn").val(param.obj.unit);
    }

    _this.pageButtonView.initView();
    _this.gridView01.initView();

    var item = new Object();

    item.itemNm = param.obj.itemNm;
    item.maxQty = param.obj.itemQty;
    item.maxQty = param.obj.bomItemQty;
    item.bomUnit = param.obj.bomUnit;
    _this.gridView01.setDefault(item);
	
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
                {key: "itemNm", width: 200},
                {key: "maxQty",label: "환입가능수량", width: 120, align: "center"},
                {key: "bomUnit",label:"환입단위"},
                {key: "outQty", label: "환입수량", width: 180, formatter:"number", align: "right",formatter:function(){
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
    	fnObj.gridView01.addRow();
    	fnObj.gridView01.target.setValue(0,"itemNm", data.itemNm);
    	fnObj.gridView01.target.setValue(0,"maxQty", data.maxQty);
    	fnObj.gridView01.target.setValue(0,"bomUnit", data.bomUnit);
    	fnObj.gridView01.target.select(0);
    },
    setCalcResult:function(data){
    	fnObj.gridView01.target.setValue(0,"outQty", data.outQty);
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
      //setCalcResult($("#calc_result").val());
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
	fnObj.gridView01.setCalcResult({outQty:v});
}

document.getElementById('calc').onload=init_calc('calc');