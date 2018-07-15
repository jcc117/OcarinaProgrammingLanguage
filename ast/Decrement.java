package ast;

public class Decrement implements Statement{
	public Identifier i;
	public boolean breakPoint;

	public Decrement(Identifier i){
		this.i = i;
		breakPoint = false;
	}
}