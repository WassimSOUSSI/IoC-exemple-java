package logic.presentation;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import java.lang.reflect.Method;

import dao.DataServiceImpl_1;
import dao.DataServiceImpl_2;
import dao.DataServiceImpl_3;
import dao.DataService;
import logic.business.ServiceConsumer;



public class application {

	public static void main(String[] args) throws Exception {

		//*******V1 of code(Tightly coupled)********
//		DataServiceImpl_1 dataServiceI=new DataServiceImpl_1();
//		ServiceConsumer serviceConsumer=new ServiceConsumer();
//		serviceConsumer.setDataService(new dataServiceI);  // Dependency injection using the setter
//		System.out.println("The value is : "+serviceConsumer.doSomething());
		
		//*******V2 of code(loosely coupled using static instantiation)********
//		DataService dataService=new DataServiceImpl_2(); //Here we can specify which implementation of dataService we want to use in the code
//		ServiceConsumer serviceConsumer=new ServiceConsumer();
//		serviceConsumer.setDataService(dataService);  // Dependency injection using the setter
//		System.out.println("The value is : "+a.doSomething());
		
		//*******V3 of code(IoC implementation)********
		File file=new File("config.txt");  
		Scanner scanner=new Scanner(file);
		String className=scanner.nextLine();
		Class dataServiceClass=Class.forName(className);  //Here we get the version of DataServiceImpl we want to use in the code from config.txt
		DataService dataService=(DataService) dataServiceClass.newInstance();
		className =scanner.nextLine();
		Class dataConsumerClass=Class.forName(className);
		ServiceConsumer serviceConsumer=(ServiceConsumer) dataConsumerClass.newInstance();
		Method method=dataConsumerClass.getMethod("setDataService", DataService.class);
		method.invoke(serviceConsumer,dataService);
		System.out.println("The value is : "+serviceConsumer.doSomething());
		
		

		


		

	
	}
}
