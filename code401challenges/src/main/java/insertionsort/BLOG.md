# BLOG Notes: Insertion Sort

Brief description of what this algorithm is, does, and why we care.
- In-place comparison-based sorting algorithm.

Is it more efficient than others? How does it attack the problem differently?
- This algorithm is not suitable for large data sets as its average and worst case time complexity are of Ο(n^2), where n is the number of items.

## Learning Objectives
- To be able to explain and implement insertion sort.

## Diagram
![Insertion Sort diagram](../../../../assets/insertionsort.png)

## Algorithm
* First element in the array is already sorted
* Pick the next element
* Compare with all elements in the sorted sub-list
* Shift all the elements in the sorted sub-list that is greater than the 
         value to be sorted to the right
* Insert the value
* Repeat until list is sorted

## Pseudocode
```
InsertionSort(int[] arr)
  
    FOR i = 1 to arr.length
    
      int j <-- i - 1
      int temp <-- arr[i]
      
      WHILE j >= 0 AND temp < arr[j]
        arr[j + 1] <-- arr[j]
        j <-- j - 1
        
      arr[j + 1] <-- temp
```

## Readings and References

Watch
- [YouTube - Insertion Sort](https://www.youtube.com/watch?v=JU767SDMDvA)

Read
- [Tutorial Points - Insertion Sort](https://www.tutorialspoint.com/data_structures_algorithms/insertion_sort_algorithm.htm)