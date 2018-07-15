package ast;

public class Sage{
	public Identifier i;
	public DefList d;
	public Program p;

	public Sage(Identifier i, DefList d){
		this.i = i;
		this.d = d;
		this.p = null;
	}

	public Sage(Identifier i, Program p){
		this.i = i;
		this.p = p;
		this.d = null;
	}
}