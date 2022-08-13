package br.senac.requestfood.dto.item;

import br.senac.requestfood.model.consumable.Consumable;
import br.senac.requestfood.model.order.Order;

public record ItemDTO( Long id, Order order, Integer quantity, Consumable consumable, String observation) {}
