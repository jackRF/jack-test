package com.jack.test.netty;

import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.concurrent.Promise;

public class P1<V> {
	public Promise<V> addListener(GenericFutureListener<? extends Future<? super V>> listener) {
		return null;
		 
	 }
}
