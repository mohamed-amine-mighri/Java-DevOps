package tn.eniso.spring.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import tn.eniso.spring.entities.Instructor;



public interface IInstructorRepository extends JpaRepository<Instructor, Long> {

}
