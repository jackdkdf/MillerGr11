package me.Jack.Projects;

import me.Jack.Methods;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Project12 {

    public static void main(String[] args) throws Exception {
        String path = "";
        File file = new File(path + "ClassMarks.txt");
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
