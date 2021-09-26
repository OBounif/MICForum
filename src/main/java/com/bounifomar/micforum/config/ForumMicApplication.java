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
 * 	
 * 	-By default spring components scanning has no effect on entity or repository scanning
 *  -Autowiring don't work on static fields
 *  
 *  -@SpringBootApplication(exclude=DispatcherServletAutoConfiguration.class) prevents spring boot from creating its own dispatcher servlet with "/" mapping	
 *  
 *  
 * 	-@Transactional it'll be ignored if the method is not public also if the method invocation is inside the bean
 * 
 * 	
 */

@SpringBootApplication(scanBasePackages = "com.bounifomar.micforum")
@EntityScan(basePackages = "com.bounifomar.micforum.models")
@EnableJpaRepositories(basePackages = "com.bounifomar.micforum.repositories")

public class ForumMicApplication implements CommandLineRunner{

	
	private static String JSP_PROPERTY_URL_PATTERN = "*.jsp";
	private static String JSP_PROPERTY_PAGE_ENCODING ="utf-8";
	private static String JSP_PROPERTY_INCLUDE_PRELUDE ="/WEB-INF/jspinclude/tags.jsp";
	

	public static void main(String[] args) {
		SpringApplication.run(ForumMicApplication.class, args);
		
	}
	
	

	@Override
	public void run(String... args) throws Exception {
	/*	
		UserRank rank = new UserRank(UserRankType.ADMINISTRATOR,null,0,0,true);
		UserRank rank1 = new UserRank(UserRankType.MODERATOR,null,0,0,true);
		UserRank rank2 = new UserRank(UserRankType.FORUM_MODERATOR,null,0,0,true);
		
		UserRank rank3 = new UserRank(UserRankType.NEWBIE,null,0,1000,false);
		UserRank rank4 = new UserRank(UserRankType.MEMBRE,null,1000,5000,false);
		UserRank rank5 = new UserRank(UserRankType.ACTIF_MEMBER,null,5000,10000,false);
		UserRank rank6 = new UserRank(UserRankType.WRITER,null,10000,1000000,false);

		rankRep.save(rank);
		rankRep.save(rank1);
		rankRep.save(rank2);
		rankRep.save(rank3);
		rankRep.save(rank4);
		rankRep.save(rank5);
		rankRep.save(rank5);
	*/	
	
	}
	
	@Bean
	public ConfigurableServletWebServerFactory cnfServlerWebFactory()
	{
		
		return new TomcatServletWebServerFactory() {
			@Override
			protected void postProcessContext(Context context) {
				super.postProcessContext(context);
				
				JspConfigDescriptor test = new JspConfigDescriptor() {
					
					@Override
					public Collection<TaglibDescriptor> getTaglibs() {
						return Collections.emptyList();
					}
					
					@Override
					public Collection<JspPropertyGroupDescriptor> getJspPropertyGroups() {
						Collection<JspPropertyGroupDescriptor> collection = new LinkedHashSet<JspPropertyGroupDescriptor>();
						
						JspPropertyGroup prop = new JspPropertyGroup();
						prop.addUrlPattern(JSP_PROPERTY_URL_PATTERN);
						
						//The encoding somehow doesn't apply to the header jsp
						prop.setPageEncoding(JSP_PROPERTY_PAGE_ENCODING);
						
						prop.addIncludePrelude(JSP_PROPERTY_INCLUDE_PRELUDE);	
						
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

