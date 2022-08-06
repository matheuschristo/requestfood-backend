package br.senac.requestfood.projection.comanda;

import br.senac.requestfood.model.mesa.Mesa;
import br.senac.requestfood.model.usuario.cliente.Cliente;
import br.senac.requestfood.model.usuario.estabelecimento.Estabelecimento;
import br.senac.requestfood.projection.item.ItemProjection;

import java.time.LocalDateTime;
import java.util.List;

public interface ComandaWithItemProjection {

    Long getId();

    Cliente getCliente();

    LocalDateTime getDataEmissao();

    List<ItemProjection> getItens();

    Mesa getMesa();

    Double getValorTotal();

    Estabelecimento getEstabelecimento();
}
