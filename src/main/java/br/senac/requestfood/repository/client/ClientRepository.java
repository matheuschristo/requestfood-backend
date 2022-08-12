package br.senac.requestfood.repository.client;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.senac.requestfood.model.contact.Contact;
import br.senac.requestfood.model.user.client.Client;
import br.senac.requestfood.projection.client.ClientProjection;
import br.senac.requestfood.projection.client.ClientWithCommandsProjection;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
  
    boolean existsByContact (Contact contact);
    
    Optional<ClientProjection> findClientById(Long id);

    Optional<ClientWithCommandsProjection> findClientWithCommandsById(Long id);
    
    @Query(value = "SELECT c.id_user AS id, c.name_user AS Name, c.id_contact AS Contact, c.password.user AS Password, c.genre_client AS Genre, c.date_birth_client AS BirthDate FROM client c")
    List<ClientProjection> findClients();
}
