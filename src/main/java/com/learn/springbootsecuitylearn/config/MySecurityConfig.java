package com.learn.springbootsecuitylearn.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

import com.learn.springbootsecuitylearn.services.CustomUserDetailService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MySecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private CustomUserDetailService customUserDetailService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
       http
       		.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
       		.and()
            .authorizeRequests()
            .antMatchers("/public/**").hasRole("NORMAL")
            .antMatchers("/users/**").hasRole("ADMIN")
            .antMatchers("/signin").permitAll()
            .anyRequest()
            .authenticated()
            .and()
//            .httpBasic()
            .formLogin()
            .loginPage("/signin")
            .loginProcessingUrl("/doLogin")
            .defaultSuccessUrl("/users/");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication().withUser("manish").password(this.passwordEncoder().encode("1234")).roles("NORMAL");
//        auth.inMemoryAuthentication().withUser("admin").password(this.passwordEncoder().encode("1234")).roles("ADMIN");
    	  auth.userDetailsService(customUserDetailService).passwordEncoder(passwordEncoder());
    }
    
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        // return NoOpPasswordEncoder.getInstance();
        return new BCryptPasswordEncoder(10);
    }
}
