package br.com.iss53;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.FixedLocaleResolver;

import ch.qos.logback.core.LayoutBase;
import nz.net.ultraq.thymeleaf.LayoutDialect;

@SpringBootApplication
public class ControleIss53Application {

	public static void main(String[] args) {
		SpringApplication.run(ControleIss53Application.class, args);
	}

	@Bean
	public LocaleResolver localeResolver() {
		return new FixedLocaleResolver(new Locale("pt", "BR"));
	}

	@Bean
	public LayoutDialect layoutDialect() {
		return new LayoutDialect();
	}

}