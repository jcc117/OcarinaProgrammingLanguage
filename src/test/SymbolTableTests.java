package test;
import ast.*;
import symboltable.*;
import junit.framework.*;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

//Tests for the SymbolTable class
public class SymbolTableTests{
	private SymbolTable testTable;

	/******************************************************************/
	//Tests for floatScope()
	/******************************************************************/

	//Float scope when no parent exists(top level)
	//Should throw an IllegalScopeException
	@Test
	public void floatScopeNoParentTest(){
		testTable = new SymbolTable();
		testTable.setRoot(FakeSymbolTable.buildFakeSymbolTree());
		try{
			testTable.floatScope();
			assertTrue("Test failure when floating to a scope with no parent", false);
		}
		catch(IllegalScopeException e){
			assertTrue(e.toString().contains("Illegal transition to a scope that has no parent scope"));
		}
	}

	//Float up to a class scope
	@Test
	public void floatScopeClassParent_Test() throws IllegalScopeException{
		testTable = new SymbolTable();
		testTable.setRoot(FakeSymbolTable.buildFakeSymbolTree());
		assertTrue(testTable.getCurrentScope() instanceof SageSym);
		testTable.sinkToClassScope("TestClass1");
		assertEquals("TestClass1", testTable.getCurrentScope().name);
		assertTrue(testTable.getCurrentScope() instanceof ClassSym);
		testTable.sinkToClassScope("InnerClass");
		assertNotNull(testTable.getCurrentScope());
		assertTrue(testTable.getCurrentScope() instanceof ClassSym);
		testTable.floatScope();
		assertNotNull(testTable.getCurrentScope());
		assertEquals("TestClass1", testTable.getCurrentScope().name);
		assertTrue(testTable.getCurrentScope() instanceof ClassSym);
	}

	//Float up to a method scope
	@Test
	public void floatScopeMethodParent_Test() throws IllegalScopeException{

	}

	//Float up to a sage scope
	@Test
	public void floatScopeSageParent_Test() throws IllegalScopeException{
		testTable = new SymbolTable();
		testTable.setRoot(FakeSymbolTable.buildFakeSymbolTree());
		assertTrue(testTable.getCurrentScope() instanceof SageSym);
		testTable.sinkToClassScope("TestClass1");
		assertTrue(testTable.getCurrentScope() instanceof ClassSym);
		testTable.floatScope();
		assertNotNull(testTable.getCurrentScope());
		assertEquals("test", testTable.getCurrentScope().name);
		assertTrue(testTable.getCurrentScope() instanceof SageSym);
		assertEquals(testTable.getRoot(), testTable.getCurrentScope());
	}

	//Float up to an inner method scope from another inner method scope
	@Test
	public void floatScopeIMScopeToImScope_Test() throws IllegalScopeException{

	}

	//Float up to a method scope from an inner method scope
	@Test
	public void floatScopeIMScopeToMethodScope_Test() throws IllegalScopeException{

	}

	//Float up to a scope when the current scope is null
	//Should throw an IllegalScopeException
	//Not a normal use case
	public void floatScopeCurrentScopeNull_Test() throws IllegalScopeException{
		testTable = new SymbolTable();
		try{
			testTable.floatScope();
			assertTrue("Test failure when floating scope when current scope is null", false);
		}
		catch(IllegalScopeException e){
			assertTrue(e.toString().contains("Illegal transition to a scope that has no parent scope"));
		}
	}

	/******************************************************************/
	//Tests for sinkToClassScope()
	/******************************************************************/
	//Sink to a class scope from a class
	@Test
	public void sinkToClassScopeFromClass_Test() throws IllegalScopeException{
		testTable = new SymbolTable();
		testTable.setRoot(FakeSymbolTable.buildFakeSymbolTree());
		assertTrue(testTable.getCurrentScope() instanceof SageSym);
		testTable.sinkToClassScope("TestClass1");
		assertEquals("TestClass1", testTable.getCurrentScope().name);
		assertTrue(testTable.getCurrentScope() instanceof ClassSym);
		testTable.sinkToClassScope("InnerClass");
		assertNotNull(testTable.getCurrentScope());
		assertEquals("InnerClass", testTable.getCurrentScope().name);
		assertTrue(testTable.getCurrentScope() instanceof ClassSym);
		assertEquals("test/TestClass1/InnerClass", testTable.getPath());
	}

