package ru.javabegin.training.spring.impls.robot;

import java.lang.reflect.Method;

import org.springframework.beans.factory.support.MethodReplacer;

public class TerminatorReplacer implements MethodReplacer {

	@Override
	public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {
		System.out.println("tetst robot");
		return new String();
	}

}
