import java.io.Serializable;

public class Player implements Serializable {
	String takim;
	
	float puan; // her taş yedikçe oyuncunun puanı taşın puanına göre artar.

	public Player(String takim)
	{
		this.takim=takim;
		puan=0.0f;

	}

}
