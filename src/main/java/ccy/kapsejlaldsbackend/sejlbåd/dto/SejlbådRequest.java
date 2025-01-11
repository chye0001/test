package ccy.kapsejlaldsbackend.sejlbåd.dto;

import ccy.kapsejlaldsbackend.sejlbåd.BådType;

public record SejlbådRequest(
        String name,
        BådType bådType
) {
}
