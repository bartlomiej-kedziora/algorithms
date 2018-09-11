# Algorithms

Repository includes algotithms

## Getting Started

First of all you should clone and compile project

```Bash
$ git clone https://github.com/bartlomiej-kedziora/algorithms.git
$ cd algorithms
$ ./gradlew build
```

After build successful just run test for chosen module, i.e binary-search 

```Bash
$ ./gradlew --info :binary-search:test --tests "com.algorithms.search.BinarySearchTestSuite"
```

## Table of contents

1. [Binary search](#binary-search)

## Binary search

- search algorithm that finds the position of a target value within a sorted array (more: https://en.wikipedia.org/wiki/Binary_search_algorithm)
- runs in logarithmic time in the worst case, making O(log n) comparisons, where n is the number of elements in the array

