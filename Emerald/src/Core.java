import java.util.Scanner;
/*
���� �ý���
-nD6�� n���� ������ �ֻ����� ���� ���� ���� �ǹ��մϴ�.
-Ȯ���� ���� ��� �ֻ��� 1���� ������ n���� ���� Ȯ���Դϴ�. �� 1D6�� 1/6 Ȯ���Դϴ�.
-��ų�� MP�� �Ҹ��ϸ� MP�� �����ϸ� ����� �� �����ϴ�.
-MP�� �ϸ��� 10�� ȸ���˴ϴ�.
-�Ʊ��� �Ͽ��� �Ʊ� �� �Ѹ��� ��� ��ų�� ����ϰ� �������� ��Ÿ�� ����մϴ�(��ų�� ������� ���� ���� �ֽ��ϴ�)
-��Ÿ���� 1D6 Ȯ���� ġ��Ÿ�� �ߵ��Ͽ� 2���� �������� �����ϴ�.
-HP�� ��� �������� ������ ���°� �˴ϴ�. �� ���¿����� �����̳� ��ų�� ����� �� ������ ���ݴ������� �ʽ��ϴ�.
-������ �Ͽ��� ���� ������ �Ʊ��� ������� ��Ÿ�� ����ϰ� �߰��� Ȯ�������� ��ų�� �ߵ��մϴ�.
-������ ������ HP�� MP�� ��� ȸ���մϴ�.
-ó���� �ο� �� ���� �����մϴ�.
-�ּ� ó���� ���� �뷫������ § ��ũ��Ʈ�Դϴ�.

ĳ����

�ڷγ�[����] HP 300 MP 150 ��Ÿ 4D6
	-����
		�нú�. ���� ���� �� ��ų�� �ڽſ��� �����Ѵ�.
	-��� �¼�
		MP �Ҹ� 50. 4�� ���� �޴� ���ظ� 4D6��ŭ �氨�Ѵ�.
	-�ʻ��� �ϰ�
		MP �Ҹ� 60. �� �ϳ����� 18D6�� �������� ������. ����� ü���� 40% ������ ��� ������ 2��.

������[������] HP 175 MP 300 ��Ÿ 2D6
	-���� ���������
		�нú�. ��Ÿ�� ġ��Ÿ�� �ߵ��ϸ� �߰��� 5D6�� �������� �ְ�, 60�� ������ �ǵ��� �޴´�.
	-������
		MP �Ҹ� 150. �� ��ü���� 3�Ͽ� ���� 1�ϴ� 15D6�� �������� ������.
	-ȭ�� �۷�
		MP �Ҹ� 80. �� �ϳ����� 25D6�� �������� ������. ���� �������� ȿ���� �ް� �ִٸ� 10D6�� �������� �߰��Ѵ�.

��ī��Ű[��ɲ�] HP 250 MP 200 ��Ÿ 6D6
	-������ ���߷�
		�нú�. �� 4��° ��Ÿ�� ������ ġ��Ÿ ȿ���� �޴´�.
	-��ī�ο� ȭ��
		MP �Ҹ� 80. ������ 5�ϵ��� �ڽ��� ��Ÿ�� 5D6�� �߰� �������� �ο��Ѵ�. ��Ÿ�� ���� ���ȴ�. �ߺ��Ͽ� ����� �� ����.
	-���� ��Ÿ
		MP �Ҹ� 60. �� �ϳ����� 8D6�� �������� �ְ�, 4�ϵ��� ���� ������ 3D6�� ���ظ� �� �ش�.
		
��ġ[����̵�] HP 200 MP 250 ��Ÿ 3D6
	-���� ����
		�нú�. ��ų�� �ش�ȭ ȿ���� ������ ������, �ش�ȭ �� ȿ���� 2.5��� �����Ѵ�.
	-���
		MP �Ҹ� 80. �Ʊ� �ϳ��� ü���� 4�Ͽ� ���� 8D6�� ȸ���Ѵ�. ���ÿ� ���� ��󿡰� �� �� �ִ�. ���� ��󿡰� �����ϸ� ���� �ð��� �����Ѵ�.
	-�ڿ��� ����
		MP �Ҹ� 100. �Ʊ� ��ü�� ü���� ��� 14D6��ŭ ȸ����Ų��.
		
��
��ѱ� HP 100 ��Ÿ 2D6

ȣ���� HP 350 ��Ÿ 4D6

���� HP 250 ��Ÿ 3D6
	-���� �Ͻ�
		�ߵ� Ȯ�� 2D6. 6D6�� ���ظ� ������ 1�ϰ� �ൿ�Ҵ� ���·� �����.
		
������ �� HP 500 ��Ÿ 6D6
	-�β��� ����
		�нú�. �ڽſ��� ������ ��� ���ظ� 3D6��ŭ �氨�Ѵ�.
	-����
	 	�ߵ� Ȯ�� 2D6. ��뿡�� 4�ϵ��� 3D6�� ���� ȿ���� �ο��Ѵ�. �� ȿ���� �ߺ����� �ʴ´�.

�Ǹ��� ����̵� HP 1200 ��Ÿ 5D6
	-�ڱ�����
		�ߵ� Ȯ�� 1D6. ������ 14D6�� ���ظ� �ش�.
	-�Ǹ��� ġ��
		�ߵ� Ȯ�� 2D6. �ڽ��� ü���� 8D6 ȸ���Ѵ�.
  	-���� ����
	 	�ߵ� Ȯ�� 2D6. �� ��ü���� 5D6�� ���ظ� ������.


*/
public class Core {

