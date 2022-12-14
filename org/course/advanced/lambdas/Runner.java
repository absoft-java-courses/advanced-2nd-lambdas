package org.course.advanced.lambdas;

import org.course.advanced.lambdas.restaurant.Chef;
import org.course.advanced.lambdas.restaurant.Order;
import org.course.advanced.lambdas.restaurant.Order1;
import org.course.advanced.lambdas.restaurant.Order2;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Runner {
    public static void main(String[] args) throws IOException {
        exampleWithRestaurant();

        System.out.println("\n\n\n\n\n\n");
        exampleWithList();

        System.out.println("\n\n\n\n\n\n");
        howeWork();


        System.out.println("\n\n\n\n\n\n");
        exampleWithStreams();
    }

    private static void exampleWithStreams() throws IOException {
        var list = Arrays.asList(
                "string1",
                "string 3!!!",
                null,
                "string 2"
        );


        var collect = list.stream()
//                .filter(Objects::nonNull)
                .filter(str -> str != null && !str.equals("string 3!!!"))
                .map(String::toUpperCase)
                .peek(str -> System.out.printf("Element: '%s'\n", str))
                .collect(Collectors.toList());
        //

        System.out.println("\n\n\n\n\n\n");

        var filePath = new File("lines.txt").toPath();
        var joinedString = Files.readAllLines(filePath).stream()
                .map(String::trim)
                .filter(line -> line.length() > 0)
                .flatMap(line -> Stream.of(line.split(" ")))
//                .map(line -> line.split(" "))
//                .map(lineArray -> Stream.of(lineArray))
//                .flatMap(streamOfStreams -> streamOfStreams)
//                .map(word -> Integer.toString(word.length()))


                .collect(Collectors.joining(" | ", "", "."));
        System.out.println(joinedString);


        Integer a = 1;
        Integer b = 2;

        Integer c = a + b;
        int xxx;
        Double xx;
        double xafdf;

        Stream<Integer> streamOfInt;
    }

    private static void howeWork() {
        var list = Arrays.asList(
                "The quick brown Fox jumps over the lazy Dog.",
                "Waltz, bad nymph, for quick jigs vex.",
                "Pack my box with five dozen liquor jugs.",
                "A MAD BOXER SHOT A QUICK, GLOVED JAB TO THE JAW OF HIS DIZZY OPPONENT."
        );
        System.out.println("Source list " + list);

        // TODO: 1) use replaceAll to lowercase all strings. You can use myString.toLowerCase() method
//        list.replaceAll(...your lambda or method reference here...);

        System.out.println("List with lowercase strings: " + list);

        // TODO: 2) sort this list, by the string length
        System.out.println("List after sort: " + list);

        // TODO: 3) use list.forEach(...your lambda/method ref...) to print all elements to console

        // TODO: 4) use list.removeIf(...) to remove each element that contain at list two commas (only "Waltz, bad nymph, for quick jigs vex.")
        System.out.println("List removing string with 2+ commas: " + list);
    }

    private static void exampleWithList() {
        var list = Arrays.asList(
                "string1",
                "string 3!!!",
                "string 2"
        );
        System.out.println(list);

        list.sort(
                (String str1, String str2) -> str1.length() - str2.length()
        );
//        list.sort(new MyBigComparator());
        System.out.println(list);

        list.sort(Runner::compare);
        System.out.println(list);


        Supplier<Order> orderSupplier = Order1::new;
        Function<String, Order> function = Order1::new;


        Supplier<Order> orderSupplier1 = () -> new Order1();
    }

    private static int compare(String str1, String str2) {
        System.out.println("hello from compare method");

        char lastChar1 = str1.charAt(str1.length() - 1);
        char lastChar2 = str2.charAt(str2.length() - 1);

        return lastChar1 - lastChar2;
    }

    private static void exampleWithRestaurant() {
        var chef = new Chef();

        var order1 = new Order1();
        var order2 = new Order2();

        var order3 = new Order() {
            public String getOrder() {
                return "tea";
            }
        };

        //
        chef.execute(order1);
        chef.execute(order2);

        //
        chef.execute(order3);

        //
        chef.execute( () -> {
            System.out.println("hello from long lambda body");
            return "hello from long lambda";
        } );
        chef.execute(() ->  "hello from short lambda");

        //
        chef.execute(Runner::staticMethodReferenceExample);

        var runner = new Runner();
        chef.execute(runner::methodReferenceExample);
    }

    private static String staticMethodReferenceExample() {
        System.out.println("I was called");
        return "hello from static method reference";
    }

    private int xxx;
    private String methodReferenceExample() {
        return "hello from method reference" + xxx;
    }
}
