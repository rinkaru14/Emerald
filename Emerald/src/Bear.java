
public class Bear extends Enemy{
	public Bear()
	{
		Name="광포한 곰";
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
		if(HP==0) System.out.print(" (쓰러짐)\n");
		else
		{
			if(ResistTime==1) System.out.print(" (두꺼운 가죽)");
			if(DebuffTime>0) System.out.print(" (측방 강타 "+DebuffTime+"턴 남음)");
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
		System.out.println(Name+"의 물기!(발동 확률 2D6)");
		System.out.println(EName+"에게 4턴간 3D6 출혈 효과 부여!");
		return 3;
	}
}
