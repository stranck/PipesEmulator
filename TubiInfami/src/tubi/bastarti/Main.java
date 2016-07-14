package tubi.bastarti;

import java.util.Random;
import java.util.Scanner;

import org.fusesource.jansi.Ansi.Color;
import org.fusesource.jansi.AnsiConsole;
import static org.fusesource.jansi.Ansi.*;
import static org.fusesource.jansi.Ansi.Color.*;

public class Main {
	public static boolean[] time;
	public static int[] selection;
	public static int[] solution;
	public static int[] a;
	public static int[] b;
	public static int[] c;
	public static int[] d;
	public static int[] e;
	public static int[] f;
	public static int start;
	public static int end;
	public static int endext;
	public static int[] stat;
	public static Color[] color;
	public static String[] out;
	public static void main(String[] args){
		AnsiConsole.systemInstall();
		Startup.startup();
		Scanner sc = new Scanner(System.in);
		boolean giustopertogliereilwarn = false;
		if(giustopertogliereilwarn) System.out.println(sc);
		boolean sol = false;
		long startTime = System.currentTimeMillis();
		logger("Start at: "+startTime+"\n\nPROGRAMMED BY STRANCK http://bit.ly/SLClink\n\n");
		/*System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(b));
		System.out.println(Arrays.toString(c));
		System.out.println(Arrays.toString(d));
		System.out.println(Arrays.toString(e));
		System.out.println(Arrays.toString(f));*/
		while(true){
			colorTrad();
			System.out.println(ansi().fg(color[0]).a("A: "+selection[0]+out[0]).reset());
			System.out.println(ansi().fg(color[1]).a("B: "+selection[1]+out[1]).reset());
			System.out.println(ansi().fg(color[2]).a("C: "+selection[2]+out[2]).reset());
			System.out.println(ansi().fg(color[3]).a("D: "+selection[3]+out[3]).reset());
			System.out.println(ansi().fg(color[4]).a("E: "+selection[4]+out[4]).reset());
			System.out.println(ansi().fg(color[5]).a("F: "+selection[5]+out[5]).reset());
			//System.out.println(Arrays.toString(stat));
			/*logger("\nA: "+selection[0]+
					"\nB: "+selection[1]+
					"\nC: "+selection[2]+
					"\nD: "+selection[3]+
					"\nE: "+selection[4]+
					"\nF: "+selection[5]);*/
			String in = sc.nextLine();
			//in.equalsIgnoreCase("solution")
			if(in.equalsIgnoreCase("solution")){
				sol = true;
				for(int i=0; i<6; i++){
					selection[i] = solution[i];
					//System.out.println(i+" "+selection[i]+" "+solution[i]);
				}
			}
			try {
				String[] sp = new String[2];
				sp[1] = "ScemoChiLegge";
				sp = in.split("\\s+");
				if(isNumber(sp[1])) if(sp.length<2||toInt(sp[0])==6||Integer.parseInt(sp[1])>2) System.out.println(ansi().fg(RED)
						.a("Invalid format.").reset()); else {
							selection[toInt(sp[0])] = Integer.parseInt(sp[1]);
					} else System.out.println(ansi().fg(RED).a("Invalid format.").reset());
			} catch(java.lang.ArrayIndexOutOfBoundsException e){
				System.out.println(ansi().fg(RED).a("Invalid format.").reset());
			}
			if(airFlow()&&sol==false){
				long estimatedTime = System.currentTimeMillis() - startTime;
				estimatedTime = estimatedTime/1000;
				int hours = (int) estimatedTime / 3600;
			    int remainder = (int) estimatedTime - hours * 3600;
			    int mins = remainder / 60;
			    remainder = remainder - mins * 60;
			    int secs = remainder;
				System.out.println(ansi().fg(YELLOW).a("You win in "+hours+":"+mins+":"+secs+"!"
						+ "\nTHANKS FOR PLAY\nProgrammed by Stranck http://bit.ly/SLClink").reset()); 
				return;
				}
			sol = false;
		}
	}
	public static void colorTrad(){
		for(int i=0; i<6; i++){
			if(stat[i]==0) color[i] = GREEN;
			if(stat[i]==1) color[i] = BLUE;
			//if(stat[i]==2) {color[i] = BLUE; out[i]=" *";}
			if(stat[i]==3) color[i] = WHITE;
		}
	}
	public static boolean airFlow(){
		int start = search(0);
		int s;
		int next = start;
		boolean[] already = new boolean[6];
		for(int i=0; i<6; i++){
			already[i] = false;
			if(stat[i]==1) stat[i] = 3;
		}
		int c = 0;
		while(true){
			c++;
			//System.out.println(Arrays.toString(stat));
			if(already[next]||c==7) return false;
			already[next] = true;
			s = selection[next];
			//System.out.println(out[next]+"   "+endext);
			if(out[next].equals(" *")&&endext==s) return true;
			next = read(next, s);
			if(stat[next]==3) stat[next] = 1;
		}
	}
	public static boolean isNumber(String s){
		try {
			Integer.parseInt(s);
		} catch(NumberFormatException e) {
			return false;
		} catch(NullPointerException e) {
			return false;
		}
		return true;
	}
	public static int read(int v, int i){
		if(v==0) return a[i];
		if(v==1) return b[i];
		if(v==2) return c[i];
		if(v==3) return d[i];
		if(v==4) return e[i];
		if(v==5) return f[i];
		return 0;
	}
	public static int search(int i){
		for(int n=0; n<stat.length; n++){
			if(stat[n]==i) return n;
		}
		return 0;
	}
	public static int toInt(String s){
		if(s.equalsIgnoreCase("a")) return 0;
		if(s.equalsIgnoreCase("b")) return 1;
		if(s.equalsIgnoreCase("c")) return 2;
		if(s.equalsIgnoreCase("d")) return 3;
		if(s.equalsIgnoreCase("e")) return 4;
		if(s.equalsIgnoreCase("f")) return 5;
		return 6;
	}
	public static int random(int i){
		Random generator = new Random();
		return generator.nextInt(i);
	}
	public static void logger(String text) {
		System.out.println(text);
	}
	public static void loggerC(String text) {
		AnsiConsole.systemInstall();
		System.out.print(ansi().fg(RED).a("Test"));
	}
}
