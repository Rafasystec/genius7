package com.genius7.rule;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.genius7.model.ProArea;
import com.genius7.repository.ProAreaRepo;
@Service
public class ProAreaRule extends SuperRule{
	
	@Autowired
	private ProAreaRepo proAreaRepo;
	
	public List<ProArea> findAll() {
		 return proAreaRepo.findAll();
	}

}
