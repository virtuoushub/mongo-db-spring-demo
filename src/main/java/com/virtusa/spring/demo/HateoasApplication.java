package com.virtusa.spring.demo;

import com.joshlong.hateoas.BookmarkHateoasController;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by Peter Colapietro on 11/17/2014.
 */
@ComponentScan(basePackageClasses = {BookmarkHateoasController.class})
public final class HateoasApplication extends  Application {
}
