
public class Rogue extends Enemy{
	public Rogue()
	{
		Name="����";
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
		System.out.println(Name+"�� ���� �Ͻ�!(�ߵ� Ȯ�� 2D6)");
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
		
		System.out.print(EName+"���� "+6+"D6 "+dmg+"������!");
		if(ER>0) System.out.print("("+EV+"D6 "+res+" ����)");
		if(DebuffTime>0) System.out.print("("+DebuffValue+"D6 "+deb+" �ݰ�)");
		System.out.print("\n");
		System.out.println(EName+"�� 1�ϰ� �ൿ �Ҵ� ���°� �Ǿ���!");
		
		return dmg;
	}
}
