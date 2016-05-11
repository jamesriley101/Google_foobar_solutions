#Nested Codes

This program decodes a message that has been encrypted by inserting a 
certain word into the message an arbitrary number of times, including
subsequent insertions nested inside previous insertions arbitrarily. In 
other words, the encypting word to be removed may appear within itself an 
indefinite number of times. 

The method solve_sub is passed the encrypted message and the encrypting
word, and recursively decrypts the message by removing the most recently
added words and passing the reconstructed string to the next recursive call.

In this implementation, the message and the key are entered in the
assignment statements in the main function, and the decrypted message and 
the execution time are printed to the console.

	Examples:

	Input arguments:
	String message = "xx112323xx";
    String word = "123";

    Output:
    xxxx
    Running time: 0.001


	Input arguments:
	String message = "llolollxxlololxxxllolll";
    String word = "lol";

    Output:
    lxxloxxxlll
	Running time: 0.004
