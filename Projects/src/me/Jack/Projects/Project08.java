package me.Jack.Projects;

import me.Jack.Methods;

import java.util.Arrays;
import java.util.List;

public class Project08 {

    public static void main(String[] args) {
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
}
