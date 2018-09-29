package symboltable;
import java.util.Hashtable;

public class MethodScope{
	public String path;
	public Hashtable<String, VarSym> varTable;
	public Hashtable<String, MethodScope> innerScopes;

	public MethodScope(String path){
		this.path = path;
		varTable = new Hashtable<String, VarSym>();
		innerScopes = new Hashtable<String, MethodScope>();
	}

	public void addVar(String name, VarSym var){
		varTable.put(name, var);
	}

	public VarSym getVar(String name){
		return varTable.get(name);
	}

	public void addScope(String path, MethodScope scope){
		innerScopes.put(path, scope);
	}

	public MethodScope getScope(String path){
		return innerScopes.get(path);
	}
}