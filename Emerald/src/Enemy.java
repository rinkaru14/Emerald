
public class Enemy {
	
	Dice d=new Dice();
	
	String Name;
	int MAXHP;
	int HP;
	int AT;
	int ResistTime;
	int ResistValue;
	int DebuffTime;
	int DebuffValue;
	
	void Status()
	{
		System.out.print(Name+" HP:"+HP+"/"+MAXHP);
		if(HP==0) System.out.print(" (������)\n");
		else
		{
			if(DebuffTime>0) System.out.print(" (���� ��Ÿ "+DebuffTime+"�� ����)");
			System.out.print("\n");
		}
	}
	
	void TurnCount()
	{
		if(ResistTime>0) ResistTime--;
		if(DebuffTime>0) DebuffTime--;
	}
	
	
	int Skill1(int x, int ER, int EV, int EHP, String EName)
	{
		return 0;
	}
	
	int Skill2()
	{
		return 0;
	}
	
	int[] Skill3(int ER1,int EV1, int EHP1, int ER2,int EV2,int EHP2, int ER3,int EV3,int EHP3, int ER4,int EV4,int EHP4)
	{
		int[] dmg=new int[5];
		return dmg;
	}
	
	int Skill4(int x, String EName)
	{
		return 0;
	}
	
	int AutoAttack(int x, int ER, int EV, int EHP, String EName)
	{
		System.out.println(Name+"�� ��Ÿ!");
		int dmg=d.dice(AT);
		int res=0,deb=0;
		boolean crit=d.crit(1);
		
		if(crit==true) dmg*=2;
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
		//AT+"D6 "+
		System.out.print(EName+"���� "+AT+"D6 "+dmg+"������!");
		if(crit==true) System.out.print("(��2 ġ��Ÿ)");
		if(ER>0) System.out.print("("+EV+"D6 "+res+" ����)");
		if(DebuffTime>0) System.out.print("("+DebuffValue+"D6 "+deb+" �ݰ�)");
		System.out.print("\n");
		
		return dmg;
	}
}
