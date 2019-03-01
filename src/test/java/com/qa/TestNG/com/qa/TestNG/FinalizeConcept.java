package com.qa.TestNG.com.qa.TestNG;

public class FinalizeConcept {
	
	public void finalize(){
		System.out.println("finalize method");
	}
	//finalize is a method which is used to clear out the garbage collection from JAVA memory
	//like the objects which has no refrence,they will be clear out from mamory when garbage collector will be called to free some spce inside the memory.
	//finalize is a methodis used to clean up the memory.
	//finalize() method is a protected and non-static method of java.lang.Object class. 
	//This method will be available in all objects you create in java. This method is used to perform some final operations or clean up operations on an object before it is removed from the memory.
	
	public static void main(String[] args) {

		FinalizeConcept f1 = new FinalizeConcept();
		FinalizeConcept f2 = new FinalizeConcept();
		f1 = null;//means the f1 object will be removed from reference.
		f2 = null;
		System.gc();//gc-garbage collector--> method will be called to clear out the memory which has no object reference. 
	}

}
