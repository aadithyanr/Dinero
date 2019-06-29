package com.trinet.dinero.Supports.Utils.ExpandableLayout;

/**
 * Created by Aadithyan Rajeshon 05/09/2017.
 */

public interface ExpandableLayoutListener {

    void onAnimationStart();

    void onAnimationEnd();

    void onPreOpen();

    void onPreClose();

    void onOpened();

    void onClosed();
}