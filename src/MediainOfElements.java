// 5 10 1 3 8....


import java.util.Collections;
import java.util.PriorityQueue;

public class MediainOfElements {

    private PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder()); // MAX heap
    private PriorityQueue<Integer> right = new PriorityQueue<>(); // MIN heap

    public double findMedian(){ // O(1)
        // odd
        if(left.size() > right.size()){
            return left.peek();
        }
// even
        return (left.peek() + right.peek())/2.0;
    }

    // rule 1 : all left <= all right      SIDE
    // rules 2 : differ by 1 size max
    //               left size == rightsize
    //               left size = rightsize+1
    public void addNum(int num){ // maintain our heaps using those 2 rules

        // which half this number should go
        // number, both peaks
        // 5 - left
        // 10 -
        // 1
        // 3

        // 1 10 5 3
        // Left        Right
       //   1   3         10 5

        // maximum         minimum
        // finding correct size
        if(left.isEmpty() || num<=left.peek())
        {
            left.offer(num);
        }
        else{
            right.offer(num);
        }

        // Balancing - we will do every step
        if(left.size() < right.size()){
            left.offer(right.poll());// from right to left
        }

        if(left.size() > right.size()+1){
            right.offer(left.poll()); // from left to right
        }
    }

    // maintaina heap
    // add element
    // delete element

    //heapifyy..

    // a b c d e f g h .....

    // left=2      right=0
    //  a           b
    // max heap     min heap

    // left     right
    // 1 3          2

    static void main() {
        MediainOfElements medianFinder = new MediainOfElements();

        medianFinder.addNum(5);

        medianFinder.addNum(10);
        medianFinder.addNum(1);
        System.out.println(medianFinder.findMedian()); // O(1)
        medianFinder.addNum(3);
        medianFinder.addNum(8);

        System.out.println(medianFinder.findMedian());


        medianFinder.addNum(20);
        System.out.println(medianFinder.findMedian());
        // 5 8
    }
}
