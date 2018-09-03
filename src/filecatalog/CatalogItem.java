package filecatalog;
import ast.*;

public class CatalogItem{
	private Sage sage;
	private String name;

	public CatalogItem(Sage sage){
		this.sage = sage;
		name = "";	//Temporary for now
	}

	public Sage getSage(){
		return sage;
	}

	public String getName(){
		return name;
	}
}