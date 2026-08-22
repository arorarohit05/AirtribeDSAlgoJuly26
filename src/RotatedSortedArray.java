//9  15  20 45  3 5 6 7

import java.util.Scanner;

// l  r
//  0 1 2 3 4 5
// [4,5,0,1,2,3]


// target = 0
// mid  = 2

// arr[mid] = 1

// a b c d e f g h i j k
//          m

//1 2 4 5 6 7

// 0
// lr

// search for = 0

// rotated sorted array - if i take middle - 1 half will always be sorted

public class RotatedSortedArray {

    public static int binarySearchRSA(int arr[],int k) {
        int left = 0;
        int right = arr.length - 1;

        while(left<=right){
            int mid =left + (right-left)/2;

            if(arr[mid] == k){
                return mid;
            }

            // left half sorted
            if(arr[left] <= arr[mid]){ // my left half is sorted
                 if(k>= arr[left] && k<arr[mid]){
                     right = mid-1;
                 }
                 else{
                    left = mid+1;
                 }
            }

            // right half siorted
            else{
                if(k<=arr[right] && k>arr[mid]){
                    left = mid+1;
                }
                else{
                    right = mid-1;
                }
            }


        }

        return -1;
    }

    static void main() {
        Scanner sc = new Scanner(System.in); // input from user
        int n = sc.nextInt(); //100

        int[] arr;
        arr = new int[n]; // 100

        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }

        int data = sc.nextInt();// search this data

        System.out.println("Now apply Binary Search On given rotated sorted array");
        System.out.println(binarySearchRSA(arr,data));
    }

}
