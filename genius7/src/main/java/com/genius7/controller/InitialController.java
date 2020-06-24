package com.genius7.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InitialController extends SuperController {

	@RequestMapping("/")
	public List<TestB> initPath() {
		List<TestB> response = Arrays.asList(new TestB()
				.setId("1").setName("Name"),new TestB().setId("2").setName("Name1"));
		return response;
	}
	
	class TestB{
		private String name;
		private String id;
		/**
		 * @return the name
		 */
		public String getName() {
			return name;
		}
		/**
		 * @param name the name to set
		 */
		public TestB setName(String name) {
			this.name = name;
			return this;
		}
		/**
		 * @return the id
		 */
		public String getId() {
			return id;
		}
		/**
		 * @param id the id to set
		 */
		public TestB setId(String id) {
			this.id = id;
			return this;
		}
		
	}
}
