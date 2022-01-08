
public class Sakazuki extends Character{

	public Sakazuki()
	{
		Name="사카즈키";
		HP=250;
		MP=200;
		MAXHP=250;
		MAXMP=200;
		AT=6;
		ResistTime=0;
		ResistValue=0;
		HealTime=0;
		HealValue=4;
		DealTime=0;
		DealValue=0;
		Stun=0;
	}
	int Arrow_Remain=0;
	int stack=0;
	
	void Status()
	{
		System.out.print(Name+" HP:"+HP+"/"+MAXHP+" MP:"+MP+"/"+MAXMP);
		System.out.print(" (예리한 집중력 "+stack+"스택)");
		if(Arrow_Remain>0) System.out.print(" (날카로운 화살 "+Arrow_Remain+"턴 남음)");
		if(HealTime>0) System.out.print(" (재생 "+HealTime+"턴 남음)");
		if(DealTime>0) System.out.print(" (물기 "+DealTime+"턴 남음)");
		if(Stun>0) System.out.print(" ("+Stun+"턴 동안 행동불능)");
		System.out.print("\n");
	}
	
	void TurnCount()
	{
		MP+=10;
		if(MP>MAXMP) MP=MAXMP;
		if(Stun>0) Stun--;
		if(Arrow_Remain>0) Arrow_Remain--;
		if(ResistTime>0) ResistTime--;
		if(DealTime>0)
		{
			int deal=d.dice(DealValue);
			if(HP<deal) deal=HP;
			System.out.println(Name+"에게 "+DealValue+"D6 "+deal+"출혈!(광포한 곰의 물기)");
			HP-=deal;
			DealTime--;
		}
		if(HealTime>0)
		{
			int heal=d.dice(HealValue);
			if(MAXHP-HP<heal) heal=MAXHP-HP;
			System.out.println(Name+"에게 "+HealValue+"D6 "+heal+"치유!(하치의 재생)");
			HP+=heal;
			HealTime--;
		}
	}
	
	
	int AutoAttack(int x, int ER, int EV,int EHP,String EName)
	{
		stack++;
		if(stack==4) stack=0;
		System.out.println(Name+"의 평타!");
		int dmg=d.dice(AT);
		int res=0;
		boolean crit=d.crit(1);
		if(Arrow_Remain>0) dmg+=d.dice(5);
		if(crit==true || stack==0) dmg*=2;
		if(ER>0)
		{
			res=d.dice(EV);
			dmg-=res;
			if(dmg<0) dmg=0;
		}
		if(dmg>EHP) dmg=EHP;
		
		System.out.print("적 "+x+"("+EName+")에게 "+AT+"D6 "+dmg+"데미지!");
		if(Arrow_Remain>0) System.out.print("(+5D6 날카로운 화살)");
		if(crit==true || stack==0)
		{
			if(stack==0) System.out.print("(×2 예리한 집중력 치명타)");
			else System.out.print("(×2 치명타)");
		}
		if(ER>0) System.out.print("("+EV+"D6 "+res+" 저항)");
		System.out.print("\n");
		
		return dmg;
	}
	
	
	
	int Arrow(int x, int ER, int EV,int EHP,String EName)
	{
		System.out.println("사카즈키의 날카로운 화살!");
		MP-=80;
		Arrow_Remain=5;
		return AutoAttack(x, ER, EV,EHP,EName);
		
	}
	
	int Side_Strike(int x, int ER, int EV,int EHP,String EName)
	{
		System.out.println("사카즈키의 측방 강타!");
		MP-=60;
		
		int dmg=d.dice(8);
		int res=0;
		if(ER>0)
		{
			res=d.dice(EV);
			dmg-=res;
			if(dmg<0) dmg=0;
		}
		if(dmg>EHP) dmg=EHP;
		
		System.out.print("적 "+x+"("+EName+")에게 "+8+"D6 "+dmg+"데미지!");
		if(ER>0) System.out.print("("+EV+"D6 "+res+" 저항)");
		System.out.print("\n");
		return dmg;
	}
	
}
