package leo.prj.petrocoin.controller;

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
import leo.prj.petrocoin.bean.dto.UserDTO;
import leo.prj.petrocoin.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController extends GeneralController {

	@Autowired
	private UserService userService;

	@PostMapping("/create")
	public ResponseEntity<ResponseObject<Object>> create(@RequestBody UserDTO user) {
		try {
			return ResponseEntity.ok(new ResponseObject<>(this.userService.create(user)));
		} catch (final Exception e) {
			return this.createErrorResponse(e);
		}
	}

	@PutMapping("/update")
	public ResponseEntity<ResponseObject<Object>> update(@RequestBody UserDTO user) {
		try {
			return ResponseEntity.ok(new ResponseObject<>(this.userService.update(user)));
		} catch (final Exception e) {
			return this.createErrorResponse(e);
		}
	}

	@GetMapping("/read")
	public ResponseEntity<ResponseObject<Object>> read(@RequestParam long id) {
		try {
			return ResponseEntity.ok(new ResponseObject<>(this.userService.read(id).get()));
		} catch (final Exception e) {
			return this.createErrorResponse(e);
		}
	}

	@DeleteMapping("/delete")
	public ResponseEntity<ResponseObject<Object>> delete(@RequestParam long id) {
		try {
			this.userService.delete(id);
			return ResponseEntity.ok(new ResponseObject<>(true));
		} catch (final Exception e) {
			return this.createErrorResponse(e);
		}
	}
}
