import java.io.Serializable;

public class Item extends AbstractItem implements Serializable {



	public Item(String takim,String position,float puan)
	{
		super(takim,position,puan);

	}



	@Override
	public boolean move(int a,String to) {
		return true;



	}
	public int[] gidebilecegiYerler()
	{
		return new int[1];

	}


}
