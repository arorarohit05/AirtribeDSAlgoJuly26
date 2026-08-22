import java.util.Scanner;


// not sorted
// first sort array , apply bs
//  nlogn + logn

// n

public class BinarySearch {

    public static int linarySearch(int arr[] , int k){
        for(int i=0;i<arr.length;i++){
            if(arr[i] == k){
                return i;
            }
        }
        return -1;
    }

    // 2 5 8 12 17 23 30 45

    // l                  r
    // 0 1 2  3  4  5  6  7

    // 24783478734789


   // 90       100
    // left    right
    // mid = (right + left) /2 = 0+7/2 = 3              18  // integer overflow exception Mistake1
    // mid = left + (right-left)/2 = 0 + 7/2 = 3      18

    // l = 12 , r = 25

    // 238643867462387467823

    // long

    //     16
    //   r  l
    //   7   8 - index
    //      m

    // k = 15


    //    single element
    //      15
    //       l
     //      r

    public static int binarySearch(int arr[],int k){
        int left = 0;
        int right = arr.length - 1;

        while(left<=right){ // very important // mistakee 2
            int mid =left + (right-left)/2;

            if(arr[mid] == k){
                return mid;
            }
            if(arr[mid] < k){
                // discard left hald
                left = mid+1; // discard everything from starting till mid // left = mid // mistake 3
            }
            else{
                right = mid-1;
            }

        }

        return -1;
    }

    //  1 4 5 7 8 9 10 17 19 25 30
    //               l    mid       r
    //  0          m 8             12
    //

    // 83

    static void main() {
        Scanner sc = new Scanner(System.in); // input from user
        int n = sc.nextInt(); //100

        int[] arr;
        arr = new int[n]; // 100

        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }

        int data = sc.nextInt();// search this data

        System.out.println(linarySearch(arr,data));


        System.out.println("Now apply Binary Search");
        System.out.println(binarySearch(arr,data));
    }
}
