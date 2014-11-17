package com.virtusa.spring.demo;

import com.joshlong.rest.BookmarkRestController;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by Peter Colapietro on 11/17/2014.
 */
@ComponentScan(basePackageClasses = {BookmarkRestController.class})
public final class RestApplication extends Application {
}
