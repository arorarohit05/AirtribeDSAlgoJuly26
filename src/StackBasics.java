import java.util.Stack;
// Last in first out
public class StackBasics {

    // Iterable -> collection ->

    // array, linkedlist
    // Scratch implementation of stack
    // initialize array
    // push
    // pop
    // peek
    // 6th index
    // top--
    // 5

    // FIFO , LIFO
    // deque = add and remove elements from both sides [front as well back]
    static void main() {
        Stack<Integer> stack = new Stack<>(); // class

        stack.push(50);
        stack.push(60);
        stack.push(700);
        stack.push(85);
        stack.push(400);
        System.out.println(stack.size());

        System.out.println(stack);

        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.peek());

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

        System.out.println(stack.isEmpty());

        System.out.println(stack.size());


    }
}
