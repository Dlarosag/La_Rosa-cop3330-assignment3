/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 David La Rosa
 */
package ex46;

import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.io.PrintStream;


public class App {

    public static void main(String[] args) throws Exception
    {
        FileReader file = new FileReader("src\\main\\java\\ex46\\exercise46_input.txt");
        Scanner scnr = new Scanner(file);

        List<Integer> arr = new ArrayList<Integer>();
        List<String> words = new ArrayList<String>();

        String temp;
        int count = 0;

        while (scnr.hasNextLine())
        {
            temp = scnr.nextLine();
            String list[] = temp.split(" ");

            /////// Checks if first word is in array
            if(!words.contains(list[0]))
            {
              words.add(list[0]);
              arr.add(1);
            }

            /////// Checks if there is any word that is not in the array already
            ////// It will also add the word and increase the rate of this
            for(int i = 0; i < list.length; i++)
            {
                if(!words.contains(list[i]))
                {
                    words.add(list[i]);
                    arr.add(1);
                }
                else
                {
                    for(int j = 0; j < words.size(); j++)
                    {
                       if(words.get(j).equals(list[i]))
                       {
                           count = arr.get(j);

                           count++;

                           arr.add(j, count);

                           arr.remove(j + 1);
                       }
                    }
                }
            }

        }

        int max = -1, index = -1;


        ///////// This block will determine the most used word and will process it all the way down to the item before last

       for(int i = 0; i < words.size(); i++)
       {
           for(int j = 0; j < arr.size(); j++)
           {
               if(max < arr.get(j))
               {
                   index = j;
                   max = arr.get(j);
               }
           }

           System.out.print(words.get(index) + ": ");

           for(int p = 0; p < arr.get(index); p++)
           {
               System.out.print("*");
           }

           System.out.println("");

           words.remove(index);
           arr.remove(index);

           max = 0;
           index = 0;
       }

       ///// Takes care of the Last word
        System.out.print(words.get(0) + ": ");

        for(int p = 0; p < arr.get(0); p++)
        {
            System.out.print("*");
        }
    }
}