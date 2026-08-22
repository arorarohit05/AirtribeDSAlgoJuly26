// +ve & -ve  numbers
// subarray sum = maximum of size k
// each subaaray

// n = 7
// k = 3

// i        i
// 2 9 6 -7 2 -3 5 ->

// 0 1    3

import java.util.Scanner;

public class MaxSubArraySumSizeK {

    public static int maxSubaaraySumSizeK(int arr[] , int k){
        if(k>arr.length)
        {
            System.out.println("Wroong input");
            return -1;
        }

        int maxSum = Integer.MIN_VALUE;

        for(int i=0;i<=arr.length-k;i++){ // starting index of window
            int sumCurrentWindow = 0 ;
            for(int j=i;j<i+k;j++){ // iterating k elements
                sumCurrentWindow = sumCurrentWindow + arr[j];
            }
            if(maxSum<sumCurrentWindow){
                maxSum = sumCurrentWindow;
            }
        }

        return maxSum;
    }

    // 2 9 6 -7 2 -3 5

    // windowSum = 17

    public static int maxSubaaraySumSizeKUsingSlidingWindow(int arr[] , int k) {
        int windowSum = 0;

        for(int i=0;i<k;i++){
            windowSum = windowSum + arr[i];
        }

        int maxSum = windowSum;

        for(int i=k;i<arr.length;i++)
        {
            windowSum = windowSum + arr[i] - arr[i-k];
            maxSum = Math.max(maxSum,windowSum);
        }

        return maxSum;


    }

    //                25   29 30
    //               [   x    ] 2
    //               5 [         ]

    // x + 2 - 5


    // 0 1 2      3 4  5 6
    // 2 9 6     -7 2 -3 5

    // O(n*k)

    static void main() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 10

        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }

        int k = sc.nextInt();

        System.out.println(maxSubaaraySumSizeK(arr ,k));

        System.out.println(maxSubaaraySumSizeKUsingSlidingWindow(arr ,k));
    }
}
