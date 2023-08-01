package kr.jinseok.eatgo;

import kr.jinseok.eatgo.controller.filters.JwtAuthenticationFilter;
import kr.jinseok.eatgo.util.JwtUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

import javax.servlet.Filter;

@Configuration
@EnableWebSecurity
public class SecurityJavaConfig extends WebSecurityConfigurerAdapter {
    @Value("${jwt.secret}")
    private String secret;

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        Filter filter = new JwtAuthenticationFilter(authenticationManager(),jwtUtil());
        httpSecurity
                .cors().disable()
                .csrf().disable()
                .formLogin().disable()
                .headers().frameOptions().disable()
                .and()
                .addFilter(filter)
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }
    @Bean
    public JwtUtil jwtUtil(){
        return  new JwtUtil(secret);
    }
}
