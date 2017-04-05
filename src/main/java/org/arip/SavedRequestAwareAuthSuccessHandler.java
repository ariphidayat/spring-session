package org.arip;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Arip Hidayat on 4/4/2017.
 */
public class SavedRequestAwareAuthSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws ServletException, IOException {
        setDefaultTargetUrl("/hello");

        SecurityContextImpl context = new SecurityContextImpl();

        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>(authentication.getAuthorities());
        User user = (User) authentication.getPrincipal();
        if (user.getUsername().equals("arip")) {
            authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
            setDefaultTargetUrl("/hello/new");
        }

        Authentication authenticationNew = new UsernamePasswordAuthenticationToken(authentication.getPrincipal(),
                UUID.randomUUID(), authorities);
        context.setAuthentication(authenticationNew);

        SecurityContextHolder.setContext(context);

        super.onAuthenticationSuccess(request, response, authenticationNew);
    }
}
