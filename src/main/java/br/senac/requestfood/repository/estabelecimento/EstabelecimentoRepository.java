package br.senac.requestfood.repository.estabelecimento;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.senac.requestfood.model.contato.Contato;
import br.senac.requestfood.model.usuario.estabelecimento.Estabelecimento;
import br.senac.requestfood.projection.estabelecimento.EstabelecimentoProjection;
import br.senac.requestfood.projection.estabelecimento.EstablishmentWithAllProjection;
import br.senac.requestfood.projection.estabelecimento.EstablishmentWithCommandProjection;
import br.senac.requestfood.projection.estabelecimento.EstablishmentWithConsumableProjection;
import br.senac.requestfood.projection.estabelecimento.EstablishmentWithTableProjection;

@Repository
public interface EstabelecimentoRepository extends JpaRepository<Estabelecimento, Long> {

	boolean existsByContact (Contato contact);
	
	Optional<EstabelecimentoProjection> findEstablishmentById(Long id);
	
	Optional<EstablishmentWithAllProjection> findEstablishmentWithAllById(Long id);
	
	Optional<EstablishmentWithTableProjection> findEstablishmentWithTableById(Long id);
	
	Optional<EstablishmentWithConsumableProjection> findEstablishmentWithConsumableById(Long id);
	
	Optional<EstablishmentWithCommandProjection> findEstablishmentWithCommandById(Long id);

	@Query(value="SELECT e.id_Establishment as id, e.name_Establishment as Name FROM client e)")
	List<EstabelecimentoProjection>findEstablishments();

}
