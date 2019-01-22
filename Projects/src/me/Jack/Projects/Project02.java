package me.Jack.Projects;

public class Project02 {

    public static void main(String[] args) {
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
}
