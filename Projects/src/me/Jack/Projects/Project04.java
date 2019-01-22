package me.Jack.Projects;

import java.util.Scanner;

public class Project04 {

    public static void main(String[] args) {
        //Basic projects will do at the end
        Scanner scanner = new Scanner(System.in);
        int itemPrice, numBolt, numNut, numWasher, tankCapacity, gagePercent, MPG, currentGas;
        final int boltPrice = 5, nutPrice = 3, washerPrice = 1, route66 = 200 * 100;

        //Chapter 12
        //Exercise 1
        System.out.println("Enter price of item in cents");
        itemPrice = scanner.nextInt();
        if(itemPrice >= 1000){
            System.out.println(itemPrice * 0.9);
        }
        //Exercise 2
        System.out.println("Enter number of bolts");
        numBolt = scanner.nextInt();
        System.out.println("Enter number of nuts");
        numNut = scanner.nextInt();
        System.out.println("Enter number of washers");
        numWasher = scanner.nextInt();
        if(numBolt > numNut) {
            System.out.println("Check order: You must have the same amount of bolts as nuts");
        } else if (numBolt*2 > numWasher) {
            System.out.println("Check order: You must have atleast twice as many washers as bolts");
        } else {
            System.out.println("Check order: Okay");
        }

        System.out.println("Price: " + ((numBolt*boltPrice) + (numWasher * washerPrice) + (numNut * nutPrice)));

        //Exercise 3
        System.out.println("Enter tank capacity in gallons");
        tankCapacity = scanner.nextInt() * 100;
        System.out.println("Gage reading");
        gagePercent = scanner.nextInt()* 100;
        System.out.println("Enter miles per gallon");
        MPG = scanner.nextInt()* 100;
        currentGas = tankCapacity * gagePercent;
        if((route66 - currentGas * MPG) < 0){
            System.out.println("Get gas");
        } else {
            System.out.println("Keep driving");
        }
    }
}
