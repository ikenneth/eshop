package fr.icodem.eshop.service;

import fr.icodem.eshop.model.ItemCounter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service @Transactional
public class SystemServiceImpl implements SystemService {

    @Autowired
    private SessionFactory sf;

    @Override @Transactional(propagation = Propagation.REQUIRES_NEW)
    public int getNextItemCounterValue(String item, String info) {
        // read counter from data store
        Session session = sf.getCurrentSession();
        ItemCounter counter = (ItemCounter)session.get(ItemCounter.class, item);
        if (counter == null) {
            counter = new ItemCounter();
            counter.setItem(item);
            counter.setNextValue(1);
            session.save(counter);
        }

        // read and increment value
        int value = counter.getNextValue();
        counter.increment();

        return value;
    }
}
