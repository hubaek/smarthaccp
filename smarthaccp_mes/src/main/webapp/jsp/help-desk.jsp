<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ppm" tagdir="/WEB-INF/tags" %>
<ppm:set key="page_auto_height" value="true"/>
<ppm:layout name="modal">
    <jsp:body>
<div id="wrap">	
	<div class="h_bar"></div>
		<div class="container">
			<div class="header">
		    	<a style="margin-left:10px;">
		    		<img src="${pageContext.request.contextPath}${config.logo.login}" class="img-logo" width=200px />
		    	</a>
		   	</div>       
            <pre>
            	<br>
            	* PC 사용환경
            		Internet Explorer : 9 버전 이상
            		Google Chrome : 32.0.1700 이상  <font color='red'>(크롬브라우저 최적화됨)</font>
            		Opera : Opera 2014 이상
            		Safari : Safari 7 이상
            		Firefox : 32.0 버전 이상
            </pre>
			<p>
				※ 문의 전 게시판 FAQ를 먼저 확인 부탁드립니다.
				추가 문의 발생 시 각팀 해당담당자 또는 아래 담당자에게 연락 바랍니다.
			</p>
		   	<div align="center">
		   		<table width="100%" border="1" style="line-height:200%" cellspacing="0">
				  <tr>
				    <td width="15%" align="center"><strong>문의구분</strong></td>
				    <td width="10%" align="center"><strong>소속</strong></td>
				    <td width="15%" align="center"><strong>담당자</strong></td>
				    <td width="20%" align="center"><strong>비상 연락처</strong></td>
				    <td width="20%" align="center"><strong>이메일</strong></td>
				  </tr>
                  <tr>
                    <td align="center">기준정보</td>
                    <td align="center">공정기술팀</td>
                    <td align="center">정경식 대리</td>
                    <td align="center">010-3349-3214</td>
                    <td align="center">jksboy@siliconevalley.co.kr</td>
                  </tr>
                  <tr>
                    <td align="center">구매관리</td>
                    <td align="center">구매팀</td>
                    <td align="center">윤인기 팀장</td>
                    <td align="center">010-2423-5444</td>
                    <td align="center">yik1228@siliconevalley.co.kr</td>
                  </tr>
				  <tr>
				    <td align="center">영업관리</td>
				    <td align="center">공정기술팀</td>
				    <td align="center">정경식 대리</td>
				    <td align="center">010-3349-3214</td>
				    <td align="center">jksboy@siliconevalley.co.kr</td>
				  </tr>
				  <tr>
				    <td  align="center">생산관리</td>
				    <td align="center">공정기술팀</td>
				    <td align="center">장연지 사원</td>
				    <td align="center">010-3033-9331</td>
				    <td align="center">jangyeong@siliconevalley.co.kr</td>
				  </tr>
				  <tr>
				    <td align="center" >품질관리</td>
				    <td align="center">공정기술팀</td>
				    <td align="center">정경식 대리</td>
				    <td align="center">010-3349-3214</td>
				    <td align="center">jksboy@siliconevalley.co.kr</td>
				  </tr>
				</table>
		   	</div>
		</div>
	</div>	
	<br>
	<br>
    </jsp:body>
</ppm:layout>