package symboltable;

import ast.*;

public class SymbolTableBuilder implements Visitor{
	private SymbolTable symboltable;
	public boolean hadErrors;
	private Sym current;

	public SymbolTableBuilder(){
		symboltable = null;
		hadErrors = false;
		current = null;
	}

	//Set force to true to force a new rebuild if the table is already built 
	public SymbolTable build(Sage s, boolean force){
		if(symboltable == null || force){
			symboltable = new SymbolTable((SageSym)s.accept(this));
		}
		return symboltable;
	}

	public Sym visit(Sage s){
		SageSym root = new SageSym(s.line, s.i.i, null);
		//Visit imported sages later
		current = root;
		if(s.p == null)
		{
			s.p.accept(this);
		}
		else
		{
			s.d.accept(this);
		}
	}

	public Sym visit(UsingList u){

	}

	public Sym visit(Program p){
		((SageSym)current).put("$main",new MethodSym("$main", p.line, 0, new VoidType(), current));
	}

	public void visit(StatementList l){
		for(Statement s : l.l){
			s.accept(this);
		}
	}

	public void visit(DefList d){
		for(Def def : d.l){
			def.accept(this);
		}
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
		if(m.r instanceof VarType){
			hadErrors = true;
		}
		else{

		}
	}

	public Sym visit(VarDeclList l){
		for(VarDecl v : l.l){
			v.accept(this);
		}
	}

	public void visit(VarDecl v){
		if(v.t instanceof VarType){
			hadErrors = true;
		}
		else if(v.t instanceof VoidType){
			hadErrors = true;
		}
		else{

		}
	}

	public Sym visit(ArgList a){

	}

	public Sym visit(Param p){

	}

	//***************************************************************************************
	//Types
	public Type visit(ArrayType t){
		return t;
	}

	public Type visit(IntType t){
		return t;
	}

	public Type visit(FloatType t){
		return t;
	}

	public Type visit(BooleanType t){
		return t;
	}

	public Type visit(StringType t){
		return t;
	}

	public Type visit(HashmapType t){
		return t;
	}

	public Type visit(VoidType t){
		return t;
	}

	public Type visit(VarType v){
		return v;
	}

	public Type visit(IdentifierType i){
		return i;
	}

	//=======================================================================================================================
	//Statements
	public void visit(Block b){
		//Cycle through statementlist
	}

	public void visit(If i){
		//Cycle through statementlists
	}

	public void visit(While w){
		//Cycle through statementlists
	}

	public void visit(For f){
		//Cycle through statementlist
	}

	public void visit(DoWhile d){
		//Cycle through statementlist
	}

	public void visit(Print p){
		//Do nothing
	}

	public void visit(VarDecAssignment v){

	}

	public void visit(Assignment a){
		//Do nothing
	}

	public void visit(HashmapAssignment h){
		//Do nothing
	}

	public void visit(ArrayAssignment a){
		//Do nothing
	}

	public void visit(Return r){
		//Do nothing
	}

	public void visit(Assert a){
		//Do nothing
	}

	public void visit(Exit e){
		//Do nothing
	}

	public void visit(Break b){
		//Do nothing
	}	

	public void visit(Continue c){
		//Do nothing
	}

	public void visit(Increment i){
		//Do nothing
	}

	public void visit(Decrement d){
		//Do nothing
	}

	public void visit(RatherList l){
		//Cycle through statementlists
	}

	public void visit(Rather r){
		//Cycle through statement list
	}

	public void visit(MethodCallStatement m){
		//Do nothing
	}
	
	public void visit(Super s){
		//Do nothing
	}
	
	public void visit(Until u){
		//Cycle through statementlist
	}
	
	public void visit(Unless u){
		//Cycle throug statementlist
	}

	public void visit(Throw t){
		//Do nothing
	}
	
	public void visit(TryCatch t){
		//Cycle through statementlist
	}
	
	public void visit(Catch c){
		//Cycle through statementlist
	}

