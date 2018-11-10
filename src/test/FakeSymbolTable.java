package test;
import ast.*;
import symboltable.*;

//For the moment we will only focus on doing Type searches within the symbol table.
//Therefore, we will only do classes and delegates for the moment
public class FakeSymbolTable{

	//Build a fake symbol tree manually for testing symbol table naviagation
	public static SageSym buildFakeSymbolTree(){
		//Line and column numbers don't matter at the moment
		SageSym root = new SageSym("test", true, null, "test");

		//Create a class to add to the root
		ClassSym t1 = new ClassSym("TestClass1", 0, 0, false, Sym.ProtectionLevel.PUBLIC, root, "test/TestClass1");

		/******************************************************************************************************************/
		//Nothing static is in this class
		/******************************************************************************************************************/
		//Add a few inner classes
		ClassSym innerT1 = new ClassSym("InnerClass", 0, 0, false, Sym.ProtectionLevel.NONE, t1, "test/TestClass1/InnerClass");
		ClassSym privateInnerT1 = new ClassSym("PrivateInnerClass", 0, 0, false, Sym.ProtectionLevel.PRIVATE, t1, "test/TestClass1/PrivateInnerClass");
		ClassSym publicInnerT1 = new ClassSym("PublicInnerClass", 0, 0, false, Sym.ProtectionLevel.PUBLIC, t1, "test/TestClass1/PublicInnerClass");

		//Add inner classes to the private inner class
		ClassSym publicDoubleInnerT1 = new ClassSym("PublicDoubleInnerClass", 0, 0, false, Sym.ProtectionLevel.PUBLIC, privateInnerT1, "test/TestClass1/PrivateInnerClass/PublicDoubleInnerClass");
		ClassSym privateDoubleInnerT1 = new ClassSym("PrivateDoubleInnerClass", 0, 0, false, Sym.ProtectionLevel.PRIVATE, privateInnerT1, "test/TestClass1/PrivateInnerClass/PrivateDoubleInnerClass");
		privateInnerT1.addClass(publicDoubleInnerT1.name, publicDoubleInnerT1);
		privateInnerT1.addClass(privateDoubleInnerT1.name, privateDoubleInnerT1);

		//Add inner classes to public inner class
		ClassSym publicDoubleInnerT1_2 = new ClassSym("PublicDoubleInnerClass2", 0, 0, false, Sym.ProtectionLevel.PUBLIC, publicInnerT1, "test/TestClass1/PublicInnerClass/PublicDoubleInnerClass2");
		ClassSym privateDoubleInnerT1_2 = new ClassSym("PrivateDoubleInnerClass2", 0, 0, false, Sym.ProtectionLevel.PRIVATE, publicInnerT1, "test/TestClass1/PublicInnerClass/PrivateDoubleInnerClass2");
		publicInnerT1.addClass(publicDoubleInnerT1_2.name, publicDoubleInnerT1_2);
		publicInnerT1.addClass(privateDoubleInnerT1_2.name, privateDoubleInnerT1_2);

		//Add an inner class to the class with no protection
		ClassSym publicDoubleInnerT1_3 = new ClassSym("PublicDoubleInnerClass3", 0, 0, false, Sym.ProtectionLevel.PUBLIC, innerT1, "test/TestClass1/InnerClass/PublicDoubleInnerClass3");
		innerT1.addClass(publicDoubleInnerT1_3.name, publicDoubleInnerT1_3);

		t1.addClass(innerT1.name, innerT1);
		t1.addClass(privateInnerT1.name, privateInnerT1);
		t1.addClass(publicInnerT1.name, publicInnerT1);

		/*********************************************************************************************************/
		//The second class to be added is static and contains static and non static features
		/*********************************************************************************************************/

		ClassSym t2 = new ClassSym("TestClass2", 0, 0, true, Sym.ProtectionLevel.PUBLIC, root, "test/TestClass2");

		/*********************************************************************************************************/
		//The third class to be added is not static but contains static and non static features
		/*********************************************************************************************************/
		ClassSym t3 = new ClassSym("TestClass3", 0, 0, false, Sym.ProtectionLevel.NONE, root, "test/TestClass3");
		root.addClass(t1.name, t1);
		root.addClass(t2.name, t2);
		root.addClass(t3.name, t3);

		//TO DO: Create a few other SymbolTables to use for import testing

		return root;
	}
}