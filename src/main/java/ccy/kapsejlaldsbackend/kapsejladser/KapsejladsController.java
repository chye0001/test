package ccy.kapsejlaldsbackend.kapsejladser;

import ccy.kapsejlaldsbackend.kapsejladser.dto.KapsejladsRequest;
import ccy.kapsejlaldsbackend.kapsejladser.dto.KapsejladsResponse;
import ccy.kapsejlaldsbackend.kapsejladser.dto.Period;
import ccy.kapsejlaldsbackend.sejlbåde.dto.SejlbådResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/kapsejladser")
public class KapsejladsController {

    private final KapsejladsService kapsejladsService;

    public KapsejladsController(KapsejladsService kapsejladsService) {
        this.kapsejladsService = kapsejladsService;
    }

    @GetMapping
    public ResponseEntity<List<KapsejladsResponse>> getAllKapsejladser() {
        List<KapsejladsResponse> kapsejlads = kapsejladsService.getAllKapsejlads();
        return ResponseEntity.ok(kapsejlads);
    }

    @GetMapping("/{id}")
    public ResponseEntity<KapsejladsResponse> getKapsejladsById(@PathVariable long id) {
        KapsejladsResponse kapsejlads = kapsejladsService.getKapsejladsById(id);
        return ResponseEntity.ok(kapsejlads);
    }

    @GetMapping("/{id}/sejlbåde")
    public ResponseEntity<List<SejlbådResponse>> getSejlbådeFromKapsejlads(@PathVariable long id) {
        List<SejlbådResponse> sejlbåde = kapsejladsService.getSejlbådeFromKapsejlads(id);
        return ResponseEntity.ok(sejlbåde);
    }

    @GetMapping("/sejlbåde/{sejlbådId}")
    public ResponseEntity<List<KapsejladsResponse>> getKapsejladsBySailBoatId(@PathVariable long sejlbådId) {
        List<KapsejladsResponse> kapsejlads = kapsejladsService.getKapsejladsBySailBoatId(sejlbådId);
        return ResponseEntity.ok(kapsejlads);
    }

    @PostMapping
    public ResponseEntity<KapsejladsResponse> createKapsejlads(@RequestBody KapsejladsRequest postRequest) {
        KapsejladsResponse kapsejlads = kapsejladsService.createKapsejlads(postRequest);
        return ResponseEntity.ok(kapsejlads);
    }

    @PutMapping("/{id}")
    public ResponseEntity<KapsejladsResponse> updateKapsejlads(@PathVariable long id, @RequestBody KapsejladsRequest putRequest) {
        KapsejladsResponse kapsejlads = kapsejladsService.updateKapsejlads(id, putRequest);
        return ResponseEntity.ok(kapsejlads);
    }

    @PostMapping("/all")
    public ResponseEntity<List<KapsejladsResponse>> createAllKapsejladsByPeriode(@RequestBody Period period) {
        System.out.println("PERIODDDDDDDDDDDDDDDDDDDDDDDDDDDDD: " + period);
        List<KapsejladsResponse> kapsejlads = kapsejladsService.createAllKapsejladsByPeriode(period);
        System.out.println("KAPSEJLADSSSSSSSSSSSSSSSSSSSSSSSSS: " + kapsejlads);
        return ResponseEntity.ok(kapsejlads);
    }

    @PutMapping("/{kapsejladsId}/sejlbåde")
    public ResponseEntity<SejlbådResponse> addSailBoatToKapsejlads(@PathVariable long kapsejladsId, @RequestBody long sejlbådId) {
        SejlbådResponse response = kapsejladsService.addToKapsejlads(kapsejladsId, sejlbådId);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteKapsejlads(@PathVariable long id) {
        kapsejladsService.deleteKapsejlads(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{kapsejladsId}/sejlbåde/{sejlbådId}")
    public ResponseEntity<Void> removeSailBoatFromKapsejlads(@PathVariable long kapsejladsId, @PathVariable long sejlbådId) {
        kapsejladsService.removeFromKapsejlads(kapsejladsId, sejlbådId);
        return ResponseEntity.noContent().build();
    }
}
