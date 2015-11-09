
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

class PlayersHands extends Deck {
    // current hand
    public static ArrayList<String> currentHand = new ArrayList<String>();
    public ArrayList<String> hand = new ArrayList<String>();
    // random;
    static Random random = new Random();

    // get insult hand
    public ArrayList<String> getHand(List<String> fullDeck) {
        super.fullDeck = fullDeck;
        for (int i = 0; i < 4; i++) {
            this.hand.add(fullDeck.remove(random.nextInt(fullDeck.size())));

        }
        return this.hand;
    }

    // pull hand out of deck
    public ArrayList<String> fullDeck(List<String> getHand) {
        for (String u : getHand) {
            fullDeck.remove(u);
        }
        return (ArrayList<String>) fullDeck;

    }

    // getter and setter for current hand
    public ArrayList<String> getCurrentHand() {
        return currentHand;
    }

    public void setCurrentHand(ArrayList<String> currentHand) {
        this.currentHand = currentHand;
    }

    // human turn to play
    public static String HumanPlays(String TopCard, ArrayList<String> currentHand, List<String> fullDeck) {

        // scanner
        Scanner s = new Scanner(System.in);
        // display players hand to user
        System.out.println(currentHand);
        // display
        System.out.println("Which card do you want to play, or enter D for draw.");
        // get input
        String str = s.nextLine().toUpperCase();
        // if user draw they end they turn
        if (str.equals("D")) {
            currentHand.add(addCurrentHand(fullDeck));
            return TopCard;
        }
        System.out.println(currentHand);
        // counter
        int i = 0;
        // check if user has the cad that they inputed if not enter new card
        if (currentHand.contains(str)) {
        } else {
            System.out.println("you dont have that card !");
            HumanPlays(TopCard, currentHand, fullDeck);
        }
        // if use enter an 8 card
        if (str.substring(0, TopCard.length() - 1).equals("8")) {
            while (true) {
                System.out.println("Crazy 8 pick  change the suit to H, D, C or S ");
                // get new suit
                String newSuit = s.nextLine().toUpperCase();
                // if it is a real suit change remove card form hand
                if (newSuit.equals("C") || newSuit.equals("S") || newSuit.equals("H") || newSuit.equals("D")) {
                    for (String v : currentHand) {
                        if (v.equals(str)) {
                            fullDeck.add(random.nextInt(fullDeck.size()), TopCard);
                            currentHand.remove(i);
                            return TopCard = "8" + newSuit;
                        }
                        i++;
                    }
                }
                // if not a real suit ask to reenter
                else {
                    System.out.println("Pleace make sure that you enter H, D, C or S ");
                }
            }
        }
        // check if the card you pick can be put down
        if (str.contains(TopCard.substring(0, TopCard.length() - 1))
                || str.contains(TopCard.substring(TopCard.length() - 1, TopCard.length()))) {
        } else {
            System.out.println("Make sure that you drop the right card");
            HumanPlays(TopCard, currentHand, fullDeck);
        }
        // all bottom cards get move in to the deck so the deck is never empty
        for (String v : currentHand) {
            if (v.contains(str)) {
                fullDeck.add(random.nextInt(fullDeck.size()), TopCard);
                return TopCard = currentHand.remove(i);
            }
            i++;
        }

        return TopCard;
    }

    // pull card form deck and in to hand
    public static String addCurrentHand(List<String> fullDeck) {
        String Newcard = fullDeck.remove(0);

        return Newcard;
    }
}
