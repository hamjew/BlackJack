import java.util.ArrayList;

/**
 * The class that models your game. You should create a more specific
 * child of this class and instantiate the methods given.
 * @author dancye, 2018
 */
public abstract class Game 
{
    private final String gameName;
    private ArrayList <? extends Player> players;
    
    public Game(String givenName)
    {
        gameName = givenName;
        players = new ArrayList();
    }

    public String getGameName() 
    {
        return gameName;
    }
    
    public ArrayList <? extends Player> getPlayers() 
    {
        return players;
    }

    /**
     * @param players the players of this game
     */
    public void setPlayers(ArrayList<? extends Player> players) 
    {
        this.players = players;
    }
    
    /**
     * Play the game. This might be one method or many method calls depending
     * on your game.
     */
    public abstract void play();
    
    /**
     * When the game is over, use this method to declare and display a winning
     * player.
     */
    public abstract void declareWinner();

   
    
}//end class
