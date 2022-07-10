package vilvay.blog.service.blog.vilvay;

import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class AppSecurityConfiguration {

    protected SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.httpBasic(Customizer.withDefaults());
        return httpSecurity.build();
    }
}
