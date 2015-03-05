import java.util.ArrayList;
import java.util.Random;


public class Deck {
	public class Card {
		int value;
		int category;
		
		public Card (int t_value, int t_category) throws Exception {
			if ( t_value < 1 || t_value > 13 || t_category < 1 || t_category > 4) {
				throw new Exception("Invalid value for the card:" + t_value + "," + t_category);
			}
			value = t_value;
			category = t_category;
		}
	}
	
	static int ValueMAX = 13;
	static int CategoryMAX = 4;
	ArrayList<Card> cards;
	private Random generator = new Random(System.currentTimeMillis());
	int currentIndex = 0;
	
	public Deck() throws Exception{
		cards = new ArrayList<Card>();
		for (int i = 1; i <= CategoryMAX; i++) {
			for (int j = 1; j <= ValueMAX; j++) {
				cards.add(new Card(j, i));
			}
		}
		this.shuffle();
	}
	
	
	public void shuffle(){
		for (int i = 0; i < ValueMAX * CategoryMAX - 1; i++) {
			int swapIndex = this.generator.nextInt( ValueMAX * CategoryMAX - i) + i;
			Card tempCard = this.cards.get(i);
			this.cards.set(i, this.cards.get(swapIndex));
			this.cards.set(swapIndex, tempCard);
		}
		currentIndex = 0;
	}
	
	public Card getCard() throws Exception{
		if (!this.hasCard()) {
			throw new Exception("No more cards.");
		}
		Card result = this.cards.get(currentIndex);
		currentIndex++;
		return result;
	}
	
	public boolean hasCard(){
		return this.currentIndex < ValueMAX * CategoryMAX;
	}
	
}
