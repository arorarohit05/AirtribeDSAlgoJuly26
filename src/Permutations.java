import java.util.ArrayList;
import java.util.List;

public class Permutations {

    //used [F F F]
    //nums [1,2,3]
    //      0 1 2

    static List<List<Integer>> permutations(int nums[]){
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        recursivePermutations(nums, used, new ArrayList<>(), result);
        return result;
    }

    public static void recursivePermutations( int nums[],
             boolean[] used,List<Integer> currentPath, List<List<Integer>> result){

        // base case
        if(currentPath.size() == nums.length){
            result.add(new ArrayList<>(currentPath));
            return;
        }

        // 1 2 3
        // T T F
        for(int i=0; i<nums.length;i++){ // 1 2 3
            if(used[i] == true){
                continue;
            }

            // choose and fixed 1 element
            currentPath.add(nums[i]);
            used[i] = true;

            // explore further
            recursivePermutations(nums,used,currentPath,result);

            // undo  and choose other elements
            currentPath.remove(currentPath.size()-1);
            used[i] = false;
        }

    }

    // currentpath = [1 [3 ,2 ]]

    // 1 2 3
    // 1 3 2
    // 2 1 3
    // 2 3 1
    // 3 1 2
    // 3 2 1

    //used [T F T]
    //nums [1,2,3]
    //      0 1 2

    static void main() {
        int arr[] = {1,2,3,4};
        List<List<Integer>> result = permutations(arr);
        System.out.println(result);
    }
}
