/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mobileproject1;

import com.sun.midp.lcdui.EventHandler;
import javax.microedition.midlet.*;
import javax.microedition.rms.*;
import javax.microedition.lcdui.*;

/**
 * @author sirus
 */
public class records extends MIDlet implements CommandListener,ItemStateListener {

     Display d;
      RecordStore rs;
        Command save,update,del,retrive,add,addRRecord,go,addMN,back,Mdel;
        TextField tf1,tf2;
         Form f,f2,TASK,MainAddRecord;
         String s,common,common2;
         StringBuffer sb;
         ChoiceGroup cg1,cg2;
         TextField tf3;
         Alert a,b;
            int i,XxX,XxX1,Mac=0;
           
            byte[] byt,byt1;
   public records()
    {
       
    
      tf1=new TextField("NAME: ", null, 15, TextField.ANY);
    tf2=new TextField("PASSWORD: ",null,15,TextField.ANY);
     a=new Alert("SAVED SUCCESSFULLY");
     b=new Alert("DELETED SUCCESSFULLY");
    
///////////////////////////////////////////////////////////////////////////////////////////////////////////    
        f = new Form(null);
        save=new Command("SAVE",Command.SCREEN,0);
       
 ///////////////////////////////////////////////////////////////////////////////////////////////////////////       
        f2=new Form(null);
        retrive =new Command("Retrive",Command.SCREEN,0);
        cg2=new ChoiceGroup("",ChoiceGroup.EXCLUSIVE);
        del=new Command("DELETE",Command.SCREEN,0);
       // edit=new Command("EDIT",Command.SCREEN,0);
        
 //////////////////////////////////////////////////////////////////////////////////////////////////////////       
        TASK=new Form(null);
        add=new Command("ADD RECORD",Command.SCREEN,1);
        go=new Command("GO",Command.SCREEN,0);
       
       cg1=new ChoiceGroup("one",Choice.EXCLUSIVE);
       
        
  /////////////////////////////////////////////////////////////////////////////////////////////////////////      
        MainAddRecord=new Form(null);
        addRRecord=new Command("ADD",Command.SCREEN, 0);
           addMN=new Command("SAVE",Command.SCREEN,1);
           back=new Command("BACK",Command.SCREEN,0);
           tf3=new TextField("NAME","",25,TextField.ANY);
           Mdel=new Command("DELETE",Command.SCREEN,0);
        
       
        
        
  
     f.setCommandListener(this);
     f2.setCommandListener(this);
     TASK.setCommandListener(this);
     MainAddRecord.setCommandListener(this);
     f2.setItemStateListener(this);
     f.setItemStateListener(this);
     TASK.setItemStateListener(this);
     MainAddRecord.setItemStateListener(this);
    }
    
    public void startApp() {
   
       
                     f.append(tf1);
            f.append(tf2);
              f.addCommand(save);
             f.addCommand(retrive);
        
        d=Display.getDisplay(this);
      //  d.setCurrent(TASK);
       
       
       disRecord();
        
    
    }
    
    public void pauseApp() {
    }
    
