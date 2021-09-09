public class GameBoard
{
   //Column Counter to see how many
   //spaces are left in the Column
   int column1;
   int column2;
   int column3;
   int column4;
   int column5;
   int column6;
   int column7;
   
   //Squares that make of the Gameboard
   String[][] board;
   
   /*********************************
   *  * Contructor for Gameboard *  *
   **********************************/
   public GameBoard()
   {
   column1 = 6;   //Starts on the bottom row
   column2 = 6;   //Therefore I will be
   column3 = 6;   //Subtracting the nunmbers
   column4 = 6;   //when an input is made
   column5 = 6;   //These numbers keep track of
   column6 = 6;   //The column's capacity
   column7 = 6;   
   
   //insantiate Dub Array, 7x7
   board = new String[7][7];
   
   //input asterisk at every cell of dub Array
   for(int i = 0; i < 7; i++)
      for(int j = 0; j < 7; j++)
         board[i][j]=" * ";  
   }
   
   
   
   /************************
   *  * Print GameBoard *  *
   *************************/
   public void printBoard()
    {
      for(int i = 0; i < 7; i++)
      {
         for(int j = 0; j < 7; j++)
         {
            System.out.print(this.board[i][j]); 
         }
         System.out.println();
      }
      System.out.println("--------------------");
    }
   
   
   
   /***************************************************
   *  *  *  *  *  *  *  Clean board *  *  *  *  *  *  *
   *Function to create dub array with asterisks again**    
   ****************************************************/
   public void clearBoard()
   {
      for(int i = 0; i < 7; i++)
         for(int j = 0; j < 7; j++)
            this.board[i][j]=" * "; 
   }
   
   
   
   /******************************************
   *  Function to input player play on Board *
   *******************************************/
   public boolean inputBoard(int columnInput, boolean turn)
   {
       int colNum = this.column1;
       columnInput--;
       
       //make sure only 1 - 7(0,6) can be inputted
       if(columnInput >= 0 && columnInput < 7)
       {
          //let colNum be the number to count for column capacity
          if(columnInput == 0)
            colNum = this.column1;
          else if(columnInput == 1)
            colNum = this.column2;
          else if(columnInput == 2)
            colNum = this.column3;
          else if(columnInput == 3)
            colNum = this.column4;
          else if(columnInput == 4)
            colNum = this.column5;
          else if(columnInput == 5)
            colNum = this.column6;
          else if(columnInput == 6)
            colNum = this.column7; 
          
          //if statement will check capacity of the column
          if(colNum < 0)
            {
            System.out.println("There is no more room in the column. \nPlease enter a valid move.");
            return turn;   //return turn when invalid move
            }
          //if there is capacity then it will input valid move
          else
          {
         //iterate through board grid
            for(int i = 0; i < 7; i++)
            {
               for(int j = 0; j < 7; j++)
               {
                  if(columnInput == j && colNum == i) //will find the right column(columnInput/j) and row(colNum/i)
                  {
                     
                     if(turn)                      //true when player 1 move
                        this.board[i][j] = " 1 ";
                     else                          //false when player two move
                        this.board[i][j] = " 2 ";
                     
                     //Subtract Column number, so we know what row the next number will be
                     if(columnInput == 0)
                        this.column1--;
                     else if(columnInput == 1)
                        this.column2--;
                     else if(columnInput == 2)
                        this.column3--;
                     else if(columnInput == 3)
                        this.column4--;
                     else if(columnInput == 4)
                        this.column5--;
                     else if(columnInput == 5)
                        this.column6--;
                     else if(columnInput == 6)
                        this.column7--;             
                  }
               }
            }//end of for loop to interate board grid
            
            //This will print the state of the board after every new input
            this.printBoard();
            
         }//end of conditional else for a valid move
         return !turn; //return opposite of trun if there is a valid move
      }//end of if statement for 1 - 7 inclusive
      
      
      else
      {
         System.out.println("Please input a number between 1 and 7. \nPlease enter a valid move.");
         return turn;
      }
   }
}