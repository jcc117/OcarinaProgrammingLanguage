package symboltable;

import ast.*;

public class OcarinaPrettyPrinter implements VoidVisitor{
	public OcarinaPrettyPrinter(Sage s){
		visit(s);
	}

	public void visit(Sage s){
		System.out.print("sage ");
		s.i.accept(this);
		System.out.println(";");
		s.u.accept(this);
		if(s.p == null){
			s.d.accept(this);
		}
		else{
			s.p.accept(this);
		}
	}

	public void visit(Using u){
		System.out.print("using ");
		u.i.accept(this);
		System.out.println(";");
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
		System.out.print(prot + " class ");
		s.i.accept(this);
		System.out.println(":");
		s.v.accept(this);
		s.c.accept(this);
		s.d.accept(this);
	}

	public void visit(ExtendsClassDef e){
		String prot = get_protection_level(e.protection);
		System.out.print(prot + " class ");
		e.i.accept(this);
		System.out.print(" extends ");
		e.c.accept(this); 
		System.out.println(":");
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
		t.t.accept(this);
		System.out.print("[]");
	}

	public void visit(IntType t){
		System.out.print("int");
	}

	public void visit(FloatType t){
		System.out.print("float");
	}

	public void visit(BooleanType t){
		System.out.print("boolean");
	}

	public void visit(StringType t){
		System.out.print("string");
	}

	public void visit(HashmapType t){
		System.out.print("hashmap{");
		t.t1.accept(this);
		System.out.print(", ");
		t.t2.accept(this);
		System.out.print("}");
	}

	public void visit(VoidType t){
		System.out.print("void");
	}

	public void visit(Block b){
		System.out.println("begin");
		b.l.accept(this);
		System.out.println("end");
	}

	public void visit(If i){
		System.out.print("if ");
		i.e.accept(this);
		System.out.println(":");
		i.s1.accept(this);
		i.r.accept(this);
		i.s2.accept(this);
	}

	public void visit(While w){
		System.out.print("while ");
		w.e.accept(this);
		System.out.println(":");
		w.s.accept(this);
		System.out.println("end");
	}

	public void visit(For f){

	}

	public void visit(DoWhile d){
		System.out.println("do");
		d.s.accept(this);
		System.out.println("end");
		System.out.print("while ");
		d.e.accept(this);
		System.out.println(";");
	}

	public void visit(Print p){
		System.out.print("print(");
		p.e.accept(this);
		System.out.println(");");
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
		i.i.accept(this);
		System.out.println("++;");
	}

	public void visit(Decrement d){
		d.i.accept(this);
		System.out.println("--;");
	}

	public void visit(RatherList l){

	}

	public void visit(Rather r){

	}

	public void visit(And a){
		a.e1.accept(this);
		System.out.print(" and ");
		a.e2.accept(this);
	}

	public void visit(Or o){
		o.e1.accept(this);
		System.out.print(" or ");
		o.e2.accept(this);
	}

	public void visit(Nand n){
		n.e1.accept(this);
		System.out.print(" nand ");
		n.e2.accept(this);
	}

	public void visit(Nor n){
		n.e1.accept(this);
		System.out.print(" nor ");
		n.e2.accept(this);
	}

	public void visit(Equals e){
		e.e1.accept(this);
		System.out.print(" equals ");
		e.e2.accept(this);
	}

	public void visit(Plus p){
		p.e1.accept(this);
		System.out.print(" + ");
		p.e2.accept(this);
	}

	public void visit(Minus m){
		m.e1.accept(this);
		System.out.print(" - ");
		m.e2.accept(this);
	}

	public void visit(Multiply m){
		m.e1.accept(this);
		System.out.print(" * ");
		m.e2.accept(this);
	}

	public void visit(Power p){
		p.e1.accept(this);
		System.out.print(" ^ ");
		p.e2.accept(this);
	}

	public void visit(Divide d){
		d.e1.accept(this);
		System.out.print(" / ");
		d.e2.accept(this);
	}

	public void visit(Modulo m){
		m.e1.accept(this);
		System.out.print(" % ");
		m.e2.accept(this);
	}

	public void visit(GreaterThanEqualTo g){
		g.e1.accept(this);
		System.out.print(" >= ");
		g.e2.accept(this);
	}

	public void visit(LessThanEqualTo l){
		l.e1.accept(this);
		System.out.print(" <= ");
		l.e2.accept(this);
	}

	public void visit(GreaterThan g){
		g.e1.accept(this);
		System.out.print(" > ");
		g.e2.accept(this);
	}

	public void visit(LessThan l){
		l.e1.accept(this);
		System.out.print(" < ");
		l.e2.accept(this);
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
		System.out.print(".length");
	}

	public void visit(IntLiteral i){
		System.out.print(i.i.toString());
	}

	public void visit(FloatLiteral f){
		System.out.print(f.f.toString());
	}

	public void visit(True t){
		System.out.print("true");
	}

	public void visit(False f){
		System.out.print("false");
	}

	public void visit(Nil n){
		System.out.print("nil");
	}

	public void visit(ParentExpr p){
		System.out.print("(");
		p.e.accept(this);
		System.out.print(")");
	}

	public void visit(Not n){
		System.out.print("!");
		n.e.accept(this);
	}

	public void visit(IdentifierExpr i){
		i.i.accept(this);
	}

	public void visit(ObjectCreate o){
		System.out.print("create ");
		o.i.accept(this);
		System.out.print("(");
		o.l.accept(this);
		System.out.print(")");
	}

	public void visit(This t){
		System.out.print("this");
	}

	public void visit(GetInt g){
		System.out.print("getInt()");
	}

	public void visit(GetFloat f){
		System.out.print("getFloat");
	}

	public void visit(GetBoolean t){
		System.out.print("getBoolean()");
	}

	public void visit(GetString s){
		System.out.print("getString()");
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
		System.out.print(i.i);
	}

	public void visit(IdentifierType i){
		i.i.accept(this);
	}

	public void visit(Statement s){

	}

	public void visit(Type t){

	}

	public void visit(Expression e){

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