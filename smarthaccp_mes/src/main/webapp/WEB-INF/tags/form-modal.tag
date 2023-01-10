<%@ tag import="org.apache.commons.lang3.StringUtils" %>
<%@ tag language="java" pageEncoding="UTF-8" body-content="empty" %>
<%@ taglib prefix="ppm" tagdir="/WEB-INF/tags" %>
<!-- input box name값 -->
<%@ attribute name="codeName" required="false" %>
<%@ attribute name="valueName" required="false" %>
<!-- 팝업 type -->
<%@ attribute name="modalType" required="true" %>
<%@ attribute name="whereValue" required="false" %>

<%@ attribute name="required" required="false" %>
<%@ attribute name="title" required="false" %>
<%
	if (StringUtils.isEmpty(whereValue)) {
		whereValue = "";
	}

	if (StringUtils.isNotEmpty(required)) {
		required = "required";
	}
	
%>
<div class="form-inline">
    <div class="form-group">
        <input type="text" data-ax-path="<%=codeName%>"  class="form-control W79" data-ax-validate="<%=required%>" title="<%=title%>" placeholder="CODE" readonly="readonly"/>
        <input type="text" data-ax-path="<%=valueName%>" class="form-control W90" placeholder="NAME" readonly="readonly"/>
        <button type="button" class="btn btn-primary"   onclick="openFormCommonModal('<%=codeName%>','<%=valueName%>','<%=modalType%>','<%=whereValue%>');return false;">
            <i class="cqc-magnifier"></i>
        </button>  
    </div>
</div>  
<script>
	function openFormCommonModal(codeName,valueName,modalType,whereValue){
    	if(codeName == "userCd"){
        	var item = new Object();
        	fnObj.formView01.setDefaultUser(item);
    	}else if(codeName == "routCd"){
    		var item = new Object();
    		if(whereValue=="search"){
    			fnObj.searchView.setDefaultRout(item);
    		}else{
    			fnObj.formView01.setDefaultRout(item);
    		}
    	}else{
        	var item = new Object();
        	fnObj.formView01.setDefaultCust(item);
    	}
    	
		ppmboot.search_modal.open({  
            modalType: modalType,
            param: "",
            sendData: function(){
                return {
                	"whereValue" : nvl(whereValue,''),
                };
            },
            callback: function (data) {
            	if(codeName == "userCd"){
                	var item = new Object();
                	item.userCd = eval("data."+codeName);
                	item.userNm = eval("data."+valueName)
                	fnObj.formView01.setDefaultUser(item);
            	}else if(codeName == "routCd"){
            		var item = new Object();
            		
            		item.routCd = eval("data."+codeName);
            		item.routNm = eval("data."+valueName)
            		if(whereValue=="search"){
            			fnObj.searchView.setDefaultRout(item);
            		}else{
            			fnObj.formView01.setDefaultRout(item);
            		}
            	}else{
                	var item = new Object();
                	item.custCd = eval("data."+codeName);
                	item.custNm = eval("data."+valueName)
                	fnObj.formView01.setDefaultCust(item);
            	}
               	this.close();
            }
        });
	}
</script>