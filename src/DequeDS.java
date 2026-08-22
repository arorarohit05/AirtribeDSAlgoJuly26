import java.util.ArrayDeque;
import java.util.Deque;


// interface A
// class B implements A

public class DequeDS {

    static void main() {
        Deque<Integer> deque = new ArrayDeque<>();

        deque.addLast(10);
        deque.addLast(20);
        deque.addLast(30);
        deque.addLast(40);
        deque.addLast(50);

        // Front [10 20 30 40 50       ]  Rear


        System.out.println(deque);

        System.out.println(deque.removeFirst());

        System.out.println(deque.removeLast());

        System.out.println(deque);

        System.out.println(deque.peek()); // first element
    }
}

//   F   [40 30 20 10 50      ]  R
