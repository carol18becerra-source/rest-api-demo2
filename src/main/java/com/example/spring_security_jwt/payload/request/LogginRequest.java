package com.example.spring_security_jwt.payload.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class LogginRequest {

	@NotBlank
	private String username;
	@NotBlank
	private String password;
}
