package ru.shaitanshamma.controlerTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@TestPropertySource(locations = "classpath:application-test.properties")
@AutoConfigureMockMvc
@SpringBootTest
public class MainControllerTests {

    @Autowired
    private MockMvc mvc;

    @Test
    public void testIndexPage() throws Exception {
        mvc.perform(get("/").contentType(MediaType.TEXT_HTML))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("products"))
                .andExpect(model().attributeExists("cartItems"))
                .andExpect(view().name("index"));
    }

    @Test
    public void testCartPage() throws Exception {
        mvc.perform(get("/cart").contentType(MediaType.TEXT_HTML))
                .andExpect(status().isOk())
                .andExpect(view().name("cart"));
    }

    @Test
    public void badCredentials() throws Exception {
        mvc.perform(formLogin("/authenticateTheUser").user("admin").password("100"))
                .andDo(print())
                .andExpect(status().is3xxRedirection());
    }

    @Test
    public void correctLogin() throws Exception {
        mvc.perform(formLogin("/authenticateTheUser").user("Bob").password("admin"))
                .andDo(print())
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/"));
    }
}
