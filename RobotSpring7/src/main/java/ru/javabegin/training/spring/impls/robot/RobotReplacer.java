package ru.javabegin.training.spring.impls.robot;

import java.lang.reflect.Method;

import org.springframework.beans.factory.support.MethodReplacer;

public class RobotReplacer implements MethodReplacer 
{

	

	@Override
	public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {
		String str = "method was replaced";
		System.out.println(str);
		return str;
	}
}
