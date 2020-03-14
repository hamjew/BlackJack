public class CardForBlackJack extends Card{
	

	private final Suit suit;
    private final Value value;
	
    public CardForBlackJack(Suit s, Value gVal)
    {
       suit =s;
       value= gVal;
    }
    
    @Override
	public Value getValue() {
		return this.value;
	}

	@Override
	public Suit getSuit() {
		return this.suit;
    }
	
	@Override
	public String toString() {
		
		return String.format("%s %s", suit, value);
		
	}
	
}	
