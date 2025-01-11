package ccy.kapsejlaldsbackend.sejlbåd.dto;

import ccy.kapsejlaldsbackend.sejlbåd.Sejlbåd;
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
        return Sejlbåd.builder()
                .name(sejlbådRequest.name())
                .bådType(sejlbådRequest.bådType())
                .build();
    }
}
