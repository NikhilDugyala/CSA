
public class Memory {
	private int[] MEM=new int[4096];
	public void setMemory(int add, int val) {
		MEM[add]=val;
	}
	public int getMemory(int add) {
		return MEM[add];
	}
}
