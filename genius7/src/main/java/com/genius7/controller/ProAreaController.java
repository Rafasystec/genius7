package com.genius7.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.genius7.model.ProArea;
import com.genius7.rule.ProAreaRule;

@RestController
@RequestMapping("area")
public class ProAreaController extends SuperController {
	@Autowired
	private ProAreaRule proAreaRule;

	@PostMapping
	@Transactional
	public ResponseEntity<List<ProArea>> getAll() {
		List<ProArea> list = proAreaRule.findAll();
		return responseOK(list);
	}
}
