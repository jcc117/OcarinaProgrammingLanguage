package symboltable;
import ast.*;
import java.util.Stack;
import java.util.ArrayList;

public class SymbolTableBuilderPass1 implements Visitor{
	//This builder will perform the initial pass of the ast to build the symbol table.
	//It will add all symbols to the table to build a table that is imcomplete.
	//A second pass will fill in gaps where symbols of the same scope are not yet seen or imported, leaving null
	//refrences throughout some areas.
	//A third pass will be needed to resolve all var-type variables.

	private SymbolTable table;
	private StringBuilder path;
	private Stack<PathCounterStruct> counterStack;
	private Stack<Sym.ProtectionLevel> protectionStack;

	//Create an instance of a pass 1 symbol table builder
	public SymbolTableBuilderPass1(SymbolTable table){
		this.table = table;
		this.path = new StringBuilder();
		this.counterStack = new Stack<PathCounterStruct>();
		this.protectionStack = new Stack<Sym.ProtectionLevel>();
	}

	//Build the symboltable
	public void build(Sage sage){
		sage.accept(this);
	}

	//Process a sage
	public void visit(Sage s){
		String name = s.i.i;
		boolean hasMainMethod = false;
		if(s.p != null){
			hasMainMethod = true;
		}
		SageSym root = new SageSym(name, hasMainMethod, null, name);
		table.setRoot(root);

		//If there is a main method, process it
		if(hasMainMethod){
			s.p.accept(this);
		}
		else{
			//Process everything else
			s.d.accept(this);
		}
	}

	public void visit(Using u){
		//Do nothing for now
	}

	public void visit(UsingList u){
		//Do nothing for now
	}

	//Process the variables within the main method and all definitions after it
	public void visit(Program p){
		appendToPath("$main()");
		MethodSym mainMethod = new MethodSym("$main()", p.line, p.column, true, Sym.ProtectionLevel.NONE, new TypeSym(TypeSym.TypeEnum.VOID, false), false, table.getCurrentScope(), path.toString());
		counterStack.push(new PathCounterStruct());
		try{
			table.sinkToMethodScope("$main()");
			p.s.accept(this);
			counterStack.pop();
			table.floatScope();
		}
		catch(IllegalScopeException e){
			System.out.println("An error occured when sinking to $main()");
			e.printStackTrace();
			System.exit(-1);
		}
		catch(Exception e2){
			System.out.println("An error occured when processing $main()");
			e2.printStackTrace();
			System.exit(-1);
		}
		trimLastAddedPath();
		p.d.accept(this);
	}

	//Loop throuth the statements in the list
	public void visit(StatementList l){
		for(Statement s : l.l){
			s.accept(this);
		}
	}

	//Loop through the definitions in a list
	public void visit(DefinitionList d){
		for(Definition def : d.defs){
			def.accept(this);
		}
	}

	//Define everything within the public block as public
	public void visit(PublicList p){
		protectionStack.push(Sym.ProtectionLevel.PUBLIC);
		p.defList.accept(this);
		protectionStack.pop();
	}

	//Define everthing within the private block as private
	public void visit(PrivateList p){
		protectionStack.push(Sym.ProtectionLevel.PRIVATE);
		p.defList.accept(this);
		protectionStack.pop();
	}

	//Define everything within the protected list as protected
	public void visit(ProtectedList p){
		protectionStack.push(Sym.ProtectionLevel.PROTECTED);
		p.defList.accept(this);
		protectionStack.pop();
	}

	//Process the definition within the definition wrapper
	public void visit(DefWrapper d){
		protectionStack.push(Sym.ProtectionLevel.NONE);
		d.item.accept(this);
		protectionStack.pop();
	}

	public void visit(Definition d){}

	//Process the list of definitions
	public void visit(DefList d){
		for(Def def : d.l){
			def.accept(this);
		}
	}

	//Process a class that has no extension
	public void visit(SimpleClassDef s){
		String name = s.i.i;
		appendToPath(name);
		ClassSym symbol = new ClassSym(name, s.line, s.column, s.is_static, protectionStack.peek(), table.getCurrentScope(), path.toString());
		try{
			table.addSymbol(symbol);
			table.sinkToClassScope(name); 
			s.d.accept(this);
			table.floatScope();
		}
		catch(IllegalScopeException e){
			System.out.println("An error occured when sinking to " + name);
			e.printStackTrace();
			System.exit(-1);
		}
		catch(Exception e2){
			System.out.println("An error occured when processing " + name);
			e2.printStackTrace();
			System.exit(-1);
		}
		trimLastAddedPath();
	}

