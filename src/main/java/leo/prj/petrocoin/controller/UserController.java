package leo.prj.petrocoin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import leo.prj.petrocoin.bean.backobject.ResponseObject;
import leo.prj.petrocoin.bean.backobject.User;
import leo.prj.petrocoin.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/create")
	public ResponseEntity<ResponseObject<Object>> create(User user) {
		try {
			return ResponseEntity.ok(new ResponseObject<>(this.userService.create(user)));
		} catch (final Exception e) {
			return this.createErrorResponse(e);
		}
	}

	@PutMapping("/update")
	public ResponseEntity<ResponseObject<Object>> update(User user) {
		try {
			return ResponseEntity.ok(new ResponseObject<>(this.userService.update(user)));
		} catch (Exception e) {
			return this.createErrorResponse(e);
		}
	}

	@GetMapping("/read")
	public ResponseEntity<ResponseObject<Object>> read(long id) {
		try {
			return ResponseEntity.ok(new ResponseObject<>(this.userService.read(id).get()));
		} catch (Exception e) {
			return this.createErrorResponse(e);
		}
	}

	@DeleteMapping("/delete")
	public ResponseEntity<ResponseObject<Object>> delete(long id) {
		try {
			this.userService.delete(id);
			return ResponseEntity.ok(new ResponseObject<>(true));
		} catch (Exception e) {
			return this.createErrorResponse(e);
		}
	}

	private ResponseEntity<ResponseObject<Object>> createErrorResponse(Exception e) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseObject<>(e.getMessage(), e));
	}
}
