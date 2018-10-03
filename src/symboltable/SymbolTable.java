package symboltable;
import java.util.Hashtable;

public class SymbolTable{
	private SageSym root;
	private Sym currentScope;
	private MethodScope currentMethodScope;

	public SymbolTable(SageSym root){
		this.root = root;
	}

	//Retrieve the symbol from the symbol table identified by the String called name.
	//If symbol is not in the current scope it will search in the scope above it and keep doing so
	//until it is either found or it hits the root. When the root is hit it will then check the top level
	//of all imports. If it is not there null is returned. Proper protections will be checked if the symbol
	//is found but does not have the proper protections. Appropriate protection exceptions will be thrown if
	//one is violated.
	public Sym getSymbol(String name){
		return null;
	}

	//Retrive the symbol from the symbol table with the identified path. Each string in the array is
	//identified as a different component of the path. The first item in path is treated like the above method
	//where it will keep floating up scopes until it is found or it is not. If not found, null is returned. If
	//found, it will then use the rest of the path as sinking points to get down to those various scopes until
	//the last item in the path is found and returned. It cannot return variables symbols within functions.
	//Proper protections of these scopes will be checked. Appropriate protection exceptions will be thrown if
	//one is violated with the given path.
	public Sym getSymbolWithPath(String[] path){
		return null;
	}

	//Navigate up to the parent scope from the current one.
	public void floatScope(){
		if(currentMethodScope == null){
			currentScope = currentScope.parent;
		}
		else{
			currentMethodScope = currentMethodScope.parent;
		}
	}

	//Navigate down to the child scope from the current one with the name scopeName.
	public void sinkScope(String scopeName){
		if(currentMethodScope == null){

		}
		else{

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