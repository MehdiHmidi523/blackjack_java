package BlackJack.view;

import java.util.Scanner;

public class SimpleView implements IView {
  public void DisplayWelcomeMessage() {
      for(int i = 0; i < 1; i++){System.out.print("\n");}
      System.out.println(" _____________________________________________");
      System.out.println("|                                             |");
      System.out.println("| ҉҉҉҉҉҉     Welcome to BLACKJACK      ҉҉҉҉҉҉ |") ;
      System.out.println("|_____________________________________________|\n");
      GetInput();
  }

    private int GetInput(){
        System.out.println("Type 'p' to Play, 'h' to Hit, 's' to Stand or 'q' to Quit\n");

       /* try {
                int c = System.in.read();
                while (c == '\r' || c =='\n') {
                    c = System.in.read();
                }
                return c;
            } catch (java.io.IOException e) {
                System.out.println("" + e);
                return 0;
            }*/
       return 90;
    }

    public void DisplayCard(BlackJack.model.Card a_card) {
      System.out.println("" + a_card.GetValue() + " of " + a_card.GetColor());
    }

    public void DisplayPlayerHand(Iterable<BlackJack.model.Card> a_hand, int a_score) {
      DisplayHand("Player", a_hand, a_score);
    }

    public void DisplayDealerHand(Iterable<BlackJack.model.Card> a_hand, int a_score) {
        DisplayHand("Dealer", a_hand, a_score);
    }

    private void DisplayHand(String a_name, Iterable<BlackJack.model.Card> a_hand, int a_score) {
        System.out.println(a_name + " Has: ");
        for(BlackJack.model.Card c : a_hand) {
            DisplayCard(c);
        }
        System.out.println("Score: " + a_score);
        System.out.println("");
    }

    public void DisplayGameOver(boolean a_dealerIsWinner) {
        System.out.println("GameOver: ");
        if (a_dealerIsWinner)  System.out.println("Dealer Won!");
        else  System.out.println("You Won!");
    }

    public void pauseProgram() {
        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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