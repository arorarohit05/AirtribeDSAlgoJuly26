import java.util.Scanner;

// Item
// int arr[] = new int[Item.size]

public class ArrayBasica {

    static void main() {
        Scanner sc = new Scanner(System.in); // input from user
        int n = sc.nextInt(); // 20

        int[] arr;
        arr = new int[n]; // 20

        for(int i=0;i<n;i++){
            System.out.print (arr[i] +  " ");
        }
    }
}

// [1 2 3 4 5...]

//
