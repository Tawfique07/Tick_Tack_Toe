import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonClickListener implements ActionListener {
    private Button[] buttons;
    private String previous = "O";
    private String present = "X";
    private int clicks = 0;
    private Game game;
    private Label status;

    ButtonClickListener(Button[] buttons, Label status ){
        this.buttons = buttons;
        game = new Game(buttons);
        this.status = status;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        System.out.println(command+" button clicked !");
        int button = Integer.parseInt(command);
        if(buttons[button].getLabel() == " " && !game.isResult()){
            if(previous == "O"){
                buttons[button].setLabel("X");
                previous = "X";
                present = "O";
            }
            else {
                buttons[button].setLabel("O");
                previous = "O";
                present = "X";
            }
            status.setText("Put "+present+" in the blank !");
            clicks++;
            game.start();
        }
        if(button == 9){
            game.reset();
            clicks = 0;
            status.setText("Put "+present+" in the blank !");
            buttons[9].setLabel("Reset");
        }
        if(clicks==9 && !game.isResult()){
            status.setText("Match Draw");
            buttons[9].setLabel("Play Again");
        }



        if(game.isResult()){
            status.setText(buttons[game.getWinner()].getLabel()+" is the winner !");
            buttons[9].setLabel("Play Again");
            clicks = 0;
        }
    }

    public String getPresent() {
        return present;
    }
}
