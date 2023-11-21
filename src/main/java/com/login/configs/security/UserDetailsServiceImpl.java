package com.login.configs.security;

import com.login.entity.UserEntity;
import com.login.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

  private final UserRepository userRepository;
  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    UserEntity userEntity = userRepository.findByUserName(username)
        .orElseThrow(() ->
            new UsernameNotFoundException("User not found: " + username));

    return new User(
        userEntity.getUsername(),
        userEntity.getPassword(),
        true,
        true,
        true,
        true,
        userEntity.getAuthorities()
    );
  };
}
