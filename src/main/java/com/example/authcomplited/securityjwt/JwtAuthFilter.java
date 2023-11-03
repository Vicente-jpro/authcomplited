package com.example.authcomplited.securityjwt;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.authcomplited.SpringApplicationContext;
import com.example.authcomplited.models.User;
import com.example.authcomplited.services.UserService;

public class JwtAuthFilter extends OncePerRequestFilter {

	private JwtService jwtService;
	private UserService usuarioService;

	public JwtAuthFilter(JwtService jwtService, UserService usuarioService) {
		this.jwtService = jwtService;
		this.usuarioService = usuarioService;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		String authorizationHeader = request.getHeader("Authorization");

		if (authorizationHeader != null && authorizationHeader.startsWith("Bearer")) {
			String token = authorizationHeader.split(" ")[1];
			boolean isValid = jwtService.tokenValido(token);

			if (isValid) {
				String email = jwtService.obterLoginUsuario(token);
				UserDetails userDetails = usuarioService.loadUserByUsername(email);
				UsernamePasswordAuthenticationToken user = new UsernamePasswordAuthenticationToken(userDetails, null,
						userDetails.getAuthorities());

				user.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(user);

				UserService userService = (UserService) SpringApplicationContext.getBean("userService");
				User userLogado = userService.getUserByEmail(email);
				response.addHeader("UserID", userLogado.getUserId());
			}
		}

		filterChain.doFilter(request, response);
	}

}
