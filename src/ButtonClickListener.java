
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
        int button = Integer.parseInt(command);
        if(buttons[button].getLabel() == " " && !game.isResult()){
            if(previous.equals("O")){
                buttons[button].setForeground(Color.WHITE);
                buttons[button].setLabel("X");
                previous = "X";
                present = "O";
            }
            else {
                buttons[button].setForeground(Color.BLUE);
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
            status.setBackground(Color.LIGHT_GRAY);
            buttons[9].setLabel("Reset");

        }
        if(clicks==9 && !game.isResult()){
            status.setText("Match Draw");
            status.setBackground(Color.YELLOW);
            buttons[9].setForeground(Color.WHITE);
            buttons[9].setLabel("Play Again");

        }



        if(game.isResult()){
            status.setText(buttons[game.getWinner()].getLabel()+" is the winner !");
            status.setBackground(Color.green);
            buttons[9].setLabel("Play Again");
            buttons[9].setForeground(Color.WHITE);
            clicks = 0;

        }
    }

    public String getPresent() {
        return present;
    }
}
