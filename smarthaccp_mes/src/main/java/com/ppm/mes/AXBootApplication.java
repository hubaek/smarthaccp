package com.ppm.mes;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import com.chequer.axboot.core.AXBootCoreConfiguration;

@SpringBootApplication
@PropertySource(value = {"classpath:ppmboot-common.properties", "classpath:ppmboot-${spring.profiles.active:local}.properties"})
@Import(AXBootCoreConfiguration.class)
public class AXBootApplication {
}
