package sn.kp.packetmanagement;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import sn.kp.packetmanagement.domaine.Packets;
import sn.kp.packetmanagement.repositories.PacketsRepository;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PacketsRepositoryTest {

    @Autowired
    private PacketsRepository packetsRepository;

    @Test
    public void savePackets() {
        //arrange
        Packets packets = new Packets("BAG", new Date(), "My Computer BAG");
        //action
        Packets saved = packetsRepository.save(packets);

        assertEquals(saved.getId(), (Long) 1L);
        assertThat(saved.getName()).isEqualTo("BAG");
        assertThat(saved.getDescription()).isEqualTo("My Computer BAG");

    }
}
