
import java.util.ArrayList;
import java.util.List;

public class Crazy8 {

    // make deck
    static List<String> cards = new ArrayList<>();
    // fill deck
    static Deck deck = new Deck(cards);
    // geting all classes
    static ComputerHands Chands = new ComputerHands();
    static PlayersHands hands = new PlayersHands();
    static Managment manage = new Managment();

    public static void main(String[] args) {
        // display
        System.out.println("Let's Play Crazy Eights");
        // shuffle deck
        deck.shuffle(cards);
        // test deck size
        // System.out.println(cards.size());
        // computer get a hand of cards to play
        Chands.getHand(cards);
        // test show computer hand
        // Chands.showHand();
        // player get a hand of cards
        hands.getHand(cards);
        // pull out the top card of the deak
        Managment.TopCard = deck.pulloutTopCard(cards);

        // System.out.println("/n");
        // play and computer get hands agina seting it as currant hand
        hands.setCurrentHand(hands.getHand(cards));
        Chands.setCurrentHand(Chands.getHand(cards));
        // test display every ones hands
        // System.out.println(Chands.currentHand);
        // System.out.println(hands.currentHand);
        // display
        System.out.println("You go first.");
        while (true) {

            // display
            System.out.println("TopCard");
            // display top card
            System.out.println(Managment.TopCard);

            // test display every ones hands
            // System.out.println(Chands.currentHand);
            // System.out.println(hands.currentHand);

            // each player has a turn to place a card on top this gos one till
            // we get a winner
            manage.setTopCard(hands.HumanPlays(Managment.TopCard, hands.currentHand, cards));
            manage.setTopCard(Chands.AIPlays(Managment.TopCard, Chands.currentHand, cards));
            // Finally results
            if (hands.currentHand.size() == 0) {
                System.out.println("You win !!");
                break;
            }
            if (hands.currentHand.size() == 0) {
                System.out.println("You Lose :(");
                break;
            }

        }

    }

}
