package com.jack.test.netty;

import java.util.Iterator;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

import com.jack.test.BaseTest;

import io.netty.util.concurrent.AbstractEventExecutorGroup;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.MultithreadEventExecutorGroup;

public class NettyTest extends BaseTest {
	@Test
	public void testa() {
		log(isPowerOfTwo(7));
		log(isPowerOfTwo(8));
	}
	 private static boolean isPowerOfTwo(int val) {
	        return (val & -val) == val;
	    }
}
