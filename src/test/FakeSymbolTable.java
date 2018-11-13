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

		//Add a delegate to the public class
		MethodSym publicDelegate = new MethodSym("publicDelegate(int)", 0, 0, false, Sym.ProtectionLevel.PUBLIC, new TypeSym(TypeSym.TypeEnum.INT, false), true, t1, "test/TestClass1/publicDelegate(int)");
		MethodSym privateDelegate = new MethodSym("privateDelegate(boolean,boolean)", 0, 0, false, Sym.ProtectionLevel.PRIVATE, new TypeSym(TypeSym.TypeEnum.BOOLEAN, false), true, t1, "test/TestClass1/privateDelegate(boolean,boolean)");
		
		t1.addMethod(publicDelegate.name, publicDelegate);
		t1.addMethod(privateDelegate.name, privateDelegate);
		t1.addClass(innerT1.name, innerT1);
		t1.addClass(privateInnerT1.name, privateInnerT1);
		t1.addClass(publicInnerT1.name, publicInnerT1);

		/*********************************************************************************************************/
		//The second class to be added is static and contains static and non static features
		/*********************************************************************************************************/

		ClassSym t2 = new ClassSym("TestClass2", 0, 0, true, Sym.ProtectionLevel.PUBLIC, root, "test/TestClass2");

		ClassSym staticInnert2 = new ClassSym("StaticInnerClass", 0, 0, true, Sym.ProtectionLevel.PUBLIC, t2, "test/TestClass2/StaticInnerClass");
		ClassSym privateStaticInnert2 = new ClassSym("PrivateStaticInnerClass", 0, 0, true, Sym.ProtectionLevel.PRIVATE, t2, "test/TestClass2/PrivateStaticInnerClass");
		ClassSym innerNonStatict2 = new ClassSym("NonStaticPublicClass", 0, 0, false, Sym.ProtectionLevel.PUBLIC, t2, "test/TestClass2/NonStaticPublicClass");

		t2.addClass(staticInnert2.name, staticInnert2);
		t2.addClass(privateStaticInnert2.name, privateStaticInnert2);
		t2.addClass(innerNonStatict2.name, innerNonStatict2);

		/*********************************************************************************************************/
		//The third class to be added is not static but contains static and non static features
		/*********************************************************************************************************/
		ClassSym t3 = new ClassSym("TestClass3", 0, 0, false, Sym.ProtectionLevel.NONE, root, "test/TestClass3");
		MethodSym publicDelegatet3 = new MethodSym("publicDelegatet3()", 0, 0, false, Sym.ProtectionLevel.PUBLIC, new TypeSym(TypeSym.TypeEnum.VOID, false), true, t3, "test/TestClass3/publicDelegatet3()");
		MethodSym privateStaticDelegate = new MethodSym("privateStaticDelegate(publicDelegatet3,int[])", 0, 0, true, Sym.ProtectionLevel.PRIVATE, new TypeSym(TypeSym.TypeEnum.DECIMAL, false), true, t3, "test/TestClass3/privateStaticDelegate(publicDelegatet3,int[])");

		t3.addMethod(publicDelegatet3.name, publicDelegatet3);
		t3.addMethod(privateStaticDelegate.name, privateStaticDelegate);

		//Add sage level delegates
		MethodSym staticDelegate = new MethodSym("staticDelegate()", 0, 0, true, Sym.ProtectionLevel.NONE, new TypeSym(TypeSym.TypeEnum.VOID, false), true, root, "test/staticDelegate()");
		MethodSym publicSageDelegate = new MethodSym("publicDelegate(int)", 0, 0, false, Sym.ProtectionLevel.PUBLIC, new TypeSym(TypeSym.TypeEnum.INT, false), true, root, "test/publicDelegate(int)");

		root.addMethod(staticDelegate.name, staticDelegate);
		root.addMethod(publicSageDelegate.name, publicSageDelegate);
		root.addClass(t1.name, t1);
		root.addClass(t2.name, t2);
		root.addClass(t3.name, t3);

		//Create a few other SymbolTables to use for import testing
		SageSym import1 = new SageSym("import1", false, null, "import1");
		ClassSym importClass = new ClassSym("ImportClass", 0, 0, false, Sym.ProtectionLevel.PUBLIC, import1, "import1/ImportClass");
		ClassSym hiddenClass = new ClassSym("HiddenClass", 0, 0, false, Sym.ProtectionLevel.NONE, import1, "import1/HiddenClass");
		import1.addClass(importClass.name, importClass);
		import1.addClass(hiddenClass.name, hiddenClass);

		SageSym import2 = new SageSym("import2", false, null, "import2");
		ClassSym importClass2 = new ClassSym("ImportClass", 0, 0, false, Sym.ProtectionLevel.PUBLIC, import2, "import2/ImportClass");
		ClassSym staticImport = new ClassSym("StaticImportClass", 0, 0, true, Sym.ProtectionLevel.PUBLIC, import2, "import2/StaticImportClass");
		import2.addClass(importClass2.name, importClass2);
		import2.addClass(staticImport.name, staticImport);

		SymbolTable importTable1 = new SymbolTable();
		importTable1.setRoot(import1);
		SymbolTable importTable2 = new SymbolTable();
		importTable2.setRoot(import2);

		root.addTable(import1.name, importTable1);
		root.addTable(import2.name, importTable2);

		return root;
	}
}