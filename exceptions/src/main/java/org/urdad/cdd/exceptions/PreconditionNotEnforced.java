package org.urdad.cdd.exceptions;

import java.lang.annotation.Annotation;

import org.urdad.cdd.contract.Precondition;
/**
 *
 * @author {fritz at solmstc.com, justus.posthuma at gmail.com}
 */
public class PreconditionNotEnforced extends ContractViolation {
    public PreconditionNotEnforced(
            String message, 
            Annotation  violatedConstraint) 
    {
        super(message, violatedConstraint);
    }
    
    /**
     * 
     * @return the Precondition which was not enforced causing the contract violation
     */
    public Precondition getViolatedPrecondition() 
    {
      return (Precondition)super.getViolatedConstraint();
    }
}
