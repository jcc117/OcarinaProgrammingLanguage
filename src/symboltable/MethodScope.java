package symboltable;
import java.util.Hashtable;

public class MethodScope{
	public String path;
	public int startLine;
	public int startColumn;
	public int endLine;
	public int endColumn;
	public Hashtable<String, VarSym> varTable;

	public MethodScope(String path, int startLine, int startColumn, int endLine, int endColumn){
		this.path = path;
		this.startLine = startLine;
		this.startColumn = startColumn;
		this.endLine = endLine;
		this.endColumn = endColumn;
		varTable = new Hashtable<String, VarSym>();
	}

	public void addVar(String name, VarSym var){
		varTable.put(name, var);
	}

	public VarSym getVar(String name){
		return varTable.get(name);
	}
}