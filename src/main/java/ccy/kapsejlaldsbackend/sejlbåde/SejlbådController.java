package ccy.kapsejlaldsbackend.sejlbåde;

import ccy.kapsejlaldsbackend.exceptions.SejlbådNotFound;
import ccy.kapsejlaldsbackend.sejlbåde.dto.SejlbådRequest;
import ccy.kapsejlaldsbackend.sejlbåde.dto.SejlbådResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sejlbåde")
public class SejlbådController {

    private final SejlbådService service;

    public SejlbådController(SejlbådService service) {
        this.service = service;
    }


    @GetMapping
    public ResponseEntity<List<SejlbådResponse>> getAllSejlbåde() {
        List<SejlbådResponse> response = service.getAllSejlbåd();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SejlbådResponse> getSejlbådById(@PathVariable long id) {
        SejlbådResponse response = service.getSejlbådById(id);
        return ResponseEntity.ok(response);
    }



    @PostMapping
    public ResponseEntity<SejlbådResponse> createSejlbåd(@RequestBody SejlbådRequest postRequest) {
        SejlbådResponse createdSejlbåd = service.createSejlbåd(postRequest);
        return ResponseEntity.ok(createdSejlbåd);
    }



    @PutMapping("/{id}")
    public ResponseEntity<SejlbådResponse> updateSejlbåd(@PathVariable long id, @RequestBody SejlbådRequest putRequest) {

        boolean doesExist = service.doesExist(id);
        if (!doesExist) {
            throw new RuntimeException("Kunne ikke finde sejlbåd i database");
        }

        SejlbådResponse updatedSejlbpd = service.updateSejlbåd(putRequest);
        return ResponseEntity.ok(updatedSejlbpd);
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSejlbåd(@PathVariable long id) {

        boolean doesExist = service.doesExist(id);
        if (doesExist) {
            service.deleteSejlbåd(id);
            return ResponseEntity.noContent().build();

        } else {
            throw new SejlbådNotFound("Kunne ikke finde sejlbåd i database");
        }
    }
}
