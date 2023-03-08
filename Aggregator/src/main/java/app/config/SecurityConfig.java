//package app.config;
//
//import app.service.UserService;
//import app.token.JwtCsrfFilter;
//import app.token.JwtTokenRepository;
//import org.jetbrains.annotations.NotNull;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.csrf.CsrfFilter;
//import org.springframework.web.servlet.HandlerExceptionResolver;
//import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    private UserService userService;
//
//    @Autowired
//    private JwtTokenRepository jwtTokenRepository;
//
//    private final HandlerExceptionResolver handlerExceptionResolver;
//
//    public SecurityConfig() {
//        this.handlerExceptionResolver = new ExceptionHandlerExceptionResolver();
//    }
//
//    @Override
//    public void configure(@NotNull HttpSecurity http) throws Exception {
//        http
//                .sessionManagement()
//                    .sessionCreationPolicy(SessionCreationPolicy.NEVER)
//                .and()
//                    .addFilterAt(new JwtCsrfFilter(jwtTokenRepository, handlerExceptionResolver), CsrfFilter.class)
//                    .csrf().ignoringAntMatchers("/**")
//                .and()
//                    .authorizeRequests()
//                    .antMatchers("/user/login")
//                    .authenticated()
//                .and()
//                    .httpBasic()
//                    .authenticationEntryPoint((((request, response, authException) ->
//                            handlerExceptionResolver.resolveException(request, response, null, authException))));
//    }
//
//    @Override
//    protected void configure(@NotNull AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(this.userService);
//    }
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return NoOpPasswordEncoder.getInstance();
//    }
//}
