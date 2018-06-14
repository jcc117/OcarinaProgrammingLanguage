package ast;

public class SimpleClassDef implements ClassDef{
	public Identifier i;
	public DefList d;
	public VarDeclList v;
	public SimpleClassDef(Identifier i, DefList d, VarDeclList v){
		this.i = i;
		this.d = d;
		this.v = v;
	}
}