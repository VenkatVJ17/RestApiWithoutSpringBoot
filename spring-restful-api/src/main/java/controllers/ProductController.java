package controllers;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import models.Product;

@RestController
public class ProductController {

	private static final String template = "%s is added !";
	private final AtomicLong counter = new AtomicLong();

	@RequestMapping(value = "/addProduct", method = RequestMethod.GET)
	public Product sendProduct(@RequestParam(value = "name", defaultValue = "apple") String name) {

		return new Product(counter.incrementAndGet(), String.format(template, name));
	}
}