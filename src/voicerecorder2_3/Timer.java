package voicerecorder2_3;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Timer implements Runnable {
    Calendar cal=Calendar.getInstance();
    int s,m,h,f,b,ms;
    Thread ob;
    public Timer()
    {
        ob=new Thread(this);
        s=0;m=0;h=0;f=0;b=0;ms=1;
    }
    public void start()
    {
        ob.start();
    }
    @Override
    public void run() {
        while(ob!=null){
            try {
                Thread.sleep(999);
            } catch (InterruptedException ex) {
                Logger.getLogger(Timer.class.getName()).log(Level.SEVERE, null, ex);
            }
        if(s>58)
        {
            ++m;
            s=-1;
        }
        if(m>58)
        {
            ++h;
            m=-1;
        }
        
        Base.ss.setText(String.valueOf(++s));
        Base.mm.setText(String.valueOf(m));
        Base.hh.setText(String.valueOf(h));}
        if(Base.c==2)
        {
            Base.hh.setText("0");
            Base.mm.setText("0");
            Base.ss.setText("0");
        }
    }
    public void stop()
    {
        ob=null;
        
    }
}