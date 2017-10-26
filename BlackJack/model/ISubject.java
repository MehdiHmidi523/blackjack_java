package BlackJack.model;
import java.util.Observer;


public interface ISubject {
    void register(IObserver o);
    void unregister(IObserver o);
    void update();
}
