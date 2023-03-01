package org.urdad.cdd.contractAnnotationProcessor;

import javax.annotation.processing.*;
import javax.lang.model.element.TypeElement;

import javax.lang.model.SourceVersion;

import java.util.Set;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;

import javax.tools.Diagnostic;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.auto.service.AutoService;
import java.io.IOException;
import java.util.HashSet;
import java.util.ServiceLoader;

/**
 * This annotation processor processes all elements annotated as a <code>@Contract</code>
 * by forwarding all interface elements annotated as <code>@Contract</code> to the
 * set of <code>ContractProcessor</code> services found in the <code>modulepath</code>
 * which are loaded using <code>ServiceLoader</code>.
 * 
 * If no <code>ContractProcessor</code> services are found, a compiler warning is issued.
 * 
 * If the <code>@Contract</code> annotation has been applied to something other than 
 * a Java interface, a compiler error is generated.
 * 
 * @author {fritz at solmstc.com, justus.posthuma at gmail.com}
 */
@SupportedAnnotationTypes("org.urdad.cdd.contract.Contract")
@SupportedSourceVersion(SourceVersion.RELEASE_17)
@AutoService(Processor.class)
public class ContractAnnotationProcessor extends AbstractProcessor
{
  @Override
  public synchronized void init(ProcessingEnvironment processingEnv)
  {
    super.init(processingEnv);
    
    contractProcessors.add(new BasicContractValidationInterceptor());
        //TODO remove above once service provider discovery is used - see private member vars
    if (contractProcessors.iterator().hasNext())
      logger.info("ContractAnnotationProcessor initialized.");
    else
      {
        String msg = "No contract processors found in modulespath.";
        logger.warn(msg);
        processingEnv.getMessager().printMessage(Diagnostic.Kind.WARNING, msg);
      }
  }

  @Override
  public boolean process(Set<? extends TypeElement> annotationTypes,
      RoundEnvironment roundEnv)
  {
    logger.info("*************** Processing @Contract annotations ***********");

    assert (annotationTypes.size() == 1);
    for (TypeElement annotationType : annotationTypes) // should be only single type: Contract
    {
      Map<Boolean, List<Element>> annotatedTypes 
      = roundEnv.getElementsAnnotatedWithAny(annotationType).parallelStream()
          .collect(Collectors.partitioningBy(annotatedElement 
            -> annotatedElement.getKind() == ElementKind.INTERFACE));

      annotatedTypes.get(false).forEach(nonInterfaceContract
          -> compilationError("@Contract annotation may only be applied to interfaces.", nonInterfaceContract));

      annotatedTypes.get(true).forEach(contract
        -> {contractProcessors.forEach(contractProcessor 
          -> processContract(contractProcessor, contract));});
    }    
    return true;
  } 
    
  private void processContract(ContractProcessor contractProcessor, Element contract )
  {
    try { 
      contractProcessor.process(contract, processingEnv.getFiler());
    }
    catch (ContractEncodingException e) 
    {
      compilationError(e.getMessage(), e.getElement());
    }
    catch(IOException e)
    {
      compilationError(e.getMessage(), contract);
    }
  }
  
  private void compilationError(String msg, Element element)
  {
    logger.error(element.getSimpleName() + msg);
    processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR,
              "@Contract annotation may only be applied to interfaces.",
              element);
  }
    
  private static final Logger logger = LogManager.getLogger(ContractAnnotationProcessor.class);

//TODO Revert back to service provider discovery  
//  private static final Iterable<ContractProcessor> contractProcessors 
//    = ServiceLoader.loadInstalled(ContractProcessor.class);
  private static final Set<ContractProcessor> contractProcessors = new HashSet<>();
}