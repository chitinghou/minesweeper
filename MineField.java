// Name:Chi ting, Hou
// USC NetID:chitingh
// CS 455 PA3
// Fall 2023


/** 
   MineField
      Class with locations of mines for a minesweeper game.
      This class is mutable, because we sometimes need to change it once it's created.
      Mutators: populateMineField, resetEmpty
      Includes convenience method to tell the number of mines adjacent to a location.
 */

import java.util.*;

public class MineField {
   
   // <put instance variables here>
   boolean[][] mineData;
   int row_length = 0;
   int col_length = 0;
   int numMines = 0;
   
   /**
      Create a minefield with same dimensions as the given array, and populate it with the mines in
      the array such that if mineData[row][col] is true, then hasMine(row,col) will be true and vice
      versa.  numMines() for this minefield will corresponds to the number of 'true' values in 
      mineData.
      @param mineData  the data for the mines; must have at least one row and one col,
                       and must be rectangular (i.e., every row is the same length)
    */
   public MineField(boolean[][] mineData) {
      this.row_length = mineData.length;
      this.col_length = mineData[0].length;
      this.mineData = new boolean[this.row_length][this.col_length];
      
      for(int i=0; i<this.row_length; i++){
         for(int j=0; j<this.col_length; j++){
            this.mineData[i] = Arrays.copyOf(mineData[i], this.col_length);
            if(this.mineData[i][j]){
               this.numMines++;
            }
         }
      }
   }
   
   
   /**
      Create an empty minefield (i.e. no mines anywhere), that may later have numMines mines (once 
      populateMineField is called on this object).  Until populateMineField is called on such a 
      MineField, numMines() will not correspond to the number of mines currently in the MineField.
      @param numRows  number of rows this minefield will have, must be positive
      @param numCols  number of columns this minefield will have, must be positive
      @param numMines   number of mines this minefield will have,  once we populate it.
      PRE: numRows > 0 and numCols > 0 and 0 <= numMines < (1/3 of total number of field locations). 
    */
   public MineField(int numRows, int numCols, int numMines) {
      this.row_length = numRows;
      this.col_length = numCols;
      this.numMines = numMines;
      this.mineData = new boolean[numRows][numCols];
   }
   

   /**
      Removes any current mines on the minefield, and puts numMines() mines in random locations on
      the minefield, ensuring that no mine is placed at (row, col).
      @param row the row of the location to avoid placing a mine
      @param col the column of the location to avoid placing a mine
      PRE: inRange(row, col) and numMines() < (1/3 * numRows() * numCols())
    */
   public void populateMineField(int row, int col) {
      
      for(int i = 0; i<this.row_length; i++){
         for(int j = 0; j<this.col_length; j++){
            mineData[i][j] = false;
         }
      }
      
      int mines = numMines;
      int max = row_length-1;
      int min = 0;
      while(mines > 0){
         Random rand = new Random();
         int pickRow = rand.nextInt(max - min + 1) + min;
         int pickCol = rand.nextInt(max - min + 1) + min;
         if(this.mineData[pickRow][pickCol] != true &&  pickRow != row && pickCol != col){
            this.mineData[pickRow][pickCol] = true;
            mines -- ;
         }
         
      }
   }
   
   
   /**
      Reset the minefield to all empty squares.  This does not affect numMines(), numRows() or
      numCols().  Thus, after this call, the actual number of mines in the minefield does not match
      numMines().  
      Note: This is the state a minefield created with the three-arg constructor is in at the 
      beginning of a game.
    */
   public void resetEmpty() {
      this.mineData = new boolean[this.row_length][this.col_length];
   }

   
  /**
     Returns the number of mines adjacent to the specified location (not counting a possible 
     mine at (row, col) itself).
     Diagonals are also considered adjacent, so the return value will be in the range [0,8]
     @param row  row of the location to check
     @param col  column of the location to check
     @return  the number of mines adjacent to the square at (row, col)
     PRE: inRange(row, col)
   */
   public int numAdjacentMines(int row, int col) {
      int count = 0;
      for(int i = row-1; i<row+2; i++){
         for(int j = col-1; j<col+2; j++){
            if(i >= 0 && j>= 0 && i<row_length && j<col_length){
               if(mineData[i][j] == true && (i != row || j != col)){
                  count++;
               }
            }
         }
      }
      return count;       // DUMMY CODE so skeleton compiles
   }
   
   
   /**
      Returns true iff (row,col) is a valid field location.  Row numbers and column numbers
      start from 0.
      @param row  row of the location to consider
      @param col  column of the location to consider
      @return whether (row, col) is a valid field location
   */
   public boolean inRange(int row, int col) {
      return(row>=0 && col>=0 && row<row_length && col<col_length);       // DUMMY CODE so skeleton compiles
   }
   
   
   /**
      Returns the number of rows in the field.
      @return number of rows in the field
   */  
   public int numRows() {
      return this.row_length;       // DUMMY CODE so skeleton compiles
   }
   
   
   /**
      Returns the number of columns in the field.
      @return number of columns in the field
   */    
   public int numCols() {
      return this.col_length;       // DUMMY CODE so skeleton compiles
   }
   
   
   /**
      Returns whether there is a mine in this square
      @param row  row of the location to check
      @param col  column of the location to check
      @return whether there is a mine in this square
      PRE: inRange(row, col)   
   */    
   public boolean hasMine(int row, int col) {
      return this.mineData[row][col];       
   }
   
   
   /**
      Returns the number of mines you can have in this minefield.  For mines created with the 3-arg
      constructor, some of the time this value does not match the actual number of mines currently
      on the field.  See doc for that constructor, resetEmpty, and populateMineField for more
      details.
      @return number of mines
    */
   public int numMines() {
      return this.numMines;       
   }

   public String toString() {
      StringBuilder str = new StringBuilder();
      str.append("\n");
      for(int i = 0; i<this.row_length; i++){
         for(int j = 0; j<this.col_length; j++){
            if(mineData[i][j]){
               str.append("1 ");
            }else{
               str.append("0 ");
            }
         }
         str.append("\n");
      }
    return str.toString();  
   }
   // <put private methods here>
   
         
}

