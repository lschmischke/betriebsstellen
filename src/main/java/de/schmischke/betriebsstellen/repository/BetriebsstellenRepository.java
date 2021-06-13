package de.schmischke.betriebsstellen.repository;

import de.schmischke.betriebsstellen.domain.Betriebsstelle;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BetriebsstellenRepository extends CrudRepository<Betriebsstelle, String> {
}
