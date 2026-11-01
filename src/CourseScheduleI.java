import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 0 -> [1]
// 1 -> [0]

public class CourseScheduleI {

    public static boolean canFinish(int numCourses, int[][] prerequisites){
        List<List<Integer>> graph = new ArrayList<>(); // to store as adjacnecy list
        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }

        int[] indegree = new int[numCourses]; // store the indegrees
        // [1,1]

        // prerequisite [cource , prerequisite course]    [0,1]  = 1->0

        // 1,0
        for(int[] prerequisite : prerequisites){
            int course = prerequisite[0]; //1
            int preC = prerequisite[1]; // 0

            graph.get(preC).add(course);
            indegree[course]++;// calculating indegress
        }

        // graph and indegrees are ready


        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                queue.add(i);
            }
        }

        // 0 ->1->2->3->4->2
        //2->1
        //3->1
        //4->1

        // queue =[]

        // processed =2
        // num =5

        int processedCources = 0;
        while(!queue.isEmpty()){
            int course = queue.poll();
            processedCources++;
            // add to ordering


            // 0 -> 1
            // 0->2
            // 0->3
            // remove this node outgoing edges
            for(int i:graph.get(course)){
                indegree[i]--;

                if(indegree[i] == 0){
                    queue.add(i);
                }
            }
        }

        return processedCources == numCourses;
    }


    public static int[] finishOrder(int numCourses, int[][] prerequisites){
        List<List<Integer>> graph = new ArrayList<>(); // to store as adjacnecy list
        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }

        int[] indegree = new int[numCourses]; // store the indegrees
        // [1,1]

        // prerequisite [cource , prerequisite course]    [0,1]  = 1->0

        // 1,0
        for(int[] prerequisite : prerequisites){
            int course = prerequisite[0]; //1
            int preC = prerequisite[1]; // 0

            graph.get(preC).add(course);
            indegree[course]++;// calculating indegress
        }

        // graph and indegrees are ready


        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                queue.add(i);
            }
        }

        // 0 ->1->2->3->4->2
        //2->1
        //3->1
        //4->1

        // queue =[]

        // processed =2
        // num =5

        int [] result = new int[numCourses];
        int index = 0; //

        // [0,0,0,0,0]
        //  0 1 2 3 4
        while(!queue.isEmpty()){
            int course = queue.poll();
            result[index++] = course;
            // add to ordering


            // 0 -> 1
            // 0->2
            // 0->3
            // remove this node outgoing edges
            for(int i:graph.get(course)){
                indegree[i]--;

                if(indegree[i] == 0){
                    queue.add(i);
                }
            }
        }

        //  0 1 2 3 4
        // [0,0,0,0,0]
        //      i
        if(index!=numCourses){
            return new int[0];
        }
        return result;
    }

     //2
    // ^
    //|

    //        0 ->1->2->3->4
    static void main() {
        int numCourses = 5;   // 0 1 2 3 4
        int[][] prerequisites = { // edges
                                    {1,0},
                {2,1},
                {3,2},
                {4,3},
                //{2,4}
                                };

        System.out.println(canFinish(numCourses,prerequisites));

        int[] order = finishOrder(numCourses,prerequisites);
        for(int i=0;i<order.length;i++){
            System.out.print(i+" ");
        }
    }
}

// is it possible?? -> cycle detection

// Course schedule || -> if the course scehdueling is possible , give me an order for student to lear
// topologcval sort...


// 4
//  1,0   2,0    3,1   3,2

//     1
// 0->     ->3
//      2

// 0 1 2 3

