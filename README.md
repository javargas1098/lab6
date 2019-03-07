# lab 5
## Part 	l
In this part i had to modify  the class `Cinemafuntions` in order to separte the date and the hour for in the get method when call a cine usign the date didn't have inconsistencies but the required requests weren't changed.
when probe the URL the program responds properly to the request made.
## Part 	ll
The `Post` `Put` funtions requests are successfully received and the answer is the expected

 ## Part 	ll
 The race conditions that i found is when the server recive many requests about get pos put etc and they need to acces at the same time  to the `cinemafuntions` so the simple way to solve this is synchronized the arraylist `funtions` in cinema call and i use atomic values in the   to guarantee that all requests are made properly
