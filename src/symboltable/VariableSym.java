package symboltable;

import ast.*;

public class VariableSym extends Sym{
	public String name;
	public int protection;
	public Type t;
	public int line;
	public Sym parent;

	public VariableSym(String name, int line, Type t, int protection, Sym parent){
		this.name = name;
		this.line = line;
		this.t = t;
		this.protection = protection;
		this.parent = parent;
	}
}