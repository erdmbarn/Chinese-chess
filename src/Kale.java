import javax.rmi.ssl.SslRMIClientSocketFactory;
import java.io.Serializable;

public class Kale extends Item implements Serializable {
    public Kale(String takim, String position) {
        super(takim, position,9);
    }

    public String toString() {
        if (takim.equals("B"))
            return "K";
        else
            return "k";
    }

    @Override
    public boolean move(int a, String to) {
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
        int[] test = new int[18];
        for(int i=0;i< test.length;i++)
        {
            test[i]=100;
        }
        String durulanyer = getPosition();
        char satir = durulanyer.charAt(0);
        int  satir1= 106-satir;
        char sutun = durulanyer.charAt(1);
        int sutun1= sutun-49;

        int num=0;


        for(int i = sutun1+1;i<9;i++)//sağa doğru gitme
        {
            if(!Board.tahta[satir1][i].toString().equals("-"))
            {
                if(!this.takim.equals(Board.tahta[satir1][i].takim))
                {

                        test[num] = satir1 * 10 + i;
                        num++;


                }
                break;
            }
            else {
                test[num] = satir1 * 10 + i;
                num++;

            }
        }
        for(int i = sutun1-1;0<=i;i--)//sola doğru gitme
        {
            if(!Board.tahta[satir1][i].toString().equals("-"))
            {
                if(!this.takim.equals(Board.tahta[satir1][i].takim))
                {

                    test[num] = satir1 * 10 + i;
                    num++;
                    //System.out.println("1");


                }
                break;
            }
            else {
                test[num] = satir1 * 10 + i;
                num++;
                //System.out.println("2");

            }
        }
        for(int i = satir1+1;i<=9;i++)//aşağı doğru gitme
        {
            if(!Board.tahta[i][sutun1].toString().equals("-"))
            {
                if(!this.takim.equals(Board.tahta[i][sutun1].takim))
                {

                    test[num] = i * 10 + sutun1;
                    num++;
                   // System.out.println("3");


                }
                break;
            }
            else {
                test[num] = i * 10 + sutun1;
                num++;
               // System.out.println("4");

            }
        }
        for(int i = satir1-1;0<=i;i--)//yukarı doğru gitme
        {
            if(!Board.tahta[i][sutun1].toString().equals("-"))
            {
                if(!this.takim.equals(Board.tahta[i][sutun1].takim))
                {

                    test[num] = i * 10 + sutun1;
                    num++;
                   // System.out.println("4");


                }
                break;
            }
            else {
                test[num] = i * 10 + sutun1;
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


