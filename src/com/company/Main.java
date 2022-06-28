package com.company;


import java.util.Scanner;


public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Enter N: ");
        int n = sc.nextInt();

        System.out.println("Enter M: ");
        int m = sc.nextInt();

        System.out.println("Enter i:");
        int i = sc.nextInt();

        System.out.println("Enter j:");
        int j = sc.nextInt();

        System.out.println("N value in binary is:       " + Integer.toBinaryString(n));
        System.out.println("M value in binary is:       " + Integer.toBinaryString(m));
        int result = insertion(n, m, i, j);
        System.out.println("Result: " + result);
        System.out.println("Result value in binary is:  " + Integer.toBinaryString(result));
    }

    /**
     * Insert M into N so that M starts at bit j and ends at bit i. j through i must have enough space to fit all of M.
     * ex) if M = 10011, then there must be at least 5 bit between j and i.
     * <p>
     * EXAMPLE:
     * Input 	N = 10000000000, M = 10011, i =2, j = 6
     * Output: N = 10001001100
     *
     * @return N value after inserting the M into it.
     */
    public static int insertion(int n, int m, int i, int j) {

        for (int x = i; x <= j; x++) {
            if (getBitAt(m, x-i)) {
                n = setBitAt(n, x);
            } else {
                n = clearBitAt(n, x);
            }
        }

        return n;
    }

    /**
     * Return the bit value (1 or 0) at position i.
     *
     * @param i position from 0 to n.
     */
    public static boolean getBitAt(int number, int i) {
        return ((number & (1 << i)) != 0);
    }

    /**
     * Set the bit at position i to 1.
     *
     * @param i position from 0 to n.
     */
    public static int setBitAt(int number, int i) {
        return number | (1 << i);
    }

    /**
     * Set the bit at position i to 0.
     *
     * @param i position from 0 to n.
     */
    public static int clearBitAt(int number, int i) {
        return number & (~(1 << i));
    }
}