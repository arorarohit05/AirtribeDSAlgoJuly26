public class BasicRecursion {

    // 5
    // 4 -> 5

    public static void print(int n){

        if(n == 0){
            return;
        }

        print(n-1);// changing my state

        System.out.print(n + " ");
    }

    public static void printDifferent(int n){
        if(n == 0){
            return;
        }

        System.out.print(n + " ");
        printDifferent(n-1);// changing my state
        System.out.print("X" + " ");
        // no print - no business logic
    }

    // -1*
    // 0 - 1
    // 1-1
    // 5 - >5*4*3*2*1 = 120
    public static int factorial(int n){

        if(n == 0 || n == 1){
            return 1;
        }
        return n*factorial(n-1);

    }

    public static int sum(int n){
        if(n==1){
            return 1;
        }
        return n+sum(n-1);
    }

    // f5 ->  5+f4 -> 3+f2 => 2+f1

  //120  // 5*24 -> 4*6 -> 3*2 -> 2*1 ->1

    // factyorial(5)      factorial(4) = x

    public static String reverseString(String str){

        if(str.length() == 1){
            return str;
        }
        return reverseString(str.substring(1)) + str.charAt(0);
    }
    // reverse("abcd") -> reverse("bcd") + 'a'

    // 100 chars  - [99 chars string] + first char
    //               [ 98]+ first stting


    // rohit
    //     tihor
    //
    //
    //
    //

    static void main() {
        print(5); // print 1 to n

        System.out.println();

        printDifferent(5); //print n to 1


        System.out.println();

        System.out.println(factorial(5));


        System.out.println(sum(5)); // 1 to n

        System.out.println(reverseString("rohit"));   // tihor
    }
}

// main -> 19 func
//         20

//
  //    recrusive - return back to next line from where it got called
