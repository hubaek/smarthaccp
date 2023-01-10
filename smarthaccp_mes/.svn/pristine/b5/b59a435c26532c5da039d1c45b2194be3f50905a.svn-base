package com.ppm.mes.utils;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

public class CommonUtil {
	public static Instant stringToInstant(String timestamp){

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");   		    
	    TemporalAccessor temporalAccessor = formatter.parse(timestamp);
	    LocalDateTime localDateTime = LocalDateTime.from(temporalAccessor);
	    ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, ZoneId.systemDefault());
	    Instant resultInstant = Instant.from(zonedDateTime);	    
	    return resultInstant;
    }

}
