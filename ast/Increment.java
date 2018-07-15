package ast;

public class Increment implements Statement{
	public Identifier i;
	public boolean breakPoint;

	public Increment(Identifier i){
		this.i = i;
		breakPoint = false;
	}
}