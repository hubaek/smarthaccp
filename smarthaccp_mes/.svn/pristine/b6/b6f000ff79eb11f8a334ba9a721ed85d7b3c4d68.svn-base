/**
 * Monitoring Item 생성 function
 * itemList를 바탕으로 HTML 생성
 * 2022.09.13
 * 작성자 : 김다위
 */ 

/**
 * 1. addCcpItem : Mornitoring CCPItem 추가
 * parameter
 * (1) divId : Item을 추가할 divId
 * (2) btnDivid : 상태표시 영역 id
 * (3) item : item Data Object
 * (4) index : item 순서
 */   
function addCcpItem(divId, btnDivid, item, index, max, min){
	//1.init
	var itemHtml = "";
	var btnHtml = "";
	var warnid = "warn_" + index;
	var htmlid = "html_" + index;
	console.log(item);
	//2.setting
	itemHtml += '<div class="item-list">';
	itemHtml += '    <div class="item-header bg-main">';
	itemHtml += '    	<h2>' + item["lmtnm"] + '</h2>';
	itemHtml += '    </div>';
	itemHtml += '    <div class="item-body">';
	/***************************************** 한계기준알림영역 *********************************************/

	//1. 최솟값만 존재
	if((min != undefined && min != null) && (max == undefined && max == null)){
	    itemHtml += '    <div class="item-row top">';
		itemHtml += '        <strong> * 한계기준 최솟값 : ' + min + '이상</strong>';
	    itemHtml += '    </div>';
	}
	//2. 최댓값만 존재
	if((min == undefined && min == null) && (max != undefined && max != null)){
		itemHtml += '    <div class="item-row top">';
	    itemHtml += '        <strong> * 한계기준 최댓값 : ' + max + '이하 </strong>';
	    itemHtml += '    </div>';
	}
	//3. 최솟,최댓값 존재
	if((min != undefined && min != null) && (max != undefined && max != null)){
		itemHtml += '    <div class="item-row top">';
	    itemHtml += '        <strong> * 한계기준  : ' + min + ' ~ ' + max + '</strong>';
	    itemHtml += '    </div>';
	}
	
	/***************************************************************************************************/
	
	/****************************************** 경고알람영역 **********************************************/
	if(item["warnYn"] == "Y"){
		itemHtml += '    <div class="warning middle">';
	    itemHtml += '        <img id=' + warnid + ' src="/assets/css/images/warning.png"/>';
	    itemHtml += '    </div>';	
	}
	/***************************************************************************************************/
	
	/******************************************* icon 영역 **********************************************/
	itemHtml += '        <div class="item-row middle">';
	var iconhtml = "";
	if(item["icon"] != undefined && item["icon"] != null && item["icon"] != ""){
		for(var i=0; i<item["icon"].length; i++){
			iconhtml += '            <div class="item-row">';
			//icon
			if(item["icon"][i] == "temp"){ //온도
				iconhtml += '            <div class="icon-wrap"><img src="/assets/css/images/icon-temp.svg" alt="온도 아이콘" /></div>';
			}
			else if(item["icon"][i] == "scale"){ //저울
				iconhtml += '            <div class="icon-wrap"><img src="/assets/css/images/icon-scale.svg" alt="저울 아이콘" /></div>';
			}
			else if(item["icon"][i] == "setting"){ //톱니바퀴
				iconhtml += '            <div class="icon-wrap"><img src="/assets/css/images/icon-setting.svg" alt="톱니바퀴 아이콘" /></div>';
			}
			else if(item["icon"][i] == "wash"){ //세척
				iconhtml += '            <div class="icon-wrap"><img src="/assets/css/images/icon-wash.svg" alt="세척 아이콘" /></div>';
			}
			else if(item["icon"][i] == "waterdrop"){ //물방울
				iconhtml += '            <div class="icon-wrap"><img src="/assets/css/images/icon-waterdrop.svg" alt="물방울 아이콘" /></div>';
			}
			else if(item["icon"][i] == "clock"){ //시계
				iconhtml += '            <div class="icon-wrap"><img src="/assets/css/images/icon-clock.png" alt="시계 아이콘" /></div>';
			}
			//다른 type의 icon을 사용할경우 추가
			//...
			
			//value
			if(item["iconval"][i] != undefined && item["iconval"][i] != null && item["iconval"][i] != ""){
				if(item["warnYn"] == "Y"){
					iconhtml += '            <h2><strong id="' + htmlid + '" style="color:red;">' + item["iconpre"][i] + item["iconval"][i] + item["iconpost"][i] + '</strong></h2> ';
				}else{
					iconhtml += '            <h2><strong id="' + htmlid + '">' + item["iconpre"][i] + item["iconval"][i] + item["iconpost"][i] + '</strong></h2> ';
				}
			}else{
				iconhtml += '            <h2><strong id=' + htmlid + 'style="color:red;"></strong></h2> ';
			}
			iconhtml += '            </div>';
		}		
	}

	itemHtml += iconhtml;
	itemHtml += '        </div>';
	/***************************************************************************************************/

	/******************************************* 상태 button 영역 ****************************************/
	var btnId = "btn_" + item["plcIp"] + "_" + index;
	itemHtml += '		 <div id=' + btnDivid + ' class="btn-bottom">';

	itemHtml += '        </div>';
	/***************************************************************************************************/
	itemHtml += '    </div>';
	itemHtml += '</div>';
	
	//3.html apply
	$("#"+divId).append(itemHtml);
}