	//Sink to a class scope from a sage
	@Test 
	public void sinkToClassScopeFromSage_Test() throws IllegalScopeException{
		testTable = new SymbolTable();
		testTable.setRoot(FakeSymbolTable.buildFakeSymbolTree());
		assertTrue(testTable.getCurrentScope() instanceof SageSym);
		testTable.sinkToClassScope("TestClass1");
		assertNotNull(testTable.getCurrentScope());
		assertEquals("TestClass1", testTable.getCurrentScope().name);
		assertTrue(testTable.getCurrentScope() instanceof ClassSym);
		assertEquals("test/TestClass1", testTable.getPath());
	}

	//Sink to a class scope from a method
	//Should throw an IllegalScopeException
	@Test
	public void sinkToClassScopeFromMethod_Test() throws IllegalScopeException{
		testTable = new SymbolTable();
		testTable.setRoot(FakeSymbolTable.buildFakeSymbolTree());
		testTable.sinkToClassScope("TestClass1");
		testTable.sinkToMethodScope("publicDelegate(int)");
		assertTrue(testTable.getCurrentScope() instanceof MethodSym);
		try{
			testTable.sinkToClassScope("TestShouldFail");
			assertTrue("Test failure when trying to sink to class scope from a method", false);
		}
		catch(IllegalScopeException e){
			assertTrue(e.toString().contains("Illegal transition to a class scope"));
		}
	}

	//Sink to class scope from an inner method scope
	//Should throw an IllegalScopeException
	@Test
	public void sinkToClassScopeFromInnerMethodScope_Test(){

	}

	//Sink to a non existent class
	//Should throw an IllegalScopeException
	@Test
	public void sinkToClassScopeNonExistentClass_Test() throws IllegalScopeException{
		testTable = new SymbolTable();
		testTable.setRoot(FakeSymbolTable.buildFakeSymbolTree());
		try{
			testTable.sinkToClassScope("NonExistentClass");
			assertTrue("Test failure when trying to sink to a nonexistent class", false);
		}
		catch(IllegalScopeException e){
			assertTrue(e.toString().contains("Illegal transition to a class scope that does not exist"));
		}
	}

	/******************************************************************/
	//Tests for sinkToMethodScope()
	/******************************************************************/
	//Sink to a method scope from a class
	@Test
	public void sinkToMethodScopeFromClass_Test() throws IllegalScopeException{
		testTable = new SymbolTable();
		testTable.setRoot(FakeSymbolTable.buildFakeSymbolTree());
		testTable.sinkToClassScope("TestClass1");
		testTable.sinkToMethodScope("publicDelegate(int)");
		assertNotNull(testTable.getCurrentScope());
		assertTrue(testTable.getCurrentScope() instanceof MethodSym);
		assertEquals("test/TestClass1/publicDelegate(int)", testTable.getPath());
	}

	//Sink to a method scope from a sage
	@Test 
	public void sinkToMethodScopeFromSage_Test() throws IllegalScopeException{
		testTable = new SymbolTable();
		testTable.setRoot(FakeSymbolTable.buildFakeSymbolTree());
		assertTrue(testTable.getCurrentScope() instanceof SageSym);
		testTable.sinkToMethodScope("staticDelegate()");
		assertNotNull(testTable.getCurrentScope());
		assertTrue(testTable.getCurrentScope() instanceof MethodSym);
		assertEquals("test/staticDelegate()", testTable.getPath());
	}

	//Sink to a method scope from a method
	//Should throw an IllegalScopeException
	@Test
	public void sinkToMethodScopeFromMethod_Test() throws IllegalScopeException{
		
	}

	//Sink to a method scope from an inner method scope
	//Should throw an IllegalScopeException
	@Test
	public void sinkToMethodScopeFromInnerMethodScope_Test() throws IllegalScopeException{
		
	}

