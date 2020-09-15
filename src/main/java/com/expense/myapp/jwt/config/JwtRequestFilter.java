/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.expense.myapp.jwt.config;

/**
 *
 * @author Lenovo
 */
import com.expense.myapp.features.users.UserModel;
import com.expense.myapp.features.users.UserService;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import io.jsonwebtoken.ExpiredJwtException;
@Component
public class JwtRequestFilter extends OncePerRequestFilter {
    
    @Autowired
    private JwtUserDetailsService jwtUserDetailsService;
    
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    
    @Autowired
    private UserService userService;
    
    UserModel user;
    
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
    throws ServletException, IOException {
        
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        response.setHeader("Access-Control-Allow-Credentials", "true");
        
        if( !request.getRequestURI().equals("/authenticate") && !request.getRequestURI().equals("/register") ){
            final String requestTokenHeader = request.getHeader("Authorization");
            String username = null;
            String jwtToken = null;
//            System.out.println(request.getRequestURI());
            // JWT Token is in the form "Bearer token". Remove Bearer word and get
            // only the Token
            if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")  ) { //&& (request.getRequestURI()!="/authenticate" || 
                jwtToken = requestTokenHeader.substring(7);
                try {
                    username = jwtTokenUtil.getUsernameFromToken(jwtToken);
                    user = userService.findByUsername(username);
                } catch (IllegalArgumentException e) {
                    System.out.println("Unable to get JWT Token");
                } catch (ExpiredJwtException e) {
                    System.out.println("JWT Token has expired");
                }
            } else {
                logger.warn("JWT Token does not begin with Bearer String");
            }
            // Once we get the token validate it.
            if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = this.jwtUserDetailsService.loadUserByUsername(username);
            // if token is valid configure Spring Security to manually set
            // authentication
                if (jwtTokenUtil.validateToken(jwtToken, userDetails)) {
                    UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities());
                        usernamePasswordAuthenticationToken
                        .setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                        request.setAttribute("user", user);
                        // After setting the Authentication in the context, we specify
                        // that the current user is authenticated. So it passes the
                        // Spring Security Configurations successfully.
                        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
                }
            }
            chain.doFilter(request, response);
        }
        else{
            chain.doFilter(request, response);
        }
    }
    
}
