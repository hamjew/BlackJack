import java.util.ArrayList;
import java.util.Random;

public class Dealer {

	private ArrayList<Card> cards = new ArrayList();
	
	public void setCards(Card card) {
		cards.add(card);
	}
	
	public ArrayList<Card> getCards() {
		return this.cards;
	}
	
	public void openOneCard() {
		
		Random random = new Random();
		int randomBetweenOneAndTwo = random.nextInt(2);
		
		System.out.println("This is one of the dealer's card");
		
		System.out.println(cards.get(randomBetweenOneAndTwo));
				
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
