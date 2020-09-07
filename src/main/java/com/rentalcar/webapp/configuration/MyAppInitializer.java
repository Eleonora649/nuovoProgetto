package com.rentalcar.webapp.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

//configurazione DispatcherServlet con annotatio - no file xml
public class MyAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer
{ 		//specifica la classe di configurazione

	@Override
	protected Class<?>[] getRootConfigClasses() 
	{
		return new Class[] { HibernateConfiguration.class, SecurityConfig.class }; 
	}

	@Override
	protected Class<?>[] getServletConfigClasses() 
	{ 
		return new Class[] {WebApplicationContextConf.class};
	}

	@Override
	protected String[] getServletMappings() 
	{
		return new String[] {"/"}; //qualsiasi chiamata verrà eseguita al nostro webServer verrà gestita dal dispatcher servlet
	}

}
