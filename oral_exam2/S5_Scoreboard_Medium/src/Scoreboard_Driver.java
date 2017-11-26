import java.awt.*;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Driver class
 */
public class Scoreboard_Driver {

    /**
     * Main method simulates the scoreboard
     *
     * @param args command arguments
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int sportNumber = 0, choice;
        String homeTeam, awayTeam;

        while (true) {
            try {
                System.out.println("Select type of game: ");
                System.out.println("1. Football\n2. Basketball\n3. Hockey");
                sportNumber = scanner.nextInt();
                if (sportNumber < 1 || sportNumber > 3) {
                    System.out.println("Must be an integer 1 - 3");
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Must be an integer 1 - 3");
                scanner.next();
            }

        }

        System.out.println("Enter team1 name: ");
        scanner.nextLine();
        homeTeam = scanner.nextLine();
        Team team1 = new Team(homeTeam);

        System.out.println("Enter team2 name: ");
        awayTeam = scanner.nextLine();
        Team team2 = new Team(awayTeam);

        System.out.println(team1.getTeamName() + " - " + team1.getScore());
        System.out.println(team2.getTeamName() + " - " + team2.getScore());


        switch (sportNumber) {
            case 1:
                Game football = new Football(team1, team2);
                while (!football.isGameOver()) {
                    System.out.println("Current " + football.getNameOfPeriod() + ": " + football.getCurrentPeriod());
                    System.out.println("Menu:");
                    System.out.println("1. " + team1.getTeamName() + " touchdown");
                    System.out.println("2. " + team1.getTeamName() + " field goal");
                    System.out.println("3. " + team1.getTeamName() + " extra point");
                    System.out.println("4. " + team1.getTeamName() + " two point conversion");
                    System.out.println("5. " + team1.getTeamName() + " safety");

                    System.out.println("6. " + team2.getTeamName() + " touchdown");
                    System.out.println("7. " + team2.getTeamName() + " field goal");
                    System.out.println("8. " + team2.getTeamName() + " extra point");
                    System.out.println("9. " + team2.getTeamName() + " two point conversion");
                    System.out.println("10. " + team2.getTeamName() + " safety");

                    System.out.println("11. End " + football.getNameOfPeriod());

                    choice = scanner.nextInt();

                    switch (choice) {
                        case 1:
                            football.addScore("touchdown", team1);
                            break;
                        case 2:
                            football.addScore("field goal", team1);
                            break;
                        case 3:
                            football.addScore("extra point", team1);
                            break;
                        case 4:
                            football.addScore("two point conversion", team1);
                            break;
                        case 5:
                            football.addScore("safety", team1);
                            break;
                        case 6:
                            football.addScore("touchdown", team2);
                            break;
                        case 7:
                            football.addScore("field goal", team2);
                            break;
                        case 8:
                            football.addScore("extra point", team2);
                            break;
                        case 9:
                            football.addScore("two point conversion", team2);
                            break;
                        case 10:
                            football.addScore("safety", team2);
                            break;
                        case 11:
                            football.endCurrentPeriod();
                            break;
                        default:
                            System.out.println("Not a valid answer");
                    }

                    //print out score, check if game is over
                    System.out.println(team1.getTeamName() + " - " + team1.getScore());
                    System.out.println(team2.getTeamName() + " - " + team2.getScore());

                }
                System.out.println("Game Over");
                System.out.println(football.getWinningTeam().getTeamName() + " won");
                break;
            case 2:
                Game basketball = new Basketball(team1, team2);
                while (!basketball.isGameOver()) {
                    System.out.println("Current " + basketball.getNameOfPeriod() + ": " + basketball.getCurrentPeriod());
                    System.out.println("Menu:");
                    System.out.println("1. " + team1.getTeamName() + " Three Pointer");
                    System.out.println("2. " + team1.getTeamName() + " Two Pointer");
                    System.out.println("3. " + team1.getTeamName() + " Free Throw");

                    System.out.println("4. " + team2.getTeamName() + " Three Pointer");
                    System.out.println("5. " + team2.getTeamName() + " Two Pointer");
                    System.out.println("6. " + team2.getTeamName() + " Free Throw");

                    System.out.println("7. End " + basketball.getNameOfPeriod());

                    choice = scanner.nextInt();

                    switch (choice) {
                        case 1:
                            basketball.addScore("Three Pointer", team1);
                            break;
                        case 2:
                            basketball.addScore("Two Pointer", team1);
                            break;
                        case 3:
                            basketball.addScore("Free Throw", team1);
                            break;
                        case 4:
                            basketball.addScore("Three Pointer", team2);
                            break;
                        case 5:
                            basketball.addScore("Two Pointer", team2);
                            break;
                        case 6:
                            basketball.addScore("Free Throw", team2);
                            break;
                        case 7:
                            basketball.endCurrentPeriod();
                            break;
                        default:
                            System.out.println("Not a valid answer");
                    }

                    System.out.println(team1.getTeamName() + " - " + team1.getScore());
                    System.out.println(team2.getTeamName() + " - " + team2.getScore());
                }
                System.out.println("Game Over");
                System.out.println(basketball.getWinningTeam().getTeamName() + " won");
                break;
            case 3:
                Game hockey = new Hockey(team1, team2);
                while (!hockey.isGameOver()) {
                    System.out.println("Current " + hockey.getNameOfPeriod() + ": " + hockey.getCurrentPeriod());
                    System.out.println("Menu:");
                    System.out.println("1. " + team1.getTeamName() + " Goal");
                    System.out.println("2. " + team2.getTeamName() + " Goal");

                    System.out.println("3. End " + hockey.getNameOfPeriod());

                    choice = scanner.nextInt();

                    switch (choice) {
                        case 1:
                            hockey.addScore("goal", team1);
                            break;
                        case 2:
                            hockey.addScore("goal", team2);
                            break;
                        case 3:
                            hockey.endCurrentPeriod();
                            break;
                        default:
                            System.out.println("Not a valid answer");
                    }

                    System.out.println(team1.getTeamName() + " - " + team1.getScore());
                    System.out.println(team2.getTeamName() + " - " + team2.getScore());
                }
                System.out.println("Game Over");
                System.out.println(hockey.getWinningTeam().getTeamName() + " won");
        }
    }
}
