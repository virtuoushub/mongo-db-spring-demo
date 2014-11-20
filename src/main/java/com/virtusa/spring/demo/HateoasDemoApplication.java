package com.virtusa.spring.demo;

import com.joshlong.hateoas.BookmarkHateoasController;
import com.joshlong.model.Account;
import com.joshlong.model.AccountRepository;
import com.joshlong.model.Bookmark;
import com.joshlong.model.BookmarkRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.Arrays;

/**
 * Created by Peter Colapietro on 11/17/2014.
 */
@ComponentScan(basePackageClasses = {BookmarkHateoasController.class})
public final class HateoasDemoApplication extends AbstractDemoApplication {

    @Bean
    @Override
    CommandLineRunner init(AccountRepository accountRepository, BookmarkRepository bookmarkRepository) {
        return (evt) ->
                Arrays.asList("jhoeller,dsyer,pwebb,ogierke,rwinch,mfisher,mpollack,jlong".split(","))
                        .forEach(a -> {
                            Account account = accountRepository.save(new Account(a, "password"));
                            bookmarkRepository.save(new Bookmark(account, "http://bookmark.com/1/" + a, "A description"));
                            bookmarkRepository.save(new Bookmark(account, "http://bookmark.com/2/" + a, "A description"));
                        });
    }

    public static void main(String[] args) {
        SpringApplication.run(HateoasDemoApplication.class, args);
    }
}
