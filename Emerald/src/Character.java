
public class Character {

	Dice d=new Dice();
	
	String Name;
	int MAXHP;
	int MAXMP;
	int HP;
	int MP;
	int AT;
	int ResistTime;
	int ResistValue;
	int HealTime;
	int HealValue;
	int DealTime;
	int DealValue;
	int Stun;
	
	void Status()
	{
		System.out.print(Name+" HP:"+HP+"/"+MAXHP+" MP:"+MP+"/"+MAXMP);
		if(HP==0) System.out.print(" (쓰러짐)\n");
		else
		{
			if(HealTime>0) System.out.print(" (재생 "+HealTime+"턴 남음)");
			if(DealTime>0) System.out.print(" (물기 "+DealTime+"턴 남음)");
			if(Stun>0) System.out.print(" ("+Stun+"턴 동안 행동불능)");
			System.out.print("\n");
		}
		//쓰러짐 추가
	}
	
	void TurnCount()
	{
		MP+=10;
		if(MP>MAXMP) MP=MAXMP;
		if(Stun>0) Stun--;
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
		System.out.println(Name+"의 평타!");
		int dmg=d.dice(AT);
		int res=0;
		boolean crit=d.crit(1);
		
		if(crit==true) dmg*=2;
		if(ER>0)
		{
			res=d.dice(EV);
			dmg-=res;
			if(dmg<0) dmg=0;
		}
		if(dmg>EHP) dmg=EHP;
		
		System.out.print("적 "+x+"("+EName+")에게 "+AT+"D6 "+dmg+"데미지!");
		if(crit==true) System.out.print("(×2 치명타)");
		if(ER>0) System.out.print("("+EV+"D6 "+res+" 저항)");
		System.out.print("\n");
		
		return dmg;
	}
}
