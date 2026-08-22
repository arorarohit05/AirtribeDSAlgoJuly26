import java.util.Scanner;
import java.util.Stack;

public class NextGreeaterTemp {

    public static int[] nextGreaterTemperatures(int temp[]){
        int n = temp.length;
        int answer[] = new int[n];
        // [0 0 0 0 0 0 0 0]

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(temp[j] > temp[i]){
                    answer[i] = j-i;
                    break;
                }
            }
        }
        return answer;
    }

    // 0   1  2  3  4  5 6  7
    //[73,74,75,71,69,72,76,73]
 //a//  1  1  4  2  1  1  0  0

    // stack [ 6 7]

    // 8 7 6 5 15

//  50


    // for (int i = 0; i < n; i++) {
    //
    //    while (!stack.isEmpty()
    //
    //            && current element makes stack top useless) {
    //
    //        int index = stack.pop();
    //
    //        // Resolve answer for index
    //
    //    }
    //
    //    stack.push(i);
    //
    //}
    public static int[] nextGreaterTemperaturesOpt(int temp[]) {
        int n = temp.length;
        int answer[] = new int[n];

        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<n;i++){

            while(!stack.isEmpty() && temp[i]>temp[stack.peek()]){
                int previousIndex = stack.pop(); // 0
                answer[previousIndex] = i - previousIndex;
            }

            stack.push(i);
        }



        return answer;

    }

    public static int[] nextGreaterElementsOptCircular(int temp[]) {
        int n = temp.length;
        int answer[] = new int[n];

        // fill with -1

        Stack<Integer> stack = new Stack<>();

        // 0 1 2 3 , 4 5 6 7
        //           0 1 2 3

        // n = 4
        for(int i=0;i<n*2;i++){

            int currentIndex = i%n;

            while(!stack.isEmpty() && temp[currentIndex]>temp[stack.peek()]){
                int previousIndex = stack.pop(); // 0
                answer[previousIndex] = temp[currentIndex]; //i - previousIndex;
            }

            if(i<n) {
                stack.push(i);
            }
        }



        return answer;

    }

    //[73,74,75,71,69,72,76,73]
    // 1  1

    static void main() {
        Scanner sc = new Scanner(System.in); // input from user
        int n = sc.nextInt(); // 8

        int[] temp;
        temp = new int[n]; // 8 temperatures

        for(int i=0;i<n;i++){
            temp[i] = sc.nextInt();
        }

        int arr[] = nextGreaterTemperatures(temp);
        for(int i=0;i<n;i++){
            System.out.println(arr[i] + " ");
        }

        int arr1[] = nextGreaterTemperaturesOpt(temp);
        for(int i=0;i<n;i++){
            System.out.println(arr1[i] + " ");
        }
    }
}


// circular array


// next greater temperature
//  //[73,74,75,71,69,72,76,73]
//     74 75  76           74

// find next greater element

// [1,3,2,1]
//  3 -1 -1 -1

// [3,-1,3,3]

// 2 3 4 5 8 3
// next greater

// traverse twice, but add in stack once only
//            0   1   2   3
// origin // [1,  3,  2,  1]
// answer // [3  -1   3   3]


// stack =>[1  ]
