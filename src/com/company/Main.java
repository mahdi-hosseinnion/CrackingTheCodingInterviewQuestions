package com.company;


import com.company.callcenter.Call;
import com.company.callcenter.CallCenter;

import java.util.Arrays;
import java.util.Scanner;


public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        System.out.println("There is #" + steps(n, memo) + " ways.");
    }

    public static int steps(int n, int[] memo) {
        if (n < 0) return 0;
        if (n == 0) return 1;
        if (n == 1) return 1;
        if (memo[n] > -1) {
            return memo[n];
        }
        memo[n] = steps(n - 1, memo) + steps(n - 2, memo) + steps(n - 3, memo);
        return memo[n];
    }
}