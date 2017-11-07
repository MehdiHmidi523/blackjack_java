package BlackJack.controller;

import BlackJack.model.IObserver;
import BlackJack.view.IView;
import BlackJack.model.Game;

public class PlayGame implements IObserver{

    private Game game;
    private IView view;

    public PlayGame(Game a_game, IView a_view){
        game = a_game;
        view = a_view;
        a_game.register(this);
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
    public void update() {
        view.DisplayDealerHand(game.GetDealerHand(), game.GetDealerScore());
        view.DisplayPlayerHand(game.GetPlayerHand(), game.GetPlayerScore());
    }

}