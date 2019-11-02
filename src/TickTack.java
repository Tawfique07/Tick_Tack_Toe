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
        mainFrame.setLayout(new GridLayout(4,1));
        mainFrame.setVisible(true);
        mainFrame.addWindowListener(new WindowEventListener());

        status = new Label();
        ButtonClickListener buttonClickListener = new ButtonClickListener(buttons,status);
        status.setText("Put "+buttonClickListener.getPresent()+" in the blank !");

        status.setFocusable(true);
        status.setAlignment(1);
        status.setSize(new Dimension());

//        Font font = new Font();

        for(int j=0; j<3; j++){
            panels[j] = new Panel(new GridLayout(1,3));
            panels[j].setVisible(true);
            for(int i=3*j; i<(j*3)+3; i++){
                buttons[i] = new Button(" ");
                buttons[i].setActionCommand(Integer.toString(i));
                buttons[i].addActionListener(buttonClickListener);
//                buttons[i].setBackground(new Color());
                panels[j].add(buttons[i]);
            }
            mainFrame.add(panels[j]);
        }
        buttons[9]= new Button("Reset");
        buttons[9].setActionCommand("9");
        buttons[9].addActionListener(buttonClickListener);

        panels[3] = new Panel(new GridLayout(1,2));
        panels[3].add(status);
        panels[3].add(buttons[9]);
        mainFrame.add(panels[3]);

    }
}
