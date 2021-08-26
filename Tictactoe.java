package tictactoeproject;

import java.util.Random;
import java.util.Scanner;

public class Tictactoe {

	static char[] board = new char[10];
	static int val=1;
	static char player,computer;
	
	static int index;
	static char input,whowin;
	
	static boolean toswin,didwin;
	static int toss,tosschoice,x=0,o=0;
	static Scanner sc=new Scanner(System.in);
	static Random random=new Random();
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
	 * this method will determine which index computer should input to
	 */
	public static void computerIndex()
	{
		index=random.nextInt(10);
		if(isEmpty(index)==true)
		{
				
			board[index]=computer;
			val++;
			showBoard();	
		}
		else {
			computerIndex();
		}
	}
	/*
	 * until all index are filled player and computer play alternatively
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
	 * this method will check for the winnig condition XXX or OOO
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
	 * this method is used to check if there is a tie 
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
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        System.out.println("Welcome to tic tac toe");
        initialize();
        playerInput();
        showBoard();
        selectIndex();

		tossing();
		startGame();
		displayWinner();
	}

}
