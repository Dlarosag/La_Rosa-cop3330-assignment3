/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 David La Rosa
 */
package ex42;

import java.nio.*;
import java.io.*;
import java.util.*;
import java.util.Scanner;



public class App {

    public static void main(String[] args) throws Exception
    {
        FileReader file = new FileReader("src\\main\\java\\ex42\\exercise42_input.txt");

        Scanner scnr = new Scanner(file);

        List<String> last = new ArrayList<String>();
        List<String> first = new ArrayList<String>();
        List<String> salary = new ArrayList<String>();
        List<String> source = new ArrayList<String>();

        int i = 0, p;

        while (scnr.hasNextLine()) {

            source.add(scnr.nextLine());

            String[] temp =  source.get(i).split(",", 3);

            last.add(temp[0]);
            first.add(temp[1]);
            salary.add(temp[2]);

            i++;

        }

        Formatter fmt = new Formatter();

        fmt.format("%8s %10s %10s\n", "Last", "First", "Salary");

        fmt.format("%1s \n", "--------------------------------");

        for(int j = 0; j < i; j++)
        {
            fmt.format("%8s %10s %10s\n", last.get(j), first.get(j), salary.get(j));
        }

        System.out.print(fmt);



    }
}
