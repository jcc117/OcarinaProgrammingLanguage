package ast;
import symboltable.*;

public interface Def{
	public void accept(VoidVisitor v);

	public Sym accept(Visitor v);
}