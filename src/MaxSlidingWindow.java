import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.Scanner;
//  0 1  2  3 4 5 6 7
// [1,3,-1,-3,5,3,6,7] -> k = 3
// 3 3 5 5 6 7

// maintain a window in a queue
//  index are growing towards rear side

//  elements increasing order
// [ 1 2 ]
// front
//v- 1

// -> expired
// -> non useful

public class MaxSlidingWindow {

    // 100

    // 5

    //

    // [1 2 3 4 5 6 7] k = 3
    // [a b c d e]
    public static int[] maxSlidingWidnow(int nums[], int k) {
        int n = nums.length;
        int ans[] = new int[n - k + 1];
        Deque<Integer> queue = new ArrayDeque<>(); // maintain our window
        int j = 0;
        for (int i = 0; i < n; i++) {
            // step 1: remove indexes that are out of window - expired
            while (!queue.isEmpty() && queue.peekFirst() <= i - k) { // 1 iterations
                queue.removeFirst();
            }

            // 2 4 6 8
            // step2:useless elements
            while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]) {
                queue.removeLast();
            }

            // [ 8  3 ]  7

            // step: 3 added new element
            queue.addLast(i);

            // updating the max of window
            if (i >= k - 1) {
                ans[j++] = nums[queue.peekFirst()];// decreasing order
            }
        }


        // 0 1 2 3 4 5 6 7
        //     adding

        // k = 3
        return ans;
    }

    static void main() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int k = sc.nextInt();
        int brr[] = maxSlidingWidnow(arr, k);

        for (int i = 0; i < brr.length; i++) {
            System.out.print(brr[i] + " ");
        }

        //

        // 1 - expired element []out of widnow
        // 2 - useles elemenet

        //
        // [1 2]

        //         3
        // 3
        //
    }
}
