
public class Rogue extends Enemy{
	public Rogue()
	{
		Name="도적";
		MAXHP=250;
		HP=250;
		AT=3;
		ResistTime=0;
		ResistValue=0;
		DebuffTime=0;
		DebuffValue=0;
	}
	
	
	
	
	int Skill1(int x, int ER, int EV, int EHP, String EName)
	{
		//Sinister_Strike
		System.out.println(Name+"의 비열한 암습!(발동 확률 2D6)");
		int dmg=d.dice(6);
		int res=0,deb=0;
		if(ER>0)
		{
			res=d.dice(EV);
			dmg-=res;
		}
		if(DebuffTime>0)
		{
			deb=d.dice(DebuffValue);
			dmg-=deb;
		}
		if(dmg<0) dmg=0;
		if(dmg>EHP) dmg=EHP;
		
		System.out.print(EName+"에게 "+6+"D6 "+dmg+"데미지!");
		if(ER>0) System.out.print("("+EV+"D6 "+res+" 저항)");
		if(DebuffTime>0) System.out.print("("+DebuffValue+"D6 "+deb+" 반감)");
		System.out.print("\n");
		System.out.println(EName+"는 1턴간 행동 불능 상태가 되었다!");
		
		return dmg;
	}
}
