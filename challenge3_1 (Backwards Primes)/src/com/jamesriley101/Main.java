package com.jamesriley101;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int[] range = get_range_from_user();
        BackWardsPrime bwp = new BackWardsPrime();
        System.out.println(bwp.backwardsPrime(range[0], range[1]));
    }

    public static int[] get_range_from_user(){
        Scanner s = new Scanner(System.in);
        int[] range = new int[2];
        System.out.print("Enter a minimum: ");
        range[0] = Integer.parseInt(s.nextLine());
        System.out.print("Enter a maximum: ");
        range[1] = Integer.parseInt(s.nextLine());
        return range;
    }
}

class BackWardsPrime {
    public static String backwardsPrime(long start, long end) {
        String output_string = "";
        for (int i = (int) start; i <= end; i++) {
            String rev_i = "";
            int num = i;
            while (num > 0) {
                rev_i += num % 10;
                num = (int) Math.floor(num / 10);
            }
            if (isPrime(i) && isPrime(Integer.parseInt(rev_i)) && i != Integer.parseInt(rev_i)) {
                output_string += String.valueOf(i) + " ";
            }
        }

        return ((output_string == "") ? output_string : output_string.substring(0, output_string.length() - 1));
    }

    public static boolean isPrime(int num) {
        for (int j = 2; j <= Math.sqrt(num); j++) {
            if (num % j == 0) {
                return false;
            }
        }
        return true;
    }
}
