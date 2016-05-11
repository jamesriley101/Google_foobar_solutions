#Optimal Schedule

A non-conventional solution to the classic scheduling problem.
Input is a matrix of 1x2 arrays containing the start and end 
times of all possible appointments. The maximum number of 
non-overlapping appointments is returned. 

The conventional solution is simply to stack appointments by 
end time, such that the earliest-ending appointment is "booked" 
first, then the next earliest-ending appointment that does not
conflict with the first, and so forth.

This solution creates an n x n matrix representing all of the 
conflicts between all appointments, then creates the schedule 
by selecting the appoinments having the fewest conflicts with 
the remaining unbooked appointments, thus always optimizing 
the number of possible that can still be booked.

This algorithm, though far less scalable due to the polynomial
runtimes needed to create and update the conflict matrix, can 
easily be adapted to include other criteria, such as appointment 
weights, which would make the conventional solution to this 
problem unuseful. 

	Example:

	Input:
	int[][] meetings = {{1, 4}, {4, 7}, {5, 10}, {3, 5}, {8, 9}};
    
    Output:
    3
