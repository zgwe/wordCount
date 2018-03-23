package com.zgw;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Test {
	
	
	public static void main(String[] args) throws FileNotFoundException{
		ArrayList<String> argR = new ArrayList(2);
		ArrayList<String> argR2 = new ArrayList();
		ArrayList<String> stopList=new ArrayList();
		
	
		
		for(int i=0;i<args.length;i++){
			if(args[i].charAt(0)=='-'){
				char arg = args[i].charAt(1);
				switch(arg){
					case 'c':
					case 'w':
					case 'l':
					case 'a':
						argR2.add(String.valueOf(arg));
						break;
					case 'o':
						if(i+1>args.length)
							System.out.println("need a file");
						else argR2.add(String.valueOf(arg));
					}
				}
			else {
				
				argR.add(args[i]);
			}
			
		}
		//·ÀÖ¹argR¡£2Îª¿Õ
				if(argR.size()==1){
					argR.add(null);
				}
		wordCount a=new wordCount(argR.get(0),argR.get(1));
		
		
		if(argR2.contains("c")){
			//do c
			
			a.getchar();
		}
		
		if(argR2.contains("w")){
			//do w
			
			a.getword();
		}
		
		if(argR2.contains("l")){
			//do l
			a.getline();
		}
		if(argR2.contains("a")){
			//do a
			a.getmore();
		}
		if(argR2.contains("o")){
			//do o
			
				try {
					a.print();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			
		}
		
		
	
		
	}
}
