package com.jack.test;

import org.junit.Test;

public class ThreadTest extends BaseTest {
	@Test
	public void testa() {
		try{
			Thread.currentThread().stop();
		}catch(ThreadDeath e){
			e.printStackTrace();
		}

	}
}
