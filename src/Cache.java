
public class Cache {
	Block[] bl=new Block[16]; 
	int i=0;
	public void add2Cache(int add, int val) {
		if(i>16)
		{
			i=0;
		}
		bl[i++].addBlock(add, val);
	}
	public int getFromCache(int tag) {
		 for(int j=0;j<16;j++)
		 {
			 if(bl[j].getTag()==tag)
			 {
				 return bl[j].getVal();
			 }
		 }
		 return -1;
	}
}
