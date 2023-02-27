package org.urdad.cdd.contract;

/**
 * This is the base class for any exception to be associated with a precondition, 
 * ie. any exception used to communicate that a service is not being provided
 * due to a precondition specified in a contract not having been met. The reason 
 * for introducing this exception class is to prevent contract specifiers to be
 * able to associate a RuntimeException with a precondition, i.e. to enforce that 
 * all PreconditionViolation exceptions are checked exceptions which must be 
 * declared in the throws clause for the service which has that precondition.
 * <p>
 * Note that for all PreconditionViolation exceptions and its specializations 
 * <code>enableSupression</code> is set to <code>false</code>.
 *
 * @author fritz at solmstc.com
 */
public class PreconditionViolation extends Exception
{
  /**
   * Creates a PreConditionViolation exception.
   * <p>
   * This constructor calls {@link PreconditionViolation(String, Throwable, boolean)}
   * with 
   * <ul>
   *   <li>no <code>message</code>,
   *   <li><code>cause</code> set to <code>null</code> and 
   *   <li><code>writableStackTrace</code> set to <code>true</code>
   * </ul>
   * @see PreconditionViolation(String, Throwable, boolean)
   */

  public PreconditionViolation() {
    this(null, null, true);
  }
  /**
   * Creates a PreConditionViolation exception with the specified message.
   * <p>
   * This constructor calls {@link PreconditionViolation(String, Throwable, boolean)}
   * with 
   * <ul>
   *   <li><code>cause</code> set to <code>null</code> and 
   *   <li><code>writableStackTrace</code> set to <code>true</code>
   * </ul>
   * @see PreconditionViolation(String, Throwable, boolean)
   */
  public PreconditionViolation(String message) {
    this(message, null, true);
  }

  /**
   * Creates a PreConditionViolation exception with the specified message and the
   * exception raised by a lower-level service provider which <code>cause</code>d 
   * this exception.
   * <p>
   * This constructor calls {@link PreconditionViolation(String, Throwable, boolean)}
   * with <code>writableStackTrace</code> set to <code>true</code>
   * @see PreconditionViolation(String, Throwable, boolean)
   */
  public PreconditionViolation(String message, Throwable cause) {
    this(message, cause, true);
  }

  /** 
   * Creates a checked PreconditionViolation exception.
   * 
   * @param message the human readable message explaining the reason why the service 
   * was not provided. It could simply state that the precondition with which this
   * exception is associated is violated, providing the relevant <code>PreCondition</code>
   * name.
   * @param cause If the exception is caused by a lower level service provider 
   * having raised an exception, the method may catch that exception and raise
   * the relevant PreConditionViolation exception specified in its contract 
   * providing the exception raised by the lower-level service provider as 
   * <code>cause</code>.
   * @param writableStackTrace whether or not the stack trace should be writable
   */
  public PreconditionViolation(String message, Throwable cause, boolean writableStackTrace) {
    super(message, cause, false, writableStackTrace);
  }
}
