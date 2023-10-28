package dao;

public class DataServiceImpl_2 implements DataService {

	//The logic to retrieve a value from another source (API)
	@Override
	public int getValue() {
		System.out.println("Version 2 of DataService implementation");
		return 5;
	}

}
