package filecatalog;
import ast.*;

public class CatalogItem{
	private Sage sage;
	private String name;
	private String path;

	public CatalogItem(Sage sage, String name, String path){
		this.sage = sage;
		this.name = name;
		this.path = path;
	}

	public Sage getSage(){
		return sage;
	}

	public String getName(){
		return name;
	}

	public String getPath(){
		return path;
	}
}