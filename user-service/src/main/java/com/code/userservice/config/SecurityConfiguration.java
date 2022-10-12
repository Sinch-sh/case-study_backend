package com.code.userservice.config;


import com.code.userservice.security.CustomUserDetailsService;
import com.code.userservice.security.JwtFilterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Autowired
    private  CustomUserDetailsService customUserDetailsService;
    @Autowired
    private JwtFilterRequest jwtFilterRequest;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(customUserDetailsService);
    }

    @Bean
    public  PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();

    }

    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/subs","/auth").permitAll().
                anyRequest().authenticated().and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.addFilterBefore(jwtFilterRequest, UsernamePasswordAuthenticationFilter.class);


//        http.authorizeRequests().antMatchers(HttpMethod.POST).hasAnyRole("Admin")
//                .antMatchers(HttpMethod.PUT).hasAnyRole("Admin")
//                .antMatchers(HttpMethod.DELETE).hasAnyRole("Admin")
//                .antMatchers(HttpMethod.GET,"/user/findAllUser").hasAnyRole("Admin","Doctor");

        http.cors().disable();
        http.csrf().disable();
     ///   super.configure(http);
    }
}
