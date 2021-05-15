package com.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Model.WashingMachine;
import com.Service.SampleMachineService;

@RestController
public class SampleMachineController {

	@Autowired
	private SampleMachineService sampleService;

	@GetMapping("/machine/{id}")
	public Optional<WashingMachine> getSpecificmachine(@PathVariable int id)
	{
		return sampleService.getSpecificMachine(id);
	}
	@PostMapping("/machine/add")
	public void addMachine(@RequestBody WashingMachine w)
	{
		sampleService.addMachine(w);
	}
	@PutMapping("/machine/update/{id}")
	public void updateSpecificmachine(@PathVariable int id)
	{
		 sampleService.updateSpecificMachine(id);
	}
	@DeleteMapping("/machine/delete/{id}")
	public void deleteSpecificmachine(@PathVariable int id)
	{
		 sampleService.deleteSpecificMachine(id);
	}
}
