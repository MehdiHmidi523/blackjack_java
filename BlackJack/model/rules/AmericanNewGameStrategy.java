package BlackJack.model.rules;

import BlackJack.model.Deck;
import BlackJack.model.Dealer;
import BlackJack.model.Player;
import BlackJack.model.Card;  

class AmericanNewGameStrategy implements INewGameStrategy {

  public boolean NewGame(Deck a_deck, Dealer a_dealer, Player a_player) {
    a_player.DealCard(giveCard(a_deck, true));
    a_dealer.DealCard(giveCard(a_deck, true));
    a_player.DealCard(giveCard(a_deck, true));
    a_dealer.DealCard(giveCard(a_deck, false));
    return true;
  }
  private Card giveCard(Deck a_deck, Boolean b) {
    Card c = a_deck.GetCard();
    c.Show(b);
    return c;
  }
}