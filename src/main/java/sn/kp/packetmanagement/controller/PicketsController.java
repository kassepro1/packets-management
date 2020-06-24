package sn.kp.packetmanagement.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.kp.packetmanagement.domaine.Packets;
import sn.kp.packetmanagement.repositories.PacketsRepository;

@RestController
@RequiredArgsConstructor
public class PicketsController {

    private final PacketsRepository packetsRepository;

    @PostMapping("/pickets")
    public ResponseEntity<Packets> createPickest(@RequestBody Packets packets) {
        Packets p = packetsRepository.save(packets);
        return new ResponseEntity<Packets>(p, HttpStatus.CREATED);
    }

    @GetMapping("/pickets/{name}")
    public ResponseEntity<Packets> findPacketsByName(@PathVariable("name") String name){
        Packets p = packetsRepository.findPacketsByName(name);
        return new ResponseEntity<>(p,HttpStatus.OK);
    }
}
