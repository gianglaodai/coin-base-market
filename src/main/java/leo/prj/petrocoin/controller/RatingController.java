package leo.prj.petrocoin.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import leo.prj.petrocoin.bean.dto.RatingDTO;
import leo.prj.petrocoin.bean.dto.ResponseObject;
import leo.prj.petrocoin.service.RatingService;

@RestController
@RequestMapping("/rating")
public class RatingController extends GeneralController {

	@Autowired
	private RatingService ratingService;

	@PostMapping("/create")
	public ResponseEntity<ResponseObject<Object>> create(@RequestBody RatingDTO rating) {
		try {
			return ResponseEntity.ok(new ResponseObject<>(this.ratingService.create(rating)));
		} catch (final Exception e) {
			return this.createErrorResponse(e);
		}
	}

	@PutMapping("/update")
	public ResponseEntity<ResponseObject<Object>> update(@RequestBody RatingDTO rating) {
		try {
			return ResponseEntity.ok(new ResponseObject<>(this.ratingService.update(rating)));
		} catch (final Exception e) {
			return this.createErrorResponse(e);
		}
	}

	@GetMapping("/read")
	public ResponseEntity<ResponseObject<Object>> read(@RequestParam long id) {
		try {
			return ResponseEntity.ok(new ResponseObject<>(this.ratingService.read(id).get()));
		} catch (final Exception e) {
			return this.createErrorResponse(e);
		}
	}

	@DeleteMapping("/delete")
	public ResponseEntity<ResponseObject<Object>> delete(@RequestParam long id) {
		try {
			this.ratingService.delete(id);
			return ResponseEntity.ok(new ResponseObject<>(true));
		} catch (final Exception e) {
			return this.createErrorResponse(e);
		}
	}
	
	@GetMapping("/rating/createdDate")
	public ResponseEntity<ResponseObject<Object>> getRatingByCreatedDate(@RequestParam long createdDate){
		try {
			return ResponseEntity.ok(new ResponseObject<>(this.ratingService.getRatingByCreatedDate(createdDate)));
		} catch (final Exception e) {
			return this.createErrorResponse(e);
		}
	}
}
