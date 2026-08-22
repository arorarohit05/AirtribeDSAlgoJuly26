import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

// 0 1 2 3 4 5 6 7
// a b c b a b a b
//       r


// left 2
// max = 3
// hs = [ c b]


public class MaxLenSubstringNoRepeat {

    // hvbefjvbfhjvbhfvj
    // l                r

    // length of string n
    //
    public static int maxLength(String str){
        Set<Character> hs = new HashSet<>();

        int left = 0 ;
        int maxLength = 0;
        // start, end

        for(int right=0;right<str.length();right++){ // expand
            char currentChar = str.charAt(right);

            // keep removing from left pointer [keep shrinking]  and removing from hashset - until hs doesnt contain that element
           while(hs.contains(currentChar)){
               hs.remove(str.charAt(left));
               left++; // shrink
           }
            hs.add(currentChar);
            maxLength = Math.max(maxLength,right-left+1);

        }

        // substring (start,end)

        return maxLength;

    }

    //  abc  b

    // cb  max = 3

    //   0 -------------n

    //     d
    //      left right

    // twice - enpansaion , shrinking

    static void main() {
        Scanner sc = new Scanner(System.in);
        String str  = sc.next();

        System.out.println(maxLength(str));
    }
}
