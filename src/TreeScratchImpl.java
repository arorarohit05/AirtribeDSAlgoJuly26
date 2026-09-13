import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeScratchImpl {

    static class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data){
            this.data = data;
        }
    }


    // pot (1)


//      1
//   2     3
// 4   5  n  6

    // queue =  2 3

    // count = 2

    // answer = 1

    // answer = 1 2 4 5 3 6
    // root left right
    public static void preorderTraversal(TreeNode root){
        if(root == null){
            return;
        }
        System.out.print(root.data +" ");
        preorderTraversal(root.left);// came back
        preorderTraversal(root.right);
    }

    //  left -> right -> root
    public static void postorderTraversal(TreeNode root){
        if(root == null){
            return;
        }
        postorderTraversal(root.left);// came back
        postorderTraversal(root.right);
        System.out.print(root.data +" ");
    }

    public static void inorderTraversal(TreeNode root){
        if(root == null){
            return;
        }
        inorderTraversal(root.left);// came back
        System.out.print(root.data +" ");
        inorderTraversal(root.right);
    }

    // 1
    //2  3

    // 2 1 3

    // 1
    //2   3
//   n n n n

    // 2 3 1

    // 2 3 1

    //   1
    // 2    3
    //4 5  n  6

// queue  =

    // 1
    // 2 3
    // 4 5 6


    public static void levelOrderTraversal(TreeNode root){
        List<List<Integer>> result  = new ArrayList<>();

        if(root == null){
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        // everytime you are at a node
        // adding it
        // removing it

        while(!queue.isEmpty()){
            int size = queue.size(); //3
            List<Integer> level = new ArrayList<>();

            for(int i=0;i<size;i++){

                // if( i == size-1) // last node of each loevel
                TreeNode node = queue.remove(); //  1
                level.add(node.data);
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
            }
            result.add(level);
        }

        // print the result

        for(int i=0;i<result.size();i++){
            for(int j=0;j<result.get(i).size();j++){
                System.out.print(result.get(i).get(j));
            }
            System.out.println();
        }

        // [4,5,6]


        // print result
    }

    public static void rightSideView(TreeNode root){
        List<Integer> view  = new ArrayList<>();

        if(root == null){
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        // everytime you are at a node
        // adding it
        // removing it

        while(!queue.isEmpty()){
            int size = queue.size(); //3

            for(int i=0;i<size;i++){
                TreeNode node = queue.remove(); //  1
                if( i == size-1){
                    view.add(node.data);
                }
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
            }

        }

        // print the result

        for(int i=0;i<view.size();i++){
            System.out.print(view.get(i));
        }

        // [4,5,6]


        // print result
    }


    public static void levelOrderTraversalSecond(TreeNode root){
        List<Integer> result  = new ArrayList<>();

        if(root == null){
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        // everytime you are at a node
        // adding it
        // removing it


        while(!queue.isEmpty()){

                TreeNode node = queue.remove(); //  3
                result.add(node.data);
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
        }

        // result = [1 ,2 , 3,4,5,6]

        // print the result

        for(int i=0;i<result.size();i++){
            System.out.print(result.get(i) + " ");
        }

        // [4,5,6]


        // print result
    }

    // result = [[1],
    //           [2,3],
    //           [4,5,6]]

    // 1
    //2 3
    //45
    static void main() {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
       //root.left.right = new TreeNode(5);

       // root.right.right = new TreeNode(6);

        preorderTraversal(root);
        System.out.println();

        postorderTraversal(root);
        System.out.println();

        inorderTraversal(root);
        System.out.println();

        levelOrderTraversal(root);
        System.out.println();

        levelOrderTraversalSecond(root);

        System.out.println();

        rightSideView(root);


    }

}

// print right view of the tree
//   1
// 2   3
//4 5

// 1 3 4


//      1   - l0
//   2     3 -  l1
// 4   5  n  6 - l2
//8
// l3
// l4

// BFS  -> 1 2 3 4 5 6
// queue data structure - FIFO behavior

//      8  -> queue

// 1 2 3 4 5 6 8

//  1
// 2  3

// 2 1 3
// 1 2 3
// 2 3 1

// left root right

// 4 7 2 5 1 3 6

// postorder = 4 5 2  6 3 1

// inorder = 4 -> 2 -> 5  -> 1 -> 3 -> 6

//preorder =  1->2->4 ->5 ->3->6 = DFS travsrsal of the binary tree
// always use recursion - u have to backtrack


// height of the tree, max no of edges = 2
// depth of a node , distance from root = 1


// 2 aproaches of travsersal :
// DFS - depth first search - go deep before going wide
// 3 DFS travsersals :
// a) Preorder = Root -> left -> right
// b) Inorder = left -> root -> right
// c) Postorder = left -> right -> root

// roght rroot left

//       root
//  left       right


// DFS = deep

// BFS - breadth first search -
// go level by level
