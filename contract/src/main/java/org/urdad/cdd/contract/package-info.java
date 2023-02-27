/**
 * This package specifies the annotations as well as the concept of a 
 * PreConditionViolation exception used to annotate a Java interface
 * to a component contract.
 * 
 * Each contract constraint annotations either a {@link Precondition}, 
 * {@link Postcondition} or an {@link Invariance} and contains a parameter 
 * <code>constraint</code> which is a predicate specifying the constraint 
 * in the <i>Java-Based Constraint Language (JBCL)</i>.
 * <p>
 * A <i>JBCL</i> encoded constraint is a simple Java based expression for which the 
 * following hold:
 * <ul>
 *   <li> it must evaluate to a <code>boolean</code>.
 *   <li> <code>this</code> represents an external reference to the instance 
 *        of the component whose service request is being intercepted. 
 *        It is an instance of some class which realizes the contract 
 *        (and implements the interface). 
 *        The <code>this</code> reference only provides access to the component
 *        via the public interface.</li>
 *   <li> for constraints applied to services you have direct access to the
 *        service parameters by referring to them using the parameter name
 *        specified in the interface. Note that the implementing class whose 
 *        services is intercepted may use a different name for that same parameter.</li>
 *   <li> In a PostCondition you may use an <i>pre-evaluation</i>, i.e. an evaluation
 *        of some aspect of the accessible state at the instant when the service
 *        was requested. For example, for an account a post-condition of
 *        the debit service may be that the balance after the service has been 
 *        provided is equal to the account balance at the point of service request
 *        minus the debit amount. A <i>pre-evaluation</i> in <i>JBCL</i> is a Java clause
 *        enclosed in double forward slashes. For example, one could specify
 *        for a PostCondition named <code>balance adjusted
 *        constraint="this.getBalance() = //this.getBalance()// - amount", Note 
 *        that <i>pre-evaluations</i> are the equivalent to the <code>@pre</code>
 *        clauses available in the <i>Object COnstraint Language</i>.
 * </ul>
 */
package org.urdad.cdd.contract;
