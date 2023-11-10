package tn.eniso.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.eniso.spring.entities.Piste;

public interface IPisteRepository extends JpaRepository<Piste, Long> {

}
