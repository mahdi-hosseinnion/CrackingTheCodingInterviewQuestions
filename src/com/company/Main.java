package com.company;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        IntegerStack stack = new IntegerStack();

        loop:
        while (true) {
            System.out.println("What you wanna do?");
            String order = sc.nextLine();
            switch (order) {
                case "push":
                    System.out.println("What do your want to push into stack?");
                    Integer data = sc.nextInt();
                    sc.nextLine();  // Consume newline left-over
                    stack.push(data);
                    break;
                case "pop":
                    System.out.println(stack.pop());
                    break;
                case "peek":
                    System.out.println(stack.peek());
                    break;
                case "isEmpty":
                    System.out.println(stack.isEmpty());
                    break;
                case "print":
                    stack.printAll();
                    break;
                case "min":
                    System.out.println(stack.getMin());
                    break;
                case "stop":
                    break loop;
                default:
                    System.out.println("You did nothing!");
                    break;
            }
        }
    }

}
