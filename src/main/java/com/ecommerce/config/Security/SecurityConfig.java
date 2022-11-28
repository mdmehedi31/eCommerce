package com.ecommerce.config.Security;

import com.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
@ComponentScan(basePackages = {"com.ecommerce.config", "com.ecommerce.service"})
public class SecurityConfig {


    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserService userService;



    @Autowired
    public void configure(AuthenticationManagerBuilder aut) throws Exception{

        aut.userDetailsService(userService).passwordEncoder(passwordEncoder);


 /* aut.inMemoryAuthentication().
                withUser("bablu").
                password("{noop}12345").
                roles("ADMIN");
        aut.inMemoryAuthentication().withUser("bablu1").password("{noop}123456").roles("USER");*/

    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        return http
                .headers().frameOptions().sameOrigin()
                .and()
                /*.csrf().disable()*/
                .authorizeRequests()
                .antMatchers("/images/**",
                        "/css/**","/js/**").permitAll()
             //   .antMatchers("/").permitAll()
               // .antMatchers("/auth/**").permitAll()

                .and()
                .authorizeRequests()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/user/**").hasAnyRole("ADMIN","USER")
                .anyRequest().authenticated()

                .and()
                .formLogin(form->form
                        .loginPage("/auth/login")
                        .permitAll()
                        .usernameParameter("username")
                        .passwordParameter("password")
                        .loginProcessingUrl("/auth/login-processing")
                        .defaultSuccessUrl("/")
                        .permitAll()
                )
                        .logout(logout->logout
                                .logoutUrl("/auth/logout")
                                .logoutSuccessUrl("/auth/login?logout")
                                .permitAll()
                            )
                .build();
/*
  http.
                authorizeHttpRequests((authz)->authz
                        .anyRequest()
                        .authenticated()
                )
                .httpBasic(withDefaults());
*

        return http.build();
        */


    }
}
