package BlackJack.view;

import java.util.Scanner;

public class SwedishView implements IView
    {
        public void DisplayWelcomeMessage()
        {
         
            for(int i = 0; i < 50; i++) {System.out.print("\n");};
            System.out.println(" _____________________________________________");
            System.out.println("|                                             |");
            System.out.println("| ҉҉҉҉҉҉     Hej Black Jack V�rlden   ҉҉҉҉҉҉ |") ;
            System.out.println("|_____________________________________________|\n");

            System.out.println("Skriv 'p' f�r att Spela, 'h' f�r nytt kort, 's' f�r att stanna 'q' f�r att avsluta\n");
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
                    System.out.println("Ogiltigt kommando, f�rs�k igen.");
                }
            }
        }
        
        public void DisplayCard(BlackJack.model.Card a_card)
        {
            if (a_card.GetColor() == BlackJack.model.Card.Color.Hidden)
            {
                System.out.println("Dolt Kort");
            }
            else
            {
                String colors[] = 
                    { "Hj�rter", "Spader", "Ruter", "Kl�ver" };
                String values[] =  
                    { "tv�", "tre", "fyra", "fem", "sex", "sju", "�tta", "nio", "tio", "knekt", "dam", "kung", "ess" };
                System.out.println("" + colors[a_card.GetColor().ordinal()] + " " + values[a_card.GetValue().ordinal()]);
            }
        }
        public void DisplayPlayerHand(Iterable<BlackJack.model.Card> a_hand, int a_score)
        {
            DisplayHand("Spelare", a_hand, a_score);
        }
        public void DisplayDealerHand(Iterable<BlackJack.model.Card> a_hand, int a_score)
        {
            DisplayHand("Croupier", a_hand, a_score);
        }
        public void DisplayGameOver(boolean a_dealerIsWinner)
        {
            System.out.println("Slut: ");
            if (a_dealerIsWinner)
            {
                System.out.println("Croupiern Vann!");
            }
            else
            {
                System.out.println("Du vann!");
            }
        }

        public void pauseProgram() {
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public void DisplayClearConsole() {
            System.out.flush();
        }

        private void DisplayHand(String a_name, Iterable<BlackJack.model.Card> a_hand, int a_score)
        {
            System.out.println(a_name + " Har: " + a_score);
            for(BlackJack.model.Card c : a_hand)
            {
                DisplayCard(c);
            }
            System.out.println("Po�ng: " + a_score);
            System.out.println("");
        }
    }