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
   boolean turn = true;
   
   //do while loop for game continuing until done
   do
   {
   
   System.out.println("Where do you want to move?");  //ask for move
   String userString = scanner.nextLine();            //scans in user input for move
   int userInt = Integer.parseInt(userString);        //parses String into Int
   turn = gb.inputBoard(userInt,turn);                //input user input
   
   }while(!done);
   
    
   }   
}