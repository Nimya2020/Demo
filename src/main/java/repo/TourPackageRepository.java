package repo;

import org.springframework.data.repository.CrudRepository;

import domain.TourPackage;

public interface TourPackageRepository extends CrudRepository<TourPackage, String> {

	TourPackage findByName(String name);

}
