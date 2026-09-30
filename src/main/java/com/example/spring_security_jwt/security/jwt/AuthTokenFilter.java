package com.example.spring_security_jwt.security.jwt;

import java.io.IOException;

import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.spring_security_jwt.security.service.UserDetailsServiceImpl;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class AuthTokenFilter extends OncePerRequestFilter {

	private final JwtUtils jwtUtils;
	
	private final UserDetailsServiceImpl userDetailsServiceImpl;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		try {
			String jwt = parseJwt(request);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private String parseJwt(HttpServletRequest request) {
		
		String headerAuth = request.getHeader("Authorization");
		
		if (StringUtils.hasText(headerAuth) && headerAuth.startsWith("Bearer: ")) {
			return headerAuth.substring(7);
		}
		
		
		
		return null;
	}

}
