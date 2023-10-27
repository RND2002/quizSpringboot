//package com.quizApp.Quiz_app.security;
//
//import com.quizApp.Quiz_app.model.Roles;
//import com.quizApp.Quiz_app.model.User;
//import com.quizApp.Quiz_app.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//
//import java.util.*;
//
//public class UserDetailServiceImpl implements UserDetailsService {
//
//
//    private UserRepository userRepository;
//
//    public UserDetailServiceImpl(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
//        User user=userRepository.findByUserName(username);
//        if(user==null){
//            throw new UsernameNotFoundException("Not found");
//        }
////        List<GrantedAuthority> authorities = new ArrayList<>();
////        for (Roles role : user.getRoles()) {
////            authorities.add(new SimpleGrantedAuthority(role.getName()));
////        }
////        return new org.springframework.security.core.userdetails.User(user.getUserName(),user.getPassword(), (Collection<? extends GrantedAuthority>) new ArrayList<>(authorities));
////        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
////        grantedAuthorities.add(new SimpleGrantedAuthority("USER"));
////        grantedAuthorities.add(new SimpleGrantedAuthority("ADMIN"));
//        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
//        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_",user.getRole()));
//
//        return new org.springframework.security.core.userdetails.User(
//                user.getEmail(), user.getPassword(), grantedAuthorities);
//    }
//}
