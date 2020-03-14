import java.util.ArrayList;

public class User extends Player{
	
	private ArrayList<Card> cards = new ArrayList();
	
	public User(String name) {
		super(name);
	}
	

	@Override
	public void play() {
		
		System.out.printf("%s Entered the game!\n\n" , super.getPlayerID());
		
	}
	
	public void setCards(Card card) {
		cards.add(card);
	}
	
	@Override
	public ArrayList<Card> getCards() {
		return this.cards;
	}
	
	public void showCards() {
		for(int i = 0; i < cards.size(); i++) {
			System.out.println(cards.get(i));
		}
	}
	
	public int calculate() {
		
		int total = 0;
		
		for(int i = 0; i < cards.size(); i++) {
			
			int countForAce = 0;
			
			switch(cards.get(i).getValue()) {
				
			case TWO:
				total += 2;
				break;
			case THREE:
				total += 3;
				break;
			case FOUR:
				total += 4;
				break;
			case FIVE:
				total += 5;
				break;
			case SIX:
				total += 6;
				break;
			case SEVEN:
				total += 7;
				break;
			case EIGHT:
				total += 8;
				break;
			case NINE:
				total += 9;
				break;
			case TEN:
			case JACK:
			case QUEEN:
			case KING:
				total += 10;
				break;
			default:
				countForAce += 1;
			}
			
			for(int j = 0; j< countForAce; j++) {
				
				if(total + 11 > 21) {
					total += 1;
				}else {
					total += 11;
				}
				
			}
			
		}
		
		return total;
		
	}
	
}