	//Process a class that has an extension
	public void visit(ExtendsClassDef e){
		String name = e.i.i;
		appendToPath(name);
		ArrayList<String> chain = new ArrayList<String>();
		chain.add(e.c.i);
		ClassSym symbol = new ClassSym(name, e.line, e.column, e.is_static, protectionStack.peek(), table.getCurrentScope(), path.toString(), (ClassSym)table.getSymbol((String[])chain.toArray(), true));
		try{
			table.addSymbol(symbol);
			table.sinkToClassScope(name);
			e.d.accept(this);
			table.floatScope();
		}
		catch(IllegalScopeException e1){
			System.out.println("An error occured when sinking to " + name);
			e1.printStackTrace();
			System.exit(-1);
		}
		catch(Exception e2){
			System.out.println("An error occured when processing " + name);
			e2.printStackTrace();
			System.exit(-1);
		}
		trimLastAddedPath();
	}

	//Process a constructor
	public void visit(Constructor c){
		//Treated like a method
		String name = "constructor";
		name = createMethodSignature(name, c.a);
		TypeSym returnType = new TypeSym(TypeSym.TypeEnum.VOID, true);
		appendToPath(name);
		MethodSym constructor = new MethodSym(name, c.line, c.column, false, protectionStack.peek(), returnType , false, table.getCurrentScope(), path.toString());
		try{
			table.addSymbol(constructor);
			table.sinkToMethodScope(name);
			c.a.accept(this);
			c.l.accept(this);
			table.floatScope();
		}
		catch(IllegalScopeException e1){
			System.out.println("An error occured when sinking to " + name);
			e1.printStackTrace();
			System.exit(-1);
		}
		catch(Exception e2){
			System.out.println("An error occured when processing " + name);
			e2.printStackTrace();
			System.exit(-1);
		}
		trimLastAddedPath();
	}

	//Process a method definition
	public void visit(MethodDef m){
		String name = m.i.i;
		TypeSym returnType = m.r.accept(this);
		name = createMethodSignature(name, m.a);	//Creates the method signature
		counterStack.push(new PathCounterStruct());
		appendToPath(name);
		MethodSym symbol = new MethodSym(name, m.line, m.column, m.is_static, protectionStack.peek(), returnType, false, table.getCurrentScope(), path.toString());
		try{
			table.addSymbol(symbol);
			table.sinkToMethodScope(name);
			m.a.accept(this);
			if(!m.is_delegate) 
				m.s.accept(this);
			counterStack.pop();
			table.floatScope();
		}
		catch(IllegalScopeException e1){
			System.out.println("An error occured when sinking to " + name);
			e1.printStackTrace();
			System.exit(-1);
		}
		catch(Exception e2){
			System.out.println("An error occured when processing " + name);
			e2.printStackTrace();
			System.exit(-1);
		}
		trimLastAddedPath();
	}

	//Helper method to create a method signature for a given method name and a list of parameters
	private String createMethodSignature(String name, ArgList args){
		StringBuilder signature = new StringBuilder(name);
		signature.append("(");
		TypeSym type = args.p.t.accept(this);
		signature.append(type.toString());
		ArrayList<Param> list = args.chain.accept(this);
		for(Param parameter : list){
			type = parameter.t.accept(this);
			signature.append(",");
			signature.append(type.toString());
		}
		signature.append(")");
		return signature.toString();
	}

	//Process a variable declaration
	public void visit(VarDecl v){
		String name = v.i.i;
		TypeSym type = v.t.accept(this);
		appendToPath(name);
		VarSym symbol = new VarSym(name, v.line, v.column, v.is_static, protectionStack.peek(), false, type, type.is_constant, table.getCurrentScope(), path.toString());
		table.addSymbol(symbol);
		trimLastAddedPath();
	}

	//Process a variable declaration that is also assigned
	public void visit(VarDecAssignment v){
		String name = v.i.i;
		TypeSym type = v.t.accept(this);
		appendToPath(name);
		VarSym symbol = new VarSym(name, v.line, v.column, v.is_static, protectionStack.peek(), true, type, type.is_constant, table.getCurrentScope(), path.toString());
		table.addSymbol(symbol);
		trimLastAddedPath();
	}
	
