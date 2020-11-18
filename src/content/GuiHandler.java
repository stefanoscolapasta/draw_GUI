package content;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import panel.DrawPanel;

public class GuiHandler extends MouseAdapter {
    private static final int MIN_PEN_SIZE = 1;
    private static final int SMALL_V_GAP = 5;
    private static final int MEDIUM_V_GAP = 10;
    private static final int LARGE_V_GAP = 25;
    private static final int MAX_PEN_SIZE = 30;
    private static final int STARTING_PEN_SIZE = 15;
    static final Color DEFAULT_BUTTON_COLOR = Color.LIGHT_GRAY;
    private final DrawPanel pcenterPanel;
    private final JSlider penSize;
    private JLabel penSizeText;
    private final MyFrame frame;
    private final JPanel pEast;
    private final JPanel pMain;
    private final JButton bDelete;
    private final JButton bSelectColor;
    private Color currentColor = Color.BLACK;
    private final MyMouseListener myListener;

    //Should implement a settings class!!!
    public GuiHandler() {
        this.frame = new MyFrame("Canvas Example", new BorderLayout());
        this.frame.setResizable(true);
        this.pMain = new JPanel(new BorderLayout());
        this.penSize = new JSlider(JSlider.HORIZONTAL, MIN_PEN_SIZE, MAX_PEN_SIZE, STARTING_PEN_SIZE);
        this.pcenterPanel = new DrawPanel();
        this.pcenterPanel.setBackground(Color.WHITE);
        this.pcenterPanel.setBorder(new LineBorder(Color.BLACK));
        this.pEast = new JPanel(new GridBagLayout());
        this.myListener = new MyMouseListener(this);
        this.bSelectColor = new ButtonSelectColor("Select Color", this);
        this.bDelete = new ButtonDeleteEverything("Erase everything", this);
        this.pEast.setLayout(new BoxLayout(this.pEast, BoxLayout.Y_AXIS));
        this.pEast.setBackground(Color.WHITE);
        this.pEast.setBorder(new TitledBorder("Change settings here"));
        this.setPenSizeJSlider();
        this.setCenterPanelListeners();
        this.buildSettingsPanel();
        this.setFrameView();
    }

    private void buildSettingsPanel() {
        this.addVerticalSpacing(this.pEast, LARGE_V_GAP);
        this.pEast.add(this.penSizeText);
        this.addVerticalSpacing(this.pEast, MEDIUM_V_GAP);
        this.pEast.add(this.penSize);
        this.addVerticalSpacing(this.pEast, SMALL_V_GAP);
        this.pEast.add(this.bSelectColor, BorderLayout.EAST);
        this.addVerticalSpacing(this.pEast, MEDIUM_V_GAP);
        this.pEast.add(this.bDelete);
    }

    private void addVerticalSpacing(final JPanel target, final int ySpacing) {
        target.add(Box.createVerticalStrut(ySpacing));
    }

    private void setFrameView() {
        this.pMain.add(this.pcenterPanel, BorderLayout.CENTER);
        this.pMain.add(this.pEast, BorderLayout.LINE_END);
        this.frame.getMainPanel().add(pMain);
    }

    private void setCenterPanelListeners() {
        this.getpCenterPanel().addMouseListener(this.myListener);
        this.getpCenterPanel().addMouseMotionListener(this.myListener);
    }

    private void setPenSizeJSlider() {
        this.penSize.setPaintTicks(true);
        this.penSizeText = new JLabel("Select pen size");
        this.penSize.setMajorTickSpacing(2);
    }
    /**
     * @return this.pcenterPanel 
     * */
    public DrawPanel getpCenterPanel() {
        return this.pcenterPanel;
    }
    /**
     * @param c
     * */
    public void changeCurrentColor(final Color c) {
        this.currentColor = c;
    }
    /**
     * @return this.currentColor;
     * */
    public Color getCurrentColor() {
        return this.currentColor;
    }
    /**
     * @return this.penSize.getValue();
     * */
    public int getPenSize() {
        return this.penSize.getValue();
    }
    /**
     * this method shows the frame and sets the frame visible.
     * */
    public void show() {
        this.frame.setVisible(true);
    }

}
