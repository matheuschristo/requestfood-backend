package br.senac.requestfood.repository.itemadicional;

import br.senac.requestfood.model.item.Item;
import br.senac.requestfood.model.itemadicional.ItemAdicional;
import br.senac.requestfood.projection.estabelecimento.EstabelecimentoProjection;
import br.senac.requestfood.projection.itemAdicional.ItemAdicionalProjection;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemAdicionalRepository extends JpaRepository <ItemAdicional, Long> {

	Optional<ItemAdicionalProjection> findAdditionalItemById(Long id);

	@Query(value = "SELECT a.id_AdditionalItem as id, a.Item as AdditionalItem, a.Name as AdditionItemName, a.Quantity as AdditionalItemQuantity FROM AdditionalItem a")
	List<ItemAdicionalProjection>findAdditionalItens();


}
