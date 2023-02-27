# cdd-java
This project aims to make Contract-Driven Development efficient and easy, simplifying the process and reducing the overheads for developing tests. In particuler, the project has the following aims:
<ol>
  <li>To make it really easy and efficient to specify component contracts by annotating interfaces methods with pre-conditions, post-conditions and invariance constraints using a Java like syntax. </li>
  <li>To be able to generate test interceptors which can be used 
    <ul> 
      <li>for unit testing</li>
    </ul>
</ol>    
  
<h2>A simple example</h2>
<b>TODO</b>

<h2>User's guide</h2>
<b>TODO</b>
<h3>Upgrading interfaces to component contracts</h3>
<h4>The <i>Java Based Constrint Language (JBCL)</h4>
Each contract constraint annotations either a <code>Precondition</code>, a <code>Postcondition</code> or an <code>Invariance</code> and contains a parameter <code>constraint</code> which is a predicate specifying the constraint in the <i>Java-Based Constraint Language (JBCL)</i>.
  
A <i>JBCL</i> encoded constraint is a simple Java based expression for which the following hold:
 <ul>
   <li> it must evaluate to a <code>boolean</code>.
   <li> <code>this</code> represents an external reference to the instance of the component whose service request is being intercepted. It is an instance of some class which realizes the contract (and implements the interface). The <code>this</code> reference only provides access to the component via the public interface.</li>
   <li> for constraints applied to services you have direct access to the service parameters by referring to them using the parameter name specified in the interface. Note that the implementing class whose services is intercepted may use a different name for that same parameter.</li>
   <li> In a PostCondition you may use an <i>pre-evaluation</i>, i.e. an evaluation of some aspect of the accessible state at the instant when the service was requested. For example, for an account a post-condition of the debit service may be that the balance after the service has been provided is equal to the account balance at the point of service request minus the debit amount. A <i>pre-evaluation</i> in <i>JBCL</i> is a Java clause enclosed in double forward slashes. For example, one could specify for the contract of an <code>Account</code> a <code>PostCondition</code> on the <code>debit</code> method as follows
<code>
public interface Acount
{
  @PostCondition(name="balanceAdjusted" constraint="this.getBalance() = //this.getBalance()// - amount")
  public Transaction debit(double amount);
  ...
}
</code>
 Note that the pre-evaluations are equivalent to the <code>@pre</code> clauses available in the <i>Object Constraint Language (OCL)</i>.


The project provides 
  - contract annotations 
  - contract validating interceptors used in contract-driven development (CDD) for unit testing, integration testing, operational testing and service-provider oversight.
