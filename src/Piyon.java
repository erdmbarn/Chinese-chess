import java.io.Serializable;

public class Piyon extends Item implements Serializable {

    public Piyon(String takim,String position)
    {
        super(takim,position,1);

    }
    public String toString()
    {
        if(takim.equals("B"))
            return "P";
        else
            return "p";
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
        int [] test = new int[3];
        for(int i=0;i< test.length;i++)
        {
            test[i]=100;
        }
        int num=0;
        if(this.takim.equals("W"))//beyaz
        {
            if(satir>=5) //dik ilerleme nehir gerisi;
            {
                if(!this.takim.equals(Board.tahta[satir - 1][sutun].takim)) {
                    test[num] = (satir - 1) * 10 + sutun;
                }

            }
            else
            {
                if((satir-1)>=0)// dik ilerleme nehir ilerisi
                {
                    if(!this.takim.equals(Board.tahta[satir - 1][sutun].takim)) {
                        test[num] = (satir - 1) * 10 + sutun;
                        num++;
                    }

                }
                if((sutun+1)<=8)//sağa ilerleme nehir ilerisi
                {
                    if(!this.takim.equals(Board.tahta[satir][sutun+1].takim)) {
                        test[num] = (satir) * 10 + sutun + 1;
                        num++;
                    }
                }
                if((sutun-1)>=0)//sola ilerleme nehir ilerisi
                {
                    if(!this.takim.equals(Board.tahta[satir][sutun-1].takim)) {
                        test[num] = (satir) * 10 + sutun - 1;
                    }
                }


            }

        }
        else//siyah
        {
            if(satir<=4) //dik ilerleme nehir gerisi;
            {
                if(!this.takim.equals(Board.tahta[satir +1][sutun].takim)) {
                    test[num] = (satir +1) * 10 + sutun;
                }

            }
            else
            {
                if((satir+1)<=9)// dik ilerleme nehir ilerisi
                {
                    if(!this.takim.equals(Board.tahta[satir +1][sutun].takim)) {
                        test[num] = (satir +1) * 10 + sutun;
                        num++;
                    }

                }
                if((sutun+1)<=8)//sağa ilerleme nehir ilerisi
                {
                    if(!this.takim.equals(Board.tahta[satir][sutun+1].takim)) {
                        test[num] = (satir) * 10 + sutun + 1;
                        num++;
                    }
                }
                if((sutun-1)>=0)//sola ilerleme nehir ilerisi
                {
                    if(!this.takim.equals(Board.tahta[satir][sutun-1].takim)) {
                        test[num] = (satir) * 10 + sutun - 1;
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
