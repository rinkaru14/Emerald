
public class Korone extends Character{
	
	public Korone()
	{
		Name="�ڷγ�";
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
		System.out.print(" (����)");
		if(ResistTime>0) System.out.print(" (��� �¼� "+ResistTime+"�� ����)");
		if(HealTime>0) System.out.print(" (��� "+HealTime+"�� ����)");
		if(DealTime>0) System.out.print(" (���� "+DealTime+"�� ����)");
		if(Stun>0) System.out.print(" ("+Stun+"�� ���� �ൿ�Ҵ�)");
		System.out.print("\n");
	}
	
	
	void Sheild_Up()
	{
		System.out.println("�ڷγ��� ��� �¼�!");
		MP-=50;
		ResistTime=4;
	}
	
	
	int Mortal_Strike(int x, int ER, int EV, int EHP, int EMAXHP,String EName)
	{
		System.out.println("�ڷγ��� �ʻ��� �ϰ�!");
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

		System.out.print("�� "+x+"("+EName+")���� "+18+"D6 "+dmg+"������!");
		if(EHP/EMAXHP<0.4) System.out.print("(��2 ������ �ϰ� �ߵ�)");
		if(ER>0) System.out.print("("+EV+"D6 "+res+" ����)");
		System.out.print("\n");
		return dmg;
	}
}
