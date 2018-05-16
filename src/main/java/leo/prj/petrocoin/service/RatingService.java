package leo.prj.petrocoin.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import leo.prj.petrocoin.bean.backobject.Rating;
import leo.prj.petrocoin.db.petro_coin.petro_coin.rating.RatingManager;
import leo.prj.petrocoin.service.converter.RatingConverter;

@Service
public class RatingService {
	@Autowired
	private RatingConverter ratingConverter;

	@Autowired
	private RatingManager ratings;

	public Rating create(Rating rating) {
		return ratingConverter.createRating(ratings.persist(ratingConverter.createDatabaseRating(rating)));
	}

	public Rating update(Rating rating) {
		return ratingConverter.createRating(ratings.persist(ratingConverter.createUpdateDatabaseRating(rating)));
	}

	public Optional<Rating> read(long id) {
		Optional<leo.prj.petrocoin.db.petro_coin.petro_coin.rating.Rating> foundRating = this.ratings.stream()
				.filter(leo.prj.petrocoin.db.petro_coin.petro_coin.rating.Rating.ID.equal(id)).findFirst();
		if (foundRating.isPresent()) {
			return Optional.of(ratingConverter.createRating(foundRating.get()));
		}
		return Optional.empty();
	}

	public void delete(long id) {
		this.ratings.stream().filter(leo.prj.petrocoin.db.petro_coin.petro_coin.rating.Rating.ID.equal(id))
				.forEach(ratings.remover());
	}
}
