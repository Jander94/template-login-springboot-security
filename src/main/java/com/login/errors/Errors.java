package com.login.errors;

import lombok.Data;

import java.util.Arrays;
import java.util.List;

@Data
public class Errors {
  private List<String> errors;

  public Errors(List<String> errors) {
    this.errors = errors;
  }
  public Errors(String mensagemErro){
    this.errors = Arrays.asList(mensagemErro);
  }
}
