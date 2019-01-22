package me.Jack.Projects;

import java.util.HashMap;
import java.util.Scanner;

public class Project07 {

    public static void main(String[] args) {
        //Declaring
        Scanner scanner = new Scanner(System.in);
        String amount, dollars, cents;
        int amt = 0, totalAmt = 0;

        //Input
        System.out.println("Enter the desired cheque amount in words");
        amount = scanner.nextLine();

        //List of numbers
        final HashMap<String, Integer> numbers= new HashMap<>();
        //List of number + ty
        final HashMap<String, Integer> tynumbers = new HashMap<>();
        //List of positive powers
        final HashMap<String, Integer> posPowers = new HashMap<>();

        numbers.put("zero", 0);
        numbers.put("one", 1);
        numbers.put("two", 2);
        numbers.put("three", 3);
        numbers.put("four", 4);
        numbers.put("five", 5);
        numbers.put("six", 6);
        numbers.put("seven", 7);
        numbers.put("eight", 8);
        numbers.put("nine", 9);
        numbers.put("ten", 10);
        numbers.put("eleven", 11);
        numbers.put("twelve", 12);
        numbers.put("thirteen", 13);
        numbers.put("fourteen", 14);
        numbers.put("fifteen", 15);
        numbers.put("sixteen", 16);
        numbers.put("seventeen", 17);
        numbers.put("eighteen", 18);
        numbers.put("nineteen", 19);

        tynumbers.put("twenty", 20);
        tynumbers.put("thirty", 30);
        tynumbers.put("forty", 40);
        tynumbers.put("fifty", 50);
        tynumbers.put("sixty", 60);
        tynumbers.put("seventy", 70);
        tynumbers.put("eighty", 80);
        tynumbers.put("ninety", 90);

        posPowers.put("hundred", 100);
        posPowers.put("thousand", 1000);

        String [] split = amount.toLowerCase().split(" and ");
        dollars = split[0];
        cents = split[1];

        String [] check = amount.toLowerCase().split("thousand");

        System.out.println(dollars);
        System.out.println(cents);

        amount.toLowerCase().replaceAll(" dollars", "");

        String [] nums = amount.toLowerCase().split(" ");
        for(int i=0; i<nums.length; i++){
            //check if hundred comes before thousand
            if(numbers.get(nums[i]) != null){
                amt += numbers.get(nums[i]);
            } else if (tynumbers.get(nums[i]) != null){
                amt += tynumbers.get(nums[i]);
            } else if (posPowers.get(nums[i]) != null){
                if(amount.toLowerCase().contains("hundred") && amount.toLowerCase().contains("thousand")){
                    if(check[0].contains("hundred")){
                        totalAmt += amt;
                        totalAmt *= posPowers.get(nums[i]);
                        amt = 0;
                    } else {
                        amt *= posPowers.get(nums[i]);
                        totalAmt += amt;
                        amt = 0;
                    }
                } else {
                    amt *= posPowers.get(nums[i]);
                    totalAmt += amt;
                    amt = 0;
                }
            }
        }

        totalAmt+=amt;

        cents = cents.toLowerCase().replaceAll(" cents", "");

        System.out.println("$" + totalAmt + "." + cents);
    }
}
