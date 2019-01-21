package me.Jack;

import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Methods {

    static String path = "C:\\Users\\jack\\Documents\\MillerGr11\\Projects\\src\\";

    public static String padL(String string, int padding){
        return String.format("%1$" + padding + "s", string);
    }

    public static String padR(String string, int padding){
        return String.format("%1$-" + padding + "s", string);
    }

    public static void clearChat(int times){
        for(int i=0; i<times; i++){
            System.out.println();
        }
    }

    public static int checkAmtLetters(String string, Character c){
        int count = 0;
            for(int i=0; i<string.length(); i++){
                if(string.toLowerCase().charAt(i) == c){
                    count++;
                }
            }

        return count;
    }

    public static void tally(int num, Character c){
        char capitalC = Character.toUpperCase(c);
        System.out.println();
        System.out.print(Methods.padR(capitalC + " (" + num + ")", 10));
        for(int i=0; i<num; i++){
            System.out.print("*");
        }
    }

    public static void shoppingCartList(){
        System.out.println("///////////////////////////////////////////////////////////////");
        System.out.println("//Please enter 5 to list parts                               //");
        System.out.println("//Please enter 6 to buy parts                                //");
        System.out.println("//Please enter 7 to list your shopping cart                  //");
        System.out.println("//Please enter 8 when you are done with your shopping cart   //");
        System.out.println("///////////////////////////////////////////////////////////////");
    }

    public static void listCart(String[] sArray, int[] iArray, double[] dArray){
        System.out.println("Part" + Methods.padL("Quantity", 16) + Methods.padL("Price", 7));
        System.out.println("----" + Methods.padL("--------", 16) + Methods.padL("-----", 7));
        for(int i=0; i<5; i++){
            System.out.print(Methods.padR(sArray[i], 12));
            System.out.print(Methods.padR("" + iArray[i], 10));
            System.out.println(Methods.padR("$" + iArray[i] * dArray[i], 4));
        }
    }

    // \/ Only method relevant to CPT \/

    //Takes a string date (from my arraylist) and a date
    public static int daysBetween(String sDate, Date d2) {
        //Manipulates the arraylist string to a calendar and then to a date
        int year = Integer.parseInt(sDate.substring(1, 5));
        int month = Integer.parseInt(sDate.substring(5, 7));
        int day = Integer.parseInt(sDate.substring(7, 9));
        Calendar cal = new GregorianCalendar();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month-1);
        cal.set(Calendar.DAY_OF_MONTH, day);
        //Converts the calendar into a date
        Date d1 = cal.getTime();
        //Does some nice old math I didn't have time to come up with myself so I had to google it, however I did the honours of adding the +1
        //Calculates the time between two dates
        return (int)( (d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24)) + 1;
    }

}
