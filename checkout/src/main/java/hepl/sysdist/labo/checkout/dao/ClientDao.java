package hepl.sysdist.labo.checkout.dao;

import hepl.sysdist.labo.checkout.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface ClientDao extends JpaRepository<Client, Integer>
{

    Client getClientById(int Id);

}
