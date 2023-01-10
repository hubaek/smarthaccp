package com.ppm.mes.logging;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

import com.chequer.axboot.core.config.AXBootContextConfig;
import com.chequer.axboot.core.domain.log.AXBootErrorLog;
import com.chequer.axboot.core.domain.log.AXBootErrorLogService;
import com.chequer.axboot.core.utils.JsonUtils;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.UnsynchronizedAppenderBase;
import lombok.Getter;
import lombok.Setter;
import net.gpedro.integrations.slack.SlackApi;
import net.gpedro.integrations.slack.SlackAttachment;
import net.gpedro.integrations.slack.SlackField;
import net.gpedro.integrations.slack.SlackMessage;

@Setter
@Getter
public class AXBootLogbackAppender extends UnsynchronizedAppenderBase<ILoggingEvent> {

    private AXBootErrorLogService errorLogService;
    
    private AXBootContextConfig axBootContextConfig;

    private AXBootContextConfig.Logging axBootLoggingConfig;

    public AXBootLogbackAppender(AXBootErrorLogService axBootErrorLogService, AXBootContextConfig axBootContextConfig) {
        this.errorLogService = axBootErrorLogService;
        this.axBootContextConfig = axBootContextConfig;
        this.axBootLoggingConfig = axBootContextConfig.getLoggingConfig();
    }

    @PostConstruct
    public void created() {
        this.axBootLoggingConfig = axBootContextConfig.getLoggingConfig();
    }

    @Override
    public void doAppend(ILoggingEvent eventObject) {
        super.doAppend(eventObject);
    }

	
    @Override
    protected void append(ILoggingEvent loggingEvent) {
    	
    	//에러로그 저장(axBootLoggingConfig의 Database isEnabled을 true로 설정) : 2022.02.09 KHJ
    	axBootLoggingConfig.getDatabase().setEnabled(true);
    	
    	if (loggingEvent.getLevel().isGreaterOrEqual(axBootLoggingConfig.getLevel())) {
            AXBootErrorLog errorLog = errorLogService.build(loggingEvent);

            if (axBootLoggingConfig.getDatabase().isEnabled()) {
                toDatabase(errorLog);
            }

            if (axBootLoggingConfig.getSlack().isEnabled()) {
                toSlack(errorLog);
            }

            
            if (axBootLoggingConfig.getJandi().isEnable()) {
                toJandi(errorLog);
            }
        }
    }

    private void toJandi(AXBootErrorLog errorLog) {
    	Map<String ,Object> paramMap1 = new HashMap();
		paramMap1.put("body", "스마트HACCP MES");
		paramMap1.put("connectColor", "#FAC11B");

		List<Map<String ,Object>> list = new ArrayList<>();
		Map<String ,Object> paramMap2 = new HashMap();

		paramMap2.put("title", errorLog.getPath());
		paramMap2.put("description", errorLog.getMessage());
		list.add(paramMap2);
		paramMap1.put("connectInfo", list);
		               
		try{
			String callUrl = axBootLoggingConfig.getJandi().getWebHookUrl();
			String jsonBody = JsonUtils.toJson(paramMap1);

	    	System.out.println("!!!!!"+ jsonBody.toString());

			HttpClient client = HttpClientBuilder.create().build();
			HttpPost post = new HttpPost(callUrl);
			StringEntity stringEntity = new StringEntity(jsonBody, "UTF-8");
			post.setHeader("Accept", "application/vnd.tosslab.jandi-v2+json");
			post.setHeader("Content-Type", "application/json");
			post.setEntity(stringEntity);
			
			HttpResponse response = client.execute(post);
		}catch(Exception e){
		}
    }


    private void toSlack(AXBootErrorLog errorLog) {
        SlackApi slackApi = new SlackApi(axBootLoggingConfig.getSlack().getWebHookUrl());

        List<SlackField> fields = new ArrayList<>();

        SlackField message = new SlackField();
        message.setTitle("에러내용");
        message.setValue(errorLog.getMessage());
        message.setShorten(false);
        fields.add(message);

        SlackField path = new SlackField();
        path.setTitle("요청 URL");
        path.setValue(errorLog.getPath());
        path.setShorten(false);
        fields.add(path);

        SlackField date = new SlackField();
        date.setTitle("발생시간");

        LocalDateTime localDateTime = LocalDateTime.ofInstant(errorLog.getErrorDatetime(), ZoneId.of("Asia/Seoul"));
        date.setValue(localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        date.setShorten(true);
        fields.add(date);

        SlackField profile = new SlackField();
        profile.setTitle("프로파일");
        profile.setValue(errorLog.getPhase());
        profile.setShorten(true);
        fields.add(profile);

        SlackField system = new SlackField();
        system.setTitle("시스템명");
        system.setValue(errorLog.getSystem());
        system.setShorten(true);
        fields.add(system);

        SlackField serverName = new SlackField();
        serverName.setTitle("서버명");
        serverName.setValue(errorLog.getServerName());
        serverName.setShorten(true);
        fields.add(serverName);

        SlackField hostName = new SlackField();
        hostName.setTitle("호스트명");
        hostName.setValue(errorLog.getHostName());
        hostName.setShorten(false);
        fields.add(hostName);

        if (errorLog.getUserInfo() != null) {
            SlackField userInformation = new SlackField();
            userInformation.setTitle("사용자 정보");
            userInformation.setValue(JsonUtils.toPrettyJson(errorLog.getUserInfo()));
            userInformation.setShorten(false);
            fields.add(userInformation);
        }

        String title = errorLog.getMessage();

        SlackAttachment slackAttachment = new SlackAttachment();
        slackAttachment.setFallback("에러발생!! 확인요망");
        slackAttachment.setColor("danger");
        slackAttachment.setFields(fields);
        slackAttachment.setTitle(title);

        if (StringUtils.isNotEmpty(axBootContextConfig.getLoggingConfig().getAdminUrl())) {
            slackAttachment.setTitleLink(axBootContextConfig.getLoggingConfig().getAdminUrl());
        }

        slackAttachment.setText(errorLog.getTrace());

        SlackMessage slackMessage = new SlackMessage("");

        String channel = axBootLoggingConfig.getSlack().getChannel();

        if (!axBootLoggingConfig.getSlack().getChannel().startsWith("#")) {
            channel = "#" + channel;
        }

        slackMessage.setChannel(channel);
        slackMessage.setUsername(String.format("[%s] - ErrorReportBot", errorLog.getPhase()));
        slackMessage.setIcon(":exclamation:");
        slackMessage.setAttachments(Collections.singletonList(slackAttachment));

        slackApi.call(slackMessage);
    }

    private void toDatabase(AXBootErrorLog errorLog) {
        errorLogService.saveLog(errorLog);
    }
}