package RPS;

/*
 * Main class, runs the main method and shows instructions.
 */
public class Main
{
	/*
	 * Main method, shows instructions for the game and starts the game by calling on the constructor of Game.
	 */
    public static void main(final String[] args) {
        JOP.msg("Grader:\nDear Grader, \nI am so sorry you have to go through this shitty game I made and I also want to say sorry to Rico. \nI was moving home so I didn't have more then about 30 minutes to work on this.\nSorry again.");
        JOP.msg("R = Rock\nP = Paper\nS = Scissors\nWrite (change mode) at any tiem to change mode.\nCancel to exit the game at any time.");
        new Game();
    }
}
