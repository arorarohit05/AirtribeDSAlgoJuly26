import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;


// Queue ->  <-front (remove)   [      20, 30, 40]<- rear

// ATM   ->     front 1 2 3 4 5 6 7 8 9 10 11 rear
public class QueueDS {

    static void main() {
        Queue<Integer> queue = new ArrayDeque<>();

        queue.add(10); // adding element to the rear of the queue
        queue.add(20);
        queue.add(30);
        queue.add(40);

        System.out.println(queue.peek());

        System.out.println(queue.remove()); // removing

        System.out.println(queue.peek());

        System.out.println(queue.isEmpty());
    }
}

// stack -> push pop
// queue -> enqueue dequeue
