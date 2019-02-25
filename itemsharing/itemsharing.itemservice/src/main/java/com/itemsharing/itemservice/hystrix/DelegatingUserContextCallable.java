package com.itemsharing.itemservice.hystrix;

import java.util.concurrent.Callable;

import com.itemsharing.itemservice.util.UserContext;
import com.itemsharing.itemservice.util.UserContextHolder;

public class DelegatingUserContextCallable<V> implements Callable<V> {
	private final Callable<V> delegate;
	private UserContext originalUserContext;

	public DelegatingUserContextCallable(Callable<V> delegate, UserContext originalUserContext) {
		super();
		this.delegate = delegate;
		this.originalUserContext = originalUserContext;
	}

	@Override
	public V call() throws Exception {
		UserContextHolder.setContext(originalUserContext);
		try {
			return delegate.call();
		} finally {
			this.originalUserContext = null;
		}
	}

	public static <V> Callable<V> create (Callable<V> delegate, UserContext userContext) {
		return new DelegatingUserContextCallable<>(delegate, userContext);
	}
}
