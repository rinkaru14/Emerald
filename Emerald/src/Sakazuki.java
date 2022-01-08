
public class Sakazuki extends Character{

	public Sakazuki()
	{
		Name="��ī��Ű";
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
		System.out.print(" (������ ���߷� "+stack+"����)");
		if(Arrow_Remain>0) System.out.print(" (��ī�ο� ȭ�� "+Arrow_Remain+"�� ����)");
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
		if(Arrow_Remain>0) Arrow_Remain--;
		if(ResistTime>0) ResistTime--;
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
	
	
	int AutoAttack(int x, int ER, int EV,int EHP,String EName)
	{
		stack++;
		if(stack==4) stack=0;
		System.out.println(Name+"�� ��Ÿ!");
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
		
		System.out.print("�� "+x+"("+EName+")���� "+AT+"D6 "+dmg+"������!");
		if(Arrow_Remain>0) System.out.print("(+5D6 ��ī�ο� ȭ��)");
		if(crit==true || stack==0)
		{
			if(stack==0) System.out.print("(��2 ������ ���߷� ġ��Ÿ)");
			else System.out.print("(��2 ġ��Ÿ)");
		}
		if(ER>0) System.out.print("("+EV+"D6 "+res+" ����)");
		System.out.print("\n");
		
		return dmg;
	}
	
	
	
	int Arrow(int x, int ER, int EV,int EHP,String EName)
	{
		System.out.println("��ī��Ű�� ��ī�ο� ȭ��!");
		MP-=80;
		Arrow_Remain=5;
		return AutoAttack(x, ER, EV,EHP,EName);
		
	}
	
	int Side_Strike(int x, int ER, int EV,int EHP,String EName)
	{
		System.out.println("��ī��Ű�� ���� ��Ÿ!");
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
		
		System.out.print("�� "+x+"("+EName+")���� "+8+"D6 "+dmg+"������!");
		if(ER>0) System.out.print("("+EV+"D6 "+res+" ����)");
		System.out.print("\n");
		return dmg;
	}
	
}
