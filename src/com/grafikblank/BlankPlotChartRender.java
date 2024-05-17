package com.grafikblank;

import java.awt.Graphics2D;

public abstract class BlankPlotChartRender {

    public abstract String getLabelText(int index);

    public abstract void renderSeries(BlankPlotChart chart, Graphics2D g2, SeriesSize size, int index);
}
