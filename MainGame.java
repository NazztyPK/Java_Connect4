import java.util.Scanner;  // Import the Scanner class

class MainGame 
{
   public static void main(String[] args) 
   {
   
      int i = 0;
      
      //create scanner object
      Scanner scanner = new Scanner(System.in);  
      
      //create GameBoard Object
      GameBoard gb = new GameBoard();
      gb.printBoard();
      
      //boolean to see if the game is done
      boolean done = false;
      
      //boolean to see who's turn it is
      //TRUE = P1
      //FALSE = P2
      boolean turn = true;
      
      //do while loop for game continuing until done
      do
      {
           
      //Tells player whose turn it is
      //TRUE = P1, FALSE P2
      if(turn)
         System.out.println("Player 1's Turn");
      else
         System.out.println("Player 2's Turn");
      
      System.out.println("Where do you want to move?");  //ask for move
      String userString = scanner.nextLine();            //scans in user input for move
      int userInt = Integer.parseInt(userString);        //parses String into Int
      turn = gb.inputBoard(userInt,turn);                //input user input, here turn becomes the opposite of whoever just went
      
      done = checkGame(gb, done, turn);
         
      }while(!done);
   
    
   }   
   
   public static boolean checkGame(GameBoard gb, boolean done, boolean turn)
   {
      //Initialize player string for 1 and 2
      String player = "";
      
      if(!turn)          //if player 1, player is 1, has to !turn because it is the opposite
         player = " 1 ";
      else              //else player 2, player is 2, turn
         player = " 2 ";
      
      //Check Across
      for(int i = 0; i < 7; i++)
         for(int j = 0; j < 4; j++)
            if (gb.board[i][j] == player   && 
					gb.board[i][j+1] == player &&
					gb.board[i][j+2] == player &&
					gb.board[i][j+3] == player)
					{
                  done = true;
                  System.out.println("Player" + player + "you have Won!!");
               }
      
      //Check vertical
      for(int i = 0; i < 4; i++)
         for(int j = 0; j < 7; j++)
            if (gb.board[i][j] == player   && 
					gb.board[i+1][j] == player &&
					gb.board[i+2][j] == player &&
					gb.board[i+3][j] == player)
					{
                  done = true;
                  System.out.println("Player" + player + "you have Won!!");
               }
               
      //Check up diagnol
      for(int i = 0; i < 7; i++)
         for(int j = 0; j < 4; j++)
            if (gb.board[i][j] == player   && 
					gb.board[i-1][j+1] == player &&
					gb.board[i-2][j+2] == player &&
					gb.board[i-3][j+3] == player)
					{
                  done = true;
                  System.out.println("Player" + player + "you have Won!!");
               }
      
      //Down diagnol         
      for(int i = 0; i < 4; i++)
         for(int j = 0; j < 4; j++)
            if (gb.board[i][j] == player   && 
					gb.board[i-1][j+1] == player &&
					gb.board[i-2][j+2] == player &&
					gb.board[i-3][j+3] == player)
					{
                  done = true;
                  System.out.println("Player" + player + "you have Won!!");
               }
      
      return done;
   }
}