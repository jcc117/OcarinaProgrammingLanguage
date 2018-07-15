package ast;

public class Increment extends Statement{
	public Identifier i;

	public Increment(Identifier i){
		this.i = i;
		breakPoint = false;
	}
}