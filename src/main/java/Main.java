import exceptions.ParameterIsNotJSONStringException;
import utils.*;
import domain.*;
import java.io.*;
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
                    String json = new JSONStringRetriever(input).getJSONstring();
                    Webpage wb1 = JSONStringParser.ParseJSONString(json);
                    printOutTheStuff(wb1, input);
                }
            } catch (IOException | ParameterIsNotJSONStringException e) {
                System.out.println("Exception");
            } catch (NullPointerException e) {
                System.out.println("No Article Exists");
            }
    }

    private static void printOutTheStuff(Webpage wb1, String input) {

        if(wb1.redirected){
            System.out.println("Redirected from: " + input);
        }
        System.out.println("Page Title: " + wb1.title);
        
        for (int i = 0; i < wb1.timeStampArray.length; i++) {
            TimeStamp timestamp = (TimeStamp) wb1.timeStampArray[i];
            String user = wb1.timeUserArray[i];
            System.out.println(user + " edited page on " + timestamp.printTimeStamp());
        }

        for (int j = 0; j < wb1.editValueArray.length; j++) {
            String name = wb1.userArray[j].toString();
            int edits = wb1.editValueArray[j];
            System.out.println(name + " made " + edits + " edits");
            }
        }
}