package com;

import com.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import com.springConfig.ConfigurationClass;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;


import javax.sql.DataSource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ConfigurationClass.class})
@WebAppConfiguration
@Transactional
public class TestDataSource {


    @Autowired
    DataSource dataSource;

    @Autowired
    SessionFactory sf;

    @Test
    public void test() {
        Person person = new Person("person");
        Session session = sf.openSession();
        session.beginTransaction();
        session.save(person);
        session.getTransaction().commit();
        Person person1 = session.get(Person.class,1L);
        assertNotNull(person1);
        assertEquals(person.getName(),person1.getName());

    }

}
