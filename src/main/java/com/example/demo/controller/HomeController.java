package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	@RequestMapping(value="/home", method=RequestMethod.GET)
	public String goHome() {
		System.out.println("Enter!!~~~~~~~~");
		return "index.html";
	}
	
	@RequestMapping(value="/home/{name}/{age}", method=RequestMethod.GET)
	@ResponseBody
	public String member(@PathVariable("name") String name, @PathVariable("age") String age) {
		System.out.println(name+" is "+age+" years old !");
		return name+" is "+age+" years old !";
	}
	
	@RequestMapping(value="/valueTest", method=RequestMethod.GET)
	@ResponseBody
	public String valueTest() {
		return "ResponseBody Test";
	}
	
	@RequestMapping(value="/test", method=RequestMethod.GET)
	@ResponseBody
	public ModelAndView test() throws Exception {
		ModelAndView mav = new ModelAndView("test");
		mav.addObject("name", "eunbin");
		
		List<String> testList = new ArrayList<String>();
		testList.add("a");
		testList.add("b");
		testList.add("c");
		
		mav.addObject("list", testList);
		return mav;
	}
}
