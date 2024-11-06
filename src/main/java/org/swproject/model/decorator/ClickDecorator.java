package org.swproject.model.decorator;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Stroke;
import org.swproject.model.CanvasObjectInterface;

public class ClickDecorator implements CanvasObjectInterface {

    private final CanvasObjectInterface canvasObject;
    private final Stroke stroke; // 선 스타일 설정
    private Rectangle resizeHandler = new Rectangle();
    private int handleSize = 10;

    public ClickDecorator(CanvasObjectInterface canvasObject) {
        this.canvasObject = canvasObject;
        this.stroke = new BasicStroke(3.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
        createResizeHandles();
    }

    private void createResizeHandles() {
        // 모서리에 작은 사각형 핸들러 생성
        if (canvasObject.getWidth() != 0) {
            resizeHandler = new Rectangle(canvasObject.getX() + canvasObject.getWidth() - handleSize / 2,
                    canvasObject.getY() + canvasObject.getHeight() - handleSize / 2, handleSize, handleSize); // 우하단
        }
    }

    @Override
    public void resize(int x, int y, int width, int height) {
        canvasObject.resize(x, y, width, height);
        createResizeHandles();
    }

    @Override
    public void draw(Graphics2D g) {
        g.setStroke(stroke);
        canvasObject.draw(g);
        g.setColor(Color.BLUE);
        g.fill(resizeHandler);
    }

    @Override
    public void setColor(Color color) {
        canvasObject.setColor(color);
    }

    @Override
    public void move(int dx, int dy) {
        canvasObject.move(dx, dy);
        createResizeHandles();
    }

    @Override
    public boolean isPointerInside(Point point) {
        return canvasObject.isPointerInside(point);
    }

    @Override
    public boolean isResizable(Point point) {
        return canvasObject.isResizable(point);
    }

    @Override
    public int getId() {
        return canvasObject.getId();
    }

    @Override
    public int getX() {
        return canvasObject.getX();
    }

    @Override
    public int getY() {
        return canvasObject.getY();
    }

    @Override
    public int getWidth() {
        return canvasObject.getWidth();
    }

    @Override
    public int getHeight() {
        return canvasObject.getHeight();
    }

}
