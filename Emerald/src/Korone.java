
public class Korone extends Character{
	
	public Korone()
	{
		Name="코로네";
		HP=300;
		MP=150;
		MAXHP=300;
		MAXMP=150;
		AT=4;
		ResistTime=0;
		ResistValue=4;
		HealTime=0;
		HealValue=4;
		DealTime=0;
		DealValue=0;
		Stun=0;
	}
	
	void Status()
	{
		System.out.print(Name+" HP:"+HP+"/"+MAXHP+" MP:"+MP+"/"+MAXMP);
		System.out.print(" (도발)");
		if(ResistTime>0) System.out.print(" (방어 태세 "+ResistTime+"턴 남음)");
		if(HealTime>0) System.out.print(" (재생 "+HealTime+"턴 남음)");
		if(DealTime>0) System.out.print(" (물기 "+DealTime+"턴 남음)");
		if(Stun>0) System.out.print(" ("+Stun+"턴 동안 행동불능)");
		System.out.print("\n");
	}
	
	
	void Sheild_Up()
	{
		System.out.println("코로네의 방어 태세!");
		MP-=50;
		ResistTime=4;
	}
	
	
	int Mortal_Strike(int x, int ER, int EV, int EHP, int EMAXHP,String EName)
	{
		System.out.println("코로네의 필사의 일격!");
		MP-=60;
		int dmg=d.dice(18);
		int res=0;
		
		if(EHP/EMAXHP<0.4) dmg*=2;
		if(ER>0)
		{
			res=d.dice(EV);
			dmg-=res;
			if(dmg<0) dmg=0;
		}
		if(dmg>EHP) dmg=EHP;

		System.out.print("적 "+x+"("+EName+")에게 "+18+"D6 "+dmg+"데미지!");
		if(EHP/EMAXHP<0.4) System.out.print("(×2 마무리 일격 발동)");
		if(ER>0) System.out.print("("+EV+"D6 "+res+" 저항)");
		System.out.print("\n");
		return dmg;
	}
}
