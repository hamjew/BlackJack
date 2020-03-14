import java.util.ArrayList;

public class Main {
	
	public static void main(String[] args) {
		
		Console.open();
		
		ArrayList<User> users = settingOfGame();
		
		Dealer dealer = new Dealer();
		
		GroupOfCards groupCards = generatingCards();
		
		distributeCards(groupCards, users, dealer);
		
		AskingHitOrStand(groupCards, users);
		
		GameForBlackJack blackJack = new GameForBlackJack("Black Jack");
		
		CalculatDealerCards(groupCards, dealer, blackJack);
		
		CalculateUsersCards(users, blackJack);
		
		whoWin(users, dealer, blackJack);
		
		Console.close();
	}
	
	static ArrayList<User> settingOfGame() {
		
		System.out.println("Welcome to Black Jack!");
		
		ArrayList<User> result = new ArrayList();
		
		int theNumberOfPlayers = Console.getInt("How mnay players?");
		
		for(int i = 0; i < theNumberOfPlayers; i++) {
			String ID = Console.getString(String.format("Enter the %dnth player's ID : ", i+1));
			result.add(new User(ID));
			result.get(i).play();
		}
		
		return result;
		
	}
	
	
	static GroupOfCards generatingCards() {
		
		GroupOfCards groupCards = new GroupOfCards(2);
		
	    ArrayList <Card> cards = new ArrayList();
		
    	for(Card.Suit s: Card.Suit.values()) {
                for(Card.Value v: Card.Value.values()) {
                
                    cards.add(new CardForBlackJack(s,v));
                    
                    
                }
    	}
		
    	groupCards.setCards(cards);
    	
    	return groupCards;
    	
	}
	
	static void distributeCards(GroupOfCards groupCards, ArrayList<User> users, Dealer dealer) {
		
		for(int i = 0; i< 10; i++) {
			groupCards.shuffle();
		}
		
		groupCards.distributeCards(users);
		groupCards.distributeCards(dealer);
		
		dealer.openOneCard();
		
		for(int i = 0; i < users.size(); i++) {
			System.out.printf("\nCards of %s\n", users.get(i).getPlayerID());
			users.get(i).showCards();
		}
		
	}
	
	static void AskingHitOrStand(GroupOfCards groupCards, ArrayList<User> users) {
		
		for(int i = 0; i < users.size(); i++) {
			
			boolean result1 = Console.getBoolean(String.format("\nDo you want to draw a new card, %s?", users.get(i).getPlayerID()));
			
			if(result1) {
				
				groupCards.distributeCards(users.get(i));
				
				while(true) {
					
					boolean result2 =  Console.getBoolean(String.format("\nDo you want to draw another new card, %s?", users.get(i).getPlayerID()));
					
					if(result2 == false) {
						break;
					}
					
					groupCards.distributeCards(users.get(i));
				
				}
			}
			
		}
	
	}
	
	static void CalculatDealerCards(GroupOfCards groupCards, Dealer dealer, GameForBlackJack blackJack) {
		
		int totalNumber = dealer.calculate();
		
		if(totalNumber < 17) {
			
			System.out.println("Dealer draws a new card");
			
			groupCards.distributeNewCard(dealer);
			
			totalNumber = dealer.calculate();
			
			while(totalNumber < 17) {
							
				System.out.println("Dealer draws another card");
				
				totalNumber = dealer.calculate();
				
			}
		} else {
			
			System.out.println("Dealer stays");
			
		}
		
		blackJack.setNumberForDealer(totalNumber);
		
	}
	
	static void CalculateUsersCards(ArrayList<User> users, GameForBlackJack blackJack) {
		
		int[] numberForUsers = new int[users.size()];
		
		for(int i = 0; i < numberForUsers.length; i++) {
			int total = users.get(i).calculate();
			numberForUsers[i] = total;
		}
		
		blackJack.setNumberForUsers(numberForUsers);
		
	}
	
	static void whoWin(ArrayList<User> users, Dealer dealer, GameForBlackJack blackJack) {
		
		blackJack.setPlayers(users);
		blackJack.setDealer(dealer);
		blackJack.declareWinner();
	}
	
}
