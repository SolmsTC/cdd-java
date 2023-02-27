package org.urdad.cdd.examples.simpleExample;

import org.urdad.cdd.contract.Contract;
import org.urdad.cdd.contract.Postcondition;
import org.urdad.cdd.contract.Precondition;
import org.urdad.cdd.contract.PreconditionViolation;

/**
 *
 * @author fritz
 */
@Contract
public interface TestProvider {
  
  @Precondition(name = "postitive k", constraint = "k > 0", raises =  PreconditionViolation.class)
  @Postcondition(name = "correct returnValue", constraint = "returnValue = 2*k")
  public int f(int k);
  
  public static class NonPositiveInput extends PreconditionViolation{}
}
