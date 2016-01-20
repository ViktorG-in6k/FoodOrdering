package com.dao;

import com.model.Person;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class PersonRepository  {

    @Autowired
    SessionFactory sf;

    public void save(Person person){
        Session session = sf.getCurrentSession();
        session.save(person);
    }

    public Person getPerson(long id) {
        Session session = sf.getCurrentSession();
        Query query = session.createQuery("from Person where id = :id");
        return (Person) query.setLong("id",id).uniqueResult();
    }
}
