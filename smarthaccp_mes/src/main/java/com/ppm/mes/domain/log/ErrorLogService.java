package com.ppm.mes.domain.log;

import javax.inject.Inject;
import javax.persistence.Query;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chequer.axboot.core.config.AXBootContextConfig;
import com.chequer.axboot.core.domain.log.AXBootErrorLog;
import com.chequer.axboot.core.domain.log.AXBootErrorLogService;
import com.chequer.axboot.core.utils.MDCUtil;
import com.chequer.axboot.core.utils.ModelMapperUtils;
import com.chequer.axboot.core.utils.PhaseUtils;
import com.ppm.mes.domain.BaseService;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.classic.spi.StackTraceElementProxy;
import ch.qos.logback.core.util.ContextUtil;


@Service
public class ErrorLogService extends BaseService<ErrorLog, Long> implements AXBootErrorLogService {

    private ErrorLogRepository repository;


    @Inject
    private AXBootContextConfig axBootContextConfig;

    @Inject
    public ErrorLogService(ErrorLogRepository repository) {
        super(repository);
        this.repository = repository;
    }

    @Override
    public void saveLog(AXBootErrorLog axBootErrorLog) {
        ErrorLog errorLog = ModelMapperUtils.map(axBootErrorLog, ErrorLog.class);
        save(errorLog);
    }


    @Override
	@Transactional
    public void deleteAllLogs() {
        Query query = em.createNativeQuery("DELETE FROM TB_MES_ERRLOG000");
        query.executeUpdate();
    }

    @Override
    public void deleteLog(Long id) {
        delete(id);
    }

    @Override
    public AXBootErrorLog build(ILoggingEvent loggingEvent) {
        ErrorLog errorLog = new ErrorLog();
        errorLog.setPhase(PhaseUtils.phase());
        errorLog.setSystem(axBootContextConfig.getApplication().getName());
        errorLog.setSystem("HACCP");
        errorLog.setLoggerName(loggingEvent.getLoggerName());
        errorLog.setServerName(axBootContextConfig.getServerName());
        errorLog.setHostName(getHostName());
        errorLog.setPath(MDCUtil.get(MDCUtil.REQUEST_URI_MDC));
        errorLog.setMessage(loggingEvent.getFormattedMessage());
        errorLog.setHeaderMap(MDCUtil.get(MDCUtil.HEADER_MAP_MDC));
        errorLog.setParameterMap(MDCUtil.get(MDCUtil.PARAMETER_BODY_MDC));
        errorLog.setUserInfo(MDCUtil.get(MDCUtil.USER_INFO_MDC));

        if (loggingEvent.getThrowableProxy() != null) {
            errorLog.setTrace(getStackTrace(loggingEvent.getThrowableProxy().getStackTraceElementProxyArray()));
        }

        return errorLog;
    }


    public String getHostName() {
        try {
            return ContextUtil.getLocalHostName();
        } catch (Exception e) {
            // ignored
        }
        return null;
    }

    public String getStackTrace(StackTraceElementProxy[] stackTraceElements) {
        if (stackTraceElements == null || stackTraceElements.length == 0) {
            return null;
        }

        StringBuilder sb = new StringBuilder();
        for (StackTraceElementProxy element : stackTraceElements) {
            sb.append(element.toString());
            sb.append("\n");
        }
        return sb.toString();
    }
}

