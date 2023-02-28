package org.urdad.cdd.contractAnnotationProcessor;

import javax.annotation.processing.Filer;
import javax.lang.model.element.Element;

public interface ContractProcessor
{
  public void process(Element contract, Filer filer) throws ContractEncodingException;
}
