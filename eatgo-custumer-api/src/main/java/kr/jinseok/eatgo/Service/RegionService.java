package kr.jinseok.eatgo.Service;

import kr.jinseok.eatgo.domain.Region;
import kr.jinseok.eatgo.domain.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class  RegionService {
    @Autowired
    private RegionRepository regionRepository;
    public List<Region> getRegions(){

        List<Region> regions = regionRepository.findAll();
        return regions;
    }


}
