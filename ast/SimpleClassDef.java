package ast;
import symboltable.*;

public class SimpleClassDef implements ClassDef{
	public Identifier i;
	public DefList d;
	public VarDeclList v;
	public int protection;
	public ConstructorList c;

	public SimpleClassDef(Identifier i, DefList d, VarDeclList v, int protection, ConstructorList c){
		this.i = i;
		this.d = d;
		this.v = v;
		this.protection = protection;
		this.c = c;
	}

	public void accept(VoidVisitor v){
		v.visit(this);
	}

	public Sym accept(Visitor v){
		return v.visit(this);
	}
}