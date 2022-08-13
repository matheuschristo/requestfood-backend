package br.senac.requestfood.mapper.order;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.senac.requestfood.dto.order.OrderDTO;
import br.senac.requestfood.model.order.Order;

@Service
public class OrderMapper {

	public OrderDTO toDTO(Order order) {
		return new OrderDTO(order.getId(), order.getClient(), order.getIssueDate(), order.getClosingDate(), order.getItems(), order.getAmount());
	}
	
	public Order toEntity(OrderDTO orderDTO) {
	//Not Completed, waiting response for Front-End
		return null;
	}

	public List<OrderDTO> toDTO(List<Order> orders){
		
		final List<OrderDTO> orderDTOS = new ArrayList<>();
		
		for (Order order : orders) {
			orderDTOS.add(toDTO(order));
		}
		
		return orderDTOS;
	}
	
	public List<Order> toEntity(List<OrderDTO> orderDTOS) {
		
		final List<Order> orders= new ArrayList<>();
		
		for (OrderDTO orderDTO : orderDTOS) {
			orders.add(toEntity(orderDTO));
		}
		
		return orders;
	}
}
