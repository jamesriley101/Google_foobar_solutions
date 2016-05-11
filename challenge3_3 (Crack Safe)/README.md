#Crack Safe

Decodes a list (digest) of integers within range 0 - 255 that is encrytped with the following
algorithm: 
	
	1. Initial unencrypted value was multiplied by 129,
	2. passed to bitwise XOR with previous (unencrypted) element in list,
	3. passed to modulo 256

or,

	S(n) = ((n * 129) XOR (n - 1)) % 256

The first element in every list is fixed at zero.

This program implements two solutions, and prints the unencrypted combination from 
each solution (which are the same), along with the execution times of the two solution 
methods. The encryptedcombination is assigned in the the Main function and passed to 
both methods. 

	Example:

	Input
	int[] digest = {0, 129, 5, 141, 25, 137, 61, 149, 113, 145, 53, 157, 233, 185, 109, 165}; 

	Output
	0 1 4 9 16 25 36 49 64 81 100 121 144 169 196 225 
	Running time: 0.0
	0 1 4 9 16 25 36 49 64 81 100 121 144 169 196 225 
	Running time: 0.001