package com.jamesriley101;

//Given a bored of length n, we will find the qty of sequences ending on the nth position
//using t rolls by recursively finding and summing the qty of sequences ending on the nth
//position with (t - 1, t - 2, t - 3 ... min) rolls.
//
//The qty of ways to reach a given non-border position n in t rolls is the sum of the qty
//of ways to reach positions n - 1, n, and n + 1 in t - 1 rolls, or: 
//
//          C(n, t) = C(n-1, t-1) + C(n, t-1) + C(n+1, t-1)
//
//In this implementation arbitrary values are assigned to n and t, and the result is printed
//to the console.

public class Main {

    public static void main(String[] args) {

        int n = 5;                                      //Example board length
        int t = 20;                                     //Example number of rolls
        int[] result = {0};                             //Initialize the result
        sum_all_previous(t, n, result);                 //Solve using methods below
        System.out.println(result[0]);                  //Print the result to the console
    }

    public static int[] sum_all_previous(int t, int n, int sum[]){
        if (t == 2){                                    //base case: previous roll total = 1
            int[] prev_t = new int[n];                  //initiate base
            prev_t[0] = 1;                              //1 sequence of t = 1 roll ending on position 0
            prev_t[1] = 1;                              //1 sequence of t = 1 roll ending on position 1
            sum[0] += prev_t[n - 1];
            int[] current_t = next_t(prev_t, t, n, sum); //given base case, find sequences of two rolls ending on all n
            return current_t;                            //pass possible rolls to previous recursive step
        }
        int[] prev_t = sum_all_previous(t - 1, n, sum); //back down to previous roll count until base case
        return next_t(prev_t, t, n,sum);                //pass qty sequence ending at each n to previous recursive step
    }

    public static int[] next_t(int[] prev_t, int t, int n, int sum[]){
        int max_pos = t < n - 1 ? t : n - 1;                    //farthest possible position is either t or final position index n - 1
        boolean reaches_n = max_pos == n - 1 ? true : false;
        int[] current_t = new int[n];                           //current_t to contain qty of ways to reach each position n wth t rolls

        current_t[0] = (prev_t[0] + prev_t[1]) % 123454321;     //first position can be reached in t by arriving there in t-1 (roll s),
                                                                //or by arriving at next position in t - 1 (roll r)
        for (int i = 1; i <= max_pos; i++){
            if (i == max_pos){
                current_t[i] = prev_t[i - 1] % 123454321;       //qty of sequences ending on final n or ending on new farthest n is
                                                                //equal to qty sequences of t - 1 rolls ending on n - 1 (then roll r)
            } else{
                current_t[i] = (prev_t[i - 1] + prev_t[i] + prev_t[i + 1]) % 123454321; //apply rule for non-border n
            }
        }
        if(reaches_n) {                                         //if final position was reached with this qty of rolls
            sum[0] += current_t[n - 1];                         //add the qty of sequences (held in last element of current_t) to total
            sum[0] %= 123454321;                                //keep running result small enough for integer
            current_t[n - 1] = 0;                               //clear last element of current for next calculation (allows for one
        }                                                       //function for t < n - 1 and t > n - 1 cases).
        return current_t;
    }
}
