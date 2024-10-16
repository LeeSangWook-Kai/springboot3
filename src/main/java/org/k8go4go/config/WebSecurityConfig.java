package org.k8go4go.config;

import jakarta.servlet.DispatcherType;
import lombok.RequiredArgsConstructor;
import org.k8go4go.serice.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@RequiredArgsConstructor
@Configuration
public class WebSecurityConfig {
    private final UserService userService;
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((au)->
            au.dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
                    .requestMatchers("/login", "/signup", "user").permitAll()
                    .anyRequest().authenticated()
        )
                .formLogin((form)->
                        form.loginPage("login")
                                .defaultSuccessUrl("/articles")
                                .usernameParameter("email")
                                .passwordParameter("password")
                )
                .logout((out)->
                        out.logoutSuccessUrl("/login")
                        )
                .csrf((csrf)->csrf.disable())
        ;
        return http.build();
    }
}
