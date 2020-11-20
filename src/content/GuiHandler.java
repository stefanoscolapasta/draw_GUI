package content;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import panel.DrawPanel;

public class GuiHandler extends MouseAdapter {
    static final Color DEFAULT_BUTTON_COLOR = Color.LIGHT_GRAY;
    static final Color DEFAULT_PANEL_COLOR = Color.WHITE;
    private final DrawPanel pcenterPanel;
    private final MyFrame frame;
    private final PanelSettings pEast;
    private final JPanel pDrawPanelContainer;
    private final JPanel pMain;
    private Color currentColor = Color.BLACK;
    private final MyMouseListener myListener;

    // Should implement a settings class!!!
    public GuiHandler() {
        this.frame = new MyFrame("Canvas Example");
        this.frame.setResizable(true);
        this.pMain = new JPanel(new BorderLayout());

        this.pDrawPanelContainer = new JPanel(new BorderLayout());
        this.pDrawPanelContainer.setBackground(DEFAULT_PANEL_COLOR);
        this.pDrawPanelContainer.setBorder(new TitledBorder("Draw something here"));
        this.pcenterPanel = new DrawPanel();
        this.pDrawPanelContainer.add(this.pcenterPanel, BorderLayout.CENTER);

        this.pEast = new PanelSettings(new GridBagLayout(), this);

        this.myListener = new MyMouseListener(this);

        this.setCenterPanelListeners();
        this.setFrameView();
    }

    private void setFrameView() {
        this.pMain.add(this.pDrawPanelContainer, BorderLayout.CENTER);
        this.pMain.add(this.pEast, BorderLayout.EAST);
        this.frame.add(this.pMain);
    }

    private void setCenterPanelListeners() {
        this.getpCenterPanel().addMouseListener(this.myListener);
        this.getpCenterPanel().addMouseMotionListener(this.myListener);
//        this.pEast.addMouseListener(this.myListener);
//        this.pEast.addMouseMotionListener(this.myListener);
    }

    /**
     * @return this.pcenterPanel
     */
    public DrawPanel getpCenterPanel() {
        return this.pcenterPanel;
    }

    /**
     * @param c
     */
    public void changeCurrentColor(final Color c) {
        this.currentColor = c;
    }

    /**
     * @return this.currentColor;
     */
    public Color getCurrentColor() {
        return this.currentColor;
    }

    /**
     * @return this.penSize.getValue();
     */
    public int getPenSize() {
        return this.pEast.getPenSizeValueFromJSlider();
    }

    /**
     * this method shows the frame and sets the frame visible.
     */
    public void show() {
        this.frame.setVisible(true);
    }

}
