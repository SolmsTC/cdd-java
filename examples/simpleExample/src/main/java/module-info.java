module org.urdad.cdd.examples.simpleExample 
{
  requires java.compiler;
  
  requires org.urdad.cdd.contract;
  requires org.urdad.cdd.exceptions;
  requires org.urdad.cdd.contractValidatingInterceptor;
  
  exports org.urdad.cdd.examples.simpleExample;
  requires com.google.auto.service;
}
