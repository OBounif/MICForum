package com.bounifomar.micforum.config;





import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;

import javax.servlet.descriptor.JspConfigDescriptor;
import javax.servlet.descriptor.JspPropertyGroupDescriptor;
import javax.servlet.descriptor.TaglibDescriptor;

import org.apache.catalina.Context;
import org.apache.tomcat.util.descriptor.web.JspPropertyGroup;
import org.apache.tomcat.util.descriptor.web.JspPropertyGroupDescriptorImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;







/*
 * 	By default spring components scanning has no effect on entity or repository scanning-
 *  Autowiring don't work on static fields
 *  
 *  @SpringBootApplication(exclude=DispatcherServletAutoConfiguration.class) prevents spring boot from creating its own dispatcher servlet with "/" mapping	
 *  
 *  
 * @Transactional it'll be ignored the method is not public also if the method invocation is inside the bean
 * 
 * 	
 * */

@SpringBootApplication(scanBasePackages = "com.bounifomar.micforum")
@EntityScan(basePackages = "com.bounifomar.micforum.models")
@EnableJpaRepositories(basePackages = "com.bounifomar.micforum.repositories")

public class ForumMicApplication implements CommandLineRunner{
	
	
	//private static Integer MAX_UPLOAD_SIZE = 2097152 ;
	
	private static String JSP_PROPERTY_URL_PATTERN = "*.jsp";
	private static String JSP_PROPERTY_PAGE_ENCODING ="UTF-8";
	private static String JSP_PROPERTY_INCLUDE_PRELUDE ="/WEB-INF/jspinclude/tags.jsp";
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(ForumMicApplication.class, args);
		
	}
	
	

	@Override
	public void run(String... args) throws Exception {
		
		
	}
	

	
	@Bean
	public ConfigurableServletWebServerFactory cnfServlerWebFactory()
	{
		
		return new TomcatServletWebServerFactory() {
			@Override
			protected void postProcessContext(Context context) {
				// TODO Auto-generated method stub
				super.postProcessContext(context);
				
				JspConfigDescriptor test = new JspConfigDescriptor() {
					
					@Override
					public Collection<TaglibDescriptor> getTaglibs() {
						// TODO Auto-generated method stub
						return Collections.emptyList();
					}
					
					@Override
					public Collection<JspPropertyGroupDescriptor> getJspPropertyGroups() {
						// TODO Auto-generated method stub
						Collection<JspPropertyGroupDescriptor> collection = new LinkedHashSet<JspPropertyGroupDescriptor>();
						
						JspPropertyGroup prop = new JspPropertyGroup();
						prop.addUrlPattern(JSP_PROPERTY_URL_PATTERN);
						prop.setPageEncoding(JSP_PROPERTY_PAGE_ENCODING);
						prop.addIncludePrelude(JSP_PROPERTY_INCLUDE_PRELUDE);	
						prop.setDefaultContentType("text/html");
						
						JspPropertyGroupDescriptor ijsp=new JspPropertyGroupDescriptorImpl(prop);
						collection.add(ijsp);
						
						return  collection;
					}
				};	
				
				context.setJspConfigDescriptor(test);
			}
		};
	}
	
}

