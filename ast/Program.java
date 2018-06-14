package ast;

public class Program{
	public StatementList s;
	public DefList d;

	public Program(StatementList s, DefList d){
		this.s = s;
		this.d = d;
	}
}