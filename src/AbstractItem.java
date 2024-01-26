import java.io.Serializable;

public abstract class AbstractItem implements ItemInterface, Serializable {
	String takim;

	private String position;
	private String oldposition;
	int positionnum;
	//static Board oyuntahtasi;// tahtadaki konumu gösterir. Örneğin, a1
	float point;
	int oldpositionnum;


	public AbstractItem(String takim, String position,float puan)
	{
		this.takim=takim;
		this.position=position;
		this.oldposition=position;
		char tosatir=position.charAt(0);
		char tosutun=position.charAt(1);
		int tointsatir= 106-tosatir;
		int tointsutun= tosutun -49;

		positionnum=tointsatir*10+tointsutun;
		oldpositionnum=tointsatir*10+tointsutun;
		point=puan;



	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public void setPositionnum(int positionnum) {
		this.positionnum = positionnum;
	}

	public int getPositionnum() {
		return positionnum;
	}

	public int getOldpositionnum() {
		return oldpositionnum;
	}

	public String getOldposition() {
		return oldposition;
	}

	public void setOldposition(String oldposition) {
		this.oldposition = oldposition;
	}

	public void setOldpositionnum(int oldpositionnum) {
		this.oldpositionnum = oldpositionnum;
	}
}
