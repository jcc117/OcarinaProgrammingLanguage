package ast;

public class ExtendsClassDef{
	public Identifier i;
	public ClassDef c;
	public DefList d;
	public VarDeclList v;

	public ExtendsClassDef(Identifier i, ClassDef c, DefList d, VarDeclList v){
		this.i = i;
		this.c = c;
		this.d = d;
		this.v = v;
	}
}