package com.toy.springbootmavencustombuild.service;

import org.springframework.stereotype.Service;

/**
 * 예제 Service Layer
 *
 * @author readra
 */
@Service
public class HelloWorldService {
	public static final String HELLO_WORLD = "{ \"message\" : \"Hello World\", \"code\" : %d }";

	/**
	 * 안녕하세요!
	 *
	 * @param code
	 * 		코드
	 * @return
	 *      안녕하세요!
	 */
	public String helloWorld(int code) {
		return String.format(HELLO_WORLD, code);
	}
}
