package test;
import ast.*;
import symboltable.*;
import junit.framework.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class SymbolTableTestRunner{
	private SymbolTable testTable;

	@Test
	public void setup(){
		testTable = new SymbolTable();
		testTable.setRoot(FakeSymbolTable.buildFakeSymbolTree());
	}

	public void tearDown(){
		testTable = null;
	}
}