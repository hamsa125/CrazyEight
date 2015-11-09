
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Deck {
    // create possible card combinations
    public final String[] SUITS = { "H", "D", "C", "S" };
    public final String[] RANKS = { "A", "K", "Q", "J", "10", "9", "8", "7", "6", "5", "4", "3", "2" };

    // maximum number of cards
    public final int deckLength = SUITS.length * RANKS.length;
    public List<String> fullDeck = new ArrayList<>();

    // form deck
    public Deck() {
        for (int i = 0; i < SUITS.length; i++) {
            for (int j = 0; j < RANKS.length; j++) {
                fullDeck.add(RANKS[j] + SUITS[i]);
            }
        }
    }

    // form deck
    public Deck(List<String> fullDeck) {
        this.fullDeck = fullDeck;
        for (int i = 0; i < SUITS.length; i++) {
            for (int j = 0; j < RANKS.length; j++) {
                fullDeck.add(RANKS[j] + SUITS[i]);
            }
        }
    }

    // shuffle all cards in deck
    public List<String> shuffle(List<String> fullDeck) {
        this.fullDeck = fullDeck;
        Collections.shuffle(fullDeck);
        return fullDeck;
    }

    // to ensure shuffling was indeed taking place
    public void showDeck(List<String> fullDeck) {
        this.fullDeck = fullDeck;
        for (int i = 0; i < deckLength; i++) {
            System.out.printf("%s ", fullDeck.get(i));
        }
    }

    // remove top card from deck
    public String pulloutTopCard(List<String> fullDeck) {
        return fullDeck.remove(0);
    }

}
