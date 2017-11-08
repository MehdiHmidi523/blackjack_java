package BlackJack.controller;

import BlackJack.model.INewCardDealtObserver;
import BlackJack.view.IView;
import BlackJack.model.Game;

public class PlayGame implements IButtonPressedObserver, INewCardDealtObserver {

    private Game game;
    private IView view;

    public PlayGame(Game a_game, IView a_view){
        game = a_game;
        a_game.addSubscriber(this);
        view = a_view;
        a_view.addSubscriber(this);
    }

    public void Play() {
        view.DisplayClearConsole();
        view.DisplayWelcomeMessage();
        showPlayerHands();
    }

    public void showPlayerHands(){
        view.DisplayDealerHand(game.GetDealerHand(), game.GetDealerScore());
        view.DisplayPlayerHand(game.GetPlayerHand(), game.GetPlayerScore());
    }

    @Override
    public void NotifyNewCardDealt() {
        try {
            view.DisplayDealerStatus();    // Display Dealer status
            Thread.sleep(2500);     //Delay
            view.DisplayDealerHand(game.GetDealerHand(), game.GetDealerScore());
            view.DisplayPlayerHand(game.GetPlayerHand(), game.GetPlayerScore());
        }
        catch ( InterruptedException e ) {
            e.printStackTrace();
        }
    }

    private void checkGameOver(){
        if (game.IsGameOver()) { view.DisplayGameOver(game.IsDealerWinner());}
    }

    @Override
    public void playButtonPressed() {
        game.NewGame();
        showPlayerHands();
        checkGameOver();
    }

    @Override
    public void hitButtonPressed() {
        game.Hit();
        showPlayerHands();
        checkGameOver();
    }

    public void standButtonPressed(){
        game.Stand();
        showPlayerHands();
        checkGameOver();
    }

    @Override
    public void quitButtonPressed() {
        System.exit(0);
    }
}