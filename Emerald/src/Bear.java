
public class Bear extends Enemy{
	public Bear()
	{
		Name="������ ��";
		MAXHP=500;
		HP=500;
		AT=6;
		ResistTime=1;
		ResistValue=3;
		DebuffTime=0;
		DebuffValue=0;
	}
	
	void Status()
	{
		System.out.print(Name+" HP:"+HP+"/"+MAXHP);
		if(HP==0) System.out.print(" (������)\n");
		else
		{
			if(ResistTime==1) System.out.print(" (�β��� ����)");
			if(DebuffTime>0) System.out.print(" (���� ��Ÿ "+DebuffTime+"�� ����)");
			System.out.print("\n");
		}
	}
	
	void TurnCount()
	{
		if(DebuffTime>0) DebuffTime--;
	}
	
	int Skill4(int x,String EName)
	{
		//Bite
		System.out.println(Name+"�� ����!(�ߵ� Ȯ�� 2D6)");
		System.out.println(EName+"���� 4�ϰ� 3D6 ���� ȿ�� �ο�!");
		return 3;
	}
}