	static Enemy[] e= new Enemy[4];
	
	static void ViewStatus(Character korone,Character tsukumoya,Character sakazuki,Character hachi)
	{
		korone.Status();
		tsukumoya.Status();
		sakazuki.Status();
		hachi.Status();
		System.out.print("\n");
	}
	
	static void ViewEnemyStatus(Enemy e1,Enemy e2,Enemy e3)
	{
		System.out.print("�� 1:");
		e1.Status();
		System.out.print("�� 2:");
		e2.Status();
		System.out.print("�� 3:");
		e3.Status();
		System.out.print("\n");
	}
	
	
	static void battle(int e1,int e2,int e3)
	{
		Dice d=new Dice();
		
		Korone korone=new Korone();
		Tsukumoya tsukumoya=new Tsukumoya();
		Sakazuki sakazuki=new Sakazuki();
		Hachi hachi=new Hachi();
		
		if(e1==1) e[1]=new Pigeon();
		else if(e1==2) e[1]=new Tiger();
		else if(e1==3) e[1]=new Rogue();
		else if(e1==4) e[1]=new Bear();
		else if(e1==5) e[1]=new Druid();
		
		if(e2==1) e[2]=new Pigeon();
		else if(e2==2) e[2]=new Tiger();
		else if(e2==3) e[2]=new Rogue();
		else if(e2==4) e[2]=new Bear();
		else if(e2==5) e[2]=new Druid();
		
		if(e3==1) e[3]=new Pigeon();
		else if(e3==2) e[3]=new Tiger();
		else if(e3==3) e[3]=new Rogue();
		else if(e3==4) e[3]=new Bear();
		else if(e3==5) e[3]=new Druid();
		
		int skill1=0,skill2=0, attack=0,healing;
		
		Scanner sc=new Scanner(System.in);
		
		boolean flag=false;
		

		
		while(true)
		{
			if(e[1].HP==0 && e[2].HP==0 && e[3].HP==0) break;
			if(korone.HP==0 && tsukumoya.HP==0 && sakazuki.HP==0 && hachi.HP==0) break;
			
			ViewStatus(korone,tsukumoya,sakazuki,hachi);
			ViewEnemyStatus(e[1],e[2],e[3]);
			
			flag=false;
			while(true)
			{
				if(flag==true) break;
				while(true)
				{
					System.out.println("\n������ ��ų�� ����Ͻðڽ��ϱ�?");
					System.out.println("1: �ڷγ� 2: ������ 3: ��ī��Ű 4: ��ġ 5: ������� �ʴ´�");
					skill1=sc.nextInt();
					if(skill1==1 && korone.HP==0) System.out.println("�ڷγ״� ������ ���´�. �ٸ� �Ʊ��� ��������.");
					else if(skill1==2 && tsukumoya.HP==0) System.out.println("�����ߴ� ������ ���´�. �ٸ� �Ʊ��� ��������.");
					else if(skill1==3 && sakazuki.HP==0) System.out.println("��ī��Ű�� ������ ���´�. �ٸ� �Ʊ��� ��������.");
					else if(skill1==4 && hachi.HP==0) System.out.println("��ġ�� ������ ���´�. �ٸ� �Ʊ��� ��������.");
					else break;
				}
				
				if(skill1==1 || skill1==2 || skill1==3 || skill1==4)
				{
					while(true)
					{
						System.out.println("\n� ��ų�� ����Ͻðڽ��ϱ�?");
						if(skill1==1) System.out.println("1: ��� �¼� 2: �ʻ��� �ϰ� 3:���");
						if(skill1==2) System.out.println("1: ������ 2: ȭ�� �۷� 3:���");
						if(skill1==3) System.out.println("1: ��ī�ο� ȭ�� 2: ���� ��Ÿ 3:���");
						if(skill1==4) System.out.println("1: ��� 2: �ڿ��� ���� 3:���");
						skill2=sc.nextInt();
						if(skill2!=1 && skill2!=2 && skill2!=3)
						{
							System.out.println("�߸��� �Է��Դϴ�.");
						}
						else
						{
							if(skill1==1 && skill2==1 && korone.MP<50) System.out.println("������ �����մϴ�.");
							else if(skill1==1 && skill2==2 && korone.MP<60) System.out.println("������ �����մϴ�.");
							else if(skill1==2 && skill2==1 && tsukumoya.MP<150) System.out.println("������ �����մϴ�.");
							else if(skill1==2 && skill2==2 && tsukumoya.MP<80) System.out.println("������ �����մϴ�.");
							else if(skill1==3 && skill2==1 && sakazuki.MP<80) System.out.println("������ �����մϴ�.");
							else if(skill1==3 && skill2==2 && sakazuki.MP<60) System.out.println("������ �����մϴ�.");
							else if(skill1==4 && skill2==1 && hachi.MP<80) System.out.println("������ �����մϴ�.");
							else if(skill1==4 && skill2==2 && hachi.MP<100) System.out.println("������ �����մϴ�.");
							else if(skill2!=3) flag=true;
							break;
						}
					}
				}
				else flag=true;
			}
			System.out.print("\n");
				
			
			
			if(tsukumoya.HP!=0 && tsukumoya.Blizzard_Remain>0)
			{
				int[] dmg3=new int[5];
				dmg3=tsukumoya.Blizzard_1tick(e[1].ResistTime, e[1].ResistValue, e[1].HP, e[1].Name, e[2].ResistTime, e[2].ResistValue, e[2].HP, e[2].Name, e[3].ResistTime, e[3].ResistValue, e[3].HP, e[3].Name);
				if(e[1].HP!=0) e[1].HP-=dmg3[1];
				if(e[2].HP!=0) e[2].HP-=dmg3[2];
				if(e[3].HP!=0) e[3].HP-=dmg3[3];
				System.out.print("\n");
				if(e[1].HP==0 && e[2].HP==0 && e[3].HP==0) break;
			}
			
			if(korone.HP!=0)
			{
				if(korone.Stun==0)
				{
					if(skill1==1)
					{
						if(skill2==1)
						{
							korone.Sheild_Up();
						}
						else if(skill2==2)
						{
							while(true)
							{
								System.out.println("�ڷγ��� �ʻ��� �ϰ�: ��� ���� �����Ͻðڽ��ϱ�?");
								System.out.println("1: "+e[1].Name+"(HP:"+e[1].HP+"/"+e[1].MAXHP+") 2: "+e[2].Name+"(HP:"+e[2].HP+"/"+e[2].MAXHP+") 3: "+e[3].Name+"(HP:"+e[3].HP+"/"+e[3].MAXHP+")");
								attack=sc.nextInt();
								if((attack==1 && e[1].HP!=0)|| (attack==2 && e[2].HP!=0)|| (attack==3 && e[3].HP!=0)) break;
								else System.out.println("�߸��� �Է��Դϴ�.");
							}
							int dmg=korone.Mortal_Strike(attack, e[attack].ResistTime, e[attack].ResistValue, e[attack].HP,e[attack].MAXHP, e[attack].Name);
							e[attack].HP-=dmg;
						}
					}
					else
					{
						while(true)
						{
							System.out.println("�ڷγ��� ��Ÿ: ��� ���� �����Ͻðڽ��ϱ�?");
							System.out.println("1: "+e[1].Name+"(HP:"+e[1].HP+"/"+e[1].MAXHP+") 2: "+e[2].Name+"(HP:"+e[2].HP+"/"+e[2].MAXHP+") 3: "+e[3].Name+"(HP:"+e[3].HP+"/"+e[3].MAXHP+")");
							attack=sc.nextInt();
							if((attack==1 && e[1].HP!=0)|| (attack==2 && e[2].HP!=0)|| (attack==3 && e[3].HP!=0)) break;
							else System.out.println("�߸��� �Է��Դϴ�.");
						}
						int dmg=korone.AutoAttack(attack, e[attack].ResistTime, e[attack].ResistValue, e[attack].HP, e[attack].Name);
						e[attack].HP-=dmg;
					}
					
				}
				else System.out.println("�ڷγ״� �ൿ �Ҵ� ���´�.");
			}
			else System.out.println("�ڷγ״� ������ ���´�.");
			
			System.out.print("\n");
			if(e[1].HP==0 && e[2].HP==0 && e[3].HP==0) break;
			
			
			if(tsukumoya.HP!=0)
			{
				if(tsukumoya.Stun==0)
				{
					if(skill1==2)
					{
						if(skill2==1)
						{
							tsukumoya.Blizzard();
						}
						else if(skill2==2)
						{
							while(true)
							{
								System.out.println("�������� ȭ�� �۷�: ��� ���� �����Ͻðڽ��ϱ�?");
								System.out.println("1: "+e[1].Name+"(HP:"+e[1].HP+"/"+e[1].MAXHP+") 2: "+e[2].Name+"(HP:"+e[2].HP+"/"+e[2].MAXHP+") 3: "+e[3].Name+"(HP:"+e[3].HP+"/"+e[3].MAXHP+")");
								attack=sc.nextInt();
								if((attack==1 && e[1].HP!=0)|| (attack==2 && e[2].HP!=0)|| (attack==3 && e[3].HP!=0)) break;
								else System.out.println("�߸��� �Է��Դϴ�.");
							}
							int dmg=tsukumoya.FlameStrike(attack, e[attack].ResistTime, e[attack].ResistValue, e[attack].HP, e[attack].Name);
							e[attack].HP-=dmg;
						}
					}
					else
					{
						while(true)
						{
							System.out.println("�������� ��Ÿ: ��� ���� �����Ͻðڽ��ϱ�?");
							System.out.println("1: "+e[1].Name+"(HP:"+e[1].HP+"/"+e[1].MAXHP+") 2: "+e[2].Name+"(HP:"+e[2].HP+"/"+e[2].MAXHP+") 3: "+e[3].Name+"(HP:"+e[3].HP+"/"+e[3].MAXHP+")");
							attack=sc.nextInt();
							if((attack==1 && e[1].HP!=0)|| (attack==2 && e[2].HP!=0)|| (attack==3 && e[3].HP!=0)) break;
							else System.out.println("�߸��� �Է��Դϴ�.");
						}
						int dmg=tsukumoya.AutoAttack(attack, e[attack].ResistTime, e[attack].ResistValue, e[attack].HP, e[attack].Name);
						e[attack].HP-=dmg;
					}
					
				}
				else System.out.println("�����ߴ� �ൿ �Ҵ� ���´�.");
			}
			else System.out.println("�����ߴ� ������ ���´�.");
			
			System.out.print("\n");
			if(e[1].HP==0 && e[2].HP==0 && e[3].HP==0) break;
			
			if(sakazuki.HP!=0)
			{
				if(sakazuki.Stun==0)
				{
					if(skill1==3)
					{
						if(skill2==1)
						{
							while(true)
							{
								System.out.print("��ī��Ű�� ��ī�ο� ȭ��");
								if(sakazuki.stack==3) System.out.print("(������ ���߷� �ߵ�)");
								System.out.println(": ��� ���� �����Ͻðڽ��ϱ�?");
								System.out.println("1: "+e[1].Name+"(HP:"+e[1].HP+"/"+e[1].MAXHP+") 2: "+e[2].Name+"(HP:"+e[2].HP+"/"+e[2].MAXHP+") 3: "+e[3].Name+"(HP:"+e[3].HP+"/"+e[3].MAXHP+")");
								attack=sc.nextInt();
								if((attack==1 && e[1].HP!=0)|| (attack==2 && e[2].HP!=0)|| (attack==3 && e[3].HP!=0)) break;
								else System.out.println("�߸��� �Է��Դϴ�.");
							}
							int dmg=sakazuki.Arrow(attack, e[attack].ResistTime, e[attack].ResistValue, e[attack].HP, e[attack].Name);
							e[attack].HP-=dmg;
						}
						else if(skill2==2)
						{
							while(true)
							{
								System.out.println("��ī��Ű�� ���� ��Ÿ: ��� ���� �����Ͻðڽ��ϱ�?");
								
								System.out.println("1: "+e[1].Name+"(HP:"+e[1].HP+"/"+e[1].MAXHP+") 2: "+e[2].Name+"(HP:"+e[2].HP+"/"+e[2].MAXHP+") 3: "+e[3].Name+"(HP:"+e[3].HP+"/"+e[3].MAXHP+")");
								attack=sc.nextInt();
								if((attack==1 && e[1].HP!=0)|| (attack==2 && e[2].HP!=0)|| (attack==3 && e[3].HP!=0)) break;
								else System.out.println("�߸��� �Է��Դϴ�.");
							}
							int dmg=sakazuki.Side_Strike(attack, e[attack].ResistTime, e[attack].ResistValue, e[attack].HP, e[attack].Name);
							e[attack].HP-=dmg;
							e[attack].DebuffTime=4;
							e[attack].DebuffValue=3;
						}
					}
					else
					{
						while(true)
						{
							System.out.print("��ī��Ű�� ��Ÿ");
							if(sakazuki.Arrow_Remain>0) System.out.print("(��ī�ο� ȭ��)");
							if(sakazuki.stack==3) System.out.print("(������ ���߷� �ߵ�)");
							System.out.println(": ��� ���� �����Ͻðڽ��ϱ�?");
							System.out.println("1: "+e[1].Name+"(HP:"+e[1].HP+"/"+e[1].MAXHP+") 2: "+e[2].Name+"(HP:"+e[2].HP+"/"+e[2].MAXHP+") 3: "+e[3].Name+"(HP:"+e[3].HP+"/"+e[3].MAXHP+")");
							attack=sc.nextInt();
							if((attack==1 && e[1].HP!=0)|| (attack==2 && e[2].HP!=0)|| (attack==3 && e[3].HP!=0)) break;
							else System.out.println("�߸��� �Է��Դϴ�.");
						}
						int dmg=sakazuki.AutoAttack(attack, e[attack].ResistTime, e[attack].ResistValue, e[attack].HP, e[attack].Name);
						e[attack].HP-=dmg;
					}
					
				}
				else System.out.println("��ī��Ű�� �ൿ �Ҵ� ���´�.");
			}
			else System.out.println("��ī��Ű�� ������ ���´�.");
			
			System.out.print("\n");
			if(e[1].HP==0 && e[2].HP==0 && e[3].HP==0) break;
			
			if(hachi.HP!=0)
			{
				if(hachi.Stun==0)
				{
					if(skill1==4)
					{
						if(skill2==1)
						{
							while(true)
							{
								
								System.out.println("��ġ�� ���: ��� �Ʊ��� ġ���Ͻðڽ��ϱ�?");
								System.out.println("1: �ڷγ�"+"(HP:"+korone.HP+"/"+korone.MAXHP+")"+" 2: ������"+"(HP:"+tsukumoya.HP+"/"+tsukumoya.MAXHP+")"+" 3: ��ī��Ű"+"(HP:"+sakazuki.HP+"/"+sakazuki.MAXHP+")"+" 4: ��ġ"+"(HP:"+hachi.HP+"/"+hachi.MAXHP+")");
								healing=sc.nextInt();
								if((healing==1 && korone.HP!=0)|| (healing==2 && tsukumoya.HP!=0) || (healing==3 && sakazuki.HP!=0) || (healing==4 && hachi.HP!=0) ) break;
								else System.out.println("�߸��� �Է��Դϴ�.");
							}
							int healv=hachi.Regenerate(healing);
							if(healing==1)
							{
								korone.HealTime=4;
								korone.HealValue=healv;
							}
							if(healing==2) 
							{
								tsukumoya.HealTime=4;
								tsukumoya.HealValue=healv;
							}
							if(healing==3)
							{
								sakazuki.HealTime=4;
								sakazuki.HealValue=healv;
							}
							if(healing==4)
							{
								hachi.HealTime=4;
								hachi.HealValue=healv;
							}
						}
						else if(skill2==2)
						{
							int[] heal=new int[5];
							heal=hachi.Bless(korone.HP, korone.MAXHP, tsukumoya.HP, tsukumoya.MAXHP, sakazuki.HP, sakazuki.MAXHP, hachi.HP, hachi.MAXHP);
							if(korone.HP!=0) korone.HP+=heal[1];
							if(tsukumoya.HP!=0) tsukumoya.HP+=heal[2];
							if(sakazuki.HP!=0) sakazuki.HP+=heal[3];
							if(hachi.HP!=0) hachi.HP+=heal[4];
						}
					}
					else
					{
						while(true)
						{
							System.out.println("��ġ�� ��Ÿ: ��� ���� �����Ͻðڽ��ϱ�?");
							System.out.println("1: "+e[1].Name+"(HP:"+e[1].HP+"/"+e[1].MAXHP+") 2: "+e[2].Name+"(HP:"+e[2].HP+"/"+e[2].MAXHP+") 3: "+e[3].Name+"(HP:"+e[3].HP+"/"+e[3].MAXHP+")");
							attack=sc.nextInt();
							if((attack==1 && e[1].HP!=0)|| (attack==2 && e[2].HP!=0)|| (attack==3 && e[3].HP!=0)) break;
							else System.out.println("�߸��� �Է��Դϴ�.");
						}
						int dmg=hachi.AutoAttack(attack, e[attack].ResistTime, e[attack].ResistValue, e[attack].HP, e[attack].Name);
						e[attack].HP-=dmg;
					}
					
				}
				else System.out.println("��ġ�� �ൿ �Ҵ� ���´�.");
			}
			else System.out.println("��ġ�� ������ ���´�.");
			
			System.out.print("\n");
			if(e[1].HP==0 && e[2].HP==0 && e[3].HP==0) break;
			
			for(int i=1;i<=3;i++)
			{
				if(e[i].HP!=0)
				{
					if(korone.HP!=0) 
					{
						int dmg=e[i].AutoAttack(1, korone.ResistTime, korone.ResistValue, korone.HP, korone.Name);
						korone.HP-=dmg;
					}
					else
					{
						
						while(true)
						{
							int atk=d.atk();
							if(atk==2)
							{
								if(tsukumoya.HP!=0)
								{
									int dmg=e[i].AutoAttack(1, tsukumoya.ResistTime, tsukumoya.ResistValue, tsukumoya.HP, tsukumoya.Name);
									tsukumoya.HP-=dmg;
									break;
								}
							}
							else if(atk==3)
							{
								if(sakazuki.HP!=0)
								{
									int dmg=e[i].AutoAttack(1, sakazuki.ResistTime, sakazuki.ResistValue, sakazuki.HP, sakazuki.Name);
									sakazuki.HP-=dmg;
									break;
								}
							}
							else if(atk==4)
							{
								if(hachi.HP!=0)
								{
									int dmg=e[i].AutoAttack(1, hachi.ResistTime, hachi.ResistValue, hachi.HP, hachi.Name);
									hachi.HP-=dmg;
									break;
								}
							}
						}
					}
					
					System.out.print("\n");
					if(korone.HP==0 && tsukumoya.HP==0 && sakazuki.HP==0 && hachi.HP==0) break;
					
					int en=0;
					if(i==1) en=e1;
					else if(i==2) en=e2;
					else if(i==3) en=e3;
					
					if(en==3)
					{
						if(d.crit(2))
						{
							if(korone.HP!=0) 
							{
								int dmg=e[i].Skill1(1, korone.ResistTime, korone.ResistValue, korone.HP, korone.Name);
								korone.HP-=dmg;
								korone.Stun=2;
							}
							else
							{
								while(true)
								{
									int atk=d.atk();
									if(atk==2)
									{
										if(tsukumoya.HP!=0)
										{
											int dmg=e[i].Skill1(1, tsukumoya.ResistTime, tsukumoya.ResistValue, tsukumoya.HP, tsukumoya.Name);
											tsukumoya.HP-=dmg;
											tsukumoya.Stun=2;
											break;
										}
									}
									else if(atk==3)
									{
										if(sakazuki.HP!=0)
										{
											int dmg=e[i].Skill1(1, sakazuki.ResistTime, sakazuki.ResistValue, sakazuki.HP, sakazuki.Name);
											sakazuki.HP-=dmg;
											sakazuki.Stun=2;
											break;
										}
									}
									else if(atk==4)
									{
										if(hachi.HP!=0)
										{
											int dmg=e[i].Skill1(1, hachi.ResistTime, hachi.ResistValue, hachi.HP, hachi.Name);
											hachi.HP-=dmg;
											hachi.Stun=2;
											break;
										}
									}
								}
							}
							
							System.out.print("\n");
							if(korone.HP==0 && tsukumoya.HP==0 && sakazuki.HP==0 && hachi.HP==0) break;
						}
						
					}
					else if(en==4)
					{
						if(d.crit(2))
						{
							if(korone.HP!=0) 
							{
								korone.DealValue=e[i].Skill4(1, korone.Name);
								korone.DealTime=4;
							}
							else
							{
								while(true)
								{
									int atk=d.atk();
									if(atk==2)
									{
										if(tsukumoya.HP!=0)
										{
											tsukumoya.DealValue=e[i].Skill4(1, tsukumoya.Name);
											tsukumoya.DealTime=4;
											break;
										}
									}
									else if(atk==3)
									{
										if(sakazuki.HP!=0)
										{
											sakazuki.DealValue=e[i].Skill4(1, sakazuki.Name);
											sakazuki.DealTime=4;
											break;
										}
									}
									else if(atk==4)
									{
										if(hachi.HP!=0)
										{
											hachi.DealValue=e[i].Skill4(1, hachi.Name);
											hachi.DealTime=4;
											break;
										}
									}
								}
							}
							
							System.out.print("\n");
							if(korone.HP==0 && tsukumoya.HP==0 && sakazuki.HP==0 && hachi.HP==0) break;
						}
					}
					else if(en==5)
					{
						if(d.crit(1))
						{
							if(korone.HP!=0) 
							{
								int dmg=e[i].Skill1(1, korone.ResistTime, korone.ResistValue, korone.HP, korone.Name);
								korone.HP-=dmg;
							}
							else
							{
								while(true)
								{
									int atk=d.atk();
									if(atk==2)
									{
										if(tsukumoya.HP!=0)
										{
											int dmg=e[i].Skill1(1, tsukumoya.ResistTime, tsukumoya.ResistValue, tsukumoya.HP, tsukumoya.Name);
											tsukumoya.HP-=dmg;
											break;
										}
									}
									else if(atk==3)
									{
										if(sakazuki.HP!=0)
										{
											int dmg=e[i].Skill1(1, sakazuki.ResistTime, sakazuki.ResistValue, sakazuki.HP, sakazuki.Name);
											sakazuki.HP-=dmg;
											break;
										}
									}
									else if(atk==4)
									{
										if(hachi.HP!=0)
										{
											int dmg=e[i].Skill1(1, hachi.ResistTime, hachi.ResistValue, hachi.HP, hachi.Name);
											hachi.HP-=dmg;
											break;
										}
									}
								}
							}
							
							System.out.print("\n");
							if(korone.HP==0 && tsukumoya.HP==0 && sakazuki.HP==0 && hachi.HP==0) break;
						}
						
						if(d.crit(2))
						{
							e[i].HP+=e[i].Skill2();
						}
						
						if(d.crit(2))
						{
							int[] dmg4=new int[5];
							dmg4=e[i].Skill3(korone.ResistTime, korone.ResistValue, korone.HP, tsukumoya.ResistTime,tsukumoya.ResistValue,tsukumoya.HP, sakazuki.ResistTime,sakazuki.ResistValue,sakazuki.HP, hachi.ResistTime,hachi.ResistValue,hachi.HP);
							korone.HP-=dmg4[1];
							tsukumoya.HP-=dmg4[2];
							sakazuki.HP-=dmg4[3];
							hachi.HP-=dmg4[4];
						}
						
					}
					
					System.out.print("\n");
					if(korone.HP==0 && tsukumoya.HP==0 && sakazuki.HP==0 && hachi.HP==0) break;
					
				}
				
			}
			
			if(korone.HP!=0) korone.TurnCount();
			if(tsukumoya.HP!=0) tsukumoya.TurnCount();
			if(sakazuki.HP!=0) sakazuki.TurnCount();
			if(hachi.HP!=0) hachi.TurnCount();
			
			if(e[1].HP!=0) e[1].TurnCount();
			if(e[2].HP!=0) e[2].TurnCount();
			if(e[3].HP!=0) e[3].TurnCount();
			
			System.out.print("\n");
			if(korone.HP==0 && tsukumoya.HP==0 && sakazuki.HP==0 && hachi.HP==0) break;
			
		}
	}
	
	
	
