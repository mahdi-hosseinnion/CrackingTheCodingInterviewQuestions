package com.company;


import com.company.callcenter.Call;
import com.company.callcenter.CallCenter;

import java.util.Scanner;


public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        System.out.println("");
        System.out.println("There is #" + steps(n) + " ways.");
    }

    public static int steps(int n) {
        if (n < 0) return 0;
        if (n == 0) return 1;
        if (n == 1) return 1;

        int oneSum = steps(n - 1);
        int twoSum = steps(n - 2);
        int treeSum = steps(n - 3);

        return oneSum + twoSum + treeSum;
    }
}