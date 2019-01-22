package me.Jack.Projects;

import java.util.Random;
import java.util.Scanner;

public class Project09 {

    public static void main(String[] args) {
        int num, guesses = 0, guess;
        boolean playAgain = true;

        Scanner scanner = new Scanner(System.in);

        Random r = new Random();
        num = r.nextInt(1000-1) + 1;

        while(playAgain) {
            System.out.println("Enter a guess");
            guess = scanner.nextInt();
            if(guess != num){
                if (guess < 1 || guess > 1000){
                    System.out.println("Please guess between 1 and 1000");
                } else {
                    if(guess > num){
                        System.out.println("High");
                    } else if (guess < num){
                        System.out.println("Low");
                    }
                }
                guesses++;
            } else {
                System.out.println("It took you " + guesses + " guesses.");
                System.out.println("Do you want to play again? true or false");
                if(scanner.nextBoolean()){
                    playAgain = true;
                } else if (scanner.nextBoolean()){
                    playAgain = false;
                }
            }

        }
    }
}
