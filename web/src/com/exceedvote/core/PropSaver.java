package com.exceedvote.core;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropSaver {
	public static void main(String[] args){
		Properties write = new Properties();
		write.put("gg", "kk");
		 try
		    {
		      write.store(new FileOutputStream("myproperties.properties"), "my first properties list");
		      System.out.println("Write OK");
		    }
		    catch(FileNotFoundException ex)
		    {
		      System.out.println(ex.getMessage());
		    }
		    catch(IOException ex)
		    {
		      System.out.println(ex.getMessage());
		    }
	}
}
