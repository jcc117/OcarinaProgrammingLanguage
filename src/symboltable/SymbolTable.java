package symboltable;
import java.util.Hashtable;

public class SymbolTable{
	private SageSym root;
	private Sym currentScope;
	private MethodScope currentMethodScope;
	private String currentPath;

	//Creates an empty symbol table
	public SymbolTable(){
		root = null;
		currentScope = null;
		currentPath = "";
	}

	public SymbolTable(SageSym root){
		this.root = root;
		currentScope = root;
		currentPath = root.path;
	}

	//Set the root of a symbol table to the given sage
	public void setRoot(SageSym root){
		this.root = root;
		currentScope = root;
		currentPath = root.path;
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
			String scopePath = currentPath;

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
						scopePath = thisScope.path;
					}
					else if(thisScope instanceof ClassSym){
						ClassSym result = ((ClassSym)thisScope).getClass(path[0]);
						if(result == null){
							//Float up in scope
							thisScope = thisScope.parent;
							scopePath = thisScope.path;
						}
						else if(result.is_static){
							//Print error message here
							return null;
						}
						else{
							//Found the symbol
							found = true;
							thisScope = result;
							scopePath = thisScope.path;
						}
					}
					else if(thisScope instanceof SageSym){
						ClassSym result = ((SageSym)thisScope).getClass(path[0]);
						if(result == null){
							return null;	//Return null for now - will fill in looking in other tables later
						}
						else{
							//Found the symbol
							found = true;
							thisScope = result;
							scopePath = thisScope.path;
						}
					}
					else{
						return null;
					}
				}

				//Search the rest of the path by sinking in scope until its found
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
						else if(result.protection == Sym.ProtectionLevel.PRIVATE && !result.is_static){
							//Check if the current scope is an inner scope of the private class
							if(isInnerPath(scopePath.toString() + "/" + result.name)){
								thisScope = result;
								scopePath = thisScope.path;
							}
							else{
								//Print error message here
								return null;
							}
						}
						else if(result.is_static){
							//Print error message here
							return null;
						}
						//Will insert checks for PROTECTED here later
						else{
							thisScope = result;
							scopePath = thisScope.path;
						}
					}
					//All types must be classes, not variables or methods
					else{
						return null;
					}
					index++;
				}
				return thisScope;
				//If found - search the rest of the path under class scopes only
			}
			//Build phases 1 and 2 should only be using type searches
			else{
				//This is being treated as a variable reference, static class reference, or method references
				MethodScope thisMethodScope = currentMethodScope;
				int index = 0;
				//Float up in scope until its found
				if(path[index].equals("this")){
					//Float up to the nearest instance of a class
					//If its static return null and print an error
					//If there is no upper instance of a class print an error and return null
					while(!found){
						if(thisScope == null){
							return null;
						}
						else if(thisScope instanceof SageSym){
							//Print error message here
							return null;
						}
						else if(thisScope instanceof ClassSym){
							if(thisScope.is_static){
								//Print error message here
								return null;
							}
							found = true;
						}
						else if(thisScope instanceof MethodSym){
							//Float up in scope
							thisScope = thisScope.parent;
							scopePath = thisScope.path;
						}
						else{
							return null;
						}
					}
				}
				else{
					//Float up til found
					while(!found){
						//If its the only item, search variables and methods
						if(path.length == 1){
							if(thisScope == null){
								return null;
							}
							//Look in the current sage
							else if(thisScope instanceof SageSym){
								Sym result = ((SageSym)thisScope).getVar(path[index]);
								if(result != null){
									return result;
								}
								result = ((SageSym)thisScope).getMethod(path[index]);
								if(result != null){
									return result;
								}
								thisScope = thisScope.parent;
								scopePath = thisScope.path;
							}
							//Look in the current class
							else if(thisScope instanceof ClassSym){
								Sym result = ((ClassSym)thisScope).getVar(path[index]);
								if(result != null){
									return result;
								}
								result = ((ClassSym)thisScope).getMethod(path[index]);
								if(result != null){
									return result;
								}
								thisScope = thisScope.parent;
								scopePath = thisScope.path;
							}
							//Look in the current method
							else if(thisScope instanceof MethodSym){
								Sym result = ((MethodSym)thisScope).getVar(path[index]);
								if(result != null){
									return result;
								}
								thisScope = thisScope.parent;
								scopePath = thisScope.path;
							}
							else{
								return null;
							}
						}
						//If not, search classes and variables
						else{
							if(thisScope == null){
								return null;
							}
							else if(thisScope instanceof SageSym){
								Sym result = ((SageSym)thisScope).getClass(path[index]);
								if(result != null && result.is_static){
									found = true;
									thisScope = result;
									scopePath = thisScope.path;
								}
								else if(result != null && !result.is_static){
									//Print error message here
									return null;
								}

								result = ((SageSym)thisScope).getVar(path[index]);
								if(result != null){
									found = true;
									thisScope = ((VarSym)result).type.idSym;
									scopePath = thisScope.path;
								}
								else{
									thisScope = thisScope.parent;
									scopePath = thisScope.path;
								}

							}
							else if(thisScope instanceof ClassSym){
								Sym result = ((ClassSym)thisScope).getClass(path[index]);
								if(result != null && result.is_static){
									found = true;
									thisScope = result;
									scopePath = thisScope.path;
								}
								else if(result != null && !result.is_static){
									//Print error message here
									return null;
								}

								result = ((ClassSym)thisScope).getVar(path[index]);
								if(result != null){
									found = true;
									thisScope = ((VarSym)result).type.idSym;
									scopePath = thisScope.path;
								}
								else{
									thisScope = thisScope.parent;
									scopePath = thisScope.path;
								}
							}
							else if(thisScope instanceof MethodSym){
								//Check to see if are within a method scope first
								if(thisMethodScope == null){
									Sym result = ((MethodSym)thisScope).getVar(path[index]);
									if(result != null){
										found = true;
										thisScope = ((VarSym)result).type.idSym;
										scopePath = thisScope.path;
									}
									else{
										thisScope = thisScope.parent;
										scopePath = thisScope.path;
									}
								}
								else{
									Sym result = thisMethodScope.getVar(path[index]);
									if(result != null){
										thisScope = ((VarSym)result).type.idSym;
										found = true;
										thisMethodScope = null;
										scopePath = thisScope.path;
									}
									else{
										thisMethodScope = thisMethodScope.parent;
										scopePath = thisMethodScope.path;
									}
								}
							}
						}
					}
				}
				index++;
				//Sink down the rest of the path
				while(index < path.length){
					if(index == (path.length - 1)){
						//The last item may be a variable or method
						if(thisScope == null){
							return null;
						}
						else if(thisScope instanceof SageSym){
							Sym result = ((SageSym)thisScope).getVar(path[index]);
							if(result != null && result.protection != Sym.ProtectionLevel.PRIVATE)
								return result;
							result = ((SageSym)thisScope).getMethod(path[index]);
							if(result != null)
								return result;
						}
						else if(thisScope instanceof ClassSym){
							Sym result = ((ClassSym)thisScope).getVar(path[index]);
							if(result != null && (result.protection != Sym.ProtectionLevel.PRIVATE))
								return result;
							result =((ClassSym)thisScope).getMethod(path[index]);
							if(result != null && result.protection != Sym.ProtectionLevel.PRIVATE)
								return result;
						}
						else if(thisScope instanceof MethodSym){
							Sym result = ((MethodSym)thisScope).getVar(path[index]);
							if(result != null && result.protection != Sym.ProtectionLevel.PRIVATE)
								return result;
						}
						else{
							return null;
						}
					}
					else{
						//All items except the last may be variables or static classes
						//If it is a variable, go down to the type of the variable
						if(thisScope == null){
							return null;
						}
						else if(thisScope instanceof SageSym){
							Sym result = ((SageSym)thisScope).getClass(path[index]);
							if(result != null){
								if(result.protection == Sym.ProtectionLevel.PRIVATE && isInnerPath(scopePath) && result.is_static){
									thisScope = result;
									scopePath = thisScope.path;
								}
								else if(result.is_static){
									thisScope = result;
									scopePath = thisScope.path;
								}
								else{
									//Print error message here
									return null;
								}
							}
							else{
								result = ((SageSym)thisScope).getVar(path[index]);
								if(result != null){
									if(result.protection == Sym.ProtectionLevel.PRIVATE && isInnerPath(scopePath)){
										thisScope = ((VarSym)thisScope).type.idSym;
										scopePath = thisScope.path;
									}
									else{
										thisScope = ((VarSym)thisScope).type.idSym;
										scopePath = thisScope.path;
									}
								}
								else{
									return null;
								}
							}
						}
						else if(thisScope instanceof ClassSym){
							Sym result = ((ClassSym)thisScope).getClass(path[index]);
							if(result != null){
								if(result.protection == Sym.ProtectionLevel.PRIVATE && isInnerPath(scopePath) && result.is_static){
									thisScope = result;
									scopePath = thisScope.path;
								}
								else if(result.is_static){
									thisScope = result;
									scopePath = thisScope.path;
								}
								else{
									//Print error message here
									return null;
								}
							}
							else{
								result = ((ClassSym)thisScope).getVar(path[index]);
								if(result != null){
									if(result.protection == Sym.ProtectionLevel.PRIVATE && isInnerPath(scopePath)){
										thisScope = ((VarSym)thisScope).type.idSym;
										scopePath = thisScope.path;
									}
									else{
										thisScope = ((VarSym)thisScope).type.idSym;
										scopePath = thisScope.path;
									}
								}
								else{
									return null;
								}
							}
						}
						//Not allowed to access inner variables of methods
						else if(thisScope instanceof MethodSym){
							return null;
						}
						else{
							return null;
						}
					}
					index++;
				}
				return thisScope;
			}
		}
	}

	//Navigate up to the parent scope from the current one.
	public void floatScope() throws IllegalScopeException{
		if(currentMethodScope == null){
			if(currentScope != null && currentScope.parent != null){
				currentScope = currentScope.parent;
				currentPath = currentScope.path;
			}
			else{
				//Throw exception - illegal floating of scope
				throw new IllegalScopeException("Illegal transition to a scope that has no parent scope");
			}
		}
		else{
			currentMethodScope = currentMethodScope.parent;
			currentPath = currentMethodScope.path;
		}
	}

	//Navigate down to the child scope which is a class
	public void sinkToClassScope(String scopeName) throws IllegalScopeException{
		if(currentScope instanceof SageSym){
			currentScope = ((SageSym)currentScope).getClass(scopeName);
		}
		else if(currentScope instanceof ClassSym){
			currentScope = ((ClassSym)currentScope).getClass(scopeName);
		}
		else{
			//Throw exception - illegal navigation to a class scope
			throw new IllegalScopeException("Illegal transition to a class scope");
		}
		//Check if the scope is null
		if(currentScope != null){
			currentPath = currentScope.path;
		}
		else{
			throw new IllegalScopeException("Illegal transition to a class scope that does not exist");
		}
	}

	//Navigate down to the child scope which is a method
	public void sinkToMethodScope(String scopeName) throws IllegalScopeException{
		if(currentScope instanceof SageSym){
			currentScope = ((SageSym)currentScope).getMethod(scopeName);
		}
		else if(currentScope instanceof ClassSym){
			currentScope = ((ClassSym)currentScope).getMethod(scopeName);
			currentPath = currentScope.path;
		}
		else if(currentScope instanceof MethodSym){
			currentScope = ((MethodSym)currentScope).getMethodLiteral(scopeName);
		}
		else{
			//Throw exception - illegal navigation to a method scope
			throw new IllegalScopeException("Illegal transition to a function scope");
		}

		//Check if the scope is null
		if(currentScope != null){
			currentPath = currentScope.path;
		}
		else{
			throw new IllegalScopeException("Illegal transition to a method scope that does not exist");
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

		//Check if the scope is null
		if(currentScope != null){
			currentPath = currentMethodScope.path;
		}
		else{
			throw new IllegalScopeException("Illegal transition to an inner method scope that does not exist");
		}
	}

	//Returns the type of the symbol as a String identified by the String name.
	public String getType(String name){
		return null;
	}

	//Add a symbol to the current scope.
	public void addSymbol(Sym symbol){
		if(symbol instanceof SageSym){
			//Will work on later
		}
		else if(symbol instanceof ClassSym){
			if(currentScope instanceof SageSym){
				((SageSym)currentScope).addClass(symbol.name, (ClassSym)symbol);
			}
			else if(currentScope instanceof ClassSym){
				((ClassSym)currentScope).addClass(symbol.name, (ClassSym)symbol);
			}
			else{
				//Print error message here
			}
		}
		else if(symbol instanceof MethodSym){
			if(currentScope instanceof SageSym){
				((SageSym)currentScope).addMethod(symbol.name, (MethodSym)symbol);
			}
			else if(currentScope instanceof ClassSym){
				((ClassSym)currentScope).addMethod(symbol.name, (MethodSym)symbol);
			}
			else if(currentScope instanceof MethodSym){
				((MethodSym)currentScope).addMethodLiteral(symbol.name, (MethodSym)symbol);
			}
			else{
				//Print error message here
			}
		}
		else if(symbol instanceof VarSym){
			if(currentScope instanceof SageSym){
				((SageSym)currentScope).addVar(symbol.name, (VarSym)symbol);
			}
			else if(currentScope instanceof ClassSym){
				((ClassSym)currentScope).addVar(symbol.name, (VarSym)symbol);
			}
			else if((currentScope instanceof MethodSym) && currentMethodScope == null){
				((MethodSym)currentScope).addVar(symbol.name, (VarSym)symbol);
			}
			else if((currentScope instanceof MethodSym) && currentMethodScope != null){
				currentMethodScope.addVar(symbol.name, (VarSym)symbol);
			}
			else{
				//Print error message here
			}
		}
	}

	//Add an inner scope to the current method scope
	public void addMethodScope(MethodScope scope){
		if(currentMethodScope != null){
			currentMethodScope.addScope(scope.path, scope);
		}
		else if(currentScope instanceof MethodSym){
			((MethodSym)currentScope).addScope(scope.path, scope);
		}
		else{
			//Print error message
		}
	}

	//Returns the root of the symbol table
	public SageSym getRoot(){
		return root;
	}

	public void addImport(SymbolTable table){
		root.addTable(table.getRoot().name, table);
	}

	public Sym getCurrentScope(){
		return currentScope;
	}

	public MethodScope getCurrentMethodScope(){
		return currentMethodScope;
	}

	public String getPath(){
		return currentPath;
	}

	//Checks if the path makes up part of the currentPath
	private boolean isInnerPath(String path){
		return currentPath.startsWith(path);
	}
}