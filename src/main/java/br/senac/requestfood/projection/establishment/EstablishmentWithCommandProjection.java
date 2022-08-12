package br.senac.requestfood.projection.establishment;

import java.util.List;

import br.senac.requestfood.projection.command.CommandProjection;

public interface EstablishmentWithCommandProjection {

	Long getId();

	String getName();

	List<CommandProjection> getCommands();

}
