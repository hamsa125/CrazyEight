
public class Managment {

    // use only to hold the top card value
    static String TopCard = null;

    public static String getTopCard() {
        return TopCard;
    }

    public static void setTopCard(String topCard) {
        TopCard = topCard;
    }

    // used for testing (a.k.a junk code)
    static String input = null;
    static String Telements[] = new String[2];
    static String Helements[] = null;
    // static int errorlvl = (Integer) null;

    public static String[] getTelements() {
        return Telements;
    }

    public static void setTelements(String TopCard) {
        Telements = TopCard.split("");
        ;
    }

    public static String[] getHelements() {
        return Helements;
    }

    public static void setHelements(String input) {
        Helements = input.split("");
    }

}
