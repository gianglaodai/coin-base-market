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

import leo.prj.petrocoin.bean.dto.DepositHistoryDTO;
import leo.prj.petrocoin.bean.dto.ResponseObject;
import leo.prj.petrocoin.service.DepositHistoryService;

@CrossOrigin
@RestController
@RequestMapping("/depositHistory")
public class DepositHistoryController extends GeneralController {

	@Autowired
	private DepositHistoryService depositHistoryService;

	@PostMapping("/create")
	public ResponseEntity<ResponseObject<Object>> create(@RequestBody DepositHistoryDTO depositHistory) {
		try {
			return ResponseEntity.ok(new ResponseObject<>(this.depositHistoryService.create(depositHistory)));
		} catch (final Exception e) {
			return this.createErrorResponse(e);
		}
	}

	@PutMapping("/update")
	public ResponseEntity<ResponseObject<Object>> update(@RequestBody DepositHistoryDTO depositHistory) {
		try {
			return ResponseEntity.ok(new ResponseObject<>(this.depositHistoryService.update(depositHistory)));
		} catch (final Exception e) {
			return this.createErrorResponse(e);
		}
	}

	@GetMapping("/read")
	public ResponseEntity<ResponseObject<Object>> read(@RequestParam int id) {
		try {
			return ResponseEntity.ok(new ResponseObject<>(this.depositHistoryService.read(id).get()));
		} catch (final Exception e) {
			return this.createErrorResponse(e);
		}
	}

	@DeleteMapping("/delete")
	public ResponseEntity<ResponseObject<Object>> delete(@RequestParam int id) {
		try {
			this.depositHistoryService.delete(id);
			return ResponseEntity.ok(new ResponseObject<>(true));
		} catch (final Exception e) {
			return this.createErrorResponse(e);
		}
	}
}
