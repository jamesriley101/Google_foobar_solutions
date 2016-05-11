package com.jamesriley101;

//Integers forming at least one valid date are passed to return_result
//which returns "Ambiguous" if more than one date can be formed, otherwise
//the only valid date that can be formed.

//In this implementation arguments are entered directly into return_result
//and the result is printed to the console.

public class Main {
    public static void main(String[] args) {
        System.out.println(return_result(31, 99, 11));  //Enter integers.
        return;
    }

    public static String return_result(int x, int y, int z) {

        //test for multiple month digits:
        if (count_month_digits(x, y, z) > 1) {
            return "Ambiguous";
        }

        //test for multiple-day digits by month-type (day limit):
        //february
        int month_28[] = {2};
        if (test_month_type(month_28, x, y, z, 28)) {
            return "Ambiguous";
        }

        //30 day months:
        int month_30[] = {4, 6, 9, 11};
        if (test_month_type(month_30, x, y, z, 30)) {
            return "Ambiguous";
        }

        //31 day months:
        int month_31[] = {1, 3, 5, 7, 8, 10, 12};
        if (test_month_type(month_31, x, y, z, 31)) {
            return "Ambiguous";
        }

        //if no ambiguity found, identify the actual date represented:
        if (x <= 12) {
            if (y <= z) {
                return (return_date(x, y, z));
            }
            else {
                return (return_date(x, z, y));
            }
        }
        if (y <= 12) {
            if (x <= z){
                return (return_date(y, x, z));
            }
            else{
                return (return_date(y, z, x));
            }
        }
        else {
            if (x <= y) {
                return (return_date(z, x, y));
            }
            else{
                return (return_date(z, y, x));
            }
        }
    }

    //sub methods

    public static int count_month_digits(int x, int y, int z) {
        int month_elig = 0;
        if (x <= 12) {
            month_elig++;
        }
        if (y <= 12 && y != x) {
            month_elig++;
        }
        if (z <= 12 && z != x && z != y) {
            month_elig++;
        }
        return month_elig;
    }

    public static boolean is_month_type(int months[], int var) {
        for (int i = 0; i < months.length; i++) {
            if (months[i] == var) {
                return true;
            }
        }
        return false;
    }

    public static boolean test_days(int day_max, int a, int b) {
        if (a <= day_max && a > 0 && b <= day_max && b > 0 && a != b) {
            return true;
        }
        return false;
    }

    public static boolean test_month_type(int month_type[], int j, int k, int l, int day_lim) {
        if (is_month_type(month_type, j)) {
            if (test_days(day_lim, k, l)) {
                return true;
            }
        }
        if (is_month_type(month_type, k)) {
            if (test_days(day_lim, j, l)) {
                return true;
            }
        }
        if (is_month_type(month_type, l)) {
            if (test_days(day_lim, k, j)) {
                return true;
            }
        }
        return false;
    }

    public static String return_date(int month, int day, int year) {
        String out_string = String.format("%02d", month) + "/" + String.format("%02d", day) + "/" + String.format("%02d", year);
        return out_string;
    }


}