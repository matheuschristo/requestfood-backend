package br.senac.requestfood.controller.order;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.senac.requestfood.dto.order.CreateOrderDTO;
import br.senac.requestfood.dto.order.client.OrderDetailsDTO;
import br.senac.requestfood.dto.order.establishment.OrderWithDateDTO;
import br.senac.requestfood.enumeration.order.OrderStatus;
import br.senac.requestfood.service.order.OrderService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/order")

public class OrderController {
    
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}

	@PostMapping
	public ResponseEntity<CreateOrderDTO> addOrder(@RequestBody CreateOrderDTO orderDTO) {
		return ResponseEntity.status(HttpStatus.CREATED).body(orderService.save(orderDTO));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletedOrder(@PathVariable(value = "id") Long id) {
		orderService.delete(id);
		return ResponseEntity.status(HttpStatus.OK).body("Order deleted successfully");
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<OrderDetailsDTO> getOrderDetails(@PathVariable(value = "id") Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(orderService.findByIdOrderDetails(id));
	}
	
	@GetMapping("/search-id/{id}")
	public ResponseEntity<OrderWithDateDTO> getOrderById(@PathVariable(value = "id") Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(orderService.findById(id));
	}
	
	@PostMapping("/{status}/{id}")
	public ResponseEntity<String> alterOrderStatus(@PathVariable(value = "status")OrderStatus status ,@PathVariable(value = "id")Long id) {
		orderService.alterOrderStatus(id, status);
		return ResponseEntity.status(HttpStatus.OK).body("Order status alter sucefully");
	}
}
