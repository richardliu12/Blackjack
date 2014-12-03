
/**
* Represents the rank of a card from two through ace, and the associated Blackjack value.
* Aces are given value 11, which can be corrected in a hand-value evaluation later.
*/

public enum Rank
{
    TWO     (2),
    THREE   (3),
    FOUR    (4),
    FIVE    (5),
    SIX     (6),
    SEVEN   (7),
    EIGHT   (8),
    NINE    (9),
    TEN     (10),
    JACK    (10),
    QUEEN   (10),
    KING    (10),
    ACE     (11);

    int value; 

    /**
    * Constructor specifying value of card.
    */
    private Rank(int value){
        this.value = value;
    }

    /**
    * Returns value of the card.
    */
    public int getValue(){
        return value;
    }
}




