package ccy.kapsejlaldsbackend.kapsejladser.dto;

import ccy.kapsejlaldsbackend.kapsejladser.Kapsejlads;
import ccy.kapsejlaldsbackend.sejlbåde.dto.SejlbådMapper;
import ccy.kapsejlaldsbackend.sejlbåde.dto.SejlbådResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class KapsejladsMapper {

    private final SejlbådMapper sejlbådMapper;

    public KapsejladsMapper(SejlbådMapper sejlbådMapper) {
        this.sejlbådMapper = sejlbådMapper;
    }

    public Kapsejlads toKapsejlads(KapsejladsRequest kapsejladsRequest) {
        return new Kapsejlads(
                kapsejladsRequest.name(),
                kapsejladsRequest.startDate(),
                kapsejladsRequest.raceType()
        );
    }



    public KapsejladsResponse toKapsejladsResponse(Kapsejlads kapsejlads) {

        List<SejlbådResponse> sejlbådResponseList = kapsejlads.getSejlbåde().stream()
                .map(sejlbådMapper::toSejlbådResponse)
                .toList();

        return new KapsejladsResponse(
                kapsejlads.getId(),
                kapsejlads.getName(),
                kapsejlads.getStartDate(),
                kapsejlads.getRaceType(),
                sejlbådResponseList
        );
    }
}
