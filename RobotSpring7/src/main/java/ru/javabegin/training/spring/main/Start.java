package ru.javabegin.training.spring.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ru.javabegin.training.spring.impls.robot.ModelT1000;
import ru.javabegin.training.spring.interfaces.Robot;
import ru.javabegin.training.spring.interfaces.RobotConveyor;

public class Start {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("all_context.xml");
		Robot replacedTerminator = (ModelT1000)context.getBean("t1000");
		replacedTerminator.action();
		
		
	/*	RobotConveyor t1000Conveyor =(RobotConveyor)context.getBean("t1000Conveyor");
		Robot terminator1 = t1000Conveyor.createRobot();
		Robot terminator2 = t1000Conveyor.createRobot();
		Robot terminator3 = t1000Conveyor.createRobot();*/
		
		/*terminator1.dance();
		terminator2.dance();
		terminator3.dance();*/
		
		//ModelT1000 t1000 = (ModelT1000) context.getBean("t1000");
		// ModelT1000 t1000Empty = (ModelT1000) context.getBean("t1000Empty");

	}
}