	//Process a list of parameters
	public void visit(ArgList a){
		a.p.accept(this);
		ArrayList<Param> list = a.chain.accept(this);
		for(Param p : list){
			p.accept(this);
		}
	}

	public ArrayList<Param> visit(ArgChain a){
		return a.l;
	}

	//Process a parameter in a method definition
	public void visit(Param p){
		TypeSym type = p.t.accept(this);
		String name = p.i.i;
		appendToPath(name);
		VarSym symbol = new VarSym(name, p.line, p.column, false, Sym.ProtectionLevel.PRIVATE, true, type, false, table.getCurrentScope(), path.toString());
		table.addSymbol(symbol);
		trimLastAddedPath();
	}

	//Process an array type
	public TypeSym visit(ArrayType t){
		return new TypeSym(TypeSym.TypeEnum.ARRAY, t.t.accept(this), t.constant);
	}

	//Process an identifier type
	public TypeSym visit(IdentifierType i){
		String firstPart = i.i.i;
		ArrayList<String> chain = i.chain.accept(this);
		chain.add(0, firstPart);
		return new TypeSym(TypeSym.TypeEnum.ID, table.getSymbol((String[])chain.toArray(), true), i.constant);
	}

	//Return the rest of identifiers in a chain as a list of strings
	public ArrayList<String> visit(IdChain i){
		ArrayList<String> retVal = new ArrayList<String>();
		for(Identifier id : i.chain){
			retVal.add(id.i);
		}
		return retVal;
	}

	//Process an int type
	public TypeSym visit(IntType t){
		return new TypeSym(TypeSym.TypeEnum.INT, t.constant);
	}

	//Process a float type(decimal)
	public TypeSym visit(FloatType t){
		return new TypeSym(TypeSym.TypeEnum.DECIMAL, t.constant);
	}

	//Process a boolean type
	public TypeSym visit(BooleanType t){
		return new TypeSym(TypeSym.TypeEnum.BOOLEAN, t.constant);
	}

	//Process a string type
	public TypeSym visit(StringType t){
		return new TypeSym(TypeSym.TypeEnum.STRING, t.constant);
	}

	//Process a hashmap type(dictionary)
	public TypeSym visit(HashmapType t){
		return new TypeSym(TypeSym.TypeEnum.HASHMAP, t.t1.accept(this), t.t2.accept(this), t.constant);
	}

	//Process a void type
	public TypeSym visit(VoidType t){
		return new TypeSym(TypeSym.TypeEnum.VOID, t.constant);
	}

	//Process a var type- will be resolved in a later pass
	public TypeSym visit(VarType v){
	 	return new TypeSym(TypeSym.TypeEnum.VAR, v.constant);
	}

	//Create an inner scope for a block and process its variables
	public void visit(Block b){
		String name = counterStack.peek().blockCounter++ + "block";
		appendToPath(name);
		MethodScope newScope = new MethodScope(path.toString(), table.getCurrentMethodScope(), name);
		try{
			table.addMethodScope(newScope);
			counterStack.push(new PathCounterStruct());
			table.sinkToInnerMethodScope(path.toString());
			b.l.accept(this);
			table.floatScope();
		}
		catch(IllegalScopeException e1){
			System.out.println("An error occured when sinking to " + name);
			e1.printStackTrace();
			System.exit(-1);
		}
		catch(Exception e2){
			System.out.println("An error occured when processing " + name);
			e2.printStackTrace();
			System.exit(-1);
		}
		trimLastAddedPath();
		counterStack.pop();
	}

