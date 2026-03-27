package com.houses.inmobiliary.web.Config;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.houses.inmobiliary.persistence.crud.UserCRUD;

@Service
public class UserDetailService implements UserDetailsService {

    private final UserCRUD userCRUD;

    public UserDetailService(UserCRUD userCRUD) {
        this.userCRUD = userCRUD;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      var user = userCRUD.findById(username).orElseThrow(()-> new UsernameNotFoundException("Username not found"));
      String[] roles = user.getRoles().stream().toArray(String[]::new);

      System.out.println(user.getPassword());

      return User.builder().username(user.getUsername())
                            .password(user.getPassword())
                            .authorities(roles)
                            .disabled(user.isDisabled())
                            .build();
    }

    
    
}