	//Sink to a method scope that does not exist
	//Should throw an IllegalScopeException
	@Test
	public void sinkToMethodScopeNonExistMethod_Test() throws IllegalScopeException{
		testTable = new SymbolTable();
		testTable.setRoot(FakeSymbolTable.buildFakeSymbolTree());
		try{
			testTable.sinkToMethodScope("nonExistentMethod()");
		}
		catch(IllegalScopeException e){
			assertTrue(e.toString().contains("Illegal transition to a method scope that does not exist"));
		}
	}
	/******************************************************************/
	//Tests for sinkToInnerMethodScope()
	/******************************************************************/
	//Sink to an inner method scope from a class
	//Should throw an IllegalScopeException
	@Test
	public void sinkToInnerMethodScopeFromClass_Test(){

	}

	//Sink to an inner method scope from a sage
	//Should throw an IllegalScopeException
	@Test 
	public void sinkToInnerMethodScopeFromSage_Test(){

	}

	//Sink to an inner method scope from a method
	@Test
	public void sinkToInnerMethodScopeFromMethod_Test(){

	}

	//Sink to an inner method scope from an inner method scope
	@Test
	public void sinkToInnerMethodScopeFromInnerMethodScope_Test(){
		
	}
	/******************************************************************/
	//Tests for addSymbol()
	/******************************************************************/
	//Note that adding a sage symbol is never a normal use case

	//Add a var to a sage
	@Test
	public void addSymbolVarToSage_Test(){
		testTable = new SymbolTable();
		testTable.setRoot(FakeSymbolTable.buildFakeSymbolTree());
		SageSym current = (SageSym)testTable.getCurrentScope();
		String varName = "testVar";
		VarSym testVar = new VarSym(varName, 0, 0, false, Sym.ProtectionLevel.PUBLIC, true, new TypeSym(TypeSym.TypeEnum.INT, false), false, (Sym)current,"test/" + varName);
		testTable.addSymbol(testVar);
		assertNotNull(current.getVar(varName));
		assertEquals(varName, current.getVar(varName).name);
		assertEquals("test/" + varName, current.getVar(varName).path);
		assertNull(current.getMethod(varName));
		assertNull(current.getClass(varName));
		assertNull(current.getTable(varName));
	}

	//Add a method to a sage
	@Test
	public void addSymbolMethodToSage_Test(){
		testTable = new SymbolTable();
		testTable.setRoot(FakeSymbolTable.buildFakeSymbolTree());
		SageSym current = (SageSym)testTable.getCurrentScope();
		String methodName = "testMethod()";
		MethodSym testMethod = new MethodSym(methodName, 0, 0, false, Sym.ProtectionLevel.PUBLIC, new TypeSym(TypeSym.TypeEnum.VOID, false), false, current, "test/" + methodName);
		testTable.addSymbol(testMethod);
		assertNotNull(current.getMethod(methodName));
		assertEquals(methodName, current.getMethod(methodName).name);
		assertEquals("test/" + methodName, current.getMethod(methodName).path);
		assertNull(current.getVar(methodName));
		assertNull(current.getClass(methodName));
		assertNull(current.getTable(methodName));
	}

	//Add a class to a sage
	@Test
	public void addSymbolClassToSage_Test(){
		testTable = new SymbolTable();
		testTable.setRoot(FakeSymbolTable.buildFakeSymbolTree());
		SageSym current = (SageSym)testTable.getCurrentScope();
		String className = "ClassToAdd";
		ClassSym testClass = new ClassSym(className, 0, 0, false, Sym.ProtectionLevel.PUBLIC, (Sym)current, "test/" + className);
		testTable.addSymbol(testClass);
		assertNotNull(current.getClass(className));
		assertEquals(className, current.getClass(className).name);
		assertEquals("test/" + className, current.getClass(className).path);
		assertNull(current.getVar(className));
		assertNull(current.getMethod(className));
		assertNull(current.getTable(className));
	}

