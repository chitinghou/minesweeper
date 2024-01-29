public class MineFieldTester {

    public static void main(String[] args) {
        // Test case 1: Creating a MineField with predefined mine data
        boolean[][] mineData = {
            {false, true, false},
            {true, false, true},
            {false, true, false}
        };
        MineField mineField1 = new MineField(mineData);
        
        System.out.println("Test Case 1: Creating a MineField with predefined mine data");
        System.out.println("Initial MineField:" + mineField1);
        //printMineField();

        // Test case 2: Creating an empty MineField and populating it with mines
        MineField mineField2 = new MineField(9, 9, 30); // 3x3 field with 4 mines
        mineField2.populateMineField(1, 1); // Avoid placing a mine at (1, 1)

        System.out.println("\nTest Case 2: Creating an empty MineField and populating it with mines");
        System.out.println("MineField after populating with mines:"  + mineField2);
       
       // Test case 3: Testing the number of adjacent mines

        System.out.println("\nTest Case 3: Testing the number of adjacent mines");
        //System.out.println("MineField:" + mineField2);

        int row = 1;
        int col = 1;
        int numAdjacentMines = mineField2.numAdjacentMines(row, col);
        int numAdjacentMines2 = mineField2.numAdjacentMines(2, 5);
        int numAdjacentMines3 = mineField2.numAdjacentMines(7, 3);
        System.out.println("Number of adjacent mines at (" + row + ", " + col + "): " + numAdjacentMines);
          System.out.println("Number of adjacent mines at (2, 5) " + numAdjacentMines2);
          System.out.println("Number of adjacent mines at (7, 3) " + numAdjacentMines3);

       
       // Test case 5: Testing the inRange() method
        System.out.println("\nTest Case 5: Testing the inRange() method");
        int testRow = 2;
        int testCol = 3;
        boolean inRangeResult = mineField2.inRange(testRow, testCol);
        System.out.println("(" + testRow + ", " + testCol + ") is in range: " + inRangeResult);
       
        testRow = 8;
        testCol = 9;
        inRangeResult = mineField2.inRange(testRow, testCol);
        System.out.println("(" + testRow + ", " + testCol + ") is in range: " + inRangeResult);

        // Test case 6: Testing the numRows() and numCols() methods
        System.out.println("\nTest Case 6: Testing the numRows() and numCols() methods");
        int numRows = mineField2.numRows();
        int numCols = mineField2.numCols();
        System.out.println("Number of rows: " + numRows);
        System.out.println("Number of columns: " + numCols);

        // Test case 7: Testing the hasMine() method
        System.out.println("\nTest Case 7: Testing the hasMine() method");
        int testHasMineRow = 2;
        int testHasMineCol = 2;
        boolean hasMineResult = mineField2.hasMine(testHasMineRow, testHasMineCol);
        System.out.println("(" + testHasMineRow + ", " + testHasMineCol + ") has a mine: " + hasMineResult);

        // Test case 8: Testing the numMines() method
        System.out.println("\nTest Case 8: Testing the numMines() method");
        int numMines = mineField2.numMines();
        System.out.println("Number of mines in the MineField: " + numMines);
       
       // Test case 4: Resetting an empty MineField to all empty squares
        mineField2.resetEmpty();

        System.out.println("\nTest Case 4: Resetting an empty MineField");
        System.out.println("MineField after resetting:" + mineField2);
    }
}
