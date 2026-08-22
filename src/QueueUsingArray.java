// share GIT link
// raise PR

public class QueueUsingArray {
    int queue[];
    int front;
    int rear;
    int size;
    int capacity;

    QueueUsingArray(int k){
        this.capacity = k;
        queue = new int[k];
        front = 0;
        rear = 0;
        size = 0;
    }
    //          0 1 2 3 4
    // queue = [ , , , , ]
    //          f
    //          r

    // size = 0

    public void enqueue(int num){
        if(isFull()){
            System.out.println("No enough to add more element");
            return;
        }

        queue[rear] = num;
        //rear++; // wrong , is it circualr??
        rear = (rear+1)%capacity;
        size++;
    }

    public int dequeue(){
        if(isEmpty()){
            System.out.println("Nothing left to remove");
            return -1;
        }

        //front++;// worng
        int element = queue[front];
        front = (front+1)%capacity;
        size--;
        return element;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public boolean isFull(){
        return size == capacity;
    }

    public int peek(){
        if(isEmpty()){
            System.out.println("Nothing left to remove");
            return -1;
        }
        return queue[front];
    }

    // 5 5


    static void main() {
        QueueUsingArray que = new QueueUsingArray(5);

        que.enqueue(10);
        que.enqueue(20);
        que.enqueue(30);
        que.enqueue(40);
        que.enqueue(50);
        que.enqueue(60);

        // [10 20 30 40 50]
        // 10

        System.out.println(que.dequeue()); // removing element from first, front

        que.enqueue(60);
        que.enqueue(70);
        System.out.println(que.peek());
    }
}
