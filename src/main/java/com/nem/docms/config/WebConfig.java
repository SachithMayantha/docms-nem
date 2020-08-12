package com.nem.docms.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/webjars/**", "/images/**", "/css/**", "/js/**", "/fonts/**").addResourceLocations(
				"classpath:/META-INF/resources/webjars/", "classpath:/static/images/", "classpath:/static/css/",
				"classpath:/static/js/", "classpath:/static/fonts/");
	}

	@Override
	public void configureViewResolvers(final ViewResolverRegistry registry) {
		registry.jsp("/WEB-INF/view/", ".jsp");
		registry.jsp("/WEB-INF/view/jsp", ".jsp");
	}

}
