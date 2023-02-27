package org.urdad.cdd.exceptions;

import org.urdad.cdd.contract.Invariant;

/**
 * This exception is used to communicate that aspects of the system state
 * violate an invariance constraint.
 *
 * @author {fritz at solmstc.com, justus.posthuma at gmail.com}
 */
public class InvariantViolated extends ContractViolation {
  public InvariantViolated(
            String message, 
            Invariant invariant) 
    {
        super(message, invariant);
    }
  
    /**
     * 
     * @return the violated Invariant which caused the contract violation
     */
    public Invariant getInvariant() { return (Invariant)getViolatedConstraint(); }
    
}
