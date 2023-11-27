package com.example.rest;


import com.example.rest.Cliente;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

public interface ClienteRepository extends JpaRepositoryImplementation<Cliente, Integer> {
}
