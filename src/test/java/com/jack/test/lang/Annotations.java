package com.jack.test.lang;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collection;

public class Annotations {
	@Retention(RetentionPolicy.RUNTIME)
	@Target({ ElementType.TYPE_USE, ElementType.TYPE_PARAMETER })
	public @interface NonEmpty {
	}

	public static class Holder<@NonEmpty T> extends @NonEmpty Object {
		public void method() throws @NonEmpty Exception {
		}
	}
    public static void annApply(String[] args) {
        final Holder< String > holder = new @NonEmpty Holder< String >();       
        @NonEmpty Collection< @NonEmpty String > strings = new ArrayList<>(); 
        strings.add("sfs");
        try {
			holder.method();
		} catch (@NonEmpty Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
