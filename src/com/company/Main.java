package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        try {

            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            Sequence s = new Sequence(bf.readLine(), ";");
            System.out.println(s.getResult());
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
