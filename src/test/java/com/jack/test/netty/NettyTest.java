package com.jack.test.netty;

import java.util.Iterator;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

import com.jack.test.BaseTest;

import io.netty.util.concurrent.AbstractEventExecutorGroup;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.concurrent.MultithreadEventExecutorGroup;
import io.netty.util.concurrent.Promise;

public class NettyTest extends BaseTest {
	@Test
	public void test6() {
		 for (io.netty.util.ResourceLeakDetector.Level l : io.netty.util.ResourceLeakDetector.Level.values()) {
			 log(l.name());
			 log(l.ordinal());
         }

	}
	@Test
	public void testa() {
		log(isPowerOfTwo(7));
		log(isPowerOfTwo(8));
	}
	 private static boolean isPowerOfTwo(int val) {
	        return (val & -val) == val;
	    }
}
