package com.splitspends;

import org.springframework.web.filter.CorsFilter;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.splitspends.model.Expense;
import com.splitspends.repository.ExpenseRepository;

import java.util.Collections;
import java.util.stream.Stream;

@SpringBootApplication
public class SplitspendsApplication {

    public static void main(String[] args) {
	SpringApplication.run(SplitspendsApplication.class, args);
    }

    @Bean
    ApplicationRunner init(ExpenseRepository repository) {
	return args -> {
	    Stream.of("Ferrari", "Jaguar", "Porsche", "Lamborghini", "Bugatti", "AMC Gremlin", "Triumph Stag",
		    "Ford Pinto", "Yugo GV").forEach(detail -> {
			Expense expense = new Expense();
			expense.setDetail(detail);
			repository.save(expense);
		    });
	    repository.findAll().forEach(System.out::println);
	};
    }
    
    @Bean
    public FilterRegistrationBean<CorsFilter> simpleCorsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
        config.setAllowedMethods(Collections.singletonList("*"));
        config.setAllowedHeaders(Collections.singletonList("*"));
        source.registerCorsConfiguration("/**", config);
        FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<CorsFilter>(new CorsFilter(source));
        bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return bean;
    }

}
