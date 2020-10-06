package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.TourPackage;
import repo.TourPackageRepository;

@Service

public class TourPackageService {
	
	private TourPackageRepository tourPackageRepository;

    @Autowired
    public TourPackageService(TourPackageRepository tourPackageRepository) {
        this.tourPackageRepository = tourPackageRepository;
    }

    public TourPackage createTourPackage(String code, String name) {
        if (tourPackageRepository.existsById(code)) {
            return tourPackageRepository.save(new TourPackage(code, name));
        } else {
            return null;
        }
    }
    public Iterable<TourPackage> lookup(){
        return tourPackageRepository.findAll();
    }
    public long total() {
        return tourPackageRepository.count();
    }

}
