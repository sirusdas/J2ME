/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mobileproject1;



/**
 * @author sirus
 */

import java.io.IOException;
import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;


public class wilfred extends MIDlet implements CommandListener{

    Display myDisplay;
    Form f1[];
    Image im1[];
ImageItem i1[];
Ticker tkr1;
    Command exit,c11,c21,c22,c31,c32,back;
String s;
StringItem name[],size[],date[],loc[];
int XxX=0;

public wilfred()
    {
        tkr1=new Ticker("W E L C O M E__TO__P H O T O__G A L L E R Y");
f1 = new Form[6];
im1=new Image[6];
i1=new ImageItem[6];

name=new StringItem[6];
date=new StringItem[6];
size=new StringItem[6];
loc=new StringItem[6];

name[0]=new StringItem("NAME: ","Rainbow apple");
name[1]=new StringItem("NAME: ","ninja Boy");
name[2]=new StringItem("NAME: ","Wallpaper");
name[3]=new StringItem("NAME: ","Wallpaper");
name[4]=new StringItem("NAME: ","Smile Face");
name[5]=new StringItem("NAME: ","Water Drop Face");

date[0]=new StringItem("DATE: ","1/2/2014");
date[1]=new StringItem("DATE: ","13/3/2014");
date[2]=new StringItem("DATE: ","26/4/2013");
date[3]=new StringItem("DATE: ","19/1/2012");
date[4]=new StringItem("DATE: ","7/8/2006");
date[5]=new StringItem("DATE: ","12/4/2001");

size[0]=new StringItem("SIZE: ","20kb");
size[1]=new StringItem("SIZE: ","30kb");
size[2]=new StringItem("SIZE: ","40kb");
size[3]=new StringItem("SIZE: ","10kb");
size[4]=new StringItem("SIZE: ","15kb");
size[5]=new StringItem("SIZE: ","21kb");

loc[0]=new StringItem("LOCATION: ","sdcard:/pictures");
loc[1]=new StringItem("LOCATION: ","sdcard:/Received files");
loc[2]=new StringItem("LOCATION: ","sdcard:/images");
loc[3]=new StringItem("LOCATION: ","sdcard:/pics");
loc[4]=new StringItem("LOCATION: ","sdcard:/movie");
loc[5]=new StringItem("LOCATION: ","sdcard:/music");



c11=new Command("NEXT",Command.SCREEN,1);
exit=new Command("EXIT",Command.EXIT,0);
back=new Command("BACK",Command.SCREEN,1);
try {
 for(int i=0;i<6;i++)
 {
      s="/"+i+".png";
      System.out.println("path="+s);
    im1[i]=Image.createImage(s);
    i1[i]=new ImageItem("",im1[i],ImageItem.LAYOUT_LEFT,null);
    f1[i]=new Form("");
    f1[i].append(i1[i]);
    f1[i].append(name[i]);
     f1[i].append(date[i]);
      f1[i].append(size[i]);
       f1[i].append(loc[i]);
    f1[i].setTicker(tkr1);
    f1[i].addCommand(c11);
    f1[i].addCommand(exit);
    f1[i].addCommand(back);
    f1[i].setCommandListener(this);
 }
        } catch (Exception ex)
        {
            System.out.println("E R R O R = "+ex);
        }


    }

public void startApp() {

myDisplay = Display.getDisplay(this);

myDisplay.setCurrent(f1[XxX]);



    }
public void pauseApp() {
    }

public void destroyApp(boolean unconditional) {
    }

public void commandAction(Command c, Displayable dsplbl) {
if(c==c11)
        {
            XxX++;
            System.out.println("XxX="+XxX);
            if(XxX<6)
            {
myDisplay.setCurrent(f1[XxX]);
            }
            else
            {
                XxX--;
            }
        }

else if(c==exit)
        {
notifyDestroyed();
 }

if(c==back)
{
    XxX--;
    if(XxX>=0)
    {
    myDisplay.setCurrent(f1[XxX]);
    }
    else
    {
        XxX++;
    }
}

    }
}
