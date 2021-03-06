package symboltable;

import ast.*;
import java.util.ArrayList;

public interface Visitor{
	public void visit(Sage s);
	public void visit(Using u);
	public void visit(UsingList u);
	public void visit(Program p);
	public void visit(StatementList l);
	public void visit(DefinitionList d);
	public void visit(PublicList p);
	public void visit(PrivateList p);
	public void visit(ProtectedList p);
	public void visit(DefWrapper d);
	public void visit(Definition d);
	public void visit(DefList d);
	public void visit(SimpleClassDef s);
	public void visit(ExtendsClassDef e);
	public void visit(Constructor c);
	public void visit(MethodDef m);
	public void visit(VarDecl v);
	public void visit(ArgList a);
	public void visit(Param p);
	public TypeSym visit(ArrayType t);
	public TypeSym visit(IntType t);
	public TypeSym visit(FloatType t);
	public TypeSym visit(BooleanType t);
	public TypeSym visit(StringType t);
	public TypeSym visit(HashmapType t);
	public TypeSym visit(VoidType t);
	public TypeSym visit(VarType v);
	public void visit(Block b);
	public void visit(If i);
	public void visit(While w);
	public void visit(For f);
	public void visit(Foreach f);
	public void visit(DoWhile d);
	public void visit(Print p);
	public void visit(VarDecAssignment v);
	public void visit(Assignment a);
	public void visit(HashmapAssignment h);
	public void visit(ArrayAssignment a);
	public void visit(Return r);
	public void visit(Assert a);
	public void visit(Exit e);
	public void visit(Break b);	
	public void visit(Continue c);
	public void visit(Increment i);
	public void visit(Decrement d);
	public void visit(RatherList l);
	public void visit(Rather r);
	public TypeSym visit(And a);
	public TypeSym visit(Or o);
	public TypeSym visit(Nand n);
	public TypeSym visit(Nor n);
	public TypeSym visit(Equals e);
	public TypeSym visit(Plus p);
	public TypeSym visit(Minus m);
	public TypeSym visit(Multiply m);
	public TypeSym visit(Power p);
	public TypeSym visit(Divide d);
	public TypeSym visit(Modulo m);
	public TypeSym visit(GreaterThanEqualTo g);
	public TypeSym visit(LessThanEqualTo l);
	public TypeSym visit(GreaterThan g);
	public TypeSym visit(LessThan l);
	public TypeSym visit(HashmapExpr h);
	public TypeSym visit(ArrayExpr a);
	public TypeSym visit(ObjectVarAccess o);
	public TypeSym visit(MethodCall m);
	public TypeSym visit(ArrayLength l);
	public TypeSym visit(IntLiteral i);
	public TypeSym visit(FloatLiteral f);
	public TypeSym visit(True t);
	public TypeSym visit(False f);
	public TypeSym visit(Nil n);
	public TypeSym visit(ParentExpr p);
	public TypeSym visit(Not n);
	public TypeSym visit(IdentifierExpr i);
	public TypeSym visit(ObjectCreate o);
	public TypeSym visit(This t);
	public TypeSym visit(ArrayCreate a);
	public TypeSym visit(HashmapCreate h);
	public TypeSym visit(StringLiteral s);
	public TypeSym visit(ParamList p);
	public TypeSym visit(Identifier i);	
	public TypeSym visit(IdentifierType i);
	public void visit(Statement s);
	public TypeSym visit(Type t);
	public TypeSym visit(Expression e);
	public TypeSym visit(ArrayLiteral a);
	public ArrayList<String> visit(IdChain i);
	public void visit(MethodCallStatement m);
	public TypeSym visit(UnaryMinus u);
	public void visit(Super s);
	public void visit(Until u);
	public void visit(Unless u);
	public TypeSym visit(Typeof t);
	public TypeSym visit(Differs d);
	public TypeSym visit(MethodLiteral m);
	public ArrayList<Param> visit(ArgChain a);
	public void visit(ExprChain e);
	public void visit(Throw t);
	public void visit(TryCatch t);
	public void visit(Catch c);
	public void visit(CatchList c);
	public TypeSym visit(PostIncrement p);
	public TypeSym visit(PreIncrement p);
	public TypeSym visit(PostDecrement p);
	public TypeSym visit(PreDecrement p);
}