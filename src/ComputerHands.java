
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

class ComputerHands extends Deck {
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

    // computer's turn
    public static String AIPlays(String TopCard, ArrayList<String> currentHand, List<String> fullDeck) {
        System.out.println("Computer has " + currentHand.size() + " cards.");
        // array list for all eligible cards
        ArrayList<String> elagable = new ArrayList<String>();
        // keep track of insult top card
        String currentTopCard = TopCard;
        // counter
        int i = 0;
        // check each card to see if we got an match ad put that down
        for (String u : currentHand) {
            if (u.contains(TopCard.substring(0, TopCard.length() - 1))
                    || u.contains(TopCard.substring(TopCard.length() - 1, TopCard.length()))) {
                fullDeck.add(random.nextInt(fullDeck.size()), TopCard);
                TopCard = currentHand.remove(i);
                break;
            }
            i++;
        }

        // suit array
        ArrayList<String> Suit = new ArrayList<String>();
        // get the sit for each card
        try {
            for (String v : currentHand) {
                Suit.add(v.substring(TopCard.length() - 1, TopCard.length()));
            }
        } catch (Exception e) {
        }
        // get the most common suit
        String commonSuit = mostpopuler(Suit);
        // if no matchers check if we got an 8 and change suit to the most
        // common on we got
        // for(String w : currentHand){if(w.substring(0, TopCard.length() -
        // 1).equals("8")){currentHand.remove(i);return TopCard = "8"+
        // commonSuit ;}i++;}

        // if no option draw a card
        if (currentTopCard.equals(TopCard)) {
            System.out.println("Comuter draws a card ");
            addCurrentHand(fullDeck);
            return TopCard;
        }
        // test
        // System.out.println(currentHand);
        return TopCard;
    }

    // array to get the most popular object in the array using hash maps to
    // count them up and figure it out
    private static String mostpopuler(ArrayList<String> list) {

        Map<String, Integer> stringsCount = new HashMap<String, Integer>();
        for (String string : list) {
            if (string.length() > 0) {
                string = string.toLowerCase();
                Integer count = stringsCount.get(string);
                if (count == null)
                    count = new Integer(0);
                count++;
                stringsCount.put(string, count);
            }
        }
        Map.Entry<String, Integer> mostRepeated = null;
        for (Map.Entry<String, Integer> e : stringsCount.entrySet()) {
            if (mostRepeated == null || mostRepeated.getValue() < e.getValue())
                mostRepeated = e;
        }
        try {
            return mostRepeated.getKey();
        } catch (NullPointerException e) {
            // test
            // System.out.println("Cannot find most popular value at the List.
            // Maybe all strings are empty");
            return "";
        }

    }

    // pull card form deck and in to hand
    public static ArrayList<String> addCurrentHand(List<String> fullDeck) {
        currentHand.add(fullDeck.remove(0));
        return currentHand;
    }
}
