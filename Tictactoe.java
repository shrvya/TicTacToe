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
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        System.out.println("Welcome to tic tac toe");
        initialize();
        playerInput();
        showBoard();
	}

}
