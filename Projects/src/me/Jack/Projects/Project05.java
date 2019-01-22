package me.Jack.Projects;

import java.util.Scanner;

public class Project05 {

    public static void main(String[] args) {
        //Ontario Speeding Fines
        Scanner scanner = new Scanner(System.in);
        int postedSpeed, speed, zone, check;
        double fine = 0;
        System.out.println("Enter speed limit");
        postedSpeed = scanner.nextInt();
        System.out.println("Enter the speed the vehicle was traveling");
        speed = scanner.nextInt();
        System.out.println("Normal zone or Construction zone");
        zone = scanner.nextInt();
        check = speed-postedSpeed;
        if(check <= 0){
            fine = 0;
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
}
