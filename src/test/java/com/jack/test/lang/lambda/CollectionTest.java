package com.jack.test.lang.lambda;

import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import org.junit.Test;

import com.jack.test.BaseTest;

public class CollectionTest extends BaseTest {
	static {
//		sfs();
	}
	private String testType="lang";
	@Test
	public void testa() {
//		Arrays.asList("a","b","c").forEach(e->log(e));
//		sfs();
		MyFunction<String> fn=e->{log(e);};
		funca(fn, "sfs","bvnghj","gkyu");
		funca(e->log(e), "sfs","bvnghj","gkyu");
	}
	
	private void funca(MyFunction<String> fn,String...items){
		for(String s:items){
			fn.action(s);
		}
	}
	private static void sfs(){
		asf(e->log(e), Arrays.asList("a","b","c"));
	}
	private  static void asf(Consumer<?super String> action,List<String> list){
		log(action.getClass());
		log(Modifier.isStatic(action.getClass().getModifiers()));
		for(String s:list){
			action.accept("{"+s+"}");
		}
	}
}
