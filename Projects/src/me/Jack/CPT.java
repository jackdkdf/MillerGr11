package me.Jack;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class CPT {

    public void CPTLvl5() throws Exception{
        File file = new File("C:\\Users\\jack\\Documents\\MillerGr11\\Projects\\src\\resources\\JohnWickNeedsYourHelp.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

        String st;
        while ((st = br.readLine()) != null) {
            System.out.println(st);
        }
    }

}
