// [3, 2, 1, 5, 6, 4]
//
/// find the 3nd largest element in this array
///
/// // brute force - sort and get 2nd last inde
///
/// // top 2  -> 5 6
/// // 2nd largest element -> 5
///
/// // millhions - top 10 -> HEAP best way


// nums = [3,2,1,5,6,4]
//
//k = 2
// top 2 elements ->

    // heap of size k
    // top 2 element
    // min heap =>
// r g s ge g w g  g g g  hh  h

    // 100
    //   5
    //  6

    // answer = 5


    // array - sort it ??
    // add all heap =

    //
// sorted


// top distint -
// duplicated

// 1 1 2 3 4 4 5 6 7 7 8 9

// 7 7 8 9
// top distint k = 6 7 8 9

//     5
//  7     8
//9

//

//

// hasmap
// hashset [ 1 2 5 7 8 9 ]



//   class Driver{
//   name
//   age
//   star rating -
//   }


// prorityqueue <Driver>  ==          comparator rating

//            Driver1 - 5 largest ratiung driuver
//    driver2           driver3
// d4        d5

// min heap-> top k drivers based on rating


// thosands of drivers in my system

// top 5 drivers in the city


    // understand all these sorting algorithms =>
    // bubble sort, insertion sort, selection sort
    // merge sort, quick sort,heap sort - nlogn
// 100 200 -> 5 7


    // 1

    //   2
///    3


// pq.add

// pq is full
// rroot and add


// compare with root

//  smaller -> ingore'
// larger - poll push


    //hint  ->  2 heaps technique ->
//given continuous stream of elements
// median of array  ->

import java.util.PriorityQueue;

//// nums = [3,2,1,5,6,4]
    ////
    ////k = 2
    ///
    ///  pq -> 5
    /// //   6
    ///


    // a b c d e f g
//  k = 2

// a b c


public class TopK {

    int findKthLargestElement(int[] nums, int k){

        // Min heap
        PriorityQueue<Integer> pq = new PriorityQueue<>(k);

        // n logk
        for(int num:nums){
            pq.add(num);

            if(pq.size()>k){
                pq.poll();
            }
        }
        return pq.peek();
    }

        static void main() {

        }


}
