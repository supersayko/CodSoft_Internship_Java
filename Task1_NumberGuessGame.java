import java.util.Random;
import java.util.Scanner;

public class Task1_NumberGuessGame {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int attempt = 0;
//        int minRange = 1;
//        int maxRange = 100;
        int maxAttempt = 7;


        System.out.println("-----------Number Game-----------");

        int correct = rand.nextInt(100)+1;
        boolean isRight = false;
        while (attempt < maxAttempt) {
            System.out.println("Enter a guess");
            int guess = sc.nextInt();
            attempt++;
            if (correct == guess) {
                System.out.println("You are right");
                isRight=true;
                break;
            } else if (correct < guess) {
                System.out.println("to low\n");
            } else {
                System.out.println("to high\n");
            }
        }

    }
}
