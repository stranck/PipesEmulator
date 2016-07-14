package tubi.bastarti;

import org.fusesource.jansi.Ansi.Color;
import static org.fusesource.jansi.Ansi.Color.*;

public class Startup {
	public static void startup(){
		Main.logger("Starting up...\nSetting up arrays.");
		Main.selection = new int[6];
		Main.time = new boolean[6];
		Main.solution = new int[6];
		Main.stat = new int[6];
		Main.color = new Color[6];
		Main.out = new String[6];
		Main.a = new int[3];
		Main.b = new int[3];
		Main.c = new int[3];
		Main.d = new int[3];
		Main.e = new int[3];
		Main.f = new int[3];
		Main.logger("Presetting");
		preset();
		Main.logger("Creating a solution");
		solution();
		Main.logger("Choosing other pipes");
		for(int i=0;i<6;i++){
			for(int n=0;n<3;n++){
				if(i==0&&Main.a[n]==8) Main.a[n] = testEq(i);
				if(i==1&&Main.b[n]==8) Main.b[n] = testEq(i);
				if(i==2&&Main.c[n]==8) Main.c[n] = testEq(i);
				if(i==3&&Main.d[n]==8) Main.d[n] = testEq(i);
				if(i==4&&Main.e[n]==8) Main.e[n] = testEq(i);
				if(i==5&&Main.f[n]==8) Main.f[n] = testEq(i);
			}
		}
	}
	public static void solution(){
		//boolean done = true;
		Main.start = Main.random(6);
		int last = Main.start;
		int i = 0;
		Main.stat[last] = 0;
		Main.logger("Entering in solution loop");
		while(true){
			i++;
			//System.out.println(last+" "+i);
			if(i==6){
				Main.end = last;
				Main.out[last] = " *";
				Main.endext = Main.random(3);
				return;
			}
			
			int r = solapp(last);
			int id = Main.random(3);
			//System.out.println(id);
			sinapp(last, id, r);
			Main.time[last] = true;
			Main.solution[last] = id;
			//System.out.println(id + " "+last);
			//System.out.println(Arrays.toString(Main.solution));
			last = r;
		}
	}
	public static void sinapp(int s, int i, int v){
		//System.out.println(s+" "+i+" "+v);
		if(s==0) Main.a[i] = v;
		if(s==1) Main.b[i] = v;
		if(s==2) Main.c[i] = v;
		if(s==3) Main.d[i] = v;
		if(s==4) Main.e[i] = v;
		if(s==5) Main.f[i] = v;
	}
	public static int testEq(int i){
		int random;
		while(true) {
			random = Main.random(6);
			if(random!=i) return random;
		}
	}
	public static int solapp(int i){
		int rand;
		Main.logger("Solapping");
		while(true){
			rand = Main.random(6);
			//System.out.println(rand +" "+i+" "+Main.time[rand]);
			//System.out.println(Arrays.toString(Main.time));
			if(rand!=i&&Main.time[rand]==false) {/*System.out.println("ret");*/ return rand;}
			if(allOcc()) return 8;
		}
	}
	public static boolean allOcc(){
		for(int i=0; i<Main.time.length; i++){
			if(Main.time[i]==false) return false;
		}
		return true;
	}
	public static void preset(){
		//713231
		for(int i=0; i<Main.selection.length; i++){
			Main.selection[i] = 0;
		}
		for(int i=0; i<Main.time.length; i++){
			Main.time[i] = false;
			Main.color[i] = WHITE;
			Main.stat[i] = 3;
			Main.out[i] = "";
		}
		for(int i=0; i<3; i++){
			Main.a[i] = 8;
			Main.b[i] = 8;
			Main.c[i] = 8;
			Main.d[i] = 8;
			Main.e[i] = 8;
			Main.f[i] = 8;
		}
	}
}
