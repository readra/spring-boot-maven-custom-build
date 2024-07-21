package com.toy.springbootmavencustombuild.rest;

import com.toy.springbootmavencustombuild.service.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 예제 Controller Layer
 *
 * @author readra
 */
@RestController
@RequestMapping("/v1")
public class HelloWorldController {
	private final HelloWorldService helloWorldService;

	@Autowired
	public HelloWorldController(final HelloWorldService helloWorldService) {
		this.helloWorldService = helloWorldService;
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
		return helloWorldService.helloWorld(code);
	}
}
