
import java.awt.*;

public class TickTack {
    private Frame mainFrame;
    private Label status;
    private Button[] buttons =new Button[10];
    private Panel[] panels =new Panel[4];

    TickTack(){
        GUI();

    }

    public static void main(String[] args) {
        TickTack tickTack = new TickTack();
    }

    private void GUI(){

        mainFrame = new Frame("Tick Tack Toe");
        mainFrame.setSize(400,500);
        mainFrame.setLayout(new GridLayout(4,1,2,2));
        mainFrame.setVisible(true);
        mainFrame.addWindowListener(new WindowEventListener());

        Font font = new Font("Courier",Font.BOLD,48);


        status = new Label();
        ButtonClickListener buttonClickListener = new ButtonClickListener(buttons,status);
        status.setText("Put "+buttonClickListener.getPresent()+" in the blank !");

       Font font1 = new Font("Courier",Font.BOLD,20);

        status.setFocusable(true);
        status.setAlignment(1);
        status.setBackground(Color.LIGHT_GRAY);
        status.setFont(font1);


        for(int j=0; j<3; j++){
            panels[j] = new Panel(new GridLayout(1,3,2,3));
            panels[j].setVisible(true);
            for(int i=3*j; i<(j*3)+3; i++){
                buttons[i] = new Button(" ");
                buttons[i].setActionCommand(Integer.toString(i));
                buttons[i].addActionListener(buttonClickListener);
                buttons[i].setBackground(Color.GRAY);
                buttons[i].setFont(font);
                panels[j].add(buttons[i]);
            }
            mainFrame.add(panels[j]);
        }

        buttons[9]= new Button("Reset");
        buttons[9].setActionCommand("9");
        buttons[9].addActionListener(buttonClickListener);
        buttons[9].setFont(font1);
        buttons[9].setBackground(Color.red);
        buttons[9].setForeground(Color.cyan);

        panels[3] = new Panel(new GridLayout(1,2,2,2));
        panels[3].add(status);
        panels[3].add(buttons[9]);
        mainFrame.add(panels[3]);

    }
}
