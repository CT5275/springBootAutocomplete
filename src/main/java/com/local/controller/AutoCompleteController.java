package com.local.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.local.model.Book;


@Controller
public class AutoCompleteController {
	List<Book> listBook = new ArrayList<Book>();

	
	AutoCompleteController() {
		//init list
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			listBook = objectMapper.readValue(getClass().getResourceAsStream("/Booklist.json"), new TypeReference<List<Book>>(){});
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView getPages() {
		ModelAndView model = new ModelAndView("autocomplete");
		return model;
	}

	@RequestMapping(value = "/getBooks", method = RequestMethod.GET)
	public @ResponseBody List<Book> getBooks(@RequestParam String author) {
		return searchBook(author);
	}

	private List<Book> searchBook(String author) {
		List<Book> result = new ArrayList<Book>();
		for (Book book : listBook) {
			if (book.getAuthor().toLowerCase().contains(author.toLowerCase())) {
				result.add(book);
			}
		}
		return result;
	}

}