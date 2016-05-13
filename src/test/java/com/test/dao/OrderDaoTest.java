package com.test.dao;

import com.config.TestHibernateConfig;
import com.dataLayer.DAO.Interfaces.EventDAO;
import com.dataLayer.DAO.Interfaces.OrderDAO;
import com.dataLayer.DAO.Interfaces.RestaurantDAO;
import com.dataLayer.entity.base.Event;
import com.dataLayer.entity.base.Order;
import com.dataLayer.entity.base.Restaurant;
import com.dataLayer.entity.base.Status;
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
public class OrderDaoTest {
    @Autowired
    OrderDAO orderDAO;
    @Autowired
    EventDAO eventDAO;
    @Autowired
    RestaurantDAO restaurantDAO;

    @Test
    public void change_order_status_from_PENDING_to_FREEZE(){
        Event event = new Event(LocalDateTime.now(), "Party");
        eventDAO.save(event);
        Restaurant restaurant = new Restaurant("macdonald","34-22-11");
        restaurantDAO.save(restaurant);
        Order order = new Order();
        order.setStatus(Status.PENDING);
        order.setEvent(event);
        order.setRestaurant(restaurant);
        orderDAO.saveOrder(order);
        orderDAO.changeOrderStatus(order.getId(), Status.FREEZE);
        Order savedOrder = orderDAO.getOrderByOrderId(order.getId());
        Assert.assertThat(savedOrder.getStatus(), is(Status.FREEZE));
    }
}
