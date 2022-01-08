
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
		if(HP==0) System.out.print(" (������)\n");
		else
		{
			if(HealTime>0) System.out.print(" (��� "+HealTime+"�� ����)");
			if(DealTime>0) System.out.print(" (���� "+DealTime+"�� ����)");
			if(Stun>0) System.out.print(" ("+Stun+"�� ���� �ൿ�Ҵ�)");
			System.out.print("\n");
		}
		//������ �߰�
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
		System.out.println(Name+"�� ��Ÿ!");
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
		
		System.out.print("�� "+x+"("+EName+")���� "+AT+"D6 "+dmg+"������!");
		if(crit==true) System.out.print("(��2 ġ��Ÿ)");
		if(ER>0) System.out.print("("+EV+"D6 "+res+" ����)");
		System.out.print("\n");
		
		return dmg;
	}
}
