import java.io.Serializable;

public class Fil extends Item implements Serializable {




    public Fil(String takim,String position)
    {
        super(takim,position,2);

    }
    public String toString()
    {
        if(takim.equals("B"))
            return "F";
        else
            return "f";
    }

    @Override
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
                    /*Item gidilenyerdekiItem= Board.tahta[satir][sutun];//xx 101 yapılan
                    int gidilecekyerdekiint= Board.tahta[satir][sutun].positionnum;
                    String gidilecekyerdekistr= Board.tahta[satir][sutun].getPosition();

                    Item durulanyerdekiItem= Board.tahta[osatir][osutun];// to ve a yapılan
                    int durulanyerdekiint= Board.tahta[osatir][osutun].positionnum;
                    String durulanyerdekistr = Board.tahta[osatir][osutun].getPosition();*/

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
        int[] test = new int[4];
        test[0]=100;
        test[1]=100;
        test[2]=100;
        test[3]=100;
        String durulanyer = getPosition();
        char satir = durulanyer.charAt(0);
        int  satir1= 106-satir;
        char sutun = durulanyer.charAt(1);
        int sutun1= sutun-49;

        int num=0;
if(this.takim.equals("W")) {
    if (satir1 - 2 >= 5 && sutun1 + 2 <= 8) //yukarı sağ
    {
        if (Board.tahta[satir1 - 1][sutun1 + 1].takim.equals("E")) {
            if (!Board.tahta[satir1 - 2][sutun1 + 2].takim.equals(this.takim)) {
                test[num] = (satir1 - 2) * 10 + sutun1 + 2;
                num++;

            }
        }


    }

    if (satir1 - 2 >= 5 && sutun1 - 2 >= 0)//sol yukarı
    {
        if (Board.tahta[satir1 - 1][sutun1 - 1].takim.equals("E")) {
            if (!Board.tahta[satir1 - 2][sutun1 - 2].takim.equals(this.takim)) {
                test[num] = (satir1 - 2) * 10 + sutun1 - 2;
                num++;

            }
        }

    }
    if (satir1 + 2 <= 9 && sutun1 + 2 <= 8)//sağ aşağı
    {
        if (Board.tahta[satir1 + 1][sutun1 + 1].takim.equals("E")) {
            if (!Board.tahta[satir1 + 2][sutun1 + 2].takim.equals(this.takim)) {
                test[num] = (satir1 + 2) * 10 + sutun1 + 2;
                num++;

            }
        }

    }
    if (satir1 + 2 <= 9 && sutun1 - 2 >= 0)//sol aşağı
    {
        if (Board.tahta[satir1 + 1][sutun1 - 1].takim.equals("E")) {
            if (!Board.tahta[satir1 + 2][sutun1 - 2].takim.equals(this.takim)) {
                test[num] = (satir1 + 2) * 10 + sutun1 - 2;
                num++;

            }
        }

    }
}
else
{
    if (satir1 - 2 >= 0 && sutun1 + 2 <= 8) //yukarı sağ
    {
        if (Board.tahta[satir1 - 1][sutun1 + 1].takim.equals("E")) {
            if (!Board.tahta[satir1 - 2][sutun1 + 2].takim.equals(this.takim)) {
                test[num] = (satir1 - 2) * 10 + sutun1 + 2;
                num++;

            }
        }


    }

    if (satir1 - 2 >= 0 && sutun1 - 2 >= 0)//sol yukarı
    {
        if (Board.tahta[satir1 - 1][sutun1 - 1].takim.equals("E")) {
            if (!Board.tahta[satir1 - 2][sutun1 - 2].takim.equals(this.takim)) {
                test[num] = (satir1 - 2) * 10 + sutun1 - 2;
                num++;

            }
        }

    }
    if (satir1 + 2 <= 4 && sutun1 + 2 <= 8)//sağ aşağı
    {
        if (Board.tahta[satir1 + 1][sutun1 + 1].takim.equals("E")) {
            if (!Board.tahta[satir1 + 2][sutun1 + 2].takim.equals(this.takim)) {
                test[num] = (satir1 + 2) * 10 + sutun1 + 2;
                num++;

            }
        }

    }
    if (satir1 + 2 <= 4 && sutun1 - 2 >= 0)//sol aşağı
    {
        if (Board.tahta[satir1 + 1][sutun1 - 1].takim.equals("E")) {
            if (!Board.tahta[satir1 + 2][sutun1 - 2].takim.equals(this.takim)) {
                test[num] = (satir1 + 2) * 10 + sutun1 - 2;
                num++;

            }
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
