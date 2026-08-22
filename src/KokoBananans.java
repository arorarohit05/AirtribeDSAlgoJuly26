import java.util.Scanner;

public class KokoBananans {

    public static int findMinimumSpeedBS(int[] piles, int h) {
        int left = 1;
        int right = 0;

        for(int i=0;i<piles.length;i++){
            right = Math.max(right,piles[i]);
        }

        // to check if its not possiuble - return -1

      //  int answer = -1;
        while(left <= right){ // logm
            int mid = left + (right-left)/2; // 1 -11

            int hours = 0;
            for(int pile : piles){
                hours += Math.ceil((double)pile/mid);
            }

            // if it was allowed to move to next

//            if(hours<=h){ // directly return  // mid = 6
//                answer = mid;//6
//                right = mid-1;
//            }
            if(hours<=h){ // directly return  // mid = 6
              //  answer = mid;//6
                right = mid;
            }
            else{
                left = mid+1;
            }
        }

        // 1 ---------11
        //     mid  = 6
        // 1 - 6

        //  mid =3

        // 4-6
        // mid = 5
        //4-5

        // mid = 4
        // 4-4
        // mid = 4


        return right;
    }

    //  7 3 11 6
    // h = 8

    // k=4

    public static int findMinimumSpeed(int[] piles, int h){
        int maxPile = 0;

        for(int i=0;i<piles.length;i++){
            maxPile = Math.max(maxPile,piles[i]);
        }

        // 1 - maxpile

        for(int speed = 1;speed<=maxPile;speed++){
            int hours = 0;

            for(int pile : piles){
                hours += Math.ceil((double)pile/speed);
            }

            //

            if(hours <= h){
                return speed;
            }
        }
        return -1;
    }

    // 7 4
    // 1.something


    static void main() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//4

        int[] piles = new int[n];
        for(int i=0;i<n;i++){
            piles[i] = sc.nextInt(); // 3 6 7 11
        }

        int h = sc.nextInt(); // 8

        int k = findMinimumSpeed(piles, h);
        System.out.println(k);

        int k1 = findMinimumSpeedBS(piles, h);
        System.out.println(k1);

//        int p = 11;
//        int s = 4;
//        System.out.println(Math.ceil((double)p/s));
    }
}
