
public class Hachi extends Character{

	public Hachi()
	{
		Name="��ġ";
		HP=200;
		MP=250;
		MAXHP=200;
		MAXMP=250;
		AT=3;
		ResistTime=0;
		ResistValue=0;
		HealTime=0;
		HealValue=4;
		DealTime=0;
		DealValue=0;
		Stun=0;
	}	
	
	int Regenerate(int x)
	{
		if(x==1) System.out.print("�ڷγ׿��� ");
		else if(x==2) System.out.print("�����߿��� ");
		else if(x==3) System.out.print("��ī��Ű���� ");
		else if(x==4) System.out.print("��ġ���� ");
		
		MP-=80;
		boolean crit=d.crit(1);
		System.out.println("��ġ�� ���!");
		if(crit==true) System.out.print("(��2.5 �ش�ȭ �ߵ�)");
		System.out.print("\n");
		
		if(crit==true) return 20;
		else return 8;
	}
	
	int[] Bless(int HP1,int MAXHP1,int HP2,int MAXHP2,int HP3,int MAXHP3,int HP4,int MAXHP4)
	{
		System.out.println("��ġ�� �ڿ��� ����!");
		MP-=100;
		
		int healv=14;
		boolean crit=d.crit(1);
		if(crit==true) healv=35;
		
		int[] heal=new int[5];
		heal[1]=d.dice(healv);
		if(MAXHP1-HP1<heal[1]) heal[1]=MAXHP1-HP1;
		System.out.print("�ڷγ׿��� "+healv+"D6 "+heal[1]+"ġ��!");
		if(crit==true) System.out.print("(��2.5 �ش�ȭ �ߵ�)");
		System.out.print("\n");

		heal[2]=d.dice(healv);
		if(MAXHP2-HP2<heal[2]) heal[2]=MAXHP2-HP2;
		System.out.print("�����߿��� "+healv+"D6 "+heal[2]+"ġ��!");
		if(crit==true) System.out.print("(��2.5 �ش�ȭ �ߵ�)");
		System.out.print("\n");
		
		heal[3]=d.dice(healv);
		if(MAXHP3-HP3<heal[3]) heal[3]=MAXHP3-HP3;
		System.out.print("��ī��Ű���� "+healv+"D6 "+heal[3]+"ġ��!");
		if(crit==true) System.out.print("(��2.5 �ش�ȭ �ߵ�)");
		System.out.print("\n");
		
		heal[4]=d.dice(healv);
		if(MAXHP4-HP4<heal[4]) heal[4]=MAXHP4-HP4;
		System.out.print("��ġ���� "+healv+"D6 "+heal[4]+"ġ��!");
		if(crit==true) System.out.print("(��2.5 �ش�ȭ �ߵ�)");
		System.out.print("\n");
		
		return heal;
	}
}
