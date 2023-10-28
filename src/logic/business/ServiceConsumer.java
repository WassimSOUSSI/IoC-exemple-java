package logic.business;

import dao.DataService;

public class ServiceConsumer {
	//*******V1 of code (specifying the exact class to be used to handle the app logic)********
//	//Dependency
//	DataServiceImpl_1 dataService;
//	
//	public void setB(DataServiceImpl_1 dataService) {
//		this.dataService = dataService;
//	}
//	
//	//Method that handle the business logic of the app
//	public int doSomething() {
//		return this.dataService.getValue()*2;
//	}
	
	//*******V2 of code (Using the interface instead of the class)*******
	//Dependency
	DataService dataService;
	
	public void setDataService(DataService dataService) {
		this.dataService = dataService;
	}
	
	//Method that handle the business logic of the app
	public int doSomething() {
		return this.dataService.getValue()*2;
	}

}
