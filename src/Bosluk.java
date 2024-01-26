
import java.io.Serializable;

public class Bosluk extends Item implements Serializable {

    public Bosluk(String takim,String position)
    {
        super("E",position,0);
    }
    public String toString()
    {
        return "-";
    }
    @Override
    public void setOldposition(String oldposition) {
        super.setOldposition(oldposition);
    }

    @Override
    public void setOldpositionnum(int oldpositionnum) {
        super.setOldpositionnum(oldpositionnum);
    }

    @Override
    public void setPosition(String position) {
        super.setPosition(position);
    }

    @Override
    public void setPositionnum(int positionnum) {
        super.setPositionnum(positionnum);
    }



}
