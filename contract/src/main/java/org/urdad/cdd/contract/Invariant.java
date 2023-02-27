package org.urdad.cdd.contract;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * The Invariance annotation is used to specify a constraint which must
 * hold in any observable state of the system. It constraints the state of the 
 * component and/or its environment.
 * <p>
 * The constraint itself is a simple Java based predicate specified using the 
 * <i>Java Based Constraint Language (JBL)</i> whose usage is specified in the 
 * {@link org.urdad.cdd.contract contract} package description.
 *
 * @author {fritz at solmstc.com, justus.posthuma at gmail.com}
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Repeatable(Invariants.class)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface Invariant
{
  /**
   * A name which is typically used by humans to identify the Invariance constraint.
   */
  String name();

  /**
   * A <i>JBCL</i> based constraint expression specifying the predicate which
   * must hold (see {@link org.urdad.cdd.contract constraint} package description)
   * for the specification of the <i>Java Based Constraint Language, JBCL</i>)
   */
  String constraint();

  /**
   * an optional expanded natural-language based description of the constraint.
   */
  String description() default "";
  
}
