package ccy.kapsejlaldsbackend.sejlbåde;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SejlbådRepository extends JpaRepository<Sejlbåd, Long> {
}
