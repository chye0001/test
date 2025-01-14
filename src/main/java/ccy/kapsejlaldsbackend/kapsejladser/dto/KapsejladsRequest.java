package ccy.kapsejlaldsbackend.kapsejladser.dto;

import ccy.kapsejlaldsbackend.sejlbåde.BådType;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record KapsejladsRequest(
        String name,
        LocalDateTime startDate,
        BådType raceType
) {
}
