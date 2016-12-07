package com.facnet.ws;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import com.facnet.ws.rest.ProdutoResource;

public class RestfulApp extends Application {
	private Set<Object> singletons = new HashSet<Object>();
	private Set<Class<?>> empty = new HashSet<Class<?>>();

	public RestfulApp() {
		this.singletons.add(new ProdutoResource());
	}

	@Override
	public Set<Object> getSingletons() {
		return this.singletons;
	}

	@Override
	public Set<Class<?>> getClasses() {
		return this.empty;
	}
}
