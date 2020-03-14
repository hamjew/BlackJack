import java.util.ArrayList;
import java.util.Collections;


/**
 * A concrete class that represents any grouping of cards for a Game.
 * HINT, you might want to subclass this more than once.
 * The group of cards has a maximum size attribute which is flexible for reuse.
 * @author dancye
 */
public class GroupOfCards 
{
   
    //The group of cards, stored in an ArrayList
    private ArrayList <Card> cards;
    private int size;//the size of the grouping
    
    public GroupOfCards(int givenSize)
    {
        size = givenSize;
    }
    
    /**
     * A method that will get the group of cards as an ArrayList
     * @return the group of cards.
     */
    public ArrayList<Card> showCards()
    {
        return cards;
    }
    
    public void shuffle()
    {
        Collections.shuffle(cards);
    }

    /**
     * @return the size of the group of cards
     */
    public int getSize() {
        return size;
    }

    /**
     * @param givenSize the max size for the group of cards
     */
    public void setSize(int givenSize) {
        size = givenSize;
    }
    
    public void setCards(ArrayList<Card> cards) {
    	this.cards = cards;
    }
    
    public void distributeCards(ArrayList<User> users) {
    	
    	for(int i = 0; i < users.size(); i++) {
    		for(int j = 0; j < size; j++) {
    			users.get(i).setCards(cards.get(0));
    			cards.remove(0);    			
    		}
    	}
    	
    }
    
    public void distributeCards(Dealer dealer) {
    	
    	for(int i = 0; i< size; i++) {
    		dealer.setCards(cards.get(0));
    		cards.remove(0);
    	}
    	
    }
    
    public void distributeCards(User user) {
    	user.setCards(cards.get(0));
    	System.out.printf("Here's new card %s\n",cards.get(0));
    	cards.remove(0);
    }
    
    public void distributeNewCard(Dealer dealer) {
    	dealer.setCards(cards.get(0));
    	cards.remove(0);
    }
    
}
