package br.com.virtz.cfc.servlet.config;

import br.com.virtz.cfc.servlet.modules.BootstrapServletModule;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.persist.PersistService;
import com.google.inject.servlet.GuiceServletContextListener;

/**
 * This class goes mapped in web.xml and is used to inject Google Guice's Injector into the Web Application Context.
 * 
 */
public class GenericGuiceContextListener extends GuiceServletContextListener{

	@Override
	protected Injector getInjector() {
		Injector inj = Guice.createInjector(new BootstrapServletModule());
		PersistService persistService = inj.getInstance(PersistService.class);
		persistService.start();
		return inj;
	}
	
}
