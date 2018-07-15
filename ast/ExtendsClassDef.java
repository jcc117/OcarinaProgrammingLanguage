package ast;

public class ExtendsClassDef implements ClassDef{
	public Identifier i;
	public Identifier c;
	public DefList d;
	public VarDeclList v;
	public int protection;
	public ConstructorList o;

	public ExtendsClassDef(Identifier i, Identifier c, DefList d, VarDeclList v, int protection, ConstructorList o){
		this.i = i;
		this.c = c;
		this.d = d;
		this.v = v;
		this.protection = protection;
		this.o = o;
	}
}