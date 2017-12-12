package com.jack.test.lang;

public interface Defaulable {
	default String notRequired() { 
        return "Default implementation"; 
    }
	static class DefaultableImpl implements Defaulable {
	}
	     
	static class OverridableImpl implements Defaulable {
	    @Override
	    public String notRequired() {
	        return "Overridden implementation";
	    }
	}
}
