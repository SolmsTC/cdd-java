package org.urdad.cdd.contract;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * This annotation is used to specify a constraint for a service which, if 
 * not met upon service should result in the service being refused and
 * an associated exception being raised.
 * 
 * The constraint must be specified as a predicate clause in the 
 * Java-Based Constraint Language (JBCL) as specified in {@link org.urdad.cdd.contract}
 * 
 * @author {fritz at solmstc.com, justus.posthuma at gmail.com}
*/
@Target(ElementType.METHOD)
@Repeatable(Preconditions.class)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface Precondition {
  /**
   * A name which is typically used by humans to identify the Precondition.
   */
  String name();

  /**
   * A <i>JBCL</i> based constraint expression specifying the predicate which
   * must hold (see {@link org.urdad.cdd.contract org.urdad} package description)
   * for the specification of the <i>Java Based Constraint Language, JBCL</i>)
   */
  String constraint();
  
  /**
   * The PreconditionViolation exception which is top be raised if the service
   * provider refuses to provide the service due to this Precondition not being met.
   * <p>
   * Contracts exceptions are required to subclass PreConditionViolation in order
   * to enforce that only check exceptions are associated with pre-conditions.
   */
  Class<? extends PreconditionViolation> raises();

  /**
   * an optional expanded natural-language based description of the constraint.
   */
  String description() default "";
}
