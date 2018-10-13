package symboltable;

public abstract class Sym{
	public enum ProtectionLevel{
		PRIVATE, NONE, PROTECTED, PUBLIC;
	}

	public int line;
	public int column;
	public String name;
	public boolean is_static;
	public ProtectionLevel protection;
	public boolean is_initialized;
	public Sym parent;
	public String path;
}