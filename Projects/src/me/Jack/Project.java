package me.Jack;

import java.util.Scanner;
import me.Jack.Methods;

//Assignment 7, 8, 9 for Jack Michie

public class Project {
    public static void main(String args[]){
        Project p = new Project();
        p.Project02();
        //p.Project03();
        //p.Project04();
        //p.Project05();
        //p.Project06();
        //p.Project07();
        //p.Project08();
        //p.Project09();
        //p.Project10();
        //p.Project11();
    }

    //Done
    public void Project02(){
        //Task 1
        int factorialI = 1;
        long factorialL = 1;
        System.out.println("Number   Factorial(Integer)   Factorial(Long)");
        System.out.println("------   ------------------   ---------------------");
        for(int i=1; i<26; i++){
            factorialI *= i;
            factorialL *= i;
            System.out.format("%d%25d%25d%n", i, factorialI, factorialL);
        }
        //Task 2
        double fourGrowth = 1000, fiveGrowth = 1000, sixGrowth = 1000, sevenGrowth = 1000;
        System.out.println();
        System.out.println("Year   4% Growth   5% Growth   6% Growth   7% Growth");
        System.out.println("----   ---------   ---------   ---------   ---------");
        for(int i=1; i<46; i++){
            fourGrowth *= 1.04;
            fiveGrowth *= 1.05;
            sixGrowth *= 1.06;
            sevenGrowth *= 1.07;
            fourGrowth = Math.round(fourGrowth*100)/100.0;
            fiveGrowth = Math.round(fiveGrowth*100)/100.0;
            sixGrowth = Math.round(sixGrowth*100)/100.0;
            sevenGrowth = Math.round(sevenGrowth*100)/100.0;
            System.out.format("%d%12.2f%12.2f%12.2f%12.2f%n", i, fourGrowth, fiveGrowth, sixGrowth, sevenGrowth);
        }
    }

    public void Project03(){
        //Just sout will do it later
        String[] names = {"JORDAN SASLOWSKI", "PAT ATAKI"};
        String[] street = {"333 WILLIAM ST", "909 KING ST"};
        String[] postalCode = {"SHELBURNE ON L9V 3A7", "Sarnia ON N7V 3V3"};
        int [] payments = {400, 500};
        double [] balance = {428.71, 688.95};
        String accountNum = "4988 4902 0165 2388";
        String statementPeriod = "September 1, 2015 to September 30, 2015";
        String [] transactionsJordan = {"Walmart, Goergetown ON", "7-Eleven, Georgetown ON", "Superstore, Georgetown ON", "American Eagle, Store #218", "PAYMENT", "Home Hardware, Georgetown ON"};
        String [] transactionsPat = {"Sears, Georgetown ON", "The Beer Store, Georgetown ON", "Bell Mobile, Georgetown ON", "The Shoe Box, Georgetown ON", "PAYMENT", "Canadian Tire, Georgetown ON"};


        for(int i=0; i<2; i++) {
            System.out.printf("%" + 16 + "s\n","TransWorld Bank Elite MasterCard");
            System.out.format("%s\n", names[i]);
            System.out.format("%s\n", street[i]);
            System.out.format("%s\n\n", postalCode[i]);
            System.out.format("%s\n", "Account Number: " + accountNum);
            System.out.format("%s", "Statement period: " +  statementPeriod + "\n");
            System.out.format("%s%s%s", "Contact us: ", "Inquiries: 1-800-651-4431\n","Lost/Stolen: 1-800-651-443\n\n");
            System.out.format("%s%s%s", "Interest rates: ", "Purchases: 19.86% Annual\n", "Cash Advances: 21.21% Annual");
            System.out.format("%s", "SUMMARY\n", "");
        }
    }

    //Done
    public void Project04(){
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

    //Done
    public void Project05(){
        //Ontario Speeding Fines
        Scanner scanner = new Scanner(System.in);
        int postedSpeed = 0, speed = 0, zone, check;
        double fine = 0;
        System.out.println("Enter speed limit");
        postedSpeed = scanner.nextInt();
        System.out.println("Enter the speed the vehicle was traveling");
        speed = scanner.nextInt();
        System.out.println("Normal zone or Construction zone");
        zone = scanner.nextInt();
        check = speed-postedSpeed;
        if(check <= 0){
            fine = check*0;
        } else if (check > 0 && check < 20){
            fine = check * 2.50;
        } else if (check >= 20 && check <= 29){
            fine = check * 3.75;
        } else if (check >= 30 && check <= 49){
            fine = check * 6.0;
        } else if (check > 50){
            fine = check * 9.75 * 1.25;
        }

        if(zone == 2){
           fine *= 2;
        }

        if(fine > 0 && fine <= 50){
            fine += 10;
        } else if (fine >= 51 && fine <= 75){
            fine += 15;
        } else if (fine >= 76 && fine <= 100){
            fine += 20;
        } else if (fine >= 101 && fine <= 150){
            fine +=25;
        } else if (fine >= 151 && fine <= 200){
            fine += 35;
        } else if (fine >= 201 && fine <= 250){
            fine += 50;
        } else if (fine >= 251 && fine <= 300){
            fine += 60;
        } else if (fine >= 301 && fine <= 350){
            fine += 75;
        } else if (fine >= 351 && fine <= 400){
            fine += 85;
        } else if (fine >= 401 && fine <= 450){
            fine += 95;
        } else if (fine >= 451 && fine <= 500){
            fine += 110;
        } else if (fine >= 501 && fine <= 1000){
            fine += 125;
        } else if (fine >= 1001){
            fine *= 1.25;
        }

        System.out.println("Your fine is $" + (fine+5));
    }

    //Done (On Macbook)
    public void Project06(){}

    public void Project07(){

    }

    public void Project08(){}

    public void Project09(){}

    public void Project10(){}

    public void Project11(){}

}
