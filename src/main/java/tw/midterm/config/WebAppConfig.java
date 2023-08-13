package tw.midterm.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

//相當於mvc-servlet.xml的java程式組態
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"tw.midterm"})
public class WebAppConfig implements WebMvcConfigurer {
	
	@Bean
	public MappingJackson2JsonView jsonView() {
		MappingJackson2JsonView jView = new MappingJackson2JsonView();
		jView.setPrettyPrint(true);
		return jView;
	}
	
	@Bean
	public ContentNegotiatingViewResolver contentViewResolver() {
		ContentNegotiatingViewResolver vr1 = new ContentNegotiatingViewResolver();
		
		List<View> lists = new ArrayList<View>();
		lists.add(jsonView());
		
		vr1.setDefaultViews(lists);
		return vr1;
	}
	

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}	
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/images/**").addResourceLocations("/WEB-INF/resources/images/");
		registry.addResourceHandler("/css/**").addResourceLocations("/WEB-INF/resources/css/");
		registry.addResourceHandler("/js/**").addResourceLocations("/WEB-INF/scripts/");
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addRedirectViewController("/", "membersmain.controller");
		registry.addViewController("/happyday.action").setViewName("form");
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
		lci.setParamName("locale");
		registry.addInterceptor(lci).addPathPatterns("/**");
	}

	@Bean
	public InternalResourceViewResolver viewResolver() {
		//InternalResourceViewResolver irv = new InternalResourceViewResolver("/WEB-INF/pages/",".jsp");
		InternalResourceViewResolver irv = new InternalResourceViewResolver();
		irv.setPrefix("/WEB-INF/pages/");
		irv.setSuffix(".html");
		irv.setOrder(6);
		return irv;
	}
	
	@Bean
	public ResourceBundleMessageSource messageSource() {
		ResourceBundleMessageSource ms = new ResourceBundleMessageSource();
		ms.setBasename("i18n.message");
		ms.setDefaultEncoding("UTF-8");
		return ms;
	}
	
	@Bean
	public SessionLocaleResolver localeResolver() {
		SessionLocaleResolver lr = new SessionLocaleResolver();
		return lr;
	}
	
	@Bean
	public StandardServletMultipartResolver multipartResolver() {
		return new StandardServletMultipartResolver();
	}

}
