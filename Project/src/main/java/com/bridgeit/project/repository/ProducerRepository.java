package com.bridgeit.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bridgeit.project.model.Producer;

@Repository
public interface ProducerRepository extends JpaRepository<Producer,Long> {

}
