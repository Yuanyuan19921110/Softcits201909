package catchup_3;
//指令集， 机器指令
public class HelloWorld {
	
	final int a;

	public void print() {
		System.out.println("Hello World");
	}


	
	//无参构造器
	public HelloWorld() {
		a = 2;
	}


	//带参构造器
	public HelloWorld(int a) {
		this.a = a;
	}
	
	

}
