package com.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Model.WashingMachine;
import com.dao.SampleMachineRepositoryInterface;

@Service
public class SampleMachineService {

	@Autowired
	private SampleMachineRepositoryInterface sampleRepository;
	
	public void addMachine(WashingMachine w) {
		sampleRepository.save(w);
		
	}

	public Optional<WashingMachine> getSpecificMachine(int id) {
		
		return sampleRepository.findById(id);
	}

	public void updateSpecificMachine(int id) {
		Optional<WashingMachine> wm = sampleRepository.findById(id);
		
		wm.get().setName("Onida");
		sampleRepository.save(wm.get());
		
	}

	public void deleteSpecificMachine(int id) {

		sampleRepository.deleteById(id);
		
	}

	
	
}
