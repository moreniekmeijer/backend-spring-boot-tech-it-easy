package nl.moreniekmeijer.backendspringboottechiteasycontroller.services;

import nl.moreniekmeijer.backendspringboottechiteasycontroller.dtos.UserDto;
import nl.moreniekmeijer.backendspringboottechiteasycontroller.models.Authority;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CustomUserDetailsService implements UserDetailsService {

    public UserService userService;

    public CustomUserDetailsService(UserService userService) {}

    @Override
    public UserDetails loadUserByUsername(String username) {
        UserDto userDto = userService.getUser(username);

        String password = userDto.getPassword();

        Set<Authority> authorities = userDto.getAuthorities();
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        for (Authority authority : authorities) {
            grantedAuthorities.add(new SimpleGrantedAuthority(authority.getAuthority()));
        }

        return new org.springframework.security.core.userdetails.User(username, password, grantedAuthorities);
    }
}
