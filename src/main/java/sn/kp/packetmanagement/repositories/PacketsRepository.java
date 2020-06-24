package sn.kp.packetmanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.kp.packetmanagement.domaine.Packets;

public interface PacketsRepository extends JpaRepository<Packets,Long> {
}
