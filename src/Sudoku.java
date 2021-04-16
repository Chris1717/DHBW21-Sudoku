

class Sudoku {

    public static void main(String[] args) {

        Sudoku mySudoku = new Sudoku();

        System.out.println(mySudoku);

        //System.out.println(mySudoku.possibleEntry(0, 3, 9));

        mySudoku.solve();

        System.out.println(mySudoku);
        
    }
    
    int[][] grid = {
        {5,3,0,0,7,0,0,0,0},
        {6,0,0,1,9,5,0,0,0},
        {0,9,8,0,0,0,0,6,0},
        {8,0,0,0,6,0,0,0,3},
        {4,0,0,8,0,3,0,0,1},
        {7,0,0,0,2,0,0,0,6},
        {0,6,0,0,0,0,2,8,0},
        {0,0,0,4,1,9,0,0,5},
        {0,0,0,0,8,0,0,0,0},
    };

    // int[][] grid = {
    //     {0,3,0,0,0,0,0,0,0},
    //     {0,0,0,1,9,5,0,0,0},
    //     {0,0,8,0,0,0,0,6,0},
    //     {8,0,0,0,6,0,0,0,0},
    //     {4,0,0,8,0,0,0,0,1},
    //     {0,0,0,0,2,0,0,0,0},
    //     {0,6,0,0,0,0,2,8,0},
    //     {0,0,0,4,1,9,0,0,5},
    //     {0,0,0,0,0,0,0,7,0},
    // };

    // int[][] grid =  { 
    //     {3,0,6,5,0,0,0,0,0}, 
    //     {5,2,0,0,0,0,0,0,0},
    //     {0,8,7,0,0,0,0,3,1},
    //     {0,0,3,0,1,0,0,8,0},
    //     {9,0,0,0,6,3,0,0,5},
    //     {0,5,0,0,9,0,0,0,0},
    //     {1,3,0,0,0,0,2,5,0},
    //     {0,0,0,0,0,0,0,7,4},
    //     {0,0,5,2,0,6,3,0,0} 
    // }; 

    Sudoku() { 
    }

    Sudoku(int[][] grid) {
        this.grid = grid;
    }

    public boolean possibleEntry(int row, int column, int value) {
        for(int i = 0; i < 9; i++) {
            if(grid[row][i] == value) {
                return false;
            }
        }

        for(int j = 0; j < 9; j++) {
            if(grid[j][column] == value) {
                return false;
            }
        }

        int rowStart = (row / 3) * 3;
        int colStart = (column / 3) * 3;

        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if (grid[i+rowStart][j+colStart] == value) {
                    return false;
                }
            }
        }


        return true;
        
    }

    public void solve() {
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if (grid[i][j] == 0) {
                    for(int z = 1; z < 10; z++) {
                        if(possibleEntry(i, j, z)) {
                            grid[i][j] = z;
                            System.out.println(this);System.out.println("=================\n");
                            solve();
                            grid[i][j] = 0;
                        }               
                    }
                    return;
                }
            }
        }

        System.out.println(this);
        System.out.println("=================\n");
    }

    public String toString() {
        String out = "";
        for (int[] row : grid) {
            for (int cell : row) {
                out += (cell == 0 ? "." : cell) + " ";
            }
            out += "\n";
        }
        return out;
    }
}