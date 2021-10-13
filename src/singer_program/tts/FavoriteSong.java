package singer_program.tts;

/**
 *
 * @author MINEJHAZZ(Aka. Jhazzmear John B. Saytas)
 * 
 */

//Prerequisites - FreeTTS
import java.util.Scanner;
import com.sun.speech.freetts.*;
import java.util.ArrayList;
//import java.util.concurrent.TimeUnit;

public class FavoriteSong{  
    
    //Line Breaks
    static void FN(){
    System.out.print("\n\n\n\n");
    }

    static void TN(){
    System.out.println("\n");
    }

    static void SN(){
    System.out.print("\n");
    }
    
    
    //Test-To-Speach API Implementation
    static void Say(String VT){
        String VoiceN = "kevin16";
        System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
        
            Voice vb = VoiceManager.getInstance().getVoice(VoiceN);
            if (vb != null) {
                vb.allocate();// Allocating Voice
                try {
            
                    vb.setRate(120);// Setting the rate of the voice box
                    vb.setPitch(150);// Setting the Pitch of the voice box
            
                    vb.speak(VT);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                throw new IllegalStateException("Cannot initialize voice: " + VoiceN);
            }
        }
    
public static void main(String args[]){  
    //Variables
    ArrayList<String> CH = new ArrayList<>()/*, CH2 = new ArrayList<String>()*/;
    int wc;
    boolean c = true;
    String VoiceT = "";
    Scanner s = new Scanner(System.in);
    
    
    System.out.print("Enter the text you wish to make the TTS Say(Type \"TTSDone\" when finished): ");
    
    //Multi line Scanner Input
    while(c){
        VoiceT = s.nextLine();
        if(VoiceT.equalsIgnoreCase("TTSDone")){
            c = false;
        } else {
            try{
            if(VoiceT.substring(VoiceT.length() - 1).equals(" ")){
                CH.add(VoiceT);
            } else {
                CH.add(VoiceT+" ");
            }
            } catch (Exception e){
                CH.add(VoiceT);
            }
        }
    }
    for(int i = 0;i < CH.size();i++){
    if(i == 0){
        VoiceT = CH.get(i);
    } else {
        VoiceT = VoiceT + CH.get(i);
    }
  }
    
    
    //Text Splitter per 4 words
    String[] SS = VoiceT.split(" ");
    wc = SS.length;
    VoiceT = "";
    //Debug
    //System.out.println(wc);
    for(int i = 0, x = 0;i < wc;i++,x++){
        if(i == 0){
            VoiceT = SS[i];
        } else {
            if(x < 4){
                VoiceT = VoiceT + " " + SS[i];
            } else {
                VoiceT = VoiceT + "\n" + SS[i];
                x = 0;
            }
        }
  }
    
    
    //Print Input
    System.out.print(VoiceT);
    
    //Activate TTS
    Say(VoiceT);
    
    
    /*
    //Text Display - With delays - Cancelled Experiment(Multi Threading Needed)
    String[] SS = VoiceT.split(" ");
    wc = SS.length;
    VoiceT = "";
    
    //Debug
    //System.out.println(wc);
    
    for(int i = 0, x = 0, y;i < wc;i++,x++){
        y = i;
        if(i == 0){
            VoiceT = SS[i];
        } else {
            if(x < 4){
                VoiceT = VoiceT + " " + SS[i];
            } else {
                System.out.print(VoiceT);
                VoiceT = VoiceT + "\n" + SS[i];
                x = 0;
            }
        }
  }
*/
    //Say("Ha shi re So ri Yo \n Pa do ru Pa do ru ooooooo");// Calling speak() method
}  
}  
