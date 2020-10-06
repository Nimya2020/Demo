package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.Difficulty;
import domain.Region;
import domain.Tour;
import domain.TourPackage;
import repo.TourPackageRepository;
import repo.TourRepository;

@Service
public class TourService {

	 private TourRepository tourRepository;
	    private TourPackageRepository tourPackageRepository;

	    @Autowired
	    public TourService(TourRepository tourRepository, TourPackageRepository tourPackageRepository) {
	        this.tourRepository = tourRepository;
	        this.tourPackageRepository = tourPackageRepository;
	    }
	    
	    public Tour createTour(String title, String description, String blurb, Integer price,
                String duration, String bullets,
                String keywords, String tourPackageName, Difficulty difficulty, Region region ) {
TourPackage tourPackage = tourPackageRepository.findByName(tourPackageName);
if (tourPackage == null) {
 throw new RuntimeException("Tour package does not exist: " + tourPackageName);
}
return tourRepository.save(new Tour(title, description,blurb, price, duration,
     bullets, keywords, tourPackage, difficulty, region));
}

/**
* Calculate the number of Tours in the Database.
*
* @return the total.
*/
public long total() {
return tourRepository.count();
}


}
