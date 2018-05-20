package leo.prj.petrocoin.controller;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import leo.prj.petrocoin.bean.dto.ResponseObject;

public abstract class GeneralController {
	private static final Logger logger = Logger.getLogger(GeneralController.class);

	protected ResponseEntity<ResponseObject<Object>> createErrorResponse(Exception e) {
		logger.error(e.getMessage(), e);
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseObject<>(e.getMessage(), e));
	}

}
