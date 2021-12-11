package springadvanced.exam.web;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@SpringBootTest
@AutoConfigureMockMvc
public class PlayerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
   public void getAllPlayers() throws Exception {
        mockMvc.perform(get("/players-all"))
                .andExpect(status().isOk())
                .andExpect(view().name("players"));
    }

    @Test
    public void getAddPlayers() throws Exception{
        mockMvc.perform(get("/player-add"))
                .andExpect(status().isOk())
                .andExpect(view().name("newPlayer"));
    }

}
