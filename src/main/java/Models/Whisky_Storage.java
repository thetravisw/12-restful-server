package Models;
import java.util.*;

public class Whisky_Storage {
    public static Map<Integer, Whisky> whiskies;
    static {
        whiskies = new HashMap<>();
        Whisky Tallisker_18 = new Whisky("Tallisker 18", 8.75);
        Whisky Dewars_White_Label = new Whisky("Dewars White Label", 4.33);
        Whisky RoyalLochnagar36 = new Whisky("Royal Lochnagar 36", 9.8);

        whiskies.put(Tallisker_18.id, Tallisker_18);
        whiskies.put(Dewars_White_Label.id, Dewars_White_Label);
        whiskies.put(RoyalLochnagar36.id, RoyalLochnagar36);
    }
}



