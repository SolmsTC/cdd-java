package org.urdAad.cdd.basicContractValidationInterceptor;

import javax.annotation.processing.Filer;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.QualifiedNameable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.urdad.cdd.contractAnnotationProcessor.ContractEncodingException;
import org.urdad.cdd.contractAnnotationProcessor.ContractNotInterface;
import org.urdad.cdd.contractAnnotationProcessor.ContractProcessor;

public class BasicContractValidationInterceptor implements ContractProcessor
{

  @Override
  public void process(Element contract, Filer filer) throws ContractEncodingException
  {
    //JavaFileObject interceptorDile 
    //  = filer.createSourceFile(fullyQualifiedName, element);
       
    if (contract.getKind() != ElementKind.INTERFACE)
      throw new ContractNotInterface(contract);
    assert contract.getKind() == ElementKind.INTERFACE;
    
    logger.info("HAVE QUALIFIED NAME:: " + ((QualifiedNameable)contract).getQualifiedName());
    
//    TypeSpec contractValidator = TypeSpec.classBuilder(contract.)
//    .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
//    .addMethod(main)
//    .build();
//    contract.
  }
  private static final Logger logger = LogManager.getLogger(BasicContractValidationInterceptor.class);

}

