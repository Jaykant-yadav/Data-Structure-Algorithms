# What is Sorting?
#### -> Arrange in an Order ascending / descending order
![App Screenshot](https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTWQnX1Pjs2ZvoKcyd0DYx7foMz05jax_3paA&s)

### Basic Sorting Algorithms <hr>
- [<b>Bubble Sort O(n2)]()
-> Largest elements come to the end of array by swapping with adjacent elements . [video Link](https://youtu.be/bBQkErahU9c?si=04TTGEh5pF22H-cT)
- [<b>Selection Sort O(n2)]()
-> Put the smallest (from unsorted), put it at the beginning . [video Link](https://youtu.be/B-nqY6IYqVw?si=VyvdPrXUNU2ML2kY)
- [Insertion Sort O(n2)]() 
-> Pick an element (from unsorted part) & place in the right pos in sorted part . [video Link](https://www.youtube.com/watch?v=wWhAhp6PIuQ)
- [Counting Sort - Advanced O(n + range)]()
<hr>

### Reverse Order Sorting Concept
- `reverseOrder()` -> Reverse Order function internally used comparator .

```Text
comparator -> typical comparator, you compare two elements and return:

-> Negative value if the first element is "less than" the second element. a < b -> -ve
-> Zero if the elements are "equal." a == b -> 0
-> Positive value if the first element is "greater than" the second element. a > b -> +ve

For reverse order, the comparator simply reverses the usual comparison logic, so that:
-> The element that would normally be considered "greater" comes first.
-> The element that would normally be considered "lesser" comes last.
```
 

