package com.nem.docms.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Qualifier("myUserDetailsService")
	@Autowired
	private UserDetailsService userDetailsService;

	@Bean
	public AuthenticationProvider authProvider() {
		System.out.println("authProvider--AppSecurityConfig");
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService);
		provider.setPasswordEncoder(new BCryptPasswordEncoder());
		return provider;
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.antMatcher("/resources/**")
				.csrf().disable()
				.authorizeRequests().antMatchers("/login").permitAll()
				.antMatchers("/main").hasAnyAuthority("ADMIN","USER")
				.antMatchers("/project/allProjects").hasAuthority("ADMIN")
				.anyRequest().authenticated()
				.and()
				.exceptionHandling().accessDeniedPage("/login")
				.and()
				.formLogin()
				.loginPage("/login").permitAll()
				.and()
				.logout().invalidateHttpSession(true)
				//clear all the data when logout
				.clearAuthentication(true)
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.logoutSuccessUrl("/login").permitAll();
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