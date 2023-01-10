<%@ tag import="org.apache.commons.lang3.StringUtils" %>
<%@ tag import="java.text.SimpleDateFormat" %>
<%@ tag import="java.util.Calendar" %>
<%@ tag import="java.util.List" %>
<%@ tag language="java" pageEncoding="UTF-8" body-content="empty" %>
<%@ taglib prefix="ppm" tagdir="/WEB-INF/tags" %>

<!-- input box id값 FROM~TO -->
<%@ attribute name="fromId" required="false" %>
<%@ attribute name="toId" required="false" %>
<%@ attribute name="fromDataPath" required="false" %>
<%@ attribute name="toDataPath" required="false" %>

<%@ attribute name="requiredFlag" required="false" %>
<%@ attribute name="title" required="false" %>
<%@ attribute name="dateType" required="false" %>

<%
StringBuilder builder = new StringBuilder();
builder.append("<div class=\"input-group\" data-ax5picker=\"period\">");


SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
Calendar cal = Calendar.getInstance();
Calendar calF = Calendar.getInstance();
String toDate = sdf.format(cal.getTime());


if (StringUtils.isNotEmpty(dateType) && dateType.equals("YEAR")) {
	cal.add(Calendar.YEAR,-1); 
}else if (StringUtils.isNotEmpty(dateType) && dateType.equals("MON")) {
	cal.add(Calendar.MONTH,-1); 
}else if (StringUtils.isNotEmpty(dateType) && dateType.equals("WEEK")) {
	cal.add(Calendar.DATE,-7); 
}else if (StringUtils.isNotEmpty(dateType) && dateType.equals("TODAY")) {
	cal.add(Calendar.DATE,-0); 
}else{
	cal.add(Calendar.DATE,-7); 
}
String fromDate = sdf.format(cal.getTime());

//TO DATE를 세팅 : 김회재 수정 (20.11.10)
if (StringUtils.isNotEmpty(dateType) && dateType.equals("YEAR_T")) {
	fromDate = sdf.format(calF.getTime());
	calF.add(Calendar.YEAR, 1); 
	toDate = sdf.format(calF.getTime());
}else if (StringUtils.isNotEmpty(dateType) && dateType.equals("MON_T")) {
	fromDate = sdf.format(calF.getTime());
	calF.add(Calendar.MONTH, 1); 
	toDate = sdf.format(calF.getTime());
}else if (StringUtils.isNotEmpty(dateType) && dateType.equals("WEEK_T")) {
	fromDate = sdf.format(calF.getTime());
	calF.add(Calendar.DATE, 7); 
	toDate = sdf.format(calF.getTime());
}


//FROM  
if (StringUtils.isNotEmpty(fromId)) {
	builder.append("<input type=\"text\" class=\"form-control\" placeholder=\"yyyy-mm-dd\" ");
	
	if(StringUtils.isNotEmpty(requiredFlag)){
		builder.append(String.format("data-ax-validate=\"required\" title=\"%s\" class=\"form-control required\"", title));
	}

    builder.append("id=\"" + fromId + "\"");
    builder.append("name=\"" + fromId + "\"");
    builder.append("value=\"" + fromDate + "\"");
    builder.append(">");
}

if (StringUtils.isNotEmpty(fromDataPath)) {
	builder.append("<input type=\"text\" class=\"form-control\" placeholder=\"yyyy-mm-dd\" ");

	if(StringUtils.isNotEmpty(requiredFlag)){
		builder.append(String.format("data-ax-validate=\"required\" title=\"%s\" class=\"form-control required\"", title));
	}
	
    builder.append("data-ax-path=\"" + fromDataPath + "\"");
    builder.append("value=\"" + fromDate + "\"");
    builder.append(">");
}

//TO
if (StringUtils.isNotEmpty(toId)) {
	builder.append("<span class=\"input-group-addon\">~</span>");
	builder.append("<input type=\"text\" class=\"form-control\" placeholder=\"yyyy-mm-dd\" ");

	if(StringUtils.isNotEmpty(requiredFlag)){
		builder.append(String.format("data-ax-validate=\"required\" title=\"%s\" class=\"form-control required\"", title));
	}

    builder.append("id=\"" + toId + "\"");
    builder.append("name=\"" + toId + "\"");
    builder.append("value=\"" + toDate + "\"");
    builder.append(">");
}

if (StringUtils.isNotEmpty(toDataPath)) {
	builder.append("<span class=\"input-group-addon\">~</span>");
	builder.append("<input type=\"text\" class=\"form-control\" placeholder=\"yyyy-mm-dd\" ");
	
	if(StringUtils.isNotEmpty(requiredFlag)){
		builder.append(String.format("data-ax-validate=\"required\" title=\"%s\" class=\"form-control required\"", title));
	}
	
    builder.append("data-ax-path=\"" + toDataPath + "\"");
    builder.append("value=\"" + toDate + "\"");
    builder.append(">");
}
builder.append("<span class=\"input-group-addon\"><i class=\"cqc-calendar\"></i></span>");
builder.append("	</div>");
%>
<%=builder.toString()%>  

<script type="text/javascript">
    var picker = new ax5.ui.picker();
    $(document.body).ready(function () {
        picker.bind({
            target: $('[data-ax5picker="period"]'),
            direction: "top",
            content: {
                width: 270,
                margin: 10,
                type: 'date',
                config: {
                    control: {
                        left: '<i class="fa fa-chevron-left"></i>',
                        yearTmpl: '%s',
                        monthTmpl: '%s',
                        right: '<i class="fa fa-chevron-right"></i>'
                    },
                    marker: (function () {
                        var marker = {};
                        marker[ax5.util.date(new Date(), {'return': 'yyyy-MM-dd', 'add': {d: 0}})] = true;
 
                        return marker;
                    })()
                },
                formatter: {
                    pattern: 'date'
                }
            },
            onStateChanged: function () {
                if (this.state == "open") {
                    var selectedValue = this.self.getContentValue(this.item["$target"]);
                    if (!selectedValue) {
                        this.item.pickerCalendar[0].ax5uiInstance.setSelection([ax5.util.date(new Date(), {'add': {d: 1}})]);
                    }
                }
            }
        });
    });
</script>