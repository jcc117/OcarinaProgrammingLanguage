package ast;

public class Block extends Statement{
	public StatementList l;

	public Block(StatementList l){
		this.l = l;
		this.breakPoint = false;
	}
}