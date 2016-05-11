package com.jamesriley101;

public class Main {

    public static void main(String[] args) {
	    int[] digest = {0, 129, 5, 141, 25, 137, 61, 149, 113, 145, 53, 157, 233, 185, 109, 165};
        long startTime = System.currentTimeMillis();
        print_array(solve(digest));
        long endTime = System.currentTimeMillis();
        System.out.println("Running time: " + (endTime - startTime) / 1000.0);

        long startTime2 = System.currentTimeMillis();
        print_array(solve2(digest));
        long endTime2 = System.currentTimeMillis();
        System.out.println("Running time: " + (endTime2 - startTime2) / 1000.0);
    }


    public static int[] solve2(int[] digest){
        int[] message = new int[digest.length];
        message[0] = solve_elem2(digest, 0, 0);
        for (int i = 1; i < message.length; i++){
            message[i] = solve_elem2(digest, message[i -1], i);
        }
        return message;
    }

    public static int solve_elem2(int[] digest, int previous, int i){
        for (int j = 0; j < 129; j++){
            int test_solution = 256 * j;
            test_solution = test_solution + digest[i];
            test_solution = (test_solution ^ previous);
            if (test_solution % 129 == 0){
                return test_solution / 129;
            }
        }
        return -1;
    }

    public static int[] solve(int[] digest){
        int[] message = new int[digest.length];
        message[0] = 0;
        for (int i = 1; i < message.length; i++){
            message[i] = solve_elem(digest, message, i);
        }
        return message;
    }

    public static int solve_elem(int[] digest, int[] message, int i){
        for (int j = 0; j < 256; j++){
            int test_solution = 129 * j;
            test_solution = test_solution ^ message[i - 1];
            test_solution = test_solution % 256;
            if (test_solution == digest[i]){
                return j;
            }
        }
        return -1;
    }

    public static void print_array(int[] array){
        for (int j = 0; j < array.length; j++){
            System.out.print(array[j] + " ");
        }
        System.out.print(("\n"));
    }
}
