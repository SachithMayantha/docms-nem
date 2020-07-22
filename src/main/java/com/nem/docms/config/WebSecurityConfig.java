package com.nem.docms.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//    @Qualifier("userDetailsServiceImpl")
//    @Autowired
//    private UserDetailsService userDetailsService;
//
//    @Bean
//    public BCryptPasswordEncoder bCryptPasswordEncoder() {
//        return new BCryptPasswordEncoder();
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.antMatcher("/resources/**")
//			.authorizeRequests()
//			.anyRequest().authenticated()
//			.and().httpBasic()
//		    .and().sessionManagement().disable()
//            .formLogin()
//                .loginPage("/login")
////                .usernameParameter("user")
////                .passwordParameter("123")
////                .loginProcessingUrl("/logining")
////                .defaultSuccessUrl("/main", true)
////                .failureUrl("/login")
////                .successHandler(new AuthenticationSuccessHandler() {
////					
////					@Override
////					public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
////							Authentication authentication) throws IOException, ServletException {
////						String username = authentication.getName();
////						System.out.println("Logged user "+username);
////						response.sendRedirect("/main");
////					}
////				})
////                .failureHandler(new AuthenticationFailureHandler() {
////					
////					@Override
////					public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
////							AuthenticationException exception) throws IOException, ServletException {
////						System.out.println("Failure Login");
////						response.sendRedirect("/login");
////						
////					}
////				})
//                .and()
//            .logout()
//            .permitAll();
////        	.logoutUrl("/login")
        ;
    }
    
    @Override
	public void configure(WebSecurity web) throws Exception {
	    web.ignoring().antMatchers("/resources/**");
	}

//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//            .inMemoryAuthentication()
//                .withUser("user").password("123").roles("USER");
//    }
}