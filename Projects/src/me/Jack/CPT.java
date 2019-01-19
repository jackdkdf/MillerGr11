package me.Jack;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class CPT {

    //Declaring all my variables
    double charges = 0, credits = 0, availCredit, credit = 0, payments = 0, purchases = 0, cashAdv = 0, interest = 0, newBal = 0, calcPurchaseInt = 0, calcCashAdvInt = 0, minPayment = 0;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/M/dd");
    int person = 0, transactionNum = 0;
    double purchaseInt = 19.96, cashAdvInt = 22.9;
    DecimalFormat df = new DecimalFormat("#.00");
    DecimalFormat df4 = new DecimalFormat("#.0000");

    public void CPTLvl5() throws Exception{
        //Declares a file path to read from
        File file = new File("C:\\Users\\Jack\\Documents\\Gr. 11 Programming\\Projects\\src\\CreditCardDetails.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        //Declaring a temporary string called st and arraylists to store values dynamically
        String st;
        ArrayList<Calendar> statementClosingDate = new ArrayList<>();
        ArrayList<String> creditCardNumber = new ArrayList<>();
        ArrayList<String> names = new ArrayList<>();
        ArrayList<String> streetAddress = new ArrayList<>();
        ArrayList<String> cityName = new ArrayList<>();
        ArrayList<String> provinceName = new ArrayList<>();
        ArrayList<String> postalCode = new ArrayList<>();
        ArrayList<Double> accCreditLimit = new ArrayList<>();
        ArrayList<Double> prevBal = new ArrayList<>();
        HashMap<Integer, String> transType = new HashMap<>();
        HashMap<Integer, String> transDate = new HashMap<>();
        HashMap<Integer, String> transDesc = new HashMap<>();
        HashMap<Integer, String> transAmt = new HashMap<>();

        //Reads input from file and splits the information up into its required variables
        //Keeps going until there is no more information in the file
        while ((st = br.readLine()) != null) {
            StringBuilder sb = new StringBuilder(st);
            char c = st.charAt(0);
            char c1 = st.charAt(1);
            //Reads detail values
            if (c == 'D') {
                if (c1 == '1') {
                    sb.delete(0, 2);
                    transType.put(transactionNum, person + sb.toString());
                } else if (c1 == '2') {
                    sb.delete(0, 2);
                    transDate.put(transactionNum, person + sb.toString());
                } else if (c1 == '3') {
                    sb.delete(0, 2);
                    transDesc.put(transactionNum, person + sb.toString());
                } else if (c1 == '4') {
                    sb.delete(0, 2);
                    transAmt.put(transactionNum, person + sb.toString());
                    //Tracks the transaction number
                    transactionNum++;
                }
                //Reads header values
            } else if (c == 'H') {
                    if (c1 == '1') {
                        sb.delete(0, 2);
                        int year = Integer.parseInt(sb.toString().substring(0, 4));
                        int month = Integer.parseInt(sb.toString().substring(4, 6));
                        int day = Integer.parseInt(sb.toString().substring(6,8));
                        Calendar cal = new GregorianCalendar();
                        cal.set(Calendar.YEAR, year);
                        cal.set(Calendar.MONTH, month-1);
                        cal.set(Calendar.DAY_OF_MONTH, day);
                        statementClosingDate.add(cal);
                        //Changes the person that the information is being stored to
                        person++;
                    } else if (c1 == '2') {
                        sb.delete(0, 2);
                        creditCardNumber.add(sb.toString());
                    } else if (c1 == '3') {
                        sb.delete(0, 2);
                        names.add(sb.toString());
                    } else if (c1 == '4') {
                        sb.delete(0, 2);
                        streetAddress.add(sb.toString());
                    } else if (c1 == '5') {
                        sb.delete(0, 2);
                        cityName.add(sb.toString());
                    } else if (c1 == '6') {
                        sb.delete(0, 2);
                        provinceName.add(sb.toString());
                    } else if (c1 == '7') {
                        sb.delete(0, 2);
                        postalCode.add(sb.toString());
                    } else if (c1 == '8') {
                        sb.delete(0, 2);
                        accCreditLimit.add(Double.parseDouble(sb.toString()));
                    } else if (c1 == '9') {
                        sb.delete(0, 2);
                        prevBal.add(Double.parseDouble(sb.toString()));
                    }
                }
            }

            //Have an array that runs for each person
            for (int i = 0; i < names.size(); i++) {
                //Clears the chat
                Methods.clearChat(20);

                //Declares when a new invoice is outputted
                System.out.println("CARD STATEMENT");

                //Account Number (Credit Card Number) and Name
                System.out.print(Methods.padR("Account Number: ", 25) + Methods.padR(creditCardNumber.get(i), 50));
                System.out.println(Methods.padR("Name: ", 10) + names.get(i));

                //Statement Closing date and Street and the number of the street
                System.out.print(Methods.padR("Statement Closing Date:", 34) + (Methods.padR(sdf.format(statementClosingDate.get(i).getTime()) + "", 41)));
                System.out.println(Methods.padR("Address: ", 10) + streetAddress.get(i));

                //Line of credit
                System.out.print("Credit Line: " + Methods.padL("$" + df.format(accCreditLimit.get(i)), 31) + Methods.padR("", 31));
                System.out.println(Methods.padR("Area: ", 10) + cityName.get(i) + ", " + provinceName.get(i) + ", " + postalCode.get(i));

                for(int j=0; j < transType.size(); j++){
                    int b = (i) + '1';
                    int ascii = (int) transType.get(j).charAt(0);
                    if(ascii == b){
                        String tempType  = transType.get(j).substring(1, 3);
                        String amt = transAmt.get(j).substring(1);
                        double parsedAmt = Double.parseDouble(amt);
                        switch(tempType){
                            //PR and CA are used to calculate purchases, cash advance and the total charges, CR and PY are used to store credit, payments and total credit
                            case "PR":
                                charges += parsedAmt;
                                purchases += parsedAmt;
                                //If the previous balance is not paid off it calculates interest, otherwise no interest is added
                                if(prevBal.get(i) - credits > 0){
                                    int days = Methods.daysBetween(transDate.get(j), statementClosingDate.get(i).getTime());
                                    calcPurchaseInt += (purchaseInt/365) * days;
                                } else {
                                    calcPurchaseInt = 0;
                                }
                                break;
                            case "CR":
                                credits += parsedAmt;
                                credit += parsedAmt;
                                break;
                            case "CA":
                                charges += parsedAmt;
                                cashAdv += parsedAmt;
                                //If the previous balance is not paid off it calculates interest, otherwise no interest is added
                                if(prevBal.get(i) - credits > 0){
                                    int days = Methods.daysBetween(transDate.get(j), statementClosingDate.get(i).getTime());
                                    calcCashAdvInt += (cashAdvInt/365) * days;

                                } else {
                                    calcCashAdvInt = 0;
                                }
                                break;
                            case "PY":
                                credits += parsedAmt;
                                payments += parsedAmt;
                                break;
                        }
                    }
                }

                //Calculates total interest
                interest += calcCashAdvInt + calcPurchaseInt;

                //Calculating available credit by taking the total line of credit and subtracting the previous balance added with the total credits and charges
                availCredit = accCreditLimit.get(i) - (prevBal.get(i) - credits + charges);

                //Calculate Available balance
                System.out.println("Available Credit: " + Methods.padL("$" + availCredit, 26));

                //Account Summary
                Methods.clearChat(2);
                System.out.println("ACCOUNT SUMMARY");
                System.out.println("Previous Balance: " + Methods.padL("$" + prevBal.get(i), 26));
                System.out.println("- Credits: " + Methods.padL("$" + df.format(credit), 33));
                System.out.println("- Payments: " + Methods.padL("$" + df.format(payments), 32));
                System.out.println("+ Purchases: " + Methods.padL("$" + df.format(purchases), 31));
                System.out.println("+ Cash Advances: " + Methods.padL("$" + df.format(cashAdv), 27));
                System.out.println("+ Interest: " + Methods.padL("$" + df.format(interest), 32));
                //Calculate the new balance (Subtracts the available credit from the Account's Line of Credit)
                newBal = accCreditLimit.get(i) - availCredit;
                System.out.println("= New Balance: " + Methods.padL("$" + df.format(newBal) , 29));

                //Displays the Payment Information (New balance, minimum payment and the scheduled payment
                System.out.println("PAYMENT INFORMATION");
                System.out.println("New Balance: " + Methods.padL("$" + df.format(newBal), 31));
                //Calculates if 5% is greater than 10 dollars
                if(newBal * 0.05 > 10){
                    //If so the minimum payment is 5 percent of the new balance
                    minPayment = newBal * 0.05;
                } else {
                    //Otherwise it is just 10 dollars
                    minPayment = 10;
                }

                //Outputs the information we just calculated
                System.out.println("Scheduled Minimum Payment: " + Methods.padL("$" + df.format(minPayment), 17));
                //Fetches the calendar for the account, takes the date and then adds 21 days
                Calendar newCal = statementClosingDate.get(i);
                newCal.add(Calendar.DATE, 21);
                //Prints out our new Due Date
                System.out.println(Methods.padR("Scheduled Payment Due Date: ", 35) + sdf.format(newCal.getTime()));

                Methods.clearChat(2);
                //Shows interest rates (I was a little confused about these but maybe I can clarify with you on Monday)
                System.out.println(Methods.padR("Type of Balance", 25) + Methods.padR("ANNUAL PERCENTAGE RATE", 30) + Methods.padR("DAILY FINANCE RATE", 25) + "Average Daily Balance");
                System.out.println(Methods.padR("PURCHASES", 25) + Methods.padR(purchaseInt + "%", 30) + Methods.padR(df4.format(purchaseInt/365) + "%", 25) + "$" + df4.format(calcPurchaseInt/21));
                System.out.println(Methods.padR("CASH ADVANCES", 25) + Methods.padR(cashAdvInt + "%", 30) + Methods.padR(df4.format(cashAdvInt/365) + "%", 25) + "$" + df4.format(calcCashAdvInt/21));

                Methods.clearChat(2);
                //Lists all transactions and details including the type, the date, the description and the amount in dollars
                System.out.println(Methods.padR("Transaction Type", 25) + Methods.padR("Transaction Date", 25) + Methods.padR("Transaction Description", 30) + Methods.padR("Transaction Amount", 22) + Methods.padR("Credits", 10) + "Charges");
                for(int j=0; j < transType.size(); j++){
                    //Converts the i variable to its ascii value (a pain in the ass)
                    int b = (i) + '1';
                    //Checks if it is the correct person
                    int ascii = (int) transType.get(j).charAt(0);
                    if(ascii == b){
                        //If it chooses the correct person then follow through with the switch
                        String tempType  = transType.get(j).substring(1, 3);
                        switch(tempType){
                            //The following lists the type of purchase for the transaction type header
                            case "PR":
                                System.out.print(Methods.padR("Purchase", 25));
                                break;
                            case "CR":
                                System.out.print(Methods.padR("Credit", 25));
                                break;
                            case "CA":
                                System.out.print(Methods.padR("Cash Advance", 25));
                                break;
                            case "PY":
                                System.out.print(Methods.padR("Payment", 25));
                                break;
                        }

                        //Prints out the date of the transaction
                        String transYear= transDate.get(j).substring(1, 5);
                        String transMonth = transDate.get(j).substring(5, 7);
                        String transDay = transDate.get(j).substring(7, 9);
                        System.out.print(Methods.padR(transYear + "/" + transMonth + "/" + transDay, 25));

                        //Prints out the description of the transaction
                        String desc = transDesc.get(j).substring(1);
                        System.out.print(Methods.padR(desc, 30));

                        //Prints out the price of the transaction
                        String amt = transAmt.get(j).substring(1);
                        System.out.println("$" + amt);
                    }
                }
                //Prints out total credits and charges
                System.out.println(Methods.padL("$" + df.format(credits), 108));
                System.out.println(Methods.padL("$" + df.format(charges), 119));

                //Resets all values for every person
                reset();
            }
    }

    public void reset(){
         charges = 0;
         credits = 0;
         credit = 0;
         payments = 0;
         purchases = 0;
         cashAdv = 0;
         interest = 0;
         calcPurchaseInt = 0;
         calcCashAdvInt = 0;
         newBal = 0;
         minPayment = 0;
    }
}
