package com.task7.leo.utility;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.security.Principal;

@Data
@NoArgsConstructor
public class UserChecker {

    private Principal principal;

    public UserChecker(Principal principal) {
        this.principal = principal;
    }

    public boolean isRole(String role) {
        AbstractAuthenticationToken token = (AbstractAuthenticationToken) principal;

        for (GrantedAuthority auth : token.getAuthorities()) {
            if (auth.getAuthority().equals(role)) return true;
        }

        return false;
    }

    public String getUserName() {
        return principal.getName();
    }
}
