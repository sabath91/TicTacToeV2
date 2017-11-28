package org.czyz.game.round;

import org.czyz.game.Height;
import org.czyz.game.Width;
import org.czyz.game.WinningSequenceLength;

final class Triplet {
    private final Height height;
    private final Width width;
    private final WinningSequenceLength length;

    Triplet(final int heightValue, final int widthValue, final int lengthValue) {
        this.height = new Height(heightValue);
        this.width = new Width(widthValue);
        this.length = new WinningSequenceLength(lengthValue);
    }

    /**
     * It is helpful when reviewing results of failed tests.
     *
     * @return heightValue, widthValue and winningCountValue
     */
    @Override
    public String toString() {
        return "height=" + height + ", width=" + width + ", winningLength=" + length;
    }

    public int height() {
        return height.getValue();
    }

    public int width() {
        return width.getValue();
    }

    public int length() {
        return length.value();
    }


    public Height getHeight() {
        return height;
    }

    public Width getWidth() {
        return width;
    }

    public WinningSequenceLength getLength() {
        return length;
    }
}
