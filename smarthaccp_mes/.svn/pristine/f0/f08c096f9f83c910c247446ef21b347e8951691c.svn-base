<%@ tag import="org.apache.commons.lang3.StringUtils" %>
<%@ tag language="java" pageEncoding="UTF-8" body-content="empty" %>
<%@ taglib prefix="ppm" tagdir="/WEB-INF/tags" %>
<!-- input box name값 -->
<%@ attribute name="codeName" required="false" %>
<%@ attribute name="valueName" required="false" %>
<!-- 팝업 type -->
<%@ attribute name="modalType" required="true" %>
<%@ attribute name="whereValue" required="false" %>
<%
    if (StringUtils.isEmpty(whereValue)) {
    	whereValue = "";
    }
%>
<div class="form-inline">
    <div class="form-group">
        <input type="text" name="<%=codeName%>" class="form-control W79" value=""  placeholder="CODE"/>
        <input type="text" name="<%=valueName%>" class="form-control W90" value="" placeholder="NAME"/>
        <button type="button" class="btn btn-primary" onclick="openCommonModal('<%=codeName%>','<%=valueName%>','<%=modalType%>','<%=whereValue%>');return false;">
            <i class="cqc-magnifier"></i>
        </button>  
    </div>
</div>  
<script>
	function openCommonModal(codeName,valueName,modalType,whereValue){
        $("input[name="+codeName+"]").val("");
        $("input[name="+valueName+"]").val("");
        
		ppmboot.search_modal.open({  
            modalType: modalType,
            param: "",
            sendData: function(){
                return {
                	"whereValue" : nvl(whereValue,''),
                };
            },
            callback: function (data) {
                $("input[name="+codeName+"]").val(eval("data."+codeName));
                $("input[name="+valueName+"]").val(eval("data."+valueName));
               this.close();
            }
        });
	}
</script>