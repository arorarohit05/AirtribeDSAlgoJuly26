public class WordSearch {

    public static boolean recursiveSearch(char[][] board, String word,
                                          int row, int col, int index,
                                          boolean[][] visited){

        //base case : end my recursion // found word
        if(index == word.length()){
            return true;
        }

        // pruning condition 2 - out of bound
        if(row<0 || col <0 || row >= board.length || col >= board[0].length){
            return false;
        }

        // pruning condition 3 - already visited
        if(visited[row][col]){
            return false;
        }

        // Pruning condition 1 // wrong character
        if(board[row][col] != word.charAt(index)){
            return false;
        }



        // ABCCEF
        //       6

        // choose
        visited[row][col] = true;

        // A -> B
        //  E <- C
        //  A
        // exploring

        // index+1
        // ++index

        // inex++
        boolean found =
            recursiveSearch(board,word,row-1,col,index+1,visited) ||
            recursiveSearch(board,word,row+1,col,index+1,visited) ||
            recursiveSearch(board,word,row,col-1,index+1,visited)  ||
            recursiveSearch(board,word,row,col+1,index+1,visited);

        // undo
        visited[row][col] = false;

        return found;
    }

    //   <-  A -> B -> C ->


    // A || b||c

    //                | x--,y
    //   x,y--  <-   x,y -> x , y++
    //                 | x++,y

    public static boolean searchWord(char[][] board, String word){
        int rows = board.length;
        int cols = board[0].length;

        boolean[][] visited = new boolean[rows][cols];

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                // final recursive call
                if(recursiveSearch(board,word,i,j,0,visited)){
                    return true;
                }
            }
        }

        // starting from 1 char
        // explouyre all driection -> explre all path
        // go to next chaar

        // row, columns, indexstring

        return false;
    }

    static void main() {

        char[][] board = {{'A','B','C','E'},
                          {'S','F','C','S'},
                          {'G','D','E','E'},
        };



        String word = "ABFSA";

        System.out.println(searchWord(board, word));
    }
}