	//Create an inner scope for an if statement and process its variables
	public void visit(If i){
		String name = counterStack.peek().ifCounter++ + "if";
		appendToPath(name);
		MethodScope newScope = new MethodScope(path.toString(), table.getCurrentMethodScope(), name);
		try{
			table.addMethodScope(newScope);
			counterStack.push(new PathCounterStruct());
			table.sinkToInnerMethodScope(path.toString());
			i.s1.accept(this);
			table.floatScope();
		}
		catch(IllegalScopeException e1){
			System.out.println("An error occured when sinking to " + name);
			e1.printStackTrace();
			System.exit(-1);
		}
		catch(Exception e2){
			System.out.println("An error occured when processing " + name);
			e2.printStackTrace();
			System.exit(-1);
		}
		trimLastAddedPath();
		counterStack.pop();
		i.r.accept(this);

		//Process the else statement
		if(i.s2 != null && i.s2.l.size() > 0){
			name = counterStack.peek().elseCounter++ + "else";
			appendToPath(name);
			newScope = new MethodScope(path.toString(), table.getCurrentMethodScope(), name);
			try{
				table.addMethodScope(newScope);
				counterStack.push(new PathCounterStruct());
				table.sinkToInnerMethodScope(path.toString());
				i.s2.accept(this);
				table.floatScope();
			}
			catch(IllegalScopeException e1){
				System.out.println("An error occured when sinking to " + name);
				e1.printStackTrace();
				System.exit(-1);
			}
			catch(Exception e2){
				System.out.println("An error occured when processing " + name);
				e2.printStackTrace();
				System.exit(-1);
			}
			trimLastAddedPath();
			counterStack.pop();
		}
	}

	//Process a list of rather blocks
	public void visit(RatherList l){
		for(Rather r : l.l){
			r.accept(this);
		}
	}

	//Create an inner scope for a rather block and process its variables
	public void visit(Rather r){
		String name = counterStack.peek().ratherCounter++ + "rather";
		appendToPath(name);
		MethodScope newScope = new MethodScope(path.toString(), table.getCurrentMethodScope(), name);
		try{
			table.addMethodScope(newScope);
			counterStack.push(new PathCounterStruct());
			table.sinkToInnerMethodScope(path.toString());
			r.s.accept(this);
			table.floatScope();
		}
		catch(IllegalScopeException e1){
			System.out.println("An error occured when sinking to " + name);
			e1.printStackTrace();
			System.exit(-1);
		}
		catch(Exception e2){
			System.out.println("An error occured when processing " + name);
			e2.printStackTrace();
			System.exit(-1);
		}
		trimLastAddedPath();
		counterStack.pop();
	}

	//Create an inner scope for a while loop and process its variables
	public void visit(While w){
		String name = counterStack.peek().whileCounter++ + "while";
		appendToPath(name);
		MethodScope newScope = new MethodScope(path.toString(), table.getCurrentMethodScope(), name);
		try{
			table.addMethodScope(newScope);
			counterStack.push(new PathCounterStruct());
			table.sinkToInnerMethodScope(path.toString());
			w.s.accept(this);
			table.floatScope();
		}
		catch(IllegalScopeException e1){
			System.out.println("An error occured when sinking to " + name);
			e1.printStackTrace();
			System.exit(-1);
		}
		catch(Exception e2){
			System.out.println("An error occured when processing " + name);
			e2.printStackTrace();
			System.exit(-1);
		}
		trimLastAddedPath();
		counterStack.pop();
	}

	////Create an inner scope for a for loop and process its variables
	public void visit(For f){
		String name = counterStack.peek().forCounter++ + "for";
		appendToPath(name);
		MethodScope newScope = new MethodScope(path.toString(), table.getCurrentMethodScope(), name);
		try{
			table.addMethodScope(newScope);
			counterStack.push(new PathCounterStruct());
			table.sinkToInnerMethodScope(path.toString());
			f.s1.accept(this);
			f.s2.accept(this);
			f.s3.accept(this);
			table.floatScope();
		}
		catch(IllegalScopeException e1){
			System.out.println("An error occured when sinking to " + name);
			e1.printStackTrace();
			System.exit(-1);
		}
		catch(Exception e2){
			System.out.println("An error occured when processing " + name);
			e2.printStackTrace();
			System.exit(-1);
		}
		trimLastAddedPath();
		counterStack.pop();
	}

	//Create an inner scope for a foreach loop and process its variables
	public void visit(Foreach f){
		String name = counterStack.peek().foreachCounter++ + "foreach";
		appendToPath(name);
		MethodScope newScope = new MethodScope(path.toString(), table.getCurrentMethodScope(), name);
		try{
			table.addMethodScope(newScope);
			counterStack.push(new PathCounterStruct());
			table.sinkToInnerMethodScope(path.toString());
			TypeSym type = f.t.accept(this);
			String loopVar = f.i1.i;
			appendToPath(loopVar);
			VarSym symbol = new VarSym(loopVar, f.line, f.column, false, Sym.ProtectionLevel.PRIVATE, true, type, false, table.getCurrentScope(), path.toString());
			trimLastAddedPath();
			table.addSymbol(symbol);
			f.s.accept(this);
			table.floatScope();
		}
		catch(IllegalScopeException e1){
			System.out.println("An error occured when sinking to " + name);
			e1.printStackTrace();
			System.exit(-1);
		}
		catch(Exception e2){
			System.out.println("An error occured when processing " + name);
			e2.printStackTrace();
			System.exit(-1);
		}
		trimLastAddedPath();
		counterStack.pop();
	}

