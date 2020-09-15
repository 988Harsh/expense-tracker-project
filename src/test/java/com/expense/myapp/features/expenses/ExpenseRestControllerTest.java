package com.expense.myapp.features.expenses;

import com.expense.myapp.conf.WebSecurityConfig;
import java.util.Arrays;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.expense.myapp.features.expenses.ExpenseDTORes;
import com.expense.myapp.features.categories.Categories;
import com.expense.myapp.features.users.UserModel;
import com.expense.myapp.jwt.config.JwtAuthenticationEntryPoint;
import com.expense.myapp.jwt.config.JwtRequestFilter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.context.annotation.Import;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lenovo
 */
@RunWith(SpringRunner.class)
@WebMvcTest(value = ExpenseRestController.class)
@WithMockUser
@AutoConfigureMockMvc(addFilters = false)
public class ExpenseRestControllerTest {
    
        @Autowired
	private MockMvc mockMvc;

	@MockBean
	private ExpenseService expenseService;
        
        @MockBean
        private ExpenseRestController expenseRestController;
        
        @MockBean
	private Categories categoriesService;
        
        @MockBean
	private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

	@MockBean
	private UserDetailsService jwtUserDetailsService;

	@MockBean
	private JwtRequestFilter jwtRequestFilter;

	Expense mockExpense = new Expense("Expense1",10.5f);
        
        UserModel user = new UserModel("Harsh","test@test.com","harsh12345");
	String exampleExpenseJson = "{\"type\":\"food\",\"description\":\"10Steps\",\"amount\":\"10.5f\"}";

//	@Test
//        @AutoConfigureMockMvc(addFilters = false)
//        public void retrieveDetailsForExpense() throws Exception {
//            
//            
//                DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
//                String d2 = df.format(new Date(2323223232L));
//                mockExpense.setCreated_at(new Date(2323223232L));
//                mockExpense.setUpdated_at(new Date(2323223232L));
//                mockExpense.setId(1);
//                mockExpense.setCategory(new Categories("food"));
//                user.setId(1);
//                
//                given(expenseService.save(any(Expense.class))).willReturn(mockExpense);
//		
//                Mockito.when(
//				expenseService.findById(Mockito.anyInt(),Mockito.anyInt())).thenReturn(mockExpense);
//
//		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
//				"/api/expenses/1").requestAttr("user",user).accept(
//				MediaType.APPLICATION_JSON);
//
//		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
//
//		System.out.println("Here!!!!!!!!!!!!! "+result.getResponse());
//		String expected = "{id:1,description:Expense1,type:food,amount:10.5}";//,created_at:1970-01-28T02:50:23+0530,updated_at:1970-01-28T02:50:23+0530
//              
//		// {"id":"Expense1","name":"Spring","description":"10 Steps, 25 Examples and 10K Expenses","steps":["Learn Maven","Import Project","First Example","Second Example"]}
//
//		JSONAssert.assertEquals(expected, result.getResponse()
//				.getContentAsString(), false);
//	}

	@Test
        @AutoConfigureMockMvc(addFilters = false)
	public void createExpenseExpense() throws Exception {
		
                
                Expense theExpense = new Expense("desc",10.5f);
                theExpense.setId(0);
		theExpense.setUser(new UserModel("harsh","test@test.com","password"));
                theExpense.setCategory(new Categories("food"));

		// expenseService.addExpense to respond back with mockExpense
		Mockito.when(
				expenseService.save(
						Mockito.any(Expense.class))).thenReturn(theExpense);

                user.setId(1);
		// Send expense as body to /expenses/Expense1/expenses
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/api/expenses").requestAttr("user", user)
				.accept(MediaType.APPLICATION_JSON).content("{\"description\":\"Expense1\",\"category\":\"food\",\"amount\":10.5}")
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();

		assertEquals(HttpStatus.OK.value(), response.getStatus());

//		assertEquals("/api/expenses",
//				response.getHeader(HttpHeaders.LOCATION));

	}
    
    
}
