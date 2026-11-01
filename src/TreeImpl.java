import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeImpl {

    static int diameter = 0;


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

        //      1
        //   2     3
        // 4   5      9
    //            7      15
    //                       18

    // 1 = root
    // rightheight = 4 = max no of nodes starting from 3
    // leftheight = 3 = max no of nodes starting from 2
    // height = 1 + (max (4,3)) = 5

    // diameterthroughroot = 4+3 = 7 = leftheight + heitgh
    // max no of edges bw any 2 nodes

        public static int maxDepth(TreeNode root){
            if(root == null){
                return 0;
            }

            int lh = maxDepth(root.left);
            int rh = maxDepth(root.right);

            return 1+Math.max(lh,rh);
        }

        // diameter = lh + rh - at every node - max

        // diameter -> max

    // at every node  = diamter


        //  diameter = leftheight + rightheight

    public static int diameter(TreeNode root){
        if(root == null){
            return 0;
        }

        int lh = diameter(root.left);
        int rh = diameter(root.right);

        diameter = Math.max(diameter, lh+rh); // only line
        // whatebver dia , current dia - passign throug current node

        return 1+Math.max(lh,rh);
    }


    //          1
    //      2      3
    //   4    5

    // dia = 3

    //             diameter (1)    3




    // height = max no of nodes starting from root
    // diameter = max no of edges bw any 2 nodes

    //          1
    //      2       3
    //   4     5
    //     5      8
    //        7      9

    // diameter = 6

        //   height  = max no of nodes from root till any leaf

        //       root

        //          7     -> 1

    //  leaf       []
    //         left    right

    //        root

    //     lh        rh


    //   1
    // 2    3
    //4 5

    // height = 3
    // dia= 3

    //      1
    //   2     3
    // 4   5
    //9     15
    //10     25

    // diamewter = 6

    // diameter through root = max

    // diameter = max edges bw any 2 nodes 10-25

    // 10-25


       public static TreeNode lowerstCommonAncestor(TreeNode root,TreeNode p,TreeNode q){
            if(root == null){
                return null;
            }

            if(root == p || root == q){
                return root;
            }

            TreeNode left = lowerstCommonAncestor(root.left,p,q);
            TreeNode right = lowerstCommonAncestor(root.right,p,q);

            if(left!=null && right!=null){
                return root;
            }

            if(left!=null){
                return left;
           }

            return right;
       }

       //  null nothing     5   node
    //     8           41
//     tree

       //          1
    //        2        3
    //     4    5
    //  9        15
    //10            25

    // p = 9
    // q = 5

    // answer = 2


    /*


    //       root
    //     /       \
    //  solve(left)  solve(right)
    //     \        /
    //     combine solution

        solve(root){

        // base case

        // left = solve(left)
        // rioght = solve(right)

        return  combines solution

        }



     */

        public static boolean IsBinarySearchTree(TreeNode root){
            return validate(root,Long.MIN_VALUE,Long.MAX_VALUE);
        }

        public static boolean validate(TreeNode root, long min, long max){
            if(root == null){
                return true;
            }

            if(root.data >= max || root.data<= min ){
                return false;
            }

            return validate(root.left,min,root.data) && validate(root.right,root.data,max);
        }

        // solve left
    // solve right
    // combine

    // carrying constraingt down while traversing
        //           5
    //           3       7
    //      null            null

         // min = 5 - max = 7

    // -214823  5


        static void main() {
//            TreeNode root = new TreeNode(1);
//
//            root.left = new TreeNode(2);
//            root.right = new TreeNode(3);
//
//           // root.right.right = new TreeNode(9);
//           // root.right.right.right = new TreeNode(15);
//           // root.right.right.right.right = new TreeNode(18);
//
//            root.left.left = new TreeNode(4);
//            root.left.left.left = new TreeNode(9);
//            root.left.left.left.left = new TreeNode(10);
//            root.left.right = new TreeNode(5);
//            root.left.right.right = new TreeNode(15);
//            root.left.right.right.right = new TreeNode(25);
//
//        //    root.left.right.right = new TreeNode(7);
//
//            System.out.println(maxDepth(root));
//
//            diameter(root);
//            System.out.println(diameter);
//
//            TreeNode lca = lowerstCommonAncestor(root,root.left.left.left,root.right);
//            System.out.println(lca.data);

            TreeNode root = new TreeNode(5);

            root.left = new TreeNode(5);
            root.left.left = new TreeNode(3);
            root.right = new TreeNode(7);

            System.out.println(IsBinarySearchTree(root));
        }

    }
    //       5
//       5        7
//   3

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

