public abstract class Card 
{
	
	
	public enum Suit {HEARTS, CLUBS,SPADES,DIAMONDS};
    public enum Value{ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING}; 
	
    public abstract Value getValue();
    
    public abstract Suit getSuit();
    
    @Override
    public abstract String toString();
    
}
