package ccy.kapsejlaldsbackend.kapsejladser.dto;

import java.time.LocalDate;

public record Period(
        LocalDate startDate,
        LocalDate endDate
) {
}
