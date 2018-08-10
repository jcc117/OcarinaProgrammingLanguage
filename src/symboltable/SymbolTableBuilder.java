package symboltable;

import ast.*;

public class SymbolTableBuilder implements Visitor{
	private SymbolTable symboltable;
	public boolean hadErrors;

	public SymbolTableBuilder(){
		symboltable = null;
		hadErrors = false;
	}

	//Set force to true to force a new rebuild if the table is already built 
	public SymbolTable build(Sage s, boolean force){
		if(symboltable == null || force){
			symboltable = new SymbolTable((SageSym)s.accept(this));
		}
		return symboltable;
	}

	public Sym visit(Sage s){
		
	}

	public Sym visit(Using u){

	}

	public Sym visit(UsingList u){

	}

	public Sym visit(Program p){

	}

	public Sym visit(StatementList l){

	}

	public Sym visit(DefList d){

	}

	//&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
	//Defs
	public Sym visit(SimpleClassDef s){

	}

	public Sym visit(ExtendsClassDef e){

	}

	public Sym visit(ConstructorList c){

	}

	public Sym visit(ExceptionDef e){

	}

	public Sym visit(Constructor c){

	}

	public Sym visit(MethodDef m){

	}

	public Sym visit(VarDeclList l){

	}

	public Sym visit(VarDecl v){

	}

	public Sym visit(ArgList a){

	}

	public Sym visit(Param p){

	}

	//***************************************************************************************
	//Types
	public Sym visit(ArrayType t){

	}

	public Sym visit(IntType t){

	}

	public Sym visit(FloatType t){

	}

	public Sym visit(BooleanType t){

	}

	public Sym visit(StringType t){

	}

	public Sym visit(HashmapType t){

	}

	public Sym visit(VoidType t){

	}

	public Sym visit(VarType v){

	}

	//=======================================================================================================================
	//Statements
	public Sym visit(Block b){

	}

	public Sym visit(If i){

	}

	public Sym visit(While w){

	}

	public Sym visit(For f){

	}

	public Sym visit(DoWhile d){

	}

	public Sym visit(Print p){

	}

	public Sym visit(VarDecAssignment v){

	}

	public Sym visit(Assignment a){

	}

	public Sym visit(HashmapAssignment h){

	}

	public Sym visit(ArrayAssignment a){

	}

	public Sym visit(Return r){

	}

	public Sym visit(Assert a){

	}

	public Sym visit(Exit e){

	}

	public Sym visit(Break b){

	}	

	public Sym visit(Continue c){

	}

	public Sym visit(Increment i){

	}

	public Sym visit(Decrement d){

	}

	public Sym visit(RatherList l){

	}

	public Sym visit(Rather r){

	}

	public Sym visit(MethodCallStatement m){

	}
	
	public Sym visit(Super s){

	}
	
	public Sym visit(Until u){

	}
	
	public Sym visit(Unless u){

	}

	public Sym visit(Throw t){

	}
	
	public Sym visit(TryCatch t){

	}
	
	public Sym visit(Catch c){

	}

	//-----------------------------------------------------------------------------------------------------
	//Expressions
	public Type visit(And a){

	}

	public Type visit(Or o){

	}

	public Type visit(Nand n){

	}

	public Type visit(Nor n){

	}

	public Type visit(Equals e){

	}

	public Type visit(Plus p){

	}

	public Type visit(Minus m){

	}

	public Type visit(Multiply m){

	}

	public Type visit(Power p){

	}

	public Type visit(Divide d){

	}

	public Type visit(Modulo m){

	}

	public Type visit(GreaterThanEqualTo g){

	}

	public Type visit(LessThanEqualTo l){

	}

	public Type visit(GreaterThan g){

	}

	public Type visit(LessThan l){

	}

	public Type visit(HashmapExpr h){

	}

	public Type visit(ArrayExpr a){

	}

	public Type visit(ObjectVarAccess o){

	}

	public Type visit(MethodCall m){

	}

	public Type visit(ArrayLength l){

	}

	public Type visit(IntLiteral i){

	}

	public Type visit(FloatLiteral f){

	}

	public Type visit(True t){

	}

	public Type visit(False f){

	}

	public Type visit(Nil n){

	}

	public Type visit(ParentExpr p){

	}

	public Type visit(Not n){

	}

	public Type visit(IdentifierExpr i){

	}

	public Type visit(ObjectCreate o){

	}

	public Type visit(This t){

	}

	public Type visit(ArrayCreate a){

	}

	public Type visit(HashmapCreate h){

	}

	public Type visit(StringLiteral s){

	}

	public Type visit(ParamList p){

	}

	public Type visit(Identifier i){

	}

	public Type visit(IdentifierType i){

	}

	public Type visit(Typeof t){

	}

	public Type visit(UnaryMinus u){

	}

	public Type visit(Differs d){

	}

	public Type visit(MethodLiteral m){

	}

	public Type visit(ArrayLiteral a){

	}
	//------------------------------------------------------------------------------------------------------
	public Sym visit(Statement s){

	}
	
	public Type visit(Type t){

	}
	
	public Type visit(Expression e){

	}
	
	public Sym visit(IdChain i){

	}
	
	public Sym visit(MethodType m){

	}
	
	public Sym visit(ArgChain a){

	}
	
	public Sym visit(ExprChain e){

	}
	
	public Sym visit(CatchList c){

	}
	
}