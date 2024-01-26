import java.io.Serializable;

public class Board extends AbstractBoard implements Serializable {
	  static Item[][] tahta;


	public Board()
	{
		tahta=new Item[][]{
				{this.items[0],this.items[1], this.items[2], this.items[3], this.items[4], this.items[5], this.items[6], this.items[7], this.items[8]},
				{new Bosluk("E","i1"),new Bosluk("E","i2"),new Bosluk("E","i3"),new Bosluk("E","i4"),new Bosluk("E","i5"),new Bosluk("E","i6"),new Bosluk("E","i7"),new Bosluk("E","i8"),new Bosluk("E","i9")},
				{new Bosluk("E","h1"),this.items[9],new Bosluk("E","h3"),new Bosluk("E","h4"),new Bosluk("E","h5"),new Bosluk("E","h6"),new Bosluk("E","h7"),this.items[10],new Bosluk("E","h9")},
				{this.items[11],new Bosluk("E","g2"),this.items[12],new Bosluk("E","g4"),this.items[13],new Bosluk("E","g6"),this.items[14],new Bosluk("E","g8"),this.items[15]},
				{new Bosluk("E","f1"),new Bosluk("E","f2"),new Bosluk("E","f3"),new Bosluk("E","f4"),new Bosluk("E","f5"),new Bosluk("E","f6"),new Bosluk("E","f7"),new Bosluk("E","f8"),new Bosluk("E","f9")},
				{new Bosluk("E","e1"),new Bosluk("E","e2"),new Bosluk("E","e3"),new Bosluk("E","e4"),new Bosluk("E","e5"),new Bosluk("E","e6"),new Bosluk("E","e7"),new Bosluk("E","e8"),new Bosluk("E","e9")},
				{this.items[16],new Bosluk("E","d2"),this.items[17],new Bosluk("E","d4"),this.items[18],new Bosluk("E","d6"),this.items[19],new Bosluk("E","d8"),this.items[20]},
				{new Bosluk("E","c1"),this.items[21],new Bosluk("E","c3"),new Bosluk("E","c4"),new Bosluk("E","c5"),new Bosluk("E","c6"),new Bosluk("E","c7"),this.items[22],new Bosluk("E","c9")},
				{new Bosluk("E","b1"),new Bosluk("E","b2"),new Bosluk("E","b3"),new Bosluk("E","b4"),new Bosluk("E","b5"),new Bosluk("E","b6"),new Bosluk("E","b7"),new Bosluk("E","b8"),new Bosluk("E","b9")},
				{this.items[23], this.items[24], this.items[25], this.items[26], this.items[27], this.items[28], this.items[29], this.items[30], this.items[31]},


		};

	}
	public Board(String destination)
	{

	}

	@Override
	public void print() {

		System.out.print("j\t"+tahta[0][0]);
		for(int i=1;i<9;i++)
			System.out.print("--"+tahta[0][i]);
		System.out.println();
		System.out.println(" \t|  |  |  |\\ | /|  |  |  |");
		System.out.print("i\t"+tahta[1][0]);
		for(int i=1;i<9;i++)
			System.out.print("--"+tahta[1][i]);
		System.out.println();
		System.out.println(" \t|  |  |  |/ | \\|  |  |  |");
		System.out.print("h\t"+tahta[2][0]);
		for(int i=1;i<9;i++)
			System.out.print("--"+tahta[2][i]);
		System.out.println();
		System.out.println(" \t|  |  |  |  |  |  |  |  |");
		System.out.print("g\t"+tahta[3][0]);
		for(int i=1;i<9;i++)
			System.out.print("--"+tahta[3][i]);
		System.out.println();
		System.out.println(" \t|  |  |  |  |  |  |  |  |");
		System.out.print("f\t"+tahta[4][0]);
		for(int i=1;i<9;i++)
			System.out.print("--"+tahta[4][i]);
		System.out.println();
		System.out.println(" \t|                       |");
		System.out.print("e\t"+tahta[5][0]);
		for(int i=1;i<9;i++)
			System.out.print("--"+tahta[5][i]);
		System.out.println();
		System.out.println(" \t|  |  |  |  |  |  |  |  |");
		System.out.print("d\t"+tahta[6][0]);
		for(int i=1;i<9;i++)
			System.out.print("--"+tahta[6][i]);
		System.out.println();
		System.out.println(" \t|  |  |  |  |  |  |  |  |");
		System.out.print("c\t"+tahta[7][0]);
		for(int i=1;i<9;i++)
			System.out.print("--"+tahta[7][i]);
		System.out.println();
		System.out.println(" \t|  |  |  |\\ | /|  |  |  |");
		System.out.print("b\t"+tahta[8][0]);
		for(int i=1;i<9;i++)
			System.out.print("--"+tahta[8][i]);
		System.out.println();
		System.out.println(" \t|  |  |  |/ | \\|  |  |  |");
		System.out.print("a\t"+tahta[9][0]);
		for(int i=1;i<9;i++)
			System.out.print("--"+tahta[9][i]);
		System.out.println();
		System.out.println();
		System.out.println(" \t1--2--3--4--5--6--7--8--9");
		
	}


	public Item[][] getTahta() {
		return tahta;
	}
}
