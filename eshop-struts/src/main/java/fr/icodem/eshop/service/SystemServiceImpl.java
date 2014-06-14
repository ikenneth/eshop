package fr.icodem.eshop.service;

import fr.icodem.eshop.model.ItemCounter;
import fr.icodem.eshop.model.ItemCounterId;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class SystemServiceImpl implements SystemService {

    private SessionFactory sf;

    // setter for injection
    public void setSf(SessionFactory sf) {
        this.sf = sf;
    }

    @Override
    public int getNextItemCounterValue(String item, String subset, String info) {
        // check subset
        if (subset == null) subset = "";

        // read counter from data store
        Session session = sf.getCurrentSession();
        ItemCounterId id = new ItemCounterId(item, subset);
        ItemCounter counter = (ItemCounter)session.get(ItemCounter.class, id);
        if (counter == null) {
            counter = new ItemCounter();
            counter.setId(id);
            counter.setInfo(info);
            counter.setNextValue(1);
            session.save(counter);
        }

        // read and increment value
        int value = counter.getNextValue();
        counter.increment();

        return value;
    }
}
