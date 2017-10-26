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

    public boolean Play(Game a_game, IView a_view) {

        a_view.DisplayClearConsole();
        a_view.DisplayWelcomeMessage();

        view.DisplayDealerHand(game.GetDealerHand(), game.GetDealerScore());
        view.DisplayPlayerHand(game.GetPlayerHand(), game.GetPlayerScore());

        if (a_game.IsGameOver()) {
            a_view.DisplayGameOver(a_game.IsDealerWinner());
        }
        IView.InputChoice choice = a_view.GetInput();
        switch (choice) {
            case P:
                a_game.NewGame();
                break;
            case H:
                a_game.Hit();
                view.pauseProgram();
                break;
            case S:
                a_game.Stand();
                view.pauseProgram();
                break;
        }
        return choice != IView.InputChoice.Q;
    }

    public void update() {
        view.DisplayDealerHand(game.GetDealerHand(), game.GetDealerScore());
        view.DisplayPlayerHand(game.GetPlayerHand(), game.GetPlayerScore());
    }

}