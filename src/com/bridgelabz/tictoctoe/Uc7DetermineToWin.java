package com.bridgelabz.tictoctoe;

import java.util.Scanner;

public class Uc7DetermineToWin {
    //create a board of char array of size 10
    static char[] board = new char[10];
    static char userLetter;
    static char computerLetter;

    public static void main(String[] args) {
        createEmptyBoard();
        chooseLetter();
        while (true) {
            playerTurn();

            showBoard();
            checkFreeSpace();
            checkFirstPlayer();
            winner();
        }
    }

    /**
     * UC1
     * Method Name: createEmptyBoard
     * Description: Static method to create empty board
     * Algorithm: It takes board array indexes from 1 to 9 using for loop and
     * assign empty space to each element in the board.
     */
    private static void createEmptyBoard() {
        for (int index = 1; index < board.length; index++) {
            board[index] = ' ';
        }
    }

    /**
     * UC2
     * Method Name: chooseLetter
     * if user letter is 'X' then computer letter is become 'O' otherwise it becomes 'X'
     */
    private static void chooseLetter() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose a letter :: X or O : ");
        userLetter = scanner.next().toUpperCase().charAt(0);
        computerLetter = (userLetter == 'X') ? 'O' : 'X';
    }

    /**
     * UC3
     * Method Name: showBoard
     * Description: method to display current board
     */
    private static void showBoard() {
        System.out.println(board[1] + " | " + board[2] + " | " + board[3]);
        System.out.println("----------");
        System.out.println(board[4] + " | " + board[5] + " | " + board[6]);
        System.out.println("----------");
        System.out.println(board[7] + " | " + board[8] + " | " + board[9]);
    }

    /**
     * UC4
     * Method Name: playerTurn
     * Description: method to make user to move to desired location
     */
    private static void playerTurn() {
        int playerMove;
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Choose your location(1-9): ");
            playerMove = scanner.nextInt();
            if (board[playerMove] == ' ') {
                break;
            }

        }
        System.out.println("Player choose:: " + playerMove);
        board[playerMove] = userLetter;
    }

    /**
     * UC5
     * Method Name: checkFreeSpace
     * Description: method to check if space is available in the board.
     */
    private static void checkFreeSpace() {
        boolean isSpaceAvailable = false;
        int numOfFreeSpaces = 0;
        for (int index = 1; index < board.length; index++) {
            if ((board[index] == ' ')) {
                isSpaceAvailable = true;
                numOfFreeSpaces++;
            }
        }
        if (isSpaceAvailable == false) {
            System.err.println("Board is full! You can't make another move");
            System.exit(0);
        } else {
            System.out.println("Free space is available! you have " + numOfFreeSpaces + " moves left");
        }
    }

    /**
     * UC6
     * Method Name: checkFirstPlayer
     * Description : method to check who plays first computer or user
     */
    private static void checkFirstPlayer() {
        int Head = 0;
        double toss = Math.floor(Math.random() * 10) % 2;
        if (toss == Head) {
            System.out.println("computer starts to play first");
        } else {
            System.out.println("User starts to play first");
        }
    }

    /**
     * UC7
     * MethodName: winner
     * Description: method to check player possible winning positions
     */
    private static void winner() {
        if ((board[1] == userLetter && board[2] == userLetter && board[3] == userLetter) ||
                (board[4] == userLetter && board[5] == userLetter && board[6] == userLetter) ||
                (board[7] == userLetter && board[8] == userLetter && board[9] == userLetter) ||
                (board[1] == userLetter && board[5] == userLetter && board[9] == userLetter) ||
                (board[3] == userLetter && board[5] == userLetter && board[7] == userLetter)) {
            showBoard();
            System.out.println("Player win the game");
            System.exit(0);
        }
    }


}


