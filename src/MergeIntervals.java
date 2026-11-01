/*

[1,3]
[2,6]
[8,10]
[9,12]

 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

// [1,2,3,4]

    public static int[][] mergeIntervals(int[][] intervals){
        // sorted by start time
        Arrays.sort(intervals,(a,b) -> Integer.compare(a[0],b[0]));

        List<int[]> result = new ArrayList<>();

        int start = intervals[0][0];
        int end = intervals[0][1];

        for(int i=1;i<intervals.length;i++){
            int currentStart = intervals[i][0];
            int currentEnd = intervals[i][1];

            // overlap
            if(currentStart<=end){
                end = Math.max(end,currentEnd);
            }
            //else
            else{
                result.add(new int[]{start,end});
                start = currentStart;
                end = currentEnd;
            }
        }
        result.add(new int[]{start,end});
        // list to array.
        return result.toArray(new int[result.size()][]);
    }

    // 1,5
    // 7,8
    //10,12

    // 1,5
    //7 8
    // 10 12

    // 1,5
    // 7,8


    //// 0,30
    //// 5,10
    //// 15-20
    ///
    /// // start = 0 5 15
    /// // end = 10 20 30


    // first -> 2 4 = 3
    // first second thirs fourth  = 3
    // each meeting , compare with all meetings



    // 5 10  second third    // 0 30


    // 6-8    0-30   5-10

    // for each meeting
    //        compare and see how many meetings it is overlapping with

    // step 1 soprt the meeting  by start and end time
    // step keep comparing


// meeting1
    // meeting 2
    // start1 < end2   && start2 < end1

    // 0 -----------------30
    //      5-----10
    //        6-8



    //
    //// 1,4
    //    // 2,3
    //    // 3,5
    //           i
    // start 1 2 3
    // end    3 4 5
    //        j

    // 3

    // 1meetin   2 meeting
    //                         meeting ended....

    // greedy about earlist finishing interval
    public static int NoOfMeetingRooms(int[][] intervals){
        int n = intervals.length;

        int[] start =  new int[n];
        int[] end = new int[n];

        for(int i=0;i<n;i++){
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int rooms = 0;
        int maxRooms = 0;

        int i=0;
        int j=0;

        // current meeting --------
        // process the meetings
        while(i<n){
            if(start[i] <= end[j]){ // next meetings start before earlier ends
                rooms ++;
                if(rooms>maxRooms) {
                    maxRooms = rooms;
                }
                i++;
            }
            else{
                rooms--;
                j++;
            }
        }

        return maxRooms;
    }


    //////     0,30
    //    //// 5,10
    //    //// 15-20            i
    //    /// // start = 0 5 15
    //    /// // end = 10 20 30
    //                     j
    // 0

    // n = 3

    // 1,4
    // 2,3
    // 3,5
    // 7,8
    // 10,12

    static void main() {
        int[][] intervals = {
                {1,4},{2,3},{3,5},{7,8},{10,12}
        };


        int[][] mergedIntervals = mergeIntervals(intervals);
        for(int i=0;i<mergedIntervals.length;i++){
            for(int j=0;j<2;j++){
                System.out.print(mergedIntervals[i][j]+" ");
            }
            System.out.println();
        }

        System.out.print(NoOfMeetingRooms(intervals));
    }
}

// 0,30
// 5,10
// 15-20

// how many intervals are active at the same time??
// how many min meeting rooms do i need to conduct all of them??


// 1-2
// 1:30 - 3
// 9-10
// [  ]



//// 0,30
//// 5,10
//// 15-20
// sweep line
// 0------5-----10------15------20------25------30
// [---------------------------------------------]
//        [------]
//                       [-------]
//                           [--------]
// left to right

// activemeeting 0

// meeting starts + 1
// meeting ends -1

//[0,30]
//
//[5,10]
//
//[15,20]

// event - starting/endign  +1, -1
                     // track active meeting
// 0 +1                1
// 5 +1                 2
// 10  -1              1
// 15 +1               2
// 20 -1               1
// 30 -1              0

//max = 3 // max rooms needed till now

// merge overlapping intervals
// metting rooms

//[0,30]
//
//[5,10]
//
//[15,20]

//0  +1
//
//5  +1
//
//10 -1
//
//15 +1
//
//20 -1
//
//30 -1



// GREEDY -> thingking
// algorithm


// multiple products
// 5 kg             [ so many thing ]   gold 100kg     100kg trash

// partial pickup
// greedy thinking - to get the maximum value out of it
// you are thinking

//   1kg gold - 100rs
//   1kg trash - 50 rs

// optimize 100kg - 5kgbag []


// Greedy
// pick the best looking option right now....
// continue
// cghoose again best option

// maximum/minuimum - greedy focus on best optionb

//  gold     trash        dal         diamond
//   5kg      10kg       6kg           2kg
//   100/kg    99kg        5kg          200/kg

// 10kg only -> partially pick items  YES
// diamond + gold + trash 3kgs
// partial knapsack


// partialluy not allowed
// 10kg  ->    2kg diamond + 5kg gold = 400 + 500 = 900 [right approacg???]
// 10kg trash - 990
// 0/1 knapsack

// greedy - what looks best right now should be best in the end as wel

//1 - choices to pick
// 2 - u have best choice to pick
// 3 - does this choice give best output in future as well - if yes greedy work

// 9-1 pm  = 4hrs

// [1,4] - NO
//
// [2,3]  - YES  -> 3pm - more opprtutniries
//
// [3,5]

// 1----------------4 after 3
//     2------3 after 3

//  earlier finish - more room for furture meeting - potentially more meettings executed??

// which is ending faster - more opportunities with pother meetings

// max non overlapping intervals wghich u can achive??? ---
// multiple meetings ..
// 1 rooms-> hoiw many maximum no of meeting can be possible in 1 rooms??


// Q - gives meeting with start time and end time// 1 meeting room availavble
// fins max no of meetings that can be executed

// 1-> sort by end time
// pick first  ,

// local choice should be global best choice
// partial knapsach
// 1- loacl best choice - diamond
// 2 - is local best choice, global best answer - YES

// 0 1 knapsack
// 1 ->diamond, gold,  --
// trash -
// DP

// 10
// pick the meeting which is ending earlier

// 1 2 3  5 7 10 15 20 25 50 70 100 200 300  500

// 972 -> minimum no of currencies
// 500 200 200 50 20 2 -> 6 minimum
// 300 70 2
//  3  1  1

// coind [ 1 3 6]
// amount = 6
// min no of coins needed for this - 4 1 1 - 3
//  3 3->2 coiunts

// 1 2 5 10 20 50 100 200


// algrithm- step to solve a probelm
// greedily ->


// problem

// stack

// Bucket - with dsa studd
// array
// hashmap
// ll
// trees
/// graph
// backtrackinmg
// ....greedy

// pracitsicing questions - topic wise  50%
// pick random question

// mock intervies
// self practive
// practive sessions - random questions

// how to think of a dsa problem....
//  - next sessions