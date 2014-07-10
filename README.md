Coach A Java Programming Aptitude Test
======================================

Peter L. McArthur

2014-10-07

Requirements
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

Implementation Notes
====================

Error handling
--------------

The specification clearly states that the list will be non-empty,
so I have made no attempt to handle empty lists.

The type signature for the interface suggests that my code should
not raise exceptions. I have therefore decided to handle
out-of-range values by raising or lowering them to the nearest
acceptable value.

E.g. if *rank* is -10, it is treated as 0.

If *rank* is 10 and *array* is {1, 3, 2}, *rank* is treated as 2
(*array.length - 1*)

Algorithm
---------

 * time complexity: O(*n* log *n*)
 * space complexity: O(*n*)

where *n* is the size of the array.

This is "the simplest solution that can possibly work".  My code:

 - copies the array (so that the original array will not be affected)
 - sorts the copied array, from lowest to highest
 - returns the element at index *array.length - rank - 1*

This is *not* the most efficient algorithm, and it would
not be suitable for performance-sensitive code.