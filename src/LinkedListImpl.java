// GIT -> repository


//Node{}
// function
public class LinkedListImpl {

    Node head; // to store the starting address
    static Node tail; // address of last node

    static class Node{
        int data;
        Node next;

        Node(int val){
            this.data = val;
            this.next = null;
        }
    }
    //       head  -> [30,1884] -> [20,null]

    // newNode = 2056
    // newNode.next = 1884
    // head = 2056

    //      head -> [20,null]

    //            newNode = [100.null]
    //  60->50->40->30->20->null
    //                   p
    void addLast(int data){
        Node newNode = new Node(data);

        if(head == null){ // adding the first node
            head = newNode;
            return;
        }

        Node ptr = head;
        while(ptr.next!=null){
            ptr = ptr.next;
        }

        ptr.next = newNode;
    }


    //100->20->30->40->50->5->8->23->65->70->63
//                      ^---------------------
    void addLastWithCycle(int data){
        Node newNode = new Node(data);

        if(head == null){ // adding the first node
            head = newNode;
            return;
        }

        Node ptr = head;
        while(ptr.next!=null){
            ptr = ptr.next;
        }

        ptr.next = newNode;
        newNode.next = head.next.next.next.next;// make it cycle
    }

    void addStart(int data){
        Node newNode = new Node(data); // newNode -> [30, null]

        if(head == null){ // adding the first node
            head = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }
    //      [60,null]
    // head ->[60,]->  20 -> 30 -> 40 -> 50 -> null

    // 5 elements

    // [1,2,3,4,5]

    // head = x -> [1,a] -> 2,b -> 3,c -> 4,d -> 5,null -> null
//                                                head
    public void printMyList(){

        if(head == null){
            System.out.println("Nothing is present in the list");
            return;
        }

        // head
        Node ptr = head;

        System.out.print(ptr.data + "->"); //1-> 2->3->4->5->
        while(ptr.next!=null){
            ptr = ptr.next;
            System.out.print(ptr.data + "->");
        }
        System.out.print("null");
    }

    public void deleteFirst(){
        if(head == null){
            System.out.println("Nothing is present to delete");
            return;
        }
        head = head.next;
    }

    //65->23->8-> 5 ->50->40->30->20->100->null
    //                        p1
    //                                       p2

    // k =3


    // null<- 65<-23  8->5->50->40->30->20->100->null

    //        p   c   n
    //

    public void reverseTheList(){
        Node prev = null;
        Node curr = head;
        Node next = curr;

        while(curr!=null){
            next = curr.next; // maintain the reference

            curr.next = prev;
            prev = curr;
            curr = next;
        }

        head = prev;
    }

    public Node kthNodeFromEnd(int k){
        Node ptr1 = head;
        Node ptr2 = head;

        for(int i=0;i<k;i++){ // 3
            if(ptr2 == null){
                return null;
            }
            ptr2 = ptr2.next;
        }

        while(ptr2!=null){
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }

        return ptr1;
    }

    // 6
    // 3 4

    // 1 -> 2 -> 3 -> 4 -> 5 -> null
    //           s
    //                     f

    // .next.next null

    // null.next
    // node.next
    public int findMiddleNode()
    {
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next; // NPE
        }
        return slow.data;
    }

    // 1
    // 2

    // 1
    // 3


    // 1->2->3->4->5->6
    //          s
    //                   f




    // 1 2 3 4 5
    //

    //   1 2 3 4 5 ->null
    //                p

    // while(!p.next!=null)

    // p = null

    // 1->2->3->4->5 > nul
    //    s  f
     public boolean detectCycle(){
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }

        return false;




    }

    static void main() {
//        Node node1 = new Node(20); //  [20,null]
//        Node node2 = new Node(30); // [30,null]
//// head ->  [20,b]   ->   [30,null]
//        //            b
//        node1.next = node2; // node 1 , next = referecne to node 2
//        head = node1;


        // add a node in a linked list at the starting


        LinkedListImpl list = new LinkedListImpl();
        list.addStart(20);
        list.addStart(30);
        list.addStart(40);
        list.addStart(50);

        list.printMyList();

        list.addStart(60);

        System.out.println();
        list.printMyList();

        list.addLast(100);

        System.out.println();
        list.printMyList();

        list.deleteFirst();
        System.out.println();
        list.printMyList();

        list.addStart(5);
        list.addStart(8);
        list.addStart(23);
        list.addStart(65);

        System.out.println();
        list.printMyList();
        System.out.println();

        int k = 3;
        Node kthFromEnd = list.kthNodeFromEnd(3);
        if(kthFromEnd == null){
            System.out.println("There is no kth node from end");
        }
        else {
            System.out.println(kthFromEnd.data);
        }

        list.reverseTheList();
        list.printMyList();
        System.out.println();

        list.addLast(70);
        list.printMyList();
        System.out.println();

        System.out.println(list.findMiddleNode());


        //100->20->30->40->50->5->8->23->65->70->null

        list.addLastWithCycle(63);
        System.out.println(list.detectCycle());

        // where is the cycle starting ???

//        60
        // [60 -> 50 -> 40 -> 30 -> 20 -> 100 ]

    }
}


// 65->23->8->5->50->40->30->20->100->null
// h

// null<-65<-23<-8<-5<-50<-40<-30<-20<-100
//                                      h

//
// delete last
// delete middle

// reverseAList
