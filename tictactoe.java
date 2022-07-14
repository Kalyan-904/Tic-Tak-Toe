import java.util.*;
import java.io.*;

class tictactoe{
	//Hash set for user
	static HashSet<Integer> ur_set = new HashSet<>();
	//Hash set for computer
	static HashSet<Integer> comp_set = new HashSet<>();
	//Driver code
	public static void main(String args[]){
		// output 
		char[][] g_board = {
			{' ','|',' ','|',' '},
			{'-','|','-','|','-'},
			{' ','|',' ','|',' '},
			{'-','|','-','|','-'},
			{' ','|',' ','|',' '},
		};
		print_board(g_board);
		
		Scanner sc = new Scanner(System.in);
		
		while(true){
			System.out.print("Enter any number from 1 to 9: ");
			int user_pos = sc.nextInt();
			
			while(ur_set.contains(user_pos) || comp_set.contains(user_pos)){
				System.out.println();
				System.out.println("Postion already taken,Try again");
				System.out.println("Enter any number from 1 to 9");
				user_pos = sc.nextInt();
			}
			place_Holder(g_board,user_pos,"YOU");
			
			String res = check_Winner();
			if(res.length()>0){
				System.out.println(res);
				break;
			}
			
			int comp_pos = gen_random();
			
			while(ur_set.contains(comp_pos) || comp_set.contains(comp_pos)){
				comp_pos = gen_random();
			}
			place_Holder(g_board,comp_pos,"COMPUTER");
			
			res = check_Winner();
			if(res.length()>0){
				System.out.println(res);
				break;
			}
		}
	}
	
	static String check_Winner(){
		HashSet<Integer> r1 = new HashSet<>();
		r1.add(1); r1.add(2); r1.add(3);
		HashSet<Integer> r2 = new HashSet<>();
		r2.add(4); r2.add(5); r2.add(6);
		HashSet<Integer> r3 = new HashSet<>();
		r3.add(7); r3.add(8); r3.add(9);
		
		HashSet<Integer> c1 = new HashSet<>();
		c1.add(1); c1.add(4); c1.add(7);
		HashSet<Integer> c2 = new HashSet<>();
		c2.add(2); c2.add(5); c2.add(8);
		HashSet<Integer> c3 = new HashSet<>();
		c1.add(3); c3.add(6); c3.add(9);
		
		HashSet<Integer> d1 = new HashSet<>();
		d1.add(1); d1.add(5); d1.add(9);
		HashSet<Integer> d2 = new HashSet<>();
		d2.add(3); d2.add(5); d2.add(7);

		HashSet<HashSet> set = new HashSet<>();
		set.add(r1);set.add(r2);set.add(r3);
		set.add(c1);set.add(c2);set.add(c3);
		set.add(d1);set.add(d2);
		
		for(HashSet c: set){
			if(ur_set.containsAll(c)){
				return "YOU WON THE GAME";
			}else if(comp_set.containsAll(c)){
				return "COMPUTER WON THE GAME";
			}
		}
		
		if(ur_set.size()+comp_set.size() == 9){
			return "GAME IS DRAW";
		}
		
		return "";
	}
	
	static int gen_random(){
		int max = 9;
		int min = 1;
		
		int range = (max-min)+1;
		
		int res = (int) (Math.random()*range)+ min;
		return res;
	}
	
	static void print_board(char[][] g_board){
		for(int r=0;r<g_board.length;r++){
			for(int c=0;c<g_board[r].length;c++){
				System.out.print(g_board[r][c]);
			}
			System.out.println();
		}
	}
	
	static void place_Holder(char [][]g_board,int pos, String user){
		char ch = 'O';
		
		if(user.equals("YOU")){
			ch = 'X';
			ur_set.add(pos);
		}else if(user.equals("COMPUTER")){
			ch = 'O';
			comp_set.add(pos);
		}
		
		switch(pos){
			case 1:
			g_board[0][0] = ch;
			break;
			case 2:
			g_board[0][2] = ch;
			break;
			case 3:
			g_board[0][4] = ch;
			break;
			case 4:
			g_board[2][0] = ch;
			break;
			case 5:
			g_board[2][2] = ch;
			break;
			case 6:
			g_board[2][4] = ch;
			break;
			case 7:
			g_board[4][0] = ch;
			break;
			case 8:
			g_board[4][2] = ch;
			break;
			case 9:
			g_board[4][4] = ch;
			break;
			
			default:
			System.out.println("Invalid Input");
		}
		print_board(g_board);
	}
}
