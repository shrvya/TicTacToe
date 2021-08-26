package tictactoeproject;

public class Tictactoe {

	static char[] board = new char[10];
   /*
    * this method will initialize board elements to space
    * ignores oth index
    */
	public static void initialize()
	  {
		
		board[0]='\0';
		int length=board.length;
		
		for(int i=1;i<length;i++)
		{ 
			board[i]=' ';
			
		}
	  }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        System.out.println("Welcome to tic tac toe");
        initialize();
	}

}
