package com.raisetech.springsecuritysample;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(final AuthenticationManagerBuilder authBuilder) throws Exception {
        authBuilder.inMemoryAuthentication()
                .withUser("koyama").password(passwordEncoder().encode("password_koyama")).roles("USER")
                .and()
                .withUser("yamada").password(passwordEncoder().encode("password_yamada")).roles("USER")
                .and()
                .withUser("tanaka").password(passwordEncoder().encode("password_tanaka")).roles("ADMIN");
    }

    @Override
    protected void configure(final HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeRequests()
                .antMatchers("/login").permitAll()
                .anyRequest().authenticated();
        httpSecurity
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/perform_login")
                .failureUrl("/login?error")
                .usernameParameter("username")
                .passwordParameter("password")
                .defaultSuccessUrl("/hello", true);
        httpSecurity.csrf().disable();

    }
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
