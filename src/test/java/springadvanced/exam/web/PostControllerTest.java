package springadvanced.exam.web;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import springadvanced.exam.repository.PostRepository;


import javax.transaction.Transactional;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@SpringBootTest
@AutoConfigureMockMvc
public class PostControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PostRepository repository;

    @Test
    public void getAllPosts() throws Exception {
        mockMvc.perform(get("/posts-all"))
                .andExpect(status().isOk())
                .andExpect(view().name("posts"));
    }

    @Test
    public void getAddPost() throws Exception{
        mockMvc.perform(get("/post-add"))
                .andExpect(status().isOk())
                .andExpect(view().name("newPost"));
    }


}
