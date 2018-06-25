package ast;

public class ObjectCreate extends Expression{
	ParamList l;

	public ObjectCreate(ParamList l){
		this.l = l;
	}
}