	//Create an inner scope for a do-while loop and process its variables
	public void visit(DoWhile d){
		String name = counterStack.peek().doWhileCounter++ + "doWhile";
		appendToPath(name);
		MethodScope newScope = new MethodScope(path.toString(), table.getCurrentMethodScope(), name);
		try{
			table.addMethodScope(newScope);
			counterStack.push(new PathCounterStruct());
			table.sinkToInnerMethodScope(path.toString());
			d.s.accept(this);
			table.floatScope();
		}
		catch(IllegalScopeException e1){
			System.out.println("An error occured when sinking to " + name);
			e1.printStackTrace();
			System.exit(-1);
		}
		catch(Exception e2){
			System.out.println("An error occured when processing " + name);
			e2.printStackTrace();
			System.exit(-1);
		}
		trimLastAddedPath();
		counterStack.pop();
	}

	//Create an inner scope for an until loop and process its variables
	public void visit(Until u){
		String name = counterStack.peek().untilCounter++ + "until";
		appendToPath(name);
		MethodScope newScope = new MethodScope(path.toString(), table.getCurrentMethodScope(), name);
		try{
			table.addMethodScope(newScope);
			counterStack.push(new PathCounterStruct());
			table.sinkToInnerMethodScope(path.toString());
			u.s.accept(this);
			table.floatScope();
		}
		catch(IllegalScopeException e1){
			System.out.println("An error occured when sinking to " + name);
			e1.printStackTrace();
			System.exit(-1);
		}
		catch(Exception e2){
			System.out.println("An error occured when processing " + name);
			e2.printStackTrace();
			System.exit(-1);
		}
		trimLastAddedPath();
		counterStack.pop();
	}

	//Create an inner scope for an unless statement and process its variables
	public void visit(Unless u){
		String name = counterStack.peek().unlessCounter++ + "unless";
		appendToPath(name);
		MethodScope newScope = new MethodScope(path.toString(), table.getCurrentMethodScope(), name);
		try{
			table.addMethodScope(newScope);
			counterStack.push(new PathCounterStruct());
			table.sinkToInnerMethodScope(path.toString());
			u.s.accept(this);
			table.floatScope();
		}
		catch(IllegalScopeException e1){
			System.out.println("An error occured when sinking to " + name);
			e1.printStackTrace();
			System.exit(-1);
		}
		catch(Exception e2){
			System.out.println("An error occured when processing " + name);
			e2.printStackTrace();
			System.exit(-1);
		}
		trimLastAddedPath();
		counterStack.pop();
	}

	//Create an inner scope for a try-catch-finally block and process its variables
	public void visit(TryCatch t){
		String name = counterStack.peek().tryCounter++ + "try";
		appendToPath(name);
		MethodScope newScope = new MethodScope(path.toString(), table.getCurrentMethodScope(), name);
		try{
			table.addMethodScope(newScope);
			counterStack.push(new PathCounterStruct());
			table.sinkToInnerMethodScope(path.toString());
			t.l.accept(this);
			table.floatScope();
		}
		catch(IllegalScopeException e1){
			System.out.println("An error occured when sinking to " + name);
			e1.printStackTrace();
			System.exit(-1);
		}
		catch(Exception e2){
			System.out.println("An error occured when processing " + name);
			e2.printStackTrace();
			System.exit(-1);
		}
		trimLastAddedPath();
		counterStack.pop();
		t.c.accept(this);

		if(t.f != null && t.f.l.size() > 0){
			name = counterStack.peek().finallyCounter++ + "finally";
			appendToPath(name);
			newScope = new MethodScope(path.toString(), table.getCurrentMethodScope(), name);
			try{
				table.addMethodScope(newScope);
				counterStack.push(new PathCounterStruct());
				table.sinkToInnerMethodScope(path.toString());
				t.f.accept(this);
				table.floatScope();
			}
			catch(IllegalScopeException e1){
				System.out.println("An error occured when sinking to " + name);
				e1.printStackTrace();
				System.exit(-1);
			}
			catch(Exception e2){
				System.out.println("An error occured when processing " + name);
				e2.printStackTrace();
				System.exit(-1);
			}
			trimLastAddedPath();
			counterStack.pop();
		}
	}