	//-----------------------------------------------------------------------------------------------------
	//Expressions
	public Type visit(And a){
		//Ensure its children are booleans
		return new BooleanType(-1, -1);
	}

	public Type visit(Or o){
		//Ensure its children are booleans
		return new BooleanType(-1, -1);
	}

	public Type visit(Nand n){
		//Ensure its children are booleans
		return new BooleanType(-1, -1);
	}

	public Type visit(Nor n){
		//Ensure its children are booleans
		return new BooleanType(-1, -1);
	}

	public Type visit(Equals e){
		//Ensure its children are booleans
		return new BooleanType(-1, -1);
	}

	public Type visit(Plus p){
		//Ensure its children are booleans
		return new BooleanType(-1, -1);
	}

	public Type visit(Minus m){
		//Ensure its children are booleans
		return new BooleanType(-1, -1);
	}

	public Type visit(Multiply m){
		//Ensure its children are booleans
		return new BooleanType(-1, -1);
	}

	public Type visit(Power p){
		//Ensure its children are booleans
		return new BooleanType(-1, -1);
	}

	public Type visit(Divide d){
		//Ensure its children are booleans
		return new BooleanType(-1, -1);
	}

	public Type visit(Modulo m){
		//Ensure its children are booleans
		return new BooleanType(-1, -1);
	}

	public Type visit(GreaterThanEqualTo g){
		//Ensure its children are booleans
		return new BooleanType(-1, -1);
	}

	public Type visit(LessThanEqualTo l){
		//Ensure its children are booleans
		return new BooleanType(-1, -1);
	}

	public Type visit(GreaterThan g){
		//Ensure its children are booleans
		return new BooleanType(-1, -1);
	}

	public Type visit(LessThan l){
		//Ensure its children are booleans
		return new BooleanType(-1, -1);
	}

	public Type visit(HashmapExpr h){
		return new BooleanType(-1, -1);
	}

	public Type visit(ArrayExpr a){
		//Return whatever type the array is
	}

	public Type visit(ObjectVarAccess o){
		//Return whatever type the variable is
	}

	public Type visit(MethodCall m){
		//Return the rettype of the method
	}

	public Type visit(ArrayLength l){
		return new IntType();
	}

	public Type visit(IntLiteral i){
		return new IntType(-1, -1);
	}

	public Type visit(FloatLiteral f){
		return new FloatType(-1, -1);
	}

	public Type visit(True t){
		return new BooleanType(-1, -1);
	}

	public Type visit(False f){
		return new BooleanType(-1, -1);
	}

	public Type visit(Nil n){
		return null;
	}

	public Type visit(ParentExpr p){
		//return type of whatever the expression is inside of it
	}

	public Type visit(Not n){
		return new BooleanType(-1, -1);
	}

	public Type visit(IdentifierExpr i){
		//return the type of the id
	}

	public Type visit(ObjectCreate o){
		return new IdentifierType(-1, -1);
	}

	public Type visit(This t){
		//Throw an error if you are not within the scope of a class
		//Otherwise, return the type of the object you are in
	}

	public Type visit(ArrayCreate a){
		return new ArrayType(-1, -1);
	}

	public Type visit(HashmapCreate h){
		return new HashType(-1, -1);
	}

	public Type visit(StringLiteral s){
		return new StringType(-1, -1);
	}

	public void visit(ParamList p){
		//Do nothing
	}

	public Type visit(Identifier i){
		return new Identifier(i.i, -1, -1);
	}

	public Type visit(Typeof t){
		//Ensure both are of type id
		return new BooleanType(-1, -1);
	}

	public Type visit(UnaryMinus u){
		//Ensure the expression is a number, return a number
	}

	public Type visit(Differs d){
		//Visit it's inner expressions to make sure they match types
		//Return a boolean type
		return new BooleanType(-1, -1);
	}

	public Type visit(MethodLiteral m){
		//This will require some extra work
	}

	public Type visit(ArrayLiteral a){
		return new ArrayType(a.t, -1, -1);
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