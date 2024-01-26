import java.io.Serializable;

public abstract class AbstractBoard implements BoardInterface , Serializable{
	
	Item [] items={new Kale("B","j1"), //0
			new At("B","j2"), //1
			new Fil("B","j3"),//2
			new Vezir("B","j4"), //3
			new Sah("B","j5"), //4
			new Vezir("B","j6"), //5
			new Fil("B","j7"), //6
			new At("B","j8"), //7
			new Kale("B","j9"),//8
			new Top("B","h2"),//9
			new Top("B","h8"),//10
			new Piyon("B","g1"),//11
			new Piyon("B","g3"),//12
			new Piyon("B","g5"),//13
			new Piyon("B","g7"),//14
			new Piyon("B","g9"),//15
			new Piyon("W","d1"),//16
			new Piyon("W","d3"),//17
			new Piyon("W","d5"),//18
			new Piyon("W","d7"),//19
			new Piyon("W","d9"),//20
			new Top("W","c2"),//21
			new Top("W","c8"),//22
			new Kale("W","a1"),//23
			new At("W","a2"), //24
			new Fil("W","a3"), //25
			new Vezir("W","a4"),// 26
			new Sah("W","a5"), //27
			new Vezir("W","a6"), //28
			new Fil("W","a7"), //29
			new At("W","a8"), //30
			new Kale("W","a9")//31


	};
	
	
}
