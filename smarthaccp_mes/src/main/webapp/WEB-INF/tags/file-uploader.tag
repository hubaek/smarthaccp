<%@ tag import="org.apache.commons.lang3.StringUtils" %>
<%@ tag language="java" pageEncoding="UTF-8" body-content="empty" %>
<%@ taglib prefix="ppm" tagdir="/WEB-INF/tags" %>
<%@ attribute name="targetType" %>
<%@ attribute name="targetId" %>
<%@ attribute name="targetId2" %>
<%@ attribute name="targetId3" %>
<%@ attribute name="fileCount" %>
<%@ attribute name="errMsg" %>
<%@ attribute name="deleteYn" %>

<%
if (StringUtils.isEmpty(fileCount)) {
	fileCount = "10";
}
%>

<div data-ax5uploader="upload1">
	<input type="hidden" name = "targetType" id = "targetType" value = "<%=targetType%>"/>
	<input type="hidden" name = "targetId" id = "targetId" value = "<%=targetId%>"/>
	<input type="hidden" name = "targetId2" id = "targetId2" value = "<%=targetId2%>"/>
	<input type="hidden" name = "targetId3" id = "targetId3" value = "<%=targetId3%>"/>
	<input type="hidden" name = "tempYn" id = "tempYn" value = "N"/>
	<input type=hidden name="thumbnail" value ="false"/>
    <button data-ax5uploader-button="selector" class="btn btn-primary" style="display:none">파일선택 (*/*)</button>
    <div data-uploaded-box="upload1" data-ax5uploader-uploaded-box="inline"></div>
</div>

<script>
var UPLOAD;
var targetType = "<%=targetType%>";
var targetId = "<%=targetId%>";
var targetId2 = "<%=targetId2%>";
var targetId3 = "<%=targetId3%>";
var fileCount = "<%=fileCount%>";
var deleteYn = "<%=deleteYn%>";
var errMsg = "<%=errMsg%>";

$(function () {
    var DIALOG = new ax5.ui.dialog({
        title: "HACCP"      
    });
    
    UPLOAD = new ax5.ui.uploader({
        target: $('[data-ax5uploader="upload1"]'),
        form: {
        	action: "/api/v1/files/upload",
            fileNm: "file"
        },
        multiple: true,
        manualUpload: false,
        progressBox: true,
        progressBoxDirection: "left",
        dropZone: {
            target: $('[data-uploaded-box="upload1"]')
        },
        uploadedBox: {
            target: $('[data-uploaded-box="upload1"]'),
            icon: {
                "download": '<i class="cqc-controller-down" aria-hidden="true"> DOWNLOAD</i>',
                "delete": '<i class="cqc-trash" aria-hidden="true" style="width:40px"> DELETE</i>'
            },
            columnKeys: {
                apiServerUrl: "",
                name: "fileNm",
                type: "fileType",
                size: "fileSize",
                uploadedName: "saveNm",
                thumbnail: "thumbnail"
            },  
            lang: {
                supportedHTML5_emptyListMsg: '<div class="text-center" style="padding-top: 30px;"><font size =4><i class="cqc-arrow-with-circle-down" aria-hidden="true"><BR><BR>  Choose a file or Drag it here</i></font></div>',
                emptyListMsg: '<div class="text-center" style="padding-top: 30px;">Empty of List.</div>'
            },
            onchange: function () {

            },
            onclick: function () {
                var fileIndex = this.fileIndex;
                var file = this.uploadedFiles[fileIndex];
                switch (this.cellType) {
                    case "delete":
                    	if(nvl(deleteYn,"Y") == "N"){
                            alert("삭제할 수 없는 파일입니다.");
                    	}else{
                            DIALOG.confirm({
                                title: "HACCP",
                                msg: "선택하신 파일을 삭제하시겠습니까?"
                            }, function () {
                                if (this.key == "ok") {  
                                    $.ajax({
                                        contentType: "application/json",
                                        method: "PUT",
                                        url: "/api/v1/files",
                                        data: JSON.stringify([{
                                            id: file.id
                                        }]),
                                        success: function (res) {
                                            if (res.error) {
                                                return;
                                            }
                                            UPLOAD.removeFile(fileIndex);
                                        }
                                    });
                                }
                            });
                    	}
                        break;

                    case "download":
                        if (file.download) {
                            location.href = file.download;
                        }
                        break;
                    case "filename":
                        if (file.download) {
                            location.href = file.download;
                        }
                        break;
                    case "filesize":
                        if (file.download) {
                            location.href = file.download;
                        }
                        break;
                }
            }
        },
        validateSelectedFiles: function () {
        	
        	var target = $('[data-ax-path="' + targetId + '"]').val();
        	var target2 = $('[data-ax-path="' + targetId2 + '"]').val();
        	var target3 = $('[data-ax-path="' + targetId3 + '"]').val();

        	if(nvl(target,"") == ""){
            	target = nvl(target,tempFileCd);     
        		$("#tempYn").val("Y"); 		
        	}else{   
        		$("#tempYn").val("N"); 		
        	}
        	        	
        	if(nvl(target,"") == ""){
                alert("!" + errMsg);
                return false;
        	}else{
        		$("#targetId").val(target);
        		$("#targetId2").val(target2);
        		$("#targetId3").val(target3);
        	}
            // 10개 이상 업로드 되지 않도록 제한.
            if (this.uploadedFiles.length + this.selectedFiles.length > fileCount) {
                alert(fileCount + "개이상의 파일은 업로드 할 수 없습니다.");
                return false;
            }

            return true;
        },
        onprogress: function () {
        },
        onuploaderror: function () {
        },
        onuploaded: function () {
        },
        onuploadComplete: function () {
        }
    });
});

function searchFile(targetId,targetId2,targetId3){
    // 파일 목록 가져오기
    ppmboot.ajax({
            type: "GET",
            url: ["files"],
            data: {targetType:targetType,targetId:targetId,targetId2:targetId2,targetId3:targetId3},
            callback: function (res) {
                UPLOAD.setUploadedFiles(res.list);
            }
        });
}

</script>