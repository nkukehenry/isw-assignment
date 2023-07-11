package com.nkukehenry.corploans.services;


import com.nkukehenry.corploans.models.CustomUserDetails;
import com.nkukehenry.corploans.models.User;
import com.nkukehenry.corploans.services.contracts.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import  org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class CustomerUserDetailsService implements UserDetailsService {

    @Autowired
    private IUserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userService.getByUserName(username);

        CustomUserDetails userDetails = null;

        if(user != null){
            userDetails = new CustomUserDetails();
            userDetails.setUser(user);
        }
        else
            throw  new UsernameNotFoundException("No user found with username "+ username );

        return userDetails;
    }
}
