package hepl.sysdist.labo.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.ArrayList;

@Configuration
@EnableWebSecurity
public class FormLoginSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/command/*").authenticated()
                .antMatchers("/user").authenticated()
                .anyRequest().permitAll()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .logoutSuccessUrl("/shop")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .deleteCookies("user_id")
                .permitAll();
    }

    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        ArrayList<UserDetails> users = new ArrayList<>();
        users.add(User
                .withDefaultPasswordEncoder()
                .username("loic")
                .password("password")
                .roles("USER")
                .build());

        users.add(User
                .withDefaultPasswordEncoder()
                .username("samuel")
                .password("password")
                .roles("USER")
                .build());

        users.add(User
                .withDefaultPasswordEncoder()
                .username("kevin")
                .password("password")
                .roles("USER")
                .build());

        return new InMemoryUserDetailsManager(users);
    }
}
