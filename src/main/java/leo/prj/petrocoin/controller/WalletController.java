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

import leo.prj.petrocoin.bean.dto.ResponseObject;
import leo.prj.petrocoin.bean.dto.WalletDTO;
import leo.prj.petrocoin.service.WalletService;

@CrossOrigin
@RestController
@RequestMapping("/wallet")
public class WalletController extends GeneralController {

	@Autowired
	private WalletService walletService;

	@GetMapping("/all")
	public ResponseEntity<ResponseObject<Object>> getAll() {
		try {
			return ResponseEntity.ok(new ResponseObject<>(this.walletService.getAll()));
		} catch (final Exception e) {
			return this.createErrorResponse(e);
		}
	}

	@PostMapping("/create")
	public ResponseEntity<ResponseObject<Object>> create(@RequestBody WalletDTO wallet) {
		try {
			return ResponseEntity.ok(new ResponseObject<>(this.walletService.create(wallet)));
		} catch (final Exception e) {
			return this.createErrorResponse(e);
		}
	}

	@PutMapping("/update")
	public ResponseEntity<ResponseObject<Object>> update(@RequestBody WalletDTO wallet) {
		try {
			return ResponseEntity.ok(new ResponseObject<>(this.walletService.update(wallet)));
		} catch (final Exception e) {
			return this.createErrorResponse(e);
		}
	}

	@GetMapping("/read")
	public ResponseEntity<ResponseObject<Object>> read(@RequestParam long id) {
		try {
			return ResponseEntity.ok(new ResponseObject<>(this.walletService.read(id).get()));
		} catch (final Exception e) {
			return this.createErrorResponse(e);
		}
	}

	@DeleteMapping("/delete")
	public ResponseEntity<ResponseObject<Object>> delete(@RequestParam long id) {
		try {
			this.walletService.delete(id);
			return ResponseEntity.ok(new ResponseObject<>(true));
		} catch (final Exception e) {
			return this.createErrorResponse(e);
		}
	}

	@GetMapping("/userId")
	public ResponseEntity<ResponseObject<Object>> getWalletByUserId(@RequestParam long userId) {
		try {
			return ResponseEntity.ok(new ResponseObject<>(this.walletService.getByUserId(userId)));
		} catch (final Exception e) {
			return this.createErrorResponse(e);
		}
	}
}
