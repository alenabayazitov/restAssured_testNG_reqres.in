import org.testng.annotations.DataProvider;

public class DataForTests {


	@DataProvider(name = "DataForPost")
	public Object[][] dataForPost(){
	
		/*
		Object[][] data = new Object[3][2];
		data[0][0] = "Maxim";
		data[0][1] = "creator";
		data[1][0] = "Kris";
		data[1][1] = "hr";
		data[2][0] = "Sasha";
		data[2][1] = "artist";
		
		return data;
		*/
		
		return new Object[][] {
			{"Samuel", "president"},
			{"Thomas", "scientist"}
		};
		
	}
	
	@DataProvider(name = "DataForDelete")
	public Object[] dataForDelete() {
		return new Object[] {
				7,9,11
		};
	}
	
}
