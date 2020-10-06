package repo;

import org.springframework.data.repository.CrudRepository;

import domain.Tour;

public interface TourRepository extends CrudRepository<Tour, Integer> {

}
