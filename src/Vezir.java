import java.io.Serializable;

public class Vezir extends Item implements Serializable {
    public Vezir(String takim,String position)
    {
        super(takim,position,2);
    }
    public String toString()
    {
        if(takim.equals("B"))
            return "V";
        else
            return "v";
    }
    public boolean move(int a,String to) {
        int[] test1= gidebilecegiYerler();
        int satir = a/10;
        int sutun = a%10;
        int osatir = positionnum/10;
        int osutun = positionnum%10;

        for(int i=0;i< test1.length;i++)
        {
            if(test1[i]==a)
            {
                if(!Board.tahta[satir][sutun].takim.equals("E"))
                {
                    Board.tahta[satir][sutun].setPosition("xx");
                    Board.tahta[satir][sutun].setPositionnum(101);
                    Board.tahta[satir][sutun]=this;
                    Board.tahta[osatir][osutun]=new Bosluk("E",getPosition());
                    Board.tahta[satir][sutun].setPosition(to);
                    Board.tahta[satir][sutun].setPositionnum(a);

                }
                else
                {
                    Board.tahta[satir][sutun]=this;
                    Board.tahta[osatir][osutun]=new Bosluk("E",getPosition());
                    Board.tahta[satir][sutun].setPosition(to);
                    Board.tahta[satir][sutun].setPositionnum(a);

                }
                return true;
            }
        }
        return false;


    }

    @Override
    public int[] gidebilecegiYerler() {
        int satir = positionnum/10;
        int sutun = positionnum%10;
        int [] test = new int[4];
        int num=0;

        if(this.takim.equals("W")) {
            if(satir-1>=7&&sutun+1<=5)//sağ yukarı
            {
                if(!Board.tahta[satir - 1][sutun + 1].takim.equals(this.takim))
                {
                    test[num]=(satir-1)*10+sutun+1;
                    num++;
                }
            }
            if(satir-1>=7&&sutun-1>=3)//sol yukarı
            {
                if(!Board.tahta[satir-1][sutun-1].takim.equals(this.takim)) {
                    test[num] = (satir - 1) * 10 + sutun - 1;
                    num++;
                }
            }
            if(satir+1<=9&&sutun+1<=5)//sağ aşağı
            {
                if(!Board.tahta[satir+1][sutun+1].takim.equals(this.takim)) {
                    test[num] = (satir + 1) * 10 + sutun + 1;
                    num++;
                }

            }
            if(satir+1<=9&&sutun-1>=3)//sol aşağı
            {
                if(!Board.tahta[satir+1][sutun-1].takim.equals(this.takim)) {
                    test[num] = (satir +1) * 10 + sutun - 1;
                    num++;
                }
            }
        }
        else
        {
            if(satir-1>=0&&sutun+1<=5)//sağ yukarı
            {
                if(!Board.tahta[satir-1][sutun+1].takim.equals(this.takim)) {
                    test[num] = (satir - 1) * 10 + sutun +1;
                    num++;
                }
            }
            if(satir-1>=0&&sutun-1>=3)//sol yukarı
            {
                if(!Board.tahta[satir-1][sutun-1].takim.equals(this.takim)) {
                    test[num] = (satir - 1) * 10 + sutun - 1;
                    num++;
                }
            }
            if(satir+1<=2&&sutun+1<=5)//sağ aşağı
            {
                if(!Board.tahta[satir+1][sutun+1].takim.equals(this.takim)) {
                    test[num] = (satir + 1) * 10 + sutun + 1;
                    num++;
                }
            }
            if (satir+1<=2&&sutun-1>=3)//sol aşağı
            {
                if(!Board.tahta[satir+1][sutun-1].takim.equals(this.takim)) {
                    test[num] = (satir + 1) * 10 + sutun - 1;
                    num++;
                }
            }
        }
        return test;

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
