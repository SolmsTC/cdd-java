/**
 * 
 */
module org.urdad.cdd.contractValidatingInterceptor 
{
  requires java.compiler;
  
  requires org.urdad.cdd.contract;
  requires org.urdad.cdd.exceptions;
  requires com.google.auto.service;
  requires com.google.auto.service.processor;
  
  requires org.apache.logging.log4j;
  requires org.apache.logging.log4j.core;
  requires org.apache.logging.log4j.slf4j;
  requires slf4j.api;   
  
  exports org.urdad.cdd.contractAnnotationProcessor;
  opens org.urdad.cdd.contractAnnotationProcessor;
  
  provides javax.annotation.processing.Processor 
      with org.urdad.cdd.contractAnnotationProcessor.ContractAnnotationProcessor;
  
  uses org.urdad.cdd.contractAnnotationProcessor.ContractProcessor;
}
