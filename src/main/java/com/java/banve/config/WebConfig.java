package com.java.banve.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

@Configuration
@EnableWebSecurity
public class WebConfig extends WebSecurityConfigurerAdapter {


    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler(
//                "/webjars/**",
//                "/img/**",
//                "/css/**",
//                "/js/**")
//                .addResourceLocations(
//                        "classpath:/META-INF/resources/webjars/",
//                        "classpath:/static/img/",
//                        "classpath:/static/css/",
//                        "classpath:/static/js/");
//    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests()

                .antMatchers("/dang-nhap", "/dang-ky", "/mat-khau").permitAll()
                .antMatchers("/index").hasAnyAuthority("USER", "EMPLOYEE", "ADMIN")
                .antMatchers("/employee").hasAnyAuthority("EMPLOYEE", "ADMIN")
                .antMatchers("/admin").hasAnyAuthority("ADMIN")
                .anyRequest().authenticated();
        http.authorizeRequests().and().formLogin()
                .loginProcessingUrl("/j_spring_security_check")
                .loginPage("/dang-nhap")
                .defaultSuccessUrl("/index")
                .failureUrl("/dang-nhap?error=true")
                .usernameParameter("username")
                .passwordParameter("password")
                .and().logout().logoutUrl("/logout").logoutSuccessUrl("/dang-nhap");
        http.authorizeRequests().and()
                .rememberMe().tokenRepository(this.persistentTokenRepository())
                .tokenValiditySeconds(1 * 24 * 60 * 60);

    }
    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        InMemoryTokenRepositoryImpl memoryTokenRepository = new InMemoryTokenRepositoryImpl();
        return  memoryTokenRepository;
    }
}
