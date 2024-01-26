import java.io.*;
import java.util.Scanner;
import java.util.stream.Stream;

public class Game extends AbstractGame implements Serializable {
    int sira=1;




    public Game(String one, String two)
    {
        this.red=new Player(one);
        this.black=new Player(two);

        this.board=new Board();
    }



    public void play(String from,String to)

    {
        if(from.length()==2&&to.length()==2&&from.charAt(0)>96&&from.charAt(0)<107&&from.charAt(1)>48&&from.charAt(1)<58&&to.charAt(0)>96&&to.charAt(0)<107&&to.charAt(1)>48&&to.charAt(1)<58) {
            char satir = from.charAt(0);
            int satir1 = 106 - satir;
            char sutun = from.charAt(1);
            int sutun1 = sutun - 49;
            //System.out.println(satir1);
            //System.out.println(sutun1);
            char tosatir = to.charAt(0);
            char tosutun = to.charAt(1);
            int tointsatir = 106 - tosatir;
            int tointsutun = tosutun - 49;

            int toint = tointsatir * 10 + tointsutun;


            if (sira == 1 && Board.tahta[satir1][sutun1].takim.equals("W")) {
                Item gidilenyerdekiItem = Board.tahta[tointsatir][tointsutun];//xx 101 yapılan
                int gidilecekyerdekiint = Board.tahta[tointsatir][tointsutun].oldpositionnum;
                String gidilecekyerdekistr = Board.tahta[tointsatir][tointsutun].getOldposition();
                float eatpuan = gidilenyerdekiItem.point;

                Item durulanyerdekiItem = Board.tahta[satir1][sutun1]; //to ve a yapılan
                int durulanyerdekiint = Board.tahta[satir1][sutun1].oldpositionnum;
                String durulanyerdekistr = Board.tahta[satir1][sutun1].getOldposition();
                if (Board.tahta[satir1][sutun1].move(toint, to)) {
                    if (kendicheck("W") || sahkurali()) {
                        gidilenyerdekiItem.setPositionnum(gidilecekyerdekiint);
                        gidilenyerdekiItem.setPosition(gidilecekyerdekistr);
                        Board.tahta[tointsatir][tointsutun] = gidilenyerdekiItem;
                        durulanyerdekiItem.setPositionnum(durulanyerdekiint);
                        durulanyerdekiItem.setPosition(durulanyerdekistr);
                        Board.tahta[satir1][sutun1] = durulanyerdekiItem;

                        System.out.println("hatali hareket");
                        sira = 1;

                    } else {
                        Board.tahta[satir1][sutun1].setOldpositionnum(Board.tahta[satir1][sutun1].getPositionnum());
                        Board.tahta[satir1][sutun1].setOldposition(Board.tahta[satir1][sutun1].getPosition());
                        Board.tahta[tointsatir][tointsutun].setOldpositionnum(Board.tahta[tointsatir][tointsutun].getPositionnum());
                        Board.tahta[tointsatir][tointsutun].setOldposition(Board.tahta[tointsatir][tointsutun].getPosition());
                        red.puan = red.puan + eatpuan;
                        if (check("W")) {
                            if (checkMate("W")) {
                                System.out.println("ŞAH MAT! " + red.takim + " oyunu kazandı. " + red.takim + "'nın puanı: " + red.puan + ", " + black.takim + "'nin puanı: " + black.puan);

                                sira = 0;

                            } else {
                                sira = 2;
                            }

                        } else {
                            sira = 2;
                        }
                    }


                }
            } else {
                if (sira == 2 && Board.tahta[satir1][sutun1].takim.equals("B")) {

                    Item gidilenyerdekiItem = Board.tahta[tointsatir][tointsutun];//xx 101 yapılan
                    int gidilecekyerdekiint = Board.tahta[tointsatir][tointsutun].oldpositionnum;
                    String gidilecekyerdekistr = Board.tahta[tointsatir][tointsutun].getOldposition();
                    float eatpuan = gidilenyerdekiItem.point;

                    Item durulanyerdekiItem = Board.tahta[satir1][sutun1]; //to ve a yapılan
                    int durulanyerdekiint = Board.tahta[satir1][sutun1].oldpositionnum;
                    String durulanyerdekistr = Board.tahta[satir1][sutun1].getOldposition();
                    if (Board.tahta[satir1][sutun1].move(toint, to)) {
                        if (kendicheck("B") || sahkurali()) {
                            gidilenyerdekiItem.setPositionnum(gidilecekyerdekiint);
                            gidilenyerdekiItem.setPosition(gidilecekyerdekistr);
                            Board.tahta[tointsatir][tointsutun] = gidilenyerdekiItem;
                            durulanyerdekiItem.setPositionnum(durulanyerdekiint);
                            durulanyerdekiItem.setPosition(durulanyerdekistr);
                            Board.tahta[satir1][sutun1] = durulanyerdekiItem;
                            System.out.println("hatali hareket");
                            sira = 2;

                        } else {
                            Board.tahta[satir1][sutun1].setOldpositionnum(Board.tahta[satir1][sutun1].getPositionnum());
                            Board.tahta[satir1][sutun1].setOldposition(Board.tahta[satir1][sutun1].getPosition());
                            Board.tahta[tointsatir][tointsutun].setOldpositionnum(Board.tahta[tointsatir][tointsutun].getPositionnum());
                            Board.tahta[tointsatir][tointsutun].setOldposition(Board.tahta[tointsatir][tointsutun].getPosition());
                            black.puan = black.puan + eatpuan;


                            if (check("B")) {
                                if (checkMate("B")) {
                                    System.out.println("ŞAH MAT! " + black.takim + " oyunu kazandı. " + black.takim + "'nın puanı: " + black.puan + ", " + red.takim + "'nin puanı: " + red.puan);
                                    sira = 0;

                                } else {
                                    sira = 1;
                                }

                            } else {
                                sira = 1;
                            }
                        }


                    }
                } else {
                    System.out.println("hatali hareket");

                }
            }
        }
        else
        {
            System.out.println("hatali hareket");
        }



    }

