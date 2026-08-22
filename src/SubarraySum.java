// [5 4 6 7 3]
//


// 1 2 3 4
// 1 3 6 10
//     i

// 6
// k =7

// 1 4 -2 3
// 2  1
// k = 5

//      1 5  6  -8  3
//  0   1 6  12  4  7

// 1-0
// 6 - 1
// 12 2
// 4 3
// 7 4

//    1 6  12  -2 1
 //           7

// expand window  - > 3

// hasmap key-> value
// 5 -> 1
// 4 -> 1
// 7 -> 1


/*             0 1   2 3   4  5  6
 arr       ->  5 7   3 2   9  6  7  -> n
 prefixsum ->0 5 12 15 17  26 32 39

 // 1 3
 // 0,2
 // 5

 // x
 // 5

 // hashmap
 // [5 , 0]
 // 12 1
 15 2
 17 3
 26 4
 32 5
 39 6


 // Prefix sum ->


// k = 12
// subarray indexs - satrting and ending
 // -> return any one


// subarray  -> sum = k
*/

//hm
// 0 -> -1


//     4    12
// find the subarray having sum = k

import java.util.HashMap;
import java.util.Scanner;
public class SubarraySum {
    //     0 1 2 3
    //     1 3 5 6
    //  0  1 4 9 15


    //  k = 9

    // 0 -1
    // 1 0
    // 4 1
    // 9 2
    // 15 3

    //arr ->       1 4 3 7 6 3 9 7
    //prefixs->  0 1
    //          -1

    //           4 5 2 3
    //        0  4 9 11 14

    // hm = [0 , -1 ]  [ ]

    // every number +++ =

    // 1 2 3 4 5 6
    // 1 3 6 10....

    //       x            y
    //     2 5 8 10 ....  20 30

    // k = 15

    public static void subArrraySumEqualK(int arr[] , int k){
        HashMap<Integer,Integer> hm = new HashMap<>();

        int prefixSum = 0;
        hm.put(0,-1);
        for(int i=0;i<arr.length;i++){
            prefixSum = prefixSum + arr[i];

            if (hm.containsKey(prefixSum - k)) {
                int start = hm.get(prefixSum - k) + 1; // 0
                int end = i; // 2
                System.out.println("S=" + start);
                System.out.println("E=" + end);
                return;
            }
            hm.put(prefixSum, i);
        }
        System.out.println("No subarray found");
    }

    // O(n)
    // O(n)
    // 8
    // 1 4 3 7 6 3 9 7

    // 16

    static void main() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }

        int k = sc.nextInt();

        subArrraySumEqualK(arr,k);
    }
}

// k is user input

///       t-x        x
// t
// i + next+nect+net+next
//       i +net

// hm.get(sum-k)
