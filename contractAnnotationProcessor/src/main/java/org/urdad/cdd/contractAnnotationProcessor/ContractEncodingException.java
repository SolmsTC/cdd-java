package org.urdad.cdd.contractAnnotationProcessor;

import javax.lang.model.element.Element;

public class ContractEncodingException extends Exception
{
  
  public ContractEncodingException(String message, Element element)
  {
    super(message);
    this.element = element;
  }

  public Element getElement()
  {
    return element;
  }
  private final Element element;
  
}
