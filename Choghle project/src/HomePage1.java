

import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;


public class HomePage1 extends MIDlet implements CommandListener{
    Display dis;
    Form f1,f2,f3,f4,f5;
    Ticker tkr1,tkr2;
    StringItem str1,str2;
    Command mMenu,mLogin,mRegister,mExit,mBack,nBack,mGo,mSubmit,mReset,mCancel,aSubmit,aCancel,aReset,aBack,aLogout;
    TextField mEid,nEid,mpw,mFN,mLN,mG,aFullN,aCno;

    ChoiceGroup cg1,cg2;
    DateField DT,mDOB;
    Alert mA,nA;
    Image MHC;
    ImageItem I1;



    public HomePage1(){
        try{
            MHC=Image.createImage("/MHC.png");
        }
        catch(Exception e){
        }
 I1  = new ImageItem("", MHC, ImageItem.LAYOUT_CENTER, null);


        f1=new Form("M-HealthCareSystem");

         tkr1=new Ticker("WELCOME TO M-HCS");
         mExit=new Command("Exit", Command.EXIT, 0);
         mMenu=new Command("Menu", Command.SCREEN, 1);
         mLogin=new Command("Login", Command.SCREEN, 2);
         mRegister=new Command("Register", Command.SCREEN, 3);

         f1.append(I1);
         f1.setTicker(tkr1);
         f1.addCommand(mExit);
         f1.addCommand(mMenu);
         f1.addCommand(mLogin);
         f1.addCommand(mRegister);
         f1.setCommandListener(this);

         f2=new Form("LoginForm");

         mEid=new TextField("EmailID",null, 10, TextField.EMAILADDR);
         mpw=new TextField("Password",null, 10, TextField.PASSWORD);
         mGo=new Command("Go", Command.SCREEN, 0);
         mReset=new Command("Reset", Command.SCREEN, 1);
         mBack=new Command("Back", Command.BACK, 3);
         nBack=new Command("BACK", Command.SCREEN, 4);
         f2.append(mEid);
         f2.append(mpw);
         f2.addCommand(mGo);
         f2.addCommand(mReset);
         f2.addCommand(nBack);
         f2.setCommandListener(this);



        f3=new Form("Registration");

        mFN=new TextField("FirstName", "", 20, TextField.ANY);
        mLN=new TextField("LastName", "", 20, TextField.ANY);
        mDOB=new DateField("DOB", DateField.DATE);
        nEid= new TextField("EmailID", "", 10, TextField.EMAILADDR);
        mSubmit=new Command("Submit", Command.SCREEN, 1);
        mCancel=new Command("Cancle", Command.CANCEL, 0);
        mBack=new Command("Back", Command.BACK, 2);
        f3.append(mFN);
        f3.append(mLN);
        f3.append(mDOB);
        f3.append(nEid);
        f3.addCommand(mSubmit);
        f3.addCommand(mCancel);
        f3.addCommand(mBack);
        f3.setCommandListener(this);

         f4=new Form("Appointment");

         tkr2=new Ticker("Book Your Appointment");
         cg1=new ChoiceGroup("Select Speciality", ChoiceGroup.POPUP);
         cg1.append("Dental", null);
         cg1.append("Dematology(skin)", null);
         cg1.append("Endocrinology(Diabetes)", null);
         cg1.append("Hematology(Boold)", null);
         cg1.append("Orthopaedic(Bone)", null);
         cg1.append("Pediatric Cardiology(Heart)", null);
         cg1.append("Hair Transplant^n", null);
         aSubmit=new Command("Submit", Command.SCREEN, 0);
         aReset=new Command("Reset", Command.SCREEN, 1);
         aCancel=new Command("Cancel", Command.CANCEL, 2);
         aBack=new Command("Back", Command.BACK, 3);
         DT=new DateField("Seclet Date & Time", DT.DATE_TIME);
         str1=new StringItem("Patient Info", null);
         aFullN=new TextField("FullName", null, 20, TextField.ANY);
         cg2=new ChoiceGroup("Gender", ChoiceGroup.EXCLUSIVE);
         cg2.append("Male", null);
         cg2.append("Female", null);
         aCno=new TextField("Contact no", null, 10, TextField.PHONENUMBER);



         f4.setTicker(tkr2);
         f4.append(cg1);
         f4.append(DT);
         f4.append(str1);
         f4.append(aFullN);
         f4.append(cg2);
         f4.append(aCno);

         f4.addCommand(aSubmit);
         f4.addCommand(aReset);
         f4.addCommand(aCancel);
         f4.addCommand(aBack);
         f4.setCommandListener(this);


         f5=new Form("Thank You");
         str2=new StringItem("You Have booked Appointment Succesfully ", null);
         aLogout=new Command("Logout", Command.SCREEN, 0);

         f5.append(str2);
         f5.addCommand(aLogout);
         f5.setCommandListener(this);



    }

    public void startApp() {
        dis=Display.getDisplay(this);
        dis.setCurrent(f1);





    }

    public void pauseApp() {
    }

    public void destroyApp(boolean unconditional) {
        notifyDestroyed();
    }

    public void commandAction(Command c, Displayable d) {
        if(c==mExit){
            notifyDestroyed();
        }
 else
     if(c==mBack){
        dis.setCurrent(f1);
            }
 else
     if(c==nBack)
     {
         dis.setCurrent(f1);
     }


 else
     if(c==mLogin){
         dis.setCurrent(f2);
     }
 else
     {
     if(c==mGo)
     {
         if(mEid.getString().equals("") && mpw.getString().equals(""))
         {
         nA=new Alert("", "Fill all the space", null, AlertType.WARNING);
         nA.setTimeout(1000);
         dis.setCurrent(nA,f2 );

         }
 else
 {
        mA=new Alert("", "Login Successful", null, AlertType.INFO);
         mA.setTimeout(1000);
         dis.setCurrent(mA,f4 );
         }
 }
     }

     if(c==mSubmit){

         if(mFN.getString().equals("") && mLN.getString().equals("") && nEid.getString().equals(""))
         {
         nA=new Alert("", "Fill all the space", null, AlertType.WARNING);
         nA.setTimeout(1000);
         dis.setCurrent(nA,f3 );

         }
         else{
         mA=new Alert("", "Successful", null, AlertType.INFO);
         mA.setTimeout(1000);
         dis.setCurrent(mA, f2);
     }
     }
 else
     if(c==mReset){
       mEid.setString("");
       mpw.setString("");

     }
 else
     if(c==mRegister){
         dis.setCurrent(f3);
     }

 else
     if(c==aLogout)
             {
             dis.setCurrent(f1);
             }
 else {
     if(c==aSubmit)
     {
     String a=cg1.getString(cg1.getSelectedIndex());

     String e=aFullN.getString();
     String f=aCno.getString();
     String g=mEid.getString();
     f5.append(a);
     f5.append(DT);
     f5.append(e);
     f5.append(f);
     f5.append(g);



         dis.setCurrent(f5);
                   }
     else
         if(c==aReset)
         {

         }
     else
             if(c==aCancel)
             {
          mA=new Alert("", "Cancel Appointment", null, AlertType.INFO);
         mA.setTimeout(10000);
         dis.setCurrent(mA, f1);
             }
     else
                 if(c==aBack)
                 {
                 dis.setCurrent(mA, f2);
                 }

        }




}


}
