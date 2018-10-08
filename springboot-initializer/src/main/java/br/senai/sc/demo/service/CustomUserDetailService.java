package br.senai.sc.demo.service;

import br.senai.sc.demo.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CustomUserDetailService implements UserDetailsService {
    private final UserRepository userRepository;

    public CustomUserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }
//
//    @Autowired
//    public CustomUserDetailService(UserRepository userRepository){
//        this.userRepository = userRepository;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
//        Optional.ofNullable(userRepository.findByUsername(username)).orElseThrow(()-> new UsernameNotFoundException("User not found"));
//        AuthorityUtils.createAuthorityList("ROLE_ADMIN");
//    }

}
