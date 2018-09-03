package ast;
import symboltable.*;
import java.lang.StringBuilder;
import java.util.ArrayList;

public class Sage extends Node{
	public Identifier i;
	public DefList d;
	public Program p;
	public UsingList u;

	public Sage(Identifier i, DefList d, UsingList u, int line, int column){
		this.i = i;
		this.d = d;
		this.p = null;
		this.u = u;
		this.line = line;
		this.column = column;
	}

	public Sage(Identifier i, Program p, UsingList u, int line, int column){
		this.i = i;
		this.p = p;
		this.d = null;
		this.u = u;
		this.line = line;
		this.column = column;
	}

	public void accept(VoidVisitor v){
		v.visit(this);
	}

	public Sym accept(Visitor v){
		return v.visit(this);
	}

	public ArrayList<String> getUsings(){
		//Poor naming conventions are coming back to haunt me :(
		ArrayList<String> files = new ArrayList<String>();
		for(Using usingItem : u.l){
			StringBuilder name = new StringBuilder(usingItem.i.i);	//First part of the name
			for(Identifier id : usingItem.chain.chain){
				name.append("/");
				name.append(id.i);
			}
			//Append the file extension
			name.append(".ocar");
			files.add(name.toString());
		}
		return files;
	}
}