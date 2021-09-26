package com.bounifomar.micforum.config;



import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.bounifomar.micforum.controllers.interceptors.AdminCheckInterceptor;
import com.bounifomar.micforum.controllers.interceptors.AdminInterceptor;
import com.bounifomar.micforum.controllers.interceptors.LoggedUserInterceptor;
import com.bounifomar.micforum.controllers.interceptors.RegSignInterceptor;



/*
 * We shoudln't annotate our configuration class with @EnableWebMvc, or we'll lose out on Boot's auto configurations.
 * */

@Configuration
public class config implements WebMvcConfigurer{
	
	 @Override
	public void addInterceptors(InterceptorRegistry registry) {		 
		 registry.addInterceptor(new RegSignInterceptor()).addPathPatterns("/signIn","/signUp");
		 registry.addInterceptor(new LoggedUserInterceptor()).addPathPatterns("/user/*");
		 registry.addInterceptor(new AdminCheckInterceptor()).addPathPatterns("/checkAdmin","/assets/css/admin/*","/assets/js/admin/*","/assets/home/checkAdmin.js");
		 registry.addInterceptor(new AdminInterceptor()).addPathPatterns("/admin/*");
	 }
	 
	 
	
}