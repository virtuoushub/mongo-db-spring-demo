package com.virtusa.spring.demo;

import com.joshlong.model.Account;
import com.joshlong.model.AccountRepository;
import com.joshlong.model.Bookmark;
import com.joshlong.model.BookmarkRepository;
import com.joshlong.rest.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Arrays;

/**
 * See: http://stackoverflow.com/a/23366746
 */
@Configuration
@EnableAutoConfiguration
@EntityScan(basePackageClasses = {Account.class, Bookmark.class})
@EnableJpaRepositories(basePackageClasses = {AccountRepository.class, BookmarkRepository.class})
public class Application {


    @Bean
    CommandLineRunner init(AccountRepository accountRepository, BookmarkRepository bookmarkRepository) {
        return (evt) ->
                Arrays.asList("jhoeller", "dsyer", "pwebb", "ogierke", "rwinch", "mfisher", "mpollack").forEach(a -> {
                    Account account = accountRepository.save(new Account(a, "password"));
                    bookmarkRepository.save(new Bookmark(account, "http://bookmark.com/1/" + a, "A description"));
                    bookmarkRepository.save(new Bookmark(account, "http://bookmark.com/2/" + a, "A description"));
                });
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
