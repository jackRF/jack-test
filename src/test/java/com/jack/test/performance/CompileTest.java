package com.jack.test.performance;

import org.junit.Test;

import com.jack.test.BaseTest;

public class CompileTest extends BaseTest {
	@Test
	public void testa1() {
		double l;
		int nloops=100;
		long then=System.currentTimeMillis();
		for(int i=0;i<nloops;i++) {
			l=fibImpl1(50);
		}
		long now=System.currentTimeMillis();
		log("Elapsed time:"+(now-then));
	}
	/**
	 * 斐波那契数
	 * @param n  第n个 ; n:0,1,2...
	 * @return
	 */
	private double fibImpl1(int n) {
		if(n<0) {
			throw new IllegalArgumentException("Must be>0");
		}else if(n==0) {
			return 0d;
		}else if(n==1) {
			return 1d;
		}else {
			double d=fibImpl1(n-2)+fibImpl1(n-1);
			if(Double.isInfinite(d)) {
				throw new ArithmeticException("Overflow");
			}
			return d;
		}
	}
}
