package RPS;
/*
 * Game class, it runs the game and decides a winer or a loser from a play.
 */
public class Game
{
    private int Streak2;
    private int CurStreak2;
    private int Streak1;
    private int CurStreak1;
    private int mode;
    private int Round1;
    private int Games1;
    private int Round2;
    private int RoundC;
    private int GamesC;
    
    /*
     * Creates a Game object by initializing all variables of the game.
     */
    public Game() {
        this.Streak2 = 0;
        this.CurStreak2 = 0;
        this.Streak1 = 0;
        this.CurStreak1 = 0;
        this.Round1 = 0;
        this.Games1 = 0;
        this.Round2 = 0;
        this.RoundC = 0;
        this.GamesC = 0;
        final String s = JOP.in("What game mode?(M for mutiplayer or S for single player)");
        if (s == null) {
            System.exit(0);
        }
        if (s.equalsIgnoreCase("exit")) {
            System.exit(0);
        }
        if (s.equalsIgnoreCase("change mode")) {
            new Game();
        }
        if (!s.equalsIgnoreCase("m") && !s.equalsIgnoreCase("s")) {
            new Game();
        }
        if (s.equalsIgnoreCase("m")) {
            this.mode = 2;
        }
        if (s.equalsIgnoreCase("s")) {
            this.mode = 1;
        }
        this.Streak2 = 0;
        this.CurStreak2 = 0;
        this.Streak1 = 0;
        this.CurStreak1 = 0;
        this.play(this.mode);
    }
    
    /*
     * Takes input of an int that determines the mode to  be player, single or multi.
     */
    public void play(final int mode) {
        while (true) {
            if (mode == 1) {
                final String p = this.playerMove();
                final String c = this.computerMove();
                this.checkWinner(p, c);
                JOP.msg("ROUND COUNT:\nPlayer: " + this.Round1 + "\nComputer: " + this.RoundC + "\nGAME COUNT: \n" + "Player: " + this.Games1 + "\nComputer: " + this.GamesC + "\nSTREAKS: \n" + "Player Streak: " + this.CurStreak1 + "\nPlayer Highest Streak: " + this.Streak1 + "\nComputer Streak: " + this.CurStreak2 + "\nComputer Highest Streak: " + this.Streak2);
            }
            else {
                if (mode != 2) {
                    continue;
                }
                final String p = this.player1Move();
                final String c = this.player2Move();
                this.checkWinner(p, c);
                JOP.msg("ROUND COUNT:\nPlayer1: " + this.Round1 + "\nPlayer2: " + this.RoundC + "\nGAME COUNT: \n" + "Player1: " + this.Games1 + "\nPlayer2: " + this.GamesC + "\nSTREAKS: \n" + "Player1 Streak: " + this.CurStreak1 + "\nPlayer1 Highest Streak: " + this.Streak1 + "\nPlayer2 Streak: " + this.CurStreak2 + "\nPlayer2" + " Highest Streak: " + this.Streak2);
            }
        }
    }
    
    /*
     * Reads the choice of the second player and stores it to be compared with the choice of the first player.
     */
    private String player2Move() {
        String s = JOP.in("Player2 move (R,P,S)");
        if (s == null) {
            System.exit(0);
        }
        if (s.equalsIgnoreCase("change mode")) {
            new Game();
        }
        if (!s.equalsIgnoreCase("r") && !s.equalsIgnoreCase("p") && !s.equalsIgnoreCase("s")) {
            s = this.player2Move();
        }
        if (this.mode == 1) {
            if (s.equalsIgnoreCase("r")) {
                JOP.msg("Player move: Rock");
            }
            if (s.equalsIgnoreCase("p")) {
                JOP.msg("Player move: Paper");
            }
            if (s.equalsIgnoreCase("s")) {
                JOP.msg("Player move: Scissors");
            }
        }
        return s;
    }
    
    /*
     * Check which player won by comparing their move.
     */
    private boolean checkWinner(final String p, final String c) {
        if (p.equalsIgnoreCase("s") && c.equalsIgnoreCase("r")) {
            ++this.Round2;
            ++this.RoundC;
        }
        else if (p.equalsIgnoreCase("s") && c.equalsIgnoreCase("p")) {
            ++this.Round1;
        }
        else if (p.equalsIgnoreCase("r") && c.equalsIgnoreCase("s")) {
            ++this.Round1;
        }
        else if (p.equalsIgnoreCase("r") && c.equalsIgnoreCase("p")) {
            ++this.Round2;
            ++this.RoundC;
        }
        else if (p.equalsIgnoreCase("p") && c.equalsIgnoreCase("s")) {
            ++this.Round2;
            ++this.RoundC;
        }
        else if (p.equalsIgnoreCase("p") && c.equalsIgnoreCase("r")) {
            ++this.Round1;
        }
        if (this.Round1 >= 2) {
            this.Round1 = 0;
            this.Round2 = 0;
            this.RoundC = 0;
            ++this.Games1;
            ++this.CurStreak1;
            this.CurStreak2 = 0;
            if (this.CurStreak1 > this.Streak1) {
                this.Streak1 = this.CurStreak1;
            }
            return true;
        }
        if (this.RoundC >= 2 || this.Round2 >= 2) {
            this.Round1 = 0;
            this.Round2 = 0;
            this.RoundC = 0;
            ++this.GamesC;
            ++this.CurStreak2;
            this.CurStreak1 = 0;
            if (this.CurStreak2 > this.Streak2) {
                this.Streak2 = this.CurStreak2;
            }
            return true;
        }
        return false;
    }
    
    /*
     * Chooses a random move for the computer (paper, rock, or scissors).
     */
    private String computerMove() {
        String s = "";
        final int x = (int)(Math.random() * 3.0);
        if (x == 0) {
            s = "r";
        }
        else if (x == 1) {
            s = "p";
        }
        else if (x == 2) {
            s = "s";
        }
        if (s.equalsIgnoreCase("r")) {
            JOP.msg("Computer move: Rock");
        }
        if (s.equalsIgnoreCase("p")) {
            JOP.msg("Computer move: Paper");
        }
        if (s.equalsIgnoreCase("s")) {
            JOP.msg("Computer move: Scissors");
        }
        return s;
    }
    
    /*
     * Records the move of the player when in single player.
     */
    private String playerMove() {
        String s = JOP.in("Player move (R,P,S)");
        if (s == null) {
            System.exit(0);
        }
        if (s.equalsIgnoreCase("change mode")) {
            new Game();
        }
        if (!s.equalsIgnoreCase("r") && !s.equalsIgnoreCase("p") && !s.equalsIgnoreCase("s")) {
            s = this.playerMove();
        }
        return s;
    }
    
    /*
     * Records the move of player 1 to be later compare with player 2.
     */
    private String player1Move() {
        String s = JOP.in("Player1 move (R,P,S)");
        if (s == null) {
            System.exit(0);
        }
        if (s.equalsIgnoreCase("change mode")) {
            new Game();
        }
        if (!s.equalsIgnoreCase("r") && !s.equalsIgnoreCase("p") && !s.equalsIgnoreCase("s")) {
            s = this.player1Move();
        }
        return s;
    }
}
