package me.Jack;

import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.Buffer;
import java.text.DecimalFormat;
import java.util.*;
import java.util.List;

public class Project {
    public static void main(String args[]) throws Exception{
        Project p = new Project();
        Assignments a = new Assignments();
        CPT cpt = new CPT();

        //Projects
        //p.Project02();
        //p.Project03();
        //p.Project04();
        //p.Project05();
        //p.Project06();
        //p.Project07();
        //p.Project08();
        //p.Project09();
        //p.Project10();
        //p.Project11();
        //p.Project12();

        //Assignment
        //a.Assignment12();
        //a.Assignment21();
        //a.Assignment22();
        //a.Assignment24();
        //a.Assignment26();

        //Performance Tasks
        cpt.CPTLvl5();
    }

    //Done
    private void Project02(){
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

    //Close to finished have to format
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

    //Done
    public void Project06(){
//    PaintBug.drawGrid();
//    PaintBug.setWindowSize(600, 600);
//    PaintBug line = new PaintBug();
//    line.setSpeed(95);
//    Random rand = new Random();
//
//    while(true){
//        line.move(1);
//        float r = rand.nextFloat();
//        float g = rand.nextFloat();
//        float b = rand.nextFloat();
//        if(line.getXPos() >= 500){
//            System.out.println("Past 500 X");
//            double rando = Math.random()* 20 + 180;
//            line.turnLeft(rando);
//            line.setColor(new Color(r, g, b));
//        } else if (line.getXPos() <= 0){
//            System.out.println("Past 0 X");
//            double rando = Math.random()* 20 + 180;
//            line.turnLeft(rando);
//            line.setColor(new Color(r, g, b));
//        } else if (line.getYPos() >= 500){
//            System.out.println("Past 500 Y");
//            double rando = Math.random()* 20 + 180;
//            line.turnLeft(rando);
//            line.setColor(new Color(r, g, b));
//        } else if (line.getYPos() <= 0){
//            System.out.println("Past 0 Y");
//            double rando = Math.random()* 20 + 180;
//            line.turnLeft(rando);
//            line.setColor(new Color(r, g, b));
//                    }
//                }
    }

    //Done for the most part
    public void Project07(){
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

    //Done
    public void Project08()  {
        int numE = 0, numi = 0, numI = 0, numVowels = 0;

        int numR = 0, numS = 0, numT = 0, numL = 0, numN = 0;

        List<Character> vowels = Arrays.asList('a', 'e', 'i', 'o', 'u', 'y');

        String sVerse = "As we enter our centennial year we are still a young "
                + "nation, very much in the formative stages. Our national condition "
                + "is still flexible enough that we can make almost anything we wish "
                + "of our nation. No other country is in a better position than Canada "
                + "to go ahead with the evolution of a national purpose devoted to all "
                + "that is good and noble and excellent in the human spirit. "
                + "Canada is the only country in the world that knows how to live without "
                + "an identity. "
                + "Canadians, like their historians, have spent too much time remembering "
                + "conflicts, crises, and failures. They forgot the great, quiet "
                + "continuity of life in a vast and generous land. A cautious people "
                + "learns from its past; a sensible people can face its future. "
                + "Canadians, on the whole, are both. ";

        String sVerse2 = "If the general attitude of Canadians toward their mighty neighbor to the south"
        + "could be distilled into a single phrase, that phrase would probably be \"Oh, shut\""
        + "up. The Americans talked too much, mainly about themselves. Their torrid love"
        + "affair with their own history and legend exceeded - painfully - the quasi-British"
        + "Canadian idea of modesty and self-restraint . . . They were forever busting their"
        + "buttons in spasms of insufferable yahoo pride or all too publicly agonizing over"
        + "their crises.";

        String fullVerse = sVerse + sVerse2;

        String lowercaseThe [] = fullVerse.split(" the ");
        String uppercaseThe [] = fullVerse.split(" The ");
        String lowercaseAnd [] = fullVerse.split(" and ");
        String uppercaseAnd [] = fullVerse.split(" And ");

        for(int i=0; i<fullVerse.length(); i++){
            if(fullVerse.toLowerCase().charAt(i) == 'e') {
                numE++;
            } else if(fullVerse.charAt(i) == 'i'){
                numi++;
            } else if (fullVerse.charAt(i) == 'I'){
                numI++;
            }

            for(int j=0; j<vowels.size(); j++){ //Count vowels
                if(fullVerse.toLowerCase().charAt(i) == vowels.get(j)){
                    numVowels++;
                }
            }
        }

        int numThe = (lowercaseThe.length-1)+(uppercaseThe.length-1);

        numR = Methods.checkAmtLetters(fullVerse, 'r');
        numS = Methods.checkAmtLetters(fullVerse, 's');
        numT = Methods.checkAmtLetters(fullVerse, 't');
        numN = Methods.checkAmtLetters(fullVerse, 'n');
        numL = Methods.checkAmtLetters(fullVerse, 'l');
        System.out.println("Number of E: " + numE);
        System.out.println("Number of lowercase I: " + numi);
        System.out.println("Number of uppercase I: " + numI);
        System.out.println("Number of Vowels: " + numVowels);
        System.out.println("Number of The: " + numThe);
        System.out.println("Number of lowercase The: " + (lowercaseThe.length-1));
        System.out.println("Number of uppercase The: " + (uppercaseThe.length-1));
        System.out.println("Number of lowercase And: " + (lowercaseAnd.length-1));
        System.out.println("Number of uppercase And: " + (uppercaseAnd.length-1));

        Methods.clearChat(2);

        System.out.print("LETTER");

        for(int i=0; i<(numR+numS+numT+numN+numL)/3; i++){
            if(i % 5 == 0){
                System.out.print(Methods.padL(""+i, 5));
            }
        }

        Methods.tally(numE, 'E');
        Methods.tally(numL, 'L');
        Methods.tally(numN, 'N');
        Methods.tally(numR, 'R');
        Methods.tally(numS, 'S');
        Methods.tally(numT, 'T');
    }

    //Done
    public void Project09(){
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

    //Done
    public void Project10(){
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

    //Done
    public void Project11(){
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

    //Done
    public void Project12() throws Exception{
        File file = new File(Methods.path + "ClassMarks.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        DecimalFormat df = new DecimalFormat("0.00");
        ArrayList<Double> marks = new ArrayList<>();
        int spacing = 20;
        String input;
        int lines = 0;
        double average = 0;
        double mark;
        //List of marks
        int zeroToFortyNine = 0, fiftyToFiftyNine = 0, sixtyToSixtyNine = 0, seventytoSeventyNine = 0, eightyToEightyNine = 0, ninetyToHundred = 0;
        //Frequency
        HashMap<Double, Integer> frequency = new HashMap<>();

        while ((input = br.readLine()) != null){
            lines++;
            mark = Double.parseDouble(input);
            if(mark > 0 && mark < 100){
                marks.add(mark);
                average += mark;
                if(mark <= 49){
                    zeroToFortyNine++;
                } else if (mark < 60 && mark >= 50){
                    fiftyToFiftyNine++;
                } else if (mark < 70 && mark >= 60){
                    sixtyToSixtyNine++;
                } else if (mark < 80 && mark >= 70){
                    seventytoSeventyNine++;
                } else if (mark < 90 && mark >= 80){
                    eightyToEightyNine++;
                } else if (mark < 100 && mark >= 90){
                    ninetyToHundred++;
                }
            }
        }
        System.out.println("Number of lines: " + lines);
        System.out.println("Number of valid marks: " + marks.size());
        System.out.println("Average of all marks: " +  df.format(average/marks.size()));
        System.out.println("Highest mark: " + Collections.max(marks));
        System.out.println("Lowest mark: " + Collections.min(marks) + "\n\n");

        System.out.print(Methods.padR("CATEGORIES", spacing));
        System.out.println("MARK COUNT");
        System.out.print(Methods.padR("----------", spacing));
        System.out.println("----------");
        System.out.print(Methods.padR("0 to 49", spacing));
        System.out.println(zeroToFortyNine);
        System.out.print(Methods.padR("50 to 59", spacing));
        System.out.println(fiftyToFiftyNine);
        System.out.print(Methods.padR("60 to 69", spacing));
        System.out.println(sixtyToSixtyNine);
        System.out.print(Methods.padR("70 to 79", spacing));
        System.out.println(seventytoSeventyNine);
        System.out.print(Methods.padR("80 to 89", spacing));
        System.out.println(eightyToEightyNine);
        System.out.print(Methods.padR("90 to 100", spacing));
        System.out.println(ninetyToHundred + "\n\n");

        for(int i = 0; i < marks.size(); i++){
            frequency.put(marks.get(i), Collections.frequency(marks, marks.get(i)));
        }

        int freq = Collections.max(frequency.values());

        System.out.println("MOST FREQUENT MARKS (Frequency: " + freq + ")");
        System.out.println("----------------------------------");

        for(int i = 0; i < frequency.size(); i++){
            if(frequency.get(marks.get(i)) == freq){
                System.out.println(marks.get(i));
            }
        }
    }

}
