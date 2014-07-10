PROJECT TITLE
=============

Coach A Java Programming Aptitude Test

DATE
----

2014-10-07

AUTHOR
------

Peter L. McArthur

REQUIREMENTS
============

> Given a non-empty array of integers please return Nth biggest integer in that array.
> 
> please implement the following interface:
> 
>     public interface IntegerSelection {
>         int select(int[] array, int rank); 
>         //rank = 0 is biggest integer, 1 is second biggest and so on.
>     }
> 
> Example:
> input:
>     SELECT RANK=2 FROM [1, 4, 2, 3, 5, 8, 6, 9, 8, 0]
> output:
>     8

IMPLEMENTATION NOTES
====================

Error handling
--------------

The specification clearly states that the list will be non-empty,
so I have made no attempt to handle empty lists.

Furthermore, the type signature for the interface suggests that
my code should not raise exceptions. I have therefore decided to
handle out-of-range values of *rank* by normalising them to the
maximum or minimum acceptable values.  For instance, if rank is
-10, my code normalizes it to 0.  If rank is 1000, and the list
is of length 10, my code normalizes rank to 9.

Algorithm
---------

Time complexity: *n* log *n*

Space complexity: *n*

Where *n* is the size of the array.

I have chosen "the simplest solution that can work".  My code:

 - copies the array
 - sorts the copied array, from lowest to highest
 - returns the element at index *array.length - rank - 1*

This is *not* the most efficient algorithm, and it would
not be suitable for performance-sensitive code.