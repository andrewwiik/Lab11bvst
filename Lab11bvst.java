// Lab11bvst.java
// This is the Student starting version for the <Deck> class lab 11b assignment. 

public class Lab11bvst {
	public static void main(String[] args) {
	Deck deck = new Deck(); // create a new deck
	deck.display(); // display the deck
	}
}
	class Card {
		private String suit; // the card's suit
		private String rank; // the card's rank
		private int value; // the card's value in blackjack

		public Card(String s, String r, int v) {
			suit = s; // the suit of the card
			rank = r; // the rank of the card
			value = v; // the value of the card in Blackjack
		}

		public String suit() {
			return suit; // return the suit
		}

		public String rank() {
			return rank; // return the rank
		}

		public int value() {
			return value; // return the cards value in blackjack
		}

		public String toString() {
			return "[" + suit + ", " + rank + ", " + value + "]"; // convert the card's data to strings so we don't get the shallow value
		}
	}

	class Deck {
		private Card[] decks; // Our deck
		private int size; // the deck size
		public void add(String suit, String rank, int value) {
			Card temp = new Card(suit, rank, value); // add a card with the values
			decks[size] = temp; // add it to the deck
			size++; // increase the size
		}
		public Deck() {
			String[] suit = { "Clubs", "Diamonds", "Hearts", "Spades" }; // Suites Array
			String[] rank = { "Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
					"Jack", "Queen", "King"}; // Possible Rank of the cards array
			int[] value = { 11, 2, 3, 4, 5, 6, 7, 8, 9, 10,
					10, 10, 10}; // Value of the card in Blackjack 

			int SUITS = suit.length; // Size of the Suites Array
			int RANKS = rank.length; // Size of the Ranks Array
			decks = new Card[52]; // lets start our new deck


			for (int i = 0; i < RANKS; i++) { // for the 13 possible card ranks
				for (int j = 0; j < SUITS; j++) { // for each of the 4 suites
					this.add(suit[j], rank[i], value[i]); // add the card
				}
			}
		    shuffle(); // shuffle the deck
		}
		private void shuffle() {
			for (int s = 0; s < 1000; s++) { // for 1000 times
				int i = (int) (Math.random() * (decks.length)); // our first random number
	            int r = i + (int) (Math.random() * (decks.length-i)); // our second random number
	            Card t = decks[r]; // this is the card that will be swapped
	            decks[r] = decks[i]; // swap one
	            decks[i] = t; // swap 2
			}
   	    }  
        public void display() { // print out the deck
      		for (int k = 0; k < size; k++) // for every card in the deck
         		System.out.println(decks[k]); // print out the card
      		System.out.println(); // New line
   	    }  
	}
