import java.util.Scanner;
/*
게임 시스템
-nD6은 n개의 보통의 주사위를 굴린 값의 합을 의미합니다.
-확률로 사용될 경우 주사위 1개를 굴려서 n보다 낮을 확률입니다. 즉 1D6은 1/6 확률입니다.
-스킬은 MP를 소모하며 MP가 부족하면 사용할 수 없습니다.
-MP는 턴마다 10씩 회복됩니다.
-아군의 턴에는 아군 중 한명을 골라서 스킬을 사용하고 나머지는 평타를 사용합니다(스킬을 사용하지 않을 수도 있습니다)
-평타에는 1D6 확률로 치명타가 발동하여 2배의 데미지를 입힙니다.
-HP가 모두 떨어지면 쓰러짐 상태가 됩니다. 이 상태에서는 공격이나 스킬을 사용할 수 없으며 공격당하지도 않습니다.
-적군의 턴에는 적이 무작위 아군을 대상으로 평타를 사용하고 추가로 확률적으로 스킬을 발동합니다.
-전투가 끝나면 HP와 MP를 모두 회복합니다.
-처음에 싸울 적 셋을 선택합니다.
-주석 처리된 쪽은 대략적으로 짠 스크립트입니다.

캐릭터

코로네[전사] HP 300 MP 150 평타 4D6
	-도발
		패시브. 적의 공격 및 스킬을 자신에게 유도한다.
	-방어 태세
		MP 소모 50. 4턴 동안 받는 피해를 4D6만큼 경감한다.
	-필사의 일격
		MP 소모 60. 적 하나에게 18D6의 데미지를 입힌다. 상대의 체력이 40% 이하일 경우 데미지 2배.

츠쿠모야[마법사] HP 175 MP 300 평타 2D6
	-마나 끌어모으기
		패시브. 평타에 치명타가 발동하면 추가로 5D6의 데미지를 주고, 60의 마나를 되돌려 받는다.
	-눈보라
		MP 소모 150. 적 전체에게 3턴에 걸쳐 1턴당 15D6의 데미지를 입힌다.
	-화염 작렬
		MP 소모 80. 적 하나에게 25D6의 데미지를 입힌다. 적이 눈보라의 효과를 받고 있다면 10D6의 데미지를 추가한다.

사카즈키[사냥꾼] HP 250 MP 200 평타 6D6
	-예리한 집중력
		패시브. 매 4번째 평타가 언제나 치명타 효과를 받는다.
	-날카로운 화살
		MP 소모 80. 앞으로 5턴동안 자신의 평타에 5D6의 추가 데미지를 부여한다. 평타와 같이 사용된다. 중복하여 사용할 수 없다.
	-측방 강타
		MP 소모 60. 적 하나에게 8D6의 데미지를 주고, 4턴동안 적의 공격이 3D6의 피해를 덜 준다.
		
하치[드루이드] HP 200 MP 250 평타 3D6
	-마법 연마
		패시브. 스킬이 극대화 효과의 영향을 받으며, 극대화 시 효율이 2.5배로 증가한다.
	-재생
		MP 소모 80. 아군 하나의 체력을 4턴에 걸쳐 8D6씩 회복한다. 동시에 여러 대상에게 걸 수 있다. 같은 대상에게 시전하면 지속 시간을 갱신한다.
	-자연의 은총
		MP 소모 100. 아군 전체의 체력을 즉시 14D6만큼 회복시킨다.
		
적
비둘기 HP 100 평타 2D6

호랑이 HP 350 평타 4D6

도적 HP 250 평타 3D6
	-비열한 암습
		발동 확률 2D6. 6D6의 피해를 입히고 1턴간 행동불능 상태로 만든다.
		
광포한 곰 HP 500 평타 6D6
	-두꺼운 가죽
		패시브. 자신에게 들어오는 모든 피해를 3D6만큼 경감한다.
	-물기
	 	발동 확률 2D6. 상대에게 4턴동안 3D6의 출혈 효과를 부여한다. 이 효과는 중복되지 않는다.

악몽의 드루이드 HP 1200 평타 5D6
	-자군야포
		발동 확률 1D6. 적에게 14D6의 피해를 준다.
	-악몽의 치유
		발동 확률 2D6. 자신의 체력을 8D6 회복한다.
  	-검은 물결
	 	발동 확률 2D6. 적 전체에게 5D6의 피해를 입힌다.


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
		System.out.print("적 1:");
		e1.Status();
		System.out.print("적 2:");
		e2.Status();
		System.out.print("적 3:");
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
					System.out.println("\n누구의 스킬을 사용하시겠습니까?");
					System.out.println("1: 코로네 2: 츠쿠모야 3: 사카즈키 4: 하치 5: 사용하지 않는다");
					skill1=sc.nextInt();
					if(skill1==1 && korone.HP==0) System.out.println("코로네는 쓰러진 상태다. 다른 아군을 선택하자.");
					else if(skill1==2 && tsukumoya.HP==0) System.out.println("츠쿠모야는 쓰러진 상태다. 다른 아군을 선택하자.");
					else if(skill1==3 && sakazuki.HP==0) System.out.println("사카즈키는 쓰러진 상태다. 다른 아군을 선택하자.");
					else if(skill1==4 && hachi.HP==0) System.out.println("하치는 쓰러진 상태다. 다른 아군을 선택하자.");
					else break;
				}
				
				if(skill1==1 || skill1==2 || skill1==3 || skill1==4)
				{
					while(true)
					{
						System.out.println("\n어떤 스킬을 사용하시겠습니까?");
						if(skill1==1) System.out.println("1: 방어 태세 2: 필사의 일격 3:취소");
						if(skill1==2) System.out.println("1: 눈보라 2: 화염 작렬 3:취소");
						if(skill1==3) System.out.println("1: 날카로운 화살 2: 측방 강타 3:취소");
						if(skill1==4) System.out.println("1: 재생 2: 자연의 은총 3:취소");
						skill2=sc.nextInt();
						if(skill2!=1 && skill2!=2 && skill2!=3)
						{
							System.out.println("잘못된 입력입니다.");
						}
						else
						{
							if(skill1==1 && skill2==1 && korone.MP<50) System.out.println("마나가 부족합니다.");
							else if(skill1==1 && skill2==2 && korone.MP<60) System.out.println("마나가 부족합니다.");
							else if(skill1==2 && skill2==1 && tsukumoya.MP<150) System.out.println("마나가 부족합니다.");
							else if(skill1==2 && skill2==2 && tsukumoya.MP<80) System.out.println("마나가 부족합니다.");
							else if(skill1==3 && skill2==1 && sakazuki.MP<80) System.out.println("마나가 부족합니다.");
							else if(skill1==3 && skill2==2 && sakazuki.MP<60) System.out.println("마나가 부족합니다.");
							else if(skill1==4 && skill2==1 && hachi.MP<80) System.out.println("마나가 부족합니다.");
							else if(skill1==4 && skill2==2 && hachi.MP<100) System.out.println("마나가 부족합니다.");
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
								System.out.println("코로네의 필사의 일격: 어느 적을 공격하시겠습니까?");
								System.out.println("1: "+e[1].Name+"(HP:"+e[1].HP+"/"+e[1].MAXHP+") 2: "+e[2].Name+"(HP:"+e[2].HP+"/"+e[2].MAXHP+") 3: "+e[3].Name+"(HP:"+e[3].HP+"/"+e[3].MAXHP+")");
								attack=sc.nextInt();
								if((attack==1 && e[1].HP!=0)|| (attack==2 && e[2].HP!=0)|| (attack==3 && e[3].HP!=0)) break;
								else System.out.println("잘못된 입력입니다.");
							}
							int dmg=korone.Mortal_Strike(attack, e[attack].ResistTime, e[attack].ResistValue, e[attack].HP,e[attack].MAXHP, e[attack].Name);
							e[attack].HP-=dmg;
						}
					}
					else
					{
						while(true)
						{
							System.out.println("코로네의 평타: 어느 적을 공격하시겠습니까?");
							System.out.println("1: "+e[1].Name+"(HP:"+e[1].HP+"/"+e[1].MAXHP+") 2: "+e[2].Name+"(HP:"+e[2].HP+"/"+e[2].MAXHP+") 3: "+e[3].Name+"(HP:"+e[3].HP+"/"+e[3].MAXHP+")");
							attack=sc.nextInt();
							if((attack==1 && e[1].HP!=0)|| (attack==2 && e[2].HP!=0)|| (attack==3 && e[3].HP!=0)) break;
							else System.out.println("잘못된 입력입니다.");
						}
						int dmg=korone.AutoAttack(attack, e[attack].ResistTime, e[attack].ResistValue, e[attack].HP, e[attack].Name);
						e[attack].HP-=dmg;
					}
					
				}
				else System.out.println("코로네는 행동 불능 상태다.");
			}
			else System.out.println("코로네는 쓰러진 상태다.");
			
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
								System.out.println("츠쿠모야의 화염 작렬: 어느 적을 공격하시겠습니까?");
								System.out.println("1: "+e[1].Name+"(HP:"+e[1].HP+"/"+e[1].MAXHP+") 2: "+e[2].Name+"(HP:"+e[2].HP+"/"+e[2].MAXHP+") 3: "+e[3].Name+"(HP:"+e[3].HP+"/"+e[3].MAXHP+")");
								attack=sc.nextInt();
								if((attack==1 && e[1].HP!=0)|| (attack==2 && e[2].HP!=0)|| (attack==3 && e[3].HP!=0)) break;
								else System.out.println("잘못된 입력입니다.");
							}
							int dmg=tsukumoya.FlameStrike(attack, e[attack].ResistTime, e[attack].ResistValue, e[attack].HP, e[attack].Name);
							e[attack].HP-=dmg;
						}
					}
					else
					{
						while(true)
						{
							System.out.println("츠쿠모야의 평타: 어느 적을 공격하시겠습니까?");
							System.out.println("1: "+e[1].Name+"(HP:"+e[1].HP+"/"+e[1].MAXHP+") 2: "+e[2].Name+"(HP:"+e[2].HP+"/"+e[2].MAXHP+") 3: "+e[3].Name+"(HP:"+e[3].HP+"/"+e[3].MAXHP+")");
							attack=sc.nextInt();
							if((attack==1 && e[1].HP!=0)|| (attack==2 && e[2].HP!=0)|| (attack==3 && e[3].HP!=0)) break;
							else System.out.println("잘못된 입력입니다.");
						}
						int dmg=tsukumoya.AutoAttack(attack, e[attack].ResistTime, e[attack].ResistValue, e[attack].HP, e[attack].Name);
						e[attack].HP-=dmg;
					}
					
				}
				else System.out.println("츠쿠모야는 행동 불능 상태다.");
			}
			else System.out.println("츠쿠모야는 쓰러진 상태다.");
			
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
								System.out.print("사카즈키의 날카로운 화살");
								if(sakazuki.stack==3) System.out.print("(예리한 집중력 발동)");
								System.out.println(": 어느 적을 공격하시겠습니까?");
								System.out.println("1: "+e[1].Name+"(HP:"+e[1].HP+"/"+e[1].MAXHP+") 2: "+e[2].Name+"(HP:"+e[2].HP+"/"+e[2].MAXHP+") 3: "+e[3].Name+"(HP:"+e[3].HP+"/"+e[3].MAXHP+")");
								attack=sc.nextInt();
								if((attack==1 && e[1].HP!=0)|| (attack==2 && e[2].HP!=0)|| (attack==3 && e[3].HP!=0)) break;
								else System.out.println("잘못된 입력입니다.");
							}
							int dmg=sakazuki.Arrow(attack, e[attack].ResistTime, e[attack].ResistValue, e[attack].HP, e[attack].Name);
							e[attack].HP-=dmg;
						}
						else if(skill2==2)
						{
							while(true)
							{
								System.out.println("사카즈키의 측방 강타: 어느 적을 공격하시겠습니까?");
								
								System.out.println("1: "+e[1].Name+"(HP:"+e[1].HP+"/"+e[1].MAXHP+") 2: "+e[2].Name+"(HP:"+e[2].HP+"/"+e[2].MAXHP+") 3: "+e[3].Name+"(HP:"+e[3].HP+"/"+e[3].MAXHP+")");
								attack=sc.nextInt();
								if((attack==1 && e[1].HP!=0)|| (attack==2 && e[2].HP!=0)|| (attack==3 && e[3].HP!=0)) break;
								else System.out.println("잘못된 입력입니다.");
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
							System.out.print("사카즈키의 평타");
							if(sakazuki.Arrow_Remain>0) System.out.print("(날카로운 화살)");
							if(sakazuki.stack==3) System.out.print("(예리한 집중력 발동)");
							System.out.println(": 어느 적을 공격하시겠습니까?");
							System.out.println("1: "+e[1].Name+"(HP:"+e[1].HP+"/"+e[1].MAXHP+") 2: "+e[2].Name+"(HP:"+e[2].HP+"/"+e[2].MAXHP+") 3: "+e[3].Name+"(HP:"+e[3].HP+"/"+e[3].MAXHP+")");
							attack=sc.nextInt();
							if((attack==1 && e[1].HP!=0)|| (attack==2 && e[2].HP!=0)|| (attack==3 && e[3].HP!=0)) break;
							else System.out.println("잘못된 입력입니다.");
						}
						int dmg=sakazuki.AutoAttack(attack, e[attack].ResistTime, e[attack].ResistValue, e[attack].HP, e[attack].Name);
						e[attack].HP-=dmg;
					}
					
				}
				else System.out.println("사카즈키는 행동 불능 상태다.");
			}
			else System.out.println("사카즈키는 쓰러진 상태다.");
			
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
								
								System.out.println("하치의 재생: 어느 아군을 치유하시겠습니까?");
								System.out.println("1: 코로네"+"(HP:"+korone.HP+"/"+korone.MAXHP+")"+" 2: 츠쿠모야"+"(HP:"+tsukumoya.HP+"/"+tsukumoya.MAXHP+")"+" 3: 사카즈키"+"(HP:"+sakazuki.HP+"/"+sakazuki.MAXHP+")"+" 4: 하치"+"(HP:"+hachi.HP+"/"+hachi.MAXHP+")");
								healing=sc.nextInt();
								if((healing==1 && korone.HP!=0)|| (healing==2 && tsukumoya.HP!=0) || (healing==3 && sakazuki.HP!=0) || (healing==4 && hachi.HP!=0) ) break;
								else System.out.println("잘못된 입력입니다.");
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
							System.out.println("하치의 평타: 어느 적을 공격하시겠습니까?");
							System.out.println("1: "+e[1].Name+"(HP:"+e[1].HP+"/"+e[1].MAXHP+") 2: "+e[2].Name+"(HP:"+e[2].HP+"/"+e[2].MAXHP+") 3: "+e[3].Name+"(HP:"+e[3].HP+"/"+e[3].MAXHP+")");
							attack=sc.nextInt();
							if((attack==1 && e[1].HP!=0)|| (attack==2 && e[2].HP!=0)|| (attack==3 && e[3].HP!=0)) break;
							else System.out.println("잘못된 입력입니다.");
						}
						int dmg=hachi.AutoAttack(attack, e[attack].ResistTime, e[attack].ResistValue, e[attack].HP, e[attack].Name);
						e[attack].HP-=dmg;
					}
					
				}
				else System.out.println("하치는 행동 불능 상태다.");
			}
			else System.out.println("하치는 쓰러진 상태다.");
			
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
			System.out.println("적 1을 선택해 주십시오.");
			System.out.println("1: 비둘기 2: 호랑이 3: 도적 4: 광포한 곰 5: 악몽의 드루이드");
			enemys1=enemyscanner.nextInt();
			if(enemys1==1 || enemys1==2 || enemys1==3 || enemys1==4 || enemys1==5) break;
			else System.out.println("잘못된 입력입니다.");
		}
		
		while(true)
		{
			System.out.println("\n적 2를 선택해 주십시오.");
			System.out.println("1: 비둘기 2: 호랑이 3: 도적 4: 광포한 곰 5: 악몽의 드루이드");
			enemys2=enemyscanner.nextInt();
			if(enemys2==1 || enemys2==2 || enemys2==3 || enemys2==4 || enemys2==5) break;
			else System.out.println("잘못된 입력입니다.");
		}
		
		while(true)
		{
			System.out.println("\n적 3을 선택해 주십시오.");
			System.out.println("1: 비둘기 2: 호랑이 3: 도적 4: 광포한 곰 5: 악몽의 드루이드");
			enemys3=enemyscanner.nextInt();
			if(enemys3==1 || enemys3==2 || enemys3==3 || enemys3==4 || enemys3==5) break;
			else System.out.println("잘못된 입력입니다.");
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
