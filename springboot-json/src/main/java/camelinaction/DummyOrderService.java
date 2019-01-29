package camelinaction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import camelinaction.jpa.entity.OrderJpa;
import camelinaction.jpa.entity.OrderJpaRepository;

@Component("orderService")
public class DummyOrderService implements OrderService {

	@Autowired
	OrderJpaRepository orderJpaRepository;
	
	OrderJpa orderJpa=new OrderJpa();
	
  
    @Override
    public String updateOrder(OrderJpa orderJpa) {
    	orderJpaRepository.save(orderJpa);
    	
    	 return "Record Updated";
    }

    @Override
    public String createOrder(OrderJpa orderJpa) {
        orderJpaRepository.save(orderJpa);
        return "Record Created";
    }

    @Override
    public String cancelOrder(int orderId) {
    	orderJpaRepository.deleteById(orderId);
    	
    	 return "Record Deleted";
    }

   	@Override
	public Orders getOrders() {
		// TODO Auto-generated method stub
		List<OrderJpa> orderList = (List<OrderJpa>) orderJpaRepository.findAll();
		Orders obj=new Orders();
		obj.setListOrders(orderList);
		return obj;
	}

	@Override
	public Optional<OrderJpa> getOrder(int orderId) {
		// TODO Auto-generated method stub
		return orderJpaRepository.findById(orderId);
	}

}
