package com.zgw;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class wordCount {
	 int countChar = 0;      //数字数    
     int countWord = 0;    //字母数    
     int countLine = 0;    //行数  
     
     int whiteLine = 0;
     int commentLine = 0;
     int normalLine = 0;
     
     boolean comment;
	String result="";
	 String name;//example文件名    
	String name2;//result文件名
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
                 
         
                
                countChar += str.length();//字符个数就是字符长度
                countWord += str.split(",| ").length;//split() 方法用于把一个字符串分割成字符串数组,字符串数组的长度，就是单词个数
                countLine++;//因为是按行读取，所以每次增加一即可计算出行的数目
                
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
    	  result=result+(name+",字符数:"+countChar+"\r\n");
    	  
    	  return countChar;
    	  
      }
      
      public int getword(){
    	  result=result+(name+",单词数:"+countWord+"\r\n");
    	  return countWord;
      }
      
      public int getline(){
    	  result=result+(name+",行数:"+countLine+"\r\n");
    	  return countLine;
      }
      public void getmore(){
    	  result=result+(name+",代码行/空行/注释行:"+normalLine+","+whiteLine+","+commentLine+"\r\n");
    	  
    	
    	  
      }
   
      public void print() throws IOException{
    	  /* 写入Txt文件 */  
    	  File writename;
    	  if(this.name2==null){
    		  writename = new File(".\\result.txt"); // 相对路径，如果没有则要建立一个新的result.txt文件  
    	  }else{
    		  writename=new File(".\\"+name2);
    	  }
    	  
    	
		writename.createNewFile(); // 创建新文件  
          BufferedWriter out = new BufferedWriter(new FileWriter(writename));  
          out.write(result); // \r\n即为换行  
        
          out.flush(); // 把缓存区内容压入文件  
          out.close(); // 最后记得关闭文件 
      }
      public void  setFile(String filename){
    	  
    	  
    	  
    	  name=filename;
      }
}
