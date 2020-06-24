package sn.kp.packetmanagement;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import sn.kp.packetmanagement.domaine.Packets;
import sn.kp.packetmanagement.repositories.PacketsRepository;

import java.util.Date;

import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest
public class PicketsRestController {
    public static final ObjectMapper om = new ObjectMapper();
    @Autowired
    MockMvc mockMvc;
    @MockBean
    private PacketsRepository packetsRepository;


    @Test
    public void createPicket() throws Exception {
        Packets packets = new Packets(1L,"BAG", new Date(), "My Computer BAG");
       when(packetsRepository.save(any(Packets.class))).thenReturn(packets);
        mockMvc.perform(MockMvcRequestBuilders.post("/pickets")
          .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
         .content(om.writeValueAsString(packets)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id",is(1)))
                .andExpect(jsonPath("$.name",is("BAG")))
                .andExpect(jsonPath("$.description",is("My Computer BAG")));

        verify(packetsRepository,times(1)).save(any(Packets.class));
    }

}
