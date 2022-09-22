package br.senac.requestfood.service.establishment;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.senac.requestfood.dto.establishment.EstablishmentAllDTO;
import br.senac.requestfood.dto.establishment.EstablishmentWithConsumablesDTO;
import br.senac.requestfood.dto.establishment.EstablishmentWithOrdersDTO;
import br.senac.requestfood.projection.establishment.EstablishmentCardProjection;
import br.senac.requestfood.projection.establishment.EstablishmentProjection;
import br.senac.requestfood.projection.establishment.EstablishmentStartOrderProjection;

public interface EstablishmentService {

	EstablishmentAllDTO save(EstablishmentAllDTO establishmentDTO);
	
	void update(EstablishmentAllDTO establishmentDTO, Long id);
	
	void delete(Long id);
	
	Boolean setOpen(Long id);
	
	EstablishmentProjection findById(Long id);
	
	EstablishmentStartOrderProjection findByIdStartOrder(Long id);
	
	EstablishmentWithOrdersDTO findByIdWithOrder(Long id);
	
	EstablishmentWithConsumablesDTO findByIdWithConsumable(Long id);
	
	Page<EstablishmentCardProjection> findByName(Pageable pageable, Integer page,String name);

	Page<EstablishmentCardProjection> findNameByOrderByAsc(Pageable pageable, Integer page);
	
	Page<EstablishmentCardProjection> findNameByOrderByDesc(Pageable pageable, Integer page);
	
	Page<EstablishmentCardProjection> findAllToCard(Pageable pageable, Integer page);
	
	List<EstablishmentProjection> findAll();
	
	
}
