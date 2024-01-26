import java.io.Serializable;

public class Sah extends Item implements Serializable {
    public Sah(String takim, String position) {
        super(takim, position,0);

    }

    public String toString() {
        if (takim.equals("B"))
            return "Ş";
        else
            return "ş";
    }

    public boolean move(int a, String to) {
        int[] test1 = gidebilecegiYerler();
        int satir = a / 10;
        int sutun = a % 10;
        int osatir = positionnum / 10;
        int osutun = positionnum % 10;

        for (int i = 0; i < test1.length; i++) {
            if (test1[i] == a) {
                if (!Board.tahta[satir][sutun].takim.equals("E")) {
                    Board.tahta[satir][sutun].setPosition("xx");
                    Board.tahta[satir][sutun].setPositionnum(101);
                    Board.tahta[satir][sutun] = this;
                    Board.tahta[osatir][osutun] = new Bosluk("E", getPosition());
                    Board.tahta[satir][sutun].setPosition(to);
                    Board.tahta[satir][sutun].setPositionnum(a);

                } else {
                    Board.tahta[satir][sutun] = this;
                    Board.tahta[osatir][osutun] = new Bosluk("E", getPosition());
                    Board.tahta[satir][sutun].setPosition(to);
                    Board.tahta[satir][sutun].setPositionnum(a);

                }
                return true;
            }
        }
        return false;


    }

    public int[] gidebilecegiYerler() {
        int satir = positionnum / 10;
        int sutun = positionnum % 10;
        int[] test = new int[4];
        int num = 0;

        if (this.takim.equals("W")) {
            if ( sutun + 1 <= 5)//sağ
            {
                if (!Board.tahta[satir][sutun + 1].takim.equals(this.takim)) {
                    test[num] = (satir ) * 10 + sutun + 1;
                    num++;
                }
            }
            if(sutun-1>=3)//sol
            {
                if (!Board.tahta[satir][sutun -1].takim.equals(this.takim)) {
                    test[num] = (satir ) * 10 + sutun - 1;
                    num++;
                }

            }
            if(satir-1>=7)//yukarı
            {
                if (!Board.tahta[satir-1][sutun].takim.equals(this.takim)) {
                    test[num] = (satir-1 ) * 10 + sutun ;
                    num++;
                }
            }
            if(satir+1<=9)//aşağı
            {
                if (!Board.tahta[satir+1][sutun ].takim.equals(this.takim)) {
                    test[num] = (satir+1 ) * 10 + sutun ;
                    num++;
                }
            }

        }
        else
        {
            if(sutun+1<=5)//sağ
            {
                if (!Board.tahta[satir][sutun + 1].takim.equals(this.takim)) {
                    test[num] = (satir ) * 10 + sutun + 1;
                    num++;
                }
            }
            if(sutun-1>=3)//sol
            {
                if (!Board.tahta[satir][sutun -1].takim.equals(this.takim)) {
                    test[num] = (satir ) * 10 + sutun - 1;
                    num++;
                }

            }
            if(satir-1>=0)//yukarı
            {
                if (!Board.tahta[satir-1][sutun].takim.equals(this.takim)) {
                    test[num] = (satir-1 ) * 10 + sutun ;
                    num++;
                }
            }
            if(satir+1<=2)//aşağı
            {
                if (!Board.tahta[satir+1][sutun ].takim.equals(this.takim)) {
                    test[num] = (satir+1 ) * 10 + sutun ;
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
