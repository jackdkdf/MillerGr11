package me.Jack;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.SQLOutput;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;

public class CPT {

    public void CPTLvl5() throws Exception{
        int person = 0, transactionNum = 0;
        double charges = 0, credits = 0, availCredit, credit = 0, payments = 0, purchases = 0, cashAdv = 0;
        File file = new File("C:\\Users\\Jack\\Documents\\Gr. 11 Programming\\Projects\\src\\CreditCardDetails.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        ArrayList<String> statementClosingDate = new ArrayList<>();
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

        while ((st = br.readLine()) != null) {
            StringBuilder sb = new StringBuilder(st);
            char c = st.charAt(0);
            char c1 = st.charAt(1);
            if (c == 'D') {
                if (c1 == '1') {
                    System.out.println("Detail: Transaction Type " + st);
                    sb.delete(0, 2);
                    transType.put(transactionNum, person + sb.toString());
                } else if (c1 == '2') {
                    System.out.println("Detail: Transaction Date " + st);
                    sb.delete(0, 2);
                    transDate.put(transactionNum, person + sb.toString());
                } else if (c1 == '3') {
                    System.out.println("Detail: Transaction Description " + st);
                    sb.delete(0, 2);
                    transDesc.put(transactionNum, person + sb.toString());
                } else if (c1 == '4') {
                    System.out.println("Detail: Transaction Amount " + st);
                    sb.delete(0, 2);
                    transAmt.put(transactionNum, person + sb.toString());
                    transactionNum++;
                }
            } else if (c == 'H') {
                    if (c1 == '1') {
                        sb.delete(0, 2);
                        statementClosingDate.add(sb.toString());
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

            for (int i = 0; i < names.size(); i++) {
                Methods.clearChat(20);
                DecimalFormat df = new DecimalFormat("#.00");

                //Account Number (Credit Card Number) and Name
                System.out.print(Methods.padR("Account Number: ", 25) + Methods.padR(creditCardNumber.get(i), 50));
                System.out.println(Methods.padR("Name: ", 10) + names.get(i));

                //Statement Closing date and Street and the number of the street
                String year = statementClosingDate.get(i).substring(0, 4);
                String month = statementClosingDate.get(i).substring(4, 6);
                String day = statementClosingDate.get(i).substring(6,8);
                System.out.print(Methods.padR("Statement Closing Date:", 34) + Methods.padR(year + "/" + month + "/" + day, 41));
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
                            case "PR":
                                charges += parsedAmt;
                                purchases += parsedAmt;
                                break;
                            case "CR":
                                credits += parsedAmt;
                                credit += parsedAmt;
                                break;
                            case "CA":
                                charges += parsedAmt;
                                cashAdv += parsedAmt;
                                break;
                            case "PY":
                                credits += parsedAmt;
                                payments += parsedAmt;
                                break;
                        }
                    }
                }

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



                System.out.println("\n\n");
                System.out.println(Methods.padR("Transaction Type", 25) + Methods.padR("Transaction Date", 25) + Methods.padR("Transaction Description", 30) + Methods.padR("Transaction Amount", 25));
                for(int j=0; j < transType.size(); j++){
                    int b = (i) + '1';
                    int ascii = (int) transType.get(j).charAt(0);
                    if(ascii == b){
                        String tempType  = transType.get(j).substring(1, 3);
                        switch(tempType){
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

                        String transYear= transDate.get(j).substring(1, 5);
                        String transMonth = transDate.get(j).substring(5, 7);
                        String transDay = transDate.get(j).substring(7, 9);
                        System.out.print(Methods.padR(transYear + "/" + transMonth + "/" + transDay, 25));
                        String desc = transDesc.get(j).substring(1);
                        System.out.print(Methods.padR(desc, 30));

                        String amt = transAmt.get(j).substring(1);
                        System.out.println("$" + amt);

                    }
                }
            }
    }
}
