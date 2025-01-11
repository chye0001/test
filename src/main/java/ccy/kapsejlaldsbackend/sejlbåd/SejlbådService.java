package ccy.kapsejlaldsbackend.sejlbåd;

import ccy.kapsejlaldsbackend.sejlbåd.dto.SejlbådRequest;
import ccy.kapsejlaldsbackend.sejlbåd.dto.SejlbådResponse;

import java.util.List;

public interface SejlbådService {

    List<SejlbådResponse> getAllSejlbåd();
    SejlbådResponse getSejlbådById(Long id);
    SejlbådResponse createSejlbåd(SejlbådRequest postRequest);
    SejlbådResponse updateSejlbåd(SejlbådRequest putRequest);
    void deleteSejlbåd(long id);
    boolean doesExist(long id);
}
