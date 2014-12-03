import com.google.common.collect.*;
import java.util.*;

/**
* Represents a collection of cards.  This class is immutable.
*/

public class Deck
{
    private final ImmutableList<Card> cards; 
    
    /**
     * Constructs a deck and shuffles it.
     */
    public Deck(){
       List<Card> tempDeck = new ArrayList<Card>();
       for (int i=0; i<4; i++){
           for (int j=0; j<13; j++){
               Card card = new Card(Suit.values()[i], Rank.values()[j]);
               tempDeck.add(card);
           }
       }
        Collections.shuffle(tempDeck);
        this.cards = ImmutableList.copyOf(tempDeck);
    }

    /**
    * Returns the n-th card in the deck.
    */
    public Card get(int n){
        return cards.get(n);
    }
}
