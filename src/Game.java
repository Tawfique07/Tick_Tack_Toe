import java.awt.*;

public class Game {
    private boolean result;
    private Button[] buttons;
    private int winner;

    Game(Button[] buttons){
        this.buttons = buttons;
        result = false;
    }

    public void start(){
        for(int i=0; i<=2; i+=2){
            String label = buttons[i].getLabel();

            if(i==2){

                if(buttons[i+2].getLabel()==label && buttons[i+4].getLabel()==label && label!=" "){
                    result = true;
                    winner = i;
                    break;
                }
            }

            else{
                if(buttons[i+4].getLabel()==label && buttons[i+8].getLabel()==label && label!=" "){
                    result = true;
                    winner = i;
                    break;
                }
                for(int j=i; j<=i+6; j+=3){
                    label = buttons[j].getLabel();

                    if(buttons[j+1].getLabel()==label && buttons[j+2].getLabel()==label && label!=" "){
                        result = true;
                        winner = j;
                        break;
                    }
                }
                for(int j=i; j<=2; j++){
                    label = buttons[j].getLabel();

                    if(buttons[j+3].getLabel()==label && buttons[j+6].getLabel()==label && label!=" "){
                        result = true;
                        winner = j;
                        break;
                    }
                }
            }

        }
    }
    public void reset(){
        result = false;
        for(int i=0; i<9; i++){
            buttons[i].setLabel(" ");
        }
    }

    public boolean isResult() {
        return result;
    }

    public int getWinner() {
        return winner;
    }
}