	public static void main(String[] args) {
		
		int enemys1=0, enemys2=0, enemys3=0;
		Scanner enemyscanner=new Scanner(System.in);
		
		while(true)
		{
			System.out.println("�� 1�� ������ �ֽʽÿ�.");
			System.out.println("1: ��ѱ� 2: ȣ���� 3: ���� 4: ������ �� 5: �Ǹ��� ����̵�");
			enemys1=enemyscanner.nextInt();
			if(enemys1==1 || enemys1==2 || enemys1==3 || enemys1==4 || enemys1==5) break;
			else System.out.println("�߸��� �Է��Դϴ�.");
		}
		
		while(true)
		{
			System.out.println("\n�� 2�� ������ �ֽʽÿ�.");
			System.out.println("1: ��ѱ� 2: ȣ���� 3: ���� 4: ������ �� 5: �Ǹ��� ����̵�");
			enemys2=enemyscanner.nextInt();
			if(enemys2==1 || enemys2==2 || enemys2==3 || enemys2==4 || enemys2==5) break;
			else System.out.println("�߸��� �Է��Դϴ�.");
		}
		
		while(true)
		{
			System.out.println("\n�� 3�� ������ �ֽʽÿ�.");
			System.out.println("1: ��ѱ� 2: ȣ���� 3: ���� 4: ������ �� 5: �Ǹ��� ����̵�");
			enemys3=enemyscanner.nextInt();
			if(enemys3==1 || enemys3==2 || enemys3==3 || enemys3==4 || enemys3==5) break;
			else System.out.println("�߸��� �Է��Դϴ�.");
		}
		System.out.println("\n=========================================================================\n");
		battle(enemys1,enemys2,enemys3);
		
		/*
		System.out.println("=========================================================================\nChapter 1\n");
		battle(1,1,2);
		System.out.println("\n=========================================================================\nChapter 2\n");
		battle(2,2,3);
		System.out.println("\n=========================================================================\nChapter 3\n");
		battle(2,3,4);
		System.out.println("\n=========================================================================\nChapter 4\n");
		battle(1,2,5);
		System.out.println("\n=========================================================================\nChapter 5\n");
		battle(3,4,5);
		*/
	}

}
