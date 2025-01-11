package ccy.kapsejlaldsbackend.sejlbåd.dto;

import ccy.kapsejlaldsbackend.sejlbåd.BådType;

public record SejlbådResponse(
        long id,
        String name,
        BådType bådType
) {
}
