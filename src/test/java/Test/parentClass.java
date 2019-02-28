package Test;


public class parentClass{
//if you don't want to inherit the properties of the parent class to any other class,use final keyword
//to prevent inheritance,use final keyword,it will show up an error into the child class where you want to inherit the properties 
//of child class.
//Similarly you can use final keyword with any method as well,you won't be able to override a method if you use final keyword.
//To prevent method overriding and avoid inheritance.
	
	public void start()
	{
		System.out.println("Start Method");
	}
	
//	public final class parentClass{
//		public final void start()
//		{
//			System.out.println("Start Method");
//		}
//		
//	}

}
