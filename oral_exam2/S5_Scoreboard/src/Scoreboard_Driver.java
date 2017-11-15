public class Scoreboard_Driver {

    public static void main(String[] args) {

        System.out.println("Creating new Football game");

        /*----- setup teams and game ------*/
        Team hawkeyes = new Team("Hawkeyes");
        Team cyclones = new Team("Cyclones");

        System.out.println(hawkeyes.getTeamName() + " vs " + cyclones.getTeamName());
        /*----- start game ------*/

        Game hyveeCyHawk = new Football(hawkeyes, cyclones);
        System.out.println("Name of Period: " + hyveeCyHawk.getNameofPeriod());

        /*----- do some scoring and print the score along with what period we are at ------*/

        System.out.println("Current " + hyveeCyHawk.getNameofPeriod() + ": " + hyveeCyHawk.getCurrentPeriod());

        hyveeCyHawk.addScore("touchdown", hawkeyes);
        hyveeCyHawk.addScore("touchdown", hawkeyes);
        hyveeCyHawk.addScore("touchdown", hawkeyes);
        hyveeCyHawk.addScore("safety", hawkeyes);
        hyveeCyHawk.addScore("field goal", cyclones);

        System.out.println("Ending first quarter");
        hyveeCyHawk.endCurrentPeriod();

        System.out.println("Hawkeyes score:" + hawkeyes.getScore());
        System.out.println("Cyclones score:" + cyclones.getScore());

        /*----- end current period, print new period and do some more scoring ------*/

        System.out.println("Current " + hyveeCyHawk.getNameofPeriod() + ": " + hyveeCyHawk.getCurrentPeriod());

        hyveeCyHawk.addScore("touchdown", hawkeyes);
        hyveeCyHawk.addScore("touchdown", hawkeyes);
        hyveeCyHawk.addScore("touchdown", hawkeyes);
        hyveeCyHawk.addScore("safety", hawkeyes);
        hyveeCyHawk.addScore("field goal", cyclones);

        System.out.println("Is this game over? " + hyveeCyHawk.isGameOver());

        System.out.println("Ending second quarter");
        hyveeCyHawk.endCurrentPeriod();

        System.out.println("Hawkeyes score:" + hawkeyes.getScore());
        System.out.println("Cyclones score:" + cyclones.getScore());

        /*----- 3rd quarter and scoring------*/

        System.out.println("Current " + hyveeCyHawk.getNameofPeriod() + ": " + hyveeCyHawk.getCurrentPeriod());

        hyveeCyHawk.addScore("touchdown", hawkeyes);
        hyveeCyHawk.addScore("touchdown", hawkeyes);

        System.out.println("Ending third quarter");
        hyveeCyHawk.endCurrentPeriod();

        System.out.println("Hawkeyes score:" + hawkeyes.getScore());
        System.out.println("Cyclones score:" + cyclones.getScore());

        /*----- fourth quarter and scoring ------*/

        System.out.println("Current " + hyveeCyHawk.getNameofPeriod() + ": " + hyveeCyHawk.getCurrentPeriod());

        hyveeCyHawk.addScore("safety", hawkeyes);

        System.out.println("Ending fourth quarter");
        hyveeCyHawk.endCurrentPeriod();

        System.out.println("Hawkeyes score:" + hawkeyes.getScore());
        System.out.println("Cyclones score:" + cyclones.getScore());

        /*----- end the game ------*/

        System.out.println("Is the game over? " + hyveeCyHawk.isGameOver());


        /*


        do one with soccer and like tennis or something
         */
    }
}
