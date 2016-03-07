package br.com.virtz.cfc.servlet.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import com.google.inject.servlet.GuiceFilter;

public class CFCFilter extends GuiceFilter {

	@Override
	public void doFilter(ServletRequest servletRequest,
			ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		 ((HttpServletResponse) servletResponse).addHeader("Access-Control-Allow-Origin", "*");
		super.doFilter(servletRequest, servletResponse, filterChain);
	}
}
