package filecatalog;
import java.util.*;
import ast.*;

public class FileCatalog{
	private ArrayList<CatalogItem> fc;
	public FileCatalog(){
		fc = new ArrayList<CatalogItem>();
	}

	public void add(CatalogItem f){
		fc.add(f);
	}

	public CatalogItem get(int i){
		return fc.get(i);
	}

	public boolean contains(CatalogItem f){
		return fc.contains(f);
	}

	public int size(){
		return fc.size();
	}
}