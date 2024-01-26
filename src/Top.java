import java.io.Serializable;

public class Top extends Item implements Serializable {
    public Top(String takim,String position)
    {
        super(takim,position,4);
    }
    public String toString()
    {
        if(takim.equals("B"))
            return "T";
        else
            return "t";
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

    @Override
    public int[] gidebilecegiYerler() {
        int satir = positionnum / 10;
        int sutun = positionnum % 10;
        int[] test = new int[18];

        for(int i=0;i< test.length;i++)
        {
            test[i]=100;
        }

        int num = 0;
            for (int i = sutun + 1; i < 9; i++)//sağa doğru gitme
            {
                if (!Board.tahta[satir][i].toString().equals("-")) {
                    for (int k = i + 1; k <= 8; k++) {
                        if (!Board.tahta[satir][k].takim.equals("E") && !this.takim.equals(Board.tahta[satir][k].takim)) {
                            test[num] = satir * 10 + k;
                            num++;
                            break;
                        }
                    }
                    break;
                } else {
                    test[num] = satir * 10 + i;
                    num++;

                }
            }
            for (int i = sutun - 1; 0 <= i; i--)//sola doğru gitme
            {
                if (!Board.tahta[satir][i].toString().equals("-")) {
                    for (int k = i - 1; k >= 0; k--) {
                        if (!Board.tahta[satir][k].takim.equals("E") && !this.takim.equals(Board.tahta[satir][k].takim)) {
                            test[num] = satir * 10 + k;
                            num++;
                            break;
                        }
                    }
                    break;
                } else {
                    test[num] = satir * 10 + i;
                    num++;
                    //System.out.println("2");

                }
            }
            for (int i = satir + 1; i <= 9; i++)//aşağı doğru gitme
            {
                if (!Board.tahta[i][sutun].toString().equals("-")) {
                    for (int k = i + 1; k <= 9; k++) {
                        if (!Board.tahta[k][sutun].takim.equals("E") && !this.takim.equals(Board.tahta[k][sutun].takim)) {
                            test[num] = k * 10 + sutun;
                            num++;
                            break;
                        }
                    }
                    break;
                } else {
                    test[num] = i * 10 + sutun;
                    num++;
                    // System.out.println("4");

                }
            }
            for (int i = satir - 1; 0 <= i; i--)//yukarı doğru gitme
            {
                if (!Board.tahta[i][sutun].toString().equals("-")) {
                    for (int k = i - 1; k >= 0; k--) {
                        if (!Board.tahta[k][sutun].takim.equals("E") && !this.takim.equals(Board.tahta[k][sutun].takim)) {
                            test[num] = k * 10 + sutun;
                            num++;
                            break;
                        }
                    }
                    break;
                } else {
                    test[num] = i * 10 + sutun;
                    num++;
                    //System.out.println("5");

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
