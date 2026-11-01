//priority queue is a data structure/ concept
// where highest priority is accessible first.

// It can be implemented using heap

// in java - priority queue is implemeented using heap
// we have a call for it. its default impl - is min heap.

import java.io.PrintStream;
import java.util.Collections;
import java.util.PriorityQueue;

public class PirorityQueueBasics {

    static void main() {

        // by default min- heap
        PriorityQueue<Integer> pq1 = new PriorityQueue<>();
        pq1.add(5);// offer
        pq1.add(2);
        pq1.add(8);
        pq1.add(1);

        System.out.println(pq1.peek());

        pq1.add(-10);
        System.out.println(pq1.peek());

        pq1.poll();
        System.out.println(pq1.peek());


        // max heap
        PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder());


        pq2.add(5);
        pq2.add(2);
        pq2.add(8);
        pq2.add(1);

        System.out.println(pq2.peek());//8

        pq2.add(-10);
        System.out.println(pq2.peek());//8

        pq2.poll();
        System.out.println(pq2.peek());//5

        System.out.println(pq2.size());

        System.out.println(pq2.isEmpty());


        while(!pq2.isEmpty()){
            System.out.println(pq2.poll());
        }

        // collections

        //   1
        // 2    5
        //7


    }

}

//        1
//     2     8
//  5
