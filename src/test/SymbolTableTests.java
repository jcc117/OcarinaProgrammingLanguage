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
	}

	//Float up to a class scope
	@Test
	public void floatScopeClassParent_Test(){

	}

	//Float up to a method scope
	@Test
	public void floatScopeMethodParent_Test(){

	}

	//Float up to a sage scope
	@Test
	public void floatScopeSageParent_Test(){

	}

	//Float up to an inner method scope from another inner method scope
	@Test
	public void floatScopeIMScopeToImScope_Test(){

	}

	//Float up to a method scope from an inner method scope
	@Test
	public void floatScopeIMScopeToMethodScope_Test(){

	}

	/******************************************************************/
	//Tests for sinkToClassScope()
	/******************************************************************/
	//Sink to a class scope from a class
	@Test
	public void sinkToClassScopeFromClass_Test(){

	}

	//Sink to a class scope from a sage
	@Test 
	public void sinkToClassScopeFromSage_Test(){

	}

	//Sink to a class scope from a method
	//Should throw an InnerScopeException
	@Test
	public void sinkToClassScopeFromMethod_Test(){

	}

	//Sink to class scope from an inner method scope
	//Should throw an InnerScopeException
	@Test
	public void sinkToClassScopeFromInnerMethodScope_Test(){

	}

	/******************************************************************/
	//Tests for sinkToMethodScope()
	/******************************************************************/
	//Sink to a method scope from a class
	@Test
	public void sinkToMethodScopeFromClass_Test(){

	}

	//Sink to a method scope from a sage
	@Test 
	public void sinkToMethodScopeFromSage_Test(){

	}

	//Sink to a method scope from a method
	//Should throw an InnerScopeException
	@Test
	public void sinkToMethodScopeFromMethod_Test(){

	}

	//Sink to a method scope from an inner method scope
	//Should throw an InnerScopeException
	@Test
	public void sinkToMethodScopeFromInnerMethodScope_Test(){
		
	}
	/******************************************************************/
	//Tests for sinkToInnerMethodScope()
	/******************************************************************/
	//Sink to an inner method scope from a class
	//Should throw an InnerScopeException
	@Test
	public void sinkToInnerMethodScopeFromClass_Test(){

	}

	//Sink to an inner method scope from a sage
	//Should throw an InnerScopeException
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

	/******************************************************************/
	//Tests for addMethodScope()
	/******************************************************************/

	/******************************************************************/
	//Tests for getSymbol()
	/******************************************************************/

}