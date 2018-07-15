package ast;

public class Constructor{
	public StatementList l;
	public ArgList a;

	public Constructor(ArgList a, StatementList l){
		this.l = l;
		this.a = a;
	}
}