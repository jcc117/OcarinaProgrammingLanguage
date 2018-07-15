package ast;
import java.util.ArrayList;

public class UsingList{
	ArrayList<Using> l;

	public UsingList(){
		l = new ArrayList<Using>();
	}

	public void add(Using u){
		l.add(u);
	}
}