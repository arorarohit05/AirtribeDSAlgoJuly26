import java.util.Scanner;

public class MinContainerSize {

    public static boolean canShip(int weight[] , int days, int cap){
        int daysNeeded = 1;
        int currentLoad = 0;

        for(int w : weight){
            if(currentLoad + w > cap) {
                daysNeeded++;
                currentLoad = 0;
            }

            currentLoad += w;
        }

        return daysNeeded<=days;

    }

    // 1 2 3 4      5     6    7    8   9   10
    // container => 10 , days 5

    // container  = 1+2+3+4+5

    public static int minContainerSize(int weight[] , int days){
        int left = 0;
        int right = 0;

        for(int i=0;i<weight.length;i++){
            left = Math.max(left, weight[i]);
            right = right + weight[i];
        }

        // left = max
        // right = sum

        int answer = right;

        while(left<=right){
            int capacity = left+(right-left)/2;

            if(canShip(weight,days,capacity)){
                answer = capacity;
                right = capacity -1;
            }
            else{
                left = capacity+1;
            }
        }

        return answer;

    }

    static void main() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();// 10
        int weights[] = new int[n];
        for(int i=0;i<n;i++){
            weights[i] = sc.nextInt();
        }

        int days = sc.nextInt();

        System.out.println(minContainerSize(weights, days));
    }
}
