package com.grafik;

import com.grafikblank.BlankPlotChart;
import com.grafikblank.BlankPlotChartRender;
import com.grafikblank.SeriesSize;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;
import org.jfree.data.category.DefaultCategoryDataset;

public class Chart extends javax.swing.JPanel {
    //private BlankPlotChart blankPlotChart;
    private List<ModelLegend> legends = new ArrayList<>();
    private List<ModelChart> model = new ArrayList<>();
    private final int seriesSize = 12;
    private final int seriesSpace = 6;
    private final Animator animator;
    private float animate;

    public Chart() {
        initComponents();
        TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                animate = fraction;
                repaint();
            }
        };
        animator = new Animator(800, target);
        animator.setResolution(0);
        animator.setAcceleration(0.5f);
        animator.setDeceleration(0.5f);
        blankPlotChart.setBlankPlotChatRender(new BlankPlotChartRender() {
            @Override
            public String getLabelText(int index) {
                return model.get(index).getLabel();
            }

            @Override
public void renderSeries(BlankPlotChart chart, Graphics2D g2, SeriesSize size, int index) {
    double totalSeriesWidth = (seriesSize * legends.size()) + (seriesSize * (legends.size() - 1));
    double x = (size.getWidth() - totalSeriesWidth) / 2 - 10; // shift chart towards the left

    for (int i = 0; i < legends.size(); i++) {
        ModelLegend legend = legends.get(i);
        g2.setColor(legend.getColor());

        int seriesWidth = 55; 
        int seriesSpace = 150; 

        double seriesValues = chart.getSeriesValuesOf(model.get(index).getValues()[i], size.getHeight()) * animate;
        g2.fillRect((int) (size.getX() + x), (int) (size.getY() + size.getHeight() - seriesValues), seriesWidth, (int) seriesValues);
        x += seriesSpace + seriesSize;
    }
}
        });
    }

    public void addLegend(String name, Color color) {
        ModelLegend data = new ModelLegend(name, color);
        legends.add(data);
        panelLegend.add(new LegendItem(data));
        panelLegend.repaint();
        panelLegend.revalidate();
    }

    public void addData(ModelChart data) {
        model.add(data);
        blankPlotChart.setLabelCount(model.size());
        double max = data.getMaxValues();
        if (max > blankPlotChart.getMaxValues()) {
            blankPlotChart.setMaxValues(max);
        }
    }

    public void clear() {
        animate = 0;
        blankPlotChart.setLabelCount(0);
        model.clear();
        repaint();
    }

    public void start() {
        if (!animator.isRunning()) {
            animator.start();
        }
    }
public void setData(String[] seriesKeys, DefaultCategoryDataset dataset) {
    clear();
    for (int i = 0; i < seriesKeys.length; i++) {
        String seriesKey = seriesKeys[i];
        double[] seriesValues = new double[dataset.getRowCount()];
        for (int j = 0; j < dataset.getRowCount(); j++) {
            String category = (String) dataset.getColumnKey(j);
            Number value = dataset.getValue(seriesKey, category);
            if (value != null) {
                seriesValues[j] = value.doubleValue();
            }
        }
        Color seriesColor;
        switch (seriesKey) {
            case "transaksi":
                seriesColor = new Color(245, 189, 135); // Orange
                break;
            case "belanja":
                seriesColor = new Color(135, 189, 245); // Blue
                break;
            case "keuntungan":
                seriesColor = new Color(189, 135, 245); // Purple
                break;
            default:
                seriesColor = Color.BLACK; // Default color
                break;
        }
        addData(new ModelChart(seriesKey, seriesValues));
    }
    start(); // Start animation
}


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelLegend = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));

        panelLegend.setOpaque(false);
        panelLegend.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelLegend, javax.swing.GroupLayout.DEFAULT_SIZE, 573, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(348, Short.MAX_VALUE)
                .addComponent(panelLegend, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel panelLegend;
    // End of variables declaration//GEN-END:variables
}
