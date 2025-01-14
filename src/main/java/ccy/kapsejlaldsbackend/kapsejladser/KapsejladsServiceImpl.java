package ccy.kapsejlaldsbackend.kapsejladser;

import ccy.kapsejlaldsbackend.exceptions.KapsejladsNotFound;
import ccy.kapsejlaldsbackend.exceptions.SejlbådNotFound;
import ccy.kapsejlaldsbackend.kapsejladser.dto.KapsejladsMapper;
import ccy.kapsejlaldsbackend.kapsejladser.dto.KapsejladsRequest;
import ccy.kapsejlaldsbackend.kapsejladser.dto.KapsejladsResponse;
import ccy.kapsejlaldsbackend.kapsejladser.dto.Period;
import ccy.kapsejlaldsbackend.sejlbåde.BådType;
import ccy.kapsejlaldsbackend.sejlbåde.Sejlbåd;
import ccy.kapsejlaldsbackend.sejlbåde.SejlbådRepository;
import ccy.kapsejlaldsbackend.sejlbåde.dto.SejlbådMapper;
import ccy.kapsejlaldsbackend.sejlbåde.dto.SejlbådResponse;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class KapsejladsServiceImpl implements KapsejladsService {

    private final SejlbådRepository sejlbådRepository;
    private final KapseladsRepository kapseladsRepository;
    private final KapsejladsMapper kapsejladsMapper;
    private final SejlbådMapper sejlbådMapper;

    public KapsejladsServiceImpl(KapseladsRepository kapseladsRepository, KapsejladsMapper kapsejladsMapper, SejlbådMapper sejlbådMapper, SejlbådRepository sejlbådRepository) {
        this.kapseladsRepository = kapseladsRepository;
        this.kapsejladsMapper = kapsejladsMapper;
        this.sejlbådMapper = sejlbådMapper;
        this.sejlbådRepository = sejlbådRepository;
    }



    @Override
    public List<KapsejladsResponse> getAllKapsejlads() {
       List<Kapsejlads> list = kapseladsRepository.findAll();
       return list.stream().map(kapsejladsMapper::toKapsejladsResponse).collect(Collectors.toList());
    }

    @Override
    public KapsejladsResponse getKapsejladsById(long id) {
        Kapsejlads kapsejlads = kapseladsRepository.findById(id).orElseThrow( () -> new KapsejladsNotFound("Kapsejlads with id " + id + "not found"));
        return kapsejladsMapper.toKapsejladsResponse(kapsejlads);
    }

    @Override
    public KapsejladsResponse createKapsejlads(KapsejladsRequest postRequest) {
        Kapsejlads kapsejladsToCreate = kapsejladsMapper.toKapsejlads(postRequest);
        Kapsejlads createdKapsejlads = kapseladsRepository.save(kapsejladsToCreate);
        createdKapsejlads.setSejlbåde(new ArrayList<>());

        return kapsejladsMapper.toKapsejladsResponse(createdKapsejlads);
    }

    @Override
    public KapsejladsResponse updateKapsejlads(long id, KapsejladsRequest putRequest) {
        boolean doesExist = kapseladsRepository.existsById(id);
        if (!doesExist) {
            throw new KapsejladsNotFound("Kapsejlads with id " + id + " not found");
        }

        Kapsejlads kapsejladsToUpdate = kapsejladsMapper.toKapsejlads(putRequest);
        kapsejladsToUpdate.setId(id);
        Kapsejlads updatedKapsejlads = kapseladsRepository.save(kapsejladsToUpdate);

        return kapsejladsMapper.toKapsejladsResponse(updatedKapsejlads);
    }

    @Override
    public void deleteKapsejlads(long id) {
        boolean doesExist = kapseladsRepository.existsById(id);
        if (doesExist) {
            kapseladsRepository.deleteById(id);

        } else {
            throw new KapsejladsNotFound("Kapsejlads with id " + id + " not found");
        }
    }

    @Override
    @Transactional
    public SejlbådResponse addToKapsejlads(long kapsejladsId, long sejlbådId) {
        Sejlbåd sejlbådToAdd = sejlbådRepository.findById(sejlbådId).orElseThrow( () -> new SejlbådNotFound("Sejlbåd with id " + sejlbådId + "not found"));

        Kapsejlads kapsejlads = kapseladsRepository.findById(kapsejladsId).orElseThrow(() -> new KapsejladsNotFound("Kapsejlads with id " + kapsejladsId + "not found"));
        kapsejlads.getSejlbåde().add(sejlbådToAdd);
        kapseladsRepository.save(kapsejlads);

        return sejlbådMapper.toSejlbådResponse(sejlbådToAdd);
    }

    @Override
    @Transactional
    public SejlbådResponse removeFromKapsejlads(long kapsejladsId, long sejlbådId) {
        Sejlbåd sejlbåd = sejlbådRepository.findById(sejlbådId).orElseThrow(() -> new SejlbådNotFound("Sejlbåd with id " + sejlbådId + "not found"));

        Kapsejlads kapsejlads = kapseladsRepository.findById(kapsejladsId).orElseThrow(() -> new KapsejladsNotFound("Kapsejlads with id " + kapsejladsId + "not found"));
        kapsejlads.getSejlbåde().remove(sejlbåd);
        kapseladsRepository.save(kapsejlads);

        return sejlbådMapper.toSejlbådResponse(sejlbåd);
    }

    @Override
    public List<SejlbådResponse> getSejlbådeFromKapsejlads(long id) {
        Kapsejlads kapsejlads = kapseladsRepository.findById(id).orElseThrow(() -> new KapsejladsNotFound("Kapsejlads with id " + id + "not found"));
        return kapsejlads.getSejlbåde().stream().map(sejlbådMapper::toSejlbådResponse).collect(Collectors.toList());
    }

    @Override
    public List<KapsejladsResponse> createAllKapsejladsByPeriode(Period period) {
        List<LocalDate> dates = getAllKapsejladsDates(period);
        System.out.println("DATESSSSSSSSSSSSSSSSSSSSSSSSSSSSS: " + dates);

        List<Kapsejlads> createdKapsejladsTypeA;
        List<Kapsejlads> kapsejladsTypeA = dates.stream().map(date ->
                new Kapsejlads("Kapsejlads " + date, date.atTime(12, 0, 0), BådType.TYPE_A))
                .collect(Collectors.toList());
        createdKapsejladsTypeA = kapseladsRepository.saveAll(kapsejladsTypeA);
        System.out.println("CREATEDDDDDDDDDDDDDDDDDDDDDD" + createdKapsejladsTypeA);

        List<Kapsejlads> createdKapsejladsTypeB;
        List<Kapsejlads> kapsejladsTypeB = dates.stream().map(date ->
                        new Kapsejlads("Kapsejlads " + date, date.atTime(14, 0, 0), BådType.TYPE_B))
                .collect(Collectors.toList());
        createdKapsejladsTypeB = kapseladsRepository.saveAll(kapsejladsTypeB);

        List<Kapsejlads> createdKapsejladsTypeC;
        List<Kapsejlads> kapsejladsTypeC = dates.stream().map(date ->
                        new Kapsejlads("Kapsejlads " + date, date.atTime(16, 0, 0), BådType.TYPE_C))
                .collect(Collectors.toList());
        createdKapsejladsTypeC = kapseladsRepository.saveAll(kapsejladsTypeC);

        List<Kapsejlads> allKapsejlads = new ArrayList<>();
        allKapsejlads.addAll(createdKapsejladsTypeA);
        allKapsejlads.addAll(createdKapsejladsTypeB);
        allKapsejlads.addAll(createdKapsejladsTypeC);

        return allKapsejlads.stream().map(kapsejladsMapper::toKapsejladsResponse).collect(Collectors.toList());
    }

    @Override
    public List<KapsejladsResponse> getKapsejladsBySailBoatId(long sejlbådId) {
        Sejlbåd sejlbåd = sejlbådRepository.findById(sejlbådId).orElseThrow( () -> new SejlbådNotFound("Sejlbåd with id " + sejlbådId + "not found"));
        System.out.println("SEJLBÅD IN SERVICE: " + sejlbåd);

        List<Sejlbåd> sejlbådList = new ArrayList<>(List.of(sejlbåd));
        List<Kapsejlads> kapsejlads = kapseladsRepository.findAllBySejlbåde(sejlbådList);
        System.out.println("KAPSEJSLALSSA" + kapsejlads);
        return kapsejlads.stream().map(kapsejladsMapper::toKapsejladsResponse).collect(Collectors.toList());
    }

    private List<LocalDate> getAllKapsejladsDates(Period period) {
        LocalDate startDate = period.startDate();
        LocalDate endDate = period.endDate();

        return startDate.datesUntil(endDate).filter(date -> date.getDayOfWeek().name().equalsIgnoreCase("WEDNESDAY")).toList();
    }
}
