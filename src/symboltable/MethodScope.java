package symboltable;
import java.util.Hashtable;

//Represents an inner scope of a method
public class MethodScope{
	public String name;
	public String path;
	public Hashtable<String, VarSym> varTable;
	public Hashtable<String, MethodScope> innerScopes;
	public MethodScope parent;

	//Creates an inner method scope
	public MethodScope(String path, MethodScope parent, String name){
		this.path = path;
		this.parent = parent;
		this.name = name;
		varTable = new Hashtable<String, VarSym>();
		innerScopes = new Hashtable<String, MethodScope>();
	}

	//Add a variable to the inner scope
	public void addVar(String name, VarSym var){
		varTable.put(name, var);
	}

	//Get a variable by name
	public VarSym getVar(String name){
		return varTable.get(name);
	}

	//Add an inner scope to the inner scope
	public void addScope(String path, MethodScope scope){
		innerScopes.put(path, scope);
	}

	//Get an inner scope within this scope
	public MethodScope getScope(String path){
		return innerScopes.get(path);
	}
}