package com.example.oskaribookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class BookController {

	@RequestMapping(name= "/index")
	public String listbooks() {
		return "placeholder";
	}
}
