package ccy.kapsejlaldsbackend.sejlbåde.dto;

import ccy.kapsejlaldsbackend.sejlbåde.Sejlbåd;
import org.springframework.stereotype.Component;

@Component
public class SejlbådMapper {

    public SejlbådResponse toSejlbådResponse(Sejlbåd sejlbåd) {
        return new SejlbådResponse(
                sejlbåd.getId(),
                sejlbåd.getName(),
                sejlbåd.getBådType()
        );
    }

    public Sejlbåd toSejlbåd(SejlbådRequest sejlbådRequest) {
        return new Sejlbåd(
                sejlbådRequest.name(),
                sejlbådRequest.bådType()
        );
    }
}
