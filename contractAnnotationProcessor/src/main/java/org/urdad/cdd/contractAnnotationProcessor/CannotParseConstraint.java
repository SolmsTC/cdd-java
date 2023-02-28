package org.urdad.cdd.contractAnnotationProcessor;

import javax.lang.model.element.Element;

public class CannotParseConstraint extends ContractEncodingException
{
  public CannotParseConstraint(Element element, String constraint)
  {
    super("The following constraint was not parsable:[" + constraint + "]", element);
  }
}
