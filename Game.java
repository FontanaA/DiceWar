import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {
    /*public Game() {
        runGame();
    }*/
    public /*void run*/ Game() {
        //generate scanner
        Scanner input = new Scanner(System.in);

        //intro
        System.out.println(
                "This is a game of random numbers, no skill, " +
                        "just luck, and random numbers.");
        System.out.println("Each player has a die to roll. Who ever gets the highest number in a round gets a point" +
                "who ever gets the most points wins.");

        //get s number of rounds to play, with error checks
        int numRounds = 0;
        do {
            System.out.println("Enter number of rounds > ");
            try {
                numRounds = input.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Please input a correct number");
            }
            input.nextLine();
        } while(numRounds <= 0);
        //gets side number ofr p1's die, with error checking
        int numSidesP1 = 0;
        do {
            System.out.println("Enter number of sides for player 1's die > ");
            try {
                numSidesP1 = input.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Please input a correct number");
            }
            input.nextLine();
        } while(numSidesP1 <= 2);
        //gets side number of p2's die, with error checking
        int numSidesP2 = 0;
        do {
            System.out.println("Enter number of sides for player 2's die > ");
            try {
                numSidesP2 = input.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Please input a correct number");
            }
            input.nextLine();
        } while(numSidesP2 <= 2);
        //type of die for p1 with error checking
        int type1 = 0;
        do {
            System.out.println("Enter type of die for player 1's die (1 for normal, and 2 for loaded)> ");
            try {
                type1 = input.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Please input a correct number");
            }
            input.nextLine();
        } while(type1 <= 0 || type1 >= 3);
        //type of die for p2 with error checking
        int type2 = 0;
        do {
            System.out.println("Enter type of die for player 2's die (1 for normal, and 2 for loaded)> ");
            try {
                type2 = input.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Please input a correct number");
            }
            input.nextLine();
        } while(type2 <= 0 || type2 >= 3);
        //construct appropriate die for p1
        Die p1;
        if(type1 == 2){
            p1 = new LoadedDie(numSidesP1);
        } else {
            p1 = new Die(numSidesP1);
        }
        //construct appropriate die for p2
        Die p2;
        if(type2 == 2){
            p2 = new LoadedDie(numSidesP2);
        } else {
            p2 = new Die(numSidesP2);
        }
        //sets
        int p1Value;
        int p2Value;
        //sets starting point values for each player
        int p1Points = 0;
        int p2Points = 0;
        //total rolls
        float p1RollsTotal = 0;
        float p2RollsTotal = 0;

        //the code for each round
        for(int i = 1; i <= numRounds; i ++){
            //roll
            p1Value = p1.returnNum();
            p2Value = p2.returnNum();
            p1RollsTotal += p1Value;
            p2RollsTotal += p2Value;
            //display info
            System.out.println("--------------------------------------------------");
            System.out.println("|\tRound: " + i);
            System.out.println("|\tPlayer 1 rolled: " + p1Value);
            System.out.println("|\tPlayer 2 rolled: " + p2Value);
            System.out.println("|");
            //print(die types)
            System.out.print("|\tPlayer 1's die is a " + numSidesP1 + " sided die, type: ");
            if(type1 == 1){
                System.out.println("Normal");
            } else{
                System.out.println("Loaded");
            }
            System.out.print("|\tPlayer 2's die is a " + numSidesP2 + " sided die, type: ");
            if(type2 == 1){
                System.out.println("Normal");
            } else{
                System.out.println("Loaded");
            }
            System.out.println("|");
            //score
            if(p1Value > p2Value) {
                p1Points++;
                System.out.println("|\tPlayer 1 wins the round!");
            } else if(p2Value > p1Value) {
                p2Points++;
                System.out.println("|\tPlayer 2 wins the round!");
            } else {
                System.out.println("|\tTie!");
            }
            //if last round, prints results
            if(i == numRounds){
                System.out.println("|\n|\tPlayer 1 got: " + p1Points + " points");
                System.out.println("|\tPlayer 2 got: " + p2Points +  " points");
                if(p1Points > p2Points) {
                    System.out.println("|\n|\tPlayer 1 wins the game!");
                } else if(p2Points > p1Points) {
                    System.out.println("|\n|\tPlayer 2 wins the game!");
                } else {
                    System.out.println("|\n|\tTie game!");
                }
                System.out.println("|\n|\tP1s average Roll is: " + p1RollsTotal/numRounds);
                System.out.println("|\tP2s average Roll is: " + p2RollsTotal/numRounds);
                System.out.println("------------------------------------------------");
            }
            try{
                Thread.sleep(2000);
            }catch(InterruptedException e){
                System.out.println(e);
                System.exit(1);
            }
        }
    }
    public static void main(String[] args) {
        Game r = new Game();
        /*Die y;
        float tot = 0;
        int x;
        for(int i = 0; i < 100; i++) {
            y = new LoadedDie(6);
            x = y.returnNum();
            System.out.println(x);
            tot+= x;
        }
        System.out.println(tot);
        System.out.println((float)tot / 100);*/
    }
}
