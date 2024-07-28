package com.toy.springbootmavencustombuild.site.customer;

import com.toy.springbootmavencustombuild.site.customer.rest.CustomerController;
import com.toy.springbootmavencustombuild.site.customer.service.CustomerService;
import org.junit.Before;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.restdocs.JUnitRestDocumentation;
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * CustomerController 테스트 코드
 *
 * @author readra
 */
@AutoConfigureRestDocs
@WebMvcTest(CustomerController.class)
public class CustomerControllerTest {
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private WebApplicationContext webApplicationContext;
	@MockBean
	private CustomerService customerService;

	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext)
				.apply(documentationConfiguration(new JUnitRestDocumentation()))
				.build();
	}

	@Test
	@DisplayName("Customer Hello World")
	void helloWorldTest() throws Exception {
		final int code = 100;
		final String result = String.format(CustomerService.HELLO_WORLD, code);

		// given
		given(customerService.helloWorld(anyInt())).willReturn(result);

		// when
		ResultActions resultActions = mockMvc.perform(
				RestDocumentationRequestBuilders.get("/v1/customer/hello-world/{code}", code)
						.contentType(MediaType.APPLICATION_JSON)
		);

		// then
		resultActions.andExpect(status().isOk())
				.andDo(
						document(
								"Customer Hello World",
								preprocessRequest(prettyPrint()),
								preprocessResponse(prettyPrint()),
								pathParameters(
										parameterWithName("code").description("코드")
								),
								responseFields(
										fieldWithPath("message").type(JsonFieldType.STRING).description("메시지"),
										fieldWithPath("code").type(JsonFieldType.NUMBER).description("코드")
								)
						)

				)
				.andDo(print());
	}
}