    public Board getBoard()
    {
        return board;

    }
    public boolean sahkurali()
    {
        int siyahsahsatiri=board.items[4].positionnum/10;
        int siyahsahsutunu=board.items[4].positionnum%10;

        int beyazsahsatiri=board.items[27].positionnum/10;
        int beyazsahsutunu=board.items[27].positionnum%10;

        if(siyahsahsutunu==beyazsahsutunu)
        {
            for(int i=siyahsahsatiri+1;i<beyazsahsatiri;i++)
            {
                if(!Board.tahta[i][siyahsahsutunu].takim.equals("E"))
                {
                    return false;
                }
            }
        }
        else {
            return false;
        }
        return true;

    }
    public boolean kendicheck(String takim)
    {
        if(takim.equals("W"))
        {
            int sahstop=board.items[27].positionnum;
            for(int i=0;i<16;i++)
            {
                if(!board.items[i].getPosition().equals("xx"))
                {
                    int[] sg = board.items[i].gidebilecegiYerler();
                    for(int k = 0;k< sg.length;k++)
                    {
                        if(sahstop==sg[k])
                        {
                            return true;
                        }
                    }
                }
            }
        }
        else
        {
            int sahstop=board.items[4].positionnum;
            for(int i=16;i<32;i++)
            {
                if(!board.items[i].getPosition().equals("xx"))
                {
                    int[] sg = board.items[i].gidebilecegiYerler();
                    for(int k = 0;k< sg.length;k++)
                    {
                        if(sahstop==sg[k])
                        {
                            return true;
                        }
                    }
                }
            }

        }
        return false;

    }
    public boolean check(String takim)
    {
        if(takim.equals("W"))
        {
            int sahstop=board.items[4].positionnum;
            for(int i=16;i<32;i++)
            {
                if(!board.items[i].getPosition().equals("xx"))
                {
                    int[] sg = board.items[i].gidebilecegiYerler();
                    for(int k = 0;k< sg.length;k++)
                    {
                        if(sahstop==sg[k])
                        {
                            return true;
                        }
                    }
                }
            }

        }
        else
        {
            int sahstop=board.items[27].positionnum;
            for(int i=0;i<16;i++)
            {
                if(!board.items[i].getPosition().equals("xx"))
                {
                    int[] sg = board.items[i].gidebilecegiYerler();
                    for(int k = 0;k< sg.length;k++)
                    {
                        if(sahstop==sg[k])
                        {
                            return true;
                        }
                    }
                }
            }

        }
        return false;
    }
    public boolean checkMate(String takim)
    {
        if(takim.equals("W"))
        {
            for(int i=0;i<=9;i++)
            {
                for(int k=0;k<=8;k++)
                {
                    Item gidilenyerdekiItem= Board.tahta[i][k];//xx 101 yapılan
                    int gidilecekyerdekiint= Board.tahta[i][k].oldpositionnum;
                    String gidilecekyerdekistr= Board.tahta[i][k].getOldposition();
                    for(int j=0;j<=15;j++)
                    {
                        if(!board.items[j].getPosition().equals("xx")) {
                            Item durulanyerdekiItem = board.items[j];//to a yapılan
                            int durulanyerdekiint = durulanyerdekiItem.oldpositionnum;
                            int satir = durulanyerdekiint / 10;
                            int sutun = durulanyerdekiint % 10;
                            String durulanyerdekistr = durulanyerdekiItem.getOldposition();

                            if (board.items[j].move(gidilecekyerdekiint, gidilecekyerdekistr)) {
                                if (sahkurali() || check("W")) {
                                    Board.tahta[i][k] = gidilenyerdekiItem;
                                    gidilenyerdekiItem.setPositionnum(gidilecekyerdekiint);
                                    gidilenyerdekiItem.setPosition(gidilecekyerdekistr);
                                    Board.tahta[satir][sutun] = durulanyerdekiItem;
                                    durulanyerdekiItem.setPosition(durulanyerdekistr);
                                    durulanyerdekiItem.setPositionnum(durulanyerdekiint);

                                }
                                else
                                {
                                    Board.tahta[i][k] = gidilenyerdekiItem;
                                    gidilenyerdekiItem.setPositionnum(gidilecekyerdekiint);
                                    gidilenyerdekiItem.setPosition(gidilecekyerdekistr);
                                    Board.tahta[satir][sutun] = durulanyerdekiItem;
                                    durulanyerdekiItem.setPosition(durulanyerdekistr);
                                    durulanyerdekiItem.setPositionnum(durulanyerdekiint);

                                    return false;
                                }
                            }
                           /* else
                            {
                                Board.tahta[i][k] = gidilenyerdekiItem;
                                gidilenyerdekiItem.setPositionnum(gidilecekyerdekiint);
                                gidilenyerdekiItem.setPosition(gidilecekyerdekistr);
                                Board.tahta[satir][sutun] = durulanyerdekiItem;
                                durulanyerdekiItem.setPosition(durulanyerdekistr);
                                durulanyerdekiItem.setPositionnum(durulanyerdekiint);

                            }*/

                        }
                    }
                }
            }
            return true;

        }
        else
        {
            for(int i=0;i<=9;i++)
            {
                for(int k=0;k<=8;k++)
                {
                    Item gidilenyerdekiItem= Board.tahta[i][k];//xx 101 yapılan
                    int gidilecekyerdekiint= Board.tahta[i][k].positionnum;
                    String gidilecekyerdekistr= Board.tahta[i][k].getPosition();
                    for(int j=16;j<=31;j++)
                    {
                        if(!board.items[j].getPosition().equals("xx")) {
                            Item durulanyerdekiItem = board.items[j];//to a yapılan
                            int durulanyerdekiint = durulanyerdekiItem.positionnum;
                            int satir = durulanyerdekiint / 10;
                            int sutun = durulanyerdekiint % 10;
                            String durulanyerdekistr = durulanyerdekiItem.getPosition();

                            if (board.items[j].move(gidilecekyerdekiint, gidilecekyerdekistr)) {
                                if (sahkurali() || check("B")) {
                                    Board.tahta[i][k] = gidilenyerdekiItem;
                                    gidilenyerdekiItem.setPositionnum(gidilecekyerdekiint);
                                    gidilenyerdekiItem.setPosition(gidilecekyerdekistr);
                                    Board.tahta[satir][sutun] = durulanyerdekiItem;
                                    durulanyerdekiItem.setPosition(durulanyerdekistr);
                                    durulanyerdekiItem.setPositionnum(durulanyerdekiint);

                                } else {
                                    Board.tahta[i][k] = gidilenyerdekiItem;
                                    gidilenyerdekiItem.setPositionnum(gidilecekyerdekiint);
                                    gidilenyerdekiItem.setPosition(gidilecekyerdekistr);
                                    Board.tahta[satir][sutun] = durulanyerdekiItem;
                                    durulanyerdekiItem.setPosition(durulanyerdekistr);
                                    durulanyerdekiItem.setPositionnum(durulanyerdekiint);

                                    return false;
                                }
                            }
                            /*else
                            {
                                Board.tahta[i][k] = gidilenyerdekiItem;
                                gidilenyerdekiItem.setPositionnum(gidilecekyerdekiint);
                                gidilenyerdekiItem.setPosition(gidilecekyerdekistr);
                                Board.tahta[satir][sutun] = durulanyerdekiItem;
                                durulanyerdekiItem.setPosition(durulanyerdekistr);
                                durulanyerdekiItem.setPositionnum(durulanyerdekiint);
                            }*/

                        }

                    }
                }
            }
            return true;

        }
    }
    public void save_binary(String address)
    {
        ObjectOutputStream out =null;
        try{
            out = new ObjectOutputStream(new FileOutputStream(address));

            out.writeObject(this);
            for(int i=0;i<Board.tahta.length;i++)
            {
                for(int j=0;j<Board.tahta[0].length;j++)
                {
                    out.writeObject(Board.tahta[i][j]);

                }
            }
            out.close();


        } catch (FileNotFoundException e) {

        } catch (IOException e) {

        }


    }
    public void load_binary(String address)
    {
        ObjectInputStream i = null;
        try {
            i = new ObjectInputStream(new FileInputStream(address));
            Game g = (Game) i.readObject();
            this.sira=g.sira;
            this.board=g.board;
            this.red=g.red;
            this.black=g.black;
            for(int k=0;k<Board.tahta.length;k++)
            {
                for(int j=0;j<Board.tahta[0].length;j++)
                {
                    Board.tahta[k][j]= (Item) i.readObject();
                }
            }
            i.close();


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void save_text(String address)
    {
        PrintWriter out = null;
        try {
            out=new PrintWriter(address);
            out.println(this.sira);
            for(int i=0;i<this.board.items.length;i++)
            {
                //out.println(board.items[i].getClass().getName());
                out.println(board.items[i].takim);
                out.println(board.items[i].getPosition());
                out.println(board.items[i].getOldposition());
                out.println(board.items[i].positionnum);
                out.println(board.items[i].oldpositionnum);
                out.println(board.items[i].point);
            }
            out.println(red.puan);
            out.println(red.takim);
            out.println(black.puan);
            out.println(black.takim);
            for(int i=0;i<Board.tahta.length;i++)
            {
                for (int j=0;j<Board.tahta[0].length;j++)
                {
                    out.println(Board.tahta[i][j].getClass().getName());
                    out.println(Board.tahta[i][j].takim);
                    out.println(Board.tahta[i][j].getPosition());
                    out.println(Board.tahta[i][j].getOldposition());
                    out.println(Board.tahta[i][j].positionnum);
                    out.println(Board.tahta[i][j].oldpositionnum);


                }
            }
            out.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void load_text(String address)
    {
        Scanner s=null;
        try {
            s=new Scanner(new FileInputStream(address));

            this.sira= Integer.parseInt(s.nextLine());
            for(int i=0;i<board.items.length;i++)
            {
                board.items[i].takim=s.nextLine();
                board.items[i].setPosition(s.nextLine());
                board.items[i].setOldposition(s.nextLine());
                board.items[i].setPositionnum(Integer.parseInt(s.nextLine()));
                board.items[i].setOldpositionnum(Integer.parseInt(s.nextLine()));
                board.items[i].point= Float.parseFloat(s.nextLine());

            }
            red.puan= Float.parseFloat(s.nextLine());
            red.takim=s.nextLine();
            black.puan= Float.parseFloat(s.nextLine());
            black.takim=s.nextLine();
            for(int i=0;i<Board.tahta.length;i++)
            {
                for (int j=0;j<Board.tahta[0].length;j++)
                {
                    String sinif = s.nextLine();
                    //Item yeni=new Item(s.nextLine(),s.nextLine(),Integer.parseInt(s.nextLine()));
                    //yeni.setOldposition(s.nextLine());
                    //yeni.setPositionnum(Integer.parseInt(s.nextLine()));
                    //yeni.setOldpositionnum(Integer.parseInt(s.nextLine()));
                    if(sinif.equals("At"))
                    {
                        At yeni= new At(s.nextLine(),s.nextLine());
                        yeni.setOldposition(s.nextLine());
                        yeni.setPositionnum(Integer.parseInt(s.nextLine()));
                        yeni.setOldpositionnum(Integer.parseInt(s.nextLine()));
                        for(int k=0;k<this.board.items.length;k++)
                        {
                            if(board.items[k].getPosition().equals(yeni.getPosition()))
                            {
                                board.items[k]=yeni;

                            }

                        }
                        Board.tahta[i][j]=yeni;


                    }
                    if(sinif.equals("Fil"))
                    {
                        Fil yeni= new Fil(s.nextLine(),s.nextLine());
                        yeni.setOldposition(s.nextLine());
                        yeni.setPositionnum(Integer.parseInt(s.nextLine()));
                        yeni.setOldpositionnum(Integer.parseInt(s.nextLine()));
                        for(int k=0;k<this.board.items.length;k++)
                        {
                            if(board.items[k].getPosition().equals(yeni.getPosition()))
                            {
                                board.items[k]=yeni;

                            }

                        }

                        Board.tahta[i][j]=yeni;


                    }
                    if(sinif.equals("Bosluk"))
                    {
                        Bosluk yeni= new Bosluk(s.nextLine(),s.nextLine());
                        yeni.setOldposition(s.nextLine());
                        yeni.setPositionnum(Integer.parseInt(s.nextLine()));
                        yeni.setOldpositionnum(Integer.parseInt(s.nextLine()));
                        for(int k=0;k<this.board.items.length;k++)
                        {
                            if(board.items[k].getPosition().equals(yeni.getPosition()))
                            {
                                board.items[k]=yeni;

                            }

                        }
                        Board.tahta[i][j]=yeni;


                    }
                    if(sinif.equals("Kale"))
                    {
                        Kale yeni= new Kale(s.nextLine(),s.nextLine());
                        yeni.setOldposition(s.nextLine());
                        yeni.setPositionnum(Integer.parseInt(s.nextLine()));
                        yeni.setOldpositionnum(Integer.parseInt(s.nextLine()));
                        for(int k=0;k<this.board.items.length;k++)
                        {
                            if(board.items[k].getPosition().equals(yeni.getPosition()))
                            {
                                board.items[k]=yeni;

                            }

                        }
                        Board.tahta[i][j]=yeni;


                    }
                    if(sinif.equals("Piyon"))
                    {
                        Piyon yeni= new Piyon(s.nextLine(),s.nextLine());
                        yeni.setOldposition(s.nextLine());
                        yeni.setPositionnum(Integer.parseInt(s.nextLine()));
                        yeni.setOldpositionnum(Integer.parseInt(s.nextLine()));
                        for(int k=0;k<this.board.items.length;k++)
                        {
                            if(board.items[k].getPosition().equals(yeni.getPosition()))
                            {
                                board.items[k]=yeni;

                            }

                        }
                        Board.tahta[i][j]=yeni;


                    }
                    if(sinif.equals("Sah"))
                    {
                        Sah yeni= new Sah(s.nextLine(),s.nextLine());
                        yeni.setOldposition(s.nextLine());
                        yeni.setPositionnum(Integer.parseInt(s.nextLine()));
                        yeni.setOldpositionnum(Integer.parseInt(s.nextLine()));
                        for(int k=0;k<this.board.items.length;k++)
                        {
                            if(board.items[k].getPosition().equals(yeni.getPosition()))
                            {
                                board.items[k]=yeni;

                            }

                        }
                        Board.tahta[i][j]=yeni;


                    }
                    if(sinif.equals("Top"))
                    {
                        Top yeni= new Top(s.nextLine(),s.nextLine());
                        yeni.setOldposition(s.nextLine());
                        yeni.setPositionnum(Integer.parseInt(s.nextLine()));
                        yeni.setOldpositionnum(Integer.parseInt(s.nextLine()));
                        for(int k=0;k<this.board.items.length;k++)
                        {
                            if(board.items[k].getPosition().equals(yeni.getPosition()))
                            {
                                board.items[k]=yeni;

                            }

                        }
                        Board.tahta[i][j]=yeni;


                    }
                    if(sinif.equals("Vezir"))
                    {
                        Vezir yeni= new Vezir(s.nextLine(),s.nextLine());
                        yeni.setOldposition(s.nextLine());
                        yeni.setPositionnum(Integer.parseInt(s.nextLine()));
                        yeni.setOldpositionnum(Integer.parseInt(s.nextLine()));
                        for(int k=0;k<this.board.items.length;k++)
                        {
                            if(board.items[k].getPosition().equals(yeni.getPosition()))
                            {
                                board.items[k]=yeni;

                            }

                        }
                        Board.tahta[i][j]=yeni;


                    }



                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}