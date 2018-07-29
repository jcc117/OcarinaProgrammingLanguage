package symboltable;

import java.util.HashMap;
import ast.*;

public class MethodSym extends Sym{
	public HashMap<String, Sym> variables;
	public String name;
	public int protection;
	public Type returnType;
	public int line;
	public Sym parent;

	public MethodSym(String name, int line, int protection, Type returnType, Sym parent){
		this.name = name;
		this.line = line;
		this.protection = protection;
		this.returnType = returnType;
		this.parent = parent;
		variables = new HashMap<String, Sym>();
	}

	public void put(String name, Sym symbol){
		variables.put(name, symbol);
	}

	public Sym get(String name){
		return variables.get(name);
	}
}