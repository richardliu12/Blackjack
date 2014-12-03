import com.google.common.collect.*;
import java.util.*;

/**
* Represents a Blackjack hand.  This class is immutable.
*/

public class Hand
{
    private final ImmutableList<Card> cards; 
    
    /**
     * Constructs a hand given a list of cards.
     */
    public Hand(List<Card> cards){
        this.cards = ImmutableList.copyOf(cards);
    }

    /**
    * Adds a card to the hand.
    */
    public Hand addCard(Card card){
        List<Card> newCards = new ArrayList<Card>(cards);
        newCards.add(card);
        return new Hand(newCards);
    }

    /**
    * Evaluates the hand.
    */
    public int getValue()
    {
        int aces = 0;
        int value = 0;
        for (int k = 0; k < cards.size(); k++){
           Card card = cards.get(k);
           value = value + card.getValue();
           if (card.getValue() == 11) aces++;
           if (value > 21 && aces > 0){
               value = value - 10;
               aces--;
           }
        }
        return value;
    }

    @Override
    public String toString()
    {
        String text = new String();
        for (int k = 0; k < cards.size(); k++){
            text = text + cards.get(k) + ". ";
        }
        return text;
    }
    
    public static void main(String args[])
    {
        Deck deck = new Deck();
        List<Card> deal = new ArrayList<Card>();
        
        deal.add(deck.getCard(0));
        deal.add(deck.getCard(1));
        deal.add(deck.getCard(2));
        deal.add(deck.getCard(3));
        Hand hand = new Hand(deal);
        System.out.println(hand.toString());
        System.out.println(hand.getValue());
    }
}
