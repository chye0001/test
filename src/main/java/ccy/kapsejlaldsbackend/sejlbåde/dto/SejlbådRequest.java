package ccy.kapsejlaldsbackend.sejlbåde.dto;

import ccy.kapsejlaldsbackend.sejlbåde.BådType;

public record SejlbådRequest(
        String name,
        BådType bådType
) {
}
