package ccy.kapsejlaldsbackend.sejlbåde;

import ccy.kapsejlaldsbackend.sejlbåde.dto.SejlbådRequest;
import ccy.kapsejlaldsbackend.sejlbåde.dto.SejlbådResponse;

import java.util.List;

public interface SejlbådService {

    List<SejlbådResponse> getAllSejlbåd();
    SejlbådResponse getSejlbådById(Long id);
    SejlbådResponse createSejlbåd(SejlbådRequest postRequest);
    SejlbådResponse updateSejlbåd(SejlbådRequest putRequest);
    void deleteSejlbåd(long id);
    boolean doesExist(long id);
}
