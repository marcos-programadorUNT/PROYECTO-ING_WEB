package com.ingenieriaweb.springboot.web.app.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.ingenieriaweb.springboot.web.app.services.Interface.USUARIO_SERVICE;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
	
	
	@Autowired
    private USUARIO_SERVICE usuarioService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(usuarioService);
        auth.setPasswordEncoder(passwordEncoder());
        return auth;
    }

    @Bean
    protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        //Exmaple - 1
        http.authorizeRequests()
                .antMatchers(
                        "/registrar**",
                        "/assets/**",
                        "/cliente/**").permitAll()
                
              //.antMatchers("/admin/**").hasAuthority("ADMIN")
              //.antMatchers("/cliente/**").hasAuthority("CLIENTE")
              //.anyRequest().permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login?logout")
                .permitAll();
        http.authenticationProvider(authenticationProvider());
        return http.build();
    }

}
