package ast;

public class Program{
	public StatementList s;
	public DefList d;
	public boolean debug;

	public Program(StatementList s, DefList d, boolean debug){
		this.s = s;
		this.d = d;
		this.debug = debug;
	}
}