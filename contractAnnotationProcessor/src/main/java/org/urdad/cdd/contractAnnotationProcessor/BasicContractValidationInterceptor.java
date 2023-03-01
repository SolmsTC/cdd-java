package org.urdad.cdd.contractAnnotationProcessor;

import com.google.auto.service.AutoService;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.TypeSpec;
import java.io.IOException;
import javax.annotation.processing.Filer;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.Name;
import javax.lang.model.element.QualifiedNameable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@AutoService(ContractProcessor.class)
public class BasicContractValidationInterceptor implements ContractProcessor
// TODO Move into separate module, add provides decelaration to 
// ContractProcessor in that module-info file a uses declaration 
// also to ContractProcessor in this modules module-info file.
{

  @Override
  public void process(Element contract, Filer filer) 
      throws ContractEncodingException, IOException
  {
    if (contract.getKind() != ElementKind.INTERFACE)
      throw new ContractNotInterface(contract);
    assert contract.getKind() == ElementKind.INTERFACE;
    
    logger.info("HAVE QUALIFIED NAME: " + ((QualifiedNameable)contract).getQualifiedName().toString());
    
    Name nm = ((QualifiedNameable)contract).getQualifiedName();
    
    JavaFile javaFile = JavaFile.builder(
      ((QualifiedNameable)contract).getQualifiedName().toString(),
        this.buildInterceptor(contract)).build();

    javaFile.writeTo(filer); 
  }
  
  private TypeSpec buildInterceptor(Element contract)
  {
    TypeSpec.Builder interceptorBuilder 
      = TypeSpec.classBuilder(contract.getSimpleName().toString()+validatorPostFix)
      .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
      .addSuperinterface(contract.asType())
      .addField(     contract.asType().getClass(), 
          wrappendComponentName, Modifier.PUBLIC);

    this.addConstructors(interceptorBuilder, contract)
        .addInterceptorMethods(interceptorBuilder, contract);
    
    return interceptorBuilder.build();
  }
  
  private BasicContractValidationInterceptor addConstructors(TypeSpec.Builder interceptorBuilder, Element contract)
  {  
    //TODO
    return this;
  }
  
  private BasicContractValidationInterceptor addInterceptorMethods(TypeSpec.Builder interceptorBuilder, Element contract)
  {  
    //TODO
    return this;
  }
  
  private static final Logger logger = LogManager.getLogger(BasicContractValidationInterceptor.class);
  
  private static final String validatorPostFix = "Validator";
  private static final String wrappendComponentName = "component";
}

