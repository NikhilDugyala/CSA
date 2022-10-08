
public class Block {
	private int tag;
	private int val;
	public Block() {
		super();
	}
	public Block(int tag, int val) {
		super();
		this.tag = tag;
		this.val = val;
	}
	public void addBlock(int tag, int val) {
		this.tag = tag;
		this.val = val;
	}
	public int getTag() {
		return tag;
	}
	public void setTag(int tag) {
		this.tag = tag;
	}
	public int getVal() {
		return val;
	}
	public void setVal(int val) {
		this.val = val;
	}
}
