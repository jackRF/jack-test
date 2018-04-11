package com.jack.test.spring;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
@ContextConfiguration(locations={"classpath:spring/spring-*.xml"})
public abstract class AbstractSpringTest extends AbstractJUnit4SpringContextTests {
	protected void log(Object msg){
		System.out.println(msg);
	}
}
