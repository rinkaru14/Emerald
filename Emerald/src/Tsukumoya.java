
public class Tsukumoya extends Character{
	
	public Tsukumoya()
	{
		Name="������";
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
		if(Blizzard_Remain>0) System.out.print(" (������ "+Blizzard_Remain+"�� ����)");
		if(HealTime>0) System.out.print(" (��� "+HealTime+"�� ����)");
		if(DealTime>0) System.out.print(" (���� "+DealTime+"�� ����)");
		if(Stun>0) System.out.print(" ("+Stun+"�� ���� �ൿ�Ҵ�)");
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
			System.out.println(Name+"���� "+DealValue+"D6 "+deal+"����!(������ ���� ����)");
			HP-=deal;
			DealTime--;
		}
		if(HealTime>0)
		{
			int heal=d.dice(HealValue);
			if(MAXHP-HP<heal) heal=MAXHP-HP;
			System.out.println(Name+"���� "+HealValue+"D6 "+heal+"ġ��!(��ġ�� ���)");
			HP+=heal;
			HealTime--;
		}
	}
	
	
	int[] Blizzard_1tick(int ER1,int EV1, int EHP1,String EName1, int ER2,int EV2,int EHP2, String EName2,int ER3,int EV3,int EHP3,String EName3)
	{
		System.out.println("�������� ������!");
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
			System.out.print("�� "+1+"("+EName1+")���� "+15+"D6 "+dmg[1]+"������!");
			if(ER1>0) System.out.print("("+EV1+"D6 "+res+" ����)");
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
			System.out.print("�� "+2+"("+EName2+")���� "+15+"D6 "+dmg[2]+"������!");
			if(ER2>0) System.out.print("("+EV2+"D6 "+res+" ����)");
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
			System.out.print("�� "+3+"("+EName3+")���� "+15+"D6 "+dmg[3]+"������!");
			if(ER3>0) System.out.print("("+EV2+"D6 "+res+" ����)");
			System.out.print("\n");
		}
		else dmg[3]=0;
		
		return dmg;
		
	}
	
	int AutoAttack(int x, int ER, int EV,int EHP,String EName)
	{
		//if(Blizzard_Remain>0) Blizzard_1tick();
		
		System.out.println(Name+"�� ��Ÿ!");
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
		
		System.out.print("�� "+x+"("+EName+")���� "+AT+"D6 "+dmg+"������!");
		if(crit==true) System.out.print("(��2 ġ��Ÿ)(+5D6 ���� ���������)(MP +60)");
		if(ER>0) System.out.print("("+EV+"D6 "+res+" ����)");
		System.out.print("\n");
		
		return dmg;
	}
	
	void Blizzard()
	{
		System.out.println("�������� ������!");
		MP-=150;

		Blizzard_Remain=4;
	}
	
	
	
	int FlameStrike(int x, int ER,int EV,int EHP, String EName)
	{
		System.out.println("�������� ȭ�� �۷�!");
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
		
		System.out.print("�� "+x+"("+EName+")���� "+25+"D6 "+dmg+"������!");
		if(Blizzard_Remain>0) System.out.print("(+10D6 ���� �ش�ȭ)");
		if(ER>0) System.out.print("("+EV+"D6 "+res+" ����)");
		System.out.print("\n");
		return dmg;
	}

}
