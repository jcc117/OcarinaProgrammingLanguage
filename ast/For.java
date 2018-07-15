package ast;

public class For implements Statement{
	public Expression e;
	public Statement s1;
	public Statement s2;
	public Statement s3;
	public boolean breakPoint;

	public For(Expression e, Statement s1, Statement s2, Statement s3){
		this.e = e;
		this.s1 = s1;
		this.s2 = s2;
		this.s3 = s3;
		breakPoint = false;
	}
}