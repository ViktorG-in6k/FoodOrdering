package com.test.dao;

import com.config.TestHibernateConfig;
import com.dataLayer.DAO.EventDAO;
import com.model.Entity.Event;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.AnnotationConfigWebContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import static org.hamcrest.CoreMatchers.is;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestHibernateConfig.class}, loader = AnnotationConfigWebContextLoader.class)
@WebAppConfiguration
@Transactional
public class EventDaoTest {
    @Autowired
    EventDAO eventDAO;

    @Test
    public void test_save_event_to_db() {
        Event event = new Event();
        event.setName("Party");
        event.setDate(LocalDateTime.now());
        eventDAO.save(event);
        Event eventFromDb = eventDAO.getEventById(event.getId());
        Assert.assertThat(event.getName(), is(eventFromDb.getName()));
    }
}

