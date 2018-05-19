package leo.prj.petrocoin.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import leo.prj.petrocoin.bean.dto.RatingDTO;
import leo.prj.petrocoin.db.petro_coin.petro_coin.rating.Rating;
import leo.prj.petrocoin.db.petro_coin.petro_coin.rating.RatingManager;
import leo.prj.petrocoin.service.converter.RatingConverter;

@Service
public class RatingService {
	@Autowired
	private RatingConverter ratingConverter;

	@Autowired
	private RatingManager ratings;

	public RatingDTO create(RatingDTO rating) {
		return this.ratingConverter
				.createRating(this.ratings.persist(this.ratingConverter.createDatabaseRating(rating)));
	}

	public RatingDTO update(RatingDTO rating) {
		return this.ratingConverter
				.createRating(this.ratings.persist(this.ratingConverter.createUpdateDatabaseRating(rating)));
	}

	public Optional<RatingDTO> read(long id) {
		final Optional<Rating> foundRating = this.ratings.stream().filter(Rating.ID.equal(id)).findFirst();
		if (foundRating.isPresent()) {
			return Optional.of(this.ratingConverter.createRating(foundRating.get()));
		}
		return Optional.empty();
	}

	public void delete(long id) {
		this.ratings.stream().filter(Rating.ID.equal(id)).forEach(this.ratings.remover());
	}

	public List<RatingDTO> getRatingByCreatedDate(long createdDate) {
		return this.ratings.stream().filter(Rating.CREATED_DATE.equal(new Timestamp(createdDate)))
				.map(rating -> this.ratingConverter.createRating(rating)).collect(Collectors.toList());
	}
}
