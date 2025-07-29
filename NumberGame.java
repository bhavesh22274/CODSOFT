#codsoft
import java.util.Scanner;
import java.util.Random;

public class GuessTheNumber {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        String again;

        int totalScore = 0, round = 0;

        System.out.println("Welcome to Guess The Number!");

        do {
            round++;
            int score = playRound(sc, rand);
            totalScore += score;
            System.out.println("Round " + round + " score: " + score);
            System.out.print("Play again? (yes/no): ");
            again = sc.next();
        } while (again.equalsIgnoreCase("yes"));

        System.out.println("Thanks! Rounds played: " + round + ", Total score: " + totalScore);
        sc.close();
    }

    private static int playRound(Scanner sc, Random rand) {
        int number = rand.nextInt(100) + 1;
        int attempts = 0;
        int guess;
        final int maxAttempts = 5;

        while (attempts < maxAttempts) {
            System.out.print("Guess (1-100): ");
            if (!sc.hasNextInt()) {
                sc.next(); 
                System.out.println("Invalid number.");
                continue;
            }
            guess = sc.nextInt();
            attempts++;

            if (guess == number) {
                System.out.println("Correct! Took you " + attempts + " tries.");
                return maxAttempts - attempts + 1;
            } else if (guess < number) {
                System.out.println("Too low.");
            } else {
                System.out.println("Too high.");
            }
        }

        System.out.println("Out of tries. Number was: " + number);
        return 0;
    }
}
