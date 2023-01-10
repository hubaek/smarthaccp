function sleep(num) { // [1/1000초]

	var now = new Date();

	var stop = now.getTime() + num;

	while (true) {
    
		now = new Date();

		if (now.getTime() > stop)
			return;

	}
}
    
/*
 * pad(10, 4);      // 0010
pad(9, 4);       // 0009
pad(123, 4);    // 0123
pad(1234, 4);   // 1234
 */
function pad(n, width) {
  n = n + '';
  return n.length >= width ? n : new Array(width - n.length + 1).join('0') + n;
}

// 오늘날짜
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

function getNowDtYYYYMMDD(){
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

	today = yyyy+''+mm+''+dd;
	
	return today;
}

//한달전
function getNowYy(){
	var today = new Date();
	var yyyy = today.getFullYear();
	return yyyy;  
}

//한달전
function getFromDt(){
	var today = new Date();
	var dd = today.getDate();
	var mm = today.getMonth(); //January is 0!
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
  
    
function getLastDt(){ 
	var today = new Date();
	var mm = today.getMonth()+1; //January is 0!
	var yyyy = today.getFullYear();

    var dd = new Date(yyyy, mm, 0).getDate();
    
    if(dd<10) {
	    dd='0'+dd
	} 
    
	if(mm<10) {
	    mm='0'+mm
	} 

	today = yyyy+'-'+mm+'-'+dd;
	return today;
}

//날짜변환
function convertStringToTimestamp(timeString){
	var d="";
	if(timeString=="" || typeof timeString == "undefined" ){
		d="";
	}else{
		d = ax5.util.date(new Date(timeString || ""), {"return": 'yyyy-MM-dd hh:mm:ss'});
	}
	return d;
}



function changeHangul(number) {
	var hanA = new Array("", "일", "이", "삼", "사", "오", "육", "칠", "팔", "구", "십");
	var danA = new Array("", "십", "백", "천", "", "십", "백", "천", "", "십", "백",
			"천", "", "십", "백", "천");
	var result = "";
	var num = number + "";
	for (i = 0; i < num.length; i++) {
		str = "";
		han = hanA[num.charAt(num.length - (i + 1))];
		if (han != "")
			str += han + danA[i];
		if (i == 4)
			str += "만";
		if (i == 8)
			str += "억";
		if (i == 12)
			str += "조";
		result = str + result;
	}
	if (num != 0)
		result = result + "원";
	return result;
}

//콤마찍기
function comma(str) {

	if (typeof str === "undefined"){

	    str = "";
	}else{

	    str = String(str);
	}
    return str.replace(/(\d)(?=(?:\d{3})+(?!\d))/g, '$1,');
}
//콤마풀기
function uncomma(str) {
    str = String(str);
    return str.replace(/[^\d]+/g, '');
}





function nvl(str, defaultVal) {
    var defaultValue = "";
     
    if (typeof defaultVal != 'undefined') {
        defaultValue = defaultVal;
    }
     
    if (typeof str == "undefined" || str == null || str == '' || str == "undefined") {
        return defaultValue;
    }
     
    return str;
}

function getSerializeArrayToJson(formId){

	var data = '';
	$.each( $(formId).serializeArray(), function(key, val){
		 data += ',"'+val['name']+'":"'+val['value']+'"';
	});
	
	data = JSON.parse('{'+ data.substr(1) +'}');
	
	
	return data;
}



//전화번호 포멧 설정
function phoneFomatter(num,type){
	var formatNum = '';
	if (typeof num === "undefined"){
		formatNum = "";
	}else{
		num = num + "";
	    if(num.length==11){
	        if(type==0){
	            formatNum = num.replace(/(\d{3})(\d{4})(\d{4})/, '$1-****-$3');
	        }else{
	            formatNum = num.replace(/(\d{3})(\d{4})(\d{4})/, '$1-$2-$3');
	        }
	    }else if(num.length==8){
	        formatNum = num.replace(/(\d{4})(\d{4})/, '$1-$2');
	    }else{
	        if(num.indexOf('02')==0){
	            if(type==0){
	                formatNum = num.replace(/(\d{2})(\d{4})(\d{4})/, '$1-****-$3');
	            }else{
	                formatNum = num.replace(/(\d{2})(\d{4})(\d{4})/, '$1-$2-$3');
	            }
	        }else{
	            if(type==0){
	                formatNum = num.replace(/(\d{3})(\d{3})(\d{4})/, '$1-***-$3');
	            }else{
	                formatNum = num.replace(/(\d{3})(\d{3})(\d{4})/, '$1-$2-$3');
	            }
	        }
	    }
	}
  return formatNum;
}


//임의 문자열 생성
function randomStringCd(length) {
	var str = '';
	  var chars ='0123456789ABCDEFGHIJKLMNOPQRSTUVWXTZabcdefghiklmnopqrstuvwxyz'.split(
	      '');
	  var charsLen = chars.length;
	  if (!length) {
	    length = ~~(Math.random() * charsLen);
	  }
	  for (var i = 0; i < length; i++) {
	    str += chars[~~(Math.random() * charsLen)];
	  }
	  return str;
}  

convertCommonCode = function () {
    var BASIC_CODE = {};
    
    var mapKeys = {
        key: "subCd", value: "subNm"
    };
    
    return function () {
        var codes,
            return_code = {};

        if (arguments.length == 1) {
            codes = arguments[0];  
        } else {
            BASIC_CODE = arguments[0];
            codes = arguments[1];
        }

        codes = $.extend(true, BASIC_CODE, codes);

        for (var k in codes) {
            if (codes.hasOwnProperty(k)) {
                return_code[k] = codes[k];
                return_code[k].map = function () {
                    var i = this.length,
                        map = {};

                    while (i--) {
                        map[this[i][mapKeys.key]] = this[i][mapKeys.value];
                    }
                    return map;
                }.call(return_code[k]);
            }
        }

        return return_code;
    };
}();


//Infinity 인지 체크
function calcResultCheck(v) {
	if( v== "Infinity" || v== "-Infinity" ){
		v = 0;
	}else{
		if( isNaN(v) ){
			v = 0;
		}else{
			v = v.toFixed(2);
		}
	}
	
	return v;
}


function handlePasteGridView (e,target,addYn,callback) {	
	var totalRowIdx = target.list.length;
	var columns = target.colGroup;
	var focusedColumn = Object.getOwnPropertyNames(target.focusedColumn)[0].split('_');
	var rowIndex = focusedColumn[0];
	var colIndex = focusedColumn[1];
	var list = target.list;

	var clipboardData, pastedData;
	
    e.stopPropagation();
    e.preventDefault();

    clipboardData = e.clipboardData || window.clipboardData;
    pastedData = clipboardData.getData('Text');
    
    var copiedRows = pastedData.split('\r\n');

    if(copiedRows.length == 1){
    	copiedRows.push("");
    }

    var rIdx = rowIndex ;
	
    for ( var exind = 0; exind < copiedRows.length-1; exind++ ) {  
       var items = copiedRows[exind].split('\t');       
       var rowNum = 0;
       var data = new Object() ;       
       var cIdx = colIndex ;

       if(rIdx < totalRowIdx){
           for (var i = 0 ; i < items.length ; i ++){
        	   if (typeof columns[cIdx].editor != "undefined"){
        		   if(nvl(columns[cIdx].editor.type,'') == "number"){
        			   items[i] = excelNumber(items[i]);
        		   }
        		   
        		   eval("list[" + rIdx+"]."+columns[cIdx].key +"='" + excelReplace(items[i],columns[cIdx].editor.type) + "'");
        	   }        	   
       	       cIdx++;
           }

           list[rIdx].__modified__=true;
           rIdx++;
       }else{
    	   if(addYn == "Y"){
               for (var i = 0 ; i < items.length ; i ++){
            	   if (typeof columns[cIdx].editor != "undefined"){
            		   console.log(columns[cIdx].editor.type);
            		   if(nvl(columns[cIdx].editor.type,'') == "number"){
            			   items[i] = excelNumber(items[i]);
            		   }
            		   eval("data."+columns[cIdx].key +"='" + excelReplace(items[i],columns[cIdx].editor.type) + "'");
            	   }
            	   cIdx++;
                }
                
                data.__modified__=true;
                data.company = "1000";
                data.useYn = "Y";
                list.push(data);

                list[rIdx].__modified__=true;
                rIdx++;
    	   }
       }
    }
    
    target.setData(list);
    target.repaint();
    target.keyDown("ESC");
    
    if(nvl(callback,'') != ''){
    	eval(callback);
    }
}

function excelReplace(str,editorType){
	

	str = str.replaceAll('\n',' ');
	
	if(nvl(editorType,'') == "number"){
	    var regExp = /[\{\}\[\]\/?,;:|\)*~`!^\+<>@\#$%&\\\=\(\'\"]/gi;
		str = str.replace(regExp, "");
	}
	
	
    /*if(nvl(editorType,'') != "number"){
		str = str.replaceAll('\n',' ');
	    var regExp = /[\{\}\[\]\/?.,;:|\)*~`!^\+<>@\#$%&\\\=\(\'\"]/gi;
		str = str.replace(regExp, "");
    }*/
    return str;
}

//그리드 number 소수점
function excelNumber(value) {
	var rNum;
    if (typeof value !== "undefined") {
        var val = ('' + value).replace(/[^0-9^\.^\-]/g, ""),
            regExpPattern = new RegExp('([0-9])([0-9][0-9][0-9][,.])'),
            arrNumber = val.split('.'),
            returnValue = void 0;

        arrNumber[0] += '.';

        do {
            arrNumber[0] = arrNumber[0].replace(regExpPattern, '$1,$2');
        } while (regExpPattern.test(arrNumber[0]));
        
        rNum = arrNumber.length > 1 ? arrNumber[0] + ax5.util.left(arrNumber[1], 5) : arrNumber[0].split('.')[0];
    } else {
    	rNum = "";
    }
    
    if(rNum == "-"){
    	rNum = "";
    }else if(rNum == "00"){
    	rNum = "";
    }

    return rNum;
};
 
function Trunc(input , digit){
	input = String(input);
	var reVal = ""; //return 변수

	var tail = "";

	if( input.indexOf(".") > 0){

		var num1= input.split(".")[0];
		var num2= input.split(".")[1];

	    if(num2.length >= digit ){
	    	reVal = num1 +"."+num2.substring(0,digit);
	    }else{
	    	for(var i=0;i<(digit -num2.length );i++){
	    		tail+="0";
	    	}
	    	reVal =num1 +"."+num2+tail;
	    }

	}else{
		for(var i=0;i<digit;i++){
			tail+="0";
		}
		reVal = input+"."+tail;
	}
	
	if( reVal == "Infinity" || reVal == "-Infinity" ){
		reVal = 0;
	}else{
		if( isNaN(reVal) ){
			reVal = 0;
		}
	}
	
	return Number(reVal);
}

String.prototype.replaceAll = function(org, dest) {
    return this.split(org).join(dest);
}

//문자열 공백체크
function g_isEmpty(value){
	if (value === null) return true
	if (typeof value === 'undefined') return true
	if (typeof value === 'string' && value === '') return true
	if (Array.isArray(value) && value.length < 1) return true
	if (typeof value === 'object' && value.constructor.name === 'Object' && Object.keys(value).length < 1 && Object.getOwnPropertyNames(value) < 1) return true
	if (typeof value === 'object' && value.constructor.name === 'String' && Object.keys(value).length < 1) return true // new String()

	return false
}

//문자열 날짜포맷변환
function convertStringToDateFormat(dateString){	
	var d="";
	var yyyy = dateString.substr(0,4);
    var mm = dateString.substr(4,2);
    var dd = dateString.substr(6,2);         
    d = yyyy+"-"+mm+"-"+dd;
	return d;
}