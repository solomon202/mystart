package com.example.solit.config;

import com.example.solit.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

//включить безопасность спринг секюрите если не включить адаптер небудет наследоватся
@EnableWebSecurity(debug = true)
@Profile("dao")
//наследуемся от одаптара безопасности вызывая методы для переопределения для настройки безопасности
//куда есть доступ куда нет доступа куда нужно вбивать пороль пользователь все настройки безопасности происходят в этом класе 
public class DaoSecurityConfig extends WebSecurityConfigurerAdapter {
    private Logger logger = LoggerFactory.getLogger(DaoSecurityConfig.class.getName());
    private UserService userService;

    @Autowired
    public void setUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        logger.info("Dao Authentication Provider");
      //имеют доступ все 
        http.authorizeRequests()
        //уровни защищености фильтры 
        //если пользователь переходт по этой ссылке то тоько пускать индефецированых
                .antMatchers("/authenticated/**").authenticated()
                .antMatchers("/dao").authenticated()
              //суда пускать только того у кого есть роль
                //роли допуска кого можно пускать юзер имеет роли 
                .antMatchers("/admin/**").hasAnyRole("ADMIN", "SUPERADMIN") // ROLE_ADMIN, ROLE_SUPERADMIN
                .anyRequest().permitAll()
                .and()
              //индификация через форму или указать на свою форму 
                .formLogin();
    }
//преобразователь паролей
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        authenticationProvider.setUserDetailsService(userService);
        return authenticationProvider;
    }
}
