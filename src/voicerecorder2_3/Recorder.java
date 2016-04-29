package voicerecorder2_3;
import javax.sound.sampled.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Recorder implements Runnable {
    int x;
    Thread thread;
    int bufSize;
    int bufferLengthInFrames;
    int bufferLengthInBytes;
    int frameSizeInBytes;
    byte[] data;
    float rate;
    int channels;
    int frameSize;
    int sampleSize;
    boolean bigEndian;
    static AudioInputStream audioInputStream;
    SourceDataLine lineS;
    AudioFormat.Encoding encoding;
    AudioFormat format;
    AudioInputStream playbackInputStream;
    DataLine.Info info;
    TargetDataLine lineT;
    ByteArrayOutputStream out;
    ByteArrayInputStream bais;
    public Recorder()
    {
        bufSize=16384;
        rate = 44100.0f;
        channels = 2;
        frameSize = 4;
        sampleSize = 16;
        bigEndian = true;
        out = new ByteArrayOutputStream();
    }
    public void Capture(int xx)
    {
        x=xx;
        thread=new Thread(this);
        thread.start();
    }
    public void PlayBack(int xx)
    {
        x=xx;
        thread=new Thread(this);
        thread.start();
    }
    public void save(String s)
    {
        if(s.indexOf('.')==-1)
            s+=".wav";
        if(new File(s).exists()&&s.endsWith(".wav"))
        {
            new replace().setVisible(true);
            replace.text(s);
        }
        else
            saver(s);
            
    }
    public static void saver(String name)
    {
        File fileOut=new File(name);
        try {
            AudioSystem.write(audioInputStream, AudioFileFormat.Type.WAVE, fileOut);
        } catch (IOException ex) {
            Logger.getLogger(Recorder.class.getName()).log(Level.SEVERE, null, ex);
        }
        Base.saved=true;
    }
    public void abort()
    {
        thread=null;
    }
    public void reset()throws Exception
    {
        thread=null;
        out=null;
        audioInputStream.close();
        bais.close();
    }
    @Override
    public void run() {
        if(x==0)
        {
            try {
                encoding = AudioFormat.Encoding.PCM_SIGNED;
                format = new AudioFormat(encoding, rate, sampleSize, channels, (sampleSize / 8)* channels, rate, bigEndian);
                info = new DataLine.Info(TargetDataLine.class, format);
                lineT =  (TargetDataLine) AudioSystem.getLine(info);
                lineT.open(format, lineT.getBufferSize());
                frameSizeInBytes = format.getFrameSize();
                bufferLengthInFrames = lineT.getBufferSize() / 8;
                bufferLengthInBytes = bufferLengthInFrames * frameSizeInBytes;
                data = new byte[bufferLengthInBytes];
                lineT.start();
                int numBytesRead;
                while (thread!=null) 
                {
                    if ((numBytesRead = lineT.read(data, 0, bufferLengthInBytes)) == -1)
                        break;
                    out.write(data, 0, numBytesRead);
                }
                lineT.stop();
                lineT.close();
                lineT = null;
                out.flush();
                out.close();
                byte audioBytes[] = out.toByteArray();
                bais = new ByteArrayInputStream(audioBytes);
                audioInputStream = new AudioInputStream(bais, format, audioBytes.length / frameSizeInBytes);
                audioInputStream.reset();
            } catch (Exception ex) {
                Logger.getLogger(Base.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(x==2)
        {
            try {
                    audioInputStream.reset();
                    encoding = AudioFormat.Encoding.PCM_SIGNED;
                    format = new AudioFormat(encoding, rate, sampleSize, channels, (sampleSize / 8) * channels, rate, bigEndian);
                    playbackInputStream = AudioSystem.getAudioInputStream(format, audioInputStream);
                    info = new DataLine.Info(SourceDataLine.class, format);
                    lineS = (SourceDataLine) AudioSystem.getLine(info);
                    lineS.open(format, bufSize);
                    frameSizeInBytes = format.getFrameSize();
                    bufferLengthInFrames = lineS.getBufferSize() / 8;
                    bufferLengthInBytes = bufferLengthInFrames * frameSizeInBytes;
                    data = new byte[bufferLengthInBytes];
                    lineS.start();
                    int numBytesRead=0;
                    while (thread!=null) 
                    {
                        if ((numBytesRead = playbackInputStream.read(data)) == -1)
                            break;
                        int numBytesRemaining = numBytesRead;
                        while (numBytesRemaining > 0) 
                            numBytesRemaining -= lineS.write(data, 0, numBytesRemaining);
                    }
                    Base.c=2;
                    Base.tim.stop();
                    Base.hit.setText("Play");
                    
            } catch (Exception ex) {
                Logger.getLogger(Recorder.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}