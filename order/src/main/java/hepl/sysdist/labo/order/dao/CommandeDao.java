package hepl.sysdist.labo.order.dao;


import hepl.sysdist.labo.order.model.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface CommandeDao extends JpaRepository<Commande, Integer> {

    Commande findCommandeById(int id);

    ArrayList<Commande> findCommandesByClientId(int client_id);


}
