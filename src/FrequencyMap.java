import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;


// array of linkedlist

// 2 -> 5 7 10 15


// 2 ->  [5,1]     [7,2]     [10,3]    [15,5]

// hm.get(5)
//hash function
// index


// 5 6 8 5

//-> x%2100 []
// 1 -> 5
// 0 -> 6 8
// bucket + 50

// million of data , hash function - minimal colluon
// huge data  []

// 5

// millions  []
// specific bucket  -> 5

// doesnt store duplicate
// hashset [5 6 4 7 5 4 4]
// Frequency map [for each number , store its count]
// hashmap -> [key value] -> pair
// [5 -> 2]
// [6 -> 1]
// B// 4->3
// 7 -> 1

// 4

// Hashmap  pair  - [key value paros]

// Hashset  data - .[set of data]


// 5 5

// 5 -> 2

public class FrequencyMap {
    HashSet<Integer> set = new HashSet<>();

    // set 5
    static HashMap<Integer, Integer> hm = new HashMap<>(); // declare in java

    public static int findCount(int x){
        return hm.get(x);
    }

    static void main() { // 10 [10]
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
            if(hm.containsKey(arr[i])){
                hm.put(arr[i] , hm.get(arr[i]) + 1);
            }
            else {
                hm.put(arr[i], 1);
            }
        }


        // million
        // 5 9 8
        System.out.println(findCount(7)); //  O(1)
        System.out.println(findCount(3));

    }
}

// hashset -> searching faster
// hasmap -> searching faster + value against a key
//[ 5 ]

// 100

// 100 -> 63

// Prefix Sum
// 2 4 1 3 2
// 2 6 7 10 12      -> prefix sum array


//

// 3    2      1         7    10
// a     b      c       d     e
//        5      6              23

// sum [x , y ]
// sum [a, b]


// google
// 1y
// 5 9 10

// 1 jan - 31 dec

// 1 jan 2025 31 dec 2026
