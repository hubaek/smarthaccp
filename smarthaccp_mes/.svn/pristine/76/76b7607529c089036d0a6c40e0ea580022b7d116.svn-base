var wsUri = "ws://127.0.0.1:4146/";

var output= document.getElementById("client-output");
var socket;

function socketStart() 
{
	socket = new WebSocket(wsUri);
    socket.onopen = function() {
        this.send('10')
    };
    
    socket.onmessage = function (event) {
        if(socket.readyState == 1){
            writeToScreen("<font size=2 color='blue'>Client 연결완료</font>");
        }else{
            socket.close();
        }
    };
    
    socket.onclose = function(event) {
        writeToScreen("<font size=2 color='red'>Client 종료</font>");
    };

    socket.onerror = function(event) {
        writeToScreen("<font size=2 color='red'>Client Error</font>");
    };
}

function sendSocket(b)
{	
	socket = new WebSocket(wsUri);
	
    socket.onopen = function() {
        this.send(b)
    };
    
    /*
    socket.onmessage = function (event) {
        //writeToScreen("<font size=4 color='green'>전송완료</font>")
        sleep (1000);
    };
    */
    
    socket.onclose = function() {
    	/*
		axDialog.alert({
            theme: "danger",
            width:400,
            msg: "연결된 프린터가 없습니다.1"
        });        
    	return false;
    	*/
       // writeToScreen("<font size=4 color='red'>클라이언트 종료</font>");
    };
    


    socket.onerror = function(event) {
		axDialog.alert({
            theme: "danger",
            width:400,
            msg: "연결된 프린터가 없습니다."
        });        
    	return false;
        //writeToScreen("<font size=2 color='red'>Client Error</font>");
    };
    
}

function sendBarcodeList(list){
	debugger;
	if (list != null){
		var today = getNowDt();
		if (list.length > 0){
			list.forEach(function (n){
				n.printDt = today;
//				if (n.boxYn == "Y"){
				debugger;
				n.stockQty = n.itemQty;
//				}

				n.routNm = nvl(parent.COMMON_CODE["ROUT"].map[n.routCd],'');
			});
			sendSocket(JSON.stringify(list));
		}else{
			debugger;
			list.printDt = today;
			list.routNm = nvl(parent.COMMON_CODE["ROUT"].map[list.routCd],'');
			list.goodQty = list.itemQty;
			//if (list.boxYn == "Y"){
			//list.stockQty = list.goodQty;
			//}
			sendSocket(JSON.stringify([list]));
		}
	}
}

function sleep (delay) {
   var start = new Date().getTime();
   while (new Date().getTime() < start + delay);
}

function writeToScreen(message)
{
	var pre = document.createElement("p");
	while ( output.hasChildNodes() ) { output.removeChild( output.firstChild ); }
	pre.style.wordWrap = "break-word";
	pre.innerHTML = message;
	output.appendChild(pre);
}

//오늘날짜
function getNowDt(){
	var today = new Date();
	var dd = today.getDate();
	var mm = today.getMonth()+1; //January is 0!
	var yyyy = today.getFullYear();

	if(dd<10) {
	    dd='0'+dd
	} 

	if(mm<10) {
	    mm='0'+mm
	} 

	today = yyyy+'-'+mm+'-'+dd;
	
	return today;
}