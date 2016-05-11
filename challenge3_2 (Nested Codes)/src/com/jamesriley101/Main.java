package com.jamesriley101;
import java.util.ArrayList;


public class Main {

    public static void main(String[] args) {

        String message = "1231xx1112323121233121233xx1123";
        String word = "123";

        long startTime = System.currentTimeMillis();
        System.out.println(solve_sub(message, word));
        long endTime = System.currentTimeMillis();

        System.out.println("Running time: " + (endTime - startTime) / 1000.0);
    }

    public static String solve_sub(String chunk, String word){
        ArrayList occurances = count_occurances(chunk, word);
        if (occurances.size() == 0){
            return chunk;
        }
        ArrayList possible_results = new ArrayList();
        String temp_chunk = "";
        for (int j = 0; j < occurances.size(); j++){
            temp_chunk = chunk.substring(0, (int)occurances.get(j)) + chunk.substring((int)occurances.get(j)  + word.length(), chunk.length());
            possible_results.add(solve_sub(temp_chunk, word));
        }
        String temp_solution = "";
        for (int i = 0; i < count_occurances(chunk, word).size(); i++){
            String compared_solution = (String)(possible_results.get(i));
            if (temp_solution == "" || (compare_strings(temp_solution, compared_solution))){
                temp_solution = compared_solution;
            }
        }
        return temp_solution;
    }

    public static ArrayList count_occurances(String chunk, String word){
        ArrayList occurances = new ArrayList();
        for (int i = 0; i < chunk.length() - (word.length() - 1); i++){
            if (check_forward(chunk, word, i)){
                occurances.add(i);
            }
        }
        return occurances;
    }

    public static boolean check_forward(String chunk, String word, int chunk_index){
        for (int j = 0; j < word.length(); j ++){
            if (chunk.charAt(chunk_index + j) != word.charAt(j)){
                return false;
            }
        }
        return true;
    }

    public static boolean compare_strings(String s1, String s2){
        if (s1.length() < s2.length()){
            return false;
        }
        if (s2.length() < s1.length()){
            return true;
        }
        if (s1.compareTo(s2) < 0){
            return false;
        }
        return true;
    }
}