	//Create an inner scope for a catch block and process its variables
	public void visit(Catch c){
		String name = counterStack.peek().catchCounter++ + "catch";
		appendToPath(name);
		MethodScope newScope = new MethodScope(path.toString(), table.getCurrentMethodScope(), name);
		try{
			table.addMethodScope(newScope);
			counterStack.push(new PathCounterStruct());
			table.sinkToInnerMethodScope(path.toString());
			String firstPart = c.i.i;
			ArrayList<String> chain = c.chain.accept(this);
			chain.add(0, firstPart);
			String exceptionName = c.i2.i;
			VarSym symbol = new VarSym(exceptionName, c.line, c.column, false, Sym.ProtectionLevel.PRIVATE, true, 
				new TypeSym(TypeSym.TypeEnum.ID, table.getSymbol((String[])chain.toArray(), true), false), false, table.getCurrentScope(), path.toString());
			table.addSymbol(symbol);
			c.s.accept(this);
			table.floatScope();
		}
		catch(IllegalScopeException e1){
			System.out.println("An error occured when sinking to " + name);
			e1.printStackTrace();
			System.exit(-1);
		}
		catch(Exception e2){
			System.out.println("An error occured when processing " + name);
			e2.printStackTrace();
			System.exit(-1);
		}
		trimLastAddedPath();
		counterStack.pop();
	}

	//Process a method literal's variables declarations
	public TypeSym visit(MethodLiteral m){
		String name = counterStack.peek().funcCounter++ + "function()";
		counterStack.push(new PathCounterStruct());
		appendToPath(name);
		//Return type will be resolved during var-resolver pass
		MethodScope symbol = new MethodScope(path.toString(), table.getCurrentMethodScope(), name);
		try{
			table.addMethodScope(symbol);
			table.sinkToInnerMethodScope(path.toString());
			m.parameters.accept(this);
			m.s.accept(this);
			counterStack.pop();
			table.floatScope();
		}
		catch(IllegalScopeException e1){
			System.out.println("An error occured when sinking to " + name);
			e1.printStackTrace();
			System.exit(-1);
		}
		catch(Exception e2){
			System.out.println("An error occured when processing " + name);
			e2.printStackTrace();
			System.exit(-1);
		}
		trimLastAddedPath();
		return null;
	}
	/********************************************************************************************************/
	//Scan through the rest of the statements to search for method literals
	public void visit(MethodCallStatement m){
		m.method.accept(this);

	}

	public void visit(Print p){
		p.e.accept(this);
	}

	public void visit(Throw t){
		t.e.accept(this);
	}

	public void visit(Super s){
		s.p.accept(this);
	}

	public void visit(Assignment a){
		a.e.accept(this);
	}

	public void visit(HashmapAssignment h){
		h.e1.accept(this);
		h.e2.accept(this);
	}

	public void visit(ArrayAssignment a){
		a.e1.accept(this);
		a.e2.accept(this);
	}

	public void visit(Return r){
		r.e.accept(this);
	}

	public void visit(Assert a){
		a.e.accept(this);
		if(a.print_expression != null){
			a.print_expression.accept(this);
		}
	}

	public void visit(Exit e){
		e.e.accept(this);
	}

	public void visit(Break b){}	
	public void visit(Continue c){}
	public void visit(Increment i){}
	public void visit(Decrement d){}
	/*******************************************************************************************************************/
	/*Proces all expressions to look for method literals: the return null for this pass but in later passes they will
		evaluate the expressions to resolve var-type declarations*/
	/********************************************************************************************************************/
	public TypeSym visit(And a){
		a.e1.accept(this);
		a.e2.accept(this);
		return null;
	}

	public TypeSym visit(Or o){
		o.e1.accept(this);
		o.e2.accept(this);
		return null;
	}

	public TypeSym visit(Nand n){
		n.e1.accept(this);
		n.e2.accept(this);
		return null;
	}

	public TypeSym visit(Nor n){
		n.e1.accept(this);
		n.e2.accept(this);
		return null;
	}

	public TypeSym visit(Equals e){
		e.e1.accept(this);
		e.e2.accept(this);
		return null;
	}

