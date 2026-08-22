import java.util.Scanner;
// 0 1 2 3 4 5
// 1 2 3 4 5 6
// size = 6

//    0 1 2 3 4 5 6 7 8
//   [1,8,6,2,5,4,8,3,7]

//      l           r


// x      y

// 3     7
// 1    4
// 3*3
public class MaxRainWater {

    public static int maxWater(int height[]){
        int l = 0;
        int r = height.length-1;

        int maxArea = 0;

        while(l<r){
            int area  = Math.min(height[l],height[r]) * (r-l);
            maxArea = Math.max(area,maxArea);
            if(height[l]<height[r]){
                l++;
            }
            else
            {
                r--;
            }
        }

        return maxArea;
    }

    static void main() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 10

        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }

        System.out.println(maxWater(arr));
    }
}
