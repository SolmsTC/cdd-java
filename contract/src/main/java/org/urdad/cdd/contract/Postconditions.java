package org.urdad.cdd.contract;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * A collection class facilitating that multiple {@link Postcondition} constraints may be specified
 * against the same method
 *
 * @author {fritz at solmstc.com, justus.posthuma at gmail.com}
 * 
 * @see Postcondition
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Postconditions {
    
    Postcondition[] value();
}
