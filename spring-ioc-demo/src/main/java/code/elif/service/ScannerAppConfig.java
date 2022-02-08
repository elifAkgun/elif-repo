package code.elif.service;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import code.elif.service.impl.ScannerAImpl;
import code.elif.service.impl.ScannerBImpl;

@Configuration
public class ScannerAppConfig {
	
	@Bean
	@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public Scanner scannerA() {
		return new ScannerAImpl();
	}
	
	@Bean
	public Scanner scannerB() {
		return new ScannerBImpl();
	}

}
