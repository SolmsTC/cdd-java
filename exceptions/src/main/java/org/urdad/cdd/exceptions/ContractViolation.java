package org.urdad.cdd.exceptions;

import java.lang.annotation.Annotation;

/**
 * This exception is introduced to cumulatively catch any exceptions used to
 * notify the user or tester of a contract violation, i.e. of a scenario where
 * a service was either not provided where it had to be provided or was provided 
 * in a way where the contractual obligation were not met (e.g. a post-condition
 * was not met).
 * 
 * @author fritz@solmstc.com
 */
public abstract class ContractViolation extends Exception {
    
    /**
     *
     * @param message the error message communicating the problem to human consumers
     * @param violatedConstraint the constraint (Precondition, Postcondition, Invariance)
     * which was violated
     */
    public ContractViolation(
            String message, 
            Annotation violatedConstraint)
    {
        super(message);    
    }
    
    /**
     * 
     * @return the contract annotation representing the constraint which was violated.
     */
    public Annotation getViolatedConstraint() { return violatedConstraint; }

    
    public String toString() 
    {
      return super.toString() + violatedConstraint.toString();
    }
    
    private Annotation violatedConstraint;
}
