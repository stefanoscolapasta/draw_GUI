package content;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.LayoutManager;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.border.TitledBorder;

public class PanelSettings extends JPanel {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private static final int MIN_PEN_SIZE = 1;
    private static final int MAX_PEN_SIZE = 30;
    private static final int STARTING_PEN_SIZE = 15;
    private static final int SMALL_V_GAP = 5;
    private static final int MEDIUM_V_GAP = 10;
    private static final int LARGE_V_GAP = 25;
    private final JSlider penSize;
    private final JButton bDelete;
    private final JButton bSelectColor;
    private JLabel penSizeText;
    private final GuiHandler gui;

    public PanelSettings(final LayoutManager lm, final GuiHandler gui) {
        super(lm);
        this.gui = gui;
        this.penSize = new JSlider(JSlider.HORIZONTAL, MIN_PEN_SIZE, MAX_PEN_SIZE, STARTING_PEN_SIZE);
        this.bSelectColor = new ButtonSelectColor("Select Color", this.gui);
        this.bDelete = new ButtonDeleteEverything("Erase everything", this.gui);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBackground(Color.WHITE);
        this.setBorder(new TitledBorder("Change settings here"));
        this.setPenSizeJSlider();
        this.buildSettingsPanel();
    }

    private void buildSettingsPanel() {
        this.addVerticalSpacing(this, LARGE_V_GAP);
        this.add(this.penSizeText);
        this.addVerticalSpacing(this, MEDIUM_V_GAP);
        this.add(this.penSize);
        this.addVerticalSpacing(this, SMALL_V_GAP);
        this.add(this.bSelectColor, BorderLayout.EAST);
        this.addVerticalSpacing(this, MEDIUM_V_GAP);
        this.add(this.bDelete);
    }

    private void addVerticalSpacing(final JPanel target, final int ySpacing) {
        target.add(Box.createVerticalStrut(ySpacing));
    }

    private void setPenSizeJSlider() {
        this.penSize.setPaintTicks(true);
        this.penSizeText = new JLabel("Select pen size");
        this.penSize.setMajorTickSpacing(2);
    }
    /**
     *@return this.penSize.getValue();
     * 
     */
    public int getPenSizeValueFromJSlider() {
        return this.penSize.getValue();
    }

}
