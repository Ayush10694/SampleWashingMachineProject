package com.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Model.WashingMachine;

@Repository
public interface SampleMachineRepositoryInterface extends CrudRepository<WashingMachine, Integer> {

}
