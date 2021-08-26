package tictactoeproject;

import java.util.Random;
import java.util.Scanner;

public class Tictactoe {

	static char[] board = new char[10];
	static int val=1;
	static char player,computer;
	static char input;
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
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        System.out.println("Welcome to tic tac toe");
        initialize();
        playerInput();
	}

}
