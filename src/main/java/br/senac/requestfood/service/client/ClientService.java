package br.senac.requestfood.service.client;

import java.util.List;

import br.senac.requestfood.dto.client.AllClientDTO;
import br.senac.requestfood.dto.client.ClientPasswordDTO;
import br.senac.requestfood.projection.client.ClientProjection;
import br.senac.requestfood.projection.client.ClientWithOrdersProjection;

public interface ClientService {
	
	AllClientDTO save(AllClientDTO clientDTO);
	
	void update(AllClientDTO clientDTO, Long id);
	
	void updatePassword(ClientPasswordDTO dto, Long id);
	
	void delete(Long id);
	
	ClientProjection findById(Long id);
	
	ClientWithOrdersProjection findByIdWithOrders(Long id);
	
	List<ClientProjection> findAll();
	
}
