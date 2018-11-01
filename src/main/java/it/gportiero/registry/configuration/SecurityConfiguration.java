package it.gportiero.registry.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableAsync
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
        .csrf().disable()
        .headers().frameOptions().disable()
        .and()
        .authorizeRequests()
        	.antMatchers("/css/**").permitAll()
        	.antMatchers("/h2-console/**").permitAll()
        	.anyRequest().authenticated()
        	.and()
        .formLogin()
        	.loginPage("/login")
        	.permitAll()
        	.and()
        .logout()
        	.permitAll();
    }
    
    /**
     * @return returns PasswordEncoder
     */
    @Bean
    public PasswordEncoder passwordEncoder() {

      return new BCryptPasswordEncoder();
    }
}
