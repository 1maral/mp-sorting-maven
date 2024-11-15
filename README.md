# mp-sorting-maven

An exploration of sorting in Java.

Authors

* Maral Bat-Erdene
* Samuel A. Rebelsky (starter code)

Acknowledgements

* 

This code may be found at <https://github.com/1maral/mp-sorting-maven>. The original code may be found at <https://github.com/Grinnell-CSC207/mp-sorting-maven>.

Description of custom sorting algorithm
---------------------------------------
The `MaralBatErdeneSort` algorithm is a customized Quicksort that optimizes efficiency by using a median-of-three pivot selection, choosing the median of three randomly picked indices to prevent unbalanced partitions. The algorithm employs Dutch National Flag partitioning, which divides the array into three sections—values less than, equal to, and greater than the pivot—enabling efficient handling of duplicates. For arrays smaller than 15 elements, the algorithm switches to Insertion Sort, providing a faster sorting approach for small subarrays and enhancing overall performance.

Notes on using Copilot (or other AI)
------------------------------------

_This section is optional_
