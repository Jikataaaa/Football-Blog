package springadvanced.exam.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import springadvanced.exam.model.enums.UserRoles;

@Configuration
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;

    public ApplicationSecurityConfig(@Qualifier("projectUserDetailsServiceImpl") UserDetailsService userDetailsService, PasswordEncoder passwordEncoder) {
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.
                authorizeRequests().
                // with this line we allow access to all static resources
                        requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll().
                // the next line allows access to the home page, login page and registration for everyone
                        antMatchers("/", "/user/login", "/user/register").permitAll().
                //, "/player-add", "/post-add", "/posts-all"
                antMatchers("/statistics").hasRole(UserRoles.ADMIN.name()).

                // next we forbid all other pages for unauthenticated users.
                        antMatchers("/**").authenticated().
                and().
                // configure login with login HTML form with two input fileds
                        formLogin().
                // our login page is located at http://<serveraddress>>:<port>/users/login
                        loginPage("/user/login").
                // this is the name of the <input..> in the login form where the user enters her email/username/etc
                // the value of this input will be presented to our User details service
                // those that want to name the input field differently, e.g. email may change the value below
                        usernameParameter(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_USERNAME_KEY).
                // the name of the <input...> HTML filed that keeps the password
                        passwordParameter(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_PASSWORD_KEY).
                // The place where we should land in case that the login is successful
                        defaultSuccessUrl("/").
                // the place where I should land if the login is NOT successful
                        failureUrl("/users/login-error").
                and().
                logout().
                // This is the URL which spring will implement for me and will log the user out.
                        logoutUrl("/user/logout").
                // where to go after the logout.
                        logoutSuccessUrl("/").
                // remove the session from server
                        invalidateHttpSession(true).
                //delete the cookie that references my session
                        deleteCookies("JSESSIONID");

     }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.
                userDetailsService(userDetailsService).
                passwordEncoder(passwordEncoder);
    }
}
