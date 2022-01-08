
public class Tsukumoya extends Character{
	
	public Tsukumoya()
	{
		Name="츠쿠모야";
		HP=175;
		MP=300;
		MAXHP=175;
		MAXMP=300;
		AT=2;
		ResistTime=0;
		ResistValue=0;
		HealTime=0;
		HealValue=4;
		DealTime=0;
		DealValue=0;
		Stun=0;
	}
	
	int Blizzard_Remain=0;
	
	void Status()
	{
		System.out.print(Name+" HP:"+HP+"/"+MAXHP+" MP:"+MP+"/"+MAXMP);
		if(Blizzard_Remain>0) System.out.print(" (눈보라 "+Blizzard_Remain+"턴 남음)");
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
		if(ResistTime>0) ResistTime--;
		if(Blizzard_Remain>0) Blizzard_Remain--;
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
	
	
	int[] Blizzard_1tick(int ER1,int EV1, int EHP1,String EName1, int ER2,int EV2,int EHP2, String EName2,int ER3,int EV3,int EHP3,String EName3)
	{
		System.out.println("츠쿠모야의 눈보라!");
		int res=0;
		int[] dmg=new int[4];
		
		if(EHP1!=0)
		{
			dmg[1]=d.dice(15);
			if(ER1>0)
			{
				res=d.dice(EV1);
				dmg[1]-=res;
				if(dmg[1]<0) dmg[1]=0;
			}
			if(dmg[1]>EHP1) dmg[1]=EHP1;
			System.out.print("적 "+1+"("+EName1+")에게 "+15+"D6 "+dmg[1]+"데미지!");
			if(ER1>0) System.out.print("("+EV1+"D6 "+res+" 저항)");
			System.out.print("\n");
		}
		else dmg[1]=0;
		
		if(EHP2!=0)
		{
			dmg[2]=d.dice(15);
			if(ER2>0)
			{
				res=d.dice(EV2);
				dmg[2]-=res;
				if(dmg[2]<0) dmg[2]=0;
			}
			if(dmg[2]>EHP2) dmg[2]=EHP2;
			System.out.print("적 "+2+"("+EName2+")에게 "+15+"D6 "+dmg[2]+"데미지!");
			if(ER2>0) System.out.print("("+EV2+"D6 "+res+" 저항)");
			System.out.print("\n");
		}
		else dmg[2]=0;
		
		if(EHP3!=0)
		{
			dmg[3]=d.dice(15);
			if(ER3>0)
			{
				res=d.dice(EV3);
				dmg[3]-=res;
				if(dmg[3]<0) dmg[3]=0;
			}
			if(dmg[3]>EHP3) dmg[3]=EHP3;
			System.out.print("적 "+3+"("+EName3+")에게 "+15+"D6 "+dmg[3]+"데미지!");
			if(ER3>0) System.out.print("("+EV2+"D6 "+res+" 저항)");
			System.out.print("\n");
		}
		else dmg[3]=0;
		
		return dmg;
		
	}
	
	int AutoAttack(int x, int ER, int EV,int EHP,String EName)
	{
		//if(Blizzard_Remain>0) Blizzard_1tick();
		
		System.out.println(Name+"의 평타!");
		int dmg=d.dice(AT);
		int res=0;
		boolean crit=d.crit(1);
		if(crit==true)
		{
			dmg*=2;
			dmg+=d.dice(5);
			MP+=60;
			if(MP>MAXMP) MP=MAXMP;
		}
		if(ER>0)
		{
			res=d.dice(EV);
			dmg-=res;
			if(dmg<0) dmg=0;
		}
		if(dmg>EHP) dmg=EHP;
		
		System.out.print("적 "+x+"("+EName+")에게 "+AT+"D6 "+dmg+"데미지!");
		if(crit==true) System.out.print("(×2 치명타)(+5D6 마나 끌어모으기)(MP +60)");
		if(ER>0) System.out.print("("+EV+"D6 "+res+" 저항)");
		System.out.print("\n");
		
		return dmg;
	}
	
	void Blizzard()
	{
		System.out.println("츠쿠모야의 눈보라!");
		MP-=150;

		Blizzard_Remain=4;
	}
	
	
	
	int FlameStrike(int x, int ER,int EV,int EHP, String EName)
	{
		System.out.println("츠쿠모야의 화염 작렬!");
		MP-=80;
		int dmg=d.dice(25);
		int res=0;
		if(Blizzard_Remain>0) dmg+=d.dice(10);
		if(ER>0)
		{
			res=d.dice(EV);
			dmg-=res;
			if(dmg<0) dmg=0;
		}
		if(dmg>EHP) dmg=EHP;
		
		System.out.print("적 "+x+"("+EName+")에게 "+25+"D6 "+dmg+"데미지!");
		if(Blizzard_Remain>0) System.out.print("(+10D6 동상 극대화)");
		if(ER>0) System.out.print("("+EV+"D6 "+res+" 저항)");
		System.out.print("\n");
		return dmg;
	}

}
