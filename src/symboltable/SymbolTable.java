package symboltable;
import java.util.Hashtable;

public class SymbolTable{
	private SageSym root;
	private Sym currentScope;
	private MethodScope currentMethodScope;

	public SymbolTable(SageSym root){
		this.root = root;
	}

	//Retrive the symbol from the symbol table with the identified path. Each string in the array is
	//identified as a different component of the path. The first item in path is treated like the above method
	//where it will keep floating up scopes until it is found or it is not. If not found, null is returned. If
	//found, it will then use the rest of the path as sinking points to get down to those various scopes until
	//the last item in the path is found and returned. It cannot return variables symbols within functions.
	//Proper protections of these scopes will be checked. Appropriate protection exceptions will be thrown if
	//one is violated with the given path.
	public Sym getSymbol(String[] path){
		return null;
	}

	//Navigate up to the parent scope from the current one.
	public void floatScope(){
		if(currentMethodScope == null){
			if(currentScope.parent != null){
				currentScope = currentScope.parent;
			}
			else{
				//Throw exception - illegal floating of scope
			}
		}
		else{
			currentMethodScope = currentMethodScope.parent;
		}
	}

	//Navigate down to the child scope which is a class
	public void sinkToClassScope(String scopeName){
		if(currentScope.instanceof(SageSym) || currentScope.instanceof(ClassSym)){
			currentScope = currentScope.getClass(scopeName);
		}
		else{
			//Throw exception - illegal navigation to a class scope
		}
	}

	//Navigate down to the child scope which is a method
	public void sinkToMethodScope(String scopeName){
		if(currentScope.instanceof(SageSym) || currentScope.instanceof(ClassSym)){
			currentScope = currentScope.getMethod(scopeName);
		}
		else if(currentScope.instanceof(MethodSym)){
			currentScope = currentScope.getMethodLiteral(scopeName);
		}
		else{
			//Throw exception - illegal navigation to a method scope
		}
	}

	//Navigate down to the child scope which is an inner method scope
	public void sinkToInnerMethodScope(String scopeName){
		if(currentMethodScope == null){
			if(currentScope.instanceof(MethodSym)){
				currentMethodScope = currentScope.getScope(scopeName);
			}
			else{
				//Throw exception - illegal navigation to inner method scope
			}
		}
		else{
			currentMethodScope = currentMethodScope.getScope(scopeName);
		}
	}

	//Returns the type of the symbol as a String identified by the String name.
	public String getType(String name){
		return null;
	}

	//Add a symbol to the current scope.
	public void addSymbol(Sym symbol){

	}

	//Add an inner scope to the current method scope
	public void addMethodScope(MethodScope scope){
		if(currentMethodScope != null){
			currentMethodScope.addScope(scope.path, scope);
		}
	}

	//Returns the root of the symbol table
	public SageSym getRoot(){
		return root;
	}

	public void addImport(SymbolTable table){
		root.addTable(table.getRoot().name, table);
	}
}