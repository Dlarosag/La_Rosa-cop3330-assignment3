/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 David La Rosa
 */
package ex41;

import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.io.PrintStream;


public class App {

    public static void main(String[] args) throws Exception
    {
        FileReader file = new FileReader("src\\main\\java\\ex41\\exercise41_input.txt");
        File out = new File("src\\main\\java\\ex41\\exercise41_output.txt");
        Scanner scnr = new Scanner(file);

        List<String> list = new ArrayList<String>();
        List<String> sortedList = new ArrayList<String>();

        int count = 0;

        while (scnr.hasNextLine()) {
            list.add(scnr.nextLine());
        count++;
        }
        char temp;
        int index = 0;

        while(list.size() > 0)
        {
            temp = list.get(0).charAt(0);

            for(int i = 0; i < list.size(); i++)
            {
                if(temp == list.get(i).charAt(0)) {

                    temp = list.get(i).charAt(0);
                    index = i;

                }
                else if(temp > list.get(i).charAt(0)) {

                    temp = list.get(i).charAt(0);
                    index = i;

                }
            }

            sortedList.add(list.get(index));
            list.remove(index);
        }

        PrintStream stream = new PrintStream(out);

        System.setOut(stream);

        System.out.println("total of " + count + " names");

        System.out.println("----------------");

        for(int i = 0; i < sortedList.size(); i++) {

            System.out.print(sortedList.get(i) + "\n");


        }
    }
}
