package me.Jack;

import java.util.*;

public class Assignments {

    //Done
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

    //Done (Same as Project 5)
    public void Assignment14(){
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

    //Done (Same as Project 6)
    public void Assignment18(){}

    //Done (Same as Project 7)
    public void Assignment19(){
        //Declaring Variables
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

    //Done (Same as Project *) ** Requires the Methods Class **
    public void Assignment20(){
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

    //Done (Guess The Number the same as Project 9)
    public void Assignment21(){
        //Vars
        Scanner scanner = new Scanner(System.in);
        Character yN;
        int num, guesses = 0, guess, answerPOOT;
        boolean playAgain = true;
        Random r = new Random();

        //PickOneOrTwo (POOT)
        System.out.println("Pick One or Two");
        do {
            System.out.println("Answer 1 or 2");
            answerPOOT = scanner.nextInt();
            if(answerPOOT != 1 && answerPOOT != 2){ System.out.println("That is not a valid answer\n"); }
        } while(answerPOOT != 1 && answerPOOT != 2);

        //AnswerYorN (AYON)
        System.out.println("Answer Y or N");
        do {
            System.out.println ("Answer yes or no (Y or N)");
            scanner.nextLine(); //Java can be so fucking stupid (Reads enter in ascii code and causes error)
            String temp = scanner.nextLine().toLowerCase();
            yN = temp.charAt(0);
            System.out.println(yN);
            if (!yN.equals('y') && !yN.equals('n')){ System.out.println("That is not a valid answer\n"); }
        } while (!yN.equals('y') && !yN.equals('n'));

        //GuessTheNumber
        System.out.println("Guess The Number");

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
    public void Assignment22(){
        //Vars
        char secretLetter;
        Random r = new Random();
        int points = 50, occurrences = 0;
        String guess;
        Scanner scanner = new Scanner(System.in);
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        boolean stop = false;

        //Secret Letter
        System.out.println("Secret Letter");

        secretLetter = alphabet[r.nextInt(25)];
        System.out.println(secretLetter);
        System.out.println(points);
        do {
            guess = scanner.nextLine();
            for(int i = 0; i<guess.length(); i++){
                if(guess.toLowerCase().charAt(i) == secretLetter){
                    occurrences++;
                }
            }
            if(occurrences == 0){
                points -= 10;
            } else if (occurrences > 0 && occurrences < 5){
                points -= 5;
            } else if(occurrences > 4){
                System.out.println("You win!");
                stop = true;
            }

            occurrences = 0;

            if(points < 1){
                System.out.println("You lose!");
                stop = true;
            }

            System.out.println("You have " + points + " points!");

        } while (!stop);
    }

    public void Assignment23(){

    }

    //Done (Same as Project 11)
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
