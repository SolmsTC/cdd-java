package org.urdad.cdd.exceptions;

import org.urdad.cdd.contract.Precondition;

/**
 * An exception raised to communicate that a postcondition was not met when
 * a service provider provided a service.
 *
 * @author {fritz at solmstc.com, justus.posthuma at gmail.com}
 */
public class PostconditionNotMet extends ContractViolation 
{  
    /**
     * Creates an instance of PostconditionNotMet exception
     * 
     * @param message a message which may provide some additional information to 
     *        the precondition being violated.
     * @param violatedPostcondition The precondition which caused the contract violation
     */
    PostconditionNotMet(String message, Precondition violatedPostcondition)
    {
        super(message, violatedPostcondition);
    }
    
    /**
     * 
     * @return the Precondition which was violated 
     */
    Precondition getViolatedPrecondition()
    {
      return (Precondition)super.getViolatedConstraint();
    }
}
