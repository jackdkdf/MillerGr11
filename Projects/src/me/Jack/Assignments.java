package me.Jack;

import java.sql.SQLOutput;

public class Assignments {

    public void Assignment12(){
        //TotalOfFive
        int countTOF = 0;
        System.out.println("Total Of Five");
        for(int i=1; i<6; i++){
            countTOF += i;
            System.out.print(Methods.padL(i + "", 5));
            System.out.println(Methods.padL(countTOF + "", 5));
        }

        //MultipleOfTwo
        int countMOF = 2;
        System.out.println("\nMultiple Of Two");
        for(int i=1; i<6; i++){
            System.out.print(Methods.padL(i + "", 5));
            System.out.println(Methods.padL(countMOF + "", 5));
            countMOF *= 2;
        }

        //MultipleAndTotal
        int countMAT = 2, totalMAT = 0;
        System.out.println("\n Multiple And Total");
        for(int i=1; i<6; i++){
            totalMAT += countMAT;
            System.out.print(Methods.padL(i + "", 5));
            System.out.print(Methods.padL(countMAT + "", 5));
            System.out.println(Methods.padL(totalMAT + "", 5));

            countMAT *= 2;
        }
    }

    public void Assignment24(){
        boolean[] Doors = new boolean[101];

        for (int i = 1; i < 101; i++) {
            for (int j = 1; j < 101; j++) {
                if (i % j == 0) {
                    if(Doors[i]){
                        Doors[i] = false;
                    } else {
                        Doors[i] = true;
                    }
                }
            }
            if(Doors[i]){
                System.out.println("Door " + i + " is open.");
            }
        }
    }

}
