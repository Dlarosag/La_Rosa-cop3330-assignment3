/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 David La Rosa
 */
package ex45;

import java.io.*;
import java.util.Scanner;
import java.io.PrintStream;

public class App {

    public static void main(String[] args) throws Exception
    {
        FileReader file = new FileReader("src\\main\\java\\ex45\\exercise45_input.txt");

        Scanner scnr = new Scanner(file);
        Scanner sc = new Scanner(System.in);

        String name;

        System.out.print("What is the name of the output file? ");
        name = sc.nextLine();

        File out = new File("src\\main\\java\\ex45\\" + name + ".txt");
        PrintStream stream = new PrintStream(out);
        System.setOut(stream);

        while (scnr.hasNextLine())
        {
            System.out.println(scnr.nextLine().replace("utilize","use"));
        }
    }
}
