package leo.prj.petrocoin.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import leo.prj.petrocoin.bean.dto.ResponseObject;

public abstract class GeneralController {
	protected ResponseEntity<ResponseObject<Object>> createErrorResponse(Exception e) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseObject<>(e.getMessage(), e));
	}
}
