package com.toy.springbootmavencustombuild.site.customer.rest;

import com.toy.springbootmavencustombuild.site.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 고객사 전용 Controller Layer
 *
 * @author readra
 */
@RestController
@RequestMapping("/v1/customer/")
public class CustomerController {
	private final CustomerService customerService;

	@Autowired
	public CustomerController(final CustomerService customerService) {
		this.customerService = customerService;
	}

	/**
	 * 안녕하세요!
	 *
	 * @param code
	 * 		코드
	 * @return
	 *      안녕하세요!
	 */
	@GetMapping("/hello-world/{code}")
	public String helloWorld(@PathVariable int code) {
		return customerService.helloWorld(code);
	}
}
