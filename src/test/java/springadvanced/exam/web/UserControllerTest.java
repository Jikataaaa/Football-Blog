package springadvanced.exam.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import springadvanced.exam.repository.UserRepository;

import javax.transaction.Transactional;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserRepository repository;


    @Test
    void getLoginPage() throws Exception {
        mockMvc.perform(get("/user/login"))
                .andExpect(status().isOk())
                .andExpect(view().name("login"));
    }

    @Test
    void getRegisterPage() throws Exception {
        mockMvc.perform(get("/user/register"))
                .andExpect(status().isOk())
                .andExpect(view().name("register"));
    }

     @Test
     @Transactional
        void postRegister() throws Exception {
            mockMvc.perform(post("/user/register")
                    .param("username","Nikolay")
                    .param("password", "12345")
                    .param("repeatPass", "12345")
                    .with(csrf()))
                    .andExpect(status().is3xxRedirection())
                    .andExpect(view().name("redirect:login"));

         repository.deleteByUsername("Nikolay");
        }

        @Test
        @Transactional
        void postRegisterFailParams() throws Exception {
            mockMvc.perform(post("/user/register")
                    .param("username","Nikolay")
                    .param("password", "1234")
                    .param("repeatPass", "123456")
                    .with(csrf()))
                    .andExpect(status().is3xxRedirection())
                    .andExpect(view().name("redirect:registration"));


            repository.deleteByUsername("Nikolay");

        }

}
