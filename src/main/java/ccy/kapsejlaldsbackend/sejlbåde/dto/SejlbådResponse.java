package ccy.kapsejlaldsbackend.sejlbåde.dto;

import ccy.kapsejlaldsbackend.sejlbåde.BådType;

public record SejlbådResponse(
        long id,
        String name,
        BådType bådType
) {
}
