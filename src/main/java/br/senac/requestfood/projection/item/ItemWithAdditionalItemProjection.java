package br.senac.requestfood.projection.item;

import java.util.List;

import br.senac.requestfood.model.addicionalItem.AdditionalItem;
import br.senac.requestfood.model.command.Command;
import br.senac.requestfood.model.consumable.Consumable;
import br.senac.requestfood.model.item.Item;

public interface ItemWithAdditionalItemProjection {

    Item getItem();

    Command getCommand();

    Integer getQuantity();

    Consumable getProduct();

    String getDescription();

    List<AdditionalItem> getAdditionalItem();
}
