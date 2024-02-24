package com.s19d2.securityapps.service;

import com.s19d2.securityapps.dao.MemberRepository;
import com.s19d2.securityapps.dao.RoleRepository;
import com.s19d2.securityapps.entity.Member;
import com.s19d2.securityapps.entity.Role;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class AuthenticationService {

    private MemberRepository memberRepository;

    private PasswordEncoder passwordEncoder;
    private RoleRepository roleRepository;

    public Member register(String email , String password){
        Optional<Member> memberOptional = memberRepository.findByEmail(email);

        if (memberOptional.isPresent()){
            throw new RuntimeException("User already exists" + email);
        }

        String encodedPassword = passwordEncoder.encode(password);
        List<Role> roleList = new ArrayList<>();

        Optional<Role> roleUser = roleRepository.findByAuthority("USER");
        if (!roleUser.isPresent()){
            Role roleUserEntity = new Role();
            roleUserEntity.setAuthority("USER");
            roleList.add(roleRepository.save(roleUserEntity));
        }


        Optional<Role> roleAdmin = roleRepository.findByAuthority("ADMIN");
        if (!roleAdmin.isPresent()){
            Role roleAdminEntity = new Role();
            roleAdminEntity.setAuthority("ADMIN");
            roleList.add(roleRepository.save(roleAdminEntity));
        }

        Member member = new Member();
        member.setEmail(email);
        member.setPassword(encodedPassword);
        member.setRoles(roleList);

        return memberRepository.save(member);

    }
}
