package ast;

public class ObjectCreate extends Expression{
	public ParamList l;
	public Identifier i;

	public ObjectCreate(Identifier i, ParamList l){
		this.l = l;
		this.i = i;
	}
}