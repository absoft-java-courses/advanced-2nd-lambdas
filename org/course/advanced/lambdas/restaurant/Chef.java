package org.course.advanced.lambdas.restaurant;

public class Chef {

    public void execute(Order order) {
        System.out.printf("Chef has started to to cook \"%s\"\n", order.getOrder());
    }
}
