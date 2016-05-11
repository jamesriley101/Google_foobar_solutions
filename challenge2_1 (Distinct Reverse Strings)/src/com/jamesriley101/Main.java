package com.jamesriley101;

//In this implentation, an array of strings is entered into the 
//assigment statement for test_codes in the Main class method. 
//The number of distinct and distinct-reversed string is printed
//to the console.

public class Main {

    public static void main(String[] args) {
        String[] test_codes = {"hi", "ih", "123", "321"};
        System.out.println(count_distinct_codes(test_codes));
    }

    public static int count_distinct_codes(String[] codes){
        int distinct_codes = 0;
        boolean[] indistinct_codes = new boolean[codes.length];
        for (int i = 0; i < indistinct_codes.length; i++){
            if (indistinct_codes[i] == true){
                continue;
            }
            compare_remaining_codes(codes, i, indistinct_codes);
            distinct_codes++;
        }
        return distinct_codes;
    }

    public static void compare_remaining_codes(String[] codes, int i, boolean[] indistinct_codes){
        for (int j = i + 1; j < codes.length; j++){
            if (compare_codes(codes[i], codes[j])){
                indistinct_codes[j] = true;
            }
        }
    }

    public static boolean compare_codes(String c1, String c2){
        if (c1.length() != c2.length()){
            return false;
        }
        boolean forward_check = true;
        boolean backward_check = true;
        for (int i = 0; i < c1.length(); i++){
                if (c1.charAt(i) != c2.charAt(i)) {
                    forward_check = false;
                    break;
                }
            if (!forward_check) {
                break;
            }
        }
        for (int i = 0; i < c1.length(); i++){
                if (c1.charAt(i) != c2.charAt(c2.length() - (i + 1))){
                    backward_check = false;
                    break;
                }
            if (!backward_check) {
                break;
            }
        }
        if (!forward_check && !backward_check){
            return false;
        }
        return true;
    }
}
