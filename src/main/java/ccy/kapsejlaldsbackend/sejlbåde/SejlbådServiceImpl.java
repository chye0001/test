package ccy.kapsejlaldsbackend.sejlbåde;

import ccy.kapsejlaldsbackend.exceptions.SejlbådNotFound;
import ccy.kapsejlaldsbackend.sejlbåde.dto.SejlbådMapper;
import ccy.kapsejlaldsbackend.sejlbåde.dto.SejlbådRequest;
import ccy.kapsejlaldsbackend.sejlbåde.dto.SejlbådResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SejlbådServiceImpl implements SejlbådService {

//    @Value("${sejlbåd.notfound.exception.message}")
    private final String sejlbådNotFoundExceptionMessage = "Sejlbåden findes ikke i vores database.";

    private final SejlbådRepository sejlbådRepository;
    private final SejlbådMapper sejlbådMapper;

    public SejlbådServiceImpl(SejlbådRepository sejlbådRepository, SejlbådMapper sejlbådMapper) {
        this.sejlbådRepository = sejlbådRepository;
        this.sejlbådMapper = sejlbådMapper;
    }


    @Override
    public List<SejlbådResponse> getAllSejlbåd() {
        return sejlbådRepository.findAll().stream()
                .map(sejlbåd -> sejlbådMapper.toSejlbådResponse(sejlbåd))
                .toList();
    }

    @Override
    public SejlbådResponse getSejlbådById(Long id) {
        Sejlbåd sejlbåd = sejlbådRepository.findById(id).orElseThrow(() -> new SejlbådNotFound(sejlbådNotFoundExceptionMessage));
        return sejlbådMapper.toSejlbådResponse(sejlbåd);
    }

    @Override
    public SejlbådResponse createSejlbåd(SejlbådRequest postRequest) {
        Sejlbåd sejlbådToCreate = sejlbådMapper.toSejlbåd(postRequest);
        Sejlbåd createdSejlbåd = sejlbådRepository.save(sejlbådToCreate);

        return sejlbådMapper.toSejlbådResponse(createdSejlbåd);
    }

    @Override
    public SejlbådResponse updateSejlbåd(long id, SejlbådRequest putRequest) {

        if (doesExist(id)) {
            Sejlbåd sejlbådToUpdate = sejlbådMapper.toSejlbåd(putRequest);
            sejlbådToUpdate.setId(id);
            System.out.println("UPDATED SEJLBÅD IN SERVICE " + sejlbådToUpdate.getPoints());

            Sejlbåd updatedSejlbåd = sejlbådRepository.save(sejlbådToUpdate);

            return sejlbådMapper.toSejlbådResponse(updatedSejlbåd);

        } else {
            throw new SejlbådNotFound(sejlbådNotFoundExceptionMessage);
        }
    }

    @Override
    public void deleteSejlbåd(long id) {
        boolean doesExist = doesExist(id);
        if (doesExist) {
            sejlbådRepository.deleteById(id);

        } else {
            throw new SejlbådNotFound(sejlbådNotFoundExceptionMessage);
        }
    }

    private boolean doesExist(long id) {
        return sejlbådRepository.existsById(id);
    }
}