	//Add a sage to a sage
	//Nothing should happen
	@Test
	public void addSymbolSageToSage_Test(){
		testTable = new SymbolTable();
		testTable.setRoot(FakeSymbolTable.buildFakeSymbolTree());
		SageSym current = (SageSym)testTable.getCurrentScope();
		String sageName = "SageToAdd";
		SageSym sage = new SageSym(sageName, false, null, "test/" + sageName);
		testTable.addSymbol(sage);
		assertNull(current.getVar(sageName));
		assertNull(current.getMethod(sageName));
		assertNull(current.getClass(sageName));
		assertNull(current.getTable(sageName));
	}

	//Add a var to a class
	@Test
	public void addSymbolVarToClass_Test() throws IllegalScopeException{
		testTable = new SymbolTable();
		testTable.setRoot(FakeSymbolTable.buildFakeSymbolTree());
		testTable.sinkToClassScope("TestClass1");
		ClassSym current = (ClassSym)testTable.getCurrentScope();
		String varName = "testVar";
		VarSym testVar = new VarSym(varName, 0, 0, false, Sym.ProtectionLevel.PUBLIC, true, new TypeSym(TypeSym.TypeEnum.INT, false), false, (Sym)current,"test/TestClass1/" + varName);
		testTable.addSymbol(testVar);
		assertNotNull(current.getVar(varName));
		assertEquals(varName, current.getVar(varName).name);
		assertEquals("test/TestClass1/" + varName, current.getVar(varName).path);
		assertNull(current.getMethod(varName));
		assertNull(current.getClass(varName));
	}

	//Add a method to a class
	@Test
	public void addSymbolMethodToClass_Test() throws IllegalScopeException{
		testTable = new SymbolTable();
		testTable.setRoot(FakeSymbolTable.buildFakeSymbolTree());
		testTable.sinkToClassScope("TestClass1");
		ClassSym current = (ClassSym)testTable.getCurrentScope();
		String methodName = "testMethod()";
		MethodSym testMethod = new MethodSym(methodName, 0, 0, false, Sym.ProtectionLevel.PUBLIC, new TypeSym(TypeSym.TypeEnum.VOID, false), false, current, "test/TestClass1/" + methodName);
		testTable.addSymbol(testMethod);
		assertNotNull(current.getMethod(methodName));
		assertEquals(methodName, current.getMethod(methodName).name);
		assertEquals("test/TestClass1/" + methodName, current.getMethod(methodName).path);
		assertNull(current.getVar(methodName));
		assertNull(current.getClass(methodName));
	}

	//Add a class to a class
	@Test
	public void addSymbolClassToClass_Test() throws IllegalScopeException{
		testTable = new SymbolTable();
		testTable.setRoot(FakeSymbolTable.buildFakeSymbolTree());
		testTable.sinkToClassScope("TestClass1");
		ClassSym current = (ClassSym)testTable.getCurrentScope();
		String className = "ClassToAdd";
		ClassSym testClass = new ClassSym(className, 0, 0, false, Sym.ProtectionLevel.PUBLIC, (Sym)current, "test/TestClass1/" + className);
		testTable.addSymbol(testClass);
		assertNotNull(current.getClass(className));
		assertEquals(className, current.getClass(className).name);
		assertEquals("test/TestClass1/" + className, current.getClass(className).path);
		assertNull(current.getVar(className));
		assertNull(current.getMethod(className));
	}

	//Add a sage to a class
	//Nothing should happen
	@Test
	public void addSymbolSageToClass_Test() throws IllegalScopeException{
		testTable = new SymbolTable();
		testTable.setRoot(FakeSymbolTable.buildFakeSymbolTree());
		testTable.sinkToClassScope("TestClass1");
		ClassSym current = (ClassSym)testTable.getCurrentScope();
		String sageName = "SageToAdd";
		SageSym sage = new SageSym(sageName, false, null, "test/" + sageName);
		testTable.addSymbol(sage);
		assertNull(current.getVar(sageName));
		assertNull(current.getMethod(sageName));
		assertNull(current.getClass(sageName));
	}

