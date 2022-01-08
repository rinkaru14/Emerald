import java.util.Random;
public class Dice {
	
	Random random=new Random();
	int dice(int x)
	{
		int dmg=0;
		for(int i=0;i<x;i++) dmg+=(random.nextInt(6)+1);
		return dmg;
	}
	boolean crit(int x)
	{
		int critdice=random.nextInt(6)+1;
		if(critdice<=x) return true;
		else return false;
	}
	int atk()
	{
		return random.nextInt(3)+2;
	}
}
