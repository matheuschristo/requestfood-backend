package br.senac.requestfood.model.consumable.drink;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import br.senac.requestfood.enumeration.drink.CategoryDrink;
import br.senac.requestfood.model.consumable.Consumable;

@Entity
@Table(name = "drink")
public class Drink extends Consumable {

	@Column(name = "alcoholic_drink", nullable = false)
    private Boolean alcoholic;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "type_drink", nullable = false)
    private CategoryDrink typeDrink;

    public Drink() {}

	public Drink(Boolean alcoholic, CategoryDrink typeDrink) {
		this.alcoholic = alcoholic;
		this.typeDrink = typeDrink;
	}

	public Boolean getAlcoholic() {
		return alcoholic;
	}
	public void setAlcoholic(Boolean alcoholic) {
		this.alcoholic = alcoholic;
	}
	public CategoryDrink getTypeDrink() {
		return typeDrink;
	}
	public void setTypeDrink(CategoryDrink typeDrink) {
		this.typeDrink = typeDrink;
	}
}