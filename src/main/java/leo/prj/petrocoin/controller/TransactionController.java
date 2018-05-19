package leo.prj.petrocoin.controller;

import java.math.BigInteger;

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

import leo.prj.petrocoin.bean.dto.ResponseObject;
import leo.prj.petrocoin.bean.dto.TransactionDTO;
import leo.prj.petrocoin.service.TransactionService;

@RestController
@RequestMapping("/transaction")
public class TransactionController extends GeneralController {

	@Autowired
	private TransactionService transactionService;

	@PostMapping("/create")
	public ResponseEntity<ResponseObject<Object>> create(@RequestBody TransactionDTO transaction) {
		try {
			return ResponseEntity.ok(new ResponseObject<>(this.transactionService.create(transaction)));
		} catch (final Exception e) {
			return this.createErrorResponse(e);
		}
	}

	@PutMapping("/update")
	public ResponseEntity<ResponseObject<Object>> update(@RequestBody TransactionDTO transaction) {
		try {
			return ResponseEntity.ok(new ResponseObject<>(this.transactionService.update(transaction)));
		} catch (final Exception e) {
			return this.createErrorResponse(e);
		}
	}

	@GetMapping("/read")
	public ResponseEntity<ResponseObject<Object>> read(@RequestParam BigInteger id) {
		try {
			return ResponseEntity.ok(new ResponseObject<>(this.transactionService.read(id).get()));
		} catch (final Exception e) {
			return this.createErrorResponse(e);
		}
	}

	@DeleteMapping("/delete")
	public ResponseEntity<ResponseObject<Object>> delete(@RequestParam BigInteger id) {
		try {
			this.transactionService.delete(id);
			return ResponseEntity.ok(new ResponseObject<>(true));
		} catch (final Exception e) {
			return this.createErrorResponse(e);
		}
	}
	
	@GetMapping("/available")
	public ResponseEntity<ResponseObject<Object>> getAvailableTransactions(@RequestParam long userId){
		try {
			return ResponseEntity.ok(new ResponseObject<>(this.transactionService.getAvailableTransaction(userId)));
		} catch (final Exception e) {
			return this.createErrorResponse(e);
		}
	}
	
	@GetMapping("/byUser")
	public ResponseEntity<ResponseObject<Object>> getTransactionsOfUser(@RequestParam long userId){
		try {
			return ResponseEntity.ok(new ResponseObject<>(this.transactionService.getTransactionsOfUser(userId)));
		} catch (final Exception e) {
			return this.createErrorResponse(e);
		}
	}
}
