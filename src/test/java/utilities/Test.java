package utilities;
import static utilities.ChromeFox.firefoxDriver;

public class Test {
	public static void main(String[] args) {
		firefoxDriver().get("https://the-internet.herokuapp.com/frames");
	}
}