	public TypeSym visit(Plus p){
		p.e1.accept(this);
		p.e2.accept(this);
		return null;
	}

	public TypeSym visit(Minus m){
		m.e1.accept(this);
		m.e2.accept(this);
		return null;
	}

	public TypeSym visit(Multiply m){
		m.e1.accept(this);
		m.e2.accept(this);
		return null;
	}

	public TypeSym visit(Power p){
		p.e1.accept(this);
		p.e2.accept(this);
		return null;
	}

	public TypeSym visit(Divide d){
		d.e1.accept(this);
		d.e2.accept(this);
		return null;
	}

	public TypeSym visit(Modulo m){
		m.e1.accept(this);
		m.e2.accept(this);
		return null;
	}

	public TypeSym visit(GreaterThanEqualTo g){
		g.e1.accept(this);
		g.e2.accept(this);
		return null;
	}

	public TypeSym visit(LessThanEqualTo l){
		l.e1.accept(this);
		l.e2.accept(this);
		return null;
	}

	public TypeSym visit(GreaterThan g){
		g.e1.accept(this);
		g.e2.accept(this);
		return null;
	}

	public TypeSym visit(LessThan l){
		l.e1.accept(this);
		l.e2.accept(this);
		return null;
	}

	public TypeSym visit(HashmapExpr h){
		h.e1.accept(this);
		h.e2.accept(this);
		return null;
	}

	public TypeSym visit(ArrayExpr a){
		a.e1.accept(this);
		a.e2.accept(this);
		return null;
	}

	public TypeSym visit(ObjectVarAccess o){
		o.e.accept(this);
		return null;
	}

	public TypeSym visit(MethodCall m){
		m.e.accept(this);
		m.l.accept(this);
		return null;
	}

	public TypeSym visit(ArrayLength l){
		l.e.accept(this);
		return null;
	}

	public TypeSym visit(IntLiteral i){return null;}
	public TypeSym visit(FloatLiteral f){return null;}
	public TypeSym visit(True t){return null;}
	public TypeSym visit(False f){return null;}
	public TypeSym visit(Nil n){return null;}

	public TypeSym visit(ParentExpr p){
		p.e.accept(this);
		return null;
	}

	public TypeSym visit(Not n){
		n.e.accept(this);
		return null;
	}

	public TypeSym visit(IdentifierExpr i){return null;}

	public TypeSym visit(ObjectCreate o){
		o.l.accept(this);
		return null;
	}

	public TypeSym visit(This t){return null;}

	public TypeSym visit(ArrayCreate a){
		a.e.accept(this);
		return null;
	}

	public TypeSym visit(HashmapCreate h){return null;}
	public TypeSym visit(StringLiteral s){return null;}

	public TypeSym visit(ParamList p){
		p.e.accept(this);
		p.chain.accept(this);
		return null;
	}

	public TypeSym visit(Identifier i){
		return null;
	}

	public TypeSym visit(UnaryMinus u){
		u.e.accept(this);
		return null;
	}

	public TypeSym visit(Typeof t){return null;}

	public TypeSym visit(Differs d){
		d.e1.accept(this);
		d.e2.accept(this);
		return null;
	}

	public TypeSym visit(PostIncrement p){return null;}
	public TypeSym visit(PreIncrement p){return null;}
	public TypeSym visit(PostDecrement p){return null;}
	public TypeSym visit(PreDecrement p){return null;}

	public TypeSym visit(ArrayLiteral a){
		a.l.accept(this);
		return null;
	}

	public void visit(Statement s){}
	public TypeSym visit(Type t){return null;}
	public TypeSym visit(Expression e){return null;}

	public void visit(ExprChain e){
		for(Expression expr : e.l){
			expr.accept(this);
		}
	}

	//Process a list of catch blocks
	public void visit(CatchList c){
		for(Catch cat : c.l){
			cat.accept(this);
		}
	}

	//Remove the last added scope from the current path
	private void trimLastAddedPath(){
		int slash = path.lastIndexOf("/");
		if(slash != 1){
			path.delete(slash, path.length() - 1);
		}
	}

	//Add a scope to the current path
	private void appendToPath(String name){
		path.append("/" + name);
	}

	//Turn the path string into an array of strings separated by a forward slash
	private String[] getPathArray(){
		return path.toString().split("/");
	}
}