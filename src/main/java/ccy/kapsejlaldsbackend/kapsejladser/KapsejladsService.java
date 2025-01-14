package ccy.kapsejlaldsbackend.kapsejladser;

import ccy.kapsejlaldsbackend.kapsejladser.dto.KapsejladsRequest;
import ccy.kapsejlaldsbackend.kapsejladser.dto.KapsejladsResponse;
import ccy.kapsejlaldsbackend.kapsejladser.dto.Period;
import ccy.kapsejlaldsbackend.sejlbåde.Sejlbåd;
import ccy.kapsejlaldsbackend.sejlbåde.dto.SejlbådResponse;

import java.util.List;

public interface KapsejladsService {
    List<KapsejladsResponse> getAllKapsejlads();
    KapsejladsResponse getKapsejladsById(long id);
    KapsejladsResponse createKapsejlads(KapsejladsRequest postRequest);
    KapsejladsResponse updateKapsejlads(long id, KapsejladsRequest putRequest);
    void deleteKapsejlads(long id);

    SejlbådResponse addToKapsejlads(long kapsejladsId, long sejlbådId);
    SejlbådResponse removeFromKapsejlads(long kapsejladsId, long sejlbådId);

    List<SejlbådResponse> getSejlbådeFromKapsejlads(long id);

    List<KapsejladsResponse> createAllKapsejladsByPeriode(Period period);

    List<KapsejladsResponse> getKapsejladsBySailBoatId(long sejlbådId);
}
