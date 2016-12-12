package ua.lvivl.libary.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import ua.lvivl.libary.constants.UserConstants;

/**
 * Created by lembergIP on 24.10.2016.
 */
@ComponentScan(basePackages = "ua.lvivl.libary.service")
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    @Qualifier(UserConstants.Model.USER_DETAILS_SERVICE)
    private UserDetailsService userDetailsService;

    @Autowired
    public void registerGlobalAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(getBCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()
                .authorizeRequests()
                .antMatchers("/resources/**").permitAll()
                .antMatchers("/").permitAll()
                .antMatchers(HttpMethod.GET, "/adm-**").hasRole(UserConstants.Role.ROLE_ADMINISTRATOR)
                .antMatchers(HttpMethod.POST, "/adm-**").hasRole(UserConstants.Role.ROLE_ADMINISTRATOR)
                .antMatchers(HttpMethod.GET, "/registration").anonymous()
                .antMatchers(HttpMethod.GET, "/usersList").hasRole(UserConstants.Role.ROLE_ADMINISTRATOR)
                .antMatchers(HttpMethod.GET, "/allBooks").permitAll()
                .antMatchers("/error").permitAll()
                .and()
                .exceptionHandling()
                .accessDeniedPage("/accessDenied")
                .and()


                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/j_spring_security_check")
                .failureUrl("/login?error=true")
                .usernameParameter("j_username")
                .passwordParameter("j_password")
                .defaultSuccessUrl("/home")
                .permitAll()
                .and()

                .logout()
                .permitAll()
                .logoutUrl("/j_spring_security_logout")
                .logoutSuccessUrl("/login");


    }

    @Bean
    public PasswordEncoder getBCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
