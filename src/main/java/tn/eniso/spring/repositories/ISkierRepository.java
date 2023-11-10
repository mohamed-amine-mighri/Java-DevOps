package tn.eniso.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.eniso.spring.entities.Skier;
import tn.eniso.spring.entities.Subscription;
import tn.eniso.spring.entities.TypeSubscription;

import java.util.List;

public interface ISkierRepository extends JpaRepository<Skier, Long> {
   List<Skier> findBySubscription_TypeSub(TypeSubscription typeSubscription);
   Skier findBySubscription(Subscription subscription);


}
