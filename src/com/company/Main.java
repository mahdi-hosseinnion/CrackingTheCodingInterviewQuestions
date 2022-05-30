package com.company;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();

        loop:
        while (true) {
            System.out.println("What you wanna do?");
            String order = sc.nextLine();
            switch (order) {
                case "push":
                    System.out.println("What do your want to push into stack?");
                    String data = sc.nextLine();
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
                case "stop":
                    break loop;
                default:
                    System.out.println("You did nothing!");
                    break ;
            }
        }
    }

}