	//Add a var to a method
	@Test
	public void addSymbolVarToMethod_Test() throws IllegalScopeException{
		testTable = new SymbolTable();
		testTable.setRoot(FakeSymbolTable.buildFakeSymbolTree());
		testTable.sinkToMethodScope("staticDelegate()");
		MethodSym current = (MethodSym)testTable.getCurrentScope();
		String varName = "testVar";
		VarSym testVar = new VarSym(varName, 0, 0, false, Sym.ProtectionLevel.PUBLIC, true, new TypeSym(TypeSym.TypeEnum.INT, false), false, (Sym)current,"test/staticDelegate()/" + varName);
		testTable.addSymbol(testVar);
		assertNotNull(current.getVar(varName));
		assertEquals(varName, current.getVar(varName).name);
		assertEquals("test/staticDelegate()/" + varName, current.getVar(varName).path);
	}

	//Add a method to a method
	//Nothing should happen
	@Test
	public void addSymbolMethodToMethod_Test() throws IllegalScopeException{
		testTable = new SymbolTable();
		testTable.setRoot(FakeSymbolTable.buildFakeSymbolTree());
		testTable.sinkToMethodScope("staticDelegate()");
		MethodSym current = (MethodSym)testTable.getCurrentScope();
		String methodName = "testMethod()";
		MethodSym testMethod = new MethodSym(methodName, 0, 0, false, Sym.ProtectionLevel.PUBLIC, new TypeSym(TypeSym.TypeEnum.VOID, false), false, current, "test/staticDelegate()/" + methodName);
		testTable.addSymbol(testMethod);
		assertNull(current.getVar(methodName));
	}

	//Add a class to a method
	//Nothing should happen
	@Test
	public void addSymbolClassToMethod_Test() throws IllegalScopeException{
		testTable = new SymbolTable();
		testTable.setRoot(FakeSymbolTable.buildFakeSymbolTree());
		testTable.sinkToMethodScope("staticDelegate()");
		MethodSym current = (MethodSym)testTable.getCurrentScope();
		String className = "ClassToAdd";
		ClassSym testClass = new ClassSym(className, 0, 0, false, Sym.ProtectionLevel.PUBLIC, (Sym)current, "test/staticDelegate()/" + className);
		testTable.addSymbol(testClass);
		assertNull(current.getVar(className));
	}

	//Add a sage to a method
	//Nothing should happen
	@Test
	public void addSymbolSageToMethod_Test() throws IllegalScopeException{
		testTable = new SymbolTable();
		testTable.setRoot(FakeSymbolTable.buildFakeSymbolTree());
		testTable.sinkToMethodScope("staticDelegate()");
		MethodSym current = (MethodSym)testTable.getCurrentScope();
		String sageName = "SageToAdd";
		SageSym sage = new SageSym(sageName, false, null, "test/" + sageName);
		testTable.addSymbol(sage);
		assertNull(current.getVar(sageName));
	}

	//Add a var to an inner method scope
	@Test
	public void addSymbolVarToInnerMethodScope_Test(){

	}	

	//Add a method to an inner method scope
	//Nothing should happen
	@Test
	public void addSymbolMethodToInnerMethodScope_Test(){

	}

	//Add a class to an inner method scope
	//Nothing should happen
	@Test
	public void addSymbolClassToInnerMethodScope_Test(){

	}

	//Add a sage to an inner method scope
	//Nothing should happen
	@Test
	public void addSymbolSageToInnerMethodScope_Test(){

	}

	//Add a null symbol
	//Nothing should happen
	@Test
	public void addSymbolNullSymbol_Test(){

	}

	//Add a symbol that already exists
	//Should result in error being thrown
	@Test
	public void addSymbolAlreadyExists_Test(){

	}

	/******************************************************************/
	//Tests for addMethodScope()
	/******************************************************************/

	/******************************************************************/
	//Tests for getSymbol() - Type Searches
	/******************************************************************/

	/******************************************************************/
	//Tests for getSymbol() - Non-Type Searches
	/******************************************************************/
}