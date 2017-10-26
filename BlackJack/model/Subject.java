package BlackJack.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

public class Subject implements ISubject {

    private List<IObserver> m_observers = new ArrayList<IObserver>();

    public void register(IObserver o) {
        m_observers.add(o);
    }

    public void unregister(IObserver o) {
// not implemented.
    }

    public void update() {
        m_observers.forEach(IObserver::update);
    }
}
