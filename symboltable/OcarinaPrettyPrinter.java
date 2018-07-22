package symboltable;

import ast.*;

public class OcarinaPrettyPrinter implements VoidVisitor{
	public OcarinaPrettyPrinter(Sage s){
		visit(s);
	}

	public void visit(Sage s){
		System.out.println("sage " + s.toString() + ";");
	}

	public void visit(Using u){
		System.out.println("using " + u.toString() + ";");
	}

	public void visit(UsingList u){
		for(Using l : u.l){
			l.accept(this);
		}
	}

	public void visit(Program p){
		System.out.println("start");
		p.s.accept(this);
		System.out.println("end");
		p.d.accept(this);
	}

	public void visit(StatementList l){
		for(Statement s : l.l){
			s.accept(this);
		}
	}

	public void visit(DefList d){
		for(Def i : d.l){
			i.accept(this);
		}
	}

	public void visit(SimpleClassDef s){
		String prot = get_protection_level(s.protection);
		System.out.println(prot + " class " + s.i.toString() + ":");
		s.v.accept(this);
		s.c.accept(this);
		s.d.accept(this);
	}

	public void visit(ExtendsClassDef e){
		String prot = get_protection_level(e.protection);
		System.out.println(prot + " class " + e.i.toString() + " extends " + e.c + ":");
		e.v.accept(this);
		e.o.accept(this);
		e.d.accept(this);
	}

	public void visit(ConstructorList c){
		for(Constructor o : c.l){
			o.accept(this);
		}
	}

	public void visit(Constructor c){
		System.out.print("constructor ");
		c.a.accept(this);
		c.l.accept(this);
		System.out.println("end");
	}

	public void visit(MethodDef m){
		String prot = get_protection_level(m.protection);
		System.out.print(prot + m.r.toString() + " subroutine " + m.i.toString());
		System.out.println(":");
		m.s.accept(this);
		System.out.println("end");
	}

	public void visit(VarDeclList l){

	}

	public void visit(VarDecl v){

	}

	public void visit(ArgList a){

	}

	public void visit(Param p){

	}

	public void visit(ArrayType t){

	}

	public void visit(IntType t){

	}

	public void visit(FloatType t){

	}

	public void visit(BooleanType t){

	}

	public void visit(StringType t){

	}

	public void visit(HashmapType t){

	}

	public void visit(VoidType t){

	}

	public void visit(Block b){

	}

	public void visit(If i){

	}

	public void visit(While w){

	}

	public void visit(For f){

	}

	public void visit(DoWhile d){

	}

	public void visit(Print p){

	}

	public void visit(VarDecAssignment v){

	}

	public void visit(Assignment a){

	}

	public void visit(HashmapAssignment h){

	}

	public void visit(ArrayAssignment a){

	}

	public void visit(Return r){

	}

	public void visit(Assert a){

	}

	public void visit(Exit e){

	}

	public void visit(Break b){

	}

	public void visit(Continue c){

	}

	public void visit(Increment i){

	}

	public void visit(Decrement d){

	}

	public void visit(RatherList l){

	}

	public void visit(Rather r){

	}

	public void visit(And a){

	}

	public void visit(Or o){

	}

	public void visit(Nand n){

	}

	public void visit(Nor n){

	}

	public void visit(Equals e){

	}

	public void visit(Plus p){

	}

	public void visit(Minus m){

	}

	public void visit(Multiply m){

	}

	public void visit(Power p){

	}

	public void visit(Divide d){

	}

	public void visit(Modulo m){

	}

	public void visit(GreaterThanEqualTo g){

	}

	public void visit(LessThanEqualTo l){

	}

	public void visit(GreaterThan g){

	}

	public void visit(LessThan l){

	}

	public void visit(HashmapExpr h){

	}

	public void visit(ArrayExpr a){

	}

	public void visit(ObjectVarAccess o){

	}

	public void visit(MethodCall m){

	}

	public void visit(ArrayLength l){

	}

	public void visit(IntLiteral i){

	}

	public void visit(FloatLiteral f){

	}

	public void visit(True t){

	}

	public void visit(False f){

	}

	public void visit(Nil n){

	}

	public void visit(ParentExpr p){

	}

	public void visit(Not n){

	}

	public void visit(IdentifierExpr i){

	}

	public void visit(ObjectCreate o){

	}

	public void visit(This t){

	}

	public void visit(GetInt g){

	}

	public void visit(GetFloat f){

	}

	public void visit(GetBoolean t){

	}

	public void visit(GetString s){

	}

	public void visit(ArrayCreate a){

	}

	public void visit(HashmapCreate h){

	}

	public void visit(StringLiteral s){

	}

	public void visit(ParamList p){

	}

	public void visit(Identifier i){

	}

	public void visit(IdentifierType i){

	}

	public void visit(Statement s){
		
	}

	private String get_protection_level(int i){
		String prot = "";
		switch (i){
			case 0:
				prot = "private";
				break;
			case 1:
				prot = "";
				break;
			case 2:
				prot = "protected";
				break;
			case 3:
				prot = "public";
				break;
		}
		return prot;
	}
}