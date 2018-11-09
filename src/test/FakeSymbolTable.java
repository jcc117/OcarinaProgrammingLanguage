package test;
import ast.*;
import symboltable.*;

public static class FakeSymbolTable{

	//Build a fake symbol tree manually for testing symbol table naviagation
	public static SageSym buildFakeSymbolTree(){
		//Line and column numbers don't matter at the moment
		SageSym root = new SageSym("test", true, null, "test");
		ClassSym t1 = new ClassSym("TestClass1", 0, 0, false, Sym.ProtectionLevel.PUBLIC, root, "test/TestClass1");
		ClassSym t2 = new ClassSym("TestClass2", 0, 0, true, Sym.ProtectionLevel.PUBLIC, root, "test/TestClass2");
		ClassSym t3 = new Classsym("TestClass3", 0, 0, false, Sym.ProtectionLevel.NONE, root, "test/TestClass3");
		root.addClass(t1.name, t1);
		root.addClass(t2.name, t2);
		root.addClass(t3.name, t3);

		return root;
	}
}