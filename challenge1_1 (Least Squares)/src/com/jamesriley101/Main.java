package com.jamesriley101;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int target = get_target_from_user();
        int least_squares = find_least_squares(target);
        System.out.println(" = " + target + "\nLeast Squares: " + least_squares);
        return;
    }

    public static int find_least_squares(int target_sum){
        int n = 1;
        while (!test_nlets(target_sum, 0, n++)){}
        return n - 1;
    }

    public static boolean test_nlets(int target_sum, int sum, int n){
        if (n == 0) {
            return false;
        }
        int j = 0;
        while (j * j <= target_sum){
            int temp_sum = sum + j * j;
            if (temp_sum == target_sum){
                System.out.print(j * j);
                return true;
            }
            if (test_nlets(target_sum, temp_sum, n - 1)){
                System.out.print(" + " + j * j );
                return true;
            }
            j++;
        }
        return false;
    }
    public static int get_target_from_user(){
        Scanner s = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int target = Integer.parseInt(s.nextLine());
        return target;
    }
}
