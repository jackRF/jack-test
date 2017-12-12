package com.jack.test.lang;

import java.util.function.Supplier;

public class DefaulableFactory {
	static Defaulable create(Supplier< Defaulable > supplier ) {
        return supplier.get();
    }
}
