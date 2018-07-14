package ast;

public class Block implements Statement{
	public StatementList l;

	public Block(StatementList l){
		this.l = l;
	}
}