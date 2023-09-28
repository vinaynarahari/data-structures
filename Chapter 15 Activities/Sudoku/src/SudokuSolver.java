import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class SudokuSolver {
    private final int M = 3;
    private final int N = M * M;
    private int[][] grid;
    private ArrayList<Set<Integer>> rows;
    private ArrayList<Set<Integer>> cols;
    private ArrayList<Set<Integer>> squares;
    private Set<Integer> nums;

    public SudokuSolver(String fileName) {
        // read the puzzle file
        this.grid = new int[N][N];
        this.rows = new ArrayList<Set<Integer>>();
        this.cols = new ArrayList<Set<Integer>>();
        this.squares = new ArrayList<Set<Integer>>();
        try (Scanner in = new Scanner(new File("Chapter 15 Activities/Sudoku/src/puzzle1.txt"))) {
            for (int row = 0; row < N; row++) {
                String line = in.next();

                for (int col = 0; col < N; col++) {
                    String value = line.substring(col, col + 1);
                    int number;
                    if (value.equals("x")) {
                        number = 0;
                    } else {
                        number = Integer.parseInt(value);
                    }
                    this.grid[row][col] = number;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Cannot open: " + fileName);
        }

        // create the list of sets for each row (this.rows)
        for(int row = 0; row < N; row++)
        {
            Set<Integer> row1 = new TreeSet<>();
            for(int col = 0; col < N; col++)
            {
                row1.add(this.grid[row][col]);
            }
            this.rows.add(row1);
        }

        // create the list of sets for each col (this.cols)
        
        for(int col = 0; col < N; col++)
        {
            Set<Integer> col1 = new TreeSet<>();
            for(int row = 0; row < N; row++)
            {
                col1.add(this.grid[row][col]);
            }
            this.cols.add(col1);
        }

        // create the list of sets for each square (this.squares)
        /* the squares are added to the list row-by-row:
            0 1 2
            3 4 5
            6 7 8
         */
        for (int i = 0; i<N;i++){
            this.squares.add(new HashSet<Integer>());
        }
        
        //Creates based on index
        for (int i = 0; i < M; i++)
        {
            for (int j = 0; j < M; j++)
            {
                this.squares.get((i/M)*M + (j/M)).add(this.grid[i][j]);
            }
        }


        // create a hash set for [1..9] (this.nums)
        this.nums = new HashSet<>();
        for(int i = 1; i<=9; i++)
        {
            this.nums.add(i);
        }

        // visually inspect that all the sets are correct
        for (int row = 0; row < N; row++) {
            System.out.println(this.rows.get(row) + "- Row: " + row);
        }
        for (int col = 0; col < N; col++) {
            System.out.println(this.rows.get(col) + "-  Column: " + col);
        }
        for (int square = 0; square < N; square++) {
            System.out.println(this.rows.get(square) + "- Square: " + square);
        }
        System.out.println(this.nums);
    }

    public boolean solve() {
        // find an empty location, if any
        int nextRow = -1;
        int nextCol = -1;
        boolean finished = true;
        for (int row = 0; row < N && finished; row++) {
            for (int col = 0; col < N && finished; col++) {
                if (this.grid[row][col] == 0) {
                    finished = false;
                    nextRow = row;
                    nextCol = col;
                }
            }
        }

        // the board is complete; we solved it
        if (finished) {
            return true;
        }

        // get all possible numbers for the row and column we are trying to populate
        /*
            Create a new set based on the this.nums and remove all elements in the sets
            corresponding to nextRow, nextCol, and the corresponding square (use the
            removeAll method).

            Properly indexing the squares list of sets is tricky. Verify that your
            algorithm is correct.
         */
        int grid = -1;

        Set<Integer> possibleNums = new HashSet<Integer>();
        possibleNums.addAll(this.nums);
        
        possibleNums.removeAll(this.rows.get(nextRow)); 
        possibleNums.removeAll(this.cols.get(nextCol));
        if (nextRow < 3){
            if(nextCol/3 == 0){
                    grid = 0;
            }else if(nextCol/3 == 1){
                    grid = 1;
            }else if(nextCol/3 == 2){
                    grid = 2;
            }      
         } else if (nextRow < 6){
            if(nextCol/3 == 0){
                    grid = 0;
            }else if(nextCol/3 == 1){
                    grid = 1;
            }else if(nextCol/3 == 2){
                    grid = 2;
            } 
        } else {
            if(nextCol/3 == 0){
                    grid = 0;
            }else if(nextCol/3 == 1){
                    grid = 1;
            }else if(nextCol/3 == 2){
                    grid = 2;
            } 
        }

        // if there are no possible numbers, we cannot solve the board in its current state
        if (possibleNums.isEmpty()) {
            return false;
        }

        // try each possible number
        for (Integer possibleNum : possibleNums) {
            // update the grid and all three corresponding sets with possibleNum
            this.grid[nextRow][nextCol] = possibleNum;
            this.rows.get(nextRow).add(possibleNum);
            this.cols.get(nextCol).add(possibleNum);
            this.squares.get(grid).add(possibleNum);


            // recursively solve the board
            if (this.solve()) {
                // the board is solved!
                return true;
            } else {
                /*
                 Undo the move before trying another possible number by setting the corresponding
                 element in the grid back to 0 and removing possibleNum from all three corresponding
                 sets.
                 */
                this.grid[nextRow][nextCol] = 0;
                this.rows.get(nextRow).remove(possibleNum);
                this.cols.get(nextCol).remove(possibleNum);
                this.squares.get(grid).remove(possibleNum);
            }
        }

        return false;
    }

    public String toString() {
        String str = "";

        for (int[] row : grid) {
            for (int val : row) {
                str += val + "\t";
            }

            str += "\n";
        }

        return str;
    }

    public static void main(String[] args) {
        String fileName = "Chapter 15 Activities\\Sudoku\\src\\puzzle1.txt";

        SudokuSolver solver = new SudokuSolver(fileName);
        System.out.println(solver);
        if (solver.solve()) {
            System.out.println("Solved!");
            System.out.println(solver);
        } else {
            System.out.println("Unsolveable...");
        }
    }
}