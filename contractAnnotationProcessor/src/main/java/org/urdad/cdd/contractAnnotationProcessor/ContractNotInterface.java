package org.urdad.cdd.contractAnnotationProcessor;

import javax.lang.model.element.Element;

public class ContractNotInterface extends ContractEncodingException
{ 
  public ContractNotInterface(Element element)
  {
    super("The @Contract annotation may only be applied to interfaces.", element);
  }
}
