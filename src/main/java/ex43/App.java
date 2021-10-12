/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 David La Rosa
 */
package ex43;

import java.io.*;
import java.util.Scanner;

public class App {

    public static void main(String[] args)throws Exception
    {
        Scanner scnr = new Scanner(System.in);
        String name, author, q1, q2;

        System.out.print("Site name: ");
        name = scnr.nextLine();

        System.out.print("Author: ");
        author = scnr.nextLine();

        System.out.print("Do you want a folder for JavaScript? ");
        q1 = scnr.nextLine();

        System.out.print("Do you want a folder for CSS? ");
        q2 = scnr.nextLine();

        File web = new File("src\\main\\java\\ex43\\"+ name + ".txt");
        web.createNewFile();
        System.out.println("Created ./website/" + name);


        File index = new File("src\\main\\java\\ex43\\index.html");

        BufferedWriter bw = new BufferedWriter(new FileWriter(index));
        bw.write("<html><head><title></title>" + name + "</meta>"+ author + "</html>");
        bw.close();
        System.out.println("Created ./website/" + name + "/index.html");

        if(q1.toLowerCase().charAt(0) == 'y')
        {
            File w1 = new File("src\\main\\java\\ex43\\js");
            w1.mkdir();
            System.out.println("Created ./website/" + name + "/js/");
        }


        if(q2.toLowerCase().charAt(0) == 'y')
        {
            File w2 = new File("src\\main\\java\\ex43\\css");
            w2.mkdir();
            System.out.println("Created ./website/" + name + "/css/");
        }
    }
}
