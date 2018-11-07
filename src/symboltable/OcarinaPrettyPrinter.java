package symboltable;

import ast.*;

public class OcarinaPrettyPrinter implements VoidVisitor{
	private int tabs;
	public OcarinaPrettyPrinter(){
		tabs = 0;
	}

	public void print(Sage s){
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
		u.chain.accept(this);
		System.out.println(";");
	}

	public void visit(UsingList u){
		for(Using l : u.l){
			l.accept(this);
		}
	}

	public void visit(Program p){
		System.out.println("start");
		tabs++;
		p.s.accept(this);
		tabs--;
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

	public void visit(DefinitionList d){
		for(Definition def : d.defs){
			def.accept(this);
		}
	}

	public void visit(PublicList p){
		printTabs();
		System.out.println("public");
		tabs++;
		p.defList.accept(this);
		tabs--;
		printTabs();
		System.out.println("end");
	}

	public void visit(PrivateList p){
		printTabs();
		System.out.println("private");
		tabs++;
		p.defList.accept(this);
		tabs--;
		printTabs();
		System.out.println("end");
	}
	public void visit(ProtectedList p){
		printTabs();
		System.out.println("protected");
		tabs++;
		p.defList.accept(this);
		tabs--;
		printTabs();
		System.out.println("end");
	}

	public void visit(DefWrapper d){
		d.item.accept(this);
	}

	public void visit(Definition d){

	}

	public void visit(SimpleClassDef s){
		printTabs();
		if(s.is_static)
			System.out.print(" static");
		System.out.print(" class ");
		s.i.accept(this);
		System.out.println(":");
		tabs++;
		s.d.accept(this);
		tabs--;
		printTabs();
		System.out.println("end");
	}

	public void visit(ExtendsClassDef e){
		printTabs();
		if(e.is_static)
			System.out.print(" static");
		System.out.print(" class ");
		e.i.accept(this);
		System.out.print(" extends ");
		e.c.accept(this); 
		System.out.println(":");
		tabs++;
		e.d.accept(this);
		tabs--;
		printTabs();
		System.out.println("end");
	}

	public void visit(Constructor c){
		printTabs();
		System.out.print("constructor(");
		c.a.accept(this);
		System.out.println("):");
		tabs++;
		c.l.accept(this);
		tabs--;
		printTabs();
		System.out.println("end");
	}

	public void visit(MethodDef m){
		printTabs();
		if(m.is_static)
			System.out.print("static ");
		System.out.print("function ");
		m.r.accept(this);
		System.out.print(" ");
		m.i.accept(this);
		System.out.print("(");
		m.a.accept(this);
		System.out.println("):");
		tabs++;
		m.s.accept(this);
		tabs--;
		printTabs();
		System.out.println("end");
	}

	public void visit(VarDecl v){
		printTabs();
		if(v.is_static){
			System.out.print("static ");
		}
		v.t.accept(this);
		System.out.print(" ");
		v.i.accept(this);
		System.out.println(";");
	}

	public void visit(ArgList a){
		if(a.p != null){
			a.p.accept(this);
			a.chain.accept(this);
		}
	}

	public void visit(Param p){
		p.t.accept(this);
		System.out.print(" ");
		p.i.accept(this);
	}

	public void visit(ArrayType t){
		if(t.constant)
			System.out.print("const ");
		t.t.accept(this);
		System.out.print("[]");
	}

	public void visit(IntType t){
		if(t.constant)
			System.out.print("const ");
		System.out.print("int");
	}

	public void visit(FloatType t){
		if(t.constant)
			System.out.print("const ");
		System.out.print("decimal");
	}

	public void visit(BooleanType t){
		if(t.constant)
			System.out.print("const ");
		System.out.print("boolean");
	}

	public void visit(StringType t){
		if(t.constant)
			System.out.print("const ");
		System.out.print("string");
	}

	public void visit(HashmapType t){
		if(t.constant)
			System.out.print("const ");
		System.out.print("hashmap{");
		t.t1.accept(this);
		System.out.print(", ");
		t.t2.accept(this);
		System.out.print("}");
	}

	public void visit(MethodType m){
		if(m.constant)
			System.out.print("const ");
		System.out.print("function{");
		m.t.accept(this);
		System.out.print("}");
	}

	public void visit(VoidType t){
		System.out.print("void");
	}

	public void visit(Block b){
		printTabs();
		System.out.println("begin");
		tabs++;
		b.l.accept(this);
		tabs--;
		printTabs();
		System.out.println("end");
	}

	public void visit(If i){
		printTabs();
		System.out.print("if ");
		i.e.accept(this);
		System.out.println(":");
		tabs++;
		i.s1.accept(this);
		tabs--;
		i.r.accept(this);
		if(i.s2 != null){
			printTabs();
			System.out.println("else:");
			tabs++;
			i.s2.accept(this);
			tabs--;
		}
		printTabs();
		System.out.println("end");
	}

	public void visit(While w){
		printTabs();
		System.out.print("while ");
		w.e.accept(this);
		System.out.println(":");
		tabs++;
		w.s.accept(this);
		tabs--;
		printTabs();
		System.out.println("end");
	}

	public void visit(For f){
		printTabs();
		System.out.print("for(");
		f.s1.accept(this);
		f.e.accept(this);
		System.out.print("; ");
		f.s2.accept(this);
		System.out.println("):");
		tabs++;
		f.s3.accept(this);
		tabs--;
		printTabs();
		System.out.println("end");
	}

	public void visit(Foreach f){
		printTabs();
		System.out.print("foreach ");
		f.t.accept(this);
		System.out.print(" ");
		f.i1.accept(this);
		System.out.print(" in ");
		f.i2.accept(this);
		f.chain.accept(this);
		System.out.println(":");
		tabs++;
		f.s.accept(this);
		tabs--;
		printTabs();
		System.out.println("end");
	}

	public void visit(DoWhile d){
		printTabs();
		System.out.println("do:");
		tabs++;
		d.s.accept(this);
		tabs--;
		printTabs();
		System.out.println("end");
		printTabs();
		System.out.print("while ");
		d.e.accept(this);
		System.out.println(";");
	}

	public void visit(Print p){
		printTabs();
		System.out.print("print(");
		p.e.accept(this);
		System.out.println(");");
	}

	public void visit(VarDecAssignment v){
		printTabs();
		if(v.is_static){
			System.out.print("static ");
		}
		v.t.accept(this);
		System.out.print(" ");
		v.i.accept(this);
		System.out.print(" = ");
		v.e.accept(this);
		System.out.println(";");
	}

	public void visit(Assignment a){
		printTabs();
		a.i.accept(this);
		a.chain.accept(this);
		System.out.print(" = ");
		a.e.accept(this);
		System.out.println(";");
	}

	public void visit(HashmapAssignment h){
		printTabs();
		h.i.accept(this);
		h.chain.accept(this);
		System.out.print("{");
		h.e1.accept(this);
		System.out.print("} = ");
		h.e2.accept(this);
		System.out.println(";");
	}

	public void visit(ArrayAssignment a){
		printTabs();
		a.i.accept(this);
		a.chain.accept(this);
		System.out.print("[");
		a.e1.accept(this);
		System.out.print("] = ");
		a.e2.accept(this);
		System.out.println(";");
	}

	public void visit(Return r){
		printTabs();
		System.out.print("return ");
		r.e.accept(this);
		System.out.println(";");
	}

	public void visit(Assert a){
		printTabs();
		System.out.print("assert ");
		a.e.accept(this);
		System.out.println(";");
	}

	public void visit(Exit e){
		printTabs();
		System.out.print("exit(");
		e.e.accept(this);
		System.out.println(");");
	}

	public void visit(Break b){
		printTabs();
		System.out.println("break;");
	}

	public void visit(Continue c){
		printTabs();
		System.out.println("continue;");
	}

	public void visit(Increment i){
		printTabs();
		if(i.i != null)
			i.i.accept(this);
		else
			i.t.accept(this);
		i.chain.accept(this);
		System.out.println("++;");
	}

	public void visit(Decrement d){
		printTabs();
		if(d.i != null)
			d.i.accept(this);
		else
			d.t.accept(this);
		d.chain.accept(this);
		System.out.println("--;");
	}

	public void visit(RatherList l){
		for(Rather s : l.l){
			s.accept(this);
		}
	}

	public void visit(Rather r){
		printTabs();
		System.out.print("rather ");
		r.e.accept(this);
		System.out.println(":");
		tabs++;
		r.s.accept(this);
		tabs--;
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

	public void visit(Differs d){
		d.e1.accept(this);
		System.out.print(" differs ");
		d.e2.accept(this);
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
		h.e1.accept(this);
		System.out.print("{");
		h.e2.accept(this);
		System.out.print("}");
	}

	public void visit(ArrayExpr a){
		a.e1.accept(this);
		System.out.print("[");
		a.e2.accept(this);
		System.out.print("]");
	}

	public void visit(ObjectVarAccess o){
		o.e.accept(this);
		o.i.accept(this);
	}

	public void visit(MethodCall m){
		m.e.accept(this);
		System.out.print("(");
		m.l.accept(this);
		System.out.print(")");
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
		o.chain.accept(this);
		System.out.print("(");
		o.l.accept(this);
		System.out.print(")");
	}

	public void visit(This t){
		System.out.print("this");
	}

	public void visit(ArrayCreate a){
		System.out.print("create ");
		a.t.accept(this);
		System.out.print("[");
		a.e.accept(this);
		System.out.print("]");
	}

	public void visit(ArrayLiteral a){
		System.out.print("create ");
		a.t.accept(this);
		System.out.print("[]{");
		a.l.accept(this);
		System.out.print("}");
	}

	public void visit(HashmapCreate h){
		System.out.print("hashmap {");
		h.t1.accept(this);
		System.out.print(", ");
		h.t2.accept(this);
		System.out.print("}");
	}

	public void visit(StringLiteral s){
		System.out.print(s.s);
	}

	public void visit(ParamList p){
		if(p.e != null){
			p.e.accept(this);
			p.chain.accept(this);
		}
	}

	public void visit(Identifier i){
		System.out.print(i.i);
	}

	public void visit(IdentifierType i){
		i.i.accept(this);
		i.chain.accept(this);
	}

	public void visit(IdChain i){
		for(Identifier id : i.chain){
			System.out.print(".");
			id.accept(this);
		}
	}

	public void visit(MethodCallStatement m){
		printTabs();
		System.out.print("exec ");
		m.method.accept(this);
		System.out.println(";");
	}

	public void visit(UnaryMinus u){
		System.out.print("-");
		u.e.accept(this);
	}

	public void visit(Super s){
		printTabs();
		System.out.println("super();");
	}

	public void visit(Unless u){
		printTabs();
		System.out.print("unless ");
		u.e.accept(this);
		System.out.println(":");
		tabs++;
		u.s.accept(this);
		tabs--;
		printTabs();
		System.out.println("end");
	}

	public void visit(Until u){
		printTabs();
		System.out.print("until ");
		u.e.accept(this);
		System.out.println(":");
		tabs++;
		u.s.accept(this);
		tabs--;
		printTabs();
		System.out.println("end");
	}

	public void visit(VarType v){
		if(v.constant)
			System.out.print("const ");
		System.out.print("var ");
	}

	public void visit(Typeof t){
		t.i.accept(this);
		t.chain.accept(this);
		System.out.print(" typeof ");
		t.t.accept(this);
	}

	public void visit(MethodLiteral m){
		System.out.print("delegate(");
		m.p.accept(this);
		System.out.print("):");
		m.returnType.accept(this);
		System.out.println(" => {");
		tabs++;
		m.s.accept(this);
		tabs--;
		printTabs();
		System.out.print("}");
	}

	public void visit(ArgChain a){
		for(Param p : a.l){
			System.out.print(", ");
			p.accept(this);
		}
	}

	public void visit(ExprChain e){
		for(Expression ex : e.l){
			System.out.print(", ");
			ex.accept(this);
		}
	}

	public void visit(TryCatch t){
		printTabs();
		System.out.println("try:");
		tabs++;
		t.l.accept(this);
		tabs--;
		t.c.accept(this);
		if(t.f.l.size() > 0){
			printTabs();
			System.out.println("finally:");
			tabs++;
			t.f.accept(this);
			tabs--;
		}
		printTabs();
		System.out.println("end");
	}

	public void visit(Catch c){
		printTabs();
		System.out.print("catch ");
		c.i.accept(this);
		c.chain.accept(this);
		c.i2.accept(this);
		System.out.println(":");
		tabs++;
		c.s.accept(this);
		tabs--;
	}

	public void visit(CatchList c){
		for(Catch ca : c.l){
			ca.accept(this);
		}
	}

	public void visit(Throw t){
		printTabs();
		System.out.print("throw ");
		t.e.accept(this);
		System.out.println(";");
	}

	public void visit(PostIncrement p){
		if(p.i != null)
			p.i.accept(this);
		else
			p.t.accept(this);
		p.chain.accept(this);
		System.out.print("++");
	}

	public void visit(PreIncrement p){
		System.out.print("++");
		if(p.i != null)
			p.i.accept(this);
		else
			p.t.accept(this);
		p.chain.accept(this);
	}

	public void visit(PostDecrement p){
		if(p.i != null)
			p.i.accept(this);
		else
			p.t.accept(this);
		p.chain.accept(this);
		System.out.print("--");
	}

	public void visit(PreDecrement p){
		System.out.print("--");
		if(p.i != null)
			p.i.accept(this);
		else
			p.t.accept(this);
		p.chain.accept(this);
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

	private void printTabs(){
		for(int i = 0; i < tabs; i++){
			System.out.print("\t");
		}
	}
}