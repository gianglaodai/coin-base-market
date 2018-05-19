package leo.prj.petrocoin.controller;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import leo.prj.petrocoin.bean.dto.PetroTransactionDTO;
import leo.prj.petrocoin.bean.dto.ResponseObject;
import leo.prj.petrocoin.service.PetroTransactionService;

@CrossOrigin
@RestController
@RequestMapping("/petroTransaction")
public class PetroTransactionController extends GeneralController {

	@Autowired
	private PetroTransactionService petroTransactionService;

	@PostMapping("/create")
	public ResponseEntity<ResponseObject<Object>> create(@RequestBody PetroTransactionDTO petroTransaction) {
		try {
			return ResponseEntity
					.ok(new ResponseObject<>(this.petroTransactionService.create(petroTransaction)));
		} catch (final Exception e) {
			return this.createErrorResponse(e);
		}
	}

	@PutMapping("/update")
	public ResponseEntity<ResponseObject<Object>> update(@RequestBody PetroTransactionDTO petroTransaction) {
		try {
			return ResponseEntity
					.ok(new ResponseObject<>(this.petroTransactionService.update(petroTransaction)));
		} catch (final Exception e) {
			return this.createErrorResponse(e);
		}
	}

	@GetMapping("/read")
	public ResponseEntity<ResponseObject<Object>> read(@RequestParam BigInteger id) {
		try {
			return ResponseEntity.ok(new ResponseObject<>(this.petroTransactionService.read(id).get()));
		} catch (final Exception e) {
			return this.createErrorResponse(e);
		}
	}

	@DeleteMapping("/delete")
	public ResponseEntity<ResponseObject<Object>> delete(@RequestParam BigInteger id) {
		try {
			this.petroTransactionService.delete(id);
			return ResponseEntity.ok(new ResponseObject<>(true));
		} catch (final Exception e) {
			return this.createErrorResponse(e);
		}
	}
}
