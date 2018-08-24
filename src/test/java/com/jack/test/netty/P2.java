package com.jack.test.netty;

import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.concurrent.ProgressivePromise;

public class P2<V> extends P1<V> {
	@Override
    public ProgressivePromise<V> addListener(GenericFutureListener<? extends Future<? super V>> listener) {
		return null;
		
	}
}
