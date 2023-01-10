/**
 * 0. Project	: 스마트HACCP MES
 * 1. 작성자  		: 스마트HACCP 
 * 2. 작성일		: 2018.01.01
 * 3. Comment 	: 작업표준서
 * 4. 변경이력 : 
 *  			이름		|일자          		|변경내용
 *              ------------------------------------------------------
 *				
 */
var fnObj = {};
var param;
var imgList = new Array();

var imgStdWidth=1350;
var imgStdHeight=790;

var imgWidth=1350;
var imgHeight=790;

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
        ppmboot.ajax({
            type: "GET",
            url: ["/api/v1/pop2/getWoDocFileList"],
            data: {routCd:param.order.routCd,itemCd:param.order.itemCd},
            callback: function (res) {
            	
            	if(res.length == 0){
            		$("#page1").hide();
            		$("#page2").hide();
            		$("#page3").hide();
            		$("#page4").hide();
            		$("#page5").hide();
            	}else if(res.length == 1){
            		$("#page2").hide();
            		$("#page3").hide();
            		$("#page4").hide();
            		$("#page5").hide();
            	}else if(res.length == 2){
            		$("#page3").hide();
            		$("#page4").hide();
            		$("#page5").hide();
            	}else if(res.length == 3){
            		$("#page4").hide();
            		$("#page5").hide();
            	}else if(res.length == 4){
            		$("#page5").hide();
            	}
            	
            	if(res.length > 0){
            		imgList = res;
            	    ACTIONS.dispatch(ACTIONS.SHOW_IMG,"0");
            	}else{
                    axDialog.alert({
                        theme: "danger",
                        width:500,
                        msg: "등록된 작업표준서가 없습니다.관리자에게 문의하세요."
                    }, function () {
                    	if(this.key == "ok")
                    	{
                    	    ACTIONS.dispatch(ACTIONS.PAGE_CLOSE);
                        }
                    });  
            	}
            }
        });
        return false;
    },
    SHOW_IMG: function (caller, act, data) {      
    	var image = document.getElementById('woDoc');
    	image.src = "/api/v1/files/preview?id="+imgList[data];


    	$(".mCustomScrollBox").clearQueue().animate({height:800,width:1370});    	
    	
    	imgWidth=imgStdWidth;
    	imgHeight=imgStdHeight;
    	
    	$("#woDoc").clearQueue().animate({height:imgStdHeight,width:imgStdWidth});    	
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
    param = parent.ppmboot.modal.getData();
    _this.pageButtonView.initView();
    ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
	
	$("#img-plus").click(function(){
		imgHeight = imgHeight + 100;
		imgWidth = imgWidth + 100;
		$("#woDoc").clearQueue().animate({height:imgHeight,width:imgWidth});
    });
    	  
    $("#img-minus").click(function(){
		imgHeight = imgHeight - 100;
		imgWidth = imgWidth - 100;
  		$("#woDoc").clearQueue().animate({height:imgHeight,width:imgWidth});
  		
    });

	$("#woDoc").clearQueue().animate({height:imgStdHeight,width:imgStdWidth});    	
  	 
};

fnObj.pageResize = function () {
};

fnObj.pageButtonView = ppmboot.viewExtend({
    initView: function () {
    	ppmboot.buttonClick(this, "data-page-btn", {
            "search": function () {
                ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
            },
            "close": function () {
                ACTIONS.dispatch(ACTIONS.PAGE_CLOSE);
            },
            "page1": function () {
                ACTIONS.dispatch(ACTIONS.SHOW_IMG,"0");
            },
            "page2": function () {
                ACTIONS.dispatch(ACTIONS.SHOW_IMG,"1");
            },
            "page3": function () {
                ACTIONS.dispatch(ACTIONS.SHOW_IMG,"2");
            },
            "page4": function () {
                ACTIONS.dispatch(ACTIONS.SHOW_IMG,"3");
            },
            "page5": function () {
                ACTIONS.dispatch(ACTIONS.SHOW_IMG,"4");
            }
        });
    }
});