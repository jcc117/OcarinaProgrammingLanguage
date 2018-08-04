package symboltable;
import ast.*;
import java.lang.IllegalArgumentException;
import java.util.ArrayList;

public class SymbolTable{
	private SageSym root;
	private Sym currentLevel;
	private ArrayList<SageSym> imports;
	
	public SymbolTable(SageSym root){
		this.root = root;
		imports = new ArrayList<SageSym>();
	}

	//Search for a symbol
	public Sym search(String name){
		/* WILL IMPLEMENT LATER */
		return null;
	}

	public void include(SageSym s){
		imports.add(s);
	}

	//Go up a level in scope
	public void rise(){
		if(currentLevel instanceof SageSym){
			if(((SageSym)currentLevel).parent != null){
				currentLevel = ((SageSym)currentLevel).parent;
			}
		}
		else if(currentLevel instanceof ClassSym){
			currentLevel = ((ClassSym)currentLevel).parent;
		}
		else if(currentLevel instanceof MethodSym){
			currentLevel = ((MethodSym)currentLevel).parent;
		}
		else if(currentLevel instanceof ExceptionSym){
			currentLevel = ((ExceptionSym)currentLevel).parent;
		}
		else if(currentLevel instanceof VariableSym){
			currentLevel = ((VariableSym)currentLevel).parent;
		}
		else{
			throw new IllegalArgumentException();
		}
	}

	//Go down a level in scope within one sage
	public void descend(String name){
		if(currentLevel instanceof SageSym){
			currentLevel = ((SageSym)currentLevel).lookUpDef(name);
		}
		else if(currentLevel instanceof ClassSym){
			currentLevel = ((ClassSym)currentLevel).get(name);
		}
		else if(currentLevel instanceof MethodSym){
			currentLevel = ((MethodSym)currentLevel).get(name);
		}
		else if(currentLevel instanceof ExceptionSym){
			throw new IllegalArgumentException();
		}
		else if(currentLevel instanceof VariableSym){
			throw new IllegalArgumentException();
		}
		else{
			throw new IllegalArgumentException();
		}
	}

	public void put(ClassSym d){
		if(currentLevel instanceof ClassSym){
			((ClassSym)currentLevel).put(d.name, d);
		}
		else if(currentLevel instanceof SageSym){
			((SageSym)currentLevel).put(d.name, d);
		}
		else{
			throw new IllegalArgumentException();
		}
	}

	public void put(ExceptionSym e){
		if(currentLevel instanceof ClassSym){
			((ClassSym)currentLevel).put(e.name, e);
		}
		else if(currentLevel instanceof SageSym){
			((SageSym)currentLevel).put(e.name, e);
		}
		else{
			throw new IllegalArgumentException();
		}
	}

	public void put(MethodSym m){
		if(currentLevel instanceof ClassSym){
			((ClassSym)currentLevel).put(m.name, m);
		}
		else if(currentLevel instanceof SageSym){
			((SageSym)currentLevel).put(m.name, m);
		}
		else{
			throw new IllegalArgumentException();
		}
	}

	public void put(VariableSym v){
		if(currentLevel instanceof ClassSym){
			((ClassSym)currentLevel).put(v.name, v);
		}
		else if(currentLevel instanceof MethodSym){
			((MethodSym)currentLevel).put(v.name, v);
		}
		else{
			throw new IllegalArgumentException();
		}
	}

}