package me.Jack.Projects;

import me.Jack.Methods;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Project10 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> input = new ArrayList<>();
        ArrayList<Integer> outcomes = new ArrayList<>();
        HashMap<Integer, Integer> results = new HashMap();
        Random r = new Random();

        int dice1, dice2;

        System.out.println("Enter a number");
        int userNum = Integer.parseInt(scanner.nextLine());

        for(int i=0; i<userNum; i++){
            System.out.println("Enter a string");
            input.add(scanner.nextLine());
        }

        for(int i=userNum-1; i>-1; i--){
            System.out.println(input.get(i));
        }

        for(int i=0; i<1000; i++){
            dice1 = r.nextInt(6) + 1;
            dice2 = r.nextInt(6) + 1;

            outcomes.add(dice1 + dice2);
        }

        Methods.clearChat(5);
        for(int i=2; i<13; i++){
            System.out.print(Methods.padR(i + "", 5));
            results.put(i, 0);
        }

        for(int i=0; i<outcomes.size(); i++){
            results.put(outcomes.get(i), results.get(outcomes.get(i))+1);
        }

        Methods.clearChat(2);
        for(int i=2; i<13; i++){
            System.out.print(Methods.padR(results.get(i) + "", 5));
        }
    }
}
