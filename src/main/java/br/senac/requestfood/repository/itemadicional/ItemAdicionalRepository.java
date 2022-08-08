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
	
	//select incorreto
	@Query(value = "SELECT u.id AS id_usuario, u.nome_cliente AS nome FROM cliente u")
	List<ItemAdicionalProjection> findAdditionalItens();

}
