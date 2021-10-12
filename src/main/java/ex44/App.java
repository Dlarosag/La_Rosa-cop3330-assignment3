/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 David La Rosa
 */
package ex44;

import java.io.*;
import java.util.*;
import org.json.simple.*;
import org.json.simple.parser.*;

public class App {

    public static void main(String[] args) throws Exception {
        Scanner scnr = new Scanner(System.in);
        JSONParser parser = new JSONParser();

        Object obj = parser.parse(new FileReader("src\\main\\java\\ex44\\exercise44_input.json"));
        JSONObject jsonObject = (JSONObject) obj;

        JSONArray products = (JSONArray) jsonObject.get("products");
        Iterator<JSONObject> iterator = products.iterator();

        String name, blank;
        boolean found = false;

        System.out.print("What is the product name? ");
        name = scnr.nextLine();

        while (true) {
           while (iterator.hasNext()) {

               obj = iterator.next();

               if (obj.toString().contains(name)) {

                   String[] temp = obj.toString().split(",", 3);

                   ///// Cleans the output
                   for (int i = 0; i < 3; i++) {
                       temp[i] = temp[i].replace("{", "");
                       temp[i] = temp[i].replace("}", "");
                       temp[i] = temp[i].replace("\"", "");
                       temp[i] = temp[i].replace(":", ": ");
                   }

                   for (int i = 2; i >= 0; i--) {
                       System.out.println(temp[i]);
                   }

                   found = true;
               }
           }
           ////break if found, otherwise repeat
            if (found)
                break;

            System.out.println("Sorry, that product was not found in our inventory.");
            System.out.print("What is the product name? ");
            name = scnr.nextLine();

            iterator = products.iterator();


        }

    }
}
