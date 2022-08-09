package org.course.advanced.lambdas.restaurant;

import java.util.function.Supplier;

public class Chef {

    public void execute(Supplier<String> order) {
        System.out.printf("Chef has started to to cook \"%s\"\n", order.get());
    }
}
