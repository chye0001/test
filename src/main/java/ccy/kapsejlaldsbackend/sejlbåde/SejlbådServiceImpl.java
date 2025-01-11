package ccy.kapsejlaldsbackend.sejlbåde;

import ccy.kapsejlaldsbackend.sejlbåde.dto.SejlbådMapper;
import ccy.kapsejlaldsbackend.sejlbåde.dto.SejlbådRequest;
import ccy.kapsejlaldsbackend.sejlbåde.dto.SejlbådResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SejlbådServiceImpl implements SejlbådService {

    private final SejlbådRepository sejlbRepository;
    private final SejlbådMapper sejlbådMapper;


    @Override
    public List<SejlbådResponse> getAllSejlbåd() {
        return sejlbRepository.findAll().stream()
                .map(sejlbåd -> sejlbådMapper.toSejlbådResponse(sejlbåd))
                .toList();
    }

    @Override
    public SejlbådResponse getSejlbådById(Long id) {
        Sejlbåd sejlbåd = sejlbRepository.findById(id).orElse(null);
        return sejlbådMapper.toSejlbådResponse(sejlbåd);
    }

    @Override
    public SejlbådResponse createSejlbåd(SejlbådRequest postRequest) {
        Sejlbåd sejlbådToCreate = sejlbådMapper.toSejlbåd(postRequest);
        Sejlbåd createdSejlbåd = sejlbRepository.save(sejlbådToCreate);

        return sejlbådMapper.toSejlbådResponse(createdSejlbåd);
    }

    @Override
    public SejlbådResponse updateSejlbåd(SejlbådRequest putRequest) {
        Sejlbåd sejlbådToUpdate = sejlbådMapper.toSejlbåd(putRequest);
        Sejlbåd updatedSejlbåd = sejlbRepository.save(sejlbådToUpdate);

        return sejlbådMapper.toSejlbådResponse(updatedSejlbåd);
    }

    @Override
    public void deleteSejlbåd(long id) {
        sejlbRepository.deleteById(id);
    }

    @Override
    public boolean doesExist(long id) {
        return sejlbRepository.existsById(id);
    }
}
