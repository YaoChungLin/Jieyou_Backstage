package com.jieyou.manage.service.api;

public interface Function<T,E> {
	public T callback(E e);
}
