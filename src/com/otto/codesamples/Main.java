package com.otto.codesamples;

import java.io.*;
import java.util.*;

import static java.util.Arrays.*;


public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        //Creating I/O tools

        Scanner sc = new Scanner(new File("C:\\Users\\Asguard\\IdeaProjects\\Chess\\input.txt"));
        PrintWriter pw = new PrintWriter(new File("C:\\Users\\Asguard\\IdeaProjects\\Chess\\output.txt"));

        //Reading input

        String input = sc.nextLine();
        StringBuilder builder = new StringBuilder(input);

        if (builder.length() != 5) {    //we need length of 5 characters
            pw.println("ERROR");
        } else {
            char char1 = builder.charAt(0);
            char char2 = builder.charAt(1);
            char char3 = builder.charAt(2);
            char char4 = builder.charAt(3);
            char char5 = builder.charAt(4);

            //Finding out, if input matches requirements

            char[] letters = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};
            char[] digits = {'1', '2', '3', '4', '5', '6', '7', '8'};
            char delimeter = '-';

            sort(letters);
            sort(digits);       //Arrays.sort() required before invoking Arrays.binarySearch() method

            int c1 = binarySearch(letters, char1);
            int c2 = binarySearch(digits, char2);
            int c4 = binarySearch(letters, char4);
            int c5 = binarySearch(digits, char5);


            int checkLetter = char1 - char4;    //this will help us check the horse move
            int checkDigit = char2 - char5;

            int[] checkList1 = {-1, 1};
            int[] checkList2 = {-2, 2};

            if (c1 >= 0 && c2 >= 0 && c4 >= 0 && c5 >= 0 && delimeter == char3) {   //Check if input is correct

                //This long IF checks the horse move

                if ((binarySearch(checkList1, checkLetter) >=0 && binarySearch(checkList2, checkDigit)>=0) || (binarySearch(checkList1, checkDigit) >=0 && binarySearch(checkList2, checkLetter)>=0)) {
                    pw.println("YES");
                } else {
                    pw.println("NO");
                }
            } else {
                pw.println("ERROR");
            }
        }
        pw.close();
    }
}
