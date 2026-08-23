
 //dummyhead  -> A b C dummytail

 import java.util.HashMap;


//    [null.-1,-1, 2034] -> <-  [1234,-1,-1,null]
 public class LRUCache {

    Node dummyHead;
    Node dummyTail;

    HashMap<Integer, Node> hm;
    final int capacity;


    LRUCache(int capacity){
        this.capacity = capacity;
        hm = new HashMap<>();

        dummyHead = new Node(-1,-1);
        dummyTail = new Node(-1,-1);
        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
    }

    class Node{
        int key;
        int value;

        Node prev;
        Node next;

        Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    //     A     B   C
    private void removeNode(Node node){// 2 reference
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    //
    // dh <- 1-> 2
    private void addFirst(Node node){ // update 4 referwence
        node.next = dummyHead.next;
        node.prev = dummyHead;

        dummyHead.next.prev = node;
        dummyHead.next = node;
    }

    // get(20)
    // 20 -> 2048

    // 20,mahisha,a,b   A       B
    public int get(int key){
        if(!hm.containsKey(key)){
            return -1;
        }

        Node node  = hm.get(key); // address from hashmap
        removeNode(node);
        addFirst(node);

        return node.value;
    }

    public void put(int key, int value){
        if(hm.containsKey(key)){
            Node node = hm.get(key);

            node.value = value;
            removeNode(node);
            addFirst(node);
            return;
        }

        Node node = new Node(key,value);
        hm.put(key,node);
        addFirst(node);

        // 1 important step - check for eviction
        if(hm.size() > capacity){
            Node lru = dummyTail.prev;
            removeNode(lru);
            hm.remove(lru.key);
        }
    }

    // [maintain the capacity to be - 5]





    static void main() {
        LRUCache cache = new LRUCache(2);
        cache.put(1,1); //  h[4.4]   [3,3]      t
        cache.put(2,2);
        System.out.println(cache.get(1));     // 1
        cache.put(3,3);
        System.out.println(cache.get(2));    //-1
        cache.put(4,4);
        System.out.println(cache.get(1)); // -1
        System.out.println(cache.get(3)); // 3
        System.out.println(cache.get(4));//4
    }
}
