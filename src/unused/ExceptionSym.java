package symboltable;

import ast.*;

public class ExceptionSym extends Sym{
	public String name;
	public int protection;
	public String printValue;
	public int line;
	public Sym parent;

	public ExceptionSym(String name, String printValue, int protection, int line, Sym parent){
		this.name =name;
		this.printValue = printValue;
		this.protection = protection;
		this.line = line;
		this.parent = parent;
	}
}