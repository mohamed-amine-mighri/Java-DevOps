package tn.eniso.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.eniso.spring.entities.Course;

public interface ICourseRepository extends JpaRepository<Course, Long> {



}
