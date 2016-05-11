package com.jamesriley101;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int[][] meetings = {{1, 4}, {4, 7}, {5, 10}, {3, 5}};

        System.out.println(book_meetings(meetings));
    }

    public static int book_meetings(int[][] meetings){
        int[][] conflict_matrix = create_conflict_matrix(meetings);
        int[][] conflict_rank_table = create_conflict_rank_table(meetings);
        int[] booked_meetings = new int[meetings.length];
        for (int i = 0; i < booked_meetings.length; i++){
            booked_meetings[i] = -1;
        }
        int booked = 0;
        for (int i = 0; i < conflict_rank_table.length; i++){
            if (check_schedule(conflict_rank_table[i][0], booked_meetings, conflict_matrix, booked)){
                booked++;
                int index = 0;
                int m = 0;
                while (m != -1){
                    m = booked_meetings[index];
                    index++;
                }
                booked_meetings[index - 1] = conflict_rank_table[i][0];
            }
        }
        return booked;
    }

    public static boolean check_schedule(int meeting_index, int[] booked_meetings, int[][] conflict_matrix, int booked){
        int j = 0;
        while (j < booked){
            if (conflict_matrix[meeting_index][booked_meetings[j]] == 1) {
                return false;
            }
            j++;
        }
        return true;
    }

    public static int[][] create_conflict_rank_table(int[][] meetings){
        int[][] conflict_matrix = create_conflict_matrix(meetings);
        int[][] conflict_rank_table = new int[meetings.length][2];
        for (int i = 0; i < meetings.length; i++){
            conflict_rank_table[i][0] = i;
            int conflict_sum = 0;
            int row = 0;
            while(row < conflict_matrix.length){
                conflict_sum += conflict_matrix[row][i];
                row++;
            }
            conflict_rank_table[i][1] = conflict_sum - 1;
        }
        Arrays.sort(conflict_rank_table, new java.util.Comparator<int[]>() {
            @Override
            public int compare(int[] int1, int[] int2)
            {
                Integer number1 = int1[1];
                Integer number2 = int2[1];
                return number1.compareTo(number2);
            }
        });
        return conflict_rank_table;
    }

    public static int[][] create_conflict_matrix(int[][] meetings){

        int[][] conflict_matrix = new int[meetings.length][meetings.length];
        for (int i = 0; i < meetings.length; i++){
            for (int j = 0; j < meetings.length; j++){
                if (test_for_conflict(meetings[i], meetings[j])){
                    conflict_matrix[i][j] = 1;
                }
                else{
                    conflict_matrix[i][j] = 0;
                }
            }
        }
        return conflict_matrix;
    }

    public static boolean test_for_conflict(int[] m1, int[] m2){
        if (m1[1] <= m2[0] || m1[0] >= m2[1]){
            return false;
        }
        return true;
    }

    public static void print_array(int[][] array){
        for (int i = 0; i < array.length; i ++){
            for (int j = 0; j < array[0].length; j++){
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

}
