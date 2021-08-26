package tictactoeproject;

import java.util.Random;
import java.util.Scanner;

public class Tictactoe {

	static int val=1;
	static char player,computer;
	static char[] board = new char[10];
	static char input,whowin;
	static int index;
	static boolean toswin,didwin;
	static int toss,tosschoice,x=0,o=0,corner=0,center;//
	static Random random=new Random();
	static Scanner sc=new Scanner(System.in);
   /*
    * this method will initialize board elements to space
    * ignores 0th index
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
	/*
	 * this method will allow player to choose input X or O
	 */
	public static void playerInput()
	{
		System.out.println("Please enter input X or O");
		input =sc.next().charAt(0);
		if(input=='X')
		{
			player=input;
			computer='O';
		}
		else {
			player=input;
			computer='X';
		}
		
	}
	/*
	 * this method will display the tictactoe board
	 */
	public static void showBoard()
	{
		System.out.println("|     |     |     |");
		System.out.println("|    "+board[1]+"|    "+board[2]+"|    "+board[3]+"|    ");
		System.out.println("---------------------");
		System.out.println("|     |     |     |");
		System.out.println("|    "+board[4]+"|    "+board[5]+"|    "+board[6]+"|    ");
		System.out.println("---------------------");
		System.out.println("|     |     |     |");
		System.out.println("|    "+board[7]+"|    "+board[8]+"|    "+board[9]+"|    ");
		
	}
	/*
	 * this method will allow the player select the index where the input is 
	 * to be displayed
	 */
	public static void selectIndex()
	{
		System.out.println("player please enter the index");
		index=sc.nextInt();
		if(isEmpty(index) && index>0 && index<10)
		{
			board[index]=player;
			val++;
			showBoard();
			
		}
		else {
			System.out.println("invalid index");
		}
	}
	/*
	 * if player wins the toss then player plays first
	 * otherwise computer plays first
	 */
	public static void tossing()
	{
		System.out.println("Head(1) or Tails(1)");
		tosschoice=sc.nextInt();
		toss=random.nextInt(2);
		if(tosschoice==toss)
		{
			System.out.println("Player won the toss.player plays first");
			toswin=true;
		}
		else {
			System.out.println("computer won the toss,computer plays first");
			toswin=false;
		}
		
	}
	/*
	 * player and computer will alternately play till all indexs are filed 
	 */
	public static void startGame()
	{
		while(val<10) {
		if(toswin)
		{
			selectIndex();
			if(val<10)
			{
				computerIndex();
			}
			
		}
		else {
			computerIndex();
			if(val<10)
			{
				selectIndex();
			}
		}
		}
		
	}
	/*
	 * this method will check if desired index if free
	 * if it is occupied the another index value has to be given
	 */
	public static boolean isEmpty(int index)
	{
		if(board[index]==' ')
		{
			return true;
		}
		else {
			return false;
		}
	}
	/*
	 * this method will see for the winning condition XXX or OOO
	 */
	public static void checkWin()
	{
		String line=null;
		for(int i=1;i<10;i++)
		{
			switch(i)
			{
			case 1:
				line = ""+board[1] + board[2] + board[3];
                break;
			case 2:
				line = ""+board[3] + board[4] + board[5];
                break;
			case 3:
				line = ""+board[6] + board[7] + board[8];
                break;
			case 4:
                line = ""+board[1] + board[4] + board[7];
                break;
            case 5:
                line = ""+board[2] + board[5] + board[8];
                break;
            case 6:
                line = ""+board[3] + board[5] + board[9];
                break;
            case 7:
                line = ""+board[1] + board[5] + board[9];
                break;
            case 8:
                line = ""+board[3] + board[5] + board[7];
                break;
			}
			if(line.equals("XXX"))
			{
				whowin='X';
				didwin=true;
				
			}
			else if(line.equals("OOO"))
			{
				whowin='O';
			    didwin=true;
			    
			}
			
		}
		
	}
	/*
	 * this method will see if there is a tie
	 */
	public static void checkTie()
	{
		for(int a=1;a<9;a++)
		{
			if(board[a]=='X')
			{	x++;
			
			}else {
				o++;
			}
				
		}
		if((x==(o+1)) || (o==(x+1)))
		{
			System.out.println("it is a tie");
		}
	}
	/*
	 * this method will display the winner
	 */
	public static void displayWinner()
	{
		
		checkWin();
		if(didwin==true) {
		if(whowin=='X')
		{
			System.out.println("Player Won");
			
		}
		else if(whowin=='O'){
			System.out.println("Computer Won");
			
		}
	}
		checkTie();
		}
	
