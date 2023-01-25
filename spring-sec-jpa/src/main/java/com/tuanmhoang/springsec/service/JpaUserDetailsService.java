package com.tuanmhoang.springsec.service;

import com.tuanmhoang.springsec.model.Authority;
import com.tuanmhoang.springsec.model.User;
import com.tuanmhoang.springsec.repo.AuthorityRepository;
import com.tuanmhoang.springsec.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JpaUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    private final AuthorityRepository authorityRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User foundUser = userRepository
                .findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(">>>> cannot find user"));

        List<Authority> authorities = authorityRepository
                .findAllByUsername(username)
                .get();

        return new JpaUserDetails(foundUser, authorities);
    }
}
