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
                Webpage wb1 = JSONStringParser(json).;
                wb1.print();
            }
        } catch (IOException e) {
            System.out.println("IO Exception");
        }
    }

}
