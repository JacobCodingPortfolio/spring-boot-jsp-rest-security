package com.application.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;

import javax.sql.DataSource;


//Konfiguracja Web Security
@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource securityDataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(securityDataSource); //Spring read from database user info
    }

    /*

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        // add users for authentication

        //To pozwala na logowanie się poświadczeniami bez hashowania
        User.UserBuilder users = User.withDefaultPasswordEncoder();

        //Dodawanie użytkowników
        auth.inMemoryAuthentication()
                .withUser(users.username("jakub").password("test123").roles("EMPLOYEE"))
                .withUser(users.username("jan").password("test123").roles("EMPLOYEE", "MANAGER"))
                .withUser(users.username("jola").password("test123").roles("EMPLOYEE", "ADMIN"))
                .withUser(users.username("full").password("test123").roles("EMPLOYEE", "ADMIN", "MANAGER"));

    }

    */


    @Override //Configuracja ścieżek, formy lgowania, procesu wylogowania itd...
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests() //Wszystkie pytanie przychodzące do serwera przechodzą przez ten filtr
            //.anyRequest().authenticated()  //Wszystkie zapytania do serwera wymagają uwierzytelnienia, deklarujemy jakie zapytanie wymaga uwierzytelnienia, dostęp definiujemy po specyficznych rolach
            .antMatchers("/").hasRole("EMPLOYEE")
            .antMatchers("/leaders/**").hasRole("MANAGER")
            .antMatchers("/systems/**").hasRole("ADMIN")
            .antMatchers("/showdata/**").hasRole("EMPLOYEE")
            .and()
                .formLogin()
                .loginPage("/showLoginPage") //życie innego login form <-- tu musimy robić controller
                .loginProcessingUrl("/authenticateTheUser") //Aby login form działał musi zrobić post data do tej ścieżki
                //do ścieżki pozwyżej nie musimy robić controllera
                .permitAll() //Zezwalamy wszystkim do zobaczenia login page
            .and()
                .exceptionHandling() //Obsługa wyjatków
                .accessDeniedPage("/access-denied") //Gdy nie mamy uprawnień do danej ściezki
            .and()
                .logout()
                .permitAll(); //Wylogowywanie przy pomocy ścieżki "/logout"

    }


}
