<%@ tag import="org.apache.commons.lang3.StringUtils" %>
<%@ tag import="java.util.List" %>
<%@ tag import="com.ppm.mes.utils.BasicCodeUtils" %>
<%@ tag import="com.ppm.mes.domain.item.item100.ItemGroupMainVO" %>
<%@ tag import="com.ppm.mes.domain.user.user000.SessionUser" %>
<%@ tag language="java" pageEncoding="UTF-8" body-content="empty" %>
<%

	SessionUser user = (SessionUser)request.getAttribute("loginUser");	
    StringBuilder builder = new StringBuilder();        
    List<ItemGroupMainVO> commonCodes = BasicCodeUtils.getItemMainList(user.getCompany());
    
    builder.append("<div class=\"form-inline\">");
    builder.append("	<div class=\"form-group\">");
    
    builder.append("<select class=\"form-control "+ "W80" +" \" onchange=\"changeItemMainCd();\"");
    builder.append("name=\"" + "itemMainCd" + "\"");
    builder.append("data-ax-path=\"" + "itemMainCd" + "\"");

    builder.append(">");

    builder.append(String.format("<option value=\"%s\">%s</option>", "", "전체"));
    
    for (ItemGroupMainVO commonCode : commonCodes) 
    {
        builder.append(String.format("<option value=\"%s\">%s</option>", commonCode.getItemMainCd(), commonCode.getItemMainNm()));
    }    
    builder.append("</select>");

    builder.append("&nbsp;<select class=\"form-control W100\" name=\"" + "itemSubCd" + "\">");
    builder.append(String.format("<option value=\"%s\">%s</option>", "", "전체"));
    builder.append("</select>");
    

    builder.append("	</div>");
    builder.append("</div>");
    
%>
<script>
function changeItemMainCd(){
	var company = SCRIPT_SESSION.company;
	var itemMainCd = $("select[name=itemMainCd]").val();
	$("select[name=itemSubCd] option").remove();
	if(nvl(itemMainCd,'') == ''){
   		$("select[name=itemSubCd]").append("<option value=''>전체</option>")
	}else{
		ppmboot.ajax({
	    	type: "GET",
           	url:  ["item", "itemSub"],
           	data: {company:company,itemMainCd:itemMainCd},
	        callback: function (res) {        
	        	if(res.list.length > 1 || res.list.length ==0){
	            	$("select[name=itemSubCd]").append("<option value=''>전체</option>")
	        	}		        	
	        	
	        	res.list.forEach(function (n) {
               		$("select[name=itemSubCd]").append("<option value='"+n.itemSubCd+"'>"+n.itemSubNm+"</option>")
	        	});	
	        	
    			$("select[name=itemSubCd] option:eq(0)").attr("selected","selected");	
	        }
	    });
	}
}

changeItemMainCd();
</script>
<%=builder.toString()%>