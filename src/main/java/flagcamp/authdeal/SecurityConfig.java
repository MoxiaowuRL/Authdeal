package flagcamp.authdeal;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  private DataSource dataSource;

  @Override
  // FYI: https://zhuanlan.zhihu.com/p/92077616
  protected void configure(HttpSecurity http) throws Exception {
    http.csrf().disable()
        .formLogin()
        .and()
        .authorizeRequests();
//          .antMatchers(HttpMethod.GET, "/**").hasAnyAuthority("Client", "Admin");

    http
        .authorizeRequests()
          .antMatchers("/users*/**").hasAnyAuthority("Client", "Admin")
          .antMatchers("/order/**").hasAnyAuthority("Client", "Admin")
//          .antMatchers("/item*/**").hasAnyAuthority("Client", "Admin")
          .antMatchers("/messages/**").hasAnyAuthority("Client", "Admin")
          .anyRequest().permitAll();
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.inMemoryAuthentication()
        .withUser("admin")
        .password("admin")
        .authorities("Admin").and().passwordEncoder(passwordEncoder());

    auth
        .jdbcAuthentication()
        .dataSource(dataSource)
        .usersByUsernameQuery("SELECT user_name, password, enabled FROM users WHERE user_name=?")
        .authoritiesByUsernameQuery("SELECT user_name, role FROM users WHERE user_name=?")
        .passwordEncoder(passwordEncoder());
  }

  @SuppressWarnings("deprecation")
  @Bean
  public static NoOpPasswordEncoder passwordEncoder() {
    return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
  }
}
