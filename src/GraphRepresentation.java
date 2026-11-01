// 0 -------1
// |        |
// |        |
// |        |
// 2--------3

// 0 1 2 3

// grid as a graph

// no of islands

import java.awt.desktop.SystemSleepEvent;
import java.util.*;

// grapg ->  [ 0->[1,2], 1-> [], 2->[],   3->[]   ]

// 0 1 2 3 4 5 ...
// visited 5 indexed []

public class GraphRepresentation {

    // queue -> 0
    // visited ->0
    public static void bfsTraversal(List<List<Integer>> graph, int start){
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        // add starting node
        queue.add(start);
        visited.add(start);

        while(!queue.isEmpty()){
            int node = queue.remove(); // 0  //FIFO
            System.out.print(node +" "); // printing our traversal

            // visit the neighbours
            for(int neighbour : graph.get(node)){
                if(!visited.contains(neighbour)) {   // very important
                    visited.add(neighbour);
                    queue.offer(neighbour);
                }
            }
        }
    }

    public static void dfsTraversal(List<List<Integer>> graph, int start){
        Set<Integer> visited = new HashSet<>();
        dfsTraversal(graph,start,visited);
    }


    // visited  -> []
    // 0
    public static void dfsTraversal(List<List<Integer>> graph, int node,Set<Integer> visited){
        if(visited.contains(node)){ // if already visited stop
            return;
        }

        visited.add(node);// marked the node visted
        System.out.print(node +" ");

        // visit all neighbours
        for(int neighbour : graph.get(node)){ // 0
            dfsTraversal(graph,neighbour,visited); // recursive dfs call
        }
    }

    // 0  1 3 4 2

    // array [] for
    // 0->
    // 1->
    // array as hashmap ->


    //     0
    //   1    2
    // 3   4

    // 2 0 1 3 4

    // 0-> 1 2
    // 1 -> 0 3 4
    // 2->0
    // 3->1
    // 4->1

    // O(V+E)


    //     india

    // goa          delhi

    // 0>india
   // 1->goa

    // node indtefet

    // class City
    //


    // 1 -> 2 5
// 2-> 1 4 3
// 3-> 2 4
// 4-> 2 3
// 5 ->1
    static void main() {
        List<List<Integer>> graph = new ArrayList<>();
        int v = 5;
        for(int i=0;i<v;i++){
            graph.add(new ArrayList<>());
        }

        graph.get(0).add(1);
        graph.get(0).add(4);

        graph.get(1).add(0);
        graph.get(1).add(3);
        graph.get(1).add(2);

        graph.get(2).add(1);
        graph.get(2).add(3);

        graph.get(3).add(1);
        graph.get(3).add(2);

        graph.get(4).add(0);

        bfsTraversal(graph,4);
        System.out.println();
        dfsTraversal(graph,4);
    }
}


//                 3
//      0-----1    |
//      |          2
//      4

// 4-> 4 0 1 3 2
// 4-> 4 0 1 3 2