// c a t
//     isword = true

// c a r
//   isword = true

// c a r e
//       isword = true

// wherever a word is ending - true

// ca


//               root
//      a b              C                               d e f g .............z
//                      [A                  b c d e f ..........z]
//                   [a b c d e f ..T[isword = true]...z ]

public class TrieImpl {

    TrieNode root;

    TrieImpl(){
        root = new TrieNode();
    }

    class TrieNode{

        // each node can have upto 26 children
        // one for each english char a-z
        TrieNode[] children = new TrieNode[26];

        // true means - a complete word ends at this node
        boolean isword;
    }

    // what usecase
    // -> thousand/millions of string

    // rohit-> isword true
    // rohi -->

    // roh
    //ro

    // finastring ro-> true

    // ca -> true
    // c ->true

    // cam ->

    // find a word in a pool of millions of string ->
    // rohit

    // r o h i t -> true

    // rohi ->

    //        root
    //        c     n
    //        a     a-isword- teue
    //        r  - isword = true
    //        e  - isword = true
    //        f
    //        u
    //        l
    //        l  - isword - true

    // na - word
    // ca
    //caref

    // car
    //care
    //carefull

    //"car"

    // function - inseting a string
    // insert("cat")


    // root ->
    // current  -> [  ]

    public void insert(String word){
        // start from the root
        TrieNode current = root;

        for(char c: word.toCharArray()){ // ['c'  , 'a'  , 't']
            int index = c - 'a';

            if(current.children[index] == null){
                current.children[index] = new TrieNode();
            }

            current = current.children[index];
        }

        current.isword = true;
    }

    public boolean search (String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';

            if(current.children[index] == null){
                return false;
            }

            current = current.children[index];
        }

        return current.isword;
    }

    // ca...... n number / 0 words

    // ca   car
    //      cat
    //      care
    //      carefull
    //      caref
    //     carefu
    //     careful

    // ca
    public boolean startsWith(String prefix){ // "ca"
        TrieNode current = root;

        for (char c : prefix.toCharArray()) {
            int index = c - 'a';// 2
            if(current.children[index] == null){
                return false;
            }
            current= current.children[index];
        }
        return true;
        // ca
    }

    // isword - true

    // prefix based search


    // quick sort - single
    // quick sort - doible pivot

    // c
    //a

    //  englash[isword = false]

    //   root
    //    c
    //   a [isword = false [null, r. null]]

    //           root
    // current -> c [ is word = falsse  [ , , , , , , ]]
//   current ->   a [ iswrod = false [ , , , ,[t] , , ]]
// current -?> t
    //   root ->      [ isword = false   [null ,null ,node ,null , , ......]  ]

    static void main() {
        TrieImpl trie = new TrieImpl();

        trie.insert("cat");
        trie.insert("care");
        trie.insert("car");

        System.out.println(trie.search("car"));

        System.out.println(trie.startsWith("cart"));
    }
    //  root
    //    c
    //    a
    //   t[true]     r
    //               e[iswordtrue]

}
