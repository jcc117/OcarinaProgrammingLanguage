package symboltable;
import ast.*;
import java.util.Stack;
import java.util.ArrayList;

public class SymbolTableBuilderPass1 implements Visitor{

	private SymbolTable table;
	private StringBuilder path;
	private Stack<PathCounterStruct> counterStack;
	private Stack<Sym.ProtectionLevel> protectionStack;

	public SymbolTableBuilderPass1(SymbolTable table){
		this.table = table;
		this.path = new StringBuilder();
		this.counterStack = new Stack<PathCounterStruct>();
		this.protectionStack = new Stack<Sym.ProtectionLevel>();
	}

	//Run through the ast again
	public void build(Sage sage){
		sage.accept(this);
	}

	//Setup for walking through tree goes here

}