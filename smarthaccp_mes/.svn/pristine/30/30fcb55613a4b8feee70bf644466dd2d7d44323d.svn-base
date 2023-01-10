var cmm = new (function() {
	this.ajax = new Object();
	this.document = new Object();
	this.grid = new Object();
	this.ui = new Object();
	
	return this;
})();
cmm.uiUtil = function(){};
/**
 * POST 전송을 제공합합니다.
 * 사용예) 
 * var postSend = new cmm.ui.PostSend('x');
 * postSend.add('xi1', 'zz');
 * postSend.add('xi2', 'yy');
 * 
 * postSend.send('/server/server.do');
 */
cmm.uiUtil.PostSend = function(formname,ttarget){
	var formObj=document.getElementById(formname) ;
	var formName =formname;
	if (!formObj){
		formObj =document.createElement("form");
		formObj.name = formname;
		formObj.id = formname;
		document.body.appendChild(formObj);
	}
	formObj.method="POST";
	formObj.target=ttarget?ttarget:"_self";
	
	this.add = function(sname, sval){
		if(!sname || !sval) return;
		
		var obj =$("#"+formName+" input[name="+sname+"]")[0] ;

		if (!obj){
			obj= document.createElement("input");
			
			//obj.type = "hidden";
			obj.setAttribute("type",'hidden');
			obj.name = sname;
			formObj.appendChild(obj);
		}
		obj.value = sval;
		
	};
	
	this.addWithMap = function(m){
		if (!m) return;
		for(var skey in m){
			this.add(skey,m[skey]);
		}
	};
	this.addPWithMap = function(m){
		if (!m) return;
		
			this.add("p",JSON.stringify(m));
		
	};
	
	this.send = function(surl){
		formObj.action=surl;
		formObj.submit();
	};
};

function getReportPopup(param) {
    var width  = 900;
    var height = 700;

    var x = (document.body.clientWidth)  ? (document.body.clientWidth  - width ) / 2 : 0;
    var y = (document.body.clientHeight) ? (document.body.clientHeight - height) / 2 : 0;
    
    var iframe =document.getElementById("ifr");
    if (!iframe){
    	iframe= document.createElement('iframe');
	    iframe.frameBorder = 0;
	    iframe.width  = "100%";
	    iframe.height = "100%";
	    iframe.id     = "ifr";
	    iframe.name   = "ifr";
	    
	    document.body.appendChild(iframe);
    }
   

   /* dhxWins = new dhtmlXWindows();
    dhxWins.setImagePath("/resources/dhtmlx/dhtmlxWindows/codebase/imgs/");
    
    winId = dhxWins.createWindow("winId", x, y, width, height);
    winId.setText("Report Viewer");
    winId.attachObject("ifr");
    winId.setModal(true);
    winId.button("minmax1").hide(); // max button hide
    winId.denyResize(); // disable resize
*/    
    var formsend =new cmm.uiUtil.PostSend("sendform","ifr");
   // formsend.add("path", "/views/popup/reportView");
    formsend.addPWithMap(param);
    formsend.send("/report/view_report");
    
}

