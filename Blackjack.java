import com.google.common.collect.*;
import java.util.*;

/**
* A friendly game of Blackjack.
*/

public class Blackjack
{
    public static void main (String[] args){
        Scanner scan = new Scanner(System.in);
        String quit = "N";
        while(quit.toUpperCase().equals("N")){
            System.out.println("Thank you for playing another game of blackjack,");
            System.out.println("you degenerate gambling addict.  You will be dealt");
            System.out.println("two cards, okay?  Actually, you have no choice now.");
            Deck deck = new Deck();
            List<Card> blank = new ArrayList<Card>();
            Hand player = new Hand(blank);
            Hand dealer = new Hand(blank);

            int deckPosition = 0; //tracks dealing of cards from the deck

            player=player.addCard(deck.get(deckPosition++));
            player=player.addCard(deck.get(deckPosition++));
            dealer=dealer.addCard(deck.get(deckPosition++));
            dealer=dealer.addCard(deck.get(deckPosition++));

            String resp = "Y";
            while (player.getValue() < 22 && resp.toUpperCase().equals("Y")){
                System.out.println();
                System.out.println("Your cards are: " + player.toString());
                System.out.println("Your score is: " + player.getValue());
                System.out.println("Enter 'y' to hit, other to pass");
                resp = scan.next();
                if(resp.toUpperCase().equals("Y")) player=player.addCard(deck.get(deckPosition++));
            }
            System.out.println();
            System.out.println("Your cards are: " + player.toString());
            System.out.println("Your score is: " + player.getValue());
            if(player.getValue()>21)
            {  
                System.out.println("You lose again.");
            }
            else
            {
                while (dealer.getValue() <= Math.min(17, player.getValue())){
                    System.out.println();
                    System.out.println("The dealer has: " + dealer.toString());
                    System.out.println("for a score of " + dealer.getValue());
                    System.out.println("Dealer hits.");
                    dealer=dealer.addCard(deck.get(deckPosition++));
                }
                if (dealer.getValue() < 22 && dealer.getValue() > player.getValue())
                {
                    System.out.println();
                    System.out.println("The dealer wins with " + dealer.toString());
                    System.out.println("for a score of " + dealer.getValue());
                }
                else
                {
                    System.out.println();
                    System.out.println("Dealer has " + dealer.toString());
                    System.out.println("for a score of " + dealer.getValue());
                    System.out.println("You win!");
                }
            }
            System.out.println("Enter anything but 'N' to quit.  Otherwise, you have to play again.");
            quit = scan.next();
        }
    }
}

        
