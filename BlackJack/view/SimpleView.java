package BlackJack.view;

import BlackJack.controller.IButtonPressedObserver;

import java.util.List;

public class SimpleView implements IView {

    List<IButtonPressedObserver> subscribers;

    public void DisplayWelcomeMessage() {
      for(int i = 0; i < 1; i++){System.out.print("\n");}
      System.out.println(" _____________________________________________");
      System.out.println("|                                             |");
      System.out.println("| ҉҉҉҉҉҉     Welcome to BLACKJACK      ҉҉҉҉҉҉ |") ;
      System.out.println("|_____________________________________________|\n");
      GetInput();
  }

    private void GetInput(){
        System.out.println("Type 'p' to Play, 'h' to Hit, 's' to Stand or 'q' to Quit\n");

        try {
            int c = System.in.read();
            while (c == '\r' || c =='\n') { c = System.in.read(); }
            if ( c=='p') {
                for (IButtonPressedObserver subscriber : subscribers){
                    subscriber.playButtonPressed();
                }
            }
            else if (c=='h') {
                for (IButtonPressedObserver subscriber : subscribers){
                    subscriber.hitButtonPressed();
                }
            }
            else if (c=='s') {
                for (IButtonPressedObserver subscriber : subscribers){
                    subscriber.standButtonPressed();
                }
            }
            else if (c=='q') {
                for (IButtonPressedObserver subscriber : subscribers){
                    subscriber.quitButtonPressed();
                }
            }
            GetInput();	// endless loop
        } catch (java.io.IOException e) {
            System.out.println("" + e);
        }
    }

    @Override
    public void DisplayDealerStatus() {
        for ( int i = 0 ; i<1 ; i++ ) { System.out.print("\n") ; }
        System.out.println("getting a card...\n");
    }

    @Override
    public void addSubscriber(IButtonPressedObserver subscriber) {

    }

    public void DisplayCard(BlackJack.model.Card a_card) {
      System.out.println("" + a_card.GetValue() + " of " + a_card.GetColor());
    }

    public void DisplayPlayerHand(Iterable<BlackJack.model.Card> hand, int score) {
         DisplayHand("Player", hand, score);
    }

    public void DisplayDealerHand(Iterable<BlackJack.model.Card> hand, int score) {
        DisplayHand("Dealer", hand, score);
    }

    private void DisplayHand(String name, Iterable<BlackJack.model.Card> hand, int score) {
        System.out.println(name + " Has: ");
        for(BlackJack.model.Card c : hand) { DisplayCard(c); }
        System.out.println("Score: " + score);
        System.out.println("");
    }

    public void DisplayGameOver(boolean a_dealerIsWinner) {
        System.out.println("GameOver: ");
        if (a_dealerIsWinner)  System.out.println("Dealer Won!");
        else  System.out.println("You Won!");
    }

    public void DisplayClearConsole(){ System.out.flush(); }

    /*@Override
    public void visit(AmericanNewGameStrategy americanNewGameStrategy) { System.out.println("Game Strategy: American"); }
    @Override
    public void visit(InternationalNewGameStrategy internationalNewGameStrategy) { System.out.println("Game Strategy: International"); }
    @Override
    public void visit(BasicHitStrategy basicHitStrategy) { System.out.println("Hit Strategy: Basic"); }
    @Override
    public void visit(Soft17HitStrategy soft17HitStrategy) { System.out.println("Hit Strategy: Soft17"); }
    @Override
    public void visit(D_WinningRule d_winingRule) { System.out.println("Winning Rule: Dealer"); }
    @Override
    public void visit(P_WinningRule p_WiningRule) { System.out.println("Winning Rule: Player"); }
    */
}