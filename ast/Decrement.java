package ast;

public class Decrement extends Statement{
	public Identifier i;

	public Decrement(Identifier i){
		this.i = i;
		breakPoint = false;
	}
}