    public void destroyApp(boolean unconditional) {
    }

    
    public void commandAction(Command c, Displayable d1) {
       /////add the task/////////////////////////////////////////////////
        if(c==save)
        {
              // f.append(tf1);
            //f.append(tf2);
             // f.addCommand(save);
             //f.addCommand(retrive);
            //d.setCurrent(f);
           addRecord();
         
        }
        
       //r e t r i v i n g  the tasks
        
        if(c==retrive)
        {
          
            retriveRecord();    
            
       
        }
        /////////add task/////////////////////////////////////////
        if(c==add)
        {

            d.setCurrent(f);
            
            addRecord();
        }
        ///////add the main record////////////////////////////////
        if(c==addRRecord)
        {
            
            MainAddRecord.append(tf3);
            MainAddRecord.addCommand(addMN);
            MainAddRecord.addCommand(back);
            d.setCurrent(MainAddRecord);
            //addMainRecord();
        }
        ///////Connects to retrive record//////////////////////////////////////////////////
        if(c==go)
        {
           retriveRecord();
        }
        
        if(c==addMN)
        {
           addMainRecord();
          }
        
        if(c==back)
        {
            disRecord();
        }
         
        if(c==Mdel)
        {
            MainDelete();;
        }
        
        if(c==del)
        {
            delete();
        }
        
    }
    
   
        
    
/////////////add the task//////////////////////////////////////////////////
public void addRecord()
{

             s=tf1.getString()+":"+tf2.getString();
            byt=s.getBytes();

     //   f.append(tf1);
      //  f.append(tf2);      
            
            if(tf1.size()!=0&&tf2.size()!=0)
            {
               try
               {
                rs= RecordStore.openRecordStore(cg1.getString(cg1.getSelectedIndex()), true);
               i= rs.addRecord(byt,0,byt.length);
                System.out.println("ADDED with id ="+i); 
                byt=null;
                tf1.setString(null);
                tf2.setString(null);
                rs.closeRecordStore();
                d.setCurrent(a);
                }
            
            catch(RecordStoreException e)
            {
                System.out.println("INTERNAL ERROR HAS OCCURED");  
            } 
           }
}
            

//////////Retrive the task/////////////////////////////////////////////////////

public void retriveRecord()
{
  f2.deleteAll();
  cg2.deleteAll();
    String s2;
     
 /*   if(cg2.getSelectedIndex()=-1)
    {
        
    }*/
    
    int s=1;
     // int index=cg1.getSelectedIndex();
      
        Mfind();
            
             try
            {
               // rs= RecordStore.openRecordStore("ADDREMOVE_CUSTOMER", true);
              rs=RecordStore.openRecordStore(common, true);
               
              //  int row=rs.getNumRecords();
                
               
               // tf3=new TextField[row];
               // x=rs.getRecordSize(4);
                //System.out.println("record size =  "+x);
            
               
                
               while(s<=rs.getSize())
               {
                try
                {
               
                
                byt1=new byte[rs.getRecordSize(s)];
                rs.getRecord(s, byt1,0 );
                 s2=new String(byt1);
                // tf3[s]=new TextField("ADDREMOVE_CUSTOMER"+s, s1, 25,TextField.UNEDITABLE);
               
                  cg2.append(s2, null);
                 
               //  int idx=s1.indexOf(":");
                 //tf1.setString(s1.substring(idx));
                // tf2.setString(s1.substring(idx+1));
                //f2.append(tf3[s]);

                
                 
           System.out.println("Retrive success with id ="+s+" redord size= "+rs.getSize()); 
           Mac=s;
              s++;
                }
                catch(Exception e1)
                {
                    s++;
                }
               }
               
              
                f2.append(cg2);
                f2.addCommand(back);
                f2.addCommand(add);
                
                 f2.addCommand(del);
               //  f2.addCommand(edit);
                  d.setCurrent(f2);
                  check();

            }
 catch(RecordStoreException e1)
            {
                System.out.println("INTERNAL ERROR HAS OCCURED while retriving "+e1);  
            }
    
}

//////////////Display main record/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

public void disRecord()
{
  
    
    
    
     TASK.deleteAll();
     cg1.deleteAll();
      String disRS[]=RecordStore.listRecordStores();
      
    //String s1;
        int s=0;
       
            
             try
            {
                //rs= RecordStore.openRecordStore("ADDREMOVE_CUSTOMER", true);
               
                int row=disRS.length;              
               // tf3=new TextField[row];
               // x=rs.getRecordSize(4);
                System.out.println("record size =  "+row);
            
                //d.setCurrent(TASK);
                
               for(s=0;s<=row-1;s++)
               {
                try
                {
                cg1.append(disRS[s], null);              
                
                 /*tf3[s]=new TextField(""+s+1, disRS[s], 25,TextField.UNEDITABLE);
               
                TASK.append(tf3[s]); */
                                                            
           System.out.println("RECORD DISPLAYED success with id ="+s); 
                }
                catch(Exception e)
                {
                    s++;
                }
            
               }        
                TASK.append(cg1);
                 TASK.addCommand(go);
                TASK.addCommand(addRRecord);
                TASK.addCommand(Mdel);
                d.setCurrent(TASK);
                Mcheck();
               
                
//rs.closeRecordStore();
            }
 catch(Exception e)
            {
                System.out.println("INTERNAL ERROR HAS OCCURED while retriving "+e);  
            }

}

public void addMainRecord()
{

              try
           {
                if(tf3.size()!=0)
                 {
                  RecordStore.openRecordStore(tf3.getString(), true);     
                  d.setCurrent(a);
                }
             }
             catch(Exception e)
               {
                  System.out.println("INTERNAL ERROR HAS OCCURED while retriving "+e);    
                    }   
}



public void MainDelete()
{
   //int index=cg1.getSelectedIndex();
   //String s=cg1.getString(index);
   Mfind();
    try
   {
   RecordStore.deleteRecordStore(common);
   d.setCurrent(b);
    System.out.println("Record deleted with id= "+XxX1);
    disRecord();
   }
   catch(Exception e)
   {
       System.out.println("E R R O R"+e);
   }
      
 
}

public void delete()
{
    find();
   try
   {    
   // rs=RecordStore.openRecordStore(common, true);
    rs.deleteRecord(XxX);
    d.setCurrent(b);
    System.out.println("Record deleted with id= "+XxX);
    retriveRecord();
   }
   catch(Exception e1)
   {
       System.out.println("E R R O R"+e1);
   }
      
}

public void find()
{
  int e=1;
    String s1;
   byte byt2[];
   try
   {
    
       //rs=RecordStore.openRecordStore(common, true);    
       
       System.out.println("Records present= "+Mac);
       while(Mac>=e)
       {
           try
           {
                       byt2=new byte[rs.getRecordSize(e)];
                rs.getRecord(e, byt2,0 );
                 s1=new String(byt2);
        if(s1.equals(common2))
        {
           XxX=e; 
            System.out.println("XxX= "+XxX);
        }
        e++;
           }
           catch(Exception e1)
           {
               e++;
           }
       }
   }
   catch(Exception e1)
   {
       System.out.println("E R R O R in searching in Find "+e1);
   }  
}

public void Mfind()
{
      int e=0;//,x=1;
    String s1[];
  // byte byt2[];
   try
   {
       //rs=RecordStore.openRecordStore(cg1.getString(cg1.getSelectedIndex()), true);    
        s1=RecordStore.listRecordStores();
        
        int timepass=RecordStore.listRecordStores().length;
        System.out.println("Record Store lenght"+timepass);
       while(e<timepass)
       {
          try
          {
        if(s1[e].equals(common))
        {
           XxX1=e; 
          
            System.out.println("XxX1= "+XxX1);
        }
        e++;
       }
       
       catch(Exception e1)
       {
         e++;
       }
       }
     //rs=RecordStore.openRecordStore(cg1.getString(XxX1), true);
   }
   catch(Exception e1)
   {
       System.out.println("E R R O R in searching in Mfind "+e1);
   }
}
//add function in Record field

public void Mcheck()
{
  int c=0,c1=0;
            while(c<25)
            {
            try{
    String x=cg1.getString(c);
               
    c1=c;
     System.out.println("Checking starting id "+c1);
     c=25;
    }
    catch(Exception e){c++;}
            }
        common=cg1.getString(c1);
    
}

public void check()
{
 int c=0,c1=0;
            while(c<25)
            {
            try{
    String x=cg2.getString(c);
               
    c1=c;
     System.out.println("Checking starting id "+c1);
     c=25;
    }
    catch(Exception e){c++;}
            }
        common2=cg2.getString(c1);   
}




public void itemStateChanged(Item item) {
    if(cg1.getSelectedIndex()!=-1)
    {
    common=cg1.getString(cg1.getSelectedIndex());
    }
    else
    {
           
    }
   if(cg2.getSelectedIndex()!=-1)
   {
       common2=cg2.getString(cg2.getSelectedIndex());
   }
    System.out.println("Common= "+common+" common2= "+common2);
    /* 
    boolean pics[]=new boolean[cg2.size()];
        
        if(cg2.getSelectedFlags(pics)<1)
        {
            f2.removeCommand(del);
            f2.removeCommand(edit);
        }
        if(cg2.getSelectedFlags(pics)==1)
        {
            f2.removeCommand(del);
            f2.addCommand(edit);
        }
        if(cg2.getSelectedFlags(pics)>1)
        {
            if(cg2.getSelectedFlags(pics)==2)
            {
            f2.removeCommand(edit);
            }
            f2.addCommand(del);
            System.out.println("I am in else of Flags");
        }
   
           */  
             }
    
}
