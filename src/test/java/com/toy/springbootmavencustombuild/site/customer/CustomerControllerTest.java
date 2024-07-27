package com.toy.springbootmavencustombuild.site.customer;

import com.toy.springbootmavencustombuild.site.customer.rest.CustomerController;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

/**
 * HelloWorldController 테스트 코드
 *
 * @author readra
 */
@AutoConfigureRestDocs
@WebMvcTest(CustomerController.class)
public class CustomerControllerTest {
}
