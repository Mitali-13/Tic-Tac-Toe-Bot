package com.company;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args) {
	// write your code here
        char [][] board = new char[3][3];

        System.out.println("Welcome to Tic-Tac-Toe Game!");
        System.out.println("The board is empty right now.");
        game(board);
    }

    static void game(char[][] board)
    {
        while(true)
        {
            //System.out.print("Enter the index number for your chance:");
            user(board);
            comp(board);

            int flagforprog = 0;
            //printing tic tac toe board
            for(int i = 0 ; i<3 ; i++)
            {
                for (int j = 0; j < 3; j++) {
                    System.out.print(board[i][j] +" ");
                }
                System.out.println();
            }

            //checks
            for (int i = 0; i < 3; i++) {  //checking each row for user
                int flag = 0;
                for(char c : board[i])
                {
                    if(c!='X')
                    {
                        flag = 1;
                        break;
                    }
                }
                if(flag==0)
                {
                    System.out.println("You won!");
                    flagforprog = 1;
                    break;
                }
            }
            for (int i = 0; i < 3; i++) { //checking each column for user
                int flag = 0;
                for(int j = 0 ; j<3 ; j++)
                {
                    if(board[j][i]!='X')
                    {
                        flag = 1;
                        break;
                    }
                }
                if(flag==0)
                {
                    System.out.println("You won!");
                    flagforprog =1;
                    break;
                }
            }
            for (int i = 0; i < 3; i++) { //checking diagonal 1 for user
                int flag=0;
                if(board[i][i]!='X')
                {
                    flag = 1;
                    //System.out.println("You lose");
                    break;
                }
                if (i==3){
                System.out.println("You won!");
                flagforprog = 1;}
            }
            for (int i = 0; i < 3; i++) { //checking diagonal 2 for user
                int flag = 0;
                if (board[2-i][i] != 'X') {
                    flag = 1;
                    //System.out.println("You lose");
                    break;
                }
                if(i==3)
                {
                System.out.println("You won!");
                flagforprog = 1;}
                }


            for (int i = 0; i < 3; i++) {  //checking each row for bot
                int flag = 0;
                for(char c : board[i])
                {
                    if(c!='O')
                    {
                        flag = 1;
                        break;
                    }
                }
                if(flag==0)
                {
                    System.out.println("Bot wins!");
                    flagforprog = 1 ;
                    break;
                }
            }
            for (int i = 0; i < 3; i++) { //checking each column for bot
                int flag = 0;
                for(int j = 0 ; j<3 ; j++)
                {
                    if(board[j][i]!='O')
                    {
                        flag = 1;
                        break;
                    }
                }
                if(flag==0)
                {
                    System.out.println("Bot wins!");
                    flagforprog = 1 ;
                    break;
                }
            }
            for (int i = 0; i < 3; i++) { //checking diagonal1 for bot
                int flag=0;
                if(board[i][i]!='O')
                {
                    flag = 1;
                    //System.out.println("Bot loses");
                    break;
                }
                if(i==3){
                System.out.println("Bot wins!");
                flagforprog = 1 ;}
            }
            for (int i = 0; i < 3; i++) { //checking diagonal 2 for user
                int flag = 0;
                if (board[2-i][i] != 'O') {
                    flag = 1;
                    //System.out.println("Bot loses");
                    break;
                }
                if(i==3){
                System.out.println("Bot wins!");
                flagforprog = 1 ;}
              }

            if(flagforprog == 1)
            {
                return;
            }
            //board is full - draw
            int counter = 0 ;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if(board[i][j]=='\u0000')
                    {
                        counter = 1;
                        break;
                    }
                }
                if(counter==1)
                    break;
            }
            if(counter == 0){
                System.out.println("The match is draw.");
                return;
            }
        }
    }

    static void user(char[][] board)
    {
        System.out.print("Enter the index number for your chance:");
        Scanner input = new Scanner(System.in);
        int user1 = input.nextInt();
        int user2 = input.nextInt();
        if(board[user1][user2]!='\u0000')
        {
            System.out.println("Space occupied. Choose another position.");
            user(board);
        }
        else
        {
            board[user1][user2] = 'X';
        }
    }

    static void comp(char[][] board)
    {
        Random rand = new Random();
        int comp1 = rand.nextInt(3);
        int comp2 = rand.nextInt(3);
        if(board[comp1][comp2] != '\u0000')
        {
            comp(board);
        }
        else
        {
            board[comp1][comp2] = 'O';
        }
    }
}
