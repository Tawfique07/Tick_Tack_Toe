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
                    buttons[i].setBackground(Color.green);
                    buttons[i+2].setBackground(Color.green);
                    buttons[i+4].setBackground(Color.green);
                    break;
                }
            }

            else{
                if(buttons[i+4].getLabel()==label && buttons[i+8].getLabel()==label && label!=" "){
                    result = true;
                    winner = i;
                    buttons[i].setBackground(Color.green);
                    buttons[i+4].setBackground(Color.green);
                    buttons[i+8].setBackground(Color.green);
                    break;
                }
                for(int j=i; j<=i+6; j+=3){
                    label = buttons[j].getLabel();

                    if(buttons[j+1].getLabel()==label && buttons[j+2].getLabel()==label && label!=" "){
                        result = true;
                        winner = j;
                        buttons[j].setBackground(Color.green);
                        buttons[j+1].setBackground(Color.green);
                        buttons[j+2].setBackground(Color.green);
                        break;
                    }
                }
                for(int j=i; j<=2; j++){
                    label = buttons[j].getLabel();

                    if(buttons[j+3].getLabel()==label && buttons[j+6].getLabel()==label && label!=" "){
                        result = true;
                        winner = j;
                        buttons[j].setBackground(Color.green);
                        buttons[j+3].setBackground(Color.green);
                        buttons[j+6].setBackground(Color.green);
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
            buttons[i].setBackground(Color.GRAY);
        }
        buttons[9].setForeground(Color.cyan);
    }

    public boolean isResult() {
        return result;
    }

    public int getWinner() {
        return winner;
    }
}
