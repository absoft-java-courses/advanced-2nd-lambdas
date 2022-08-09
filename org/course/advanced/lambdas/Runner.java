package org.course.advanced.lambdas;

import org.course.advanced.lambdas.restaurant.Chef;
import org.course.advanced.lambdas.restaurant.Order1;
import org.course.advanced.lambdas.restaurant.Order2;

public class Runner {
    public static void main(String[] args) {
        var order1 = new Order1();
        var order2 = new Order2();

        var chef = new Chef();

        chef.execute(order1);
        chef.execute(order2);
    }
}
