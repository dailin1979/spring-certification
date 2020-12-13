package com.ld.aop.helloworld;

import com.ld.aop.impl.ArithmeticCalculator;

public class ArithmeticCalculatorLoggingImpl implements ArithmeticCalculator {

  private Integer result;

  @Override
  public Integer add(Integer i, Integer j) {
    result = i+j;
    return result;
  }

  @Override
  public Integer sub(Integer i, Integer j) {
    result = i-j;
    return result;
  }

  @Override
  public Integer mul(Integer i, Integer j) {
    result = i*j;
    return result;
  }

  @Override
  public Integer div(Integer i, Integer j) {
    return i/j;
  }
}
