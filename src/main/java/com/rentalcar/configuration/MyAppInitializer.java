package com.rentalcar.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MyAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer
{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { WebApplicationContextConf.class }; //specifica la classe di configurazione
	}

	@Override
	protected Class<?>[] getServletConfigClasses() 
	{ 
		return null;
	}

	@Override
	protected String[] getServletMappings() 
	{
		return new String[] {"/"}; //qualsiasi chiamata verr� eseguita al nostro webServer verr� gestita dal dispatcher servlet
	}

}
