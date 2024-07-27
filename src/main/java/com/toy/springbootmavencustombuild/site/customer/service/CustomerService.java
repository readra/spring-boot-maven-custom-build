package com.toy.springbootmavencustombuild.site.customer.service;

import org.springframework.stereotype.Service;

/**
 * 고객사 전용 Service Layer
 *
 * @author readra
 */
@Service
public class CustomerService {
	public static final String HELLO_WORLD = "{ \"message\" : \"Hello World My Customer\", \"code\" : %d }";

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
