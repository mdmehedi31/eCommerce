package com.ecommerce.config.Security;

import com.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
@ComponentScan(basePackages = {"com.ecommerce.config", "com.ecommerce.service"})
public class SecurityConfig {


    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserService userService;

    @Autowired
    private AuthSuccessHandler authSuccessHandler;

    @Autowired
    public void configure(AuthenticationManagerBuilder aut) throws Exception{

       aut.userDetailsService(userService).passwordEncoder(passwordEncoder);


  /*aut.inMemoryAuthentication().
                withUser("bablu").
                password("{noop}12345").
                roles("ADMIN");
        aut.inMemoryAuthentication().withUser("bablu1").password("{noop}123456").roles("USER");
*/
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

         http
              /*  .headers().frameOptions().sameOrigin()
                .and()*/
                .csrf().disable()
                .authorizeHttpRequests()
                .antMatchers("/images/**",
                        "/css/**","/js/**").permitAll()
                //.antMatchers("/").permitAll()
                .antMatchers("/auth/**").permitAll()

                .and()
                .authorizeHttpRequests()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/user/**").hasAnyRole("ADMIN","USER")
                .anyRequest().authenticated()

                .and()

                .formLogin()
                .loginPage("/auth/login")
                .permitAll()
                .usernameParameter("email")
                .passwordParameter("password")
                 .loginProcessingUrl("/login-processing")
                .successHandler(authSuccessHandler)
                .failureUrl("/auth/login?error=true")

                .and()

                .logout()
                .logoutUrl("/auth/logout")
                .logoutSuccessUrl("/auth/login").permitAll()

                .and()
                .exceptionHandling().accessDeniedPage("/auth/403");

           return http.build();
/*
  http.
                authorizeHttpRequests((authz)->authz
                        .anyRequest()
                        .authenticated()
                )
                .httpBasic(withDefaults());
*

        return http.build();

         .formLogin(form->form
                        .loginPage("/auth/login")
                        .permitAll()
                        .usernameParameter("username")
                        .passwordParameter("password")
                        .loginProcessingUrl("/login-processing")
                        .successHandler(successHandler)
                        .permitAll()
                )
                        .logout(logout->logout
                                .logoutUrl("/auth/logout")
                                .logoutSuccessUrl("/auth/login?logout")
                                .permitAll()
                            )

        */


    }


}
