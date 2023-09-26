package co.istad.sm.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final PasswordEncoder encoder;

    //  Define in-memory user
    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        InMemoryUserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();
        UserDetails user = User.builder()
                .username("user")
                .password(encoder.encode("1219"))
                .roles("USER")
                .build();
        userDetailsManager.createUser(user);
        return userDetailsManager;
    }

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

//      Disable CSRF protection by method reference
        http.csrf(AbstractHttpConfigurer::disable);

//      Security mechanism
        http.httpBasic(Customizer.withDefaults());

//      Allowed to make cross-origin requests
        http.cors(cors -> cors.configure(http));

//      Configure authorization for HTTP request from the client
        http.authorizeHttpRequests(request -> {
//
            request.requestMatchers("/**").hasRole("USER");
        });

//      Configure Session Auth to stateless By default is stateful
        http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        return http.build();

    }
}
