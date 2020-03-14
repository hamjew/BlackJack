import java.util.ArrayList;

public class GameForBlackJack extends Game{
	
	private int numberForDealer;
	private int[] numberForUsers;
	private Dealer dealer;
	
	public GameForBlackJack(String givenName) {
		
		super(givenName);
	
	}
	
	@Override
	public void play() {
		
	}
	
	@Override
	public void declareWinner() {
		
		System.out.println();
		System.out.println("Dealer's Cards");
		System.out.println(dealer.getCards());
		System.out.printf("Dealer's total number : %d\n", numberForDealer);
		
		for(int i = 0; i < numberForUsers.length; i++) {
			
			System.out.printf("%s's Cards \n", getPlayers().get(i).getPlayerID());
			System.out.println(getPlayers().get(i).getCards());
			System.out.printf("%s's total Number : %d\n",getPlayers().get(i).getPlayerID(), numberForUsers[i]);
			
			if(numberForUsers[i] > 21 && numberForDealer > 21) {
				System.out.println("DraW!\n");
			}else if(numberForUsers[i] > 21 && numberForDealer < 21) {
				System.out.printf("%s lost!\n\n", getPlayers().get(i).getPlayerID());
			}else if(numberForDealer > 21 && numberForUsers[i] < 21) {
				System.out.printf("%s Won!\n\n",getPlayers().get(i).getPlayerID());
			}else {
				if(numberForUsers[i] > numberForDealer) {
					System.out.printf("%s Won!\n\n",getPlayers().get(i).getPlayerID());
				}else if(numberForUsers[i] == numberForDealer) {
					System.out.printf("%s Drew!\n\n", getPlayers().get(i).getPlayerID());
				}else {
					System.out.printf("%s lost!\n\n", getPlayers().get(i).getPlayerID());
				}
			}
		}
		
	}
	
	public void setNumberForDealer(int number) {
		this.numberForDealer = number;
	}
	
	public int getNumberForDealer() {
		return this.numberForDealer;
	}
	
	public void setNumberForUsers(int[] numberForUsers) {
		this.numberForUsers = numberForUsers;
	}
	
	public int[] getNumberForUsers() {
		return this.numberForUsers;
	}
	
	public void setDealer(Dealer dealer) {
		this.dealer = dealer;
	}
	
}
