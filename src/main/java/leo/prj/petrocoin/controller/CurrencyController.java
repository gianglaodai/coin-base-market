package leo.prj.petrocoin.controller;

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

import leo.prj.petrocoin.bean.dto.CurrencyDTO;
import leo.prj.petrocoin.bean.dto.ResponseObject;
import leo.prj.petrocoin.service.CurrencyService;

@CrossOrigin
@RestController
@RequestMapping("/currency")
public class CurrencyController extends GeneralController {

	@Autowired
	private CurrencyService currencyService;

	@GetMapping("/all")
	public ResponseEntity<ResponseObject<Object>> getAll() {
		try {
			return ResponseEntity.ok(new ResponseObject<>(this.currencyService.getAll()));
		} catch (final Exception e) {
			return this.createErrorResponse(e);
		}
	}

	@PostMapping("/create")
	public ResponseEntity<ResponseObject<Object>> create(@RequestBody CurrencyDTO currency) {
		try {
			return ResponseEntity.ok(new ResponseObject<>(this.currencyService.create(currency)));
		} catch (final Exception e) {
			return this.createErrorResponse(e);
		}
	}

	@PutMapping("/update")
	public ResponseEntity<ResponseObject<Object>> update(@RequestBody CurrencyDTO currency) {
		try {
			return ResponseEntity.ok(new ResponseObject<>(this.currencyService.update(currency)));
		} catch (final Exception e) {
			return this.createErrorResponse(e);
		}
	}

	@GetMapping("/read")
	public ResponseEntity<ResponseObject<Object>> read(@RequestParam long id) {
		try {
			return ResponseEntity.ok(new ResponseObject<>(this.currencyService.read(id).get()));
		} catch (final Exception e) {
			return this.createErrorResponse(e);
		}
	}

	@DeleteMapping("/delete")
	public ResponseEntity<ResponseObject<Object>> delete(@RequestParam long id) {
		try {
			this.currencyService.delete(id);
			return ResponseEntity.ok(new ResponseObject<>(true));
		} catch (final Exception e) {
			return this.createErrorResponse(e);
		}
	}
}