/**
 * 2. addButton : CCPItem에 대한 상태btn 추가
 * parameter
 * (1) btnDivid : 상태표시 영역 id
 * (2) btnConfig : btn 설정 Object
 */   
function addButton(btnDivId, btnConfig){
	var btnHtml = "";
	
	if(btnConfig.value2 != undefined && btnConfig.value2 != null){
		var displayStyle = "";
		if(btnConfig.value2 == "ON" || btnConfig.value2 == "OPEN"){
			btnHtml += '<button class="btn-full btn-on" id="' + btnConfig.value2btnid + '" style="margin:2px"><img src="/assets/css/images/icon-power.svg"/>' + btnConfig.value2onTitle + '</button>';
		}else if(btnConfig.value2 == "OFF" || btnConfig.value2 == "CLOSE"){
			if(btnConfig.value2offHidden){ displayStyle = "display:none;" };
			btnHtml += '<button class="btn-full btn-off" id="' + btnConfig.value2btnid + '" style="' + displayStyle + 'margin:2px;"><img src="/assets/css/images/icon-power.svg"/>' + btnConfig.value2offTitle + '</button>';
		}
	}
	
	if(btnConfig.value3 != undefined && btnConfig.value3 != null){
		var displayStyle = "";
		if(btnConfig.value3 == "ON" || btnConfig.value3 == "OPEN"){
			btnHtml += '<button class="btn-full btn-on" id="' + btnConfig.value3btnid + '" style="margin:2px"><img src="/assets/css/images/icon-power.svg"/>' + btnConfig.value3onTitle + '</button>';
		}else if(btnConfig.value3 == "OFF" || btnConfig.value3 == "CLOSE"){
			if(btnConfig.value3offHidden){ displayStyle = "display:none;" };
			btnHtml += '<button class="btn-full btn-off" id="' + btnConfig.value3btnid + '" style="' + displayStyle + 'margin:2px;"><img src="/assets/css/images/icon-power.svg"/>' + btnConfig.value3offTitle + '</button>';
		}
	}
	
	if(btnConfig.value4 != undefined && btnConfig.value4 != null){
		var displayStyle = "";
		if(btnConfig.value4 == "ON" || btnConfig.value4 == "OPEN"){
			btnHtml += '<button class="btn-full btn-on" id="' + btnConfig.value4btnid + '" style="margin:2px"><img src="/assets/css/images/icon-power.svg"/>' + btnConfig.value4onTitle + '</button>';
		}else if(btnConfig.value4 == "OFF" || btnConfig.value4 == "CLOSE"){
			if(btnConfig.value4offHidden){ displayStyle = "display:none;" };
			btnHtml += '<button class="btn-full btn-off" id="' + btnConfig.value4btnid + '" style="' + displayStyle + 'margin:2px;"><img src="/assets/css/images/icon-power.svg"/>' + btnConfig.value4offTitle + '</button>';
		}
	}
	
	if(btnConfig.value5 != undefined && btnConfig.value5 != null){
		var displayStyle = "";
		if(btnConfig.value5 == "ON" || btnConfig.value5 == "OPEN"){
			btnHtml += '<button class="btn-full btn-on" id="' + btnConfig.value5btnid + '" style="margin:2px"><img src="/assets/css/images/icon-power.svg"/>' + btnConfig.value5onTitle + '</button>';
		}else if(btnConfig.value5 == "OFF" || btnConfig.value5 == "CLOSE"){
			if(btnConfig.value5offHidden){ displayStyle = "display:none;" };
			btnHtml += '<button class="btn-full btn-off" id="' + btnConfig.value5btnid + '" style="' + displayStyle + 'margin:2px;"><img src="/assets/css/images/icon-power.svg"/>' + btnConfig.value5offTitle + '</button>';
		}
	}
	
	$("#" + btnDivId).append(btnHtml);
}

