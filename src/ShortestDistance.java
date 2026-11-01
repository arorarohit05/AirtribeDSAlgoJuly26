import java.util.*;

public class ShortestDistance {

    // represennt edge from 1 node to another node with given weight
    static class Edge{
        int destination;
        int weight;

        Edge(int destination, int weight){
            this.destination = destination;
            this.weight  = weight;
        }
    }

    // represent a node and its current distance
    static class State{
        int node;
        int distance;

        State(int node, int distance){
            this.node = node;
            this.distance = distance;
        }
    }

    // neightbour, min ditance
    static int[] dijkstra(List<List<Edge>> graph, int source){
        int n = graph.size();
        int[] distance = new int[n];

        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[source] = 0;

        // smallest distance will remain at the top
        PriorityQueue<State> pq = new PriorityQueue<>(
                Comparator.comparingInt(state-> state.distance)
        );

        // 4,9
        // 4,6



        pq.offer(new State(source,0));

        while(!pq.isEmpty()){
            State current = pq.poll();

            int node = current.node;
            int currentDistance = current.distance;

            // 4,6
            // 4,9
            // 4,12
            if(currentDistance > distance[node]){ // optimization
                continue;
            }

            // 4, 9

            // 1  2  5 = 13

            //

            for(Edge edge:graph.get(node)){
                int neighbour = edge.destination;
                int weight = edge.weight;

                int newDistance = currentDistance+weight;
                if(newDistance < distance[neighbour]){
                    distance[neighbour] = newDistance;
                    pq.offer(new State(neighbour,newDistance));
                }
            }

        }


        return distance;
    }


    static void main() {
        int n = 4;
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Undirected weighted graph.

        graph.get(0).add(new Edge(1, 4));
        graph.get(0).add(new Edge(2, 1));

        graph.get(1).add(new Edge(0, 4));
        graph.get(1).add(new Edge(2, 2));
        graph.get(1).add(new Edge(3, 1));

        graph.get(2).add(new Edge(0, 1));
        graph.get(2).add(new Edge(1, 2));
        graph.get(2).add(new Edge(3, 5));

        graph.get(3).add(new Edge(1, 1));
        graph.get(3).add(new Edge(2, 5));

        int[] distances = dijkstra(graph, 0); // [ , , , ]  from 0 to all nodes minimum
        System.out.println(Arrays.toString(distances));
    }
}

//   0-> [[1,4],[2,1]]
//  1-.> [0,4],[2,2][3,1]
// 2 -> 0,1  1,2   3,5
// 3-> 1,1   2,5

//    0----4------1
//    |          |
//   1 |   2     1  |
//    |          |
//    2-----5-----3


// 0 ---------- 1
//        -5

// [-20, -15]

// 1,-5

// bellmand ford...