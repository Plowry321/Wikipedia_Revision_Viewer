import exceptions.ParameterIsNotJSONStringException;
import utils.*;
import domain.*;

import java.io.*;
import java.net.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                System.out.println("Enter a word (type 'quit' to exit):");
                String input = br.readLine();
                if (input.equals("quit")) {
                    break;
                }
                JSONStringRetriever jsr = new JSONStringRetriever(input);
                if (!jsr.isConnected()) {
                    System.out.println("Internet is not connected.");
                    break;
                }
                String json = jsr.getJSONstring();
                if (json.equals("Error")) {
                    System.out.println("No article exists. Please try again.");
                } else {
                    Webpage wb1 = JSONStringParser.ParseJSONString(json);
                    System.out.println("Type 'a' to see a list of the 30 most recent edits.");
                    System.out.println("Type 'b' to see a list of who has made the most recent edits.");
                    String displayChoice = br.readLine();
                    if (wb1.redirected) {
                        System.out.println("Redirected from: " + input + " to: " + wb1.title);
                    }
                    System.out.println("Page Title: " + wb1.title);
                    if (displayChoice.equals("a")) {
                        for (int i = wb1.editValueArray.length - 1; i > 0; i--) {
                            TimeStamp timestamp = (TimeStamp) wb1.timeStampArray[i];
                            String user = wb1.timeUserArray[i];
                            System.out.println(user + " edited page on " + timestamp.printTimeStamp());
                        }
                    } else if (displayChoice.equals("b")) {
                        for (int j = wb1.editValueArray.length - 1; j > 0; j--) {
                            String name = wb1.userArray[j].toString();
                            int edits = wb1.editValueArray[j];
                            System.out.println(name + " made " + edits + " edits");
                        }
                    } else {
                        System.out.println("Incorrect Input. Please Try again.");
                    }
                }
            }
        } catch (IOException | ParameterIsNotJSONStringException e) {
            System.out.println("Exception");
        } catch (NullPointerException e) {
            System.out.println("No Article Exists");
        }
    }
}