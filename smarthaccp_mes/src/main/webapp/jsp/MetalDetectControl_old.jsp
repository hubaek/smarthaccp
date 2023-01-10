<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="/assets/resource/css/reset.css">
    <link rel="stylesheet" href="/assets/resource/fonts/S-CoreDream/S-CoreDream.css">
    <link rel="stylesheet" href="/assets/resource/css/common.css">
    <script type="text/javascript" src="/assets/resource/js/ui.js"></script>
    <title>ADMIN</title>
</head>
<body>
<div class="wrap">
    <!-- 상단 메뉴-->
    <header>
        <div class="top-bar">
            <div class="input-box">
                <label for="productName">품명</label>
                <input type="text" id="productName" name="productName" autocomplete="off">
            </div>
            <div class="input-box">
                <label for="productType">금속검출기</label>
                <select id="productType" name="productType"  >
                    <option>금속검출기</option>
                </select>
            </div>
        </div>
    </header>
    <div class="container">
        <main>
            <section class="control-box">
                <!--input[type='radio'] checked 활성화-->
                <input type="radio" name="controlButton" checked id="playButton">
                <label class="control-button play-button" for="playButton">시편시작</label>
                <input type="radio" name="controlButton" id="stopButton">
                <label class="control-button stop-button" for="stopButton">시편종료</label>
            </section>
            <section class="align-box">
                <!--input[type='radio'] checked 활성화-->
                <input type="radio" name="alignButton" checked id="leftAlign">
                <label class="align-button align-left-button" for="leftAlign">왼쪽</label>
                <input type="radio" name="alignButton" id="centerAlign">
                <label class="align-button align-center-button" for="centerAlign">중앙</label>
                <input type="radio" name="alignButton" id="rightAlign">
                <label class="align-button align-right-button" for="rightAlign">중앙</label>
            </section>
            <section class="state-box">
                <ul class="state-list">
                    <!--.state-item.active 활성화-->
                    <li class="state-item active">FE</li>
                    <li class="state-item">SuS</li>
                    <li class="state-item ">제품</li>
                    <li class="state-item">Fe<br>제품</li>
                    <li class="state-item">SuS<br>제품</li>
                </ul>
            </section>
            <section class="content-box">
                <div class="return-box">
                    <p>Fe을(를) 중앙으로 통과시키세요.</p>
                    <!--button.active 화면표시-->
                    <button class="active">검출안됨</button>
                </div>
            </section>
        </main>
    </div>
</div>
<article id="popupLayer">
    <div class="layer-container">
        <header>
            <h1>품목정보</h1>
            <button class="close-button" id="popupLayerCloseButton"><img src="/assets/resource/images/button-close.svg"> </button>
        </header>
        <div class="layer-content">
            <section class="search-box">
                <div class="input-box">
                    <label for="itemType">품목유형</label>
                    <input type="text" id="itemType" name="itemType">
                </div>
                <div class="input-box">
                    <label >품목분류</label>
                    <select name="itemClass1">
                        <option>금속검출기</option>
                    </select>
                    <select name="itemClass2">
                        <option>금속검출기</option>
                    </select>
                </div>
                <div class="input-box">
                    <label for="itemCode1">품목코드</label>
                    <input type="text" id="itemCode1" name="itemCode1">
                </div>
                <div class="input-box">
                    <label for="itemCode2">품목코드</label>
                    <input type="text" id="itemCode2" name="itemCode2">
                </div>
            </section>
            <h2><img src="/assets/resource/images/icon-list.svg ">목록</h2>
            <section class="list-box">
                <table class="table-style">
                    <colgroup>
                        <col style="width: 5rem;"/>
                        <col style="width: 10rem;"/>
                        <col style="width: 10rem;"/>
                        <col style="width: 10rem;"/>
                        <col style="width: 10rem;"/>
                        <col style="width: 10rem;"/>
                        <col style="width: 10rem;"/>
                        <col style="width: 5rem;"/>
                        <col />
                    </colgroup>
                    <thead>
                        <tr>
                            <th>No</th>
                            <th>품목코드</th>
                            <th>품목명</th>
                            <th>품목유형</th>
                            <th>품목대분류</th>
                            <th>품목소분류</th>
                            <th>규격</th>
                            <th>단위</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>1</td>
                            <td>205030</td>
                            <td>205030</td>
                            <td>품목유형</td>
                            <td>품목유형</td>
                            <td>품목유형</td>
                            <td>규격</td>
                            <td>kg</td>
                            <td></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                        </tr>
                    </tbody>
                </table>
            </section>
        </div>
    </div>
</article>
</body>
</html>