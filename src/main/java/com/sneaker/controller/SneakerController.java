package com.sneaker.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sneaker.model.Sneaker;
import com.sneaker.repository.SneakerRepository;

@RestController
@RequestMapping("api/")
public class SneakerController {
	
	@Autowired
	private SneakerRepository sneakerRepository;
	@CrossOrigin
	@RequestMapping(value="sneakers", method= RequestMethod.GET)
	public List<Sneaker> list(){
		return sneakerRepository.findAll();
	}

	@CrossOrigin
	@RequestMapping(value="sneaker/{id}", method= RequestMethod.GET)
	public Sneaker get(@PathVariable Long id){
		return sneakerRepository.findOne(id);
	}

	@CrossOrigin
	@RequestMapping(value="sneakers", method= RequestMethod.POST)
	public Sneaker create(@RequestBody Sneaker sneaker){
		return sneakerRepository.saveAndFlush(sneaker);
	}

	@CrossOrigin
	@RequestMapping(value="sneakers", method= RequestMethod.PUT)
	public Sneaker update(@PathVariable Long id, @RequestBody Sneaker sneaker){
		Sneaker existingSneaker = sneakerRepository.findOne(id);
		BeanUtils.copyProperties(sneaker, existingSneaker);
		return sneakerRepository.saveAndFlush(existingSneaker);
	}
	

	@CrossOrigin
	@RequestMapping(value="sneaker/{id}", method= RequestMethod.DELETE)
	public Sneaker delete(@PathVariable Long id){
		Sneaker existingSneaker = sneakerRepository.findOne(id);
		sneakerRepository.delete(existingSneaker);
		
		return existingSneaker;
	}

}