	/*
	 * this method will give the index where computer will input
	 */
	public static void computerIndex()
	{
		index=random.nextInt(10);
		if(isEmpty(index)==true)
		{
			if(computerCanwin() || ifPlayerCanwin() )
			{
				if(isEmpty(index))
				{
			board[index]=computer;
			val++;
			showBoard();
			}
			}
			
			else{
				board[index]=computer;
				val++;
				showBoard();
				}
		}
		else {
			computerIndex();
		}
	}
	/*
	 * this method will see possibilities of computer winning
	 * and input accordingly
	 */
	public static boolean computerCanwin()
	{
			if((board[1]==computer && board[2]==computer && board[3]==' ') ||(board[7]==computer && board[5]==computer && board[3]==' ')
					||(board[9]==computer && board[6]==computer && board[3]==' '))
			{
				index=3;
				return true;
				
			}
			else if((board[2]==computer && board[3]==computer && board[1]==' ') ||(board[7]==computer && board[4]==computer && board[1]==' ')
					||(board[9]==computer && board[5]==computer && board[1]==' '))
			{
				index=1;
				return true;
				
			}
			else if((board[1]==computer && board[3]==computer && board[2]==' ') ||(board[8]==computer && board[5]==computer && board[2]==' '))
			{
				index=2;
				return true;
			}
			else if((board[1]==computer && board[7]==computer && board[4]==' ') ||(board[6]==computer && board[5]==computer && board[4]==' '))
			{
				index=4;
				return true;
			}
			else if((board[4]==computer && board[6]==computer && board[5]==' ') ||(board[2]==computer && board[8]==computer && board[5]==' '))
			{
				index=5;
				return true;
			}
			else if((board[9]==computer && board[3]==computer && board[6]==' ') ||(board[4]==computer && board[5]==computer && board[6]==' ')
					)
			{
				index=6;
				return true;
			}
			else if((board[1]==computer && board[4]==computer && board[7]==' ') ||(board[8]==computer && board[9]==computer && board[7]==' ')
					||(board[5]==computer && board[3]==computer && board[7]==' '))
			{
				index=7;
				return true;
			}
			else if((board[7]==computer && board[9]==computer && board[8]==' ') ||(board[2]==computer && board[5]==computer && board[8]==' ')
					)
			{
				index=8;
				return true;
			}
			else if((board[1]==computer && board[5]==computer && board[9]==' ') ||(board[8]==computer && board[7]==computer && board[9]==' ')
					||(board[5]==computer && board[1]==computer && board[9]==' '))
			{
				index=9;
				return true;
			}
			else 
				return false;
	}
	/*
	 * computer uses this method to see possibilities of player winning
	 * and blocks the chances of player winning
	 */
	public static boolean ifPlayerCanwin()
	{
			if((board[1]==player && board[2]==player && board[3]==' ') ||(board[7]==player && board[5]==player && board[3]==' ')
					||(board[9]==player && board[6]==player && board[3]==' '))
			{
				index=3;
				return true;
				
			}
			else if((board[2]==player && board[3]==player && board[1]==' ') ||(board[7]==player && board[4]==player && board[1]==' ')
					||(board[9]==player && board[5]==player && board[1]==' '))
			{
				index=1;
				return true;
				
			}
			else if((board[1]==player && board[3]==player && board[2]==' ') ||(board[8]==player && board[5]==player && board[2]==' '))
			{
				index=2;
				return true;
			}
			else if((board[1]==player && board[7]==player && board[4]==' ') ||(board[6]==player && board[5]==player && board[4]==' '))
			{
				index=4;
				return true;
			}
			else if((board[4]==player && board[6]==player && board[5]==' ') ||(board[2]==player && board[8]==player && board[5]==' '))
			{
				index=5;
				return true;
			}
			else if((board[9]==player && board[3]==player && board[6]==' ') ||(board[4]==player && board[5]==player && board[6]==' ')
					)
			{
				index=6;
				return true;
			}
			else if((board[1]==player && board[4]==player && board[7]==' ') ||(board[8]==player && board[9]==player && board[7]==' ')
					||(board[5]==player && board[3]==player && board[7]==' '))
			{
				index=7;
				return true;
			}
			else if((board[7]==player && board[9]==player && board[8]==' ') ||(board[2]==player && board[5]==player && board[8]==' ')
					)
			{
				index=8;
				return true;
			}
			else if((board[1]==player && board[5]==player && board[9]==' ') ||(board[8]==player && board[7]==player && board[9]==' ')
					||(board[5]==player && board[1]==player && board[9]==' '))
			{
				index=9;
				return true;
			}
			else 
				return false;	
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        System.out.println("Welcome to tic tac toe");
        initialize();
		showBoard();
		playerInput();
		
		tossing();
		startGame();
		displayWinner();
	}

}
