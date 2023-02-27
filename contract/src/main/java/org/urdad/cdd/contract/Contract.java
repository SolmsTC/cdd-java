package org.urdad.cdd.contract;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * An annotation which is to be applied to interfaces which are annotated as
 * component contracts.
 *
 * @author {fritz at solmstc.com, justus.posthuma at gmail.com}
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Contract 
{
  /**
   * 
   * @return whether interceptors may be generated for this contract.
   */
  boolean allowInterceptors() default true;
}
