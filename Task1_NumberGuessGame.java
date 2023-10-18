import java.util.Random;
import java.util.Scanner;

public class Task1_NumberGuessGame {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

//        int minRange = 1;
//        int maxRange = 100;
        int maxAttempt = 7;

        int score = 0;

        boolean playAgain = true;
        while(playAgain) {
            System.out.println("-----------Number Game-----------");
            int target = rand.nextInt(100) + 1;
            int attempt = 0;
            boolean isTrue = false;
            while (attempt < maxAttempt) {
                System.out.println("Enter a guess");
                int userGuess = sc.nextInt();
                attempt++;
                if (target == userGuess) {
                    System.out.printf("You are right, You guessed the number in %d attempts.\n", attempt);
                    score += attempt;
                    isTrue = true;
                    break;
                } else if (target < userGuess) {
                    System.out.println("to high\n");
                } else {
                    System.out.println("to low\n");
                }
            }

            System.out.println("Your score is " + score);

            if (!isTrue) {
                System.out.println("Sorry, you have no attempts left. The Correct answer was " + target);
            }

            System.out.print("You want to play again? (yes/no): ");
            String playAgainInput = sc.next().toLowerCase();

            if (!playAgainInput.equals("yes")){
                playAgain=false;
            }

        }
        System.out.println("Thank you for playing! Your final score: " + score);
        sc.close();
    }
}
