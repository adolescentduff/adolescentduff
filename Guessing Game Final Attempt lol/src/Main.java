import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // scanner object
        Scanner scanner = new Scanner(System.in);
        // generate a random number between 1 and 100
        int random = (int)(Math.random() * 100 + 1);
        // System.out.println(random); // just a test
        // automatically set playAgain = true (so that the loop is done once), the user will be prompted to change this after the first go around
        // could actually use a do - while loop instead here but this should work just fine
        boolean playAgain = true;
        int count = 0;

        // while playAgain == true
        while(playAgain) {


            while (count < 11) {

                if (count == 10) {
                    System.out.println("sorry. you have ran out of tries.\nthe number was: " + random);
                    break;
                }


                System.out.println("enter a number between 1 - 100: ");
                int guessed = Integer.valueOf(scanner.nextLine());
                if (guessed < random) {
                    System.out.println("too low.");
                    count++;
                } else if (guessed > random) {
                    System.out.println("too high");
                    count++;
                } else {
                    System.out.println("you got it! The number was " + random);
                    count++;
                    System.out.println("It took you " + count + " tries.");
                    break;
                }
            }
            System.out.println("would you like to play again? (y/n)");
            String yn = scanner.nextLine();
            if (yn.equalsIgnoreCase("y")) {
                playAgain = true;
                random = (int)(Math.random() * 100 + 1);
                count = 0;
            } else {
                playAgain = false;
            }
        }

        System.out.println("Thank you for playing!");

	// write your code here


    }
}
