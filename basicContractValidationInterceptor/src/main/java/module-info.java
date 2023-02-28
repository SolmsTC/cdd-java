/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/module-info.java to edit this template
 */

module basicContractValidationInterceptor {
  requires java.compiler;
  requires org.urdad.cdd.contract;
  requires org.urdad.cdd.exceptions;
  requires org.urdad.cdd.contractValidatingInterceptor;
  requires com.squareup.javapoet;
  requires org.apache.logging.log4j;
  requires org.apache.logging.log4j.core;
  requires org.apache.logging.log4j.slf4j;
  requires slf4j.api;
  requires com.google.auto.service;
  requires auto.service;
  requires auto.common;
  requires com.google.common;
  requires failureaccess;
  requires listenablefuture;
  requires jsr305;
  requires org.checkerframework.checker.qual;
  requires com.google.errorprone.annotations;
  requires j2objc.annotations;
  
  provides org.urdad.cdd.contractAnnotationProcessor.ContractProcessor 
      with org.urdAad.cdd.basicContractValidationInterceptor.BasicContractValidationInterceptor;
}
