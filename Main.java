import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Encoder encoder = new Encoder();
        Scanner inputScanner = new Scanner(System.in);
        while (true) {
            System.out.println("Please enter the text to encode:");
            
            String input = inputScanner.nextLine();
            if (!input.isEmpty()) {
                System.out.println(
                    String.format(
                        "Encoded Text: %s",
                        encoder.encode(input)));
            }
        }
    }
}