/**
 * 3. MetalAddItem : 금속검출기 Mornitoring Item 추가
 * parameter
 * (1) divId : Item을 추가할 divId
 * (2) itemList : item Data Object
 * 
 */ 
//금속검출기
function MetalAddItem(divId, itemList){
	//1.init
	var itemHtml = "";
	
	//2.setting
	for(var i=0; i<itemList.length; i++){
		var metalCntid1 = "metalCnt1_"+(i+1);
		var metalCntid2 = "metalCnt2_"+(i+1);
		var metalCntid3 = "metalCnt3_"+(i+1);
		var metalLastDtid1 = "metalLastDt1_"+(i+1);
		var metalLastDtid2 = "metalLastDt2_"+(i+1);
		var warnid = "warn_" + (i+1);
		var row = itemList[i];
		
		itemHtml += '<div class="item-list">';
		itemHtml += '    <div class="item-header bg-main">';
		itemHtml += '        <h2>' + row["lmtnm"] + '</h2>';
		itemHtml += '    </div>';
		itemHtml += '    <div class="item-body">';
		/***************************************************************************************************/
		
		/****************************************** 경고알람영역 **********************************************/
		if(row["warnYn"] == "Y"){
			itemHtml += '    <div class="warning middle">';
		    itemHtml += '        <img id=' + warnid + ' src="/assets/css/images/warning.png"/>';
		    itemHtml += '    </div>';	
		}
		/*itemHtml += '        <div class="item-row">';
		itemHtml += '            <h3 class="item-row-title">시편횟수</h3>';
		itemHtml += '            <h3 class="item-row-value">';
		itemHtml += '                <strong id=' + metalCntid1 + '>' + row["testDetectCount"] + '</strong>회';
		itemHtml += '            </h3>';
		itemHtml += '        </div>';*/
		itemHtml += '        <div class="item-row">';
		itemHtml += '            <h3 class="item-row-title">시편테스트</h3>';
		itemHtml += '            <h3 class="item-row-value">';
		itemHtml += '                <strong id=' + metalCntid3 + '>' + row["testCount"] + '</strong>회';
		itemHtml += '            </h3>';
		itemHtml += '        </div>';
		itemHtml += '        <div class="item-row">';
		itemHtml += '            <h3 class="item-row-title">금속검출</h3>';
		itemHtml += '            <h3 class="item-row-value">';
		itemHtml += '                <strong id=' + metalCntid2 + '>' + row["detectCount"] + '</strong>건';
		itemHtml += '            </h3>';
		itemHtml += '        </div>';
		itemHtml += '        <div class="division"></div>';
		itemHtml += '        <div class="item-description-wrap">';
		itemHtml += '            <div class="item-description">';
		itemHtml += '                <strong class="item-title">최근시편</strong>';
		itemHtml += '                <span class="item-value" id=' + metalLastDtid1 + '>' + row["testDetectMaxDtm"] + '</span>';
		itemHtml += '            </div>';
		itemHtml += '            <div class="item-description">';
		itemHtml += '                <span class="item-title">최근검출</span>';
		itemHtml += '                <span class="item-value" id=' + metalLastDtid2 + '>' + row["detectMaxDtm"] + '</span>';
		itemHtml += '            </div>';
		itemHtml += '        </div>';
		itemHtml += '    </div>';
	  	itemHtml += '</div>';
	};
	
	//3.apply
	$("#"+divId).append(itemHtml);
}
