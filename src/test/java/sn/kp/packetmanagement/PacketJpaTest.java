package sn.kp.packetmanagement;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import sn.kp.packetmanagement.domaine.Packets;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PacketJpaTest {
    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    public void addPacket() {
        //arrange
        //action
        Packets packets = new Packets("BAG", new Date(), "My Computer BAG");
        Packets createdP = testEntityManager.persistAndFlush(packets);
        //assertion
        assertThat(createdP.getName()).isEqualTo("BAG");
        assertThat(createdP.getDescription()).isEqualTo("My Computer BAG");
    }
}
