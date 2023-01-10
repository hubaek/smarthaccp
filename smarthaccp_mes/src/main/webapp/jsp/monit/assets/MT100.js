/**
 * 0. Project	: SCV 
 * 1. 작성자  	: 스마트HACCP
 * 2. 작성일		: 2019.06.17
 * 3. Comment 	: MONIT
 * 4. 변경이력 : 
 *  			이름		|일자          		|변경내용
 *              ------------------------------------------------------
 */

var fnObj = {};
var selectionId = 0;
var selectionCnt = 5;
var timerId; 
var settingTime = 5000;

var ACTIONS = ppmboot.actionExtend(fnObj, {
    PAGE_SEARCH: function (caller, act, data) {
        ppmboot.ajax({
            type: "GET",
			 url: ["worderList" ,"workOrderList"],
            data: {},
            callback: function (res) {            
                caller.gridView01.setData(res);
            	totalSelectCnt = res.list.length;
                if(totalSelectCnt > 0){
        		    fnObj.gridView01.target.focus(0);
                }
            	selectionId = 0;
            }
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

	$("#start-monit").show();
	$("#end-monit").hide();
	
    ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
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
            lineNumberColumnWidth: 40,
            rowSelectorColumnWidth: 26,
            frozenColumnIndex: 0,
            target: $('[data-ax5grid="grid-view-01"]'),
            header: {
                columnHeight: 70
            },
            columns: [
                {key: "orderDt",width: 120},
                {key: "orderNo",width: 150},
                {key: "routCd",width: 200}, 
                {key: "equipCd",width: 250},
                {key: "orderSt",width: 120, styleClass: function () {
                	var css = "";
                	if(nvl(this.item.orderSt,'') == 'RUN'){
                		css = "grid-cell-blue";
        			}else if(nvl(this.item.orderSt,'') == 'NWRK'){
        				css = "grid-cell-red";
        			}else if(nvl(this.item.orderSt,'') == 'END'){
        				css = "grid-cell-green";
        			}
                    return css;
                }, formatter: function formatter() { 
                	if(this.item.orderSt == 'RUN'){
                		return "가동중";
                	}else if(this.item.orderSt == 'NWRK'){  
                		return "비가동";
                	}else if(this.item.orderSt == 'END'){  
                		return "종료";
                	}else{
                		return "<font color='black'>"+this.value+"</font>";
                	}
                }},
                {key: "routQcYn",width: 120, styleClass: function () {
                    return (nvl(this.item.routQcYn,'N') == 'N') ? "grid-cell-red" : "grid-cell-blue";
                }, formatter: function formatter() { 
                	if(this.item.routQcYn == 'Y'){
                		return "검사";
                	}else{  
                		return "미검사";
                	}
                }},
                {key: "outYn",width: 120, styleClass: function () {
                    return (nvl(this.item.outYn,'N') == 'N') ? "grid-cell-red" : "grid-cell-blue";
                }, formatter: function formatter() { 
                	if(this.item.outYn == 'Y'){
                		return "투입";
                	}else{  
                		return "미투입";
                	}
                }},
                {key: "itemCd"},
                {key: "itemNm",width: 250},
                {key: "orderQty",label:"지시"},
                {key: "prodQty",label:"생산"},
                {key: "badQty",label:"불량"},
                {key: "goodQty",label:"양품"},
                {key: "orderPer", label: "생산율(%)",width: 120, formatter:"number", align: "right"},
            ],
            body: {
                columnHeight: 80,
                onClick: function () {
                	this.self.select(this.dindex);
                }
            },
            page: {
                display: false
            }
        });

        ppmboot.buttonClick(this, "data-grid-view-01-btn", {
            "full-size": function () {
            	openFullScreenMode();
            },
            "small-size": function () {
            	closeFullScreenMode();
            },
        	"search": function () {
                ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
            },
        	"start-monit": function () {
        		clockStart();
            },
        	"end-monit": function () {
        		clockStop();
            }
        });
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
    }
});

function clockStart() {  
	var dataSize = fnObj.gridView01.getData().length;
	if(dataSize > 0){
		if (timerId){
			return;
		}else{
			timerId = setInterval(update, settingTime);
			update();
			$("#start-monit").hide();
			$("#end-monit").show();
		}
		
	}
}

function clockStop() {
	$("#start-monit").show();
	$("#end-monit").hide();
	clearInterval(timerId)
	timerId = null;
}


function update() {
	  var date = new Date()

	  var hours = date.getHours()
	  if (hours < 10) hours = '0'+hours
	  document.getElementById('hour').innerHTML = hours

	  var minutes = date.getMinutes()
	  if (minutes < 10) minutes = '0'+minutes
	  document.getElementById('min').innerHTML = minutes

	  var seconds = date.getSeconds()
	  if (seconds < 10) seconds = '0'+seconds	  
	  
	  document.getElementById('sec').innerHTML = seconds
	   
	  try {
		 if(totalSelectCnt >= selectionId){
			 selectionId = selectionId + selectionCnt;
		    $("#loadingPageCnt").html(selectionId + " / " + totalSelectCnt );
		    fnObj.gridView01.target.focus(selectionId);
		 }else{
		        ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
		 }
	 }
	 catch(err) {
	 }	  
}


var docV = document.documentElement;
//전체화면 설정
function openFullScreenMode() {
 if (docV.requestFullscreen)
     docV.requestFullscreen();
 else if (docV.webkitRequestFullscreen) // Chrome, Safari (webkit)
     docV.webkitRequestFullscreen();
 else if (docV.mozRequestFullScreen) // Firefox
     docV.mozRequestFullScreen();
 else if (docV.msRequestFullscreen) // IE or Edge
     docV.msRequestFullscreen();
}
//전체화면 해제
function closeFullScreenMode() {
 if (document.exitFullscreen)
     document.exitFullscreen();
 else if (document.webkitExitFullscreen) // Chrome, Safari (webkit)
     document.webkitExitFullscreen();
 else if (document.mozCancelFullScreen) // Firefox
     document.mozCancelFullScreen();
 else if (document.msExitFullscreen) // IE or Edge
     document.msExitFullscreen();
}