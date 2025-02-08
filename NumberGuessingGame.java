import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int minVal = 1;
        int maxVal = 100;
        int maxAttempts = 10;
        int totalRounds = 0;
        int totalScore = 0;
        boolean playAgain = true;

        System.out.println("Welcome to the Number Guessing Game!");

        while (playAgain) {
            totalRounds++;
            int targetNumber = random.nextInt(maxVal - minVal + 1) + minVal;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.printf("\nRound %d: Guess the number between %d and %d!\n", totalRounds, minVal, maxVal);

            while (attempts < maxAttempts && !guessedCorrectly) {
                attempts++;
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();

                if (guess == targetNumber) {
                    System.out.printf("Congratulations! You guessed the number in %d attempts.\n", attempts);
                    guessedCorrectly = true;
                    totalScore += (maxAttempts - attempts + 1); // Score based on attempts
                } else if (guess < targetNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            if (!guessedCorrectly) {
                System.out.printf("Out of attempts! The number was %d.\n", targetNumber);
            }

            System.out.print("\nDo you want to play again? (yes/no): ");
            String playAgainInput = scanner.next().toLowerCase();
            playAgain = playAgainInput.equals("yes");
        }

        System.out.printf("\nGame Over! You played %d rounds and scored %d points.\n", totalRounds, totalScore);
        scanner.close();
    }
}