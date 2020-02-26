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
                printOutTheStuff(wb1);
            }
        } catch (IOException | ParameterIsNotJSONStringException e) {
            System.out.println("Exception");
        }
    }

    private static void printOutTheStuff(Webpage wb1) {
        for (Map.Entry<String, String> entry : wb1.timesAndNames.entrySet()) {
            String time = entry.getKey();
            String name = entry.getValue();
            System.out.println(name + "made an edit at: " + time);
        }

        for (Map.Entry<String, Integer> entry : wb1.namesAndEdits.entrySet()) {
            String name = entry.getKey();
            int edits = entry.getValue();
            System.out.println(name + " made " + edits + " edits");
        }
    }

}
