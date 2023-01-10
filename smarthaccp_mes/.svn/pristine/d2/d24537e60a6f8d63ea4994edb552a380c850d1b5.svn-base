/*
 * 모니터링 메인 화면 
 */

$(function(){
	const thisURL = document.URL;
	const domain = window.location.hostname;
	const port = window.location.port;
	let addr = 'http://' + domain + ':'+port;
	
	console.log('thisURL : '+thisURL);
	if(thisURL.indexOf('openItem=office')!= -1){
		rotateMonit(addr);
		setInterval(function(){rotateMonit(addr);}, 60000);
	}else{
		addr += '/jsp/monit/MT110-01.jsp';
		$('#mainIFrame').attr('src', addr);
	}
});

function rotateMonit(addr){
	$('#mainIFrame').attr('src',addr+'/jsp/monit/MT110.jsp');
	setTimeout(function(){$('#mainIFrame').attr('src',addr+'/jsp/monit/MT120.jsp');},60000);
}