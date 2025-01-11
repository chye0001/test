package ccy.kapsejlaldsbackend.exceptions;

public record Error(
        int status,
        String message
) {
}
