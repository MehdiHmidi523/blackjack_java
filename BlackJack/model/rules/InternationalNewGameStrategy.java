package BlackJack.model.rules;

import BlackJack.model.Deck;
import BlackJack.model.Dealer;
import BlackJack.model.Player;
import BlackJack.model.Card;  

class InternationalNewGameStrategy implements INewGameStrategy {

  public boolean NewGame(Deck a_deck, Dealer a_dealer, Player a_player) {

    a_player.DealCard(giveCard(a_deck));
    a_dealer.DealCard(giveCard(a_deck));
    a_player.DealCard(giveCard(a_deck));
    return true;
  }

  private Card giveCard(Deck a_deck) {
    Card c = a_deck.GetCard();
    c.Show(true);
    return c;
  }
}