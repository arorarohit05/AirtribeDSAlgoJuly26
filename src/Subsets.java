import java.util.ArrayList;
import java.util.List;

public class Subsets {

    static List<List<Integer>> subsets(int nums[]){
        List<List<Integer>> result = new ArrayList<>();
        recursiveSubsets(0,nums,new ArrayList<>(),result);
        //                         current answer till now
        return result;
    }

    // 1 2 3

    // currentpath = 1 2

    // resutl  [currentpath 1 2 ]
    public static void recursiveSubsets(int index,int nums[],List<Integer> currentPath, List<List<Integer>> result){

        // basecase
        if(index == nums.length){
            result.add(new ArrayList<>(currentPath));// new list
            return;
        }


        // choice 1
        currentPath.add(nums[index]);
        recursiveSubsets(index+1, nums, currentPath,result);

        // choice 2
        currentPath.remove(currentPath.size()-1); // index // UNDO
        recursiveSubsets(index+1,nums,currentPath,result); // another path

    }


    /* IMPORTANT - OVERALL BACKTRACKING

    for(each choice)
    {
    makechoice();

    RECURSIVE(NEXT STATE);

    UNDOCHOICE();
    }



    */

    // 1 2 3 - add
    // 1 2 s - add

    // 1 s 3 - 1 3
    // 1 s s  1

    // s 2 3 - 2 3
    // s 2 s  2

    // s s 3  - 3
    // s s s   -[]

    // 123
    // 12

    //   1          12       12





    //    0 1 2
    //   [1 2 3]

    //    currentpath = []

    //    choice 1                                    |        choice 2
    //   currentpath [1] + next call 1                        currentpath + next cal 1

    static void main() {
        int arr[] = {1,2,3};
        List<List<Integer>> result = subsets(arr);
        System.out.println(result);
    }
}
