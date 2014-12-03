/**
* Represents a playing card.  This class is immutable.
*/

public class Card
{
    private final Suit suit;
    private final Rank rank;
    
    /**
     * Constructs a card with given Suit and Rank.
     *
     * @param suit  the suit of the card
     * @param rank  the rank of the card
     */
    public Card(Suit suit, Rank rank){
        this.rank = rank;
        this.suit = suit;
    }

    public boolean equals(Card card){
        return (this.rank==card.getRank())&&(this.suit==card.getSuit());
    }

    @Override
    public String toString(){
        return (rank.toString() + " of " + suit.toString());
    }

    /**
    * Returns Suit of card.
    */
    public Suit getSuit(){
        return suit;
    }

    /**
    * Returns Rank of card.
    */
    public Rank getRank(){
        return rank;
    }

    /**
    * Returns value of card.
    */
    public int getValue(){
        return rank.getValue();
    }
}
