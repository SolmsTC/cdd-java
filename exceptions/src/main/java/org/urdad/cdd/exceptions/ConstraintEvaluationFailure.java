package org.urdad.cdd.exceptions;

/**
 *
 * @author fritz
 */
public class ConstraintEvaluationFailure extends Exception {
    public ConstraintEvaluationFailure(String message, Throwable cause, String constraint)
    {
        super(message, cause);
        this.constraint = constraint;        
    }
    
    private String constraint;
}
