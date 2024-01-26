import java.io.Serializable;

public class At extends Item implements Serializable {
    public At(String takim,String position)
    {
        super(takim,position,4.5f);

    }
    public String toString()
    {
        if(takim.equals("B"))
            return "A";
        else
            return "a";
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
        int [] test = new int[8];
        for(int i=0;i< test.length;i++)
        {
            test[i]=100;
        }
        int num=0;


        if (satir - 2 >= 0 && sutun + 1 <= 8) //yukarı sağ
        {
            if (Board.tahta[satir - 1][sutun].takim.equals("E")) {
                if (!Board.tahta[satir - 2][sutun + 1].takim.equals(this.takim)) {
                    test[num] = (satir - 2) * 10 + sutun + 1;
                    num++;

                }
            }


        }
        if (satir - 2 >= 0 && sutun - 1 >= 0) // yukarı sol
        {
            if (Board.tahta[satir - 1][sutun].takim.equals("E")) {
                if (!Board.tahta[satir - 2][sutun -1].takim.equals(this.takim)) {
                    test[num] = (satir - 2) * 10 + sutun - 1;
                    num++;

                }
            }


        }
        if(satir-1>=0 && sutun+2<=8)//sağ yukarı
        {

            if (Board.tahta[satir ][sutun+1].takim.equals("E")) {
                if (!Board.tahta[satir - 1][sutun +2].takim.equals(this.takim)) {
                    test[num] = (satir - 1) * 10 + sutun +2;
                    num++;

                }
            }

        }
        if(satir+1<=9 && sutun+2<=8)//sağ aşağı
        {
            if (Board.tahta[satir][sutun+1].takim.equals("E")) {
                if (!Board.tahta[satir + 1][sutun +2].takim.equals(this.takim)) {
                    test[num] = (satir + 1) * 10 + sutun +2;
                    num++;

                }
            }

        }
        if(satir+2<=9&& sutun+1<=8)//aşağı sağ
        {
            if (Board.tahta[satir+1][sutun].takim.equals("E")) {
                if (!Board.tahta[satir + 2][sutun +1].takim.equals(this.takim)) {
                    test[num] = (satir + 2) * 10 + sutun +1;
                    num++;

                }
            }

        }
        if(satir+2<=9&& sutun-1>=0)//aşağı sol
        {
            if (Board.tahta[satir+1][sutun].takim.equals("E")) {
                if (!Board.tahta[satir + 2][sutun -1].takim.equals(this.takim)) {
                    test[num] = (satir + 2) * 10 + sutun -1;
                    num++;

                }
            }

        }
        if(satir-1>=0&&sutun-2>=0)//sol yukarı
        {
            if (Board.tahta[satir][sutun-1].takim.equals("E")) {
                if (!Board.tahta[satir -1][sutun -2].takim.equals(this.takim)) {
                    test[num] = (satir -1) * 10 + sutun -2;
                    num++;

                }
            }

        }
        if(satir+1<=9&&sutun-2>=0)//sol yukarı
        {
            if (Board.tahta[satir][sutun-1].takim.equals("E")) {
                if (!Board.tahta[satir +1][sutun -2].takim.equals(this.takim)) {
                    test[num] = (satir +1) * 10 + sutun -2;
                    num++;

                }
            }

        }
        return test;


    }

    @Override
    public  void setOldposition(String oldposition) {
        super.setOldposition(oldposition);
    }

    @Override
    public  void setOldpositionnum(int oldpositionnum) {
        super.setOldpositionnum(oldpositionnum);
    }

    @Override
    public void setPosition(String position) {
        super.setPosition(position);
    }

    @Override
    public  void setPositionnum(int positionnum) {
        super.setPositionnum(positionnum);
    }
}
