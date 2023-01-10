<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<%--
/**
 * 0. Project	: 
 * 1. 작성자  		: 이은기
 * 2. 작성일		: 
 * 3. Comment 	: 금속검출기
 * 4. 변경이력 		: 2022.05.02
 *  	이름		|일자          		|변경내용
 *      ------------------------------------------------------
 *		
 */
 --%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="<c:url value='assets/resource/css/reset.css'></c:url>">
    <link rel="stylesheet" href="<c:url value='assets/resource/fonts/S-CoreDream/S-CoreDream.css'></c:url>">
    <link rel="stylesheet" href="<c:url value='assets/resource/css/common.css'></c:url>">
    <link rel="stylesheet" type="text/css" href="https://cdn.rawgit.com/ax5ui/ax5ui-grid/master/dist/ax5grid.css" />
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script type="text/javascript" src="https://cdn.rawgit.com/ax5ui/ax5core/master/dist/ax5core.min.js"></script>
    <script type="text/javascript" src="https://cdn.rawgit.com/ax5ui/ax5ui-grid/master/dist/ax5grid.min.js"></script>
    <script type="text/javascript" src="<c:url value='assets/ui.js'></c:url>"></script>
    <title>금속검출기</title>
</head>
<body>
<div class="wrap">
    <!-- 상단 메뉴-->
    <header>
        <div class="top-bar">
            <div class="input-box">
                <label for="itemNm">품명</label>
                <input type="text" id="itemNm" name="itemNm" autocomplete="off">
            </div>
            <div class="input-box">
                <label for="sensorId">금속검출기</label>
                <select id="sensorId" name="sensorId"  >
                    <option value="MET_01">금속검출기</option>
                </select>
            </div>
        </div>
    </header>
    <div class="container">
        <main>
            <section class="control-box">
                <!--input[type='radio'] checked 활성화-->
                <input type="radio" name="controlButton" checked id="playButton" onclick="startWork()">
                <label class="control-button play-button" for="playButton">시편시작</label>
                <input type="radio" name="controlButton" id="stopButton">
                <label class="control-button stop-button" for="stopButton" onclick="stopWork()">시편종료</label>
            </section>
            <section class="align-box">
                <!--input[type='radio'] checked 활성화-->
                <input type="radio" name="oper_position" id="oper_position_left" value="왼쪽" onclick="setPopupEvent.changePosition('PASS_LOCATION_CD_001')">            
                <label class="align-button align-left-button" for="oper_position_left">왼쪽</label>
                <input type="radio" name="oper_position" checked id="oper_position_center" value="중앙" onclick="setPopupEvent.changePosition('PASS_LOCATION_CD_002')">
                <label class="align-button align-center-button" for="oper_position_center">중앙</label>
                <input type="radio" name="oper_position" id="oper_position_right" value="오른쪽" onclick="setPopupEvent.changePosition('PASS_LOCATION_CD_003')">
                <label class="align-button align-right-button" for="oper_position_right">오른쪽</label>
            </section>
            <section class="state-box">
                <ul class="state-list">
                    <!--.state-item.active 활성화-->
                    <li class="state-item" id="SPECIMEN_CD_001">FE</li>
                    <li class="state-item" id="SPECIMEN_CD_002">SuS</li>
                    <li class="state-item" id="SPECIMEN_CD_003">제품</li>
                    <li class="state-item" id="SPECIMEN_CD_004">Fe<br>제품</li>
                    <li class="state-item" id="SPECIMEN_CD_005">SuS<br>제품</li>
                </ul>
            </section>
            <section class="content-box">
                <div class="return-box">
                    <p id="msg"></p>
                    <!--button.active 화면표시-->
                    <button class="active" id="detectBtn" onclick="passSensing()">검출안됨</button>
                </div>
                <div id="audio-box">
                	<audio src="<c:url value='assets/audio/fe_center.mp3'></c:url>" data-value="0_중앙"></audio>
                	<audio src="<c:url value='assets/audio/fe_left.mp3'></c:url>" data-value="0_왼쪽"></audio>
                	<audio src="<c:url value='assets/audio/fe_right.mp3'></c:url>" data-value="0_오른쪽"></audio>
                	<audio src="<c:url value='assets/audio/sus_center.mp3'></c:url>" data-value="1_중앙"></audio>
                	<audio src="<c:url value='assets/audio/sus_left.mp3'></c:url>" data-value="1_왼쪽"></audio>
                	<audio src="<c:url value='assets/audio/sus_right.mp3'></c:url>" data-value="1_오른쪽"></audio>
                	<audio src="<c:url value='assets/audio/product_center.mp3'></c:url>" data-value="2_중앙"></audio>
                	<audio src="<c:url value='assets/audio/product_left.mp3'></c:url>" data-value="2_왼쪽"></audio>
                	<audio src="<c:url value='assets/audio/product_right.mp3'></c:url>" data-value="2_오른쪽"></audio>
                	<audio src="<c:url value='assets/audio/fe_product_center.mp3'></c:url>" data-value="3_중앙"></audio>
                	<audio src="<c:url value='assets/audio/fe_product_left.mp3'></c:url>" data-value="3_왼쪽"></audio>
                	<audio src="<c:url value='assets/audio/fe_product_right.mp3'></c:url>" data-value="3_오른쪽"></audio>
                	<audio src="<c:url value='assets/audio/sus_product_center.mp3'></c:url>" data-value="4_중앙"></audio>
                	<audio src="<c:url value='assets/audio/sus_product_left.mp3'></c:url>" data-value="4_왼쪽"></audio>
                	<audio src="<c:url value='assets/audio/sus_product_right.mp3'></c:url>" data-value="4_오른쪽"></audio>
                </div>
            </section>
        </main>
    </div>
</div>
<article id="popupLayer">
    <div class="layer-container">
        <header>
            <h1>품목정보</h1>
            <button class="close-button" id="popupLayerCloseButton"><img src="<c:url value='assets/resource/images/button-close.svg'></c:url>"> </button>
        </header>
        <div class="layer-content">
            <section class="search-box">
                <div class="input-box">
                    <label >품목분류</label>
                    <select name="itemMainCd" onchange="changeItemMainCd()">
                        <option>전체</option>
                    </select>
                    <select name="itemSubCd">
                        <option>전체</option>
                    </select>
                </div>
                <div class="input-box">
                    <label for="paramItemCd">품목코드</label>
                    <input type="text" id="paramItemCd" name="paramItemCd">
                </div>
                <div class="input-box">
                    <label for="paramItemNm">품목명</label>
                    <input type="text" id="paramItemNm" name="paramItemNm">
                </div>
                <div class="input-box">
                	<button class="active" onclick="searchList()">조회</button>
                </div>
            </section>
            <h2><img src="<c:url value='assets/resource/images/icon-list.svg '></c:url>">목록</h2>
            <section class="list-box" style="height: 500px;">
                <div data-ax5grid="grid-view-01" style="height: 100%;"></div>
            </section>
        </div>
    </div>
</article>
</body>
</html>