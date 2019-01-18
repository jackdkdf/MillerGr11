package me.Jack;

public class Methods {

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

    public static String underscoreCreator(int amount){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<amount; i++){
            sb.append("_");
        }
        String st = sb.toString();
        return st;
    }

    public static void creditCardStatement(String creditCardNum, int statementClosingDate, double creditLine, double availCredit, String name){
        clearChat(10);
        String cardStatement = "\n"+
                "   _____              _    _____ _        _                            _   \n"+
                "  / ____|            | |  / ____| |      | |                          | |  \n"+
                " | |     __ _ _ __ __| | | (___ | |_ __ _| |_ ___ _ __ ___   ___ _ __ | |_ \n"+
                " | |    / _` | '__/ _` |  \\___ \\| __/ _` | __/ _ \\ '_ ` _ \\ / _ \\ '_ \\| __|\n"+
                " | |___| (_| | | | (_| |  ____) | || (_| | ||  __/ | | | | |  __/ | | | |_ \n"+
                "  \\_____\\__,_|_|  \\__,_| |_____/ \\__\\__,_|\\__\\___|_| |_| |_|\\___|_| |_|\\__|\n"+
                "                                                                           \n";
        System.out.println(cardStatement);
        System.out.println("_______________________________________________________" + underscoreCreator(name.length()) + "_______");

        //Account Number (Credit Card Number) and Name
        System.out.print(Methods.padR("Account Number: ", 25) + Methods.padR(creditCardNum+ " ||", 35));
        System.out.println(name);

        //Statement Closing date and Street and the number of the street
        System.out.println(Methods.padR("Statement Closing Date", 40) + Methods.padR(statementClosingDate + " ||", 35));

    }
}
