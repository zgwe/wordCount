package com.zgw;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class wordCount {
	 int countChar = 0;      //������    
     int countWord = 0;    //��ĸ��    
     int countLine = 0;    //����  
     
     int whiteLine = 0;
     int commentLine = 0;
     int normalLine = 0;
     
     boolean comment;
	String result="";
	 String name;//example�ļ���    
	String name2;//result�ļ���
	wordCount(String filename,String filename2) throws FileNotFoundException{
		
		init(filename,filename2);
		}
	
	
	public void init(String filename,String filename2) throws FileNotFoundException {  
       
		setFile(filename);
		setFile2(filename2);
     
        try{  
         
            File file=new File(name);  
            BufferedReader br= new BufferedReader(new FileReader(file));  
            String str = null;  
              
            while((str=br.readLine())!=null){  
                 
         
                
                countChar += str.length();//�ַ����������ַ�����
                countWord += str.split(",| ").length;//split() �������ڰ�һ���ַ����ָ���ַ�������,�ַ�������ĳ��ȣ����ǵ��ʸ���
                countLine++;//��Ϊ�ǰ��ж�ȡ������ÿ������һ���ɼ�����е���Ŀ
                
                str = str.trim();   
                
                if (str.matches("\\s*.?\\s*")) {   
                    whiteLine++;   
                } else if (str.startsWith("/*") && !str.endsWith("*/")) {   
                    commentLine++;   
                    comment = true;   
                } else if (true == comment) {   
                    commentLine++;   
                    if (str.endsWith("*/")) {   
                        comment = false;   
                    }   
                } else if (str.startsWith("//")) {   
                        commentLine++;   
                } else {   
                    normalLine++;   
                }   
                
            }  
            
           
          
        }catch(Exception e){  
            e.printStackTrace();  
        }  
        
         
    }  
      private void setFile2(String filename2) {
		// TODO Auto-generated method stub
		name2=filename2;
	}


	public int getchar(){
    	  result=result+(name+",�ַ���:"+countChar+"\r\n");
    	  
    	  return countChar;
    	  
      }
      
      public int getword(){
    	  result=result+(name+",������:"+countWord+"\r\n");
    	  return countWord;
      }
      
      public int getline(){
    	  result=result+(name+",����:"+countLine+"\r\n");
    	  return countLine;
      }
      public void getmore(){
    	  result=result+(name+",������/����/ע����:"+normalLine+","+whiteLine+","+commentLine+"\r\n");
    	  
    	
    	  
      }
   
      public void print() throws IOException{
    	  /* д��Txt�ļ� */  
    	  File writename;
    	  if(this.name2==null){
    		  writename = new File(".\\result.txt"); // ���·�������û����Ҫ����һ���µ�result.txt�ļ�  
    	  }else{
    		  writename=new File(".\\"+name2);
    	  }
    	  
    	
		writename.createNewFile(); // �������ļ�  
          BufferedWriter out = new BufferedWriter(new FileWriter(writename));  
          out.write(result); // \r\n��Ϊ����  
        
          out.flush(); // �ѻ���������ѹ���ļ�  
          out.close(); // ���ǵùر��ļ� 
      }
      public void  setFile(String filename){
    	  
    	  
    	  
    	  name=filename;
      }
}
