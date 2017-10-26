package BlackJack.view;

import java.util.Scanner;

public class SimpleView implements IView {
  public void DisplayWelcomeMessage()
        {
          for(int i = 0; i < 2; i++) {System.out.print("\n");};
            System.out.println(" _____________________________________________");
            System.out.println("|                                             |");
            System.out.println("| ҉҉҉҉҉҉     Welcome to BLACKJACK      ҉҉҉҉҉҉ |") ;
            System.out.println("|_____________________________________________|\n");

            System.out.println("Type 'p' to Play, 'h' to Hit, 's' to Stand or 'q' to Quit\n");
        }

        public InputChoice GetInput() {
            Scanner sc = new Scanner(System.in);
          while (true) {
              try {
                  String in = sc.nextLine();
                  switch (in) {
                      case "p": return InputChoice.P;
                      case "h": return InputChoice.H;
                      case "s": return InputChoice.S;
                      case "q": return InputChoice.Q;
                  }
              }
              catch (IllegalArgumentException e) {
                  System.out.println("Not a valid input, please try again.");
              }
          }
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
            if (a_dealerIsWinner) {
                System.out.println("Dealer Won!");
            }
            else {
                System.out.println("You Won!");
            }
            
        }
    public void pauseProgram() {
        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void DisplayClearConsole(){
        System.out.flush();
    }


}