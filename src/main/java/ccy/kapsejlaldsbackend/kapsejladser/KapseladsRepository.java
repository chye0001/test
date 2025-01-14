package ccy.kapsejlaldsbackend.kapsejladser;

import ccy.kapsejlaldsbackend.sejlbåde.Sejlbåd;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface KapseladsRepository extends JpaRepository<Kapsejlads, Long> {

    List<Kapsejlads> findAllBySejlbåde(List<Sejlbåd> sejlbåde);
}
