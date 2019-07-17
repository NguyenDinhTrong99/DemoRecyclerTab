package com.trongdeptrai.demorecyclertab.Interface;

public interface ItemTouchListener {
    // hàm xử lý di chuyển
    void onMove(int oldPosition, int newPosition);
    // hàm sử lý kéo item
    void onSwipe(int position, int direction);
}
