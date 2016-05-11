#Unique Date

The method return_result is passed three integers that can be
combined to form at least one valid date (ex. 12, 3, 95 can form 
the date 12/3/95, but 88, 89, 90 cannot). The method returns the
string "Ambiguous." if more than one valid date can be formed 
(ex. 12/3/95 can also form 3/12/95). If only one valid date can be
formed, that date is returned (Month/Day/Year) as a string.
	
	Examples:

	return_result(31, 99, 11);
	11/31/99

	return_result(12, 9, 26);
	Ambiguous

In this implementation the integers are entered as arguments into 
return_result in the Main class method within a print statement.