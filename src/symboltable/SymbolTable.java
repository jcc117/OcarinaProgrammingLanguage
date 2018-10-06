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
	public Sym getSymbol(String[] path, boolean isTypeSearch){
		if(path.length == 0){
			return null;
		}
		else{
			boolean found = false;
			Sym thisScope = currentScope;
			//Indicates the item under question can only be searched under a class table
			if(isTypeSearch){
				//Search current scope for first item in path under class scopes - float up til found
				while(!found){
					if(thisScope == null){
						return null;
					}
					else if(thisScope instanceof MethodSym){
						//Float up in scope
						thisScope = thisScope.parent;
					}
					else if(thisScope instanceof ClassSym){
						ClassSym result = ((ClassSym)thisScope).getClass(path[0]);
						if(result == null){
							thisScope = thisScope.parent;
						}
						else{
							found = true;
							thisScope = result;
						}
					}
					else if(thisScope instanceof SageSym){
						ClassSym result = ((SageSym)thisScope).getClass(path[0]);
						if(result == null){
							return null;	//Return null for now - will fill in looking in other tables later
						}
						else{
							found = true;
							thisScope = result;
						}
					}
					else{
						return null;
					}
				}

				//Search the rest of the path
				int index = 1;
				while(index < path.length){
					if(thisScope == null){
						return null;
					}
					else if(thisScope instanceof ClassSym){
						ClassSym result = ((ClassSym)thisScope).getClass(path[index]);
						//Check the permissions of the result
						if(result == null){
							return null;
						}
						else if(result.protection == Sym.ProtectionLevel.PRIVATE){
							return null;
						}
						//Will insert checks for PROTECTED here later
						else{
							thisScope = result;
						}
					}
					else{
						return null;
					}
					index++;
				}
				return thisScope;
				//If found - search the rest of the path under class scopes only
			}
			else{
				//If the symbol is the last one in the class search in the var and method tables
				//Otherwise search the class tables
				MethodScope thisMethodScope = currentMethodScope;
				//If there is only 1 item in the path length, then this item can be a class, method, or variable
				if(path.length == 1){
					while(!found)
					{
						if(thisScope == null){
							return null;
						}
						else if(thisScope instanceof SageSym){
							//Search class table
							//Search method table
							//Search var table
						}
						else if(thisScope instanceof ClassSym){
							//Search class table
							//Search method table
							//Search var table
						}
						else if(thisScope instanceof MethodSym){
							//Look in the current method scope
							if(thisMethodScope == null){
								//Search var table
							}
							//Look in the current inner method scope
							else{

							}
						}
						else{
							return null;
						}
					}
				}
				//If the path length is greater than 1, then the first item must be a class and all items seen until
				//the last item is reached must be classes
				else{
					//Search current scope for first item in path under class scopes - float up til found
					while(!found){
						if(thisScope == null){
							return null;
						}
						else if(thisScope instanceof MethodSym){
							//Float up in scope
							thisScope = thisScope.parent;
						}
						else if(thisScope instanceof ClassSym){
							ClassSym result = ((ClassSym)thisScope).getClass(path[0]);
							if(result == null){
								thisScope = thisScope.parent;
							}
							else{
								found = true;
								thisScope = result;
							}
						}
						else if(thisScope instanceof SageSym){
							ClassSym result = ((SageSym)thisScope).getClass(path[0]);
							if(result == null){
								return null;	//Return null for now - will fill in looking in other tables later
							}
							else{
								found = true;
								thisScope = result;
							}
						}
						else{
							return null;
						}
					}
					//Search the rest of the path until the second to last item
					int index = 1;
					while(index < (path.length - 1)){
						if(thisScope == null){
							return null;
						}
						else if(thisScope instanceof ClassSym){
							ClassSym result = ((ClassSym)thisScope).getClass(path[index]);
							//Check the permissions of the result
							if(result == null){
								return null;
							}
							else if(result.protection == Sym.ProtectionLevel.PRIVATE){
								return null;
							}
							//Will insert checks for PROTECTED here later
							else{
								thisScope = result;
							}
						}
						else{
							return null;
						}
						index++;
					}

					//Once the end of the path has been reached search for the last item under all
					//possible tables
					if(thisScope == null){
						return null;
					}
					else if(thisScope instanceof SageSym){
						//Search class table
						//Search method table
						//Search var table
					}
					else if(thisScope instanceof ClassSym){
						//Search class table
						//Search method table
						//Search var table
					}
					else if(thisScope instanceof MethodSym){
						//Look in the current method scope
						if(thisMethodScope == null){
							//Search var table
						}
						//Look in the current inner method scope
						else{

						}
					}
					else{
						return null;
					}
				}
			}
		}

		return null;
	}

	//Navigate up to the parent scope from the current one.
	public void floatScope() throws IllegalScopeException{
		if(currentMethodScope == null){
			if(currentScope.parent != null){
				currentScope = currentScope.parent;
			}
			else{
				//Throw exception - illegal floating of scope
				throw new IllegalScopeException("Illegal transition to a scope that has no parent scope");
			}
		}
		else{
			currentMethodScope = currentMethodScope.parent;
		}
	}

	//Navigate down to the child scope which is a class
	public void sinkToClassScope(String scopeName) throws IllegalScopeException{
		if((currentScope instanceof SageSym) || (currentScope instanceof ClassSym)){
			currentScope = ((SageSym)currentScope).getClass(scopeName);
		}
		else{
			//Throw exception - illegal navigation to a class scope
			throw new IllegalScopeException("Illegal transition to a class scope");
		}
	}

	//Navigate down to the child scope which is a method
	public void sinkToMethodScope(String scopeName) throws IllegalScopeException{
		if(currentScope instanceof SageSym){
			currentScope = ((SageSym)currentScope).getMethod(scopeName);
		}
		else if(currentScope instanceof ClassSym){
			currentScope = ((ClassSym)currentScope).getMethod(scopeName);
		}
		else if(currentScope instanceof MethodSym){
			currentScope = ((MethodSym)currentScope).getMethodLiteral(scopeName);
		}
		else{
			//Throw exception - illegal navigation to a method scope
			throw new IllegalScopeException("Illegal transition to a function scope");
		}
	}

	//Navigate down to the child scope which is an inner method scope
	public void sinkToInnerMethodScope(String scopeName) throws IllegalScopeException{
		if(currentMethodScope == null){
			if(currentScope instanceof MethodSym){
				currentMethodScope = ((MethodSym)currentScope).getScope(scopeName);
			}
			else{
				//Throw exception - illegal navigation to inner method scope
				throw new IllegalScopeException("Illegal transition to an inner scope within a function");
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