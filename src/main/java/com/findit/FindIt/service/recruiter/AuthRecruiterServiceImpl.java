package com.findit.FindIt.service.recruiter;

import com.findit.FindIt.dto.JwtResponse;
import com.findit.FindIt.dto.RecruiterLoginDTO;
import com.findit.FindIt.exception.BadAuthCredentialsException;
import com.findit.FindIt.jwt.JwtToken;
import com.findit.FindIt.jwt.JwtTokenDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthRecruiterServiceImpl implements AuthRecruiterService{

    private final JwtToken jwtToken;
    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;

    @Override
    public ResponseEntity<JwtTokenDto> createAuth(RecruiterLoginDTO loginDto) {

        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword()));
        } catch(BadCredentialsException e){
            throw new BadAuthCredentialsException("Bad login or password");
//            return ResponseEntity.ok(new JwtResponse(loginDto.getUsername()));
        }
        JwtTokenDto jwtTokenDto = new JwtTokenDto();

        String token = jwtToken.generateToken(userDetailsService.loadUserByUsername(loginDto.getUsername()));
        jwtTokenDto.setToken(token);
        return ResponseEntity.ok().header(HttpHeaders.AUTHORIZATION, "Bearer " + token).body(jwtTokenDto);
//        return ResponseEntity.ok(new JwtResponse(loginDto.getUsername()+loginDto.getPassword()));
    }
}
