
public class Druid extends Enemy{
	public Druid()
	{
		Name="�Ǹ��� ����̵�";
		MAXHP=1200;
		HP=1200;
		AT=5;
		ResistTime=0;
		ResistValue=0;
		DebuffTime=0;
		DebuffValue=0;
	}
	
	int Skill1(int x, int ER, int EV, int EHP, String EName)
	{
		//FNSR
		System.out.println(Name+"�� �ڱ�����!(�ߵ� Ȯ�� 1D6)");
		int dmg=d.dice(14);
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
		
		System.out.print(EName+"���� "+14+"D6 "+dmg+"������!");
		if(ER>0) System.out.print("("+EV+"D6 "+res+" ����)");
		if(DebuffTime>0) System.out.print("("+DebuffValue+"D6 "+deb+" �ݰ�)");
		System.out.print("\n");
		
		return dmg;
	}
	
	int Skill2()
	{
		//Nightmare_Heal
		System.out.println(Name+"�� �Ǹ��� ġ��!(�ߵ� Ȯ�� 2D6)");
		int heal;
		heal=d.dice(8);
		if(MAXHP-HP<heal) heal=MAXHP-HP;
		System.out.println(Name+"���� "+8+"D6 "+heal+"ġ��!\n");
		
		return heal;
	}
	
	int[] Skill3(int ER1,int EV1, int EHP1, int ER2,int EV2,int EHP2, int ER3,int EV3,int EHP3, int ER4,int EV4,int EHP4)
	{
		//Black_Tide
		System.out.println(Name+"�� ���� ����!(�ߵ� Ȯ�� 2D6)");
		
		int res=0,deb=0;
		int[] dmg=new int[5];
		
		if(EHP1!=0)
		{
			dmg[1]=d.dice(5);
			if(ER1>0)
			{
				res=d.dice(EV1);
				dmg[1]-=res;
			}
			if(DebuffTime>0)
			{
				deb=d.dice(DebuffValue);
				dmg[1]-=deb;
			}
			if(dmg[1]<0) dmg[1]=0;
			if(dmg[1]>EHP1) dmg[1]=EHP1;
			System.out.print("�ڷγ׿��� "+5+"D6 "+dmg[1]+"������!");
			if(ER1>0) System.out.print("("+EV1+"D6 "+res+" ����)");
			if(DebuffTime>0) System.out.print("("+DebuffValue+"D6 "+deb+" �ݰ�)");
			System.out.print("\n");
		}
		else dmg[1]=0;
		
		if(EHP2!=0)
		{
			dmg[2]=d.dice(5);
			if(ER2>0)
			{
				res=d.dice(EV2);
				dmg[2]-=res;
			}
			if(DebuffTime>0)
			{
				deb=d.dice(DebuffValue);
				dmg[2]-=deb;
			}
			if(dmg[2]<0) dmg[2]=0;
			if(dmg[2]>EHP2) dmg[2]=EHP2;
			System.out.print("�����߿��� "+5+"D6 "+dmg[2]+"������!");
			if(ER2>0) System.out.print("("+EV2+"D6 "+res+" ����)");
			if(DebuffTime>0) System.out.print("("+DebuffValue+"D6 "+deb+" �ݰ�)");
			System.out.print("\n");
		}
		else dmg[2]=0;
		
		if(EHP3!=0)
		{
			dmg[3]=d.dice(10);
			if(ER3>0)
			{
				res=d.dice(EV3);
				dmg[3]-=res;
			}
			if(DebuffTime>0)
			{
				deb=d.dice(DebuffValue);
				dmg[3]-=deb;
			}
			if(dmg[3]<0) dmg[3]=0;
			if(dmg[3]>EHP3) dmg[3]=EHP3;
			System.out.print("��ī��Ű���� "+5+"D6 "+dmg[3]+"������!");
			if(ER3>0) System.out.print("("+EV3+"D6 "+res+" ����)");
			if(DebuffTime>0) System.out.print("("+DebuffValue+"D6 "+deb+" �ݰ�)");
			System.out.print("\n");
		}
		else dmg[3]=0;
		
		if(EHP4!=0)
		{
			dmg[4]=d.dice(10);
			if(ER4>0)
			{
				res=d.dice(EV4);
				dmg[4]-=res;
			}
			if(DebuffTime>0)
			{
				deb=d.dice(DebuffValue);
				dmg[4]-=deb;
			}
			if(dmg[4]<0) dmg[4]=0;
			if(dmg[4]>EHP4) dmg[4]=EHP4;
			System.out.print("��ġ���� "+5+"D6 "+dmg[4]+"������!");
			if(ER4>0) System.out.print("("+EV4+"D6 "+res+" ����)");
			if(DebuffTime>0) System.out.print("("+DebuffValue+"D6 "+deb+" �ݰ�)");
			System.out.print("\n");
		}
		else dmg[4]=0;
		
		
		return dmg;
		
	}
	
	
	
}
