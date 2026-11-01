public class NoOfIslands {

//
    //   <-x,y ->

    // 4   0 1 2 3
    public static void dfs(char[][] grid, int row , int col){

        if(row<0 || row >=grid.length
            || col<0 || col>=grid[0].length){
            return;
        }

        if(grid[row][col] == '0'){
            return;
        }

        grid[row][col] = '0';// marking them water

        dfs(grid, row,col+1); // dfs
        dfs(grid, row,col-1);
        dfs(grid, row-1,col);
        dfs(grid, row+1,col);
    }


    //                         {'0'->'0''0','0','0'}
    //                         {'0','0','0','0','0'}
    //                         {'0','0','1','0','0'}
    //                         {'0','0','0','0','0'}
    //   here
    //   [0,0] land -> -> -> -> out of bound
    // '0','0','0','0','0'  index

    public static int noOfIslands(char[][] grid){
        int rows = grid.length;// n
        int cols = grid[0].length;// m
        int islands = 0;

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j] == '1'){
                    islands++;//3
                    dfs(grid,i,j);
                }
            }
        }
        return islands;
    }
    // find our no of disconnected componenets in  my grid/graph

    static void main() {
        char[][] grid = {{'1','1','0','0','0'},
                         {'1','1','0','0','0'},
                         {'0','0','1','0','0'},
                         {'0','0','0','1','1'}};

        System.out.println(noOfIslands(grid));
    }
}

// O(r*c)
// O(r*c)


// rotten oranges