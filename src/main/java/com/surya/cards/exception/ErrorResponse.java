package com.surya.cards.exception;

import java.time.LocalDateTime;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponse {

	public ErrorResponse(String message, List<String> details) {
		super();
		this.message = message;
		this.details = details;
		this.timestamp = LocalDateTime.now();
	}

	// General error message about nature of error
	private String message;

	// Specific errors in API request processing
	private List<String> details;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private LocalDateTime timestamp;

}