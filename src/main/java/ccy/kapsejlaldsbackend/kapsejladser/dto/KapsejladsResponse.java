package ccy.kapsejlaldsbackend.kapsejladser.dto;

import ccy.kapsejlaldsbackend.sejlbåde.BådType;
import ccy.kapsejlaldsbackend.sejlbåde.Sejlbåd;
import ccy.kapsejlaldsbackend.sejlbåde.dto.SejlbådResponse;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public record KapsejladsResponse(
        long id,
        String name,
        LocalDateTime startDate,
        BådType raceType,
        List<SejlbådResponse> sejlbådResponseList
) {
}
