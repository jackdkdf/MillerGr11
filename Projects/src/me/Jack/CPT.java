package me.Jack;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class CPT {

    public void CPTLvl5() throws Exception{
        File file = new File("C:\\Users\\jack\\Documents\\MillerGr11\\Projects\\src\\CreditCardDetails.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        ArrayList<Integer> statementClosingDate = new ArrayList<>();
        ArrayList<String> creditCardNumber = new ArrayList<>();
        ArrayList<String> names = new ArrayList<>();
        ArrayList<String> streetAddress = new ArrayList<>();
        ArrayList<String> cityName = new ArrayList<>();
        ArrayList<String> provinceName = new ArrayList<>();
        ArrayList<String> postalCode = new ArrayList<>();
        ArrayList<Double> accCreditLimit = new ArrayList<>();
        ArrayList<Double> prevBal = new ArrayList<>();

        while ((st = br.readLine()) != null) {
            StringBuilder sb = new StringBuilder(st);
            char c = st.charAt(0);
            char c1 = st.charAt(1);
            if(c == 'D'){
                    if(c1 == '1'){
                        System.out.println("Detail: Transaction Type " + st);
                    } else if (c1 == '2') {
                        System.out.println("Detail: Transaction Date " + st);
                    } else if(c1 == '3'){
                        System.out.println("Detail: Transaction Description " + st);
                    } else if(c1 == '4'){
                        System.out.println("Detail: Transaction Amount " + st);
                    }
            } else if(c == 'H'){
                if(c1 == '1'){
                    System.out.println("Statement Closing Date " + st);
                    sb.delete(0, 2);
                    statementClosingDate.add(Integer.parseInt(sb.toString()));
                } else if (c1 == '2'){
                    System.out.println("Credit Card Number " + st);
                    sb.delete(0, 2);
                    creditCardNumber.add(sb.toString());
                } else if (c1 == '3'){
                    System.out.println("Company or Individual name " + st);
                    sb.delete(0, 2);
                    names.add(sb.toString());
                } else if (c1 == '4'){
                    System.out.println("Street address " + st);
                    sb.delete(0, 2);
                    streetAddress.add(sb.toString());
                } else if (c1 == '5'){
                    System.out.println("City " + st);
                    sb.delete(0, 2);
                    cityName.add(sb.toString());
                } else if (c1 == '6'){
                    System.out.println("Province " + st);
                    sb.delete(0, 2);
                    provinceName.add(sb.toString());
                } else if (c1 == '7'){
                    System.out.println("Postal Code " + st);
                    sb.delete(0, 2);
                    postalCode.add(sb.toString());
                } else if (c1 == '8'){
                    System.out.println("Account Credit Limit " + st);
                    sb.delete(0, 2);
                    accCreditLimit.add(Double.parseDouble(sb.toString()));
                } else if (c1 == '9'){
                    System.out.println("Previous Balance " + st);
                    sb.delete(0, 2);
                    prevBal.add(Double.parseDouble(sb.toString()));
                }
            }
        }

        for(int i=0; i<names.size(); i++){
            System.out.println("Name: " + names.get(i));
            System.out.println("Street Address: " + streetAddress.get(i));
            System.out.println("City: " + cityName.get(i));
            System.out.println("Province: " + provinceName.get(i));
            System.out.println("Postal Code: " + postalCode.get(i));
            System.out.println("Account Credit Limit: " + accCreditLimit.get(i));
            System.out.println("Previous Balance: " + prevBal.get(i));
            System.out.println("\n\n\n\n");
        }

        for(int i =0; i<names.size(); i++){
            Methods.creditCardStatement(creditCardNumber.get(i), statementClosingDate.get(i), accCreditLimit.get(i), i, names.get(i));
        }


    }